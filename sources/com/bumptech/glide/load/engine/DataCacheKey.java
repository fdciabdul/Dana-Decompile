package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class DataCacheKey implements Key {
    private final Key PlaceComponentResult;
    private final Key getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.PlaceComponentResult = key;
        this.getAuthRequestContext = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            return this.PlaceComponentResult.equals(dataCacheKey.PlaceComponentResult) && this.getAuthRequestContext.equals(dataCacheKey.getAuthRequestContext);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return (this.PlaceComponentResult.hashCode() * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataCacheKey{sourceKey=");
        sb.append(this.PlaceComponentResult);
        sb.append(", signature=");
        sb.append(this.getAuthRequestContext);
        sb.append('}');
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        this.PlaceComponentResult.getAuthRequestContext(messageDigest);
        this.getAuthRequestContext.getAuthRequestContext(messageDigest);
    }
}
