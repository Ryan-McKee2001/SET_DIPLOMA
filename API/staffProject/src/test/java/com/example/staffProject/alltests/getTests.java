package com.example.staffProject.alltests;

import com.example.staffProject.apiTestMethods.RequestSpec;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static com.example.staffProject.helper.statusCodes.OK_STATUS_CODE;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class getTests {



    private static List<Object> employeesList;

    @BeforeClass
    public static void setup() {
        employeesList = getResponseList();
    }

    @Test
    public void getAllStaffTest() {
        assertEquals(getResponseForGetAllEmployees().statusCode(), OK_STATUS_CODE);
        if(employeesList.size() == 0) fail("No staff in database");
    }

    @Test (dependsOnMethods = "getAllStaffTest")
    public void getStaffByID() {
        if(employeesList.size() == 0) fail("Can not test as no staff in database");
        Random rand = new Random();
        int randomElement = (int)employeesList.get(rand.nextInt(employeesList.size()));

        Response response = given().spec(RequestSpec.requestSpec()).when().get(String.format("/get-staff/%s", randomElement));
        assertEquals(response.statusCode(), OK_STATUS_CODE);
    }

    public static List<Object> getResponseList() {
        Response response = getResponseForGetAllEmployees();
        return response.jsonPath().getList("managerNumber");
    }

    private static Response getResponseForGetAllEmployees() {
        Response response = given()
                .spec(RequestSpec.requestSpec())
                .when()
                .get("/get-all-staff");
        ResponseBody body = response.getBody();
        return response;
    }
}
