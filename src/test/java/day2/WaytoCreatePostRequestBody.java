package day2;
import org.testng.annotations.Test;



import org.json.JSONObject;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*

/*
 * Different ways to create POST request body
 * 1. Post request body using hashmap
 * 2. using Org.json
 * 3. POJO class(Plain old java object)
 * 4. external json file data
 */
public class WaytoCreatePostRequestBody {
//@Test(priority=1)
	void testPostUsingHashmap() {
		
		HashMap data=new HashMap();
		data.put("name", "Dipak");
		//data.put("location", "France");
		data.put("phon", "125756");
		String coursearray[]= {"Java", "Rest"};
		data.put("cources", coursearray);
		
		given().contentType("applocation/json")
		.body(data.toString())
		
		.when().post("http://localhost:3000/Students")
		.then().statusCode(201)
		.body("name",equalTo("Dipak"))
		//.body("location",equalTo(""))
		.body("phon",equalTo("125756"))
		.body("coursearray[0]",equalTo("Java"))
		.body("coursearray[1]",equalTo("Rest"))
		.header("Content-type","application/json; charset=uft-8")
		.log().all();	
	}
	//@Test(priority=2)
	void testdelete() {
		given()
		.when().delete("http://localhost:3000/Students/2")
		.then().statusCode(201).log().all();
	}
	
	//post request body using org.json library
	//@Test
	void testPostUsingJsonBody() {
		
		JSONObject data=new JSONObject();
		
		data.put("name", "Rupali");
		//data.put("location", "Pune");
		data.put("phon", "125456");
		String coursearray[]= {"C", "C++"};
		data.put("cources", coursearray);
		
		given().contentType("applocation/json")
		.body(data.toString())
		
		.when().post("http://localhost:3000/Students")
		.then().statusCode(201)
		.body("name",equalTo("Scott"))
		//.body("location",equalTo("France"))
		.body("phon",equalTo("123456"))
		.body("coursearray[0]",equalTo("C"))
		.body("coursearray[1]",equalTo("C++"))
		.header("Content-type","application/json; charset=uft-8")
		.log().all();	
	}
	
	@Test
	void CreatePostUsingPOJO() {
		
		POJOPostRequest data=new POJOPostRequest();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhine("1253");
		
		String[] coursearray= {"C","C++"};
		data.setArray(coursearray);
		

		given().contentType("applocation/json")
		.body(data)
		
		.when().post("http://localhost:3000/Students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phon",equalTo("1253"))
			.body("coursearray[0]",equalTo("C"))
			.body("coursearray[1]",equalTo("C++"))
			.header("Content-type","application/json; charset=uft-8")
			.log().all();	
	}

}
