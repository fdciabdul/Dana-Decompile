package id.dana.analytics.firebase;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "p1", "p2", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;J)V", "", "Lcom/google/firebase/perf/metrics/Trace;", "PlaceComponentResult", "Ljava/util/Map;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FirebasePerformanceMonitor {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static FirebasePerformanceMonitor KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Map<String, Trace> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    @JvmStatic
    public static final FirebasePerformanceMonitor BuiltInFictitiousFunctionClassFactory() {
        return INSTANCE.MyBillsEntityDataFactory();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, Trace> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Trace newTrace = FirebasePerformance.getInstance().newTrace(p0);
        Intrinsics.checkNotNullExpressionValue(newTrace, "");
        map.put(p0, newTrace);
        Trace trace = this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
        if (trace != null) {
            trace.start();
        }
    }

    public final void MyBillsEntityDataFactory(String p0, String p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Trace trace = this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
        if (trace != null) {
            trace.putMetric(p1, p2);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Trace trace = this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
        if (trace != null) {
            trace.putAttribute(p1, p2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/analytics/firebase/FirebasePerformanceMonitor$Companion;", "", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "MyBillsEntityDataFactory", "()Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FirebasePerformanceMonitor MyBillsEntityDataFactory() {
            FirebasePerformanceMonitor firebasePerformanceMonitor;
            FirebasePerformanceMonitor firebasePerformanceMonitor2 = FirebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2;
            if (firebasePerformanceMonitor2 != null) {
                return firebasePerformanceMonitor2;
            }
            synchronized (this) {
                firebasePerformanceMonitor = FirebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2;
                if (firebasePerformanceMonitor == null) {
                    Companion companion = FirebasePerformanceMonitor.INSTANCE;
                    FirebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2 = new FirebasePerformanceMonitor();
                    firebasePerformanceMonitor = FirebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNull(firebasePerformanceMonitor);
                }
            }
            return firebasePerformanceMonitor;
        }
    }
}
