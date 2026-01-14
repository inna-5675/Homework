import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest {
    @Test
    public void testGetRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then().log().body().statusCode(HttpStatus.SC_OK). and()

                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}