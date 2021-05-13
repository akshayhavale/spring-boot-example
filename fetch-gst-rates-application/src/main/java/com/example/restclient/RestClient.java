package com.example.restclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

	private static final String url = "https://www.mastergst.com/gst-tools/commoncodes.json";

	private RestTemplate template = new RestTemplate();

	public Object getGstRate() {
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		if(interceptors.isEmpty()) {
			interceptors.add(new RestClientInterceptor());
		}
		template.setInterceptors(interceptors );
		Object forObject = template.getForObject(url, Object.class);
		return forObject;
	}

}
