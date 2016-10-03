package com.mohan.internal.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mohan.internal.retrofitexample.retrofit.NetworkCall;
import com.mohan.internal.retrofitexample.retrofit.RestClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        networkCall.makeCall(apiToken).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: "+response.body());
                try {
                    JSONObject jsonObject=new JSONObject(response.body());
                    Log.d(TAG, "onResponse: "+jsonObject.getString("status"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

   /* private void logJsonPayload(Object object) { //Log JSON String
        try {
            ObjectWriter ow = new ObjectMapper().writer();
            String jsonPayload = ow.writeValueAsString(object);
            Log.d("!!!", "JSON Payload: " + jsonPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }*/

    public JSONObject getBytesFromInputStream(InputStream is) throws IOException {

        String json;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            json = "";
        }

        // try parse the string to a JSON object
        JSONObject jObj;
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
            jObj = new JSONObject();
        }

        // return JSON String
        return jObj;
    }
}
