package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.export.MetricProducer;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import io.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import io.opentelemetry.sdk.resources.Resource;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class SdkMeterProvider implements MeterProvider, Closeable {
    static final String DEFAULT_METER_NAME = "unknown";
    private static final Logger LOGGER = Logger.getLogger(SdkMeterProvider.class.getName());
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final List<RegisteredReader> registeredReaders;
    private final List<RegisteredView> registeredViews;
    private final ComponentRegistry<SdkMeter> registry;
    private final MeterProviderSharedState sharedState;

    @Override // io.opentelemetry.api.metrics.MeterProvider
    public final /* synthetic */ Meter get(String str) {
        Meter build;
        build = meterBuilder(str).build();
        return build;
    }

    public static SdkMeterProviderBuilder builder() {
        return new SdkMeterProviderBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeterProvider(final List<RegisteredView> list, List<MetricReader> list2, Clock clock, Resource resource, ExemplarFilter exemplarFilter) {
        long now = clock.now();
        this.registeredViews = list;
        List<RegisteredReader> list3 = (List) Collection.EL.getAuthRequestContext(list2).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.sdk.metrics.SdkMeterProvider$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                RegisteredReader create;
                create = RegisteredReader.create(r2, ViewRegistry.create((MetricReader) obj, list));
                return create;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
        this.registeredReaders = list3;
        this.sharedState = MeterProviderSharedState.create(clock, resource, exemplarFilter, now);
        this.registry = new ComponentRegistry<>(new Function() { // from class: io.opentelemetry.sdk.metrics.SdkMeterProvider$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return SdkMeterProvider.this.m3158lambda$new$1$ioopentelemetrysdkmetricsSdkMeterProvider((InstrumentationScopeInfo) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
        for (RegisteredReader registeredReader : list3) {
            registeredReader.getReader().register(new LeasedMetricProducer(this.registry, this.sharedState, registeredReader));
            registeredReader.setLastCollectEpochNanos(now);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$io-opentelemetry-sdk-metrics-SdkMeterProvider  reason: not valid java name */
    public final /* synthetic */ SdkMeter m3158lambda$new$1$ioopentelemetrysdkmetricsSdkMeterProvider(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkMeter(this.sharedState, instrumentationScopeInfo, this.registeredReaders);
    }

    @Override // io.opentelemetry.api.metrics.MeterProvider
    public final MeterBuilder meterBuilder(String str) {
        if (this.registeredReaders.isEmpty()) {
            return MeterProvider.CC.noop().meterBuilder(str);
        }
        if (str == null || str.isEmpty()) {
            LOGGER.fine("Meter requested without instrumentation scope name.");
            str = "unknown";
        }
        return new SdkMeterBuilder(this.registry, str);
    }

    public final void resetForTest() {
        Iterable.EL.MyBillsEntityDataFactory(this.registry.getComponents(), new Consumer() { // from class: io.opentelemetry.sdk.metrics.SdkMeterProvider$$ExternalSyntheticLambda3
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                ((SdkMeter) obj).resetForTest();
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.PlaceComponentResult(this, consumer);
            }
        });
    }

    public final CompletableResultCode forceFlush() {
        if (this.registeredReaders.isEmpty()) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<RegisteredReader> it = this.registeredReaders.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getReader().forceFlush());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    public final CompletableResultCode shutdown() {
        if (!this.isClosed.compareAndSet(false, true)) {
            LOGGER.info("Multiple close calls");
            return CompletableResultCode.ofSuccess();
        } else if (this.registeredReaders.isEmpty()) {
            return CompletableResultCode.ofSuccess();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<RegisteredReader> it = this.registeredReaders.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getReader().shutdown());
            }
            return CompletableResultCode.ofAll(arrayList);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SdkMeterProvider{clock=");
        sb.append(this.sharedState.getClock());
        sb.append(", resource=");
        sb.append(this.sharedState.getResource());
        sb.append(", metricReaders=");
        sb.append(Collection.EL.getAuthRequestContext(this.registeredReaders).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.sdk.metrics.SdkMeterProvider$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ((RegisteredReader) obj).getReader();
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory()));
        sb.append(", views=");
        sb.append(this.registeredViews);
        sb.append("}");
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    static class LeasedMetricProducer implements MetricProducer {
        private final RegisteredReader registeredReader;
        private final ComponentRegistry<SdkMeter> registry;
        private final MeterProviderSharedState sharedState;

        LeasedMetricProducer(ComponentRegistry<SdkMeter> componentRegistry, MeterProviderSharedState meterProviderSharedState, RegisteredReader registeredReader) {
            this.registry = componentRegistry;
            this.sharedState = meterProviderSharedState;
            this.registeredReader = registeredReader;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.export.MetricProducer
        public java.util.Collection<MetricData> collectAllMetrics() {
            java.util.Collection<SdkMeter> components = this.registry.getComponents();
            ArrayList arrayList = new ArrayList();
            long now = this.sharedState.getClock().now();
            Iterator<SdkMeter> it = components.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().collectAll(this.registeredReader, now));
            }
            this.registeredReader.setLastCollectEpochNanos(now);
            return Collections.unmodifiableCollection(arrayList);
        }
    }
}
