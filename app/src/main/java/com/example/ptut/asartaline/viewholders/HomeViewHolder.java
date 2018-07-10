package com.example.ptut.asartaline.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.ptut.asartaline.R;
import com.example.ptut.asartaline.deligate.WardeeItemTap;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class HomeViewHolder extends BaseViewHolder<AstlWarDeeItem> {
    @BindView(R.id.wardee_img)ImageView wardeeImg;
    @BindView(R.id.taste_list)TextView tasteTxt;
    @BindView(R.id.taste_desc)TextView tasteDesc;
    @BindView(R.id.wardee_price)TextView wardeePrice;
    @BindView(R.id.wardee_item_title)TextView wardeeTitle;
    private WardeeItemTap wTapListener;
    private AstlWarDeeItem astlWarDeeItem;

    public HomeViewHolder(View itemView,WardeeItemTap wTapListener) {
        super(itemView);
        this.wTapListener=wTapListener;
    }

    @Override
    public void setData(AstlWarDeeItem data) {
        astlWarDeeItem=data;
        Glide.with(itemView.getContext())
                .load(data.getImages().get(0))
                .into(wardeeImg);
        tasteTxt.setText(data.getGeneralTaste().get(0).getTaste());
        tasteDesc.setText(data.getGeneralTaste().get(0).getTasteDesc());
        wardeePrice.setText(data.getPriceRangeMin()+"~"+data.getPriceRangeMax());
        wardeeTitle.setText(data.getName());
    }

    @Override
    public void onClick(View v) {
        wTapListener.onTapItem(astlWarDeeItem);
    }
}
