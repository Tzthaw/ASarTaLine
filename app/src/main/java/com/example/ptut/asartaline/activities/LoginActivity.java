package com.example.ptut.asartaline.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.TransitionInflater;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.activities.base.BaseActivity;
import com.example.ptut.asartaline.deligate.ErrorListener;
import com.example.ptut.asartaline.fragments.LoginFragment;
import com.example.ptut.asartaline.fragments.SignUpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity{

    @BindView(R.id.login_layout)
    RelativeLayout mLoginLayout;
    @BindView(R.id.signUp_Layout)
    RelativeLayout mSignUpLayout;
    @BindView(R.id.container_fragment)
    FrameLayout mFrameLayout;
    @BindView(R.id.login)
    TextView loginTextView;
    @BindView(R.id.signUp)
    TextView signUpTextView;

    private Animation animShow,animHide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this,this);
        navigateToLogin();
    }


    @OnClick(R.id.login_layout)
    public void onLoginClick(){
        initAnimation();
        mLoginLayout.setVisibility(View.GONE);
        mSignUpLayout.setVisibility(View.VISIBLE);
        signUpTextView.setAnimation(animShow);
        loginTextView.setAnimation(animHide);
        navigateToLogin();
    }

    @OnClick(R.id.signUp_Layout)
    public void onSignUpClick(){
        initAnimation();
        mSignUpLayout.setVisibility(View.GONE);
        mLoginLayout.setVisibility(View.VISIBLE);
        loginTextView.setAnimation(animShow);
        signUpTextView.setAnimation(animHide);
        navigateToSignUp();
    }

    private void navigateToSignUp() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in,0);
        transaction.replace(R.id.container_fragment, SignUpFragment.newInstance())
                .addToBackStack(null).commit();
    }
    private void navigateToLogin() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in,0);
        transaction.replace(R.id.container_fragment, LoginFragment.newInstance())
                .addToBackStack(null).commit();
    }


    private void initAnimation()
    {
        animShow = AnimationUtils.loadAnimation( this, R.anim.view_show);
        animHide = AnimationUtils.loadAnimation( this, R.anim.view_hide);
    }


}
