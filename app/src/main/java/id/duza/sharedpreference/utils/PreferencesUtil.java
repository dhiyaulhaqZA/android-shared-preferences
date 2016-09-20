package id.duza.sharedpreference.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by duza on 20/09/16.
 */

public final class PreferencesUtil {
    // No one class can extend this class
    private PreferencesUtil()   {}

    private static final String PREF_NAME = "userlogin";
    private static SharedPreferences sharedPref;

    public static final String KEY_USER = "username";
    public static final String KEY_LOGIN = "is_login";

    public static void writeUserData(Context context, String key, String value)    {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void writeBooleanData(Context context, String key, boolean value)  {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static String readUserData(Context context, String key, String defValue)  {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getString(key, defValue);
    }
    public static boolean readBooleanData(Context context, String key, boolean defValue)  {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(key, defValue);
    }
}
