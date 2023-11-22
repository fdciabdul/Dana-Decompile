package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public interface Key {
    public static final String BuiltInFictitiousFunctionClassFactory = "UTF-8";
    public static final Charset MyBillsEntityDataFactory = Charset.forName("UTF-8");

    boolean equals(Object obj);

    void getAuthRequestContext(MessageDigest messageDigest);

    int hashCode();
}
