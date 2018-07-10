package com.example.ptut.asartaline.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.fragments.base.BaseFragment;
import com.example.ptut.asartaline.mvp.presenter.LoginUserPresenter;
import com.example.ptut.asartaline.mvp.view.LoginUserView;
import com.example.ptut.asartaline.persistence.vos.SignUpVO;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpFragment extends BaseFragment implements LoginUserView {

    @BindView(R.id.email_sign_edit)
    EditText emailEdit;
    @BindView(R.id.name_sign_edit)
    EditText nameEdit;
    @BindView(R.id.password_sign_edit)
    EditText passwordEdit;
    @BindView(R.id.phone_sign_edit)
    EditText phoneEdit;

    private LoginUserPresenter loginUserPresenter;
    String name, email, password, phoneNo;

    public static SignUpFragment newInstance() {
        Bundle args = new Bundle();
        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment, container, false);
        ButterKnife.bind(this, view);

        loginUserPresenter = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(LoginUserPresenter.class);
        loginUserPresenter.initPresenter(this);
        loginUserPresenter.getSignUpInfo().observe(this, new Observer<SignUpVO>() {
            @Override
            public void onChanged(@Nullable SignUpVO signUpVO) {
                assert signUpVO != null;
                Snackbar.make(Objects.requireNonNull(getView()), "Saved Successful", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();
            }
        });
        loginUserPresenter.getErrorLD().observe(this, this);
        return view;
    }

    @OnClick(R.id.signUp_btn)
    public void onSignUpClick() {
        SignUpVO signUpVO = new SignUpVO();
        name = emailEdit.getText().toString();
        email = nameEdit.getText().toString();
        password = passwordEdit.getText().toString();
        phoneNo = phoneEdit.getText().toString();
        if (name.equals("") && name == null) {
            nameEdit.setError("Please fill data");
        } else if (email.equals("") && email == null) {
            emailEdit.setError("Please fill data");
        } else if (password.equals("") && password == null) {
            passwordEdit.setError("Please fill data");
        } else if (phoneNo.equals("") && phoneNo == null) {
            phoneEdit.setError("Please fill data");
        } else {
            signUpVO.setEmail(emailEdit.getText().toString());
            signUpVO.setName(nameEdit.getText().toString());
            signUpVO.setPassword(passwordEdit.getText().toString());
            signUpVO.setPhoneNo(phoneEdit.getText().toString());
            loginUserPresenter.onFinishSetup(signUpVO);
        }

    }

    @Override
    public void onChanged(@Nullable String errorMsg) {
        super.onChanged(errorMsg);
    }

    @Override
    protected void displayErrorMsg(String errorMsg) {
        Snackbar.make(Objects.requireNonNull(getView()), errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
