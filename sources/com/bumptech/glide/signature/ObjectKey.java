package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class ObjectKey implements Key {
    private final Object KClassImpl$Data$declaredNonStaticMembers$2;

    public ObjectKey(Object obj) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Preconditions.PlaceComponentResult(obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectKey{object=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('}');
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(((ObjectKey) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        messageDigest.update(this.KClassImpl$Data$declaredNonStaticMembers$2.toString().getBytes(MyBillsEntityDataFactory));
    }
}
