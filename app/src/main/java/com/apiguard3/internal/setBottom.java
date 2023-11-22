package com.apiguard3.internal;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class setBottom {
    private static int APIGuard = 1;
    private static int values;

    public static void APIGuard(setHovered sethovered, setLayerType setlayertype) throws IOException {
        int i = APIGuard + 3;
        values = i % 128;
        if ((i % 2 != 0 ? '\'' : 'c') == 'c') {
            setHorizontalFadingEdgeEnabled.SConfig.getSharedInstance(setlayertype, sethovered);
        } else {
            setHorizontalFadingEdgeEnabled.SConfig.getSharedInstance(setlayertype, sethovered);
            throw new ArithmeticException();
        }
    }

    public static Writer AGState(Appendable appendable) {
        int i = (values + 37) % 128;
        APIGuard = i;
        if ((appendable instanceof Writer ? (char) 7 : '_') != 7) {
            return new APIGuard(appendable);
        }
        int i2 = i + 41;
        values = i2 % 128;
        Writer writer = (Writer) appendable;
        if (i2 % 2 != 0) {
            throw new NullPointerException();
        }
        return writer;
    }

    /* loaded from: classes7.dex */
    static final class APIGuard extends Writer {
        private static int valueOf = 1;
        private static int values;
        private final AGState AGState = new AGState();
        private final Appendable getSharedInstance;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            values = (valueOf + 45) % 128;
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            int i = valueOf + 65;
            values = i % 128;
            if ((i % 2 != 0 ? (char) 22 : (char) 16) == 16) {
                return;
            }
            throw null;
        }

        APIGuard(Appendable appendable) {
            this.getSharedInstance = appendable;
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) throws IOException {
            valueOf = (values + 51) % 128;
            this.AGState.AGState = cArr;
            this.getSharedInstance.append(this.AGState, i, i2 + i);
            int i3 = valueOf + 47;
            values = i3 % 128;
            if ((i3 % 2 != 0 ? '\f' : 'Z') == 'Z') {
                return;
            }
            throw new ArithmeticException();
        }

        @Override // java.io.Writer
        public final void write(int i) throws IOException {
            valueOf = (values + 115) % 128;
            this.getSharedInstance.append((char) i);
            int i2 = values + 75;
            valueOf = i2 % 128;
            if (i2 % 2 == 0) {
                throw new NullPointerException();
            }
        }

        /* loaded from: classes7.dex */
        static final class AGState implements CharSequence {
            private static int APIGuard = 1;
            private static int getSharedInstance;
            char[] AGState;

            AGState() {
            }

            @Override // java.lang.CharSequence
            public final int length() {
                int i = APIGuard + 43;
                getSharedInstance = i % 128;
                if (!(i % 2 != 0)) {
                    return this.AGState.length;
                }
                int length = this.AGState.length;
                throw null;
            }

            @Override // java.lang.CharSequence
            public final char charAt(int i) {
                int i2 = APIGuard;
                int i3 = i2 + 23;
                getSharedInstance = i3 % 128;
                if (i3 % 2 != 0) {
                    char c = this.AGState[i];
                    throw null;
                }
                char c2 = this.AGState[i];
                int i4 = i2 + 123;
                getSharedInstance = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    return c2;
                }
                throw new NullPointerException();
            }

            @Override // java.lang.CharSequence
            public final CharSequence subSequence(int i, int i2) {
                String str = new String(this.AGState, i, i2 - i);
                getSharedInstance = (APIGuard + 59) % 128;
                return str;
            }
        }
    }

    public static <T> T getSharedInstance(T t) {
        int i = APIGuard;
        values = (i + 53) % 128;
        if (t != null) {
            int i2 = i + 33;
            values = i2 % 128;
            if (i2 % 2 == 0) {
                return t;
            }
            throw new NullPointerException();
        }
        throw null;
    }

    public static void getSharedInstance(boolean z) {
        int i = (APIGuard + 93) % 128;
        values = i;
        if (!z) {
            throw new IllegalArgumentException();
        }
        values = i;
    }

    public setBottom(Field field) {
        getSharedInstance(field);
    }

    public setBottom() {
    }

    public static DateFormat valueOf() {
        StringBuilder sb = new StringBuilder();
        sb.append(AGState(2));
        sb.append(" ");
        sb.append(APIGuard(2));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sb.toString(), Locale.US);
        int i = APIGuard + 11;
        values = i % 128;
        if ((i % 2 != 0 ? '3' : (char) 19) == 19) {
            return simpleDateFormat;
        }
        throw null;
    }

    private static String AGState(int i) {
        int i2 = APIGuard + 53;
        values = i2 % 128;
        if (i2 % 2 == 0) {
            return "MMM d, yyyy";
        }
        throw new NullPointerException();
    }

    private static String APIGuard(int i) {
        int i2 = APIGuard + 39;
        int i3 = i2 % 128;
        values = i3;
        if (!(i2 % 2 == 0)) {
            throw null;
        }
        int i4 = i3 + 55;
        APIGuard = i4 % 128;
        if (i4 % 2 == 0) {
            throw null;
        }
        return "h:mm:ss a";
    }
}
