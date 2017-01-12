package widowmaker110.exampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import widowmaker110.logger.Logger;

public class MainActivity extends AppCompatActivity {

    Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        logger.message("init() loaded successfully");

        testFunction();

        showError();

        showInfo();

        showWarning();

        showVerbose();
    }

    private void init(){

        if(logger == null)
            logger = new Logger();
    }



    private void showPrintln(){logger.println(1, "this is println");}

    private void showVerbose(){logger.verbose("this is verbose");}

    private void showInfo(){
        logger.info("Coca-Cola was originally green");
    }

    private void showError(){
        try{
            String[] strings = new String[] {"one","two","three"};

            String failure = strings[3];

        } catch (Exception e){

            logger.error("error found: " + e.getLocalizedMessage());
        }
    }

    private void showWarning(){
        logger.warning("programmers don't care about warnings");
    }

    private void testFunction(){
        logger.message("Isn't this cool?");
    }
}
