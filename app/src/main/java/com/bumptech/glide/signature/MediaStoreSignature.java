package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class MediaStoreSignature implements Key {
    private final long KClassImpl$Data$declaredNonStaticMembers$2;
    private final String PlaceComponentResult;
    private final int getAuthRequestContext;

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.KClassImpl$Data$declaredNonStaticMembers$2 == mediaStoreSignature.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext == mediaStoreSignature.getAuthRequestContext && this.PlaceComponentResult.equals(mediaStoreSignature.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.getAuthRequestContext;
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.KClassImpl$Data$declaredNonStaticMembers$2).putInt(this.getAuthRequestContext).array());
        messageDigest.update(this.PlaceComponentResult.getBytes(MyBillsEntityDataFactory));
    }
}
