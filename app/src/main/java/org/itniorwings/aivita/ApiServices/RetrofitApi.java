package org.itniorwings.aivita.ApiServices;



import org.itniorwings.aivita.model.RegisterModel;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitApi {


   /* @POST("login")
    @FormUrlEncoded
    Call<LoginModel> login(
            @Field("email") String email,
            @Field("password") String password);*/

/*    @POST("user_reg")
    @FormUrlEncoded
    Call<RegisterModel> Register(
            @Field("email") String email,
            @Field("username ") String username,
            @Field("phone") String phone,
            @Field("password") String password

    );*/
@POST("user_reg")
Call<String> Register (@Body RequestBody body);



}