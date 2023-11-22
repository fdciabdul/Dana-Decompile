package id.dana.performancetracker;

import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u001a\u0010\u0007\u001a\u00020\b@\u0007X\u0086\n¢\u0006\f\n\u0004\b\n\u0010\t\"\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/performancetracker/FirstActionTracker;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "PlaceComponentResult", "", "Z", "MyBillsEntityDataFactory", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FirstActionTracker {
    public static final FirstActionTracker INSTANCE = new FirstActionTracker();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static boolean PlaceComponentResult = true;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static boolean MyBillsEntityDataFactory;

    private FirstActionTracker() {
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static void MyBillsEntityDataFactory() {
        PlaceComponentResult = false;
    }

    public static void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("first_action");
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory("first_action", "start_type", p0);
    }

    public static void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (MyBillsEntityDataFactory || !PlaceComponentResult) {
            return;
        }
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory("first_action", "first_action_type", p0);
        FirebasePerformanceMonitor MyBillsEntityDataFactory2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter("first_action", "");
        Trace trace = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get("first_action");
        if (trace != null) {
            trace.stop();
        }
        MyBillsEntityDataFactory = true;
    }
}
