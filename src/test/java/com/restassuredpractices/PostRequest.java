package com.restassuredpractices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostRequest 
{
	ValidatableResponse id;
   //int id;
   
   //@Test(priority = 1)
   public void postRequestByHashMap()
   {
	   HashMap data=new HashMap();
	   data.put("name", "Yashaswini");
	   data.put("id", 4);
	   data.put("phone", "1234567895");
	   String coursesArr[]= {"php","javascript"};
	   data.put("courses",coursesArr);
	   
	    id = given().contentType("application/json").body(data)
	   .when().post("http://localhost:3000/students")
	   .then().statusCode(201)
	   .body("name", equalTo("Yashaswini"))
	   .body("id", equalTo(4))
	   .body("phone", equalTo("1234567895"))
	   .body("courses[0]", equalTo("php"))
	   .body("courses[1]", equalTo("javascript"))
	   .log().all();
	   
	   
   }
   
  // @Test(priority = 1)
   public void postRequestByOrgJson()
   {
	   JSONObject data=new JSONObject();
	   data.put("name", "Yashaswini");
	   //data.put("id", 4);
	   data.put("phone", "1234567895");
	   String coursesArr[]= {"php","javascript"};
	   data.put("courses",coursesArr);
	   
	     given().contentType("application/json").body(data.toString())
	   .when().post("http://localhost:3000/students")
	   .then().statusCode(201)
	   .body("name", equalTo("Yashaswini"))
	   //.body("id", equalTo(4))
	   .body("phone", equalTo("1234567895"))
	   .body("courses[0]", equalTo("php"))
	   .body("courses[1]", equalTo("javascript"))
	   .log().all();
	   
	   
   }
   
   
   @Test(priority = 1)
   public void postRequestByExternalJsonFile() throws FileNotFoundException
   {
	   File f=new File(".\\body.json");
	   FileReader fr=new FileReader(f);
	   JSONTokener jt=new JSONTokener(fr);
	   JSONObject data=new JSONObject(jt);
	   
	   
	     given().contentType("application/json").body(data.toString())
	   .when().post("http://localhost:3000/students")
	   .then().statusCode(201)
	   .body("name", equalTo("Ashwini rajkumar"))
	   //.body("id", equalTo(4))
	   .body("phone", equalTo("1234567891"))
	   .body("courses[0]", equalTo(".net"))
	   .body("courses[1]", equalTo("Jmeter"))
	   .log().all();
	   
	   
   }
   
   
   
   //@Test(priority = 2)
   public void deleteRequest()
   {
	   given()
	   .when().delete("http://localhost:3000/students/daee")
	   .then().statusCode(200).log().all();
   }
   
   
}
