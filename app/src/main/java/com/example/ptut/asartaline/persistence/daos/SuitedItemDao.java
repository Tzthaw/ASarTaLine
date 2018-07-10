package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.SuitedForItem;

import java.util.List;

@Dao
public interface SuitedItemDao extends BaseDao<SuitedForItem> {
    @Query("SELECT * FROM  suitedItem WHERE warDeeFId=:wardeeFId")
    List<SuitedForItem> getSuitedItemList(String wardeeFId);

    @Query("DELETE FROM suitedItem")
    void deleteAll();
}
