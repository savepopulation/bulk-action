package com.raqun.bulkaction;

/**
 * Created by tyln on 15/04/2017.
 */

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.raqun.bulkaction.util.ValidationUtil;


/**
 * Created by tyln on 16/01/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected static final int NAVIGATION_ROOT = 0;
    protected static final int NAVIGATION_BACK = 1;

    @LayoutRes
    protected abstract int getLayoutRes();

    @StringRes
    protected abstract int getTitleRes();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        setupActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenuRes() != Constants.NO_RES) {
            getMenuInflater().inflate(getMenuRes(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @UiThread
    public final void setActionbarTitle(@Nullable CharSequence title) {
        if (!ValidationUtil.isNullOrEmpty(title)) {
            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(title);
            }
        }
    }

    @UiThread
    private void setupActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (getTitleRes() != Constants.NO_RES) {
                final String title = getString(getTitleRes());
                setActionbarTitle(title);
            }

            switch (getNavigationType()) {
                case NAVIGATION_BACK:
                    actionBar.setDisplayHomeAsUpEnabled(true);
                    break;

                default:
                    actionBar.setDisplayHomeAsUpEnabled(false);
                    break;
            }
        }
    }

    @MenuRes
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    protected int getNavigationType() {
        return Constants.NO_RES;
    }
}