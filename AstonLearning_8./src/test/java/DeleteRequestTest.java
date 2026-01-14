import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class DeleteRequestTest {
    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";
        String expectedData = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(expectedData)
                .log().all()
                .when()
                .delete("/delete")
                .then()
                .log().all().statusCode(HttpStatus.SC_OK).and()

                .body("data", equalTo(expectedData))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
