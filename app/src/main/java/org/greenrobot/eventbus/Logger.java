package org.greenrobot.eventbus;

import java.io.PrintStream;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponents;

/* loaded from: classes2.dex */
public interface Logger {
    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    /* loaded from: classes9.dex */
    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String str) {
            this.logger = java.util.logging.Logger.getLogger(str);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String str) {
            this.logger.log(level, str);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String str, Throwable th) {
            this.logger.log(level, str, th);
        }
    }

    /* loaded from: classes6.dex */
    public static class SystemOutLogger implements Logger {
        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String str) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(level);
            sb.append("] ");
            sb.append(str);
            printStream.println(sb.toString());
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(level);
            sb.append("] ");
            sb.append(str);
            printStream.println(sb.toString());
            th.printStackTrace(System.out);
        }
    }

    /* loaded from: classes6.dex */
    public static class Default {
        public static Logger get() {
            if (AndroidComponents.areAvailable()) {
                return AndroidComponents.get().logger;
            }
            return new SystemOutLogger();
        }
    }
}
