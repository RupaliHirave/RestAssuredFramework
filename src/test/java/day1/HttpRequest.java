package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*
 * given()-pre-requisite 
 * when()  get post put 
 * then()validation of status code
 */

public class HttpRequest {
  int id;
	@Test(enabled=false)
	public void getusers() {
		// get request--https://reqres.in/api/users?page=2
		

		// delete request--https://reqres.in/api/users/2

		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log()
				.all();
	}

	@Test(priority=2)
	void createUser() {
		        // post request--https://reqres.in/api/users
				// {
				// "name": "morpheus",
				// "job": "leader"
				// }
		HashMap data=new HashMap();
		data.put("name", "rupali");
		data.put("Job", "engineer");
		
		id=given()
		.contentType("application/json")
		.body(data)
		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		
		//.then().statusCode(201).log().all();
	}
	
	@Test(dependsOnMethods = {"createUser"},priority=3)
	void updateUser() {
		HashMap data=new HashMap();
		data.put("name", "rupali");
		data.put("Job", "Test engineer");
		
		given()
		.contentType("application/json")
		.body(data)
		.when().put("https://reqres.in/api/users/"+id)
		.then().statusCode(200).log().all();	
	}
	
	@Test(priority=4)
	void deleteUser() {
		given()
		.when().delete("https://reqres.in/api/users/\"+id")
		.then().statusCode(204).log().all();
	}
}
