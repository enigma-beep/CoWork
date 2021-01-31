package com.abhigyan.cowork;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("user/")
    Call<RegisterUserResponse> registerUser(@Body RegisterUserRequest registerUserRequest);

    @GET("user/{user_id}")
    Call<UserLoginResponse> getUser(@Path("user_id") int user_id);
}
