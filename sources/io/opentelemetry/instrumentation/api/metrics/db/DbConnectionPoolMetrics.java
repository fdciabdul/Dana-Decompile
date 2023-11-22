package io.opentelemetry.instrumentation.api.metrics.db;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.BatchCallback;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.api.metrics.ObservableMeasurement;
import io.opentelemetry.instrumentation.api.internal.EmbeddedInstrumentationProperties;

/* loaded from: classes9.dex */
public final class DbConnectionPoolMetrics {
    static final String STATE_IDLE = "idle";
    static final String STATE_USED = "used";
    private final Attributes attributes;
    private final Attributes idleConnectionsAttributes;
    private final Meter meter;
    private final Attributes usedConnectionsAttributes;
    static final AttributeKey<String> POOL_NAME = AttributeKey.CC.stringKey("pool.name");
    static final AttributeKey<String> CONNECTION_STATE = AttributeKey.CC.stringKey("state");

    public static DbConnectionPoolMetrics create(OpenTelemetry openTelemetry, String str, String str2) {
        MeterBuilder meterBuilder = openTelemetry.getMeterProvider().meterBuilder(str);
        String findVersion = EmbeddedInstrumentationProperties.findVersion(str);
        if (findVersion != null) {
            meterBuilder.setInstrumentationVersion(findVersion);
        }
        return new DbConnectionPoolMetrics(meterBuilder.build(), Attributes.CC.of(POOL_NAME, str2));
    }

    DbConnectionPoolMetrics(Meter meter, Attributes attributes) {
        this.meter = meter;
        this.attributes = attributes;
        AttributesBuilder builder = attributes.toBuilder();
        AttributeKey<String> attributeKey = CONNECTION_STATE;
        this.usedConnectionsAttributes = builder.put((AttributeKey<AttributeKey<String>>) attributeKey, (AttributeKey<String>) STATE_USED).build();
        this.idleConnectionsAttributes = attributes.toBuilder().put((AttributeKey<AttributeKey<String>>) attributeKey, (AttributeKey<String>) STATE_IDLE).build();
    }

    public final ObservableLongMeasurement connections() {
        return this.meter.upDownCounterBuilder("db.client.connections.usage").setUnit("connections").setDescription("The number of connections that are currently in state described by the state attribute.").buildObserver();
    }

    public final ObservableLongMeasurement minIdleConnections() {
        return this.meter.upDownCounterBuilder("db.client.connections.idle.min").setUnit("connections").setDescription("The minimum number of idle open connections allowed.").buildObserver();
    }

    public final ObservableLongMeasurement maxIdleConnections() {
        return this.meter.upDownCounterBuilder("db.client.connections.idle.max").setUnit("connections").setDescription("The maximum number of idle open connections allowed.").buildObserver();
    }

    public final ObservableLongMeasurement maxConnections() {
        return this.meter.upDownCounterBuilder("db.client.connections.max").setUnit("connections").setDescription("The maximum number of open connections allowed.").buildObserver();
    }

    public final ObservableLongMeasurement pendingRequestsForConnection() {
        return this.meter.upDownCounterBuilder("db.client.connections.pending_requests").setUnit("requests").setDescription("The number of pending requests for an open connection, cumulative for the entire pool.").buildObserver();
    }

    public final BatchCallback batchCallback(Runnable runnable, ObservableMeasurement observableMeasurement, ObservableMeasurement... observableMeasurementArr) {
        return this.meter.batchCallback(runnable, observableMeasurement, observableMeasurementArr);
    }

    public final LongCounter connectionTimeouts() {
        return this.meter.counterBuilder("db.client.connections.timeouts").setUnit("timeouts").setDescription("The number of connection timeouts that have occurred trying to obtain a connection from the pool.").build();
    }

    public final DoubleHistogram connectionCreateTime() {
        return this.meter.histogramBuilder("db.client.connections.create_time").setUnit("ms").setDescription("The time it took to create a new connection.").build();
    }

    public final DoubleHistogram connectionWaitTime() {
        return this.meter.histogramBuilder("db.client.connections.wait_time").setUnit("ms").setDescription("The time it took to obtain an open connection from the pool.").build();
    }

    public final DoubleHistogram connectionUseTime() {
        return this.meter.histogramBuilder("db.client.connections.use_time").setUnit("ms").setDescription("The time between borrowing a connection and returning it to the pool.").build();
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final Attributes getUsedConnectionsAttributes() {
        return this.usedConnectionsAttributes;
    }

    public final Attributes getIdleConnectionsAttributes() {
        return this.idleConnectionsAttributes;
    }
}
