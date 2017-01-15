package widowmaker110.exampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import widowmaker110.logger.Logger;

public class MainActivity extends AppCompatActivity {

    public Logger logger;

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

    public void init(){

        if(logger == null)
            logger = new Logger();
    }

    public void testingLog(){Log.d("testing this","testing this");}

    public void showPrintln(){logger.println(1, "this is println");}

    public void showVerbose(){logger.verbose("this is verbose");}

    public void showInfo(){
        logger.info("Coca-Cola was originally green");
    }

    public void showError(){
        try{
            String[] strings = new String[] {"one","two","three"};

            String failure = strings[3];

        } catch (Exception e){

            logger.error("error found: " + e.getLocalizedMessage());
        }
    }

    public void showWarning(){
        logger.warning("programmers don't care about warnings");
    }

    public void testFunction(){
        logger.message("Isn't this cool?");
    }
}
