package dong.com.chat.utils;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {



    /**
     * log_level 自己设置显示log的级别 设置为0时不打印信息
     */
    public static int LOG_LEVEL = 6;

    public static int ERROR = 1;
    public static int WARN = 2;
    public static int INFO = 3;
    public static int DEBUG = 4;
    public static int VERBOS = 5;

    //log的水平有 All Debug  Impo
    private static String Level = "";
    private static String methodName;

    // 2 只显示错误信息,自己抓的异常
    public static void e(String tag, String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];//代表上一层
        String className = traceElement.getClassName();//类名看自己需要
        methodName = traceElement.getMethodName();
        if (LOG_LEVEL > ERROR) {
            Level = "Impo";
            Log.e(changeTag(tag), changeMsg(msg));
        }
    }


/*
    // 3 显示警告以上级别的信息
    public static void w(String tag,String msg){
        if(LOG_LEVEL>WARN)
            Log.w(changeTag(tag), changeMsg(msg));
    }*/


    // 4 显示信息以上级别的信息，请求的数据和传出的数据
    public static void i(String tag, String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];//代表上一层
        String className = traceElement.getClassName();//类名看自己需要
        methodName = traceElement.getMethodName();

        if (LOG_LEVEL > INFO) {
            Level = "Debug";
            Log.i(changeTag(tag), changeMsg(msg));   // initDate++huangpu.myapp.gd.bottom.pager.HomePager
        }
    }
/*    // 5 显示debug以上级别的信息
    public static void d(String tag,String msg){
            Log.d(tag, msg);
        if(LOG_LEVEL>DEBUG)
    }*/

    // 6 全部都可以显示
    public static void v(String tag, String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];//代表上一层
        String className = traceElement.getClassName();//类名看自己需要
        methodName = traceElement.getMethodName();
        if (LOG_LEVEL > VERBOS) {
            Level = "All";
            Log.v(changeTag(tag), changeMsg(msg));
        }
    }
    private static String changeTag(String tag) {
        return "[" + Level + "][" + getCurrentTime() + "][" + tag;
    }
    private static String changeMsg(String msg) {
        return methodName + "]::" + "\"" + msg + "\"";
    }
    /**
     * 返回当前时间 格式化
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 返回当前时间
     * @return
     */
    public static Long getCurrentTimeNoFormatter() {
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        Long time=curDate.getTime();
        return time;
    }
}
