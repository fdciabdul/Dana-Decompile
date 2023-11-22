package id.dana.contract.deeplink.tracker;

import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/contract/deeplink/tracker/DeeplinkTrackerFactory;", "Lid/dana/contract/deeplink/tracker/AbstractDeeplinkTrackerFactory;", "", "p0", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/contract/deeplink/tracker/DeeplinkTracker;Lid/dana/contract/deeplink/tracker/DeeplinkTracker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeeplinkTrackerFactory implements AbstractDeeplinkTrackerFactory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final DeeplinkTracker KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DeeplinkTracker BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DeeplinkTrackerFactory(DeeplinkTracker deeplinkTracker, @Named("fullstory") DeeplinkTracker deeplinkTracker2) {
        Intrinsics.checkNotNullParameter(deeplinkTracker, "");
        Intrinsics.checkNotNullParameter(deeplinkTracker2, "");
        this.BuiltInFictitiousFunctionClassFactory = deeplinkTracker;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deeplinkTracker2;
    }

    @Override // id.dana.contract.deeplink.tracker.AbstractDeeplinkTrackerFactory
    public final DeeplinkTracker BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return Intrinsics.areEqual(p0, TrackerType.FULLSTORY) ? this.KClassImpl$Data$declaredNonStaticMembers$2 : this.BuiltInFictitiousFunctionClassFactory;
    }
}
