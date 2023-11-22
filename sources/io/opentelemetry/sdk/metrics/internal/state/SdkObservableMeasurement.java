package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class SdkObservableMeasurement implements ObservableLongMeasurement, ObservableDoubleMeasurement {
    private static final Logger logger = Logger.getLogger(SdkObservableMeasurement.class.getName());
    @Nullable
    private volatile RegisteredReader activeReader;
    private final InstrumentDescriptor instrumentDescriptor;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final List<AsynchronousMetricStorage<?, ?>> storages;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);

    private SdkObservableMeasurement(InstrumentationScopeInfo instrumentationScopeInfo, InstrumentDescriptor instrumentDescriptor, List<AsynchronousMetricStorage<?, ?>> list) {
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.instrumentDescriptor = instrumentDescriptor;
        this.storages = list;
    }

    public static SdkObservableMeasurement create(InstrumentationScopeInfo instrumentationScopeInfo, InstrumentDescriptor instrumentDescriptor, List<AsynchronousMetricStorage<?, ?>> list) {
        return new SdkObservableMeasurement(instrumentationScopeInfo, instrumentDescriptor, list);
    }

    public final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    public final void setActiveReader(@Nullable RegisteredReader registeredReader) {
        this.activeReader = registeredReader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InstrumentDescriptor getInstrumentDescriptor() {
        return this.instrumentDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<AsynchronousMetricStorage<?, ?>> getStorages() {
        return this.storages;
    }

    @Override // io.opentelemetry.api.metrics.ObservableLongMeasurement
    public final void record(long j) {
        record(j, Attributes.CC.empty());
    }

    @Override // io.opentelemetry.api.metrics.ObservableLongMeasurement
    public final void record(long j, Attributes attributes) {
        RegisteredReader registeredReader = this.activeReader;
        if (registeredReader == null) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.FINE;
            StringBuilder sb = new StringBuilder();
            sb.append("Measurement recorded for instrument ");
            sb.append(this.instrumentDescriptor.getName());
            sb.append(" outside callback registered to instrument. Dropping measurement.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        for (AsynchronousMetricStorage<?, ?> asynchronousMetricStorage : this.storages) {
            if (asynchronousMetricStorage.getRegisteredReader().equals(registeredReader)) {
                asynchronousMetricStorage.recordLong(j, attributes);
            }
        }
    }

    @Override // io.opentelemetry.api.metrics.ObservableDoubleMeasurement
    public final void record(double d) {
        record(d, Attributes.CC.empty());
    }

    @Override // io.opentelemetry.api.metrics.ObservableDoubleMeasurement
    public final void record(double d, Attributes attributes) {
        RegisteredReader registeredReader = this.activeReader;
        if (registeredReader == null) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.FINE;
            StringBuilder sb = new StringBuilder();
            sb.append("Measurement recorded for instrument ");
            sb.append(this.instrumentDescriptor.getName());
            sb.append(" outside callback registered to instrument. Dropping measurement.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        for (AsynchronousMetricStorage<?, ?> asynchronousMetricStorage : this.storages) {
            if (asynchronousMetricStorage.getRegisteredReader().equals(registeredReader)) {
                asynchronousMetricStorage.recordDouble(d, attributes);
            }
        }
    }
}
