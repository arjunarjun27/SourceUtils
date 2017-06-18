package customview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by arjun27 on 6/3/2017.
 */

public class MonitoredActivity extends AppCompatActivity {

    private static  String tag = "MonitoredActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag,"onCreate.");
        super.onCreate(savedInstanceState);
        this.registerReceiver(this.mConnReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private BroadcastReceiver mConnReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);

            NetworkInfo currentNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            NetworkInfo otherNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);

            if(currentNetworkInfo.isConnected()){
                Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_LONG).show();
            }
        }
    };
    @Override
    protected void onPause() {
        Log.d(tag,"onpause. I may be partially or fully invisible");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.d(tag,"onstop. I am fully invisible");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.d(tag,"ondestroy. about to be removed");
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        Log.d(tag,"onRestart. UI controls are there.");
        super.onRestart();
    }
    @Override
    protected void onStart() {
        Log.d(tag,"onStart. UI may be partially visible.");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d(tag,"onResume. UI fully visible.");
        super.onResume();
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(tag,"onRestoreInstanceState. You should restore state");
        super.onRestoreInstanceState(savedInstanceState);
    }

//    @Override
//    public Object onRetainNonConfigurationInstance() {
//        Log.d(tag,"onRetainNonConfigurationInstance.");
//        return super.onRetainNonConfigurationInstance();
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(tag,"onSaveInstanceState. You should load up the bundle");
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(tag,"onConfigurationChanged.");
        super.onConfigurationChanged(newConfig);
    }
}
