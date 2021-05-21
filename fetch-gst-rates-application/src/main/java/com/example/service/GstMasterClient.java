package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.naming.ServiceUnavailableException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.example.model.GstModel;

@Service
public interface GstMasterClient {
	
	List<GstModel> getAllGst() throws ClientProtocolException, IOException, ServiceUnavailableException;

	List<GstModel> asyncHttpClient() throws InterruptedException, ExecutionException, IOException;

}
