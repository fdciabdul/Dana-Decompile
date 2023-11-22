package com.otaliastudios.cameraview;

import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class CameraLogger {
    private static List<Logger> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    static String MyBillsEntityDataFactory;
    static Logger PlaceComponentResult;
    static String getAuthRequestContext;
    private String moveToNextValue;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LogLevel {
    }

    /* loaded from: classes8.dex */
    public interface Logger {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i, String str, String str2, Throwable th);
    }

    static {
        Logger logger = new Logger() { // from class: com.otaliastudios.cameraview.CameraLogger.1
            @Override // com.otaliastudios.cameraview.CameraLogger.Logger
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, String str, String str2, Throwable th) {
                if (i == 0) {
                    InstrumentInjector.log_v(str, str2, th);
                } else if (i == 1) {
                    InstrumentInjector.log_i(str, str2, th);
                } else if (i == 2) {
                    InstrumentInjector.log_w(str, str2, th);
                } else if (i == 3) {
                    InstrumentInjector.log_e(str, str2, th);
                }
            }
        };
        PlaceComponentResult = logger;
        KClassImpl$Data$declaredNonStaticMembers$2 = 3;
        BuiltInFictitiousFunctionClassFactory.add(logger);
    }

    public static CameraLogger KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return new CameraLogger(str);
    }

    private CameraLogger(String str) {
        this.moveToNextValue = str;
    }

    private static boolean getAuthRequestContext(int i) {
        return KClassImpl$Data$declaredNonStaticMembers$2 <= i && BuiltInFictitiousFunctionClassFactory.size() > 0;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(int i, Object... objArr) {
        Throwable th = null;
        if (getAuthRequestContext(i)) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj instanceof Throwable) {
                    th = (Throwable) obj;
                }
                sb.append(String.valueOf(obj));
                sb.append(" ");
            }
            String trim = sb.toString().trim();
            Iterator<Logger> it = BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                it.next().KClassImpl$Data$declaredNonStaticMembers$2(i, this.moveToNextValue, trim, th);
            }
            getAuthRequestContext = trim;
            MyBillsEntityDataFactory = this.moveToNextValue;
            return trim;
        }
        return null;
    }
}
