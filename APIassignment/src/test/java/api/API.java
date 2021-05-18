package api;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class API {

    @Test
    public void testpost() {
        JSONObject x = new JSONObject();

        x.put("name", "Jan");
        x.put("occupation", "Accountant");

        System.out.println(x.toJSONString());

        given().
                body(x.toJSONString()).
        when().
                post ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }

    @Test
    public void testpatch() {
        JSONObject x = new JSONObject();

        x.put("name", "Jane");
        x.put("occupation", "Senior Accountant");

        System.out.println(x.toJSONString());

        given().
                body(x.toJSONString()).
        when().
                patch ("https://reqres.in/api/users/2").
        then().
            statusCode(200);
    }

    @Test
    public void testget() {

        when().
                get ("https://reqres.in/api/users/2").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void testdelete() {

        when().
                delete ("https://reqres.in/api/users/2").
        then().
            statusCode(204).log().all();
    }

}