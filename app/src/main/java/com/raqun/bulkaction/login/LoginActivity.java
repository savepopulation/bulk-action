package com.raqun.bulkaction.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.raqun.bulkaction.BaseActivity;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.actions.ActionsActivity;
import com.raqun.bulkaction.util.AlertUtil;

/**
 * Created by tyln on 15/04/2017.
 */

public final class LoginActivity extends BaseActivity {
    private static final String KEY_ACCESS_TOKEN = "access_token=";

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    @Override
    protected int getScreenName() {
        return Constants.NO_RES;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_login;
    }

    @Override
    protected int getNavigationType() {
        return NAVIGATION_ROOT;
    }

    private ProgressDialog mProgressDialogLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialogLogin = AlertUtil.createProgressDialog(this,
                getString(R.string.dialog_message_logging_in),
                false);

        final WebView webViewLogin = (WebView) findViewById(R.id.webview_login);
        webViewLogin.getSettings().setJavaScriptEnabled(true);
        webViewLogin.getSettings().setDomStorageEnabled(true);
        webViewLogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains(KEY_ACCESS_TOKEN)) {
                    startActivity(ActionsActivity.newIntent(LoginActivity.this));
                }
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (mProgressDialogLogin != null && mProgressDialogLogin.isShowing()) {
                    mProgressDialogLogin.dismiss();
                }
            }
        });

        mProgressDialogLogin.show();
        webViewLogin.loadUrl(Constants.LOGIN_URL);
    }

    @Override
    protected void onDestroy() {
        if (mProgressDialogLogin != null && mProgressDialogLogin.isShowing()) {
            mProgressDialogLogin.dismiss();
        }
        super.onDestroy();
    }

    private String getAccessTokenFromURL(@NonNull String url) {
        final int index = url.indexOf(KEY_ACCESS_TOKEN);
        return url.substring(index + KEY_ACCESS_TOKEN.length());
    }
}
