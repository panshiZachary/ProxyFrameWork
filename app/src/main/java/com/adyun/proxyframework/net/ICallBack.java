package com.adyun.proxyframework.net;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public interface ICallBack {

    void onSuccess(String result);

    void onFailure(int statusCode,Throwable t);
}
