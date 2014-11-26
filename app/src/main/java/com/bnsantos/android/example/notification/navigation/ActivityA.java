package com.bnsantos.android.example.notification.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ActivityA extends FragmentActivity {
    public static final int START_ACTIVITY_B = 123;
    private TextView mResponse;
    private NotificationHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mNotificationHelper = new NotificationHelper(this);
        mResponse = (TextView) findViewById(R.id.textViewResponse);
        findViewById(R.id.buttonStartB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                startActivityForResult(intent, START_ACTIVITY_B);
            }
        });
        findViewById(R.id.buttonCreateNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotificationHelper.createNotification();
            }
        });
        findViewById(R.id.buttonFinishA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        updateTextView(getIntent());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_a, menu);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == START_ACTIVITY_B) {
                updateTextView(data);
            }
        }
    }

    private void updateTextView(Intent data) {
        if (data != null && data.getStringExtra(ActivityB.RESULT) != null) {
            mResponse.setText(data.getStringExtra(ActivityB.RESULT));
        }
    }
}
