package com.iap.ac.android.region.cdp.delegate;

import android.content.Context;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public interface ImageService {

    /* loaded from: classes8.dex */
    public interface CallBack {
        void onFail(String str);

        void onSuccess(String str);
    }

    void loadImage(Context context, String str, ImageView imageView, CallBack callBack);
}
