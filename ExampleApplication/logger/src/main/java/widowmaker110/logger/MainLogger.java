package widowmaker110.logger;

/*
 *  MIT License
 *
 *  Copyright (c) 2017 Alexander Miller
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

import android.os.AsyncTask;
import android.util.Log;

/**
 * MainLogger
 *
 * Created by Alexander Miller on 1/10/2017.
 */
public class MainLogger {

    /** messageLogLevel - a way to determine which logging level to print in the async function */
    private static int messageLogLevel = 1;

    /** errorLogLevel - a way to determine which logging level to print in the async function */
    private static int errorLogLevel = 2;

    /** infoLogLevel - a way to determine which logging level to print in the async function */
    private static int infoLogLevel = 3;

    /** warningLogLevel - a way to determine which logging level to print in the async function */
    private static int warningLogLevel = 4;

    /** verboseLogLevel - a way to determine which logging level to print in the async function */
    private static int verboseLogLevel = 5;

    /** printlnLogLevel - a way to determine which logging level to print in the async function */
    private static int printlnLogLevel = 6;

    /**
     * MainLogger
     *
     * Empty Constructor
     */
    public MainLogger(){}

    public String getStackTraceString(Throwable Exception){
        return Log.getStackTraceString(Exception);
    }

    public void message(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Message).execute();
        }
    }

    public void message(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Tag, Message).execute();
        }
    }

    public void message(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Message, Exception).execute();
        }
    }

    public void message(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Tag, Message, Exception).execute();
        }
    }

    public void error(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Message).execute();
        }
    }

    public void error(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Tag, Message).execute();
        }
    }

    public void error(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Message, Exception).execute();
        }
    }

    public void error(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Tag, Message, Exception).execute();
        }
    }

    public void info(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Message).execute();
        }
    }

    public void info(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Tag, Message).execute();
        }
    }

    public void info(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Message, Exception).execute();
        }
    }

    public void info(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Tag, Message, Exception).execute();
        }
    }

    public void warning(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Message).execute();
        }
    }

    public void warning(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Tag, Message).execute();
        }
    }

    public void warning(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Message, Exception).execute();
        }
    }

    public void warning(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Tag, Message, Exception).execute();
        }
    }

    public void verbose(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Message).execute();
        }
    }

    public void verbose(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Tag, Message).execute();
        }
    }

    public void verbose(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Message, Exception).execute();
        }
    }

    public void verbose(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Tag, Message, Exception).execute();
        }
    }

    public void println(int Priority, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(printlnLogLevel, Priority, Message).execute();
        }
    }

    public void println(int Priority, String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(printlnLogLevel, Priority, Tag, Message).execute();
        }
    }

    private class PrintOperation extends AsyncTask<Void, Void, Void> {

        private int loggingLevel;
        private String Tag;
        private String Message;
        private Throwable Exception;
        private int Priority;

        /**
         * PrintOperation
         *
         * Empty Constructor
         */
        public PrintOperation(){}

        public PrintOperation(int loggingLevelParam, String MessageParam){
            this.loggingLevel = loggingLevelParam;
            this.Message = MessageParam;
        }

        public PrintOperation(int loggingLevel, String Tag, String Message){}

        public PrintOperation(int loggingLevel, int Priority, String Message){}

        public PrintOperation(int loggingLevel, int Priority, String Tag, String Message){}

        public PrintOperation(int loggingLevel, String Message, Throwable Exception){}

        public PrintOperation(int loggingLevel, String Tag, String Message, Throwable Exception){}

        @Override
        protected void onPreExecute() {}

        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {}
    }
}