package id.dana.twilio.tracker;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTrackerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/tracker/EventTrackerModel$Builder;", "", BridgeDSL.INVOKE, "(Lid/dana/tracker/EventTrackerModel$Builder;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TwilioMixpanelTracker$trackTwilioCreateChallenge$1 extends Lambda implements Function1<EventTrackerModel.Builder, Unit> {
    final /* synthetic */ String $$source;
    final /* synthetic */ TwilioMixpanelTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwilioMixpanelTracker$trackTwilioCreateChallenge$1(String str, TwilioMixpanelTracker twilioMixpanelTracker) {
        super(1);
        this.$$source = str;
        this.this$0 = twilioMixpanelTracker;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
        invoke2(builder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EventTrackerModel.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_CREATE_CHALLENGE;
        builder.MyBillsEntityDataFactory("Source", this.$$source);
        builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
    }
}
