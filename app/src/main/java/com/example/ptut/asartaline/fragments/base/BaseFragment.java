package com.example.ptut.asartaline.fragments.base;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


/**
 * Created by aung on 6/13/17.
 */

public abstract class BaseFragment extends Fragment implements Observer<String> {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            readArguments(bundle);
        }

        if (savedInstanceState != null) {
            readArguments(savedInstanceState);
        }

    }

    protected void readArguments(Bundle bundle) {

    }

    @Override
    public void onChanged(@Nullable String errorMsg) {
        displayErrorMsg(errorMsg);
    }

    protected void displayErrorMsg(String errorMsg) {

    }
}
