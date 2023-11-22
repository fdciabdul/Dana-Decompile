package id.dana.performancetracker;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebaseAnalyticsEvent;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.tracker.EventTracker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\rJC\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0013R\u0014\u0010\u000f\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016"}, d2 = {"Lid/dana/performancetracker/VerifyMethodAnalyticTracker;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "p3", "p4", "", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p5", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyMethodAnalyticTracker {
    public static final VerifyMethodAnalyticTracker INSTANCE = new VerifyMethodAnalyticTracker();
    private static final FirebasePerformanceMonitor KClassImpl$Data$declaredNonStaticMembers$2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
    private static String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static String PlaceComponentResult = "Login";

    private VerifyMethodAnalyticTracker() {
    }

    public static void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory = p0;
    }

    public static void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult = p0;
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context p0, String p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        PlaceComponentResult(p0, p1, p2, p3, p4);
    }

    @JvmStatic
    public static final void getAuthRequestContext(Context p0, String p1, String p2, String p3, String p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (!Intrinsics.areEqual(PlaceComponentResult, "Login")) {
            p2 = p3;
        }
        PlaceComponentResult(p0, p1, p2, p4, p5);
    }

    @JvmStatic
    public static final void getAuthRequestContext(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        FirebasePerformanceMonitor firebasePerformanceMonitor = KClassImpl$Data$declaredNonStaticMembers$2;
        firebasePerformanceMonitor.BuiltInFictitiousFunctionClassFactory(p2, TrackerKey.Property.IS_DELIVERED, p0);
        firebasePerformanceMonitor.BuiltInFictitiousFunctionClassFactory(p2, TrackerKey.Property.ATTEMPT, p1);
        Intrinsics.checkNotNullParameter(p2, "");
        Trace trace = firebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2.get(p2);
        if (trace != null) {
            trace.stop();
        }
    }

    private static void PlaceComponentResult(Context p0, String p1, String p2, String p3, String p4) {
        Bundle bundle = new Bundle();
        if (p3 != null) {
            bundle.putString(TrackerKey.Property.ERROR_CODE_FIREBASE, p3);
        }
        if (p4 != null) {
            bundle.putString(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, p4);
        }
        bundle.putString(TrackerKey.Event.VERIFICATION_METHOD_REQUEST, BuiltInFictitiousFunctionClassFactory);
        EventTracker.BuiltInFictitiousFunctionClassFactory(new FirebaseAnalyticsEvent(p0, p2, bundle));
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        FirebasePerformanceMonitor firebasePerformanceMonitor = KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p1, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(firebasePerformanceMonitor, p1);
    }
}
