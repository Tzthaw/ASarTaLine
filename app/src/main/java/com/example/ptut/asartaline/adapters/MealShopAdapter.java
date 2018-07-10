package com.example.ptut.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.adapters.base.BaseRecyclerAdapter;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
import com.example.ptut.asartaline.viewholders.MealShopViewHolder;

public class MealShopAdapter extends BaseRecyclerAdapter<MealShopViewHolder,AstlMealShopItem> {
    public MealShopAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public MealShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflator.inflate(R.layout.view_mealshop_list,parent,false);
        return new MealShopViewHolder(view);
    }
}
