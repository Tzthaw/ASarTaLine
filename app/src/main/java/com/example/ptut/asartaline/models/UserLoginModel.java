package com.example.ptut.asartaline.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.ptut.asartaline.models.base.BaseModel;
import com.example.ptut.asartaline.network.requestApi.GetLoginResponse;
import com.example.ptut.asartaline.network.requestApi.GetSignUpResponse;
import com.example.ptut.asartaline.persistence.vos.LoginVO;
import com.example.ptut.asartaline.persistence.vos.SignUpVO;
import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class UserLoginModel extends BaseModel {

    private static UserLoginModel objInstance;

    private UserLoginModel(Context context) {
        super(context);
    }

    public static void initNewsModel(Context context) {
        objInstance = new UserLoginModel(context);
    }

    public static UserLoginModel getInstance() {
        if (objInstance == null) {
            throw new RuntimeException("UserLogin is being invoked before initializing.");
        }
        return objInstance;
    }

    public void checkUser(final MutableLiveData<LoginVO> loginLD, final MutableLiveData<String> errorLD,
                          String email, String password) {
        theApi.checkLoginUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetLoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(GetLoginResponse getLoginResponse) {
                        if (getLoginResponse != null && getLoginResponse.getLoginUser()!=null) {
                            loginLD.setValue(getLoginResponse.getLoginUser());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getSignUpUserInfo(final MutableLiveData<SignUpVO> signUpLD, final MutableLiveData<String> errorLD
            , SignUpVO singUpInfo) {
        Gson gson = new Gson();

        // 2. Java object to JSON, and assign to a String
        String jsonInString = gson.toJson(singUpInfo);

        theApi.getSignUpInfo(jsonInString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetSignUpResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetSignUpResponse getSignUpResponse) {
                        if (getSignUpResponse != null && getSignUpResponse.getRegisteredUser() != null) {
                            signUpLD.setValue(getSignUpResponse.getRegisteredUser());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
