package com.ipification.mobile.sdk.android.interceptor;

import com.ipification.mobile.sdk.android.IPConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ipification/mobile/sdk/android/interceptor/SdkLogInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SdkLogInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Request.Builder newBuilder = p0.request().newBuilder();
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        Response proceed = p0.proceed(newBuilder.header("IP-client-id", IPConfiguration.Companion.MyBillsEntityDataFactory().moveToNextValue).build());
        Intrinsics.checkExpressionValueIsNotNull(proceed, "");
        return proceed;
    }
}
