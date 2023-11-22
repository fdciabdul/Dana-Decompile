package com.google.firebase.perf.metrics;

import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TraceMetricBuilder {
    private final Trace trace;

    public TraceMetricBuilder(Trace trace) {
        this.trace = trace;
    }

    public TraceMetric build() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(this.trace.getName()).setClientStartTimeUs(this.trace.getStartTime().getMicros()).setDurationUs(this.trace.getStartTime().getDurationMicros(this.trace.getEndTime()));
        for (Counter counter : this.trace.getCounters().values()) {
            durationUs.putCounters(counter.getName(), counter.getCount());
        }
        List<Trace> subtraces = this.trace.getSubtraces();
        if (!subtraces.isEmpty()) {
            Iterator<Trace> it = subtraces.iterator();
            while (it.hasNext()) {
                durationUs.addSubtraces(new TraceMetricBuilder(it.next()).build());
            }
        }
        durationUs.putAllCustomAttributes(this.trace.getAttributes());
        PerfSession[] buildAndSort = com.google.firebase.perf.session.PerfSession.buildAndSort(this.trace.getSessions());
        if (buildAndSort != null) {
            durationUs.addAllPerfSessions(Arrays.asList(buildAndSort));
        }
        return durationUs.build();
    }
}
