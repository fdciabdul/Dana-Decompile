package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class FitCenter extends BitmapTransformation {
    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(MyBillsEntityDataFactory);

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1572326941;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.getAuthRequestContext(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
