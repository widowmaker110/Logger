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

        logger.message("onCreate - Loaded init() successfully");

        testFunction();
    }

    private void init(){

        if(logger == null)
            logger = new Logger();
    }

    private void testFunction(){
        logger.message("Isn't this cool?");
    }
}
