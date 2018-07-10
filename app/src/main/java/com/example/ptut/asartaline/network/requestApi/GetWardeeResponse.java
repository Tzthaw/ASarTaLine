package com.example.ptut.asartaline.network.requestApi;

import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.network.base.BaseResponse;

import java.util.List;

public class GetWardeeResponse extends BaseResponse {

	private List<AstlWarDeeItem> astlWarDee;

	public void setAstlWarDee(List<AstlWarDeeItem> astlWarDee){
		this.astlWarDee = astlWarDee;
	}

	public List<AstlWarDeeItem> getAstlWarDee(){
		return astlWarDee;
	}



}