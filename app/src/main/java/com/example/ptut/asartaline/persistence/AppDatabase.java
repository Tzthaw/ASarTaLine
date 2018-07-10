package com.example.ptut.asartaline.persistence;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ptut.asartaline.persistence.daos.AstlWardeeItemDao;
import com.example.ptut.asartaline.persistence.daos.MatchItemListDao;
import com.example.ptut.asartaline.persistence.daos.MealShopDao;
import com.example.ptut.asartaline.persistence.daos.MealShopListDao;
import com.example.ptut.asartaline.persistence.daos.ReviewDao;
import com.example.ptut.asartaline.persistence.daos.ShopByDistanceDao;
import com.example.ptut.asartaline.persistence.daos.ShopByPopularDao;
import com.example.ptut.asartaline.persistence.daos.SuitedItemDao;
import com.example.ptut.asartaline.persistence.daos.TasteItemDao;
import com.example.ptut.asartaline.persistence.vos.LoginVO;
import com.example.ptut.asartaline.persistence.vos.SignUpVO;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.AstlMealShopItem;
import com.example.ptut.asartaline.persistence.vos.mealshopvos.ReviewsItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.AstlWarDeeItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.GeneralTasteItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.MatchWarDeeListItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.MealShop;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByDistanceItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.ShopByPopularityItem;
import com.example.ptut.asartaline.persistence.vos.wardeevos.SuitedForItem;

@Database(entities = { AstlWarDeeItem.class, GeneralTasteItem.class, MatchWarDeeListItem.class
        , MealShop.class, ShopByDistanceItem.class, ShopByPopularityItem.class, SuitedForItem.class,
        AstlMealShopItem.class, ReviewsItem.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase appDatabase;
    public abstract AstlWardeeItemDao astlWardeeItemDao();
    public abstract TasteItemDao tasteItemDao();
    public abstract MatchItemListDao matchItemListDao();
    public abstract MealShopDao mealShopDao();
    public abstract ShopByDistanceDao shopByDistanceDao();
    public abstract ShopByPopularDao shopByPopularDao();
    public abstract SuitedItemDao suitedItemDao();
    public abstract MealShopListDao mealShopListDao();
    public abstract ReviewDao reviewDao();

    public static AppDatabase getInMemoryDatabase(Context context){
        if(appDatabase==null){
            appDatabase= Room.inMemoryDatabaseBuilder(context,AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public void destroyInDatabase(){
        appDatabase=null;
    }
}
