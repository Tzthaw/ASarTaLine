package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "MatchWardeeListItem")
public class MatchWarDeeListItem{
	@PrimaryKey
	@NonNull
	private String warDeeId;

	public void setWarDeeId(String warDeeId){
		this.warDeeId = warDeeId;
	}

	public String getWarDeeId(){
		return warDeeId;
	}

	@Override
 	public String toString(){
		return 
			"MatchWarDeeListItem{" + 
			"warDeeId = '" + warDeeId + '\'' + 
			"}";
		}
}
