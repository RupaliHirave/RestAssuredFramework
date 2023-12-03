package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DemoCookie {
	//@Test
	void cookieDemo() {
		given()
		.when().get("https://www.google.com/")
		.then()
		.cookie("AEC","Ackid1SiwsCGJwzDI4ieXnpOYPnyV-TIq6FfBqHqgC4w3-sIK1_QYuGQ4-I")
		.log().all();
		}
	
	@Test
	void getCookieInfo() {
		Response res=
				given()
				.when().get("https://www.google.com/");
		
		//get single cookie value
		String cookieValue=res.getCookie("AEC");
		System.out.println("Value of cookie===>"+ cookieValue);
			
		//get all cookie info
		Map<String, String> cookies_values=res.getCookies();
		
		System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet()) {
			String cookie=res.getCookie(k);
			System.out.println(cookie);
			
		}
	}
	

}
