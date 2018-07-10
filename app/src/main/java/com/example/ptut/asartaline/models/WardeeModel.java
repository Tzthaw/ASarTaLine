package com.example.ptut.asartaline.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.ptut.asartaline.models.base.BaseModel;
import com.example.ptut.asartaline.network.requestApi.GetMealShopResponse;
import com.example.ptut.asartaline.network.requestApi.GetWardeeResponse;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.ReviewsItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.GeneralTasteItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.MatchWarDeeListItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.MealShop;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByDistanceItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByPopularityItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.SuitedForItem;
import com.example.ptut.asartaline.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class WardeeModel extends BaseModel {

    private List<AstlMealShopItem> mMealShopList;
    private List<AstlWarDeeItem> mWardeeList;
    private static WardeeModel objInstance;

    protected WardeeModel(Context context) {
        super(context);
    }

    public static void initNewsModel(Context context) {
        objInstance = new WardeeModel(context);
    }

    public static WardeeModel getInstance() {
        if (objInstance == null) {
            throw new RuntimeException("UserLogin is being invoked before initializing.");
        }
        return objInstance;
    }

    public void loadWardeeData(final MutableLiveData<List<AstlWarDeeItem>> mWardeeLD,
                               final MutableLiveData<String> errorLD) {
        theApi.loadWardee(Constants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetWardeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetWardeeResponse getWardeeResponse) {
                        if (getWardeeResponse != null && getWardeeResponse.getAstlWarDee().size() > 0) {
                            saveWardeeData(getWardeeResponse.getAstlWarDee());
                            mWardeeLD.setValue(getWardeeResponse.getAstlWarDee());
                            Log.e("Wardee LD", getWardeeResponse.getAstlWarDee().toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void loadMealShopList(final MutableLiveData<List<AstlMealShopItem>> mMealShopListLD,
                                 final MutableLiveData<String> errorLD) {
        theApi.loadMealShop(Constants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMealShopResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMealShopResponse getMealShopResponse) {
                        if (getMealShopResponse != null && getMealShopResponse.getAstlMealShop().size() > 0) {
                            saveMealShopList(getMealShopResponse.getAstlMealShop());
                            mMealShopListLD.setValue(getMealShopResponse.getAstlMealShop());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void saveMealShopList(List<AstlMealShopItem> astlMealShopItems) {
        List<ReviewsItem> reviewsItems = new ArrayList<>();
        for (AstlMealShopItem mealShopItem : astlMealShopItems) {
            for (ReviewsItem reviewsItem : mealShopItem.getReviews()) {
                reviewsItem.setShopFId(mealShopItem.getShopId());
                reviewsItems.add(reviewsItem);
            }
        }

        long[] mealListIds = mAppDatabase.mealShopListDao().insertAll(astlMealShopItems);
        Log.e("MealListIds", Arrays.toString(mealListIds));
        long[] reviewIds = mAppDatabase.reviewDao().insertAll(reviewsItems);
        Log.e("ReviewId", Arrays.toString(reviewIds));
    }

    private void saveWardeeData(List<AstlWarDeeItem> astlWarDeeItems) {
        List<GeneralTasteItem> generalTasteItems = new ArrayList<>();
        List<MatchWarDeeListItem> matchWarDeeListItems = new ArrayList<>();
        List<ShopByDistanceItem> shopByDistanceItems = new ArrayList<>();
        List<ShopByPopularityItem> shopByPopularityItems = new ArrayList<>();
        List<SuitedForItem> suitedForItems = new ArrayList<>();

        for (AstlWarDeeItem warDeeItem : astlWarDeeItems) {
            String wardeeId = warDeeItem.getWarDeeId();
            for (GeneralTasteItem generalTasteItem : warDeeItem.getGeneralTaste()) {
                generalTasteItem.setWarDeeFId(wardeeId);
                generalTasteItems.add(generalTasteItem);
            }
            matchWarDeeListItems.addAll(warDeeItem.getMatchWarDeeList());
            for (ShopByPopularityItem shopByPopularityItem : warDeeItem.getShopByPopularity()) {
                shopByPopularityItem.setWarDeeFId(wardeeId);
                shopByPopularityItem.getMealShop().setPopularFId(shopByPopularityItem.getShopByPopularityId());
                shopByPopularityItems.add(shopByPopularityItem);
            }
            for (ShopByDistanceItem shopByDistanceItem : warDeeItem.getShopByDistance()) {
                shopByDistanceItem.setWarDeeFId(wardeeId);
                shopByDistanceItem.getMealShop().setDistanceFId(shopByDistanceItem.getShopByDistanceId());
                shopByDistanceItems.add(shopByDistanceItem);
            }
            for (SuitedForItem suitedForItem : warDeeItem.getSuitedFor()) {
                suitedForItem.setWarDeeFId(wardeeId);
                suitedForItems.add(suitedForItem);
            }
        }
        long[] astlId = mAppDatabase.astlWardeeItemDao().insertAll(astlWarDeeItems);
        Log.e("astlIds:", Arrays.toString(astlId));
        long[] tasteId = mAppDatabase.tasteItemDao().insertAll(generalTasteItems);
        Log.e("tasteIds:", Arrays.toString(tasteId));
        long[] matchId = mAppDatabase.matchItemListDao().insertAll(matchWarDeeListItems);
        Log.e("matchId:", Arrays.toString(matchId));
        long[] shopByPopularId = mAppDatabase.shopByPopularDao().insertAll(shopByPopularityItems);
        Log.e("shopPoopularId:", Arrays.toString(shopByPopularId));
        long[] shopDistanceId = mAppDatabase.shopByDistanceDao().insertAll(shopByDistanceItems);
        Log.e("shopDistanceItem:", Arrays.toString(shopDistanceId));
        long[] suitedId = mAppDatabase.suitedItemDao().insertAll(suitedForItems);
        Log.e("suitedId:", Arrays.toString(suitedId));
    }

    public LiveData<AstlWarDeeItem> getWardeeItemById(final String id) {
        final MutableLiveData<AstlWarDeeItem> astlWardeeItemLD = new MutableLiveData<>();
        mAppDatabase.astlWardeeItemDao().getProductById(id).observeForever(new android.arch.lifecycle.Observer<AstlWarDeeItem>() {
            @Override
            public void onChanged(@Nullable AstlWarDeeItem astlWarDeeItem) {
                if (astlWarDeeItem != null) {
                    astlWarDeeItem.setMatchWarDeeList(mAppDatabase.matchItemListDao().getmatchWardeeList(id));
                    astlWarDeeItem.setGeneralTaste(mAppDatabase.tasteItemDao().getTasteItemList(id));

                    astlWarDeeItem.setShopByDistance(mAppDatabase.shopByDistanceDao().getShopDistanceList(id));
                    astlWarDeeItem.setShopByPopularity(mAppDatabase.shopByPopularDao().getShopPopularList(id));
                    for (ShopByDistanceItem distanceItem : astlWarDeeItem.getShopByDistance()) {
                        String distanceId = distanceItem.getShopByDistanceId();
                        distanceItem.setMealShop(mAppDatabase.mealShopDao().getShopDistanceMeal(distanceId));
                    }
                    for (ShopByPopularityItem shopByPopularityItem : astlWarDeeItem.getShopByPopularity()) {
                        String popularId = shopByPopularityItem.getShopByPopularityId();
                        shopByPopularityItem.setMealShop(mAppDatabase.mealShopDao().getShopPopularMeal(popularId));
                    }
                    astlWarDeeItem.setSuitedFor(mAppDatabase.suitedItemDao().getSuitedItemList(id));
                    astlWardeeItemLD.setValue(astlWarDeeItem);
                }
            }
        });
        return astlWardeeItemLD;
    }




}
