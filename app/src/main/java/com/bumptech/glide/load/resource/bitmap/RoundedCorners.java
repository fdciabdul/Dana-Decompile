package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class RoundedCorners extends BitmapTransformation {
    private static final byte[] getAuthRequestContext = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(MyBillsEntityDataFactory);
    private final int PlaceComponentResult;

    public RoundedCorners(int i) {
        Preconditions.BuiltInFictitiousFunctionClassFactory(i > 0, "roundingRadius must be greater than 0.");
        this.PlaceComponentResult = i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.getAuthRequestContext(bitmapPool, bitmap, this.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.PlaceComponentResult == ((RoundedCorners) obj).PlaceComponentResult;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Util.getAuthRequestContext(-569625254, Util.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(getAuthRequestContext);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.PlaceComponentResult).array());
    }
}
