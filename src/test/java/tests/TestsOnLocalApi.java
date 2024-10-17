package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalApi
{   @Test
    public void get()
    {
    	baseURI="http://localhost:3000/";
    	
    	given().get("/users").then().statusCode(200).log().all();
    }
    
//    @Test
//    public void post()
//    {
//       JSONObject req=new JSONObject();
//       req.put("First_name","Renuka");
//       req.put("Last_name", "Pujar");
//       req.put("StudentId", 4);
//      
//       
//       baseURI="http://localhost:3000/";
//       
//       given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().post("/users").then().statusCode(201);
//       
//    }
    
    @Test
    public void put()
    {
    	JSONObject req=new JSONObject();
        req.put("First_name","renuka");
        req.put("Last_name", "P");
        req.put("StudentId", 4);
    
       
       baseURI="http://localhost:3000";
       
       given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().put("/users/1").then().statusCode(200);
       
    }
    @Test
    public void patch()
    {
    	JSONObject req=new JSONObject();
    	
        req.put("Last_name", "poojari");
       
        
       
       baseURI="http://localhost:3000/";
       
       given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().patch("/users/1").then().statusCode(200);
       
    }
    
//    @Test
//    public void delete()
//    {
//    	
//       
//       baseURI="http://localhost:3000/";
//       
//       when().delete("/users/1").then().statusCode(200);
//       
//    }
    
   
}
