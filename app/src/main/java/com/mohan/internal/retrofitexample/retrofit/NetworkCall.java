package com.mohan.internal.retrofitexample.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by mohan on 2/10/16.
 */

public interface NetworkCall {

    @Headers({
            "Accept: application/vnd.myapp.v1+json",
    })
    @GET("/api/patient/records")
    Call<String> makeCall(@Query("api_token")String apiToken);
}
