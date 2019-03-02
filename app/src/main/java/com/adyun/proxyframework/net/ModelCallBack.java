package com.adyun.proxyframework.net;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public abstract class ModelCallBack<T> implements ICallBack {

    @Override
    public void onSuccess(String result) {
        Class<? extends T> geneticClass = getGeneticClass(this);
        T t = new Gson().fromJson(result, geneticClass);
        // 重现定向到 onSuccess
        onSuccess(t);
    }

    protected  Class<? extends T> getGeneticClass(Object object){
        // 获得带有泛型的直接类 ModelCallBack
        Type genericSuperclass = object.getClass().getGenericSuperclass();
        // ParameterizedType带参数的类型 泛型
        return (Class<? extends T>) ((ParameterizedType)genericSuperclass).getActualTypeArguments()[0];
    }

    public abstract void onSuccess(T t);

}
