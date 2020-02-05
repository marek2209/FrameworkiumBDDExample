package com.employeeApi.api.service;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class EmployeeService {

    public EmployeeService() {
        RestAssured request = new RestAssured();
        request.baseURI = "https://reqres.in";
    }

    public JsonPath getEmployeeById(Integer id) {
        JsonPath jsonResponse = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("/api/users/" + id)
                .then()
                .statusCode(200).extract().jsonPath();
        return jsonResponse;
    }
}