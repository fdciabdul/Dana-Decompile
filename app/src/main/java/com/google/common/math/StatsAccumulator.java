package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class StatsAccumulator {
    private long count = 0;
    private double mean = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private double sumOfSquaresOfDeltas = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private double min = Double.NaN;
    private double max = Double.NaN;

    public final void add(double d) {
        long j = this.count;
        if (j == 0) {
            this.count = 1L;
            this.mean = d;
            this.min = d;
            this.max = d;
            if (Doubles.isFinite(d)) {
                return;
            }
            this.sumOfSquaresOfDeltas = Double.NaN;
            return;
        }
        this.count = j + 1;
        if (Doubles.isFinite(d) && Doubles.isFinite(this.mean)) {
            double d2 = this.mean;
            double d3 = d - d2;
            double d4 = this.count;
            Double.isNaN(d4);
            double d5 = d2 + (d3 / d4);
            this.mean = d5;
            this.sumOfSquaresOfDeltas += d3 * (d - d5);
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
    }

    public final void addAll(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public final void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public final void addAll(double... dArr) {
        for (double d : dArr) {
            add(d);
        }
    }

    public final void addAll(int... iArr) {
        for (int i : iArr) {
            add(i);
        }
    }

    public final void addAll(long... jArr) {
        for (long j : jArr) {
            add(j);
        }
    }

    public final void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        merge(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
    }

    public final void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() == 0) {
            return;
        }
        merge(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.sumOfSquaresOfDeltas(), statsAccumulator.min(), statsAccumulator.max());
    }

    private void merge(long j, double d, double d2, double d3, double d4) {
        long j2 = this.count;
        if (j2 == 0) {
            this.count = j;
            this.mean = d;
            this.sumOfSquaresOfDeltas = d2;
            this.min = d3;
            this.max = d4;
            return;
        }
        this.count = j2 + j;
        if (Doubles.isFinite(this.mean) && Doubles.isFinite(d)) {
            double d5 = this.mean;
            double d6 = d - d5;
            double d7 = j;
            double d8 = this.count;
            Double.isNaN(d7);
            Double.isNaN(d8);
            double d9 = d5 + ((d6 * d7) / d8);
            this.mean = d9;
            double d10 = this.sumOfSquaresOfDeltas;
            Double.isNaN(d7);
            this.sumOfSquaresOfDeltas = d10 + d2 + (d6 * (d - d9) * d7);
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d3);
        this.max = Math.max(this.max, d4);
    }

    public final Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final long count() {
        return this.count;
    }

    public final double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public final double sum() {
        double d = this.mean;
        double d2 = this.count;
        Double.isNaN(d2);
        return d * d2;
    }

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double ensureNonNegative = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        double d = this.count;
        Double.isNaN(d);
        return ensureNonNegative / d;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        double ensureNonNegative = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        double d = this.count - 1;
        Double.isNaN(d);
        return ensureNonNegative / d;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public final double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double calculateNewMeanNonFinite(double d, double d2) {
        if (Doubles.isFinite(d)) {
            return d2;
        }
        if (Doubles.isFinite(d2) || d == d2) {
            return d;
        }
        return Double.NaN;
    }
}
