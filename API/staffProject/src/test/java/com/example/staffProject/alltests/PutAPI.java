package com.example.staffProject.alltests;

import com.example.staffProject.apiTestMethods.RequestSpec;
import com.example.staffProject.apiTestMethods.ResponseSpec;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutAPI {
    // Class Object
    JSONObject putData = new JSONObject();

    @BeforeClass
    public void setUp() throws JSONException {
        putData.put("forename", "Sylvestor");
        putData.put("surname", "Stallone");
        putData.put("deptnumber", 432);
    }

    @Test
    public void updateRecordInDatabase() {
        given().
                spec(RequestSpec.requestSpec()).
                body(putData.toJSONString()).
                when().
                put(String.format("/update-staff/%s", 4)).
                then().spec(ResponseSpec.responseSpecification()).log();
    }
}
