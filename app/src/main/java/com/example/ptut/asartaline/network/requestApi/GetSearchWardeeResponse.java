package com.example.ptut.asartaline.network.requestApi;

import com.example.ptut.asartaline.network.base.BaseResponse;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;

import java.util.List;

public class GetSearchWardeeResponse extends BaseResponse {
    private String tasteType;
    private String suited;
    private String minPrice;
    private String maxPrice;
    private String isNearBy;
    private String currentTownship;
    private String currentTLat;
    private String currentTLng;
    private List<AstlWarDeeItem> searchResults;

    public String getTasteType() {
        return tasteType;
    }

    public void setTasteType(String tasteType) {
        this.tasteType = tasteType;
    }

    public String getSuited() {
        return suited;
    }

    public void setSuited(String suited) {
        this.suited = suited;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getIsNearBy() {
        return isNearBy;
    }

    public void setIsNearBy(String isNearBy) {
        this.isNearBy = isNearBy;
    }

    public String getCurrentTownship() {
        return currentTownship;
    }

    public void setCurrentTownship(String currentTownship) {
        this.currentTownship = currentTownship;
    }

    public String getCurrentTLat() {
        return currentTLat;
    }

    public void setCurrentTLat(String currentTLat) {
        this.currentTLat = currentTLat;
    }

    public String getCurrentTLng() {
        return currentTLng;
    }

    public void setCurrentTLng(String currentTLng) {
        this.currentTLng = currentTLng;
    }

    public List<AstlWarDeeItem> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<AstlWarDeeItem> searchResults) {
        this.searchResults = searchResults;
    }
}
