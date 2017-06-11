package com.example.arjun27.sourceutils;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import customview.FunctionTester;
import customview.MonitoredDebugActivity;

public class MainActivity extends MonitoredDebugActivity {

    private static final String tag = "MainActivity";

    FunctionTester ft = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ft = new FunctionTester(this, this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this, ""+item+"aaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
//        Log.d(tag,item.getTitle().toString());
//        if (item.getItemId() == R.id.menu_no_op)
//        {
//            return true;
//        }
//        if (item.getItemId() == R.id.menu_test_toast)
//        {
//            Toast.makeText(this, "Test Toast", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        if (item.getItemId() == R.id.menu_cview)
//        {
//            Toast.makeText(this, "menu clear", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return true;
    //   }


    @Override
    protected boolean onMenuItemSelected(MenuItem item) {
        Log.d(tag, item.getTitle().toString());
        if (item.getItemId() == R.id.menu_no_op) {
            return true;
        }
        if (item.getItemId() == R.id.menu_test_toast) {
            ft.testToast();

            return true;
        }
        if (item.getItemId() == R.id.menu_cview) {
            ft.testToast();
            return true;

        }
        return true;
    }
}
