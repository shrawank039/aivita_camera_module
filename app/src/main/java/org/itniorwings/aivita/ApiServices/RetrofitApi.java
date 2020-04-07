package org.itniorwings.aivita.ApiServices;



import org.itniorwings.aivita.model.RegisterModel;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RetrofitApi {

    @Multipart
    @POST("RegisterModel")
    Call<RegisterModel> Register(@Part("username") RequestBody username,
                                 @Part("email") RequestBody email,
                                 @Part("phone") RequestBody phone,
                                 @Part("password") RequestBody password ,

                                 @Part("fileToUpload\"; filename=\"profile.jpg") RequestBody image

    );
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
/*@POST("user_reg")
Call<String> Register (@Body RequestBody body);*/



}