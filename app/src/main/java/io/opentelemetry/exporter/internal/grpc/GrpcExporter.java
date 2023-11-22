package io.opentelemetry.exporter.internal.grpc;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.grpc.Channel;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.sdk.common.CompletableResultCode;
import j$.util.function.BiFunction;
import j$.util.function.Supplier;
import java.net.URI;

/* loaded from: classes9.dex */
public interface GrpcExporter<T extends Marshaler> {
    CompletableResultCode export(T t, int i);

    CompletableResultCode shutdown();

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.exporter.internal.grpc.GrpcExporter$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC<T extends Marshaler> {
        public static <T extends Marshaler> GrpcExporterBuilder<T> builder(String str, String str2, long j, URI uri, Supplier<BiFunction<Channel, String, MarshalerServiceStub<T, ?, ?>>> supplier, String str3) {
            return new GrpcExporterBuilder<>(str, str2, j, uri, supplier, str3);
        }
    }
}
