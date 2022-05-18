package org.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ApiChaining extends BaseClass {
	String logtoken;
	int address_id;
	@Test
	public void login() throws IOException {
		System.out.println("LOGIN STATUS*****************************");
		getHeater("Content-Type", "application/json");
		basicAuthentication(getPropertyValue("username"), getPropertyValue("password"));
		Response response = methodeType("POST", EndPoints.LOGIN);
		getStatusCode(response);
		Login_Output_Pojo login_Output_Pojo =response.as(Login_Output_Pojo.class);
		logtoken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);
		System.out.println(login_Output_Pojo.getMessage());
		Assert.assertEquals(login_Output_Pojo.getMessage(), "Login successfully","Verify Login successfully");
	}
	@Test(priority=1)
	public void addAddress() {
		System.out.println("ADDADDRESS STATUS *******************************");
		List<Header> headers = new ArrayList<Header>();
		Header header = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer "+logtoken);
		headers.add(header);
		headers.add(header2);
		Headers headers2 = new Headers(headers);
		getHeaders(headers2);
		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo("Bala", "I", "8754248226", "White Building", 1, 31, 91, "607106", "Custom colony", "home");
		body(addAddress_Input_Pojo);
		Response response = methodeType("POST", EndPoints.ADD_ADDRESS);
		getStatusCode(response);
		AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		address_id = addAddress_Output_Pojo.getAddress_id();
		System.out.println(address_id);
		System.out.println(addAddress_Output_Pojo.getMessage());
		Assert.assertEquals( addAddress_Output_Pojo.getMessage(),"Address added successfully","Verify address added");

	}
	@Test(priority=2)
	public void updateAddress() {
		System.out.println("UPDATEADDRESS STATUS***********************************");
		List<Header> headers = new ArrayList<Header>();
		Header header = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer "+logtoken);
		headers.add(header);
		headers.add(header2);
		Headers headers2 = new Headers(headers);
		getHeaders(headers2);
		UpdateAddress_Input_Pojo input_Pojo =new UpdateAddress_Input_Pojo(String.valueOf(address_id), "Raji", "B", "8124590560", "Ranga Building", "Tamil Nadu", "Panruti", "India", "607106", "selam Main Road", "Home");
		body(input_Pojo);
		Response response = methodeType("PUT", EndPoints.UPDATE_ADDRESS);
		getStatusCode(response);
		getPretyString(response);
		UpdateAddress_Output_Pojo updateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		String message = updateAddress_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully","Verify address updated");

	}
	@Test(priority=4)
	public void getAddress() {
		System.out.println("GETADDRESS STATUS*************************************");
		List<Header> headers = new ArrayList<Header>();
		Header header = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer "+logtoken);
		headers.add(header);
		headers.add(header2);
		Headers headers2 = new Headers(headers);
		getHeaders(headers2);
		Response response = methodeType("GET", EndPoints.GET_ADDRESS);
		getStatusCode(response);
		getPretyString(response);
		GetAddress_Output_Pojo getAddress_Output_Pojo = response.as(GetAddress_Output_Pojo.class);
		System.out.println(getAddress_Output_Pojo.getMessage());
		Assert.assertEquals(getAddress_Output_Pojo.getMessage(), "OK","Verify the Conditions");		

	}
	@Test(priority=5)
	public void deleteAddress() {
		System.out.println("DELETEADDRESS STATUS****************************");
		List<Header> headers = new ArrayList<Header>();
		Header header = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer "+logtoken);
		headers.add(header);
		headers.add(header2);
		Headers headers2 = new Headers(headers);
		getHeaders(headers2);
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(String.valueOf(address_id));
		body(deleteAddress_Input_Pojo);
		Response response = methodeType("DELETE",EndPoints.DELETE_ADDRESS);
		getStatusCode(response);
		getPretyString(response);
		UpdateAddress_Output_Pojo updateAddress_Output_Pojo =response.as(UpdateAddress_Output_Pojo.class);
		System.out.println(updateAddress_Output_Pojo.getMessage());
		Assert.assertEquals(updateAddress_Output_Pojo.getMessage(), "Address deleted successfully","Verify Address deleted");


	}
	@Test(priority=6)
	public void logout() {
		System.out.println("LOGOUT STATUS********************************");
		List<Header> headers = new ArrayList<Header>();
		Header header = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer "+logtoken);
		headers.add(header);
		headers.add(header2);
		Headers headers2 = new Headers(headers);
		getHeaders(headers2);
		Response response = methodeType("POST", EndPoints.LOGOUT);
		getStatusCode(response);
		Logout_Output_Pojo logout_Output_Pojo =response.as(Logout_Output_Pojo.class);
		System.out.println(logout_Output_Pojo.getMessage());
		Assert.assertEquals(logout_Output_Pojo.getMessage(), "You have logged out","Verify logout");
	}


}
