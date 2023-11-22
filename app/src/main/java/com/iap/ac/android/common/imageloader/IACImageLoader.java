package com.iap.ac.android.common.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public interface IACImageLoader {

    /* loaded from: classes8.dex */
    public interface Callback {
        void onLoadFailure(Throwable th);

        void onLoadSuccess(Drawable drawable);
    }

    void loadImage(ImageView imageView, String str, Drawable drawable);

    void loadImageAsync(Context context, int i, int i2, String str, Callback callback);
}
