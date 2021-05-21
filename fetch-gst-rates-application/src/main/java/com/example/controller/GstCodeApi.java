package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.naming.ServiceUnavailableException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GstModel;
import com.example.restclient.RestClient;
import com.example.service.GstMasterClient;

@RestController
public class GstCodeApi {
	
	@Autowired
	private RestClient client;
	
	@Autowired
	private GstMasterClient masterClient;
	
	@GetMapping("/gsts")
	public Object getRates(){
		return client.getGstRate();
	}

	
	@GetMapping("/mastergst")
	public List<GstModel> getRates1() throws ClientProtocolException, IOException, ServiceUnavailableException{
		return masterClient.getAllGst();
	}
	
	@GetMapping("/asyncgst")
	public List<GstModel> getRates2() throws ClientProtocolException, IOException, ServiceUnavailableException,
			InterruptedException, ExecutionException{
		return masterClient.asyncHttpClient();
	}
}
