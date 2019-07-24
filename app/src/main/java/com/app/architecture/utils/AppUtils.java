package com.app.architecture.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.architecture.App;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.text.SimpleDateFormat;

public class AppUtils {


    public static boolean isConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isnewtwork = (activeNetworkInfo != null && activeNetworkInfo.isConnected());
        return isnewtwork;
    }

    public static int getColor(int color) {
        return ContextCompat.getColor(App.getInstance(), color);
    }

    public static void showToast(String msg) {
        Toast.makeText(App.getInstance(), msg, Toast.LENGTH_LONG).show();
    }

    public static void loadImageCircle(ImageView view, File file) {
        if (view != null && file != null)
            Glide.with(App.getInstance())
                    .load(file)
                    .apply(new RequestOptions()
                            .circleCrop()
                            .skipMemoryCache(false)
                            .placeholder(android.R.drawable.ic_menu_more)
                            .error(android.R.drawable.ic_menu_more)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(view);
    }

    public static void loadImage(ImageView view, String url) {
        if (view != null && url != null)
            Glide.with(App.getInstance())
                    .load(url)
                    .apply(new RequestOptions()
                            .placeholder(android.R.drawable.ic_menu_more)
                            .skipMemoryCache(false)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(view);
    }

    public static void loadImageWithPlaceHolder(ImageView view, String url, int placeholder) {
        if (view != null && url != null)
            Glide.with(App.getInstance())
                    .load(url)
                    .apply(new RequestOptions()
                            .placeholder(placeholder)
                            .skipMemoryCache(false)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(view);
    }

    public static void loadImageCircle(ImageView view, String url) {
        if (view != null && url != null)
            Glide.with(App.getInstance())
                    .load(url)
                    .apply(new RequestOptions()
                            .circleCrop()
                            .skipMemoryCache(false)
                            .placeholder(android.R.drawable.ic_menu_more)
                            .error(android.R.drawable.ic_menu_more)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(view);
    }

    public static String getDeviceId() {
        return Settings.Secure.getString(App.getInstance().getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static String getDate(long time, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(time);
    }

}
