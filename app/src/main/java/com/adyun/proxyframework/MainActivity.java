package com.adyun.proxyframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.adyun.proxyframework.model.WeatherInfo;
import com.adyun.proxyframework.net.HttpRequestPresenter;
import com.adyun.proxyframework.net.ModelCallBack;
import com.adyun.proxyframework.net.async.AsyncHttpRequest;
import com.adyun.proxyframework.net.okhttp.OkHttpRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        http://restapi.amap.com/v3/weather/weatherInfo
//        city=长沙
//        key=13cb58f5884f9749287abbead9c658f2
        Map<String,String> params = new HashMap<>();
        params.put("city","长沙");
        params.put("key","13cb58f5884f9749287abbead9c658f2");
//        HttpRequestPresenter.init(new OkHttpRequest());
        HttpRequestPresenter.init(new AsyncHttpRequest());

        HttpRequestPresenter.getInstance().get("http://restapi.amap.com/v3/weather/weatherInfo", params,
                new ModelCallBack<WeatherInfo>() {
            @Override
            public void onFailure(int statusCode, Throwable t) {
               t.getStackTrace();
            }

            @Override
            public void onSuccess(WeatherInfo weatherInfo) {
                Log.e(TAG, "onSuccess: "+weatherInfo.toString());
            }
        });



    }
}
