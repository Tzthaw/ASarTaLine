package com.example.ptut.asartaline.mvp.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.ptut.asartaline.models.UserLoginModel;
import com.example.ptut.asartaline.mvp.presenter.base.BasePresenter;
import com.example.ptut.asartaline.mvp.view.LoginUserView;
import com.example.ptut.asartaline.mvp.view.base.BaseView;
import com.example.ptut.asartaline.persistence.vos.LoginVO;
import com.example.ptut.asartaline.persistence.vos.SignUpVO;

public class LoginUserPresenter extends BasePresenter<LoginUserView> {

    private MutableLiveData<LoginVO> mLoginLD;
    private MutableLiveData<SignUpVO> mSingUpLD;

    @Override
    public void initPresenter(LoginUserView mView) {
        super.initPresenter(mView);
        mLoginLD=new MutableLiveData<>();
        mSingUpLD=new MutableLiveData<>();
    }

    public void onFinishLoginSetup(String email,String password){
        UserLoginModel.getInstance().checkUser(mLoginLD,mErrorLD,email,password);
    }

    public void onFinishSetup(SignUpVO singUpInfo){
        UserLoginModel.getInstance().getSignUpUserInfo(mSingUpLD,mErrorLD,singUpInfo);
    }

    public LiveData<LoginVO> getUserLoginData(){
        return mLoginLD;
    }
    public LiveData<SignUpVO> getSignUpInfo(){
        return mSingUpLD;
    }

}
