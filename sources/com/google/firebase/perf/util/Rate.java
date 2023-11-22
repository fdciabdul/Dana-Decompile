package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Rate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long numTimeUnits;
    private long numTokensPerTotalTimeUnit;
    private TimeUnit timeUnit;

    public Rate(long j, long j2, TimeUnit timeUnit) {
        this.numTokensPerTotalTimeUnit = j;
        this.numTimeUnits = j2;
        this.timeUnit = timeUnit;
    }

    /* renamed from: com.google.firebase.perf.util.Rate$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public double getTokensPerSeconds() {
        double d;
        double nanos;
        int i = AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[this.timeUnit.ordinal()];
        if (i == 1) {
            double d2 = this.numTokensPerTotalTimeUnit;
            double d3 = this.numTimeUnits;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = d2 / d3;
            nanos = TimeUnit.SECONDS.toNanos(1L);
            Double.isNaN(nanos);
        } else if (i == 2) {
            double d4 = this.numTokensPerTotalTimeUnit;
            double d5 = this.numTimeUnits;
            Double.isNaN(d4);
            Double.isNaN(d5);
            d = d4 / d5;
            nanos = TimeUnit.SECONDS.toMicros(1L);
            Double.isNaN(nanos);
        } else if (i == 3) {
            double d6 = this.numTokensPerTotalTimeUnit;
            double d7 = this.numTimeUnits;
            Double.isNaN(d6);
            Double.isNaN(d7);
            d = d6 / d7;
            nanos = TimeUnit.SECONDS.toMillis(1L);
            Double.isNaN(nanos);
        } else {
            double d8 = this.numTokensPerTotalTimeUnit;
            double seconds = this.timeUnit.toSeconds(this.numTimeUnits);
            Double.isNaN(d8);
            Double.isNaN(seconds);
            return d8 / seconds;
        }
        return d * nanos;
    }
}
