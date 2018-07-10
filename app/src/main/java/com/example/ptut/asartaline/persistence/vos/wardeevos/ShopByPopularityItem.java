package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "shopPopularItem",foreignKeys = @ForeignKey(entity = AstlWarDeeItem.class,
		parentColumns = "warDeeId",childColumns = "warDeeFId",onDelete=CASCADE))
public class ShopByPopularityItem{
	@PrimaryKey
	@NonNull
	private String shopByPopularityId;
	@Ignore
	private MealShop mealShop;
	private String warDeeFId;

	public String getWarDeeFId() {
		return warDeeFId;
	}

	public void setWarDeeFId(String warDeeFId) {
		this.warDeeFId = warDeeFId;
	}

	public void setShopByPopularityId(String shopByPopularityId){
		this.shopByPopularityId = shopByPopularityId;
	}

	public String getShopByPopularityId(){
		return shopByPopularityId;
	}

	public void setMealShop(MealShop mealShop){
		this.mealShop = mealShop;
	}

	public MealShop getMealShop(){
		return mealShop;
	}

	@Override
 	public String toString(){
		return 
			"ShopByPopularityItem{" + 
			"shopByPopularityId = '" + shopByPopularityId + '\'' + 
			",mealShop = '" + mealShop + '\'' + 
			"}";
		}
}
