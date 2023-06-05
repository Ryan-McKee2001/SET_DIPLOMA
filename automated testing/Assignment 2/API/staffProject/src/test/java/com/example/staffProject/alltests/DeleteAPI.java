package com.example.staffProject.alltests;

import com.example.staffProject.apiTestMethods.RequestSpec;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.example.staffProject.alltests.getTests.*;
import static com.example.staffProject.helper.statusCodes.OK_STATUS_CODE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DeleteAPI {

    private static List<Object> staffList;

    public static final int INTERNAL_SERVER_ERROR_STATUS_CODE = 500;

    @BeforeClass
    public static void setup() {
        staffList = getResponseList();
    }

    @Test
    public void deleteRecordFromDatabase() {

        if (staffList.size() <= 0){
            fail("Test failed as there is no records in database to deleted.");
        }
        int lastId = (int)staffList.get(staffList.size() - 1);
        Response deleteResponse = deleteByIdAndGetResponse(lastId);
        assertEquals(deleteResponse.statusCode(), OK_STATUS_CODE);
        int expected = staffList.size() - 1;
        staffList = getResponseList();
        int actual = staffList.size();
        assertEquals(actual, expected);
    }

    @Test
    public void deleteRecordThatDoesNotExistFromDatabase() {
        Response deleteResponse = deleteByIdAndGetResponse(20);
        assertEquals(deleteResponse.statusCode(), INTERNAL_SERVER_ERROR_STATUS_CODE);
    }

    private static Response deleteByIdAndGetResponse(int id) {
        Response deleteResponse = given().
                spec(RequestSpec.requestSpec()).
                delete(String.format("/delete-staff-member/%s", id));
        return deleteResponse;
    }
}
