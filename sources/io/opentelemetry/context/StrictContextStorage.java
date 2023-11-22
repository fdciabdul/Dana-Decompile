package io.opentelemetry.context;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.opentelemetry.context.StrictContextStorage;
import io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap;
import io.opentelemetry.context.internal.shaded.WeakConcurrentMap;
import j$.util.Collection;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class StrictContextStorage implements ContextStorage, AutoCloseable {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {117, -10, 119, -11, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
    public static final int getAuthRequestContext = 89;
    private static final Logger logger = Logger.getLogger(StrictContextStorage.class.getName());
    private final ContextStorage delegate;
    private final PendingScopes pendingScopes = PendingScopes.create();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = io.opentelemetry.context.StrictContextStorage.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 + 4
            int r9 = r9 * 15
            int r9 = 27 - r9
            int r7 = r7 * 3
            int r7 = 106 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r7 = r9
            r3 = r1
            r4 = 0
            r9 = r8
            r1 = r0
            r0 = r10
            r10 = r7
            goto L37
        L19:
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L1d:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L37:
            int r10 = r10 + r8
            int r8 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.context.StrictContextStorage.a(int, byte, short, java.lang.Object[]):void");
    }

    @Override // io.opentelemetry.context.ContextStorage
    public final /* synthetic */ Context root() {
        Context root;
        root = ArrayBasedContext.root();
        return root;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StrictContextStorage create(ContextStorage contextStorage) {
        return new StrictContextStorage(contextStorage);
    }

    private StrictContextStorage(ContextStorage contextStorage) {
        this.delegate = contextStorage;
    }

    @Override // io.opentelemetry.context.ContextStorage
    public final Scope attach(Context context) {
        int i;
        Scope attach = this.delegate.attach(context);
        CallerStackTrace callerStackTrace = new CallerStackTrace(context);
        StackTraceElement[] stackTrace = callerStackTrace.getStackTrace();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[16];
                Object[] objArr = new Object[1];
                a(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[16], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (getAuthRequestContext & 7);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[18]);
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 & 7), objArr2);
                if (((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null)).equals(Context.class.getName()) && stackTraceElement.getMethodName().equals("makeCurrent") && (i = i2 + 2) < stackTrace.length) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    try {
                        byte b4 = BuiltInFictitiousFunctionClassFactory[16];
                        Object[] objArr3 = new Object[1];
                        a(b4, (byte) (b4 - 1), BuiltInFictitiousFunctionClassFactory[16], objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b5 = (byte) (getAuthRequestContext & 7);
                        byte b6 = (byte) (-BuiltInFictitiousFunctionClassFactory[18]);
                        Object[] objArr4 = new Object[1];
                        a(b5, b6, (byte) (b6 & 7), objArr4);
                        if (((String) cls2.getMethod((String) objArr4[0], null).invoke(stackTraceElement2, null)).equals("kotlin.coroutines.jvm.internal.BaseContinuationImpl") && stackTraceElement2.getMethodName().equals("resumeWith")) {
                            throw new AssertionError("Attempting to call Context.makeCurrent from inside a Kotlin coroutine. This is not allowed. Use Context.asContextElement provided by opentelemetry-extension-kotlin instead of makeCurrent.");
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        int i3 = 1;
        while (i3 < stackTrace.length) {
            StackTraceElement stackTraceElement3 = stackTrace[i3];
            try {
                byte b7 = BuiltInFictitiousFunctionClassFactory[16];
                Object[] objArr5 = new Object[1];
                a(b7, (byte) (b7 - 1), BuiltInFictitiousFunctionClassFactory[16], objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                byte b8 = (byte) (getAuthRequestContext & 7);
                byte b9 = (byte) (-BuiltInFictitiousFunctionClassFactory[18]);
                Object[] objArr6 = new Object[1];
                a(b8, b9, (byte) (b9 & 7), objArr6);
                String str = (String) cls3.getMethod((String) objArr6[0], null).invoke(stackTraceElement3, null);
                if (!str.startsWith("io.opentelemetry.api.") && !str.startsWith("io.opentelemetry.sdk.testing.context.SettableContextStorageProvider") && !str.startsWith("io.opentelemetry.context.")) {
                    break;
                }
                i3++;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        }
        callerStackTrace.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3, stackTrace.length));
        return new StrictScope(attach, callerStackTrace);
    }

    @Override // io.opentelemetry.context.ContextStorage
    @Nullable
    public final Context current() {
        return this.delegate.current();
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.pendingScopes.expungeStaleEntries();
        List<CallerStackTrace> drainPendingCallers = this.pendingScopes.drainPendingCallers();
        if (drainPendingCallers.isEmpty()) {
            return;
        }
        if (drainPendingCallers.size() > 1) {
            logger.log(Level.SEVERE, "Multiple scopes leaked - first will be thrown as an error.");
            Iterator<CallerStackTrace> it = drainPendingCallers.iterator();
            while (it.hasNext()) {
                logger.log(Level.SEVERE, "Scope leaked", (Throwable) callerError(it.next()));
            }
        }
        throw callerError(drainPendingCallers.get(0));
    }

    /* loaded from: classes6.dex */
    final class StrictScope implements Scope {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {41, -91, 83, 107, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
        public static final int MyBillsEntityDataFactory = 191;
        final CallerStackTrace caller;
        final Scope delegate;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 + 99
                byte[] r0 = io.opentelemetry.context.StrictContextStorage.StrictScope.BuiltInFictitiousFunctionClassFactory
                int r6 = 27 - r6
                int r7 = r7 + 4
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L31
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r3 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L31:
                int r6 = -r6
                int r9 = r9 + r6
                int r6 = r9 + 2
                int r8 = r8 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.context.StrictContextStorage.StrictScope.a(int, int, byte, java.lang.Object[]):void");
        }

        StrictScope(Scope scope, CallerStackTrace callerStackTrace) {
            this.delegate = scope;
            this.caller = callerStackTrace;
            StrictContextStorage.this.pendingScopes.put(this, callerStackTrace);
        }

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public final void close() {
            this.caller.closed = true;
            StrictContextStorage.this.pendingScopes.remove(this);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                try {
                    byte b = BuiltInFictitiousFunctionClassFactory[43];
                    Object[] objArr = new Object[1];
                    a(b, (byte) (b | Ascii.ESC), (byte) (-BuiltInFictitiousFunctionClassFactory[8]), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[19], BuiltInFictitiousFunctionClassFactory[57], objArr2);
                    if (((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null)).equals(StrictScope.class.getName()) && stackTraceElement.getMethodName().equals("close")) {
                        int i2 = i + 2;
                        int i3 = i + 1;
                        if (i3 < stackTrace.length) {
                            StackTraceElement stackTraceElement2 = stackTrace[i3];
                            try {
                                byte b2 = BuiltInFictitiousFunctionClassFactory[43];
                                Object[] objArr3 = new Object[1];
                                a(b2, (byte) (b2 | Ascii.ESC), (byte) (-BuiltInFictitiousFunctionClassFactory[8]), objArr3);
                                Class<?> cls2 = Class.forName((String) objArr3[0]);
                                Object[] objArr4 = new Object[1];
                                a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[19], BuiltInFictitiousFunctionClassFactory[57], objArr4);
                                if (((String) cls2.getMethod((String) objArr4[0], null).invoke(stackTraceElement2, null)).equals("kotlin.jdk7.AutoCloseableKt") && stackTraceElement2.getMethodName().equals("closeFinally") && i2 < stackTrace.length) {
                                    i2 = i + 3;
                                }
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        if (stackTrace[i2].getMethodName().equals("invokeSuspend")) {
                            i2++;
                        }
                        if (i2 < stackTrace.length) {
                            StackTraceElement stackTraceElement3 = stackTrace[i2];
                            try {
                                byte b3 = BuiltInFictitiousFunctionClassFactory[43];
                                Object[] objArr5 = new Object[1];
                                a(b3, (byte) (b3 | Ascii.ESC), (byte) (-BuiltInFictitiousFunctionClassFactory[8]), objArr5);
                                Class<?> cls3 = Class.forName((String) objArr5[0]);
                                Object[] objArr6 = new Object[1];
                                a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[19], BuiltInFictitiousFunctionClassFactory[57], objArr6);
                                if (((String) cls3.getMethod((String) objArr6[0], null).invoke(stackTraceElement3, null)).equals("kotlin.coroutines.jvm.internal.BaseContinuationImpl") && stackTraceElement3.getMethodName().equals("resumeWith")) {
                                    throw new AssertionError("Attempting to close a Scope created by Context.makeCurrent from inside a Kotlin coroutine. This is not allowed. Use Context.asContextElement provided by opentelemetry-extension-kotlin instead of makeCurrent.");
                                }
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
            try {
                byte b4 = BuiltInFictitiousFunctionClassFactory[16];
                Object[] objArr7 = new Object[1];
                a(b4, (byte) (b4 + 1), (byte) (-BuiltInFictitiousFunctionClassFactory[8]), objArr7);
                Class<?> cls4 = Class.forName((String) objArr7[0]);
                byte b5 = (byte) (MyBillsEntityDataFactory & 14);
                byte b6 = BuiltInFictitiousFunctionClassFactory[43];
                Object[] objArr8 = new Object[1];
                a(b5, b6, b6, objArr8);
                if (((Thread) cls4.getMethod((String) objArr8[0], null).invoke(null, null)).getId() != this.caller.threadId) {
                    Object[] objArr9 = new Object[2];
                    objArr9[0] = this.caller.threadName;
                    try {
                        byte b7 = BuiltInFictitiousFunctionClassFactory[16];
                        Object[] objArr10 = new Object[1];
                        a(b7, (byte) (b7 + 1), (byte) (-BuiltInFictitiousFunctionClassFactory[8]), objArr10);
                        Class<?> cls5 = Class.forName((String) objArr10[0]);
                        byte b8 = (byte) (MyBillsEntityDataFactory & 14);
                        byte b9 = BuiltInFictitiousFunctionClassFactory[43];
                        Object[] objArr11 = new Object[1];
                        a(b8, b9, b9, objArr11);
                        objArr9[1] = ((Thread) cls5.getMethod((String) objArr11[0], null).invoke(null, null)).getName();
                        throw new IllegalStateException(String.format("Thread [%s] opened scope, but thread [%s] closed it", objArr9), this.caller);
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                }
                this.delegate.close();
            } catch (Throwable th5) {
                Throwable cause5 = th5.getCause();
                if (cause5 == null) {
                    throw th5;
                }
                throw cause5;
            }
        }

        public final String toString() {
            String message = this.caller.getMessage();
            return message == null ? super.toString() : message;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CallerStackTrace extends Throwable {
        public static final byte[] MyBillsEntityDataFactory = {71, Ascii.US, 113, 39, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int getAuthRequestContext = 60;
        volatile boolean closed;
        final Context context;
        final long threadId;
        final String threadName;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 7
                int r8 = r8 + 99
                byte[] r0 = io.opentelemetry.context.StrictContextStorage.CallerStackTrace.MyBillsEntityDataFactory
                int r7 = r7 + 4
                int r9 = r9 * 3
                int r9 = r9 + 13
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                goto L35
            L19:
                r3 = 0
            L1a:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r9) goto L29
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L29:
                int r7 = r7 + 1
                r3 = r0[r7]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L35:
                int r9 = r9 + r7
                int r7 = r9 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.context.StrictContextStorage.CallerStackTrace.a(byte, int, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        CallerStackTrace(io.opentelemetry.context.Context r11) {
            /*
                Method dump skipped, instructions count: 245
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.context.StrictContextStorage.CallerStackTrace.<init>(io.opentelemetry.context.Context):void");
        }
    }

    /* loaded from: classes6.dex */
    static class PendingScopes extends WeakConcurrentMap<Scope, CallerStackTrace> {
        private final ConcurrentHashMap<AbstractWeakConcurrentMap.WeakKey<Scope>, CallerStackTrace> map;

        static PendingScopes create() {
            return new PendingScopes(new ConcurrentHashMap());
        }

        PendingScopes(ConcurrentHashMap<AbstractWeakConcurrentMap.WeakKey<Scope>, CallerStackTrace> concurrentHashMap) {
            super(false, false, concurrentHashMap);
            this.map = concurrentHashMap;
            Thread thread = new Thread(this);
            thread.setName("weak-ref-cleaner-strictcontextstorage");
            thread.setPriority(1);
            thread.setDaemon(true);
            thread.start();
        }

        List<CallerStackTrace> drainPendingCallers() {
            List<CallerStackTrace> list = (List) Collection.EL.getAuthRequestContext(this.map.values()).getAuthRequestContext(new Predicate() { // from class: io.opentelemetry.context.StrictContextStorage$PendingScopes$$ExternalSyntheticLambda0
                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate negate() {
                    return Predicate.CC.PlaceComponentResult(this);
                }

                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    return StrictContextStorage.PendingScopes.lambda$drainPendingCallers$0((StrictContextStorage.CallerStackTrace) obj);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
            this.map.clear();
            return list;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$drainPendingCallers$0(CallerStackTrace callerStackTrace) {
            return !callerStackTrace.closed;
        }

        @Override // io.opentelemetry.context.internal.shaded.WeakConcurrentMap, io.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Runnable
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    CallerStackTrace remove = this.map.remove(remove());
                    if (remove != null && !remove.closed) {
                        StrictContextStorage.logger.log(Level.SEVERE, "Scope garbage collected before being closed.", (Throwable) StrictContextStorage.callerError(remove));
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    static AssertionError callerError(CallerStackTrace callerStackTrace) {
        StringBuilder sb = new StringBuilder();
        sb.append("Thread [");
        sb.append(callerStackTrace.threadName);
        sb.append("] opened a scope of ");
        sb.append(callerStackTrace.context);
        sb.append(" here:");
        AssertionError assertionError = new AssertionError(sb.toString());
        assertionError.setStackTrace(callerStackTrace.getStackTrace());
        return assertionError;
    }
}
