package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.MatchWarDeeListItem;

import java.util.List;

@Dao
public interface MatchItemListDao extends BaseDao<MatchWarDeeListItem> {
    @Query("SELECT * FROM  MatchWardeeListItem WHERE warDeeId=:wardeeId")
    List<MatchWarDeeListItem> getmatchWardeeList(String wardeeId);

    @Query("DELETE FROM MatchWardeeListItem")
    void deleteAll();
}
