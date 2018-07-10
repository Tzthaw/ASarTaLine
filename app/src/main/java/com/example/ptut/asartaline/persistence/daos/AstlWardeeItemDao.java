package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

import java.util.List;

@Dao
public interface AstlWardeeItemDao extends BaseDao<AstlWarDeeItem> {
    @Query("SELECT * FROM  AstlWarDeeItem")
    LiveData<List<AstlWarDeeItem>> getAstlWardeeList();

    @Query("SELECT * FROM AstlWarDeeItem WHERE `warDeeId` = :warDeeId")
    LiveData<AstlWarDeeItem> getProductById(String warDeeId);

    @Query("DELETE FROM AstlWarDeeItem")
    void deleteAll();
}
