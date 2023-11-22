package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class AndroidResourceSignature implements Key {
    private final Key KClassImpl$Data$declaredNonStaticMembers$2;
    private final int getAuthRequestContext;

    public static Key getAuthRequestContext(Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.getAuthRequestContext(context));
    }

    private AndroidResourceSignature(int i, Key key) {
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = key;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (obj instanceof AndroidResourceSignature) {
            AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
            return this.getAuthRequestContext == androidResourceSignature.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2.equals(androidResourceSignature.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Util.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.getAuthRequestContext).array());
    }
}
