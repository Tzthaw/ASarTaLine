package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByDistanceItem;

import java.util.List;

@Dao
public interface ShopByDistanceDao extends BaseDao<ShopByDistanceItem> {
    @Query("SELECT * FROM  shopDistanceItem WHERE warDeeFId=:wardeeId")
    List<ShopByDistanceItem> getShopDistanceList(String wardeeId);

    @Query("DELETE FROM shopDistanceItem")
    void deleteAll();
}
