package com.mohan.internal.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mohan.internal.retrofitexample.retrofit.JsonParser;
import com.mohan.internal.retrofitexample.retrofit.NetworkCall;
import com.mohan.internal.retrofitexample.retrofit.RestClient;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        return;
    }

    public void makeNetworkCall(View view) {

        Retrofit retrofit = RestClient.getClient();
        String apiToken = "v5CXXRF1nsyEAFs2shT3hcynsHEA2yVpPmoxk4oNLkdGKP2ci3RYupX7vSxu";

        NetworkCall networkCall = retrofit.create(NetworkCall.class);
        networkCall.makeCall(apiToken).enqueue(new JsonParser());
    }

}
