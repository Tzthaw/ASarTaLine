package com.example.ptut.asartaline.persistence.vos.mealshopvos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "review",foreignKeys = @ForeignKey(entity = AstlMealShopItem.class,
		parentColumns = "shopId",childColumns = "shopFId"))
public class ReviewsItem{
	@PrimaryKey
	@NonNull
	private String shopFId;
	private String userImage;
	private String review;
	private String userName;
	private String reviewId;
	private String userId;
	private String timestamp;


	@NonNull
	public String getShopFId() {
		return shopFId;
	}

	public void setShopFId(@NonNull String shopFId) {
		this.shopFId = shopFId;
	}

	public void setUserImage(String userImage){
		this.userImage = userImage;
	}

	public String getUserImage(){
		return userImage;
	}

	public void setReview(String review){
		this.review = review;
	}

	public String getReview(){
		return review;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setReviewId(String reviewId){
		this.reviewId = reviewId;
	}

	public String getReviewId(){
		return reviewId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"ReviewsItem{" + 
			"userImage = '" + userImage + '\'' + 
			",review = '" + review + '\'' + 
			",userName = '" + userName + '\'' + 
			",reviewId = '" + reviewId + '\'' + 
			",userId = '" + userId + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}
