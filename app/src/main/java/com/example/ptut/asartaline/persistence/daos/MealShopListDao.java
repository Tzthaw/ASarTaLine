package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
@Dao
public interface MealShopListDao extends BaseDao<AstlMealShopItem> {
    @Query("SELECT * FROM astlMealShop WHERE shopId=:popularId")
    LiveData<AstlMealShopItem> getMealPopular(String popularId);

    @Query("SELECT * FROM astlMealShop WHERE shopId=:distanceId")
    LiveData<AstlMealShopItem> getMealDistance(String distanceId);
}
