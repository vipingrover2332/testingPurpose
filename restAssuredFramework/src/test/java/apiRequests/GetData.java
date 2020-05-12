package apiRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetData {
	
	/*
	 * npm install -g json-server 
	 * json-server --watch db.json
	 * 
	 * Resources http://localhost:3000/posts http://localhost:3000/comments
	 * http://localhost:3000/profile
	 */	

	
	@Test
	public void sequence() {
		int actualCode = get("http://dummy.restapiexample.com/api/v1/employees").getStatusCode();
		System.out.println("ActualCode "+actualCode);
		Assert.assertEquals(actualCode , 200);
	}

	@Test
	public void givenGetData() {
		given().
				get("http://dummy.restapiexample.com/api/v1/employees").
		then().
				statusCode(200);
	}
	
	//@Test
	public void testResponseCode() {
		Response resp = get("https://samples.openweathermap.org/data/2.5/weather"
				+ "?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int actualCode = resp.getStatusCode();
		System.out.println("ActualCode "+actualCode);
		Assert.assertEquals(actualCode , 200);
	}
	
	//@Test
	public void testData() {
		Response resp = get("https://samples.openweathermap.org/data/2.5/weather"
				+ "?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		System.out.println("Response is "+resp);
		String data = resp.asString();
		System.out.println("Data is "+data);
	}
	
	//@Test
	public void anotherWayWritingCode() {
		int actualCode = get("https://samples.openweathermap.org/data/2.5/weather"
				+ "?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		System.out.println("ActualCode "+actualCode);
		Assert.assertEquals(actualCode , 200);
	}
	
}
