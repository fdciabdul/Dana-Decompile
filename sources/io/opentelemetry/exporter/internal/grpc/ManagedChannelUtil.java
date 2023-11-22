package io.opentelemetry.exporter.internal.grpc;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.opentelemetry.exporter.internal.TlsUtil;
import io.opentelemetry.exporter.internal.retry.RetryPolicy;
import io.opentelemetry.exporter.internal.retry.RetryUtil;
import io.opentelemetry.sdk.common.CompletableResultCode;
import j$.util.Collection;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes9.dex */
public final class ManagedChannelUtil {
    public static final byte[] PlaceComponentResult = {16, -117, -56, -112, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int MyBillsEntityDataFactory = 209;
    private static final Logger logger = Logger.getLogger(ManagedChannelUtil.class.getName());

    private static void a(short s, int i, byte b, Object[] objArr) {
        int i2 = 15 - (b * 12);
        int i3 = 16 - (i * 3);
        byte[] bArr = PlaceComponentResult;
        int i4 = 106 - (s * 7);
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4 = i4 + (-i6) + 2;
            i6 = i6;
            i2 = i2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i2 + 1;
            i4 = i4 + (-bArr[i8]) + 2;
            i6 = i6;
            i2 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    public static void setClientKeysAndTrustedCertificatesPem(ManagedChannelBuilder<?> managedChannelBuilder, @Nullable byte[] bArr, @Nullable byte[] bArr2, byte[] bArr3) throws SSLException {
        Objects.requireNonNull(managedChannelBuilder, "managedChannelBuilder");
        Objects.requireNonNull(bArr3, "trustedCertificatesPem");
        X509TrustManager trustManager = TlsUtil.trustManager(bArr3);
        X509KeyManager keyManager = (bArr == null || bArr2 == null) ? null : TlsUtil.keyManager(bArr, bArr2);
        if (managedChannelBuilder.getClass().getName().equals("io.grpc.netty.NettyChannelBuilder")) {
            ((NettyChannelBuilder) managedChannelBuilder).sslContext(GrpcSslContexts.forClient().keyManager(keyManager).trustManager(trustManager).build());
        } else if (managedChannelBuilder.getClass().getName().equals("io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder")) {
            ((io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder) managedChannelBuilder).sslContext(io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts.forClient().trustManager(trustManager).keyManager(keyManager).build());
        } else if (managedChannelBuilder.getClass().getName().equals("io.grpc.okhttp.OkHttpChannelBuilder")) {
            ((OkHttpChannelBuilder) managedChannelBuilder).sslSocketFactory(TlsUtil.sslSocketFactory(keyManager, trustManager));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("TLS certificate configuration not supported for unrecognized ManagedChannelBuilder ");
            sb.append(managedChannelBuilder.getClass().getName());
            throw new SSLException(sb.toString());
        }
    }

    public static Map<String, ?> toServiceConfig(String str, RetryPolicy retryPolicy) {
        List list = (List) Collection.EL.getAuthRequestContext(RetryUtil.retryableGrpcStatusCodes()).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.exporter.internal.grpc.ManagedChannelUtil$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(Double.parseDouble((String) obj));
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
        HashMap hashMap = new HashMap();
        hashMap.put("retryableStatusCodes", list);
        hashMap.put("maxAttempts", Double.valueOf(retryPolicy.getMaxAttempts()));
        StringBuilder sb = new StringBuilder();
        double millis = retryPolicy.getInitialBackoff().toMillis();
        Double.isNaN(millis);
        sb.append(millis / 1000.0d);
        sb.append("s");
        hashMap.put("initialBackoff", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        double millis2 = retryPolicy.getMaxBackoff().toMillis();
        Double.isNaN(millis2);
        sb2.append(millis2 / 1000.0d);
        sb2.append("s");
        hashMap.put("maxBackoff", sb2.toString());
        hashMap.put("backoffMultiplier", Double.valueOf(retryPolicy.getBackoffMultiplier()));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("name", Collections.singletonList(Collections.singletonMap("service", str)));
        hashMap2.put("retryPolicy", hashMap);
        return Collections.singletonMap("methodConfig", Collections.singletonList(hashMap2));
    }

    public static CompletableResultCode shutdownChannel(final ManagedChannel managedChannel) {
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        managedChannel.shutdown();
        Thread thread = new Thread(new Runnable() { // from class: io.opentelemetry.exporter.internal.grpc.ManagedChannelUtil$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ManagedChannelUtil.lambda$shutdownChannel$0(managedChannel, completableResultCode);
            }
        });
        thread.setDaemon(true);
        thread.setName("grpc-cleanup");
        thread.start();
        return completableResultCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$shutdownChannel$0(ManagedChannel managedChannel, CompletableResultCode completableResultCode) {
        try {
            managedChannel.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            try {
                byte b = (byte) (PlaceComponentResult[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-PlaceComponentResult[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                logger.log(Level.WARNING, "Failed to shutdown the gRPC channel", (Throwable) e);
                completableResultCode.fail();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        completableResultCode.succeed();
    }

    private ManagedChannelUtil() {
    }
}
