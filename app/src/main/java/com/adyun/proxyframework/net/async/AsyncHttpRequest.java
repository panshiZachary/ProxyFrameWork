package com.adyun.proxyframework.net.async;

import android.support.v4.app.NavUtils;

import com.adyun.proxyframework.net.HttpRequest;
import com.adyun.proxyframework.net.ICallBack;
import com.loopj.android.http.AsyncHttpClient;

import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public class AsyncHttpRequest implements HttpRequest {

    private AsyncHttpClient asyncHttpClient;

    public AsyncHttpRequest() {
        asyncHttpClient = new AsyncHttpClient();
    }

    @Override
    public void get(String url, Map<String, String> params, final ICallBack callBack) {
        StringBuffer sb = new StringBuffer("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        url += sb.toString();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                 callBack.onSuccess(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
               callBack.onFailure(statusCode,error);
            }
        });

    }

    @Override
    public void post(String url, Map<String, String> params, ICallBack callBack) {

    }
}
