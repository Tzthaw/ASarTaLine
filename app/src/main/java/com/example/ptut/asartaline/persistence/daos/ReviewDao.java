package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.ReviewsItem;

import java.util.List;

@Dao
public interface ReviewDao extends BaseDao<ReviewsItem> {
    @Query("SELECT * FROM review WHERE shopFId=:shopFId")
    List<ReviewsItem> getReviewById(String shopFId);
}
