package com.adyun.proxyframework.image;

import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by Zachary
 * on 2019/3/2.
 */
public class ImageLoaderPresenter implements ImageLoader {

    private static volatile ImageLoaderPresenter instance;
    private ImageLoader imageLoader;

    public ImageLoaderPresenter(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public static void init(ImageLoader imageLoader){
        if (instance == null){
            synchronized (ImageLoaderPresenter.class){
                if (instance == null){
                    instance = new ImageLoaderPresenter(imageLoader);
                }
            }
        }
    }

    public static ImageLoaderPresenter getInstance() {
        return instance;
    }

    @Override
    public void dispalyImage(Activity activity, String imageUrl, ImageView imageView) {
        imageLoader.dispalyImage(activity,imageUrl,imageView);
    }
}
