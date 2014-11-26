package com.bnsantos.android.example.notification.navigation;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bruno on 26/11/14.
 */
public class SharedPrefsHelper {
    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).edit();
        editor.putString(key, (value));
        editor.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        String result = sharedPreferences.getString(key, null);
        clear(context, key);
        return result;
    }

    public static void clear(Context context, String key) {
        SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).edit();
        editor.remove(key);
        editor.commit();
    }

}
