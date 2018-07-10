package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "tasteItem",foreignKeys = @ForeignKey(entity = AstlWarDeeItem.class,
			parentColumns = "warDeeId",childColumns = "warDeeFId"))
public class GeneralTasteItem{
	@PrimaryKey
	@NonNull
	private String tasteId;
	private String taste;
	private String tasteDesc;
	private String warDeeFId;

	public String getWarDeeFId() {
		return warDeeFId;
	}

	public void setWarDeeFId(String warDeeFId) {
		this.warDeeFId = warDeeFId;
	}

	public void setTasteId(String tasteId){
		this.tasteId = tasteId;
	}

	public String getTasteId(){
		return tasteId;
	}

	public void setTaste(String taste){
		this.taste = taste;
	}

	public String getTaste(){
		return taste;
	}

	public void setTasteDesc(String tasteDesc){
		this.tasteDesc = tasteDesc;
	}

	public String getTasteDesc(){
		return tasteDesc;
	}

	@Override
 	public String toString(){
		return 
			"GeneralTasteItem{" + 
			"tasteId = '" + tasteId + '\'' + 
			",taste = '" + taste + '\'' + 
			",tasteDesc = '" + tasteDesc + '\'' + 
			"}";
		}
}
