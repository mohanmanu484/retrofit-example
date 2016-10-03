package com.mohan.internal.retrofitexample.retrofit;

import com.mohan.internal.retrofitexample.ToStringConverterFactory;

import retrofit2.Retrofit;

/**
 * Created by mohan on 3/10/16.
 */

public class RestClient {

    private static Retrofit retrofit;
    static String URL="http://ec2-52-221-227-182.ap-southeast-1.compute.amazonaws.com";
    //v5CXXRF1nsyEAFs2shT3hcynsHEA2yVpPmoxk4oNLkdGKP2ci3RYupX7vSxu


    public static Retrofit getClient(){
        if(retrofit==null){
             retrofit = new Retrofit.Builder    ()
                    .baseUrl(URL)
                     .addConverterFactory(new ToStringConverterFactory())
                    .build();
        }

        return retrofit;
    }
}
