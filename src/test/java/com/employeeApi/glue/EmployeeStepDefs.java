package com.employeeApi.glue;

import com.employeeApi.api.service.EmployeeService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import static com.google.common.truth.Truth.assertThat;

public class EmployeeStepDefs {

    private final EmployeeService service = new EmployeeService();
    private JsonPath employee;

    @When("^User request user by id \"([^\"]*)\"$")
    public void userRequestUserById(Integer id) {
        employee = service.getEmployeeById(id);
    }

    @Then("^It should be equal to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void itShouldBeEqualToAnd(String name, String lastName) {
        employee.setRootPath("data");
        assertThat(name).isEqualTo(employee.get("first_name"));
        assertThat(lastName).isEqualTo(employee.get("last_name"));
    }
}