package id.dana.kybcpm.tracker;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.model.DisplayedErrorModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/kybcpm/tracker/MixpanelKybCpmTracker;", "Lid/dana/kybcpm/tracker/KybCpmTracker;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/Throwable;)V", "Landroid/content/Context;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MixpanelKybCpmTracker implements KybCpmTracker {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    @Inject
    public MixpanelKybCpmTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.kybcpm.tracker.KybCpmTracker
    public final void PlaceComponentResult(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.MyBillsEntityDataFactory.getString(R.string.general_error_info_kyb_cpm);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.MyBillsEntityDataFactory, string, TrackerDataKey.Source.KYB_NATIVE_HOMEPAGE, DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.CREATE_PAYMENT_ORDER_CPM));
    }
}
