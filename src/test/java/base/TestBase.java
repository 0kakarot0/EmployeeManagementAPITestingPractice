package base;

import org.testng.annotations.BeforeClass;
import utils.rest_assured_config.RestAssuredConfig;

public class TestBase {

    @BeforeClass
    public void setup() {
        RestAssuredConfig.setup();
    }
}
