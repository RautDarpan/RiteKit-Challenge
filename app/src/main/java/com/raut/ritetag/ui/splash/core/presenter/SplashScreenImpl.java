package com.raut.ritetag.ui.splash.core.presenter;

import com.raut.ritetag.ui.splash.core.view.ISplashView;

/**
 * Created by Raut Darpan on 03/05/17.
 */

public class SplashScreenImpl implements ISplashPresenter {


    private ISplashView iSplashView;

    public SplashScreenImpl(ISplashView iSplashView) {
        this.iSplashView = iSplashView;
    }

    @Override
    public void onActivityLoad() {
        iSplashView.launchAppropriate();
    }
}
