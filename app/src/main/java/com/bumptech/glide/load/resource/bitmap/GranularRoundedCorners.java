package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class GranularRoundedCorners extends BitmapTransformation {
    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(MyBillsEntityDataFactory);
    private final float PlaceComponentResult = 0.0f;
    private final float getAuthRequestContext;
    private final float getErrorConfigVersion;
    private final float lookAheadTest;

    public GranularRoundedCorners(float f, float f2, float f3) {
        this.lookAheadTest = f;
        this.getErrorConfigVersion = f2;
        this.getAuthRequestContext = f3;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.BuiltInFictitiousFunctionClassFactory(bitmapPool, bitmap, this.lookAheadTest, this.getErrorConfigVersion, this.getAuthRequestContext, this.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof GranularRoundedCorners) {
            GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
            return this.lookAheadTest == granularRoundedCorners.lookAheadTest && this.getErrorConfigVersion == granularRoundedCorners.getErrorConfigVersion && this.getAuthRequestContext == granularRoundedCorners.getAuthRequestContext && this.PlaceComponentResult == granularRoundedCorners.PlaceComponentResult;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Util.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, Util.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, Util.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, Util.getAuthRequestContext(-2013597734, Util.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest)))));
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(KClassImpl$Data$declaredNonStaticMembers$2);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.lookAheadTest).putFloat(this.getErrorConfigVersion).putFloat(this.getAuthRequestContext).putFloat(this.PlaceComponentResult).array());
    }
}
