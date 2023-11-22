package id.dana.globalnetwork;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000b"}, d2 = {"Lid/dana/globalnetwork/GnLoadTimeTracker;", "", "", "getAuthRequestContext", "()J", "", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GnLoadTimeTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static long getAuthRequestContext;
    public static final GnLoadTimeTracker INSTANCE = new GnLoadTimeTracker();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static long PlaceComponentResult;

    private GnLoadTimeTracker() {
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = System.currentTimeMillis();
    }

    @JvmStatic
    public static final void PlaceComponentResult() {
        getAuthRequestContext = System.currentTimeMillis();
    }

    @JvmStatic
    public static final long getAuthRequestContext() {
        return RangesKt.coerceAtLeast(getAuthRequestContext - PlaceComponentResult, 0L);
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory() {
        PlaceComponentResult = 0L;
        getAuthRequestContext = 0L;
    }
}
