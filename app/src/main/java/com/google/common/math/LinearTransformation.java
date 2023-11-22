package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class LinearTransformation {
    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);

    public static LinearTransformationBuilder mapping(double d, double d2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d) && DoubleUtils.isFinite(d2));
        return new LinearTransformationBuilder(d, d2);
    }

    /* loaded from: classes7.dex */
    public static final class LinearTransformationBuilder {
        private final double x1;
        private final double y1;

        private LinearTransformationBuilder(double d, double d2) {
            this.x1 = d;
            this.y1 = d2;
        }

        public final LinearTransformation and(double d, double d2) {
            Preconditions.checkArgument(DoubleUtils.isFinite(d) && DoubleUtils.isFinite(d2));
            double d3 = this.x1;
            if (d == d3) {
                Preconditions.checkArgument(d2 != this.y1);
                return new VerticalLinearTransformation(this.x1);
            }
            return withSlope((d2 - this.y1) / (d - d3));
        }

        public final LinearTransformation withSlope(double d) {
            Preconditions.checkArgument(!Double.isNaN(d));
            if (DoubleUtils.isFinite(d)) {
                return new RegularLinearTransformation(d, this.y1 - (this.x1 * d));
            }
            return new VerticalLinearTransformation(this.x1);
        }
    }

    public static LinearTransformation vertical(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new VerticalLinearTransformation(d);
    }

    public static LinearTransformation horizontal(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new RegularLinearTransformation(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, d);
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class RegularLinearTransformation extends LinearTransformation {
        @CheckForNull
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        @Override // com.google.common.math.LinearTransformation
        public final boolean isVertical() {
            return false;
        }

        RegularLinearTransformation(double d, double d2) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = null;
        }

        RegularLinearTransformation(double d, double d2, LinearTransformation linearTransformation) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = linearTransformation;
        }

        @Override // com.google.common.math.LinearTransformation
        public final boolean isHorizontal() {
            return this.slope == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        @Override // com.google.common.math.LinearTransformation
        public final double slope() {
            return this.slope;
        }

        @Override // com.google.common.math.LinearTransformation
        public final double transform(double d) {
            return (d * this.slope) + this.yIntercept;
        }

        @Override // com.google.common.math.LinearTransformation
        public final LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation == null) {
                LinearTransformation createInverse = createInverse();
                this.inverse = createInverse;
                return createInverse;
            }
            return linearTransformation;
        }

        public final String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.slope), Double.valueOf(this.yIntercept));
        }

        private LinearTransformation createInverse() {
            double d = this.slope;
            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return new RegularLinearTransformation(1.0d / d, (this.yIntercept * (-1.0d)) / d, this);
            }
            return new VerticalLinearTransformation(this.yIntercept, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class VerticalLinearTransformation extends LinearTransformation {
        @CheckForNull
        @LazyInit
        LinearTransformation inverse;
        final double x;

        @Override // com.google.common.math.LinearTransformation
        public final boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public final boolean isVertical() {
            return true;
        }

        VerticalLinearTransformation(double d) {
            this.x = d;
            this.inverse = null;
        }

        VerticalLinearTransformation(double d, LinearTransformation linearTransformation) {
            this.x = d;
            this.inverse = linearTransformation;
        }

        @Override // com.google.common.math.LinearTransformation
        public final double slope() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.math.LinearTransformation
        public final double transform(double d) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.math.LinearTransformation
        public final LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation == null) {
                LinearTransformation createInverse = createInverse();
                this.inverse = createInverse;
                return createInverse;
            }
            return linearTransformation;
        }

        public final String toString() {
            return String.format("x = %g", Double.valueOf(this.x));
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.x, this);
        }
    }

    /* loaded from: classes7.dex */
    static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        @Override // com.google.common.math.LinearTransformation
        public final LinearTransformation inverse() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public final boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public final boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public final double slope() {
            return Double.NaN;
        }

        public final String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public final double transform(double d) {
            return Double.NaN;
        }

        private NaNLinearTransformation() {
        }
    }
}
