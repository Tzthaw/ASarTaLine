package com.example.ptut.asartaline.mvp.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.ptut.asartaline.deligate.WardeeItemTap;
import com.example.ptut.asartaline.models.WardeeModel;
import com.example.ptut.asartaline.mvp.presenter.base.BasePresenter;
import com.example.ptut.asartaline.mvp.view.HomeView;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

import java.util.List;

public class HomePresenter  extends BasePresenter<HomeView> implements WardeeItemTap{

    MutableLiveData<List<AstlWarDeeItem>> mWardeeLD;
    @Override
    public void initPresenter(HomeView mView) {
        super.initPresenter(mView);
        mWardeeLD=new MutableLiveData<>();
        WardeeModel.getInstance().loadWardeeData(mWardeeLD,mErrorLD);
    }

    public MutableLiveData<List<AstlWarDeeItem>> getmWardeeLD() {
        return mWardeeLD;
    }


    @Override
    public void onTapItem(AstlWarDeeItem astlWarDeeItem) {
        mView.lunchWardeeDetail(astlWarDeeItem);
    }
}
