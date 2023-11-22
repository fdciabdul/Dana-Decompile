package id.dana.promodiscovery.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/promodiscovery/tracker/PromoDiscoveryMixpanelTracker;", "Lid/dana/promodiscovery/tracker/PromoDiscoveryAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()V", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoDiscoveryMixpanelTracker implements PromoDiscoveryAnalyticTracker {
    public final Context getAuthRequestContext;

    @Inject
    public PromoDiscoveryMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.promodiscovery.tracker.PromoDiscoveryAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.promodiscovery.tracker.PromoDiscoveryMixpanelTracker$trackPromoCenterOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_CENTER_OPEN;
            }
        });
    }

    @Override // id.dana.promodiscovery.tracker.PromoDiscoveryAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.promodiscovery.tracker.PromoDiscoveryMixpanelTracker$trackPromoCenterActions$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_CENTER_ACTIONS;
                builder.MyBillsEntityDataFactory("Source", p0);
            }
        });
    }

    private final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
