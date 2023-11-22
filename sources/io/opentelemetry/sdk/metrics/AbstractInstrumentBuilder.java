package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.SdkObservableMeasurement;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class AbstractInstrumentBuilder<BuilderT extends AbstractInstrumentBuilder<?>> {
    static final String DEFAULT_UNIT = "";
    private String description;
    protected final String instrumentName;
    private final MeterProviderSharedState meterProviderSharedState;
    protected final MeterSharedState meterSharedState;
    private String unit;

    /* JADX INFO: Access modifiers changed from: protected */
    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface SwapBuilder<T> {
        T newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3);
    }

    protected abstract BuilderT getThis();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractInstrumentBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
        this.instrumentName = str;
        this.description = str2;
        this.unit = str3;
        this.meterProviderSharedState = meterProviderSharedState;
        this.meterSharedState = meterSharedState;
    }

    public BuilderT setUnit(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(" Using \"\" for instrument ");
        sb.append(this.instrumentName);
        sb.append(" instead.");
        if (!ValidationUtil.checkValidInstrumentUnit(str, sb.toString())) {
            this.unit = "";
        } else {
            this.unit = str;
        }
        return getThis();
    }

    public BuilderT setDescription(String str) {
        this.description = str;
        return getThis();
    }

    private InstrumentDescriptor makeDescriptor(InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        return InstrumentDescriptor.create(this.instrumentName, this.description, this.unit, instrumentType, instrumentValueType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T swapBuilder(SwapBuilder<T> swapBuilder) {
        return swapBuilder.newBuilder(this.meterProviderSharedState, this.meterSharedState, this.instrumentName, this.description, this.unit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <I extends AbstractInstrument> I buildSynchronousInstrument(InstrumentType instrumentType, InstrumentValueType instrumentValueType, BiFunction<InstrumentDescriptor, WriteableMetricStorage, I> biFunction) {
        InstrumentDescriptor makeDescriptor = makeDescriptor(instrumentType, instrumentValueType);
        return biFunction.apply(makeDescriptor, this.meterSharedState.registerSynchronousMetricStorage(makeDescriptor, this.meterProviderSharedState));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CallbackRegistration registerDoubleAsynchronousInstrument(InstrumentType instrumentType, final Consumer<ObservableDoubleMeasurement> consumer) {
        final SdkObservableMeasurement buildObservableMeasurement = buildObservableMeasurement(instrumentType, InstrumentValueType.DOUBLE);
        CallbackRegistration create = CallbackRegistration.create(Collections.singletonList(buildObservableMeasurement), new Runnable() { // from class: io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Consumer.this.accept(buildObservableMeasurement);
            }
        });
        this.meterSharedState.registerCallback(create);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CallbackRegistration registerLongAsynchronousInstrument(InstrumentType instrumentType, final Consumer<ObservableLongMeasurement> consumer) {
        final SdkObservableMeasurement buildObservableMeasurement = buildObservableMeasurement(instrumentType, InstrumentValueType.LONG);
        CallbackRegistration create = CallbackRegistration.create(Collections.singletonList(buildObservableMeasurement), new Runnable() { // from class: io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Consumer.this.accept(buildObservableMeasurement);
            }
        });
        this.meterSharedState.registerCallback(create);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SdkObservableMeasurement buildObservableMeasurement(InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        return this.meterSharedState.registerObservableMeasurement(makeDescriptor(instrumentType, instrumentValueType));
    }
}
