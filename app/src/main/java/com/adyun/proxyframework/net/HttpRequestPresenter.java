package com.adyun.proxyframework.net;

import android.content.Context;

import java.util.Map;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public class HttpRequestPresenter implements HttpRequest{

    private static volatile HttpRequestPresenter instance;
    private HttpRequest httpRequest;

    private HttpRequestPresenter(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public static void init(HttpRequest httpRequest){
        if (instance == null){
            synchronized (HttpRequestPresenter.class){
                if (instance == null){
                    instance = new HttpRequestPresenter(httpRequest);
                }
            }
        }
    }

    public static HttpRequestPresenter getInstance() {
        return instance;
    }

    @Override
    public void get(String url, Map<String, String> params, ICallBack callBack) {
        httpRequest.get(url,params,callBack);
    }

    @Override
    public void post(String url, Map<String, String> params, ICallBack callBack) {
        httpRequest.post(url,params,callBack);

    }
}
