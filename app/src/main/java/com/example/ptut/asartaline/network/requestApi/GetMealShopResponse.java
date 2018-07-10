package com.example.ptut.asartaline.network.requestApi;

import com.example.ptut.asartaline.network.base.BaseResponse;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;

import java.util.List;

public class GetMealShopResponse extends BaseResponse{
	private List<AstlMealShopItem> astlMealShop;


	public void setAstlMealShop(List<AstlMealShopItem> astlMealShop){
		this.astlMealShop = astlMealShop;
	}

	public List<AstlMealShopItem> getAstlMealShop(){
		return astlMealShop;
	}



}