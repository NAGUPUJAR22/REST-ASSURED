package com.restassuredpractices;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class http_requests
{
	int id;
     @Test(priority=1)
	public void getuser()
	{
		when().get("https://reqres.in/api/users?page=2")
		
		.then().statusCode(200).body("page",equalTo(2)).log().all();
	}
     
     
     @Test(priority = 2)
     public void createUsers()
     {
    	 
    	 HashMap data=new HashMap();
    	 data.put("name", "Nagaraj");
    	 data.put("job", "QA");
    	 
    	 
    	 id=given().contentType("application/json").body(data)
    	 .when().post("https://reqres.in/api/users").jsonPath().getInt("id");
    	// .then().statusCode(201).log().all();
     }
     
     @Test(priority = 3,dependsOnMethods = {"createUsers"})
     public void updateUser()
     {
    	 HashMap data=new HashMap();
    	 data.put("name", "Nagaraj");
    	 data.put("job", "Test Engg Trainee");
    	 
    	 
    	 given().contentType("application/json").body(data)
    	 .when().put("https://reqres.in/api/users/"+id)
    	 .then().statusCode(200).log().all(); 
     }
     
     @Test(priority = 4)
     public void deleteUser()
     {
    	 given()
    	 .when().delete("https://reqres.in/api/users/"+id)
    	 .then().statusCode(204).log().all();
     }

}
