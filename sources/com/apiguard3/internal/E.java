package com.apiguard3.internal;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class E implements getSharedInstance, Serializable {
    private static boolean APIGuard = true;
    private static int generateHeaders = 1;
    private static final long serialVersionUID = -2194429445620376626L;
    private static int values;
    private final AtomicReference<String> payload;
    private static char[] valueOf = {'p', 142, 128, ';', '^', 145, 136, 'k', '|', 148, 135, 138, Ascii.MAX, 'n', 141, 132, 149, 143, 137, 147};
    private static int getSharedInstance = 27;
    private static boolean AGState = true;

    static /* synthetic */ AtomicReference APIGuard(E e) {
        int i = generateHeaders + 95;
        int i2 = i % 128;
        values = i2;
        boolean z = i % 2 != 0;
        AtomicReference<String> atomicReference = e.payload;
        if (z) {
            throw new NullPointerException();
        }
        generateHeaders = (i2 + 123) % 128;
        return atomicReference;
    }

    public E() {
        this("");
    }

    public E(String str) {
        this.payload = new AtomicReference<>(str == null ? "" : str);
    }

    @Override // com.apiguard3.internal.getSharedInstance
    public final String AGState() {
        values = (generateHeaders + 97) % 128;
        String str = this.payload.get();
        int i = values + 11;
        generateHeaders = i % 128;
        if (i % 2 != 0) {
            return str;
        }
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.getSharedInstance
    public final void values(String str) {
        String str2 = this.payload.get();
        String str3 = new String(str);
        values = (generateHeaders + 67) % 128;
        while ((!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.payload, str2, str3)) != false) {
            int i = generateHeaders + 111;
            values = i % 128;
            boolean z = i % 2 != 0;
            String str4 = this.payload.get();
            if (z) {
                throw null;
            }
            str2 = str4;
        }
    }

    protected final Object writeReplace() throws ObjectStreamException {
        CvmPayloadSerializationProxy cvmPayloadSerializationProxy = new CvmPayloadSerializationProxy(this);
        values = (generateHeaders + 111) % 128;
        return cvmPayloadSerializationProxy;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = new Object[1];
        AGState(127 - (ViewConfiguration.getTapTimeout() >> 16), null, null, "\u008d\u0089\u0083\u0092\u0082\u0093\u0090\u0084\u008a\u0094\u008c\u008f\u0088\u0093\u008c\u0090\u0092\u0089\u0091\u0090\u008b\u0089\u0090\u008f\u0083\u008e\u008d\u0089\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", objArr);
        throw new InvalidObjectException(((String) objArr[0]).intern());
    }

    /* loaded from: classes7.dex */
    public static final class CvmPayloadSerializationProxy implements Serializable {
        private static int AGState = 0;
        private static long APIGuard = 7528946436489862725L;
        private static char getSharedInstance = 0;
        private static final long serialVersionUID = 1283480018427592438L;
        private static int valueOf = 1;
        private static int values;
        private final String payload;
        private final byte[] shaHash = AGState();

        CvmPayloadSerializationProxy(E e) {
            this.payload = (String) E.APIGuard(e).get();
        }

        protected final Object readResolve() throws ObjectStreamException {
            AGState = (valueOf + 117) % 128;
            if (Arrays.equals(AGState(), this.shaHash)) {
                E e = new E(this.payload);
                int i = valueOf + 119;
                AGState = i % 128;
                if (i % 2 == 0) {
                    return e;
                }
                throw new NullPointerException();
            }
            return null;
        }

        private byte[] AGState() {
            valueOf = (AGState + 77) % 128;
            String str = this.payload;
            Object[] objArr = new Object[1];
            values((char) (55656 - (ViewConfiguration.getEdgeSlop() >> 16)), TextUtils.indexOf("", "") - 512249502, "䫵䆐䠧⼴ʶ", "\ude45ퟫヤ桼", "拖瞱棡裙", objArr);
            byte[] bytes = str.getBytes(Charset.forName(((String) objArr[0]).intern()));
            Object[] objArr2 = new Object[1];
            values((char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 49241), TextUtils.indexOf("", "", 0, 0), "숬\udf1fד䍯꼴墦精킥᜵῝㇢劣唹寨籠쾘\ue84f玦ኻ劭넏\udfe3\uf52b藆〤뼨鶰ꁪ㦩㡵", "\ude45ퟫヤ桼", "\uec38ᠯ夘峀", objArr2);
            String intern = ((String) objArr2[0]).intern();
            Object[] objArr3 = new Object[1];
            values((char) (TextUtils.lastIndexOf("", '0') + 55657), MotionEvent.axisFromString("") - 512249501, "䫵䆐䠧⼴ʶ", "\ude45ퟫヤ桼", "拖瞱棡裙", objArr3);
            try {
                byte[] bArr = (byte[]) ((Class) AGState.values((-16770643) - Color.rgb(0, 0, 0), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (1942 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("APIGuard", byte[].class, byte[].class).invoke(null, bytes, intern.getBytes(Charset.forName(((String) objArr3[0]).intern())));
                AGState = (valueOf + 53) % 128;
                return bArr;
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
        private static void values(char r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Object[] r13) {
            /*
                if (r12 == 0) goto L6
                char[] r12 = r12.toCharArray()
            L6:
                char[] r12 = (char[]) r12
                if (r11 == 0) goto Le
                char[] r11 = r11.toCharArray()
            Le:
                char[] r11 = (char[]) r11
                if (r10 == 0) goto L16
                char[] r10 = r10.toCharArray()
            L16:
                char[] r10 = (char[]) r10
                java.lang.Object r0 = com.apiguard3.internal.setForegroundGravity.AGState
                monitor-enter(r0)
                java.lang.Object r12 = r12.clone()     // Catch: java.lang.Throwable -> L94
                char[] r12 = (char[]) r12     // Catch: java.lang.Throwable -> L94
                java.lang.Object r11 = r11.clone()     // Catch: java.lang.Throwable -> L94
                char[] r11 = (char[]) r11     // Catch: java.lang.Throwable -> L94
                r1 = 0
                char r2 = r12[r1]     // Catch: java.lang.Throwable -> L94
                r8 = r8 ^ r2
                char r8 = (char) r8     // Catch: java.lang.Throwable -> L94
                r12[r1] = r8     // Catch: java.lang.Throwable -> L94
                r8 = 2
                char r2 = r11[r8]     // Catch: java.lang.Throwable -> L94
                char r9 = (char) r9     // Catch: java.lang.Throwable -> L94
                int r2 = r2 + r9
                char r9 = (char) r2     // Catch: java.lang.Throwable -> L94
                r11[r8] = r9     // Catch: java.lang.Throwable -> L94
                int r9 = r10.length     // Catch: java.lang.Throwable -> L94
                char[] r2 = new char[r9]     // Catch: java.lang.Throwable -> L94
                com.apiguard3.internal.setForegroundGravity.valueOf = r1     // Catch: java.lang.Throwable -> L94
            L3b:
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                if (r3 >= r9) goto L8b
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r3 = r3 + r8
                int r3 = r3 % 4
                int r4 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r4 = r4 + 3
                int r4 = r4 % 4
                int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r5 = r5 % 4
                char r5 = r12[r5]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 * 32718
                char r6 = r11[r3]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 + r6
                r6 = 65535(0xffff, float:9.1834E-41)
                int r5 = r5 % r6
                char r5 = (char) r5     // Catch: java.lang.Throwable -> L94
                com.apiguard3.internal.setForegroundGravity.APIGuard = r5     // Catch: java.lang.Throwable -> L94
                char r5 = r12[r4]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 * 32718
                char r3 = r11[r3]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 + r3
                int r5 = r5 / r6
                char r3 = (char) r5     // Catch: java.lang.Throwable -> L94
                r11[r4] = r3     // Catch: java.lang.Throwable -> L94
                char r3 = com.apiguard3.internal.setForegroundGravity.APIGuard     // Catch: java.lang.Throwable -> L94
                r12[r4] = r3     // Catch: java.lang.Throwable -> L94
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                char r5 = r10[r5]     // Catch: java.lang.Throwable -> L94
                char r4 = r12[r4]     // Catch: java.lang.Throwable -> L94
                r4 = r4 ^ r5
                long r4 = (long) r4     // Catch: java.lang.Throwable -> L94
                long r6 = com.apiguard3.internal.E.CvmPayloadSerializationProxy.APIGuard     // Catch: java.lang.Throwable -> L94
                long r4 = r4 ^ r6
                int r6 = com.apiguard3.internal.E.CvmPayloadSerializationProxy.values     // Catch: java.lang.Throwable -> L94
                long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
                long r4 = r4 ^ r6
                char r6 = com.apiguard3.internal.E.CvmPayloadSerializationProxy.getSharedInstance     // Catch: java.lang.Throwable -> L94
                long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
                long r4 = r4 ^ r6
                int r5 = (int) r4     // Catch: java.lang.Throwable -> L94
                char r4 = (char) r5     // Catch: java.lang.Throwable -> L94
                r2[r3] = r4     // Catch: java.lang.Throwable -> L94
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r3 = r3 + 1
                com.apiguard3.internal.setForegroundGravity.valueOf = r3     // Catch: java.lang.Throwable -> L94
                goto L3b
            L8b:
                java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L94
                r8.<init>(r2)     // Catch: java.lang.Throwable -> L94
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
                r13[r1] = r8
                return
            L94:
                r8 = move-exception
                monitor-exit(r0)
                goto L98
            L97:
                throw r8
            L98:
                goto L97
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.E.CvmPayloadSerializationProxy.values(char, int, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r9 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AGState(int r6, java.lang.String r7, int[] r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.E.AGState(int, java.lang.String, int[], java.lang.String, java.lang.Object[]):void");
    }
}
