package widowmaker110.exampleapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MainActivityUnitTest
 *
 * Covers all of the logic within MainActivity.java
 */
public class MainActivityUnitTest {

    MainActivity mainActivity;

    @Before
    public void preTestingSetup() throws Exception {
        mainActivity = new MainActivity();
        mainActivity.init();
    }

    @Test
    public void initTest() throws Exception {
        assert(mainActivity.logger != null);
    }

    @Test
    public void testingLogTest() throws Exception {
        mainActivity.testingLog();
    }

    @Test
    public void showPrintlnTest() throws Exception {
        mainActivity.showPrintln();
    }
}