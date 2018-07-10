package com.example.ptut.asartaline.mvp.view;

import com.example.ptut.asartaline.mvp.view.base.BaseView;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

public interface HomeView extends BaseView {
    void lunchWardeeDetail(AstlWarDeeItem astlWarDeeItem);
}
