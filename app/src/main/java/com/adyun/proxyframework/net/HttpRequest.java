package com.adyun.proxyframework.net;

import java.util.Map;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public interface HttpRequest {

    void get(String url, Map<String, String> params,ICallBack callBack);

    void post(String url, Map<String, String> params,ICallBack callBack);
}
