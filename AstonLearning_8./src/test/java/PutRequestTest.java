import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.*;
public class PutRequestTest {
    @Test
    public void testPutRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().body().statusCode(HttpStatus.SC_OK).and()

                .body("data", equalTo(requestBody))
                .body("args", is(emptyMap()))
                .body("files", is(emptyMap()))
                .body("form", is(emptyMap()))
                .body("json", is(nullValue()));
    }
}