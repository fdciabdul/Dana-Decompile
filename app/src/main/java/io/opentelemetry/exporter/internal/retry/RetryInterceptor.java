package io.opentelemetry.exporter.internal.retry;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import j$.util.function.Function;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes9.dex */
public final class RetryInterceptor implements Interceptor {
    private final Function<Response, Boolean> isRetryable;
    private final Function<IOException, Boolean> isRetryableException;
    private final BoundedLongGenerator randomLong;
    private final RetryPolicy retryPolicy;
    private final Sleeper sleeper;
    public static final byte[] PlaceComponentResult = {112, 117, 112, -122, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 125;

    /* loaded from: classes9.dex */
    interface BoundedLongGenerator {
        long get(long j);
    }

    /* loaded from: classes9.dex */
    interface Sleeper {
        void sleep(long j) throws InterruptedException;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = io.opentelemetry.exporter.internal.retry.RetryInterceptor.PlaceComponentResult
            int r6 = r6 * 7
            int r6 = r6 + 99
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r5 = r5 * 12
            int r5 = r5 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r6
            r3 = 0
            r6 = r5
            goto L2b
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L27:
            r4 = r0[r5]
            int r3 = r3 + 1
        L2b:
            int r4 = -r4
            int r5 = r5 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.exporter.internal.retry.RetryInterceptor.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RetryInterceptor(io.opentelemetry.exporter.internal.retry.RetryPolicy r7, j$.util.function.Function<okhttp3.Response, java.lang.Boolean> r8) {
        /*
            r6 = this;
            io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda0 r3 = new io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda0
            r3.<init>()
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            java.util.Objects.requireNonNull(r0)
            io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda1 r4 = new io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda1
            r4.<init>()
            io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda2 r5 = new io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda2
            r5.<init>()
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.exporter.internal.retry.RetryInterceptor.<init>(io.opentelemetry.exporter.internal.retry.RetryPolicy, j$.util.function.Function):void");
    }

    RetryInterceptor(RetryPolicy retryPolicy, Function<Response, Boolean> function, Function<IOException, Boolean> function2, Sleeper sleeper, BoundedLongGenerator boundedLongGenerator) {
        this.retryPolicy = retryPolicy;
        this.isRetryable = function;
        this.isRetryableException = function2;
        this.sleeper = sleeper;
        this.randomLong = boundedLongGenerator;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        long nanos = this.retryPolicy.getInitialBackoff().toNanos();
        Response response = null;
        IOException e = null;
        int i = 0;
        do {
            if (i > 0) {
                long j = this.randomLong.get(Math.min(nanos, this.retryPolicy.getMaxBackoff().toNanos()));
                double d = nanos;
                double backoffMultiplier = this.retryPolicy.getBackoffMultiplier();
                Double.isNaN(d);
                nanos = (long) (d * backoffMultiplier);
                try {
                    try {
                        this.sleeper.sleep(j);
                        if (response != null) {
                            response.close();
                        }
                    } catch (InterruptedException unused) {
                        byte b = (byte) (-PlaceComponentResult[15]);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (PlaceComponentResult[15] + 1);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            i++;
            try {
                response = chain.proceed(chain.request());
            } catch (IOException e2) {
                e = e2;
            }
            if (response != null && !Boolean.TRUE.equals(this.isRetryable.apply(response))) {
                return response;
            }
            if (e != null && !Boolean.TRUE.equals(this.isRetryableException.apply(e))) {
                throw e;
            }
        } while (i < this.retryPolicy.getMaxAttempts());
        if (response != null) {
            return response;
        }
        throw e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isRetryableException(IOException iOException) {
        if (iOException instanceof SocketTimeoutException) {
            String message = iOException.getMessage();
            return message == null || message.toLowerCase().contains("connect timed out");
        }
        return false;
    }
}
