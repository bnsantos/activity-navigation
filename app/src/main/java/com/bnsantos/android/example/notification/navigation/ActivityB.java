package com.bnsantos.android.example.notification.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ActivityB extends FragmentActivity {
    public static final String RESULT = "ACTIVITY_B_RESPONSE";
    private EditText mResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mResponse = (EditText) findViewById(R.id.editTextResult);
        findViewById(R.id.buttonFinishB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishB();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_b, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void finishB() {
        Intent resultIntent = new Intent();
        if (mResponse.getText().toString().length() > 0) {
            resultIntent.putExtra(RESULT, mResponse.getText().toString());
            SharedPrefsHelper.putString(this, RESULT, mResponse.getText().toString());
        }
        setResult(RESULT_OK, resultIntent);
        finish();

        //Reopens ActivityA but do not go into onActivityResult method
        /*Intent upIntent = new Intent(getApplicationContext(), ActivityA.class);
        if (mResponse.getText().toString().length() > 0) {
            upIntent.putExtra(RESULT, mResponse.getText().toString());
        }
        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
            Log.d("ShowNotifications", "New Home");
            TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
        } else {
            Log.d("ShowNotifications", "Old Home");
            upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(upIntent);
            finish();
        }*/
    }
}
