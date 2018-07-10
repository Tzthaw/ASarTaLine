package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "suitedItem",foreignKeys = @ForeignKey(entity = AstlWarDeeItem.class,
		parentColumns = "warDeeId",childColumns = "warDeeFId",onDelete=CASCADE))
public class SuitedForItem{
	private String suitedForDesc;
	@PrimaryKey
	@NonNull
	private String suitedForId;
	private String suitedFor;
	private String warDeeFId;

	public String getWarDeeFId() {
		return warDeeFId;
	}

	public void setWarDeeFId(String warDeeFId) {
		this.warDeeFId = warDeeFId;
	}

	public void setSuitedForDesc(String suitedForDesc){
		this.suitedForDesc = suitedForDesc;
	}

	public String getSuitedForDesc(){
		return suitedForDesc;
	}

	public void setSuitedForId(String suitedForId){
		this.suitedForId = suitedForId;
	}

	public String getSuitedForId(){
		return suitedForId;
	}

	public void setSuitedFor(String suitedFor){
		this.suitedFor = suitedFor;
	}

	public String getSuitedFor(){
		return suitedFor;
	}

	@Override
 	public String toString(){
		return 
			"SuitedForItem{" + 
			"suitedForDesc = '" + suitedForDesc + '\'' + 
			",suitedForId = '" + suitedForId + '\'' + 
			",suitedFor = '" + suitedFor + '\'' + 
			"}";
		}
}
