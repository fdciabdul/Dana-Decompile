package id.dana.contract.deeplink.path;

import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.di.PerActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/contract/deeplink/path/FeaturePushVerify;", "", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "PlaceComponentResult", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/contract/deeplink/tracker/DeeplinkTracker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class FeaturePushVerify {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final DeeplinkTracker getAuthRequestContext;

    @Inject
    public FeaturePushVerify(DeeplinkTracker deeplinkTracker) {
        Intrinsics.checkNotNullParameter(deeplinkTracker, "");
        this.getAuthRequestContext = deeplinkTracker;
    }
}
