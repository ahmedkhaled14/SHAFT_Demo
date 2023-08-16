package apiTests;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestfulBookerApiTest {
    SHAFT.API api;

    private final String serviceURI = "https://restful-booker.herokuapp.com";
    private final String auth = "/auth";
    private final String booking = "/booking";

    @BeforeClass
    public void setup(){
        api = new SHAFT.API(serviceURI);
    }

    @Test
    public void updateBookingTest(){

        String authBody = """
               {
                   "username" : "admin",
                   "password" : "password123"
               }
               """;

        api.post(auth)
                .setContentType(ContentType.JSON)
                .setRequestBody(authBody)
                .perform();
        String token = api.getResponseJSONValue("token");

        String createBody = """
                {
                    "firstname" : "Ahmed",
                    "lastname" : "Khaled",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
                """;
        api.post(booking)
                .setContentType(ContentType.JSON)
                .setRequestBody(createBody)
                .perform();

       String bookingid = api.getResponseJSONValue("bookingid");

        String updatedBody = """
                {
                    "firstname" : "khaled",
                    "lastname" : "mohamed",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
                """;
       api.put(booking+"/"+bookingid)
               .setContentType(ContentType.JSON)
               .addHeader("Cookie","token="+token)
               .setRequestBody(updatedBody)
               .perform();
        api.assertThatResponse()
                .extractedJsonValue("firstname")
                .isEqualTo("khaled")
                .perform();
    }
}
