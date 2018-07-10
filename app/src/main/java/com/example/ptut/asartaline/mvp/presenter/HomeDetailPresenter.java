package com.example.ptut.asartaline.mvp.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.ptut.asartaline.models.WardeeModel;
import com.example.ptut.asartaline.mvp.presenter.base.BasePresenter;
import com.example.ptut.asartaline.mvp.view.HomeDetailView;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

import java.util.List;

public class HomeDetailPresenter extends BasePresenter<HomeDetailView> {

    MutableLiveData<List<AstlMealShopItem>> mMealShopListLD;

    @Override
    public void initPresenter(HomeDetailView mView) {
        super.initPresenter(mView);
        mMealShopListLD = new MutableLiveData<>();
    }

    public LiveData<AstlWarDeeItem> onFinishDetailSetup(String id) {
        return WardeeModel.getInstance().getWardeeItemById(id);
    }

}
