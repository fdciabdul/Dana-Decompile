package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static Method KClassImpl$Data$declaredNonStaticMembers$2;
    private static Method MyBillsEntityDataFactory;
    private static Method PlaceComponentResult;
    private static long getAuthRequestContext;

    static {
        if (Build.VERSION.SDK_INT < 18 || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        try {
            getAuthRequestContext = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            BuiltInFictitiousFunctionClassFactory = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            KClassImpl$Data$declaredNonStaticMembers$2 = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            PlaceComponentResult = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            MyBillsEntityDataFactory = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception e) {
            InstrumentInjector.log_i("TraceCompat", "Unable to initialize via reflection.", e);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.BuiltInFictitiousFunctionClassFactory(str);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.getAuthRequestContext();
        }
    }

    private TraceCompat() {
    }

    /* loaded from: classes6.dex */
    static class Api29Impl {
        private Api29Impl() {
        }
    }

    /* loaded from: classes3.dex */
    static class Api18Impl {
        private Api18Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(String str) {
            Trace.beginSection(str);
        }

        static void getAuthRequestContext() {
            Trace.endSection();
        }
    }
}
