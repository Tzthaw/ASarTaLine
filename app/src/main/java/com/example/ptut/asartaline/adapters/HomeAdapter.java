package com.example.ptut.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.adapters.base.BaseRecyclerAdapter;
import com.example.ptut.asartaline.deligate.WardeeItemTap;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.viewholders.HomeViewHolder;

public class HomeAdapter extends BaseRecyclerAdapter<HomeViewHolder,AstlWarDeeItem> {
    private WardeeItemTap wTapListener;
    public HomeAdapter(Context context,WardeeItemTap wTapListener) {
        super(context);
        this.wTapListener=wTapListener;
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflator.inflate(R.layout.content_home_items,parent,false);
        return new HomeViewHolder(view,wTapListener);
    }

}
