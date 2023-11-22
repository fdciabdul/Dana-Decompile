package id.dana.kyb.tracker;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.model.DisplayedErrorModel;
import id.dana.tracker.BaseEventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/kyb/tracker/MixpanelKybTracker;", "Lid/dana/tracker/BaseEventTracker;", "Lid/dana/kyb/tracker/KybTracker;", "", "p0", "p1", "p2", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "getAuthRequestContext", "(Ljava/lang/Throwable;)V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MixpanelKybTracker extends BaseEventTracker implements KybTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MixpanelKybTracker(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.kyb.tracker.KybTracker
    public final void getAuthRequestContext(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.kyb_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, string, TrackerDataKey.Source.KYB_NATIVE_HOMEPAGE, DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.GET_MERCHANT_INFO));
    }

    @Override // id.dana.kyb.tracker.KybTracker
    public final void PlaceComponentResult(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.kyb.tracker.MixpanelKybTracker$trackKybServiceClick$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_SERVICE_CLICK;
                builder.MyBillsEntityDataFactory(TrackerKey.Property.ICON_NAME, p0);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.CONFIG_NAME, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.Property.FAILED_CONSULT_RULE, p2);
            }
        });
    }
}
