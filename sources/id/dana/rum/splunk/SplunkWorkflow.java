package id.dana.rum.splunk;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.rum.Rum;
import io.opentelemetry.api.trace.Span;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/rum/splunk/SplunkWorkflow;", "Lid/dana/rum/Rum$Workflow;", "", "PlaceComponentResult", "()V", "Lkotlin/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "Lio/opentelemetry/api/trace/Span;", "getAuthRequestContext", "Lio/opentelemetry/api/trace/Span;", "p0", "p1", "<init>", "(Lio/opentelemetry/api/trace/Span;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplunkWorkflow implements Rum.Workflow {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Span PlaceComponentResult;

    public SplunkWorkflow(Span span, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(span, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = span;
        this.MyBillsEntityDataFactory = function0;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.rum.splunk.SplunkWorkflow$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    @Override // id.dana.rum.Rum.Workflow
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.end();
        this.MyBillsEntityDataFactory.invoke();
    }
}
