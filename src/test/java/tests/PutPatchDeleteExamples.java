package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples
{
	@Test
      public void testPut()
      {
    	  JSONObject obj=new JSONObject();
  		obj.put("name", "yashaswini");
  		obj.put("job","QA");
  		System.out.println(obj);
  		
  		baseURI="https://reqres.in/api";
  		
  		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)	
  		.body(obj.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
      }
	
	@Test
	public void testPatch()
	{
		 JSONObject obj=new JSONObject();
	  		obj.put("name", "yashaswini");
	  		obj.put("job","Tester");
	  		System.out.println(obj);
	  		
	  		baseURI="https://reqres.in/api";
	  		
	  		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)	
	  		.body(obj.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void testDelete()
	{
		 
	  		
	  		baseURI="https://reqres.in/api";
	  		 JSONObject obj=new JSONObject();
	  		obj.put("name", "yashaswini");
	  		obj.put("job","Tester");
	  		
	  		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)	
	  		.body(obj.toJSONString()).when().delete("/users/2").then().statusCode(204).log().all();
}
}
