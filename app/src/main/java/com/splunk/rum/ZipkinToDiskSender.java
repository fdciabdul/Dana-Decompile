package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.sdk.common.Clock;
import j$.util.Collection;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import zipkin2.Call;
import zipkin2.codec.Encoding;
import zipkin2.reporter.Sender;

/* loaded from: classes3.dex */
public class ZipkinToDiskSender extends Sender {
    private final FileUtils BuiltInFictitiousFunctionClassFactory;
    private final SpanStorage MyBillsEntityDataFactory;
    private final Clock PlaceComponentResult;
    private final DeviceSpanStorageLimiter getAuthRequestContext;

    public /* synthetic */ ZipkinToDiskSender(Builder builder, byte b) {
        this(builder);
    }

    private ZipkinToDiskSender(Builder builder) {
        this.MyBillsEntityDataFactory = (SpanStorage) Objects.requireNonNull(builder.KClassImpl$Data$declaredNonStaticMembers$2);
        this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult;
        this.PlaceComponentResult = builder.BuiltInFictitiousFunctionClassFactory;
        this.getAuthRequestContext = (DeviceSpanStorageLimiter) Objects.requireNonNull(builder.MyBillsEntityDataFactory);
    }

    @Override // zipkin2.reporter.Sender
    public final Encoding KClassImpl$Data$declaredNonStaticMembers$2() {
        return Encoding.JSON;
    }

    @Override // zipkin2.reporter.Sender
    public final int PlaceComponentResult(List<byte[]> list) {
        return ((Integer) Collection.EL.getAuthRequestContext(list).MyBillsEntityDataFactory((Stream) 0, (BiFunction<Stream, ? super T, Stream>) new BiFunction() { // from class: com.splunk.rum.ZipkinToDiskSender$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiFunction
            public final /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.MyBillsEntityDataFactory(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Integer valueOf;
                valueOf = Integer.valueOf(((Integer) obj).intValue() + ((byte[]) obj2).length + 1);
                return valueOf;
            }
        }, (BinaryOperator<Stream>) new BandwidthTracker$$ExternalSyntheticLambda4())).intValue();
    }

    @Override // zipkin2.reporter.Sender
    public final Call<Void> MyBillsEntityDataFactory(List<byte[]> list) {
        if (!this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dropping ");
            sb.append(list.size());
            sb.append(" spans: Too much telemetry has been buffered or not enough space on device.");
            InstrumentInjector.log_e("SplunkRum", sb.toString());
            return Call.getAuthRequestContext();
        }
        long now = this.PlaceComponentResult.now();
        File KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(now);
        sb2.append(".spans");
        try {
            FileUtils.getAuthRequestContext(new File(KClassImpl$Data$declaredNonStaticMembers$2, sb2.toString()), list);
        } catch (IOException e) {
            InstrumentInjector.log_e("SplunkRum", "Error writing spans to storage", e);
        }
        return Call.getAuthRequestContext();
    }

    public static Builder PlaceComponentResult() {
        return new Builder();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        SpanStorage KClassImpl$Data$declaredNonStaticMembers$2;
        DeviceSpanStorageLimiter MyBillsEntityDataFactory;
        FileUtils PlaceComponentResult = new FileUtils();
        private Clock BuiltInFictitiousFunctionClassFactory = Clock.CC.getDefault();

        Builder() {
        }
    }
}
