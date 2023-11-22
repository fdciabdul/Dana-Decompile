package com.apiguard3.io;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apiguard3.domain.Config;
import com.apiguard3.internal.AGState;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.writeReplace;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class ConfigInstance implements Serializable {
    private static int APIGuard = 0;
    private static char[] getSharedInstance = {255, 263, 264, 220, 185, 254, 268, 238, 253, 250, 254, 269, 268, 263, 258, 185, 274, 273, 264, 267, 233, 263, 264, 258, 269, 250, 275, 258, 261, 250, 258, 267, 254, 236, 256, 258};
    private static final long serialVersionUID = 6511510411110711290L;
    private static int valueOf = 1;
    private transient Config values;

    static /* synthetic */ Config APIGuard(ConfigInstance configInstance) {
        int i = valueOf;
        int i2 = i + 63;
        APIGuard = i2 % 128;
        boolean z = i2 % 2 == 0;
        Config config = configInstance.values;
        if (!z) {
            throw new ArithmeticException();
        }
        APIGuard = (i + 11) % 128;
        return config;
    }

    private ConfigInstance() {
    }

    public ConfigInstance(Config config) {
        this.values = config;
    }

    public final Config getSharedInstance() {
        int i = APIGuard + 25;
        valueOf = i % 128;
        if ((i % 2 == 0 ? '^' : 'E') == 'E') {
            return this.values;
        }
        throw new ArithmeticException();
    }

    protected final Object writeReplace() throws ObjectStreamException {
        ConfigSerializationProxy configSerializationProxy = new ConfigSerializationProxy(this);
        int i = APIGuard + 73;
        valueOf = i % 128;
        if ((i % 2 == 0 ? (char) 21 : (char) 27) == 27) {
            return configSerializationProxy;
        }
        throw null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = new Object[1];
        values(null, true, new int[]{0, 36, 153, 8}, objArr);
        throw new InvalidObjectException(((String) objArr[0]).intern());
    }

    /* loaded from: classes7.dex */
    static final class ConfigSerializationProxy implements Serializable {
        private static int AGState = 1;
        private static char[] APIGuard = {28, '2', '9', 'M', 'T', 129, 253, 245, 216, 220, 254, 245, 251, 229, 201, 229, 216, 216, 247, 230, 207, 232, 222, Typography.half, 223, 219, 213, 247, 230, 203, 234, 255, 251, 221, 191};
        private static int getSharedInstance = 0;
        private static final long serialVersionUID = 9011110108210509910L;
        private final Config config;
        private final byte[] shaHash;

        ConfigSerializationProxy(ConfigInstance configInstance) {
            Config APIGuard2 = ConfigInstance.APIGuard(configInstance);
            this.config = APIGuard2;
            String analyzeResponse = APIGuard2.analyzeResponse();
            Object[] objArr = new Object[1];
            getSharedInstance("\u0000\u0001\u0001\u0000\u0001", true, new int[]{0, 5, 0, 0}, objArr);
            byte[] bytes = analyzeResponse.getBytes(Charset.forName(((String) objArr[0]).intern()));
            Object[] objArr2 = new Object[1];
            getSharedInstance("\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001", false, new int[]{5, 30, 143, 0}, objArr2);
            String intern = ((String) objArr2[0]).intern();
            Object[] objArr3 = new Object[1];
            getSharedInstance("\u0000\u0001\u0001\u0000\u0001", true, new int[]{0, 5, 0, 0}, objArr3);
            try {
                this.shaHash = (byte[]) ((Class) AGState.values(6573 - Color.alpha(0), TextUtils.indexOf("", "", 0, 0) + 35, (char) (1942 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("APIGuard", byte[].class, byte[].class).invoke(null, bytes, intern.getBytes(Charset.forName(((String) objArr3[0]).intern())));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        protected final Object readResolve() throws ObjectStreamException {
            if (!this.config.pushMaxPayload()) {
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf, writeReplace.AGState.initialize);
                int i = AGState + 99;
                getSharedInstance = i % 128;
                if ((i % 2 != 0 ? (char) 22 : '2') == '2') {
                    return null;
                }
                throw new NullPointerException();
            }
            String analyzeResponse = this.config.analyzeResponse();
            Object[] objArr = new Object[1];
            getSharedInstance("\u0000\u0001\u0001\u0000\u0001", true, new int[]{0, 5, 0, 0}, objArr);
            byte[] bytes = analyzeResponse.getBytes(Charset.forName(((String) objArr[0]).intern()));
            Object[] objArr2 = new Object[1];
            getSharedInstance("\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001", false, new int[]{5, 30, 143, 0}, objArr2);
            String intern = ((String) objArr2[0]).intern();
            Object[] objArr3 = new Object[1];
            getSharedInstance("\u0000\u0001\u0001\u0000\u0001", true, new int[]{0, 5, 0, 0}, objArr3);
            try {
                if (Arrays.equals((byte[]) ((Class) AGState.values(6573 - TextUtils.getTrimmedLength(""), 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (Drawable.resolveOpacity(0, 0) + 1941))).getMethod("APIGuard", byte[].class, byte[].class).invoke(null, bytes, intern.getBytes(Charset.forName(((String) objArr3[0]).intern()))), this.shaHash)) {
                    return new ConfigInstance(this.config);
                }
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf, writeReplace.AGState.getRequestHeaders);
                int i2 = AGState + 37;
                getSharedInstance = i2 % 128;
                if ((i2 % 2 != 0 ? Typography.amp : 'X') != '&') {
                    return null;
                }
                throw new ArithmeticException();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r12 = r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void getSharedInstance(java.lang.String r12, boolean r13, int[] r14, java.lang.Object[] r15) {
            /*
                if (r12 == 0) goto L8
                java.lang.String r0 = "ISO-8859-1"
                byte[] r12 = r12.getBytes(r0)
            L8:
                byte[] r12 = (byte[]) r12
                java.lang.Object r0 = com.apiguard3.internal.setBackgroundTintMode.getSharedInstance
                monitor-enter(r0)
                r1 = 0
                r2 = r14[r1]     // Catch: java.lang.Throwable -> La2
                r3 = 1
                r4 = r14[r3]     // Catch: java.lang.Throwable -> La2
                r5 = 2
                r6 = r14[r5]     // Catch: java.lang.Throwable -> La2
                r7 = 3
                r7 = r14[r7]     // Catch: java.lang.Throwable -> La2
                char[] r8 = com.apiguard3.io.ConfigInstance.ConfigSerializationProxy.APIGuard     // Catch: java.lang.Throwable -> La2
                char[] r9 = new char[r4]     // Catch: java.lang.Throwable -> La2
                java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch: java.lang.Throwable -> La2
                if (r12 == 0) goto L54
                char[] r2 = new char[r4]     // Catch: java.lang.Throwable -> La2
                com.apiguard3.internal.setBackgroundTintMode.APIGuard = r1     // Catch: java.lang.Throwable -> La2
                r8 = 0
            L27:
                int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                if (r10 >= r4) goto L53
                int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                r10 = r12[r10]     // Catch: java.lang.Throwable -> La2
                if (r10 != r3) goto L3e
                int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r11 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                char r11 = r9[r11]     // Catch: java.lang.Throwable -> La2
                int r11 = r11 << r3
                int r11 = r11 + r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch: java.lang.Throwable -> La2
                r2[r10] = r8     // Catch: java.lang.Throwable -> La2
                goto L49
            L3e:
                int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r11 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                char r11 = r9[r11]     // Catch: java.lang.Throwable -> La2
                int r11 = r11 << r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch: java.lang.Throwable -> La2
                r2[r10] = r8     // Catch: java.lang.Throwable -> La2
            L49:
                int r8 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                char r8 = r2[r8]     // Catch: java.lang.Throwable -> La2
                int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r10 = r10 + r3
                com.apiguard3.internal.setBackgroundTintMode.APIGuard = r10     // Catch: java.lang.Throwable -> La2
                goto L27
            L53:
                r9 = r2
            L54:
                if (r7 <= 0) goto L63
                char[] r12 = new char[r4]     // Catch: java.lang.Throwable -> La2
                java.lang.System.arraycopy(r9, r1, r12, r1, r4)     // Catch: java.lang.Throwable -> La2
                int r2 = r4 - r7
                java.lang.System.arraycopy(r12, r1, r9, r2, r7)     // Catch: java.lang.Throwable -> La2
                java.lang.System.arraycopy(r12, r7, r9, r1, r2)     // Catch: java.lang.Throwable -> La2
            L63:
                if (r13 == 0) goto L7f
                char[] r12 = new char[r4]     // Catch: java.lang.Throwable -> La2
                com.apiguard3.internal.setBackgroundTintMode.APIGuard = r1     // Catch: java.lang.Throwable -> La2
            L69:
                int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                if (r13 >= r4) goto L7e
                int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r2 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r2 = r4 - r2
                int r2 = r2 - r3
                char r2 = r9[r2]     // Catch: java.lang.Throwable -> La2
                r12[r13] = r2     // Catch: java.lang.Throwable -> La2
                int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r13 = r13 + r3
                com.apiguard3.internal.setBackgroundTintMode.APIGuard = r13     // Catch: java.lang.Throwable -> La2
                goto L69
            L7e:
                r9 = r12
            L7f:
                if (r6 <= 0) goto L99
                com.apiguard3.internal.setBackgroundTintMode.APIGuard = r1     // Catch: java.lang.Throwable -> La2
            L83:
                int r12 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                if (r12 >= r4) goto L99
                int r12 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                char r13 = r9[r13]     // Catch: java.lang.Throwable -> La2
                r2 = r14[r5]     // Catch: java.lang.Throwable -> La2
                int r13 = r13 - r2
                char r13 = (char) r13     // Catch: java.lang.Throwable -> La2
                r9[r12] = r13     // Catch: java.lang.Throwable -> La2
                int r12 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
                int r12 = r12 + r3
                com.apiguard3.internal.setBackgroundTintMode.APIGuard = r12     // Catch: java.lang.Throwable -> La2
                goto L83
            L99:
                java.lang.String r12 = new java.lang.String     // Catch: java.lang.Throwable -> La2
                r12.<init>(r9)     // Catch: java.lang.Throwable -> La2
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La2
                r15[r1] = r12
                return
            La2:
                r12 = move-exception
                monitor-exit(r0)
                goto La6
            La5:
                throw r12
            La6:
                goto La5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.io.ConfigInstance.ConfigSerializationProxy.getSharedInstance(java.lang.String, boolean, int[], java.lang.Object[]):void");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r12 = r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r12, boolean r13, int[] r14, java.lang.Object[] r15) {
        /*
            if (r12 == 0) goto L8
            java.lang.String r0 = "ISO-8859-1"
            byte[] r12 = r12.getBytes(r0)
        L8:
            byte[] r12 = (byte[]) r12
            java.lang.Object r0 = com.apiguard3.internal.setBackgroundTintMode.getSharedInstance
            monitor-enter(r0)
            r1 = 0
            r2 = r14[r1]     // Catch: java.lang.Throwable -> La2
            r3 = 1
            r4 = r14[r3]     // Catch: java.lang.Throwable -> La2
            r5 = 2
            r6 = r14[r5]     // Catch: java.lang.Throwable -> La2
            r7 = 3
            r7 = r14[r7]     // Catch: java.lang.Throwable -> La2
            char[] r8 = com.apiguard3.io.ConfigInstance.getSharedInstance     // Catch: java.lang.Throwable -> La2
            char[] r9 = new char[r4]     // Catch: java.lang.Throwable -> La2
            java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch: java.lang.Throwable -> La2
            if (r12 == 0) goto L54
            char[] r2 = new char[r4]     // Catch: java.lang.Throwable -> La2
            com.apiguard3.internal.setBackgroundTintMode.APIGuard = r1     // Catch: java.lang.Throwable -> La2
            r8 = 0
        L27:
            int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            if (r10 >= r4) goto L53
            int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            r10 = r12[r10]     // Catch: java.lang.Throwable -> La2
            if (r10 != r3) goto L3e
            int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r11 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            char r11 = r9[r11]     // Catch: java.lang.Throwable -> La2
            int r11 = r11 << r3
            int r11 = r11 + r3
            int r11 = r11 - r8
            char r8 = (char) r11     // Catch: java.lang.Throwable -> La2
            r2[r10] = r8     // Catch: java.lang.Throwable -> La2
            goto L49
        L3e:
            int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r11 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            char r11 = r9[r11]     // Catch: java.lang.Throwable -> La2
            int r11 = r11 << r3
            int r11 = r11 - r8
            char r8 = (char) r11     // Catch: java.lang.Throwable -> La2
            r2[r10] = r8     // Catch: java.lang.Throwable -> La2
        L49:
            int r8 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            char r8 = r2[r8]     // Catch: java.lang.Throwable -> La2
            int r10 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r10 = r10 + r3
            com.apiguard3.internal.setBackgroundTintMode.APIGuard = r10     // Catch: java.lang.Throwable -> La2
            goto L27
        L53:
            r9 = r2
        L54:
            if (r7 <= 0) goto L63
            char[] r12 = new char[r4]     // Catch: java.lang.Throwable -> La2
            java.lang.System.arraycopy(r9, r1, r12, r1, r4)     // Catch: java.lang.Throwable -> La2
            int r2 = r4 - r7
            java.lang.System.arraycopy(r12, r1, r9, r2, r7)     // Catch: java.lang.Throwable -> La2
            java.lang.System.arraycopy(r12, r7, r9, r1, r2)     // Catch: java.lang.Throwable -> La2
        L63:
            if (r13 == 0) goto L7f
            char[] r12 = new char[r4]     // Catch: java.lang.Throwable -> La2
            com.apiguard3.internal.setBackgroundTintMode.APIGuard = r1     // Catch: java.lang.Throwable -> La2
        L69:
            int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            if (r13 >= r4) goto L7e
            int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r2 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r2 = r4 - r2
            int r2 = r2 - r3
            char r2 = r9[r2]     // Catch: java.lang.Throwable -> La2
            r12[r13] = r2     // Catch: java.lang.Throwable -> La2
            int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r13 = r13 + r3
            com.apiguard3.internal.setBackgroundTintMode.APIGuard = r13     // Catch: java.lang.Throwable -> La2
            goto L69
        L7e:
            r9 = r12
        L7f:
            if (r6 <= 0) goto L99
            com.apiguard3.internal.setBackgroundTintMode.APIGuard = r1     // Catch: java.lang.Throwable -> La2
        L83:
            int r12 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            if (r12 >= r4) goto L99
            int r12 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r13 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            char r13 = r9[r13]     // Catch: java.lang.Throwable -> La2
            r2 = r14[r5]     // Catch: java.lang.Throwable -> La2
            int r13 = r13 - r2
            char r13 = (char) r13     // Catch: java.lang.Throwable -> La2
            r9[r12] = r13     // Catch: java.lang.Throwable -> La2
            int r12 = com.apiguard3.internal.setBackgroundTintMode.APIGuard     // Catch: java.lang.Throwable -> La2
            int r12 = r12 + r3
            com.apiguard3.internal.setBackgroundTintMode.APIGuard = r12     // Catch: java.lang.Throwable -> La2
            goto L83
        L99:
            java.lang.String r12 = new java.lang.String     // Catch: java.lang.Throwable -> La2
            r12.<init>(r9)     // Catch: java.lang.Throwable -> La2
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La2
            r15[r1] = r12
            return
        La2:
            r12 = move-exception
            monitor-exit(r0)
            goto La6
        La5:
            throw r12
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.io.ConfigInstance.values(java.lang.String, boolean, int[], java.lang.Object[]):void");
    }
}
