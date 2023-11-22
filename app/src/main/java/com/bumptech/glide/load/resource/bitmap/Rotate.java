package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class Rotate extends BitmapTransformation {
    private static final byte[] PlaceComponentResult = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(MyBillsEntityDataFactory);
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.MyBillsEntityDataFactory(bitmap, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.KClassImpl$Data$declaredNonStaticMembers$2 == ((Rotate) obj).KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.getAuthRequestContext(-950519196, Util.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(PlaceComponentResult);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.KClassImpl$Data$declaredNonStaticMembers$2).array());
    }
}
