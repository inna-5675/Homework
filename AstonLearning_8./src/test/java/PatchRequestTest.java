import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PatchRequestTest {
    @Test
    public void testPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .log().all()
                .when()
                .patch("/patch")
                .then()
                .log().all().statusCode(HttpStatus.SC_OK).and()

                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
}
