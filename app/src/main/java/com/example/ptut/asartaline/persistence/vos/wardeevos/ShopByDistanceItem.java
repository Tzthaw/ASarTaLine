package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "shopDistanceItem",foreignKeys = @ForeignKey(entity = AstlWarDeeItem.class,
		parentColumns = "warDeeId",childColumns = "warDeeFId",onDelete=CASCADE))
public class ShopByDistanceItem{
	@PrimaryKey
	@NonNull
	private String shopByDistanceId;
	@Ignore
	private MealShop mealShop;
	private double distanceInFeet;
	private String warDeeFId;

	public String getWarDeeFId() {
		return warDeeFId;
	}

	public void setWarDeeFId(String warDeeFId) {
		this.warDeeFId = warDeeFId;
	}

	public void setShopByDistanceId(@NonNull String shopByDistanceId){
		this.shopByDistanceId = shopByDistanceId;
	}

	@NonNull
	public String getShopByDistanceId(){
		return shopByDistanceId;
	}

	public void setMealShop(MealShop mealShop){
		this.mealShop = mealShop;
	}

	public MealShop getMealShop(){
		return mealShop;
	}

	public void setDistanceInFeet(double distanceInFeet){
		this.distanceInFeet = distanceInFeet;
	}

	public double getDistanceInFeet(){
		return distanceInFeet;
	}

	@Override
 	public String toString(){
		return 
			"ShopByDistanceItem{" + 
			"shopByDistanceId = '" + shopByDistanceId + '\'' + 
			",mealShop = '" + mealShop + '\'' + 
			",distanceInFeet = '" + distanceInFeet + '\'' + 
			"}";
		}
}
