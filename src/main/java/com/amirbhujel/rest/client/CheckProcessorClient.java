package com.amirbhujel.rest.client;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.amirbhujel.rest.Check;
import com.amirbhujel.rest.ChecksList;

public class CheckProcessorClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restwsasync/services/checkservice/checks");

		AsyncInvoker asyncInvoker = target.request().async();
		
		ChecksList checksList = new ChecksList();
		ArrayList<Check> checks = new ArrayList<Check>();
		checks.add(new Check());
		checksList.setChecks(checks);
		
		// CallBack Method
		Future<Boolean> future = asyncInvoker.post(Entity.entity(checksList, MediaType.APPLICATION_ATOM_XML),
				new ChecksResponseCallbackHandler());
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		// Polling Method
		/*Future<Boolean> future = asyncInvoker.post(Entity.entity(checkList, MediaType.APPLICATION_ATOM_XML),
				Boolean.class);

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			if(e.getCause() instanceof BadRequestException){
				BadRequestException be = (BadRequestException) e.getCause();
				System.out.println("Checks Should be provided !!!");
			}
			
			e.printStackTrace();
		}*/
	}
}
