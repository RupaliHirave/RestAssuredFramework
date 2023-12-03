package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class HeadersDemo {
	
	//@Test
	void getHeaderInfo() {
		
		given()
		.when().get("https://www.google.com/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip");
		
	}
	@Test
	void testgetHeaders() {
		Response res=given()
		.when().get("https://www.google.com/");
		
		//get single header info
		//String header=res.getHeader("Content-type");
		//System.out.println("The value of content type header is==>"+header);
		
		
		//to get all  headers info
		Headers myheaders=res.getHeaders();
		for(Header hd:myheaders) {
			 System.out.println(hd.getName() +" "+hd.getValue());
			
		}
		
	}

}
