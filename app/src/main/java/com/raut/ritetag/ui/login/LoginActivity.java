package com.raut.ritetag.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.raut.pet_app.R;
import com.raut.ritetag.RiteKitApplication;
import com.raut.ritetag.core.api.APIInteface;
import com.raut.ritetag.core.bus.RxBus;
import com.raut.ritetag.core.db.DatabaseManager;
import com.raut.ritetag.core.db.SharedPrefs;
import com.raut.ritetag.ui.login.core.presenter.ILoginPresenter;
import com.raut.ritetag.ui.login.core.presenter.LoginPresenterImp;
import com.raut.ritetag.ui.login.core.view.ILoginView;
import com.raut.ritetag.ui.login.dagger.component.DaggerLoginComponent;
import com.raut.ritetag.ui.login.dagger.module.LoginModule;
import com.raut.ritetag.ui.trending.TrendingListActivity;
import com.raut.ritetag.utils.AppConstants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.login_button)
    LoginButton btnFbLogin;
    private CallbackManager callbackManager;

    @OnClick(R.id.btn_login)
    void onLoginUser() {
        SharedPrefs.setLoginStatus(context, AppConstants.LOGIN);
        iLoginPresenter.doLogin(context, etUserName.getText().toString(), etPassword.getText().toString());
        iLoginPresenter.clear();
    }

    @Inject
    ILoginPresenter iLoginPresenter;
    @Inject
    LoginPresenterImp loginPresenterImp;
    @Inject
    APIInteface apiInterApiInteface;
    @Inject
    RxBus rxBus;
    @Inject
    DatabaseManager databaseManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        ButterKnife.bind(this);
        initialiseDependencies();
        loginPresenterImp.onCreate();
        loginPresenterImp.onLoad(this);
        FacebookSdk.sdkInitialize(this);
        registerForLoginResponse();
        registerFbCallBack();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



    private void registerFbCallBack() {
        callbackManager = CallbackManager.Factory.create();
        btnFbLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent gotoList = new Intent(context, TrendingListActivity.class);
                startActivity(gotoList);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

        }
        });
    }

    /**
     * Method to initialise Dependencies
     */
    private void initialiseDependencies() {
        DaggerLoginComponent.builder()
                .apiComponent(RiteKitApplication.getAppComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenterImp.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenterImp.onResume();
    }

    @Override
    public void onClearText() {
        etUserName.setText("");
        etPassword.setText("");
    }

    @Override
    public void onLoginResult(boolean isValid) {
        SharedPrefs.setLoginStatus(context, AppConstants.LOGIN_COMPLETED);
        SharedPrefs.setActionType(context, true);
        //Intent i2 = new Intent(context, ContactsListActivity.class);
        // startActivity(i2);
        finish();
    }

    @Override
    public void onLoginError() {
        Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadRegisterActivity() {

    }

    /**
     * register for response for login
     */
    public void registerForLoginResponse() {
        loginPresenterImp.addDisposableObserver(RiteKitApplication.bus().toObservable().subscribeWith(new DisposableObserver<Object>() {
            @Override
            public void onNext(Object o) {
//                if (o instanceof UserAuthenticatedEvent) {
//                    Timber.i("User Logged In");
//                    loginPresenterImp.onSuccessfulLogin();
//                }
            }

            @Override
            public void onError(Throwable e) {
                Timber.i("LoginResponse > onError" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Timber.i("LoginResponse > onComplete");
            }
        }));
    }

}
