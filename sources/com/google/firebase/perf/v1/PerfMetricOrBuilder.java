package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface PerfMetricOrBuilder extends MessageLiteOrBuilder {
    ApplicationInfo getApplicationInfo();

    GaugeMetric getGaugeMetric();

    NetworkRequestMetric getNetworkRequestMetric();

    TraceMetric getTraceMetric();

    TransportInfo getTransportInfo();

    boolean hasApplicationInfo();

    boolean hasGaugeMetric();

    boolean hasNetworkRequestMetric();

    boolean hasTraceMetric();

    boolean hasTransportInfo();
}
