package com.twilio.verify.data;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "p0", "", "p1", "", "PlaceComponentResult", "([BI)Ljava/lang/String;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class Base64EncoderKt {
    public static final String PlaceComponentResult(byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "");
        byte[] encode = Base64.encode(bArr, i);
        Intrinsics.checkExpressionValueIsNotNull(encode, "");
        return new String(encode, Charsets.UTF_8);
    }
}
