package com.example.ptut.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.activities.base.BaseActivity;
import com.example.ptut.asartaline.adapters.HomeAdapter;
import com.example.ptut.asartaline.components.EmptyViewPod;
import com.example.ptut.asartaline.models.WardeeModel;
import com.example.ptut.asartaline.mvp.presenter.HomePresenter;
import com.example.ptut.asartaline.mvp.view.HomeView;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeView{

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.app_bar) AppBarLayout appBarLayout;;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.data_recycler)RecyclerView dataRecycler;
    @BindView(R.id.empty_layout)EmptyViewPod emptyLayout;

    HomePresenter homePresenter;
    HomeAdapter homeAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_new);
        ButterKnife.bind(this,this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        homePresenter= ViewModelProviders.of(this).get(HomePresenter.class);
        homePresenter.initPresenter(this);
        homeAdapter=new HomeAdapter(this,homePresenter);
        dataRecycler.setLayoutManager(new LinearLayoutManager(this));
        dataRecycler.setAdapter(homeAdapter);

        homePresenter.getmWardeeLD().observe(this, new Observer<List<AstlWarDeeItem>>() {
            @Override
            public void onChanged(@Nullable List<AstlWarDeeItem> astlWarDeeItems) {
                homeAdapter.setNewData(astlWarDeeItems);
            }
        });
        homePresenter.getErrorLD().observe(this,this);
    }

    @Override
    public void onChanged(@Nullable String s) {
        super.onChanged(s);
    }

    @Override
    public void displayErrorMessage(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void lunchWardeeDetail(AstlWarDeeItem astlWarDeeItem) {
        startActivity(HomDetailActivity.newIntent(this,astlWarDeeItem.getWarDeeId()));
    }
}
