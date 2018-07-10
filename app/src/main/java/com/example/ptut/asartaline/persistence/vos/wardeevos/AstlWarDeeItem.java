package com.example.ptut.asartaline.persistence.vos.wardeevos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;


import com.example.ptut.asartaline.persistence.ImagesTypeConvertor;

import java.util.List;



@Entity(tableName = "AstlWarDeeItem")
@TypeConverters(ImagesTypeConvertor.class)
public class AstlWarDeeItem{
    @PrimaryKey
    @NonNull
    private String warDeeId;
    private int priceRangeMin;
    @Ignore
    private List<MatchWarDeeListItem> matchWarDeeList;

    private List<String> images;
    @Ignore
    private List<GeneralTasteItem> generalTaste;
    @Ignore
    private List<ShopByPopularityItem> shopByPopularity;
    @Ignore
    private List<ShopByDistanceItem> shopByDistance;
    private String name;
    @Ignore
    private List<SuitedForItem> suitedFor;
    private int priceRangeMax;

    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setMatchWarDeeList(List<MatchWarDeeListItem> matchWarDeeList) {
        this.matchWarDeeList = matchWarDeeList;
    }

    public List<MatchWarDeeListItem> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setGeneralTaste(List<GeneralTasteItem> generalTaste) {
        this.generalTaste = generalTaste;
    }

    public List<GeneralTasteItem> getGeneralTaste() {
        return generalTaste;
    }

    public void setShopByPopularity(List<ShopByPopularityItem> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }

    public List<ShopByPopularityItem> getShopByPopularity() {
        return shopByPopularity;
    }

    public void setShopByDistance(List<ShopByDistanceItem> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public List<ShopByDistanceItem> getShopByDistance() {
        return shopByDistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSuitedFor(List<SuitedForItem> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public List<SuitedForItem> getSuitedFor() {
        return suitedFor;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    @Override
    public String toString() {
        return
                "AstlWarDeeItem{" +
                        "priceRangeMin = '" + priceRangeMin + '\'' +
                        ",matchWarDeeList = '" + matchWarDeeList + '\'' +
                        ",images = '" + images + '\'' +
                        ",generalTaste = '" + generalTaste + '\'' +
                        ",shopByPopularity = '" + shopByPopularity + '\'' +
                        ",shopByDistance = '" + shopByDistance + '\'' +
                        ",name = '" + name + '\'' +
                        ",suitedFor = '" + suitedFor + '\'' +
                        ",warDeeId = '" + warDeeId + '\'' +
                        ",priceRangeMax = '" + priceRangeMax + '\'' +
                        "}";
    }
}