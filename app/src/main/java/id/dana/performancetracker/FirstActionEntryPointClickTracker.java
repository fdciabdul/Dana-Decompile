package id.dana.performancetracker;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\b\u001a\u00020\fH\u0007¢\u0006\u0004\b\b\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\"\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@GX\u0086\n¢\u0006\f\n\u0004\b\r\u0010\u0010\"\u0004\b\b\u0010\u0011"}, d2 = {"Lid/dana/performancetracker/FirstActionEntryPointClickTracker;", "", "", "p0", "MyBillsEntityDataFactory", "(J)J", "PlaceComponentResult", "()J", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "()Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "J", "Z", "(Z)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FirstActionEntryPointClickTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static long getAuthRequestContext;
    public static final FirstActionEntryPointClickTracker INSTANCE = new FirstActionEntryPointClickTracker();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static boolean BuiltInFictitiousFunctionClassFactory;

    private FirstActionEntryPointClickTracker() {
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (MyBillsEntityDataFactory) {
            return;
        }
        if (getAuthRequestContext > 0) {
            z = false;
        }
        MyBillsEntityDataFactory = z;
    }

    @JvmStatic
    public static final long MyBillsEntityDataFactory(long p0) {
        if (getAuthRequestContext <= 0 || p0 <= 0 || getAuthRequestContext()) {
            return -1L;
        }
        return getAuthRequestContext - p0;
    }

    @JvmStatic
    public static final long PlaceComponentResult() {
        if (getAuthRequestContext > 0 && !getAuthRequestContext()) {
            return System.currentTimeMillis() - getAuthRequestContext;
        }
        return -1L;
    }

    @JvmStatic
    public static final long BuiltInFictitiousFunctionClassFactory(long p0) {
        if (p0 > 0 && !getAuthRequestContext()) {
            BuiltInFictitiousFunctionClassFactory = true;
            return System.currentTimeMillis() - p0;
        }
        return -1L;
    }

    private static boolean getAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory) {
            return true;
        }
        AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
        return AppReadyMixpanelTracker.scheduleImpl() || MyBillsEntityDataFactory;
    }

    @JvmStatic
    public static final long PlaceComponentResult(long p0) {
        if (p0 > 0 && !getAuthRequestContext()) {
            return getAuthRequestContext - p0;
        }
        return -1L;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext = 0L;
        BuiltInFictitiousFunctionClassFactory = false;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = System.currentTimeMillis();
    }
}
