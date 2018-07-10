package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByPopularityItem;

import java.util.List;

@Dao
public interface ShopByPopularDao extends BaseDao<ShopByPopularityItem> {
    @Query("SELECT * FROM  shopPopularItem WHERE warDeeFId=:wardeeId")
    List<ShopByPopularityItem> getShopPopularList(String wardeeId);

    @Query("DELETE FROM shopPopularItem")
    void deleteAll();
}
