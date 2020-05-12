package apiRequests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Request {

	@Test
	public void postData() {
		
		//Start to build the request
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		Response resp = request.delete("http://localhost:3000/posts/22");
		int actualCode = resp.getStatusCode();
		Assert.assertEquals(actualCode, 200);
		
	}
	
}
