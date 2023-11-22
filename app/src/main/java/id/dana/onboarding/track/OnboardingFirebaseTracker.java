package id.dana.onboarding.track;

import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000eR\u0014\u0010\t\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012"}, d2 = {"Lid/dana/onboarding/track/OnboardingFirebaseTracker;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "", "(Z)V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "p1", "(Lid/dana/analytics/firebase/FirebasePerformanceMonitor;Ljava/lang/String;)V", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "getAuthRequestContext", "Z", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnboardingFirebaseTracker {
    private static boolean BuiltInFictitiousFunctionClassFactory;
    public static final OnboardingFirebaseTracker INSTANCE = new OnboardingFirebaseTracker();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static final FirebasePerformanceMonitor PlaceComponentResult = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static boolean MyBillsEntityDataFactory;

    private OnboardingFirebaseTracker() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    public static void BuiltInFictitiousFunctionClassFactory(FirebasePerformanceMonitor p0, String p1) {
        String str = getAuthRequestContext;
        if (str == null) {
            return;
        }
        if ((StringsKt.equals(str, "LOGIN", true) && MyBillsEntityDataFactory) || (StringsKt.equals(getAuthRequestContext, "REGISTER", true) && BuiltInFictitiousFunctionClassFactory)) {
            if (p0 != null) {
                Intrinsics.checkNotNullParameter(p1, "");
                Trace trace = p0.KClassImpl$Data$declaredNonStaticMembers$2.get(p1);
                if (trace != null) {
                    trace.stop();
                    return;
                }
                return;
            }
            FirebasePerformanceMonitor firebasePerformanceMonitor = PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p1, "");
            Trace trace2 = firebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2.get(p1);
            if (trace2 != null) {
                trace2.stop();
            }
        }
    }

    public static void MyBillsEntityDataFactory(boolean p0) {
        MyBillsEntityDataFactory = p0;
    }

    public static void PlaceComponentResult(boolean p0) {
        BuiltInFictitiousFunctionClassFactory = p0;
    }

    public static void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext = p0;
    }

    public static void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FirebasePerformanceMonitor firebasePerformanceMonitor = PlaceComponentResult;
        Intrinsics.checkNotNullParameter(p0, "");
        firebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2.remove(p0);
    }
}
