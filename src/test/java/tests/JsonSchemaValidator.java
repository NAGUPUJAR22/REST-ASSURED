package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemaValidator
{
	@Test
    public void tesGet()
    {
    	baseURI="https://reqres.in/api";
    	given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json")).
    	statusCode(200)	;	
       
    }
}
