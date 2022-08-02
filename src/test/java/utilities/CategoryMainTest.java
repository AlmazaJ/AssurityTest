package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

class CategoryMainTest extends CategoryMain{

    @BeforeEach
    void setUp() {
    }

    @Test
    public void checkCategory()
    {
        given().
        when().
                get(url).
        then().
                assertThat().
                // Validate Name should be equal to Carbon credits
                body("Name", equalTo(categoryName)).
                // Validate CanRelist should be equal to boolean true
                body("CanRelist", equalTo(true)).
                // Validate Promotions element with Name = "Gallery" has a description that contains the text "Good position in category"
                body("Promotions[1].Name", equalTo(promotionsName)).
                body("Promotions[1].Description", containsString(promotionsDescription));

        System.out.println("All acceptance criteria are covered");
    }

    @AfterEach
    void tearDown() {
    }
}