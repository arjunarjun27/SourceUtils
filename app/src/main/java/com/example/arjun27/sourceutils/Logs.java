package com.example.arjun27.sourceutils;

import android.app.Activity;
import android.util.Log;

/**
 * Created by arjun27 on 6/3/2017.
 */

public class Logs {

    public static void log(Activity activity,String msg){
        Log.d(activity.getLocalClassName(),msg);
    }

}
