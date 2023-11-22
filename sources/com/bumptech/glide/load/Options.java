package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class Options implements Key {
    public final ArrayMap<Option<?>, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new CachedHashCodeArrayMap();

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(((Options) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            int i2 = i << 1;
            Option option = (Option) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i2];
            option.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(option.PlaceComponentResult(), this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i2 + 1], messageDigest);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Options{values=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('}');
        return sb.toString();
    }
}
