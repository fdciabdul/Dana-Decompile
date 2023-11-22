package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class PairedStatsAccumulator {
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();
    private double sumOfProductsOfDeltas = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    private double ensurePositive(double d) {
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d;
        }
        return Double.MIN_VALUE;
    }

    public final void add(double d, double d2) {
        this.xStats.add(d);
        if (!Doubles.isFinite(d) || !Doubles.isFinite(d2)) {
            this.sumOfProductsOfDeltas = Double.NaN;
        } else if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (d - this.xStats.mean()) * (d2 - this.yStats.mean());
        }
        this.yStats.add(d2);
    }

    public final void addAll(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.xStats.addAll(pairedStats.xStats());
        if (this.yStats.count() == 0) {
            this.sumOfProductsOfDeltas = pairedStats.sumOfProductsOfDeltas();
        } else {
            double d = this.sumOfProductsOfDeltas;
            double sumOfProductsOfDeltas = pairedStats.sumOfProductsOfDeltas();
            double mean = pairedStats.xStats().mean();
            double mean2 = this.xStats.mean();
            double mean3 = pairedStats.yStats().mean();
            double mean4 = this.yStats.mean();
            double count = pairedStats.count();
            Double.isNaN(count);
            this.sumOfProductsOfDeltas = d + sumOfProductsOfDeltas + ((mean - mean2) * (mean3 - mean4) * count);
        }
        this.yStats.addAll(pairedStats.yStats());
    }

    public final PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public final long count() {
        return this.xStats.count();
    }

    public final Stats xStats() {
        return this.xStats.snapshot();
    }

    public final Stats yStats() {
        return this.yStats.snapshot();
    }

    public final double populationCovariance() {
        Preconditions.checkState(count() != 0);
        double d = this.sumOfProductsOfDeltas;
        double count = count();
        Double.isNaN(count);
        return d / count;
    }

    public final double sampleCovariance() {
        Preconditions.checkState(count() > 1);
        double d = this.sumOfProductsOfDeltas;
        double count = count() - 1;
        Double.isNaN(count);
        return d / count;
    }

    public final double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        Preconditions.checkState(sumOfSquaresOfDeltas > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        Preconditions.checkState(sumOfSquaresOfDeltas2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public final LinearTransformation leastSquaresFit() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return LinearTransformation.vertical(this.xStats.mean());
        } else if (this.yStats.sumOfSquaresOfDeltas() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        } else {
            return LinearTransformation.horizontal(this.yStats.mean());
        }
    }

    private static double ensureInUnitRange(double d) {
        return Doubles.constrainToRange(d, -1.0d, 1.0d);
    }
}
