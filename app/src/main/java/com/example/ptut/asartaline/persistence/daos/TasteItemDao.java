package com.example.ptut.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.asartaline.persistence.daos.base.BaseDao;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.GeneralTasteItem;

import java.util.List;

@Dao
public interface TasteItemDao extends BaseDao<GeneralTasteItem> {
    @Query("SELECT * FROM  tasteitem WHERE warDeeFId=:wardeeId")
    List<GeneralTasteItem> getTasteItemList(String wardeeId);

    @Query("DELETE FROM tasteitem")
    void deleteAll();
}
