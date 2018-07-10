package com.example.ptut.asartaline.network;

import com.example.ptut.asartaline.network.requestApi.GetLoginResponse;
import com.example.ptut.asartaline.network.requestApi.GetMealShopResponse;
import com.example.ptut.asartaline.network.requestApi.GetSignUpResponse;
import com.example.ptut.asartaline.network.requestApi.GetWardeeResponse;
import com.example.ptut.asartaline.persistence.vos.SignUpVO;

import java.util.ArrayList;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ASarTaLineApi {

    @FormUrlEncoded
    @POST("loginUser.php")
    Observable<GetLoginResponse> checkLoginUser(
            @Field("email_phone") String email_phone, @Field("password") String password);

    @FormUrlEncoded
    @POST("registerUser.php")
    Observable<GetSignUpResponse> getSignUpInfo(@Field("new_user") String new_user);

    @FormUrlEncoded
    @POST("GetWarDee.php")
    Observable<GetWardeeResponse> loadWardee(@Field("access_token") String access_token);

    @FormUrlEncoded
    @POST("GetMealShop.php")
    Observable<GetMealShopResponse> loadMealShop(@Field("access_token") String access_token);

}
