package androidx.work;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public abstract class Logger {
    private static final int BuiltInFictitiousFunctionClassFactory = 20;
    private static Logger MyBillsEntityDataFactory;

    public abstract void BuiltInFictitiousFunctionClassFactory(String str, String str2, Throwable... thArr);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, Throwable... thArr);

    public abstract void MyBillsEntityDataFactory(String str, String str2, Throwable... thArr);

    public abstract void PlaceComponentResult(String str, String str2, Throwable... thArr);

    public abstract void getAuthRequestContext(String str, String str2, Throwable... thArr);

    public static void PlaceComponentResult(Logger logger) {
        synchronized (Logger.class) {
            MyBillsEntityDataFactory = logger;
        }
    }

    public static String MyBillsEntityDataFactory(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i = BuiltInFictitiousFunctionClassFactory;
        if (length >= i) {
            sb.append(str.substring(0, i));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static Logger getAuthRequestContext() {
        Logger logger;
        synchronized (Logger.class) {
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new LogcatLogger(3);
            }
            logger = MyBillsEntityDataFactory;
        }
        return logger;
    }

    /* loaded from: classes3.dex */
    public static class LogcatLogger extends Logger {
        private int BuiltInFictitiousFunctionClassFactory;

        public LogcatLogger(int i) {
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        @Override // androidx.work.Logger
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, Throwable... thArr) {
            if (this.BuiltInFictitiousFunctionClassFactory <= 2) {
                int length = thArr.length;
                InstrumentInjector.log_v(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public final void PlaceComponentResult(String str, String str2, Throwable... thArr) {
            if (this.BuiltInFictitiousFunctionClassFactory <= 3) {
                if (thArr.length > 0) {
                    InstrumentInjector.log_d(str, str2, thArr[0]);
                } else {
                    InstrumentInjector.log_d(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public final void MyBillsEntityDataFactory(String str, String str2, Throwable... thArr) {
            if (this.BuiltInFictitiousFunctionClassFactory <= 4) {
                if (thArr.length > 0) {
                    InstrumentInjector.log_i(str, str2, thArr[0]);
                } else {
                    InstrumentInjector.log_i(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public final void getAuthRequestContext(String str, String str2, Throwable... thArr) {
            if (this.BuiltInFictitiousFunctionClassFactory <= 5) {
                if (thArr.length > 0) {
                    InstrumentInjector.log_w(str, str2, thArr[0]);
                } else {
                    InstrumentInjector.log_w(str, str2);
                }
            }
        }

        @Override // androidx.work.Logger
        public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, Throwable... thArr) {
            if (this.BuiltInFictitiousFunctionClassFactory <= 6) {
                if (thArr.length > 0) {
                    InstrumentInjector.log_e(str, str2, thArr[0]);
                } else {
                    InstrumentInjector.log_e(str, str2);
                }
            }
        }
    }
}
