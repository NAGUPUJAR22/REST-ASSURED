package com.restassuredpractices;


	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

	import org.json.JSONObject;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class a {

	    private int studentId;

	    @BeforeClass
	    public void setup() {
	        baseURI = "http://localhost:3000";
	    }

	    @Test(priority = 1)
	    public void createStudent() {
	        // Create a JSON object with the data to be sent in the request body
	        JSONObject data = new JSONObject();
	        data.put("name", "Yashaswini");
	        data.put("location", "Davangeri");
	        data.put("phone", "1234567895");
	        data.put("courses", new String[]{"php", ".net"});

	        // Print the request payload
	        System.out.println("Request Payload: " + data.toString());

	        // Send the POST request to create a student and store the returned ID
	        studentId = given()
	            .contentType("application/json")
	            .body(data.toString())
	        .when()
	            .post("/students")
	        .then()
	            .statusCode(201) // Expecting 201 Created
	            .body("name", equalTo("Yashaswini"))
	            .body("location", equalTo("Davangeri"))
	            .body("phone", equalTo("1234567895"))
	            .body("courses[0]", equalTo("php"))
	            .body("courses[1]", equalTo(".net"))
	            .log().all()
	            .extract()
	            .path("id");

	        System.out.println("Created Student ID: " + studentId); // Log the created student ID
	    }

	    @Test(priority = 2)
	    public void deleteRequest() {
	        // Ensure the student ID is valid before attempting deletion
	        if (studentId <= 0) {
	            throw new IllegalArgumentException("Invalid student ID: " + studentId);
	        }

	        // Log the student ID before deletion
	        System.out.println("Deleting Student ID: " + studentId);

	        // Send the DELETE request and verify the response
	        given()
	            .when()
	            .delete("/students/" + studentId)
	        .then()
	            .statusCode(204) // Expecting 204 No Content
	            .log().all();
	    }

	    @Test(priority = 3, dependsOnMethods = {"deleteRequest"})
	    public void verifyDeletion() {
	        // Verify the student has been deleted using a GET request
	        given()
	            .when()
	            .get("/students/" + studentId)
	        .then()
	            .statusCode(404) // Expecting 404 Not Found
	            .log().all();
	    }
	}



