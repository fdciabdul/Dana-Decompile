package id.dana.paymentsetting.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/paymentsetting/tracker/PaymentSettingMixpanelTracker;", "Lid/dana/paymentsetting/tracker/PaymentSettingAnalyticalTracker;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "PlaceComponentResult", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentSettingMixpanelTracker implements PaymentSettingAnalyticalTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    @Inject
    public PaymentSettingMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.paymentsetting.tracker.PaymentSettingAnalyticalTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0) {
        Function1<EventTrackerModel.Builder, Unit> function1 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.paymentsetting.tracker.PaymentSettingMixpanelTracker$trackRecommendedSecurityChosen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.RECOMMENDED_SECURITY_CHOSEN;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.RecommendedSecurityChosenProperties.RECOMMENDED_SECURITY, p0);
            }
        };
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        function1.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
