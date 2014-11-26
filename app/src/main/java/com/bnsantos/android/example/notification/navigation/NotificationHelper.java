package com.bnsantos.android.example.notification.navigation;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

/**
 * Created by bruno on 25/11/14.
 */
public class NotificationHelper {
    public static final int NOTIFICATION_ID = 1;
    NotificationCompat.Builder mBuilder;
    private Context mContext;
    private NotificationManager mNotificationManager;

    public NotificationHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void createNotification() {
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(mContext.getString(R.string.notification_title))
                .setContentText(mContext.getString(R.string.notification_text))
                .setTicker(mContext.getString(R.string.notification_text))
                .setAutoCancel(true)
                .setWhen(Calendar.getInstance().getTimeInMillis());

        mBuilder.setContentIntent(getContentIntent());
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

    private PendingIntent getContentIntent() {
        Intent intent = new Intent(mContext, ActivityB.class);
        return PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
