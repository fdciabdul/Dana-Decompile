package com.alibaba.ariver.kernel.api.image;

import android.graphics.Bitmap;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface IImageProxy extends Proxiable {

    /* loaded from: classes6.dex */
    public interface ImageListener {
        void onImageFinish(Bitmap bitmap);
    }

    void loadImage(String str, ImageListener imageListener);
}
