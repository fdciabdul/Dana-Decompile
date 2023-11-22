package id.dana.data.holdlogin.v2.interceptor;

import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/data/holdlogin/v2/interceptor/OkhttpHoldLoginV2Interceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "p0", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "getAuthRequestContext", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OkhttpHoldLoginV2Interceptor implements Interceptor {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final HoldLoginConfig getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV2Interceptor MyBillsEntityDataFactory;

    @Inject
    public OkhttpHoldLoginV2Interceptor(HoldLoginV2Interceptor holdLoginV2Interceptor, HoldLoginConfig holdLoginConfig) {
        Intrinsics.checkNotNullParameter(holdLoginV2Interceptor, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        this.MyBillsEntityDataFactory = holdLoginV2Interceptor;
        this.getAuthRequestContext = holdLoginConfig;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(final Interceptor.Chain p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory() && this.getAuthRequestContext.getAuthRequestContext()) {
            final Request request = p0.request();
            HoldLoginV2Interceptor holdLoginV2Interceptor = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(request, "");
            holdLoginV2Interceptor.BuiltInFictitiousFunctionClassFactory(request);
            Response proceed = p0.proceed(request);
            HoldLoginV2Interceptor holdLoginV2Interceptor2 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(proceed, "");
            Object PlaceComponentResult = holdLoginV2Interceptor2.PlaceComponentResult(request, proceed, new Function0<Object>() { // from class: id.dana.data.holdlogin.v2.interceptor.OkhttpHoldLoginV2Interceptor$intercept$newResponse$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Interceptor.Chain.this.proceed(request);
                }
            });
            return (PlaceComponentResult == null || !(PlaceComponentResult instanceof Response)) ? proceed : (Response) PlaceComponentResult;
        }
        Response proceed2 = p0.proceed(p0.request());
        Intrinsics.checkNotNullExpressionValue(proceed2, "");
        return proceed2;
    }
}
