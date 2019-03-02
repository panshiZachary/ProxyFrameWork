package com.adyun.proxyframework.image.glide;

import android.app.Activity;
import android.widget.ImageView;

import com.adyun.proxyframework.image.ImageLoader;
import com.bumptech.glide.Glide;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public class GlideImageLoader implements ImageLoader {
    @Override
    public void dispalyImage(Activity activity, String imageUrl, ImageView imageView) {
        Glide.with(activity).load(imageUrl).into(imageView);
    }
}
