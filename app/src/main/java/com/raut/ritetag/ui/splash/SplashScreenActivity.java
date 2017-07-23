package com.raut.ritetag.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.raut.pet_app.R;
import com.raut.ritetag.ui.login.LoginActivity;
import com.raut.ritetag.ui.splash.core.presenter.SplashScreenImpl;
import com.raut.ritetag.ui.splash.core.view.ISplashView;
import com.raut.ritetag.ui.trending.TrendingListActivity;

public class SplashScreenActivity extends AppCompatActivity implements ISplashView {

    private SplashScreenImpl splashScreenImpl;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        context = this;
        splashScreenImpl = new SplashScreenImpl(this);
        splashScreenImpl.onActivityLoad();
    }

    @Override
    public void launchAppropriate() {
        new android.os.Handler().postDelayed(
                () -> {
                    if (isLoggedIn()) {
                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.setClass(context, TrendingListActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.setClass(context, LoginActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }, 2000);
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
}
