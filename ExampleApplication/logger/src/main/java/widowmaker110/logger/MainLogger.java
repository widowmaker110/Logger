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

    /**
     * message
     *
     * Invokes an Async Task to print, using Log.d()
     *
     * @param Message (String) The message you want to print
     */
    public void message(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Message).execute();
        }
    }

    /**
     * message
     *
     * Invokes an Async Task to print, using Log.d()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     */
    public void message(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Tag, Message).execute();
        }
    }

    /**
     * message
     *
     * Invokes an Async Task to print, using Log.d()
     *
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void message(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Message, Exception).execute();
        }
    }

    /**
     * message
     *
     * Invokes an Async Task to print, using Log.d()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void message(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(messageLogLevel, Tag, Message, Exception).execute();
        }
    }

    /**
     * error
     *
     * Invokes an Async Task to print, using Log.e()
     *
     * @param Message (String) The message you want to print
     */
    public void error(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Message).execute();
        }
    }

    /**
     * error
     *
     * Invokes an Async Task to print, using Log.e()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     */
    public void error(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Tag, Message).execute();
        }
    }

    /**
     * error
     *
     * Invokes an Async Task to print, using Log.e()
     *
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void error(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Message, Exception).execute();
        }
    }

    /**
     * error
     *
     * Invokes an Async Task to print, using Log.e()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void error(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(errorLogLevel, Tag, Message, Exception).execute();
        }
    }

    /**
     * info
     *
     * Invokes an Async Task to print, using Log.i()
     *
     * @param Message (String) The message you want to print
     */
    public void info(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Message).execute();
        }
    }

    /**
     * info
     *
     * Invokes an Async Task to print, using Log.i()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     */
    public void info(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Tag, Message).execute();
        }
    }

    /**
     * info
     *
     * Invokes an Async Task to print, using Log.i()
     *
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void info(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Message, Exception).execute();
        }
    }

    /**
     * info
     *
     * Invokes an Async Task to print, using Log.i()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void info(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(infoLogLevel, Tag, Message, Exception).execute();
        }
    }

    /**
     * warning
     *
     * Invokes an Async Task to print, using Log.w()
     *
     * @param Message (String) The message you want to print
     */
    public void warning(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Message).execute();
        }
    }

    /**
     * warning
     *
     * Invokes an Async Task to print, using Log.w()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     */
    public void warning(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Tag, Message).execute();
        }
    }

    /**
     * warning
     *
     * Invokes an Async Task to print, using Log.w()
     *
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void warning(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Message, Exception).execute();
        }
    }

    /**
     * warning
     *
     * Invokes an Async Task to print, using Log.w()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void warning(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(warningLogLevel, Tag, Message, Exception).execute();
        }
    }

    /**
     * verbose
     *
     * Invokes an Async Task to print, using Log.v()
     *
     * @param Message (String) The message you want to print
     */
    public void verbose(String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Message).execute();
        }
    }

    /**
     * verbose
     *
     * Invokes an Async Task to print, using Log.v()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     */
    public void verbose(String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Tag, Message).execute();
        }
    }

    /**
     * verbose
     *
     * Invokes an Async Task to print, using Log.v()
     *
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void verbose(String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Message, Exception).execute();
        }
    }

    /**
     * verbose
     *
     * Invokes an Async Task to print, using Log.v()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void verbose(String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(verboseLogLevel, Tag, Message, Exception).execute();
        }
    }

    /**
     * println
     *
     * Invokes an Async Task to print, using Log.println()
     *
     * @param Priority (int) Priority level of the println (...) TODO: figure out the level limits
     * @param Message (String) The message you want to print
     */
    public void println(int Priority, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(printlnLogLevel, Priority, Message).execute();
        }
    }

    /**
     * println
     *
     * Invokes an Async Task to print, using Log.println()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Priority (int) Priority level of the println (...) TODO: figure out the level limits
     * @param Message (String) The message you want to print
     */
    public void println(int Priority, String Tag, String Message){
        if (BuildConfig.DEBUG){
            new PrintOperation(printlnLogLevel, Priority, Tag, Message).execute();
        }
    }

    /**
     * println
     *
     * Invokes an Async Task to print, using Log.println()
     *
     * @param Tag (String) The tag you want to print. This is usually a class and/or function name
     * @param Priority (int) Priority level of the println (...) TODO: figure out the level limits
     * @param Message (String) The message you want to print
     * @param Exception (Throwable) The exception you wish to process
     */
    public void println(int Priority, String Tag, String Message, Throwable Exception){
        if (BuildConfig.DEBUG){
            new PrintOperation(printlnLogLevel, Priority, Tag, Message, Exception).execute();
        }
    }

    private class PrintOperation extends AsyncTask<Void, Void, Void> {

        /** loggingLevel - a way to determine which logging level to print */
        private int loggingLevel;

        /** Tag - The tag you want to print. This is usually a class and/or function name  */
        private String Tag;

        /** Message - The message you want to print */
        private String Message;

        /** Exception - The exception you wish to process */
        private Throwable Exception;

        /** Priority - println priority level (..) TODO: figure out the level limits */
        private int Priority;

        /**
         * PrintOperation
         *
         * Empty Constructor
         */
        public PrintOperation(){}

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param MessageParam (String) The message you want to print
         */
        public PrintOperation(int loggingLevelParam, String MessageParam){
            this.loggingLevel = loggingLevelParam;
            this.Message = MessageParam;
        }

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param TagParam (String) The tag you want to print. This is usually a class and/or function name
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param MessageParam (String) The message you want to print
         */
        public PrintOperation(int loggingLevelParam, String TagParam, String MessageParam){
            this.loggingLevel = loggingLevelParam;
            this.Tag = TagParam;
            this.Message = MessageParam;
        }

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param PriorityParam (int) Priority level of the println (...) TODO: figure out the level limits
         * @param MessageParam (String) The message you want to print
         */
        public PrintOperation(int loggingLevelParam, int PriorityParam, String MessageParam){
            this.loggingLevel = loggingLevelParam;
            this.Priority = PriorityParam;
            this.Message = MessageParam;
        }

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param TagParam (String) The tag you want to print. This is usually a class and/or function name
         * @param PriorityParam (int) Priority level of the println (...) TODO: figure out the level limits
         * @param MessageParam (String) The message you want to print
         */
        public PrintOperation(int loggingLevelParam, int PriorityParam, String TagParam, String MessageParam){
            this.loggingLevel = loggingLevelParam;
            this.Priority = PriorityParam;
            this.Tag = TagParam;
            this.Message = MessageParam;
        }

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param TagParam (String) The tag you want to print. This is usually a class and/or function name
         * @param PriorityParam (int) Priority level of the println (...) TODO: figure out the level limits
         * @param MessageParam (String) The message you want to print
         * @param ExceptionParam (Throwable) The exception you wish to process
         */
        public PrintOperation(int loggingLevelParam, int PriorityParam, String TagParam, String MessageParam, Throwable ExceptionParam){
            this.loggingLevel = loggingLevelParam;
            this.Priority = PriorityParam;
            this.Tag = TagParam;
            this.Message = MessageParam;
            this.Exception = ExceptionParam;
        }

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param MessageParam (String) The message you want to print
         * @param ExceptionParam (Throwable) The exception you wish to process
         */
        public PrintOperation(int loggingLevelParam, String MessageParam, Throwable ExceptionParam){
            this.loggingLevel = loggingLevelParam;
            this.Message = MessageParam;
            this.Exception = ExceptionParam;
        }

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param MessageParam (String) The message you want to print
         * @param ExceptionParam (Throwable) The exception you wish to process
         * @param ExceptionParam (Throwable) The exception you wish to process
         */
        public PrintOperation(int loggingLevelParam, String TagParam, String MessageParam, Throwable ExceptionParam){
            this.loggingLevel = loggingLevelParam;
            this.Tag = TagParam;
            this.Message = MessageParam;
            this.Exception = ExceptionParam;
        }

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