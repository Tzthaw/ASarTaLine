package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.MealShop;

import java.util.List;

@Dao
public interface MealShopDao extends BaseDao<MealShop> {
    @Query("SELECT * FROM  mealShop WHERE distanceFId=:distanceFId")
    MealShop getShopDistanceMeal(String distanceFId);

    @Query("SELECT * FROM  mealShop WHERE popularFId=:popularFId")
    MealShop getShopPopularMeal(String popularFId);

    @Query("DELETE FROM mealShop")
    void deleteAll();
}
