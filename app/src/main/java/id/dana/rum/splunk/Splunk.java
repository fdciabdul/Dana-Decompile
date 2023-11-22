package id.dana.rum.splunk;

import com.splunk.rum.SplunkRum;
import id.dana.rum.NoOpWorkflow;
import id.dana.rum.Rum;
import id.dana.rum.model.RumWorkflowException;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\bJC\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\bJC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u0013\u001a\u00020\u00052\n\u0010\u0003\u001a\u00060\u0011j\u0002`\u00122*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018"}, d2 = {"Lid/dana/rum/splunk/Splunk;", "Lid/dana/rum/Rum;", "", "p0", "p1", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "", "Lkotlin/Pair;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;[Lkotlin/Pair;)V", "Lid/dana/rum/Rum$Workflow;", "getAuthRequestContext", "(Ljava/lang/String;[Lkotlin/Pair;)Lid/dana/rum/Rum$Workflow;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "MyBillsEntityDataFactory", "(Ljava/lang/Exception;[Lkotlin/Pair;)V", "Ljava/util/HashMap;", "Lio/opentelemetry/api/trace/Span;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Splunk implements Rum {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HashMap<String, Span> BuiltInFictitiousFunctionClassFactory = new HashMap<>();

    @Override // id.dana.rum.Rum
    public final void MyBillsEntityDataFactory(Exception p0, Pair<String, ? extends Object>... p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        int length = p1.length;
        SplunkRum.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(p0, Attributes.CC.empty());
    }

    @Override // id.dana.rum.Rum
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.put(p0, SplunkRum.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory().spanBuilder(p0).setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.isLayoutRequested, (AttributeKey<String>) p0).startSpan());
    }

    @Override // id.dana.rum.Rum
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Pair<String, ? extends Object>... p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Span startSpan = SplunkRum.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory().spanBuilder(p0).setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.isLayoutRequested, (AttributeKey<String>) p0).startSpan();
        HashMap<String, Span> hashMap = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(startSpan, "");
        hashMap.put(p0, startSpan);
        int length = p1.length;
        int length2 = p1.length;
        for (int i = 0; i <= 0; i++) {
            Pair<String, ? extends Object> pair = p1[0];
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 instanceof String) {
                startSpan.setAttribute(component1, (String) component2);
            } else if (component2 instanceof Boolean) {
                startSpan.setAttribute(component1, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Long) {
                startSpan.setAttribute(component1, ((Number) component2).longValue());
            } else if (component2 instanceof Double) {
                startSpan.setAttribute(component1, ((Number) component2).doubleValue());
            }
        }
    }

    @Override // id.dana.rum.Rum
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Span span = this.BuiltInFictitiousFunctionClassFactory.get(p0);
        if (span == null) {
            return;
        }
        span.end();
        this.BuiltInFictitiousFunctionClassFactory.remove(p0);
    }

    @Override // id.dana.rum.Rum
    public final Rum.Workflow getAuthRequestContext(final String p0, Pair<String, ? extends Object>... p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if ((p1.length == 0) || this.BuiltInFictitiousFunctionClassFactory.get(p0) == null) {
            return NoOpWorkflow.INSTANCE;
        }
        Span span = this.BuiltInFictitiousFunctionClassFactory.get(p0);
        Intrinsics.checkNotNull(span);
        Span span2 = span;
        for (Pair<String, ? extends Object> pair : p1) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 instanceof String) {
                span2.setAttribute(component1, (String) component2);
            } else if (component2 instanceof Boolean) {
                span2.setAttribute(component1, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Long) {
                span2.setAttribute(component1, ((Number) component2).longValue());
            } else if (component2 instanceof Double) {
                span2.setAttribute(component1, ((Number) component2).doubleValue());
            }
        }
        return new SplunkWorkflow(span2, new Function0<Unit>() { // from class: id.dana.rum.splunk.Splunk$putWorkflowAttributes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap hashMap;
                hashMap = Splunk.this.BuiltInFictitiousFunctionClassFactory;
                hashMap.remove(p0);
            }
        });
    }

    @Override // id.dana.rum.Rum
    public final void PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Span span = this.BuiltInFictitiousFunctionClassFactory.get(p1);
        if (span == null) {
            SplunkRum MyBillsEntityDataFactory = SplunkRum.MyBillsEntityDataFactory();
            StringBuilder sb = new StringBuilder();
            sb.append("No parent workflow ");
            sb.append(p1);
            sb.append(" found for event ");
            sb.append(p0);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new RumWorkflowException(sb.toString()), Attributes.CC.empty());
            return;
        }
        Splunk$startSubWorkflow$1 splunk$startSubWorkflow$1 = new Function1<Span, Unit>() { // from class: id.dana.rum.splunk.Splunk$startSubWorkflow$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Span span2) {
                Intrinsics.checkNotNullParameter(span2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Span span2) {
                invoke2(span2);
                return Unit.INSTANCE;
            }
        };
        Span startSpan = SplunkRum.MyBillsEntityDataFactory().PlaceComponentResult().getTracer("SplunkRum").spanBuilder(p0).setAttribute("workflow.name", p0).setParent(Context.CC.current().with(span)).startSpan();
        HashMap<String, Span> hashMap = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(startSpan, "");
        hashMap.put(p0, startSpan);
        splunk$startSubWorkflow$1.invoke((Splunk$startSubWorkflow$1) startSpan);
    }
}
