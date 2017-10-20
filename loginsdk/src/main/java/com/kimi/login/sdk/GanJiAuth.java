package com.kimi.login.sdk;

import android.content.Context;
import android.content.Intent;

/**
 * Created by lijie24 on 2017/10/19.
 */

public class GanJiAuth {
    private static final GanJiAuth mAuth = new GanJiAuth();
    private OnGanJiAuthListener mOnGanJiAuthListener;

    private GanJiAuth() {
    }

    public static GanJiAuth getInstance() {
        return mAuth;
    }

    public void login(String appId, Context context, OnGanJiAuthListener onGanJiAuthListener) {
        mOnGanJiAuthListener = onGanJiAuthListener;
        try {
            Intent schemeIntent = new Intent(context, AuthActivity.class);
            schemeIntent.putExtra("app_id", appId);
            context.startActivity(schemeIntent);
        } catch (Exception e) {
//            Toast.makeText(context, "ActivityNotFoundException", Toast.LENGTH_SHORT).show();
            mOnGanJiAuthListener.onComplete(null, null, "ActivityNotFoundException");
        }
    }

    public void complete(String url, String token, String error) {
        if (mOnGanJiAuthListener != null) {
            mOnGanJiAuthListener.onComplete(url, token, error);
        }
    }

    public interface OnGanJiAuthListener {
        void onComplete(String url, String token, String error);
    }
}
