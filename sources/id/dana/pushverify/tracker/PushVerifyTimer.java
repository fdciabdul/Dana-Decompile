package id.dana.pushverify.tracker;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\r"}, d2 = {"Lid/dana/pushverify/tracker/PushVerifyTimer;", "", "", "getAuthRequestContext", "()J", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "scheduleImpl", "J", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyTimer {
    public static final PushVerifyTimer INSTANCE = new PushVerifyTimer();
    private static long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static long getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static long MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static long BuiltInFictitiousFunctionClassFactory;

    private PushVerifyTimer() {
    }

    @JvmStatic
    public static final void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void moveToNextValue() {
        MyBillsEntityDataFactory = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long getAuthRequestContext() {
        return RangesKt.coerceAtLeast(MyBillsEntityDataFactory - KClassImpl$Data$declaredNonStaticMembers$2, 0L);
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void scheduleImpl() {
        getAuthRequestContext = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long MyBillsEntityDataFactory() {
        return RangesKt.coerceAtLeast(getAuthRequestContext - BuiltInFictitiousFunctionClassFactory, 0L);
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        MyBillsEntityDataFactory = 0L;
        BuiltInFictitiousFunctionClassFactory = 0L;
        getAuthRequestContext = 0L;
    }
}
