package com.facebook.flipper.plugins.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lcom/facebook/flipper/plugins/network/FlipperOkhttpInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/facebook/flipper/plugins/network/NetworkFlipperPlugin;", "MyBillsEntityDataFactory", "Lcom/facebook/flipper/plugins/network/NetworkFlipperPlugin;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lcom/facebook/flipper/plugins/network/NetworkFlipperPlugin;)V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class FlipperOkhttpInterceptor implements Interceptor {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NetworkFlipperPlugin BuiltInFictitiousFunctionClassFactory;

    public FlipperOkhttpInterceptor(NetworkFlipperPlugin networkFlipperPlugin) {
        Intrinsics.checkNotNullParameter(networkFlipperPlugin, "");
        this.BuiltInFictitiousFunctionClassFactory = networkFlipperPlugin;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.proceed(p0.request());
    }
}
