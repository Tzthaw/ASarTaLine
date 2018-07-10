package com.example.ptut.asartaline.persistence.vos.mealshopvos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.ptut.asartaline.persistence.ImagesTypeConvertor;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

import java.util.List;

@Entity(tableName = "astlMealShop")
@TypeConverters(ImagesTypeConvertor.class)
public class AstlMealShopItem{
	@PrimaryKey
	@NonNull
	private String shopId;
	private String address;
	private double lng;
	@Ignore
	private List<ReviewsItem> reviews;
	private double popularity;
	private String name;
	private List<String> shopImages;
	private double lat;
	private String township;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setReviews(List<ReviewsItem> reviews){
		this.reviews = reviews;
	}

	public List<ReviewsItem> getReviews(){
		return reviews;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setShopImages(List<String> shopImages){
		this.shopImages = shopImages;
	}

	public List<String> getShopImages(){
		return shopImages;
	}

	public void setShopId(String shopId){
		this.shopId = shopId;
	}

	public String getShopId(){
		return shopId;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	public void setTownship(String township){
		this.township = township;
	}

	public String getTownship(){
		return township;
	}

	@Override
 	public String toString(){
		return 
			"AstlMealShopItem{" + 
			"address = '" + address + '\'' + 
			",lng = '" + lng + '\'' + 
			",reviews = '" + reviews + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",name = '" + name + '\'' + 
			",shopImages = '" + shopImages + '\'' + 
			",shopId = '" + shopId + '\'' + 
			",lat = '" + lat + '\'' + 
			",township = '" + township + '\'' + 
			"}";
		}
}