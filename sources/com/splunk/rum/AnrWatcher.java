package com.splunk.rum;

import android.os.Handler;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.function.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class AnrWatcher implements Runnable {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, 93, -14, -126, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 250;
    private final Supplier<SplunkRum> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Thread MyBillsEntityDataFactory;
    private final AtomicInteger getAuthRequestContext = new AtomicInteger();
    private final Handler getErrorConfigVersion;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 + 4
            byte[] r0 = com.splunk.rum.AnrWatcher.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 3
            int r8 = 106 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.splunk.rum.AnrWatcher.a(byte, short, short, java.lang.Object[]):void");
    }

    public AnrWatcher(Handler handler, Thread thread, Supplier<SplunkRum> supplier) {
        this.getErrorConfigVersion = handler;
        this.MyBillsEntityDataFactory = thread;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = supplier;
    }

    @Override // java.lang.Runnable
    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (this.getErrorConfigVersion.post(new AnrWatcher$$ExternalSyntheticLambda0(countDownLatch))) {
            try {
                if (countDownLatch.await(1L, TimeUnit.SECONDS)) {
                    this.getAuthRequestContext.set(0);
                } else if (this.getAuthRequestContext.incrementAndGet() >= 5) {
                    Thread thread = this.MyBillsEntityDataFactory;
                    try {
                        Object[] objArr = new Object[1];
                        a(BuiltInFictitiousFunctionClassFactory[30], BuiltInFictitiousFunctionClassFactory[22], BuiltInFictitiousFunctionClassFactory[9], objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        Object[] objArr2 = new Object[1];
                        a(BuiltInFictitiousFunctionClassFactory[9], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[30], objArr2);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.get().BuiltInFictitiousFunctionClassFactory().spanBuilder("ANR").setAttribute((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_STACKTRACE, (AttributeKey<String>) SplunkRum.BuiltInFictitiousFunctionClassFactory((StackTraceElement[]) cls.getMethod((String) objArr2[0], null).invoke(thread, null))).setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) "error").startSpan().setStatus(StatusCode.ERROR).end();
                        this.getAuthRequestContext.set(0);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
            } catch (InterruptedException unused) {
            }
        }
    }
}
