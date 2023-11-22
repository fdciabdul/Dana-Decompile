package com.ipification.mobile.sdk.im.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lcom/ipification/mobile/sdk/im/network/RedirectInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "PlaceComponentResult", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RedirectInterceptor implements Interceptor {
    private String PlaceComponentResult;

    public RedirectInterceptor(String str) {
        Intrinsics.checkParameterIsNotNull(str, "");
        this.PlaceComponentResult = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r2, r10.PlaceComponentResult, false, 2, (java.lang.Object) null) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c A[LOOP:0: B:34:0x00d1->B:56:0x011c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e A[EDGE_INSN: B:59:0x011e->B:57:0x011e BREAK  A[LOOP:0: B:34:0x00d1->B:56:0x011c], SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r11) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.network.RedirectInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
