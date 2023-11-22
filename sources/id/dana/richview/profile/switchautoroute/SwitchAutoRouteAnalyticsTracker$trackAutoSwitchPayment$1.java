package id.dana.richview.profile.switchautoroute;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTrackerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/tracker/EventTrackerModel$Builder;", "", BridgeDSL.INVOKE, "(Lid/dana/tracker/EventTrackerModel$Builder;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 extends Lambda implements Function1<EventTrackerModel.Builder, Unit> {
    final /* synthetic */ boolean $$isActive;
    final /* synthetic */ String $$source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1(String str, boolean z) {
        super(1);
        this.$$source = str;
        this.$$isActive = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
        invoke2(builder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EventTrackerModel.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        builder.MyBillsEntityDataFactory = TrackerKey.Event.AUTO_SWITCH_PAYMENT;
        builder.MyBillsEntityDataFactory("Source", this.$$source);
        builder.BuiltInFictitiousFunctionClassFactory("Result", this.$$isActive);
    }
}
