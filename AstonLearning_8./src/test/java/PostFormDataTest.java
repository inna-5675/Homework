import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostFormDataTest {
    @Test
    public void testPostFormData() {
        given()
                .baseUri("https://postman-echo.com")

                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body().statusCode(HttpStatus.SC_OK).and()

                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));

    }
}

