package id.dana.data.network.interceptor;

import id.dana.data.network.constant.CashierHeader;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/network/interceptor/CashierInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierInterceptor implements Interceptor {
    @Inject
    public CashierInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Request.Builder newBuilder = p0.request().newBuilder();
        newBuilder.addHeader(CashierHeader.CASHIER_3DS_TITLE, CashierHeader.CASHIER_3DS_VALUE);
        Response proceed = p0.proceed(newBuilder.build());
        Intrinsics.checkNotNullExpressionValue(proceed, "");
        return proceed;
    }
}
