package org.stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.base.AddCartItem_Input_pojo;
import org.base.BaseClass;
import org.base.DeleteCartItem_Input_pojo;
import org.base.EndPoints;
import org.base.Login_Output_Pojo;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class StepDefinition extends BaseClass {
	static Response response ;
	static String logtoken;
	String item;


	@When("user should add header {string} and {string}")
	public void user_should_add_header_and(String key, String value) {
		getHeater(key, value);




	}

	@When("user should add request body for login")
	public void user_should_add_request_body_for_login() throws IOException {
		basicAuthentication(getPropertyValue("username"), getPropertyValue("password"));




	}

	@When("user should send post request for login")
	public void user_should_send_post_request_for_login() {
		response = methodeType("POST", EndPoints.LOGIN);
		getStatusCode(response);
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		logtoken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);
		System.out.println(login_Output_Pojo.getMessage());
	}

	@Then("user should verify statusCode for  matched with {int}")
	public void user_should_verify_statusCode_for_matched_with(Integer expected) {
		Assert.assertEquals(response.getStatusCode(),expected );
	}

	@Then("user should verify response body for login {string}")
	public void user_should_verify_response_body_for_login(String expected) {
		Assert.assertEquals(response.getBody().jsonPath().get("message"), expected);
	}

	@When("user should add header {string} and {string} and add bearer authentication to authorize endpoint")
	public void user_should_add_header_and_and_add_bearer_authentication_to_authorize_endpoint(String key, String value) {
		List<Header> headers = new ArrayList<Header>();
		Header header = new Header(key, value);
		Header header2 = new Header("Authorization", "Bearer " +logtoken);
		headers.add(header);
		headers.add(header2);

		Headers headers2 = new Headers(headers);
		getHeaders(headers2);



	}

	@When("user should add request body for addcardItems")
	public void user_should_add_request_body_for_addcardItems() throws JsonProcessingException {
		AddCartItem_Input_pojo addCartItem_Input_pojo = new AddCartItem_Input_pojo("1", "1", "4");
		ObjectMapper mapper =  new ObjectMapper();
		String body = mapper.writeValueAsString(addCartItem_Input_pojo);
		body(body);
	}

	@When("user should send post request for addcardItems")
	public void user_should_send_post_request_for_addcardItems() {
		response = methodeType("POST", EndPoints.ADD_CARDITEMS);
		getStatusCode(response);
		String productCode = response.getBody().jsonPath().get("product_code");
		System.out.println(productCode);



	}

	@Then("user should verify response body for addcarditem {string}")
	public void user_should_verify_response_body_for_addcarditem(String expected) {
		String actual = response.getBody().jsonPath().get("message");
		System.out.println(actual);
		Assert.assertEquals(actual, expected);


	}

	@When("user should send get request for getcarditem")
	public void user_should_send_get_request_for_getcarditem() {
		response = methodeType("GET", EndPoints.GET_CARDITEM);
		getStatusCode(response);
		String itemId = response.getBody().jsonPath().get("data.id").toString();
		 item = itemId.toString();
		System.out.println(item);

	}

	@Then("user should verify response body for getcartitem {string}")
	public void user_should_verify_response_body_for_getcartitem(String expected) {
		String actual = response.getBody().jsonPath().get("message");
		System.out.println(actual);
		Assert.assertEquals(actual, expected);



	}
	@When("user should add request body for deletecarditem")
	public void user_should_add_request_body_for_deletecarditem() throws JsonProcessingException {
		DeleteCartItem_Input_pojo cartItem_Input_pojo = new DeleteCartItem_Input_pojo(item);
		ObjectMapper mapper = new ObjectMapper();
		String reqBody = mapper.writeValueAsString(cartItem_Input_pojo);
		body(reqBody);

	
	
	}

	@When("user should delete request for deletecartitem")
	public void user_should_delete_request_for_deletecartitem() {
		 response = methodeType("DELETE", EndPoints.DELETE_CARDITEMS);
		 getStatusCode(response);
		
	
	}
	@Then("user should verify response body for delete {string}")
	public void user_should_verify_response_body_for_delete(String expected) {
		 String actual = response.getBody().jsonPath().get("message");
		 System.out.println(actual);
		 Assert.assertEquals(actual, expected);

		
	}@When("user should send get request for clearcart")
	public void user_should_send_get_request_for_clearcart() {
		response = methodeType("GET", EndPoints.CLEAR_CARDITEMS);
		getStatusCode(response);
		




	}	@Then("user should verify response body for clearcart {string}")
	public void user_should_verify_response_body_for_clearcart(String expected) {
		String actual = response.getBody().jsonPath().get("message");
		Assert.assertEquals(actual, expected);
		
		
		
		
	}




}
