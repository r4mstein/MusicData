package r4mstein.ua.musicdata.utils;

import android.util.Log;

public class Logger {

    public Logger() {
    }

    public void e(Throwable _throwable) {

            int errorCode = 0;

            Log.e("MusicDataApp_", _throwable.getClass().getName()
                    + ", cause - "      + _throwable.getCause()
                    + ", code = "       + errorCode
                    + ", message - "    + _throwable.getMessage());
    }

    private String getSimpleClassName(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    private int getStackOffset(StackTraceElement[] trace) {
        for (int i = 2; i < trace.length - 1; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(Logger.class.getName())) {
                return i;
            }
        }
        return -1;
    }


    public void logStackTrace() {

            StackTraceElement[] trace = Thread.currentThread().getStackTrace();

            int index = getStackOffset(trace);

            String className = getSimpleClassName(trace[index].getClassName());
            String methodName = trace[index].getMethodName();
            String threadName = Thread.currentThread().getName();
            String line = "(" + trace[index].getFileName() + ":" + trace[index].getLineNumber() + ")";

            StringBuilder builder = new StringBuilder();
            builder.append(boundString(className, 30));
            builder.append(boundString(methodName, 40));
            builder.append(boundString(threadName, 40));
            builder.append(boundString(line, 20));

            Log.d("MusicData_ThreadLogger", builder.toString());

    }

    private String boundString(String message, int bound) {
        StringBuilder builder = new StringBuilder();
        builder.append(message);

        int length = message.length();
        while (length < bound) {
            builder.append(" ");
            length++;
        }

        return builder.toString();
    }

    public void d(String _message) {
            Log.d("MusicDataApp_DataLogger", _message);
    }

}
