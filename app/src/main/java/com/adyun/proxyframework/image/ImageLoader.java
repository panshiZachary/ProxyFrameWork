package com.adyun.proxyframework.image;

import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public interface ImageLoader {
    /**
     *
     * @param activity
     * @param imageUrl
     * @param imageView
     */
    void dispalyImage(Activity activity, String imageUrl, ImageView imageView);
}
