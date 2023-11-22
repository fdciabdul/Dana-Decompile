package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class CenterCrop extends BitmapTransformation {
    private static final byte[] getAuthRequestContext = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(MyBillsEntityDataFactory);

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -599754482;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.MyBillsEntityDataFactory(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(getAuthRequestContext);
    }
}
