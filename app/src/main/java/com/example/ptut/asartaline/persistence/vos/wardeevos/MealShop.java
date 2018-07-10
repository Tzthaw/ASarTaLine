package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "mealShop",foreignKeys = {
		@ForeignKey(
				entity = ShopByPopularityItem.class,
				parentColumns = "shopByPopularityId",
				childColumns = "popularFId"
				,onDelete=CASCADE),
		@ForeignKey(
				entity = ShopByDistanceItem.class,
				parentColumns = "shopByDistanceId",
				childColumns = "distanceFId"
				,onDelete=CASCADE
		)})
public class MealShop{
	@PrimaryKey
	@NonNull
	private String mealShopId;
	private String popularFId;
	private String distanceFId;

	public String getPopularFId() {
		return popularFId;
	}

	public void setPopularFId(String popularFId) {
		this.popularFId = popularFId;
	}

	public String getDistanceFId() {
		return distanceFId;
	}

	public void setDistanceFId(String distanceFId) {
		this.distanceFId = distanceFId;
	}

	public void setMealShopId(String mealShopId){
		this.mealShopId = mealShopId;
	}

	public String getMealShopId(){
		return mealShopId;
	}

	@Override
 	public String toString(){
		return 
			"MealShop{" + 
			"mealShopId = '" + mealShopId + '\'' + 
			"}";
		}
}
