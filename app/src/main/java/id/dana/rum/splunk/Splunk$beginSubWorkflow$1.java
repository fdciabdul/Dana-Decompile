package id.dana.rum.splunk;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import io.opentelemetry.api.trace.Span;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/opentelemetry/api/trace/Span;", "workflow", "", BridgeDSL.INVOKE, "(Lio/opentelemetry/api/trace/Span;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class Splunk$beginSubWorkflow$1 extends Lambda implements Function1<Span, Unit> {
    final /* synthetic */ Pair<String, Object>[] $$attributes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Splunk$beginSubWorkflow$1(Pair<String, ? extends Object>[] pairArr) {
        super(1);
        this.$$attributes = pairArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Span span) {
        invoke2(span);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Span span) {
        Intrinsics.checkNotNullParameter(span, "");
        Pair<String, Object>[] pairArr = this.$$attributes;
        if (pairArr.length == 0) {
            return;
        }
        for (Pair<String, Object> pair : pairArr) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 instanceof String) {
                span.setAttribute(component1, (String) component2);
            } else if (component2 instanceof Boolean) {
                span.setAttribute(component1, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Long) {
                span.setAttribute(component1, ((Number) component2).longValue());
            } else if (component2 instanceof Double) {
                span.setAttribute(component1, ((Number) component2).doubleValue());
            }
        }
    }
}
