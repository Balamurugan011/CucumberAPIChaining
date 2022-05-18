package org.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification requestSpe;
	Response response;
	String value;

	public void getHeater(String key,String value) {
		requestSpe=  RestAssured.given().header(key,value);

	}
	public void getHeaders(Headers headers) {
		requestSpe= RestAssured.given().headers(headers);


	}
	public void queryParam(String key,String value) {
		requestSpe = requestSpe.queryParam(key, value);
	}
	public void pathParam(String key,String value) {
		requestSpe = requestSpe.pathParam(key, value);
	}
	
	public void body(String body) {
		requestSpe= requestSpe.body(body);

	}
	public void body(Object body) {
		requestSpe= requestSpe.body(body);
	}
	public String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream("C:\\Users\\ELCOT\\eclipse-workspace\\CucumberApiChaining\\src\\test\\resources\\Config.properties");
		properties.load(stream);
		Object object = properties.get(key);
		value = (String) object;
		return value;
	}
	public void basicAuthentication(String username,String password) {
      requestSpe= requestSpe.auth().preemptive().basic(username, password);
	}
	public Response methodeType(String type,String endpoint) {
		switch (type) {
		case "GET":
			response = requestSpe.log().all().get(endpoint);
			break;
		case "POST":
			response = requestSpe.log().all().post(endpoint);
			break;
		case "PUT":
			response = requestSpe.log().all().put(endpoint);
			break;
		case "DELETE":
			response = requestSpe.log().all().delete(endpoint);
			break;


		default:
			break;

		}
		return response;

	}
	public ResponseBody getBody() {
		ResponseBody body = response.getBody();
		return body;
	}
	public int getStatusCode(Response response) {
		int statusCode = response.statusCode();
		System.out.println(statusCode);
		return statusCode;
	}

	public String getBodyAsString(Response response) {
		String asString = getBody().asString();
		System.out.println(asString);
		return asString;
	}
	public String getPretyString(Response response) {
		String asPrettyString = getBody().asPrettyString();
		System.out.println(asPrettyString);
		return asPrettyString;
	}


}