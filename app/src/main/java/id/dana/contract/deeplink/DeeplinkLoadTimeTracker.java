package id.dana.contract.deeplink;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0011\u0010\n\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/contract/deeplink/DeeplinkLoadTimeTracker;", "", "", "getAuthRequestContext", "()J", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "(J)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "scheduleImpl", "moveToNextValue", "J", "", "getErrorConfigVersion", "()Z", "DatabaseTableConfigUtil", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeeplinkLoadTimeTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static long PlaceComponentResult;
    public static final DeeplinkLoadTimeTracker INSTANCE = new DeeplinkLoadTimeTracker();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static long getAuthRequestContext;
    private static long MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private static long lookAheadTest;

    private DeeplinkLoadTimeTracker() {
    }

    @JvmName(name = "DatabaseTableConfigUtil")
    public static boolean DatabaseTableConfigUtil() {
        return getAuthRequestContext > 0;
    }

    @JvmName(name = "getErrorConfigVersion")
    public static boolean getErrorConfigVersion() {
        return BuiltInFictitiousFunctionClassFactory > 0;
    }

    @JvmStatic
    public static final void lookAheadTest() {
        getAuthRequestContext = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void moveToNextValue() {
        PlaceComponentResult = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long BuiltInFictitiousFunctionClassFactory() {
        return RangesKt.coerceAtLeast(PlaceComponentResult - getAuthRequestContext, 0L);
    }

    @JvmStatic
    public static final void scheduleImpl() {
        MyBillsEntityDataFactory = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long getAuthRequestContext() {
        return RangesKt.coerceAtLeast(MyBillsEntityDataFactory - BuiltInFictitiousFunctionClassFactory, 0L);
    }

    @JvmStatic
    public static final long MyBillsEntityDataFactory() {
        return lookAheadTest;
    }

    @JvmStatic
    public static final void PlaceComponentResult() {
        getAuthRequestContext = 0L;
        PlaceComponentResult = 0L;
        BuiltInFictitiousFunctionClassFactory = 0L;
        MyBillsEntityDataFactory = 0L;
    }
}
