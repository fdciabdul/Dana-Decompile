package id.dana.contract.deeplink.tracker;

import com.fullstory.FS;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/contract/deeplink/tracker/FullstoryDeeplinkTracker;", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)V", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/deeplink/model/DeepLinkPayload;", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/deeplink/model/DeepLinkPayload;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FullstoryDeeplinkTracker implements DeeplinkTracker {
    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
    }

    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void MyBillsEntityDataFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Inject
    public FullstoryDeeplinkTracker() {
    }

    @Override // id.dana.contract.deeplink.tracker.DeeplinkTracker
    public final void MyBillsEntityDataFactory(String p0, String p1, DeepLinkPayload p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        FS.event(TrackerKey.Event.DEEPLINK_OPEN, MapsKt.mutableMapOf(TuplesKt.to(TrackerKey.DeeplinkProperty.FULL_URL, p0), TuplesKt.to("Source", p1)));
    }
}
