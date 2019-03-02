package com.adyun.proxyframework.image.picasso;

import android.app.Activity;
import android.widget.ImageView;

import com.adyun.proxyframework.image.ImageLoader;
import com.squareup.picasso.Picasso;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public class PicassoImageLoader implements ImageLoader {
    @Override
    public void dispalyImage(Activity activity, String imageUrl, ImageView imageView) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
