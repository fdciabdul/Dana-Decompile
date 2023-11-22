package zipkin2.reporter;

import com.google.common.base.Ascii;
import java.io.Flushable;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Call;
import zipkin2.Component;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;

/* loaded from: classes9.dex */
public abstract class AsyncReporter<S> extends Component implements Reporter<S>, Flushable {

    /* loaded from: classes9.dex */
    public static final class Builder {
    }

    /* renamed from: zipkin2.reporter.AsyncReporter$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Encoding.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Encoding.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Encoding.PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Encoding.THRIFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BoundedAsyncReporter<S> extends AsyncReporter<S> {
        private boolean GetContactSyncConfig;
        final long KClassImpl$Data$declaredNonStaticMembers$2;
        final CountDownLatch MyBillsEntityDataFactory;
        final AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        final AtomicBoolean PlaceComponentResult;
        final BytesEncoder<S> getAuthRequestContext;
        final int getErrorConfigVersion;
        final ByteBoundedQueue<S> lookAheadTest;
        final Sender moveToNextValue;
        final ReporterMetrics scheduleImpl;
        public static final byte[] DatabaseTableConfigUtil = {Ascii.ETB, -59, 18, 83, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda2 = 128;
        static final Logger BuiltInFictitiousFunctionClassFactory = Logger.getLogger(BoundedAsyncReporter.class.getName());

        /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x003b). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 3
                int r6 = 16 - r6
                byte[] r0 = zipkin2.reporter.AsyncReporter.BoundedAsyncReporter.DatabaseTableConfigUtil
                int r7 = r7 + 4
                int r8 = r8 * 7
                int r8 = 106 - r8
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L1b
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L3b
            L1b:
                r3 = 0
                r5 = r8
                r8 = r7
                r7 = r5
            L1f:
                int r8 = r8 + 1
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r6) goto L2e
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2e:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L3b:
                int r8 = r8 + r6
                int r6 = r8 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1f
            */
            throw new UnsupportedOperationException("Method not decompiled: zipkin2.reporter.AsyncReporter.BoundedAsyncReporter.a(int, int, byte, java.lang.Object[]):void");
        }

        @Override // java.io.Flushable
        public final void flush() {
            if (this.PlaceComponentResult.get()) {
                throw new ClosedSenderException();
            }
            KClassImpl$Data$declaredNonStaticMembers$2(BufferNextMessage.MyBillsEntityDataFactory(this.getAuthRequestContext.encoding(), this.getErrorConfigVersion));
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(BufferNextMessage<S> bufferNextMessage) {
            this.lookAheadTest.PlaceComponentResult(bufferNextMessage, bufferNextMessage.PlaceComponentResult());
            this.scheduleImpl.getAuthRequestContext(this.lookAheadTest.PlaceComponentResult);
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest.getErrorConfigVersion);
            if (bufferNextMessage.getAuthRequestContext() || this.PlaceComponentResult.get()) {
                this.scheduleImpl.getAuthRequestContext();
                this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(bufferNextMessage.KClassImpl$Data$declaredNonStaticMembers$2);
                final ArrayList arrayList = new ArrayList(bufferNextMessage.scheduleImpl.size());
                bufferNextMessage.PlaceComponentResult(new SpanWithSizeConsumer<S>() { // from class: zipkin2.reporter.AsyncReporter.BoundedAsyncReporter.1
                    @Override // zipkin2.reporter.SpanWithSizeConsumer
                    public final boolean PlaceComponentResult(S s, int i) {
                        arrayList.add(BoundedAsyncReporter.this.getAuthRequestContext.encode(s));
                        if (BoundedAsyncReporter.this.moveToNextValue.PlaceComponentResult(arrayList) > BoundedAsyncReporter.this.getErrorConfigVersion) {
                            ArrayList arrayList2 = arrayList;
                            arrayList2.remove(arrayList2.size() - 1);
                            return false;
                        }
                        return true;
                    }
                });
                try {
                    this.moveToNextValue.MyBillsEntityDataFactory(arrayList).PlaceComponentResult();
                } catch (Throwable th) {
                    int size = arrayList.size();
                    Call.KClassImpl$Data$declaredNonStaticMembers$2(th);
                    this.scheduleImpl.MyBillsEntityDataFactory(th);
                    this.scheduleImpl.PlaceComponentResult(size);
                    Level level = Level.FINE;
                    if (this.GetContactSyncConfig) {
                        BuiltInFictitiousFunctionClassFactory.log(Level.WARNING, "Spans were dropped due to exceptions. All subsequent errors will be logged at FINE level.");
                        level = Level.WARNING;
                        this.GetContactSyncConfig = false;
                    }
                    Logger logger = BuiltInFictitiousFunctionClassFactory;
                    if (logger.isLoggable(level)) {
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(size);
                        objArr[1] = th.getClass().getSimpleName();
                        objArr[2] = th.getMessage() == null ? "" : th.getMessage();
                        logger.log(level, String.format("Dropped %s spans due to %s(%s)", objArr), (Throwable) th);
                    }
                    if (th instanceof ClosedSenderException) {
                        throw th;
                    }
                    if ((th instanceof IllegalStateException) && th.getMessage().equals("closed")) {
                        throw th;
                    }
                }
            }
        }

        @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.PlaceComponentResult.compareAndSet(false, true)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.set(true);
                try {
                    if (!this.MyBillsEntityDataFactory.await(this.KClassImpl$Data$declaredNonStaticMembers$2, TimeUnit.NANOSECONDS)) {
                        BuiltInFictitiousFunctionClassFactory.warning("Timed out waiting for in-flight spans to send");
                    }
                } catch (InterruptedException unused) {
                    BuiltInFictitiousFunctionClassFactory.warning("Interrupted waiting for in-flight spans to send");
                    try {
                        Object[] objArr = new Object[1];
                        a((byte) (DatabaseTableConfigUtil[15] - 1), DatabaseTableConfigUtil[22], (byte) (DatabaseTableConfigUtil[15] - 1), objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b = DatabaseTableConfigUtil[15];
                        Object[] objArr2 = new Object[1];
                        a(b, (byte) (-b), DatabaseTableConfigUtil[15], objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                int authRequestContext = this.lookAheadTest.getAuthRequestContext();
                if (authRequestContext > 0) {
                    this.scheduleImpl.PlaceComponentResult(authRequestContext);
                    Logger logger = BuiltInFictitiousFunctionClassFactory;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Dropped ");
                    sb.append(authRequestContext);
                    sb.append(" spans due to AsyncReporter.close()");
                    logger.warning(sb.toString());
                }
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncReporter{");
            sb.append(this.moveToNextValue);
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    static final class Flusher<S> implements Runnable {
        static final Logger KClassImpl$Data$declaredNonStaticMembers$2 = Logger.getLogger(Flusher.class.getName());
        final BoundedAsyncReporter<S> MyBillsEntityDataFactory;
        final BufferNextMessage<S> getAuthRequestContext;

        @Override // java.lang.Runnable
        public final void run() {
            while (!this.MyBillsEntityDataFactory.PlaceComponentResult.get()) {
                try {
                    try {
                        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
                    } catch (Error | RuntimeException e) {
                        KClassImpl$Data$declaredNonStaticMembers$2.log(Level.WARNING, "Unexpected error flushing spans", e);
                        throw e;
                    }
                } finally {
                    int size = this.getAuthRequestContext.scheduleImpl.size();
                    if (size > 0) {
                        this.MyBillsEntityDataFactory.scheduleImpl.PlaceComponentResult(size);
                        Logger logger = KClassImpl$Data$declaredNonStaticMembers$2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Dropped ");
                        sb.append(size);
                        sb.append(" spans due to AsyncReporter.close()");
                        logger.warning(sb.toString());
                    }
                    this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.countDown();
                }
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncReporter{");
            sb.append(this.MyBillsEntityDataFactory.moveToNextValue);
            sb.append("}");
            return sb.toString();
        }
    }
}
