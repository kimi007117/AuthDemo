package com.kimi.login.sdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by lijie24 on 2017/10/19.
 */

public class AuthActivity extends Activity {
    private String mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("gjlogin://login?data=345"));
            startActivityForResult(intent, 2);
        } catch (Exception e) {
            mContent = "跳转M页";
            finish();
//            Toast.makeText(AuthActivity.this, "跳转M页", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 成功
            mContent = "成功";
        } else {
            mContent = "失败";
        }
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        GanJiAuth.getInstance().complete("ssss", "fdjkfjdkfjd", mContent);
    }
}
