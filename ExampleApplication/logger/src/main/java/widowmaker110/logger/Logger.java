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

import java.util.Arrays;

/**
 * MainLogger
 *
 * Created by Alexander Miller on 1/10/2017.
 */
public class Logger {

    /** DEBUGMODE - controling overall boolean which either turns on or off the debug messages */
    protected static boolean DEBUGMODE = true;

    /** messageLogLevel - a way to determine which logging level to print in the async function */
    protected static int messageLogLevel = 1;

    /** errorLogLevel - a way to determine which logging level to print in the async function */
    protected static int errorLogLevel = 2;

    /** infoLogLevel - a way to determine which logging level to print in the async function */
    protected static int infoLogLevel = 3;

    /** warningLogLevel - a way to determine which logging level to print in the async function */
    protected static int warningLogLevel = 4;

    /** verboseLogLevel - a way to determine which logging level to print in the async function */
    protected static int verboseLogLevel = 5;

    /** printlnLogLevel - a way to determine which logging level to print in the async function */
    protected static int printlnLogLevel = 6;

    protected static int wtfLogLevel = 7;

    /** printlnLogLevel - Filler for the Tag parameter of the Log.e,i,w,v() function */
    protected static String GenericTag = "LoggerTag";

    protected String[] protectedMethodNames = {"message", "error", "info", "warning", "verbose", "println", "wtf"};

    /**
     * MainLogger
     *
     * Empty Constructor
     */
    public Logger(){}

    /**
     * getCallingFunction
     *
     * This function cycles through the entire stack trace of method calls,
     * finds the last occurance of "message" || "error" || "info" || "warning" || "verbose" || "println" (the method found in this library),
     * then returns the String name
     *
     * Inspired by: http://stackoverflow.com/questions/19367119/java-how-do-i-sequentially-find-the-last-occurrence-of-an-element-in-an-array-th
     *
     * @return returningValue (String) - Name of the function calling one of this library's print statements
     */
    public String getCallingFunction(StackTraceElement[] elements){

        String returningValue = "";

        for (int index = 0; index < elements.length-1; index++) {
            String tempValue = elements[index].getMethodName();
            if (Arrays.asList(protectedMethodNames).contains(tempValue)) {
                returningValue = elements[index+1].getMethodName();
            }
        }

        return returningValue;
    }

    /**
     * getCallingFile
     *
     * This function cycles through the entire stack trace of method calls,
     * finds the last occurance of "message" || "error" || "info" || "warning" || "verbose" || "println" (the method found in this library),
     * then returns the String name
     *
     * Inspired by: http://stackoverflow.com/questions/19367119/java-how-do-i-sequentially-find-the-last-occurrence-of-an-element-in-an-array-th
     *
     * @return returningValue (String) - Name of the function calling one of this library's print statements
     */
    public String getCallingFile(StackTraceElement[] elements){

        String returningValue = "";

        for (int index = 0; index < elements.length-1; index++) {
            String tempValue = elements[index].getMethodName();
            if (Arrays.asList(protectedMethodNames).contains(tempValue)) {
                returningValue = elements[index+1].getFileName();
            }
        }

        return returningValue;
    }

    /**
     * message
     *
     * Invokes an Async Task to print, using Log.d()
     *
     * @param Message (String) The message you want to print
     */
    public void message(String Message){
        if (DEBUGMODE){

            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(messageLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){

            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(messageLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message, Exception).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(errorLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(errorLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message, Exception).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){

            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(infoLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(infoLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message, Exception).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){

            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(warningLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){

            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(warningLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message, Exception).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(verboseLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){

            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(verboseLogLevel, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message, Exception).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            new PrintOperation(printlnLogLevel, Priority, getCallingFile(stacktrace)  + " - " + getCallingFunction(stacktrace), Message).execute();
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
        if (DEBUGMODE){
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
        if (DEBUGMODE){
            new PrintOperation(printlnLogLevel, Priority, Tag, Message, Exception).execute();
        }
    }

    protected static class PrintOperation extends AsyncTask<Void, Void, Void> {

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

        // TODO Add the wtf statments here

        /**
         * PrintOperation
         *
         * overloaded constructor to hold the data passed from the super class
         *
         * @param loggingLevelParam (int) Logging level used later in a switch case
         * @param MessageParam (String) The message you want to print
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

            if(loggingLevel == messageLogLevel){
                if((Tag != null && !Tag.isEmpty())) {
                    Log.d(this.Tag, this.Message, this.Exception);
                } else {
                    Log.d(GenericTag, this.Message, Exception);
                }
            }
            else if(loggingLevel == errorLogLevel) {
                if((Tag != null && !Tag.isEmpty())) {
                    Log.e(this.Tag, this.Message, this.Exception);
                } else {
                    Log.e(GenericTag, this.Message, Exception);
                }
            }
            else if(loggingLevel == infoLogLevel) {
                if((Tag != null && !Tag.isEmpty())) {
                    Log.i(this.Tag, this.Message, this.Exception);
                } else {
                    Log.i(GenericTag, this.Message, Exception);
                }
            }
            else if(loggingLevel == warningLogLevel) {
                if((Tag != null && !Tag.isEmpty())) {
                    Log.w(this.Tag, this.Message, this.Exception);
                } else {
                    Log.w(GenericTag, this.Message, Exception);
                }
            }
            else if(loggingLevel == verboseLogLevel) {
                if((Tag != null && !Tag.isEmpty())) {
                    Log.v(this.Tag, this.Message, this.Exception);
                } else {
                    Log.v(GenericTag, this.Message, Exception);
                }
            }
            else {
                if((Tag != null && !Tag.isEmpty())) {
                    Log.println(this.Priority, this.Tag, this.Message);
                } else {
                    Log.println(this.Priority, GenericTag, this.Message);
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {}
    }
}