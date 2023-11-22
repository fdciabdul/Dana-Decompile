package androidx.tracing;

import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.metrics.resource.ResourceType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class Trace {
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    private static Method MyBillsEntityDataFactory;

    public static boolean PlaceComponentResult() {
        try {
            if (MyBillsEntityDataFactory == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.MyBillsEntityDataFactory(str);
        }
    }

    public static void MyBillsEntityDataFactory() {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.MyBillsEntityDataFactory();
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (MyBillsEntityDataFactory == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    MyBillsEntityDataFactory = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) MyBillsEntityDataFactory.invoke(null, Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2))).booleanValue();
            } catch (Exception e) {
                if (e instanceof InvocationTargetException) {
                    Throwable cause = e.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    throw new RuntimeException(cause);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to call ");
                sb.append("isTagEnabled");
                sb.append(" via reflection");
                InstrumentInjector.log_v(ResourceType.TRACE, sb.toString(), e);
            }
        }
        return false;
    }

    private Trace() {
    }
}
