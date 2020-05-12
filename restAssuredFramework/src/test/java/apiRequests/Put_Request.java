package apiRequests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_Request {

	@Test
	public void putData() {
		
		//Start to build the request
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		//Data in JsonFormat
		JSONObject json= new JSONObject();
		json.put("id","22");
		json.put("title","Testing");
		json.put("author","Automation(UI&&API)");
		request.body(json.toJSONString());
		
		Response resp = request.put("http://localhost:3000/posts/22");
		int actualCode = resp.getStatusCode();
		Assert.assertEquals(actualCode, 200);
		
	}
	
}
