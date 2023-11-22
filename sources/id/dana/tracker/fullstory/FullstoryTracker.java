package id.dana.tracker.fullstory;

import id.dana.domain.fullstory.interactor.IsEligibleForFullstorySession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/tracker/fullstory/FullstoryTracker;", "", "Lid/dana/domain/fullstory/interactor/IsEligibleForFullstorySession;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/fullstory/interactor/IsEligibleForFullstorySession;)V", "getAuthRequestContext", "()Lid/dana/domain/fullstory/interactor/IsEligibleForFullstorySession;", "PlaceComponentResult", "Lid/dana/domain/fullstory/interactor/IsEligibleForFullstorySession;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FullstoryTracker {
    public static final FullstoryTracker INSTANCE = new FullstoryTracker();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static IsEligibleForFullstorySession BuiltInFictitiousFunctionClassFactory;

    private FullstoryTracker() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(IsEligibleForFullstorySession p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory = p0;
    }

    public static IsEligibleForFullstorySession getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory;
    }
}
