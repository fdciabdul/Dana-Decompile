package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> getAuthRequestContext = new LruCache<>(50);
    private final ArrayPool KClassImpl$Data$declaredNonStaticMembers$2;
    private final Key NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Class<?> PlaceComponentResult;
    private final Transformation<?> getErrorConfigVersion;
    private final int initRecordTimeStamp;
    private final Key lookAheadTest;
    private final int moveToNextValue;
    private final Options scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayPool;
        this.lookAheadTest = key;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = key2;
        this.initRecordTimeStamp = i;
        this.moveToNextValue = i2;
        this.getErrorConfigVersion = transformation;
        this.PlaceComponentResult = cls;
        this.scheduleImpl = options;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof ResourceCacheKey) {
            ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
            return this.moveToNextValue == resourceCacheKey.moveToNextValue && this.initRecordTimeStamp == resourceCacheKey.initRecordTimeStamp && Util.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, resourceCacheKey.getErrorConfigVersion) && this.PlaceComponentResult.equals(resourceCacheKey.PlaceComponentResult) && this.lookAheadTest.equals(resourceCacheKey.lookAheadTest) && this.NetworkUserEntityData$$ExternalSyntheticLambda0.equals(resourceCacheKey.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.scheduleImpl.equals(resourceCacheKey.scheduleImpl);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        int hashCode = this.lookAheadTest.hashCode();
        int hashCode2 = (((((hashCode * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.initRecordTimeStamp) * 31) + this.moveToNextValue;
        Transformation<?> transformation = this.getErrorConfigVersion;
        if (transformation != null) {
            hashCode2 = (hashCode2 * 31) + transformation.hashCode();
        }
        return (((hashCode2 * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.scheduleImpl.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.initRecordTimeStamp).putInt(this.moveToNextValue).array();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(messageDigest);
        this.lookAheadTest.getAuthRequestContext(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.getErrorConfigVersion;
        if (transformation != null) {
            transformation.getAuthRequestContext(messageDigest);
        }
        this.scheduleImpl.getAuthRequestContext(messageDigest);
        messageDigest.update(KClassImpl$Data$declaredNonStaticMembers$2());
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
    }

    private byte[] KClassImpl$Data$declaredNonStaticMembers$2() {
        LruCache<Class<?>, byte[]> lruCache = getAuthRequestContext;
        byte[] MyBillsEntityDataFactory = lruCache.MyBillsEntityDataFactory((LruCache<Class<?>, byte[]>) this.PlaceComponentResult);
        if (MyBillsEntityDataFactory == null) {
            byte[] bytes = this.PlaceComponentResult.getName().getBytes(MyBillsEntityDataFactory);
            lruCache.getAuthRequestContext(this.PlaceComponentResult, bytes);
            return bytes;
        }
        return MyBillsEntityDataFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.lookAheadTest);
        sb.append(", signature=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", width=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", height=");
        sb.append(this.moveToNextValue);
        sb.append(", decodedResourceClass=");
        sb.append(this.PlaceComponentResult);
        sb.append(", transformation='");
        sb.append(this.getErrorConfigVersion);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.scheduleImpl);
        sb.append('}');
        return sb.toString();
    }
}
