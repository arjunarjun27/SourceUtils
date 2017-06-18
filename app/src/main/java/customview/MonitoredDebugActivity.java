package customview;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arjun27.sourceutils.R;

import customview.Interface.IReportBack;

/**
 * Created by arjun27 on 6/10/2017.
 */

public abstract class MonitoredDebugActivity extends MonitoredActivity implements IReportBack {

    private static String tag=null;


    protected abstract boolean onMenuItemSelected(MenuItem item);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        appendMenuItemText(item);
        if (item.getItemId() == R.id.menu_da_clear){
            this.emptyText();
            return true;
        }
        return onMenuItemSelected(item);
    }

    protected void emptyText(){
        TextView tv = getTextView();
        tv.setText("");
    }

    protected void appendMenuItemText(MenuItem menuItem){
        String title = menuItem.getTitle().toString();
        TextView tv = getTextView();
        tv.setText(tv.getText() + "\n" + title);
    }
    private TextView getTextView(){
        return (TextView)this.findViewById(R.id.text1);
    }

    @Override
    public void reportBack(String tag, String message) {
        this.appendText(tag + ":" + message);
        Log.d(tag,message);
    }
    private void appendText(String s){
        TextView tv = getTextView();
        tv.setText(tv.getText() + "\n" + s);
        Log.d(tag,s);
    }
    public void reportTransient(String tag, String message)
    {
        String s = tag + ":" + message;
        Toast mToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        mToast.show();
        reportBack(tag,message);
        Log.d(tag,message);
    }
}
