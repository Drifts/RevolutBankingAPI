package com.apiservicetester;

import com.sun.jersey.api.client.Client;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.ClientResponse;

import com.sun.jersey.api.client.WebResource;

/**
 * @author David Used to test the service of the API
 */

public class APIServiceTester {

	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/RevolutBankingAPI/webapi/bankaccount";
	public String passed = " TEST PASSED";

	private void initialiser() {
		this.client = Client.create();
	}

	public static void main(String[] args) {
		APIServiceTester apiTester = new APIServiceTester();

		// Initialise tester
		apiTester.initialiser();
		// test get all bank accounts available
		apiTester.testGetBankAccounts();
		// test getting one bank account using id 1
		apiTester.testBankAccount();
		// test adding a new bank account
		apiTester.testAddBankAccount();
		// test updating a bank account using id 3
		apiTester.testUpdateBankAccount();	
		// test delete a bank account using id 1
		apiTester.testDeleteBankAccount();
	}
	
	private void testGetBankAccounts() {
		
		try {
			WebResource webResource = client.resource(REST_SERVICE_URL);
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);

			// Check response status code
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
				}

			//Display response
			System.out.println("Output from Server. Test: testGetBankAccounts");
			System.out.println("Status Code: " + response.getStatus() + passed);
			String output = (String) response.getEntity(String.class);
			System.out.println(output + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testBankAccount() {
		
		try {
			WebResource webResource = client.resource(REST_SERVICE_URL).path("/1");
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);

			// Check response status code
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
				}

			//Display response
			System.out.println("Output from Server. Test: testBankAccount");
			System.out.println("Status Code: " + response.getStatus() + passed);
			String output = (String) response.getEntity(String.class);
			System.out.println(output + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	 private void testAddBankAccount() {
		 try {
				WebResource webResource = client.resource(REST_SERVICE_URL);
				
				String input = "{\"accountNumber\":\"12345681\",\"name\":\"Frozen Elsa\",\"sortCode\":\"111111\"}";
				ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.post(ClientResponse.class, input);

				// Check response status code
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
					}

				//Display response
				System.out.println("Output from Server. Test: testAddBankAccount");
				System.out.println("Status Code: " + response.getStatus() + passed);
				String output = (String) response.getEntity(String.class);
				System.out.println(output + "\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 private void testUpdateBankAccount() {

			try {
				WebResource webResource = client.resource(REST_SERVICE_URL).path("3");
				String input = "{\"accountNumber\":\"12345680\",\"name\":\"Jane Burger\",\"sortCode\":\"111111\"}";

				ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.put(ClientResponse.class, input);

				// Check response status code
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
					}

				//Display response
				System.out.println("Output from Server. Test: testUpdateBankAccount");
				System.out.println("Status Code: " + response.getStatus() + passed);
				String output = (String) response.getEntity(String.class);
				System.out.println(output + "\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	 private void testDeleteBankAccount() {
	
	 try {
			WebResource webResource = client.resource(REST_SERVICE_URL).path("3");
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
					.delete(ClientResponse.class);

			// Check response status code
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
				}

			//Display response
			System.out.println("Output from Server. Test: testDeleteBankAccount");
			System.out.println("Status Code: " + response.getStatus() + passed);
			String output = (String) response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}