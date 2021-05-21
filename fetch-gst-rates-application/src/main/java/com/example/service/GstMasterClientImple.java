package com.example.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.ServiceUnavailableException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.example.model.GstModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class GstMasterClientImple implements GstMasterClient {

	@Override
	public List<GstModel> getAllGst() throws ClientProtocolException, IOException, ServiceUnavailableException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpEntity entity = null;
		String result = null;
		try {

			HttpGet request = new HttpGet("https://www.mastergst.com/gst-tools/commoncodes.json");

			CloseableHttpResponse response = httpClient.execute(request);

			try {

				// Get HttpResponse Status
				System.out.println(response.getProtocolVersion()); // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode()); // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

				entity = response.getEntity();
				if (entity != null) {
					// return it as a String
					result = EntityUtils.toString(entity);
//					
//					System.out.println(result);
				} else {
					throw new ServiceUnavailableException("ServiceNotAvailable");
				}

			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}
		ObjectMapper mapper = new ObjectMapper();
		CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, GstModel.class);
		List<GstModel> models = new ObjectMapper().readValue(result, listType);
		return models;
	}

	@Override
	public List<GstModel> asyncHttpClient() throws InterruptedException, ExecutionException, IOException {
		
		/**
		 * need to use this dependency 
		 * https://mvnrepository.com/artifact/org.apache.httpcomponents/httpasyncclient/4.1.4
		 * 
		 * https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html
		 * 
		 * https://mkyong.com/java/apache-httpclient-examples/
		 * 
		 * https://howtodoinjava.com/java/library/jaxrs-client-httpclient-get-post/
		 */
		CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
		client.start();

		HttpGet request = new HttpGet("https://www.mastergst.com/gst-tools/commoncodes.json");

		Future<HttpResponse> future = client.execute(request, null);
		HttpResponse response = future.get();

		client.close();
		HttpEntity entity = response.getEntity();
		String jsonString = EntityUtils.toString(entity);
		ObjectMapper mapper = new ObjectMapper();
		CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, GstModel.class);
		List<GstModel> models = new ObjectMapper().readValue(jsonString, listType);
		return models;

	}
}
