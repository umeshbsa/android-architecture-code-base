package com.app.architecture.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.app.architecture.App;
import com.app.architecture.model.apimodel.output.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Class is used to save user data in preference.
 */
public class PreferenceKeeper {

    private static PreferenceKeeper keeper;
    private SharedPreferences prefs;

    private PreferenceKeeper(Context context) {
        if (context != null)
            prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PreferenceKeeper getInstance() {
        if (keeper == null) {
            keeper = new PreferenceKeeper(App.getInstance());
        }
        return keeper;
    }


    public void saveUser(User user) {
        if (user != null) {
            setAccessToken(user.accessToken);
            prefs.edit().putString(AppConstant.PKN.USER, GsonUtils.getJson(user)).apply();
        } else {
            prefs.edit().putString(AppConstant.PKN.USER, "{}").apply();
        }
    }

    public User getUser() {
        Type type = new TypeToken<User>() {
        }.getType();
        return GsonUtils.parseJson(prefs.getString(AppConstant.PKN.USER, "{}"), type);
    }

    public String getFCMToken() {
        String fcmToken = prefs.getString(AppConstant.PKN.FCM_TOKEN, "");
        if (TextUtils.isEmpty(fcmToken)) {
            fcmToken = "abcd";
        }
        return fcmToken;
    }

    public void setFCMToken(String fcmToken) {
        prefs.edit().putString(AppConstant.PKN.FCM_TOKEN, fcmToken).apply();
    }


    public String getAccessToken() {
        String accessToken = prefs.getString(AppConstant.PKN.ACCESS_TOKEN, "");
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        prefs.edit().putString(AppConstant.PKN.ACCESS_TOKEN, accessToken).apply();
    }


    public boolean isUserLogin() {
        return prefs.getBoolean(AppConstant.PKN.USER_LOGIN, false);
    }

    public void setUserLogin(boolean isUserLogin) {
        prefs.edit().putBoolean(AppConstant.PKN.USER_LOGIN, isUserLogin).apply();
    }
}
