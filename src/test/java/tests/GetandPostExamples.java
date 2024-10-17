package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetandPostExamples 
{
	@Test
    public void tesGet()
    {
    	baseURI="https://reqres.in/api";
    	given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
    	.body("data.first_name",hasItems("George","Rachel","Michael","Lindsay","Tobias","Byron"));
    }
	
	@Test
	public void testPost()
	{
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("name", "nagaraj");
//		map.put("job", "Job seeker");
//		System.out.println(map);
		
		JSONObject obj=new JSONObject();
		obj.put("name", "yashaswini");
		obj.put("job","QA");
		System.out.println(obj);
		
		baseURI="https://reqres.in/api";
		
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)	
		.body(obj.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
	}
}
