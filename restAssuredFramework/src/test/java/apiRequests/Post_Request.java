 package apiRequests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request {

	//@Test
	public void postData() {
		
		//Start to build the request
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		//Data in JsonFormat
		JSONObject json= new JSONObject();
		json.put("id","22");
		json.put("title","Testing");
		json.put("author","Automation");
		request.body(json.toJSONString());
		
		Response resp = request.post("http://localhost:3000/posts");
		int actualCode = resp.getStatusCode();
		Assert.assertEquals(actualCode, 201);
		
	}
	
	@Test
	public void postDataGiven() {
		
		RestAssured.given().
							header("Content-Type", "application/json").
							param("id","23").
							param("title","TestingGiven").
							param("author","AutomationGiven").
				    when().
							post("http://localhost:3000/posts").
				    then().
				    		statusCode(200).
				    		log().all();
	
	}
}
