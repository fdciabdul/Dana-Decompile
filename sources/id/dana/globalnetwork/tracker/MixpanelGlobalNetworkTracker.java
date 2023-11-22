package id.dana.globalnetwork.tracker;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.deeplink.DeeplinkLoadTimeTracker;
import id.dana.globalnetwork.GnLoadTimeTracker;
import id.dana.model.DisplayedErrorModel;
import id.dana.tracker.BaseEventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e"}, d2 = {"Lid/dana/globalnetwork/tracker/MixpanelGlobalNetworkTracker;", "Lid/dana/tracker/BaseEventTracker;", "Lid/dana/globalnetwork/tracker/GlobalNetworkTracker;", "", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)V", "", "getAuthRequestContext", "(Ljava/lang/Throwable;)V", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MixpanelGlobalNetworkTracker extends BaseEventTracker implements GlobalNetworkTracker {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MixpanelGlobalNetworkTracker(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.globalnetwork.tracker.GlobalNetworkTracker
    public final void getAuthRequestContext(Throwable p0) {
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.deeplink_error_description);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, string, "Deeplink Payment - ACCashier", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, "IAPConnect.Decode"));
    }

    @Override // id.dana.globalnetwork.tracker.GlobalNetworkTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        GnLoadTimeTracker.PlaceComponentResult();
        final long authRequestContext = GnLoadTimeTracker.getAuthRequestContext();
        final long MyBillsEntityDataFactory = authRequestContext + DeeplinkLoadTimeTracker.MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalnetwork.tracker.MixpanelGlobalNetworkTracker$trackAlipayConnectProcess$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.AC_PROCESS;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.DeeplinkProperty.TOTAL_DURATION, MyBillsEntityDataFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.DeeplinkProperty.METHOD, p0);
                builder.BuiltInFictitiousFunctionClassFactory("Duration", authRequestContext);
                builder.BuiltInFictitiousFunctionClassFactory("Success", p1);
            }
        });
        GnLoadTimeTracker.MyBillsEntityDataFactory();
        DeeplinkLoadTimeTracker.lookAheadTest = 0L;
    }
}
