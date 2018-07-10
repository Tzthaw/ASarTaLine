package com.example.ptut.asartaline.activities;

import android.annotation.SuppressLint;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.activities.base.BaseActivity;
import com.example.ptut.asartaline.adapters.MealShopAdapter;
import com.example.ptut.asartaline.models.WardeeModel;
import com.example.ptut.asartaline.mvp.presenter.HomeDetailPresenter;
import com.example.ptut.asartaline.mvp.view.HomeDetailView;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByDistanceItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByPopularityItem;
import com.example.ptut.asartaline.utils.Constants;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("Registered")
public class HomDetailActivity extends BaseActivity implements HomeDetailView {

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    @BindView(R.id.details_appbar)
    AppBarLayout appBarLayout;
    ;
    @BindView(R.id.details_collapsing)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.detail_img_slider)
    SliderLayout detailSliderLayout;
    @BindView(R.id.wardee_item_title)
    TextView wardeeTitle;
    @BindView(R.id.wardee_price)
    TextView wardeePrice;
    @BindView(R.id.detail_taste)
    TextView wardeeTaste;
    @BindView(R.id.wardee_desc)
    TextView wardeeDesc;

    private HomeDetailPresenter homeDetailPresenter;
    public static Intent newIntent(Context context, String wardeeId) {
        Intent intent = new Intent(context, HomDetailActivity.class);
        intent.putExtra(Constants.WARDEE_ID, wardeeId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details);
        ButterKnife.bind(this, this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        String wardeeId = getIntent().getStringExtra(Constants.WARDEE_ID);
        homeDetailPresenter = ViewModelProviders.of(this).get(HomeDetailPresenter.class);
        homeDetailPresenter.initPresenter(this);
        homeDetailPresenter.onFinishDetailSetup(wardeeId);
        homeDetailPresenter.onFinishDetailSetup(wardeeId).observe(this, new Observer<AstlWarDeeItem>() {
            @Override
            public void onChanged(@Nullable AstlWarDeeItem astlWarDeeItem) {
                setDetailView(astlWarDeeItem);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void setDetailView(AstlWarDeeItem astlWarDeeItem) {
        setImageSlider(astlWarDeeItem);
        wardeeTitle.setText(astlWarDeeItem.getName());
        wardeePrice.setText("Ks: " + astlWarDeeItem.getPriceRangeMin() + "~" + astlWarDeeItem.getPriceRangeMax());
        wardeeTaste.setText(astlWarDeeItem.getGeneralTaste().get(0).getTaste());
        wardeeDesc.setText(astlWarDeeItem.getGeneralTaste().get(0).getTasteDesc());
    }

    public void setImageSlider(AstlWarDeeItem astlWarDeeItem) {
        detailSliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        detailSliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :
        for (int i = 0; i < astlWarDeeItem.getImages().size(); i++) {
            SliderView sliderViewItem = new SliderView(this);
            sliderViewItem.setImageUrl(astlWarDeeItem.getImages().get(i));
            detailSliderLayout.addSliderView(sliderViewItem);
        }
    }
}
