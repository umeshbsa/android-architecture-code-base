package com.app.architecture.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import com.app.architecture.R;
import com.app.architecture.callback.IDialogCallback;


public class DialogUtils {

    private DialogUtils() {
    }

    public static void showAlert(Context context, String message) {
        showAlert(context, context.getResources().getString(R.string.app_name), message, context.getResources().getString(R.string.ok), context.getResources().getString(R.string.cancel));
    }

    public static void showAlert(Context context, String message, IDialogCallback callback) {
        showAlert(context, context.getResources().getString(R.string.app_name), message, context.getResources().getString(R.string.ok), context.getResources().getString(R.string.cancel), callback);
    }

    public static void showAlert(Context context, String title, String message, String ok, String no) {
        showAlert(context, title, message, ok, no, null);
    }

    public static void showAlert(Context context, String title, String message, String ok, String no, IDialogCallback callback) {
        showAlert(context, title, message, ok, no, -1, -1, callback);
    }

    public static void showAlert(Context context, String title, String message, String ok, String no, int okColor, int noColor, final IDialogCallback callback) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    }
                })
                .setNegativeButton(no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (callback != null) {
                            callback.onClick(false);
                        }
                    }
                }).show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        if (okColor == -1) {
            okColor = AppUtils.getColor(R.color.color_black);
        }

        if (noColor == -1) {
            noColor = AppUtils.getColor(R.color.color_black);
        }

        positiveButton.setTextColor(okColor);
        negativeButton.setTextColor(noColor);
    }
}

