package com.auth.demo.util;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.auth.demo.DemoApplication;

/**
 * 吐司弹出工具
 *
 * @author kimi
 */
public class ToastUtils {
    private static Toast mToast;

    public static void showToast(int resID) {
        showToast(DemoApplication.mAppContext, Toast.LENGTH_SHORT, resID);
    }

    public static void showToast(String text) {
        showToast(DemoApplication.mAppContext, Toast.LENGTH_SHORT, text);
    }

    public static void showToast(Context ctx, int resID) {
        showToast(ctx, Toast.LENGTH_SHORT, resID);
    }

    public static void showToast(Context ctx, String text) {
        showToast(ctx, Toast.LENGTH_SHORT, text);
    }

    public static void showLongToast(Context ctx, int resID) {
        showToast(ctx, Toast.LENGTH_LONG, resID);
    }

    public static void showLongToast(int resID) {
        showToast(DemoApplication.mAppContext, Toast.LENGTH_LONG, resID);
    }

    /**
     * @Title: showToastNoRepeat @Description: 解决Toast重复显示的问题 @param @param text
     * 设定文件 @return void 返回类型 @throws
     */
    public static void showToastNoRepeat(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(DemoApplication.mAppContext, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * @Title: showToastNoRepeat @Description: 解决Toast重复显示的问题 @param resID 设定文件
     * 的资源Id @return void 返回类型 @throws
     */
    public static void showToastNoRepeat(int resID) {
        showToastNoRepeat(DemoApplication.mAppContext.getString(resID));
    }

    /**
     * @Title: showLongToastNoRepeat @Description: 解决Toast重复显示的问题 @param resID
     * 设定文件 的资源Id @return void 返回类型 @throws
     */
    public static void showLongToastNoRepeat(int resID) {
        showToastNoRepeat(DemoApplication.mAppContext.getString(resID));
    }

    /**
     * @Title: showLongToastNoRepeat @Description: 解决Toast重复显示的问题 @param @param
     * text 设定文件 @return void 返回类型 @throws
     */
    public static void showLongToastNoRepeat(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(DemoApplication.mAppContext, text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    /**
     * @Title: cancelToast @Description: 按返回键调用 @param 设定文件 @return void
     * 返回类型 @throws
     */
    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public static void showLongToast(Context ctx, String text) {
        showToast(ctx, Toast.LENGTH_LONG, text);
    }

    public static void showLongToast(String text) {
        showToast(DemoApplication.mAppContext, Toast.LENGTH_LONG, text);
    }

    public static void showToast(Context ctx, int duration, int resID) {
        showToast(ctx, duration, ctx.getString(resID));
    }

    public static void showToast(Context ctx, int duration, String text) {
        // Toast toast = Toast.makeText(ctx, text, duration);
        // View mNextView = toast.getView();
        // if (mNextView != null)
        // mNextView.setBackgroundResource(R.drawable.toast_frame);
        // toast.show();
        Toast.makeText(ctx, text, duration).show();
    }

    // public static void showToastOnUiThread(final String text) {
    // showToastOnUiThread(FSAppliction.getCurrentActivity(), text);
    // }

    /**
     * 在UI线程运行弹出
     */
    public static void showToastOnUiThread(final Activity ctx, final String text) {
        if (ctx != null) {
            ctx.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    showToast(ctx, text);
                }
            });
        }
    }
}
