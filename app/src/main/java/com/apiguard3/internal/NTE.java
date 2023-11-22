package com.apiguard3.internal;

import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import com.google.common.base.Ascii;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes7.dex */
public class NTE<TaskResult> {
    private static char AGState = 26156;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_CHR, -70, 75, 72, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = WSContextConstant.HANDSHAKE_RECEIVE_SIZE;
    private static char analyzeResponse = 48175;
    private static char getRequestHeaders = 22314;
    private static char getSharedInstance = 50924;
    private static int initialize = 0;
    private static int parseResponseHeaders = 1;
    private int APIGuard;
    private int valueOf;
    private ExecutorService values;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 12
            int r8 = 15 - r8
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r0 = com.apiguard3.internal.NTE.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2e
        L17:
            r3 = 0
        L18:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.NTE.a(int, byte, short, java.lang.Object[]):void");
    }

    public NTE() {
        this((byte) 0);
    }

    private NTE(byte b) {
        this.valueOf = 2;
        this.APIGuard = 2;
        this.values = Executors.newFixedThreadPool(1);
    }

    public final TaskResult getSharedInstance(MT<TaskResult> mt) {
        synchronized (this) {
            int i = parseResponseHeaders + 39;
            initialize = i % 128;
            if (i % 2 != 0) {
                throw new ArithmeticException();
            }
            int i2 = this.APIGuard;
            int i3 = this.valueOf;
            Future future = null;
            while (true) {
                if (i2 <= 0) {
                    return null;
                }
                try {
                    try {
                        future = this.values.submit(mt);
                        TaskResult taskresult = (TaskResult) future.get(i3, TimeUnit.SECONDS);
                        initialize = (parseResponseHeaders + 123) % 128;
                        return taskresult;
                    } catch (TimeoutException unused) {
                        readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.spi, mt.values());
                        if (future != null && !future.isDone()) {
                            future.cancel(true);
                            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.APIGuard;
                            Object[] objArr = new Object[1];
                            AGState("\u038b碆잡翭蠾祍ꫪ䖟ಬ丂ほ尞\ued70権Ḙ\ue5cb풿귤〪蒢", 19 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr);
                            readResolve.values(valuesVar, ((String) objArr[0]).intern());
                        }
                        i2--;
                        this.values.shutdownNow();
                        this.values = Executors.newFixedThreadPool(1);
                        i3 <<= 1;
                        if ((i2 > 0 ? '5' : (char) 16) != 16) {
                            parseResponseHeaders = (initialize + 105) % 128;
                            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.sc, mt.values());
                        }
                    } catch (Throwable th) {
                        ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.values;
                        writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.cs;
                        StringBuilder sb = new StringBuilder();
                        sb.append(mt.values());
                        Object[] objArr2 = new Object[1];
                        AGState("\ue95d踱", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr2);
                        sb.append(((String) objArr2[0]).intern());
                        sb.append(th.toString());
                        readResolve.getSharedInstance(valuesVar2, aPIGuard, sb.toString());
                        return null;
                    }
                } catch (InterruptedException unused2) {
                    readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.ss, mt.values());
                    try {
                        byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                        byte b2 = b;
                        Object[] objArr3 = new Object[1];
                        a(b, b2, b2, objArr3);
                        Class<?> cls = Class.forName((String) objArr3[0]);
                        byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                        byte b4 = b3;
                        Object[] objArr4 = new Object[1];
                        a(b3, b4, b4, objArr4);
                        ((Thread) cls.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
                        return null;
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r13 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AGState(java.lang.String r13, int r14, java.lang.Object[] r15) {
        /*
            if (r13 == 0) goto L6
            char[] r13 = r13.toCharArray()
        L6:
            char[] r13 = (char[]) r13
            java.lang.Object r0 = com.apiguard3.internal.setBackgroundDrawable.getSharedInstance
            monitor-enter(r0)
            int r1 = r13.length     // Catch: java.lang.Throwable -> L7a
            char[] r1 = new char[r1]     // Catch: java.lang.Throwable -> L7a
            r2 = 0
            com.apiguard3.internal.setBackgroundDrawable.valueOf = r2     // Catch: java.lang.Throwable -> L7a
            r3 = 2
            char[] r4 = new char[r3]     // Catch: java.lang.Throwable -> L7a
        L14:
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            int r6 = r13.length     // Catch: java.lang.Throwable -> L7a
            if (r5 >= r6) goto L71
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
            r4[r2] = r5     // Catch: java.lang.Throwable -> L7a
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            r6 = 1
            int r5 = r5 + r6
            char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
            r4[r6] = r5     // Catch: java.lang.Throwable -> L7a
            r5 = 58224(0xe370, float:8.1589E-41)
            r7 = 0
        L2b:
            r8 = 16
            if (r7 >= r8) goto L5e
            char r8 = r4[r6]     // Catch: java.lang.Throwable -> L7a
            char r9 = r4[r2]     // Catch: java.lang.Throwable -> L7a
            int r10 = r9 + r5
            int r11 = r9 << 4
            char r12 = com.apiguard3.internal.NTE.getRequestHeaders     // Catch: java.lang.Throwable -> L7a
            int r11 = r11 + r12
            r10 = r10 ^ r11
            int r11 = r9 >>> 5
            char r12 = com.apiguard3.internal.NTE.analyzeResponse     // Catch: java.lang.Throwable -> L7a
            int r11 = r11 + r12
            r10 = r10 ^ r11
            int r8 = r8 - r10
            char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
            r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
            char r10 = com.apiguard3.internal.NTE.getSharedInstance     // Catch: java.lang.Throwable -> L7a
            int r11 = r8 >>> 5
            char r12 = com.apiguard3.internal.NTE.AGState     // Catch: java.lang.Throwable -> L7a
            int r11 = r11 + r12
            int r12 = r8 + r5
            int r8 = r8 << 4
            int r8 = r8 + r10
            r8 = r8 ^ r12
            r8 = r8 ^ r11
            int r9 = r9 - r8
            char r8 = (char) r9     // Catch: java.lang.Throwable -> L7a
            r4[r2] = r8     // Catch: java.lang.Throwable -> L7a
            r8 = 40503(0x9e37, float:5.6757E-41)
            int r5 = r5 - r8
            int r7 = r7 + 1
            goto L2b
        L5e:
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            char r7 = r4[r2]     // Catch: java.lang.Throwable -> L7a
            r1[r5] = r7     // Catch: java.lang.Throwable -> L7a
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            int r5 = r5 + r6
            char r6 = r4[r6]     // Catch: java.lang.Throwable -> L7a
            r1[r5] = r6     // Catch: java.lang.Throwable -> L7a
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            int r5 = r5 + r3
            com.apiguard3.internal.setBackgroundDrawable.valueOf = r5     // Catch: java.lang.Throwable -> L7a
            goto L14
        L71:
            java.lang.String r13 = new java.lang.String     // Catch: java.lang.Throwable -> L7a
            r13.<init>(r1, r2, r14)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7a
            r15[r2] = r13
            return
        L7a:
            r13 = move-exception
            monitor-exit(r0)
            goto L7e
        L7d:
            throw r13
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.NTE.AGState(java.lang.String, int, java.lang.Object[]):void");
    }
}
