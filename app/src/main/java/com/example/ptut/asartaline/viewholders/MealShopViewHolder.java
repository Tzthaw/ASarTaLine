package com.example.ptut.asartaline.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
import com.example.ptut.asartaline.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class MealShopViewHolder extends BaseViewHolder<AstlMealShopItem> {
    @BindView(R.id.mealshop_img)
    ImageView mealshopImg;
    @BindView(R.id.mealshop_name)
    TextView mealShopName;
    public MealShopViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(AstlMealShopItem data) {
        Glide.with(itemView)
                .load(data.getShopImages().get(0))
                .into(mealshopImg);
        mealShopName.setText(data.getName());
    }

    @Override
    public void onClick(View v) {

    }
}
