package id.dana.rum.quake;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/rum/quake/QuakeTracing;", "", "Lio/opentelemetry/instrumentation/api/instrumenter/Instrumenter;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "PlaceComponentResult", "Lio/opentelemetry/instrumentation/api/instrumenter/Instrumenter;", "MyBillsEntityDataFactory", "Lio/opentelemetry/context/propagation/ContextPropagators;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/opentelemetry/context/propagation/ContextPropagators;", "p0", "p1", "<init>", "(Lio/opentelemetry/instrumentation/api/instrumenter/Instrumenter;Lio/opentelemetry/context/propagation/ContextPropagators;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QuakeTracing {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ContextPropagators PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Instrumenter<Request, NetworkResponse> MyBillsEntityDataFactory;

    public QuakeTracing(Instrumenter<Request, NetworkResponse> instrumenter, ContextPropagators contextPropagators) {
        Intrinsics.checkNotNullParameter(instrumenter, "");
        Intrinsics.checkNotNullParameter(contextPropagators, "");
        this.MyBillsEntityDataFactory = instrumenter;
        this.PlaceComponentResult = contextPropagators;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/rum/quake/QuakeTracing$Companion;", "", "Lio/opentelemetry/api/OpenTelemetry;", "p0", "Lid/dana/rum/quake/QuakeTracingBuilder;", "BuiltInFictitiousFunctionClassFactory", "(Lio/opentelemetry/api/OpenTelemetry;)Lid/dana/rum/quake/QuakeTracingBuilder;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static QuakeTracingBuilder BuiltInFictitiousFunctionClassFactory(OpenTelemetry p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new QuakeTracingBuilder(p0);
        }
    }
}
