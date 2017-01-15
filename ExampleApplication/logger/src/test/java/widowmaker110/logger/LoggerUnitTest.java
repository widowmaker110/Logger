package widowmaker110.logger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * LoggerUnitTest
 *
 * This class is designed to cover all of the Logger API
 *
 * Created by Alexander Miller 1/13/2017
 */
public class LoggerUnitTest {

    Logger logger;

    @Before
    public void preTestingSetup() throws Exception {
        logger = new Logger();

        if(logger.DEBUGMODE == false)
            logger.DEBUGMODE = true;
    }

    @Test
    public void globalVariablesTest() throws Exception {

        assertEquals(1, logger.messageLogLevel);
        assertEquals(2, logger.errorLogLevel);
        assertEquals(3, logger.infoLogLevel);
        assertEquals(4, logger.warningLogLevel);
        assertEquals(5, logger.verboseLogLevel);
        assertEquals(6, logger.printlnLogLevel);
        assertEquals(7, logger.wtfLogLevel);
        assertEquals("LoggerTag",logger.GenericTag);
        assertArrayEquals(new String[]{"message", "error", "info", "warning", "verbose", "println", "wtf"},
                logger.protectedMethodNames);
    }

    @Test
    public void messageTest() throws Exception {

        // regular message
        logger.message("testMessage");

        // overloaded tag and message
        logger.message("testTag", "testMessage");

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            logger.message("testTag", e);
            logger.message("testTag", "testMessage", e);
        }
    }

    @Test
    public void errorTest() throws Exception {

        // regular message
        logger.error("testMessage");

        // overloaded tag and message
        logger.error("testTag", "testMessage");

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            logger.error("testTag", e);
            logger.error("testTag", "testMessage", e);
        }
    }

    @Test
    public void infoTest() throws Exception {

        // regular message
        logger.info("testMessage");

        // overloaded tag and message
        logger.info("testTag", "testMessage");

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            logger.info("testTag", e);
            logger.info("testTag", "testMessage", e);
        }
    }

    @Test
    public void warningTest() throws Exception {

        // regular message
        logger.warning("testMessage");

        // overloaded tag and message
        logger.warning("testTag", "testMessage");

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            logger.warning("testTag", e);
            logger.warning("testTag", "testMessage", e);
        }
    }

    @Test
    public void verboseTest() throws Exception {

        // regular message
        logger.verbose("testMessage");

        // overloaded tag and message
        logger.verbose("testTag", "testMessage");

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            logger.verbose("testTag", e);
            logger.verbose("testTag", "testMessage", e);
        }
    }

    @Test
    public void printlnTest() throws Exception {

        // regular message
        logger.println(1,"testMessage");

        // overloaded tag and message
        logger.println(1, "testTag", "testMessage");

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            logger.println(1, "testTag", "testMessage", e);
        }
    }

    @Test
    public void PrintOperationTest() throws Exception {

        // empty constructor
        new Logger.PrintOperation().execute();

        // simple message call
        new Logger.PrintOperation(Logger.errorLogLevel, "testMessage").execute();

        new Logger.PrintOperation(Logger.messageLogLevel, 1, "testMessage").execute();

        // throwable
        try{
            String[] exampleList = {"1"};
            // force throwable failure here
            String temp = exampleList[1];
        } catch(Throwable e) {
            new Logger.PrintOperation(Logger.messageLogLevel, "testMessage", e).execute();
        }

        // full set testing
        new Logger.PrintOperation(Logger.messageLogLevel, 1, "testTag", "testMessage", null).execute();
    }

    @Test
    public void onPreExecuteTest() throws Exception {

    }
}