package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class EmptySignature implements Key {
    private static final EmptySignature KClassImpl$Data$declaredNonStaticMembers$2 = new EmptySignature();

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
    }

    public final String toString() {
        return "EmptySignature";
    }

    public static EmptySignature MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private EmptySignature() {
    }
}
