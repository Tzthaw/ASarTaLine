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
import android.widget.Toast;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.activities.HomeActivity;
import com.example.ptut.asartaline.fragments.base.BaseFragment;
import com.example.ptut.asartaline.mvp.presenter.LoginUserPresenter;
import com.example.ptut.asartaline.mvp.view.LoginUserView;
import com.example.ptut.asartaline.persistence.vos.LoginVO;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements LoginUserView {

    @BindView(R.id.email_input_edit)
    EditText emailEdit;
    @BindView(R.id.password_input_edit)
    EditText passwordEdit;

    private LoginUserPresenter loginUserPresenter;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);

        loginUserPresenter = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(LoginUserPresenter.class);
        loginUserPresenter.initPresenter(this);
        loginUserPresenter.getUserLoginData().observe(this, new Observer<LoginVO>() {
            @Override
            public void onChanged(LoginVO loginVO) {
                assert loginVO != null;
                Snackbar.make(Objects.requireNonNull(getView()), "Successful Login!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(HomeActivity.newIntent(getContext()));
                getActivity().finish();
            }
        });
        loginUserPresenter.getErrorLD().observe(this, this);
        return view;
    }

    @OnClick(R.id.login_btn)
    public void OnLoginClick() {
        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        if (email.equals("")) {
            emailEdit.setError("Please fill data");
        }
        if(password.equals("")){
            passwordEdit.setError("Please fill data");
        }else{
            loginUserPresenter.onFinishLoginSetup(email, password);
        }
    }

    @Override
    public void onChanged(@Nullable String errorMsg) {
        super.onChanged(errorMsg);
    }

    @Override
    protected void displayErrorMsg(String errorMsg) {
        super.displayErrorMsg(errorMsg);
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
