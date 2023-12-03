package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParsingJsonData {
	
	//@Test
	void testJsonResponse() {
		//Approach1
		/*
		given()
		.contentType("ContentType.Json")
		.when().get("http://localhost:3000/store")
		.then()
		.statusCode(200)
		.header("Content-type", "application/json; charset=utf-8")
		.body("book[3].title",equalTo("Lord of Ring"));
		*/
		
		//approach2
		
	Response res=	given()
		.contentType("ContentType.json")
		.when().get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(),200); //validation 1
		Assert.assertEquals(res.header("Content-type"), "application/json; charset=utf-8");
		
		String bookname=res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "Lord of Ring");
	}

	@Test
	void testJsonResponseBody() {
		
		//approach2
		
	Response res=	given()
		.contentType(ContentType.JSON)
		.when().get("http://localhost:3000/store");
	/*	
		Assert.assertEquals(res.getStatusCode(),200); //validation 1
		Assert.assertEquals(res.header("Content-type"), "application/json; charset=utf-8");
		
		String bookname=res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "Lord of Ring");
		*/
	
	JSONObject jo=new JSONObject(res.asString());
	
	/*for(int i=0;i<jo.getJSONArray("book").length();i++) {
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		System.out.println(bookTitle);
		*/
	//search for title of the book
		boolean status=false;
	for(int i=0;i<jo.getJSONArray("book").length();i++) {
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		if(bookTitle.equals("Lord of Ring")) {
			status=true;
			break;
		}
		
	}
	Assert.assertEquals(status, true);
	
	double totalprice=0;
	//validate total price of book
	for(int i=0;i<jo.getJSONArray("book").length();i++) {
		String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
		totalprice=totalprice+Double.parseDouble(price);
	}
	
	System.out.println("Tota price of book is:" +totalprice);
	
	Assert.assertEquals(totalprice, 625.7);
	}

}
