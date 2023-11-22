package com.splunk.rum;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import j$.util.Map;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import zipkin2.reporter.Sender;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FileSender {
    private final RetryTracker BuiltInFictitiousFunctionClassFactory;
    private final FileUtils MyBillsEntityDataFactory;
    private final BandwidthTracker PlaceComponentResult;
    private final Sender getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ FileSender(Builder builder, byte b) {
        this(builder);
    }

    private FileSender(Builder builder) {
        this.getAuthRequestContext = (Sender) Objects.requireNonNull(builder.MyBillsEntityDataFactory);
        this.MyBillsEntityDataFactory = builder.getAuthRequestContext;
        this.PlaceComponentResult = (BandwidthTracker) Objects.requireNonNull(builder.KClassImpl$Data$declaredNonStaticMembers$2);
        this.BuiltInFictitiousFunctionClassFactory = Builder.PlaceComponentResult(builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reading file content for ingest: ");
        sb.append(file);
        InstrumentInjector.log_d("SplunkRum", sb.toString());
        List<byte[]> PlaceComponentResult = PlaceComponentResult(file);
        if (PlaceComponentResult.isEmpty()) {
            return false;
        }
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(file, PlaceComponentResult);
        if (!KClassImpl$Data$declaredNonStaticMembers$2) {
            RetryTracker retryTracker = this.BuiltInFictitiousFunctionClassFactory;
            Integer num = (Integer) Map.EL.BuiltInFictitiousFunctionClassFactory(retryTracker.KClassImpl$Data$declaredNonStaticMembers$2, file, 1, new BiFunction() { // from class: com.splunk.rum.FileSender$RetryTracker$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Integer valueOf;
                    Integer num2 = (Integer) obj2;
                    valueOf = Integer.valueOf(((Integer) obj).intValue() + 1);
                    return valueOf;
                }
            });
            if (num.intValue() >= retryTracker.MyBillsEntityDataFactory) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Dropping data in ");
                sb2.append(file);
                sb2.append(" (max retries exceeded ");
                sb2.append(retryTracker.MyBillsEntityDataFactory);
                sb2.append(")");
                InstrumentInjector.log_w("SplunkRum", sb2.toString());
            } else {
                retryTracker.getAuthRequestContext.accept(num);
            }
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 || this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(file)) {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.remove(file);
            FileUtils.initRecordTimeStamp(file);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(File file, List<byte[]> list) {
        try {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(list);
            this.getAuthRequestContext.MyBillsEntityDataFactory(list).PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append("File content ");
            sb.append(file);
            sb.append(" successfully uploaded");
            InstrumentInjector.log_d("SplunkRum", sb.toString());
            return true;
        } catch (IOException e) {
            InstrumentInjector.log_w("SplunkRum", "Error sending file content", e);
            return false;
        }
    }

    private List<byte[]> PlaceComponentResult(File file) {
        try {
            return FileUtils.moveToNextValue(file);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error reading span data from file ");
            sb.append(file);
            InstrumentInjector.log_w("SplunkRum", sb.toString(), e);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RetryTracker {
        final java.util.Map<File, Integer> KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        final Consumer<Integer> getAuthRequestContext;

        /* synthetic */ RetryTracker(int i, Consumer consumer, byte b) {
            this(i, consumer);
        }

        private RetryTracker(int i, Consumer<Integer> consumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
            this.MyBillsEntityDataFactory = i;
            this.getAuthRequestContext = consumer;
        }

        final boolean BuiltInFictitiousFunctionClassFactory(File file) {
            return ((Integer) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2((java.util.Map) this.KClassImpl$Data$declaredNonStaticMembers$2, (Object) file, (Object) 0)).intValue() >= this.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes3.dex */
    static class DefaultBackoff implements Consumer<Integer> {
        public static final byte[] getAuthRequestContext = {45, -61, Ascii.ETB, 105, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 10;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 3
                int r6 = r6 + 13
                int r7 = r7 * 7
                int r7 = 106 - r7
                byte[] r0 = com.splunk.rum.FileSender.DefaultBackoff.getAuthRequestContext
                int r8 = r8 * 12
                int r8 = 15 - r8
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L19
                r4 = r7
                r3 = 0
                r7 = r6
                goto L30
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r6) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                int r8 = r8 + 1
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r7
                r7 = r6
                r6 = r5
            L30:
                int r4 = -r4
                int r6 = r6 + r4
                int r6 = r6 + 2
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.splunk.rum.FileSender.DefaultBackoff.a(short, short, short, java.lang.Object[]):void");
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer<Integer> andThen(Consumer<? super Integer> consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        DefaultBackoff() {
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ void accept(Integer num) {
            try {
                TimeUnit.SECONDS.sleep(Math.min(60, num.intValue() * 5));
            } catch (InterruptedException e) {
                InstrumentInjector.log_w("SplunkRum", "Error during backoff", e);
                try {
                    byte b = (byte) (-getAuthRequestContext[15]);
                    byte b2 = (byte) (b - 1);
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (getAuthRequestContext[15] + 1);
                    byte b4 = (byte) (-getAuthRequestContext[15]);
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Builder {
        BandwidthTracker KClassImpl$Data$declaredNonStaticMembers$2;
        Sender MyBillsEntityDataFactory;
        private FileUtils getAuthRequestContext = new FileUtils();
        private int PlaceComponentResult = 20;
        private Consumer<Integer> BuiltInFictitiousFunctionClassFactory = new DefaultBackoff();

        Builder() {
        }

        static /* synthetic */ RetryTracker PlaceComponentResult(Builder builder) {
            return new RetryTracker(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    }
}
