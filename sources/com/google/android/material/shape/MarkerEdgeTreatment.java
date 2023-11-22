package com.google.android.material.shape;

/* loaded from: classes3.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.EdgeTreatment
    public final boolean forceIntersection() {
        return true;
    }

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public final void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        double d = this.radius;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d);
        float f4 = (float) ((d * sqrt) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(f4, 2.0d));
        double d2 = this.radius;
        double sqrt3 = Math.sqrt(2.0d);
        double d3 = this.radius;
        Double.isNaN(d2);
        Double.isNaN(d3);
        shapePath.reset(f2 - f4, ((float) (-((d2 * sqrt3) - d3))) + sqrt2);
        double d4 = this.radius;
        double sqrt4 = Math.sqrt(2.0d);
        double d5 = this.radius;
        Double.isNaN(d4);
        Double.isNaN(d5);
        shapePath.lineTo(f2, (float) (-((d4 * sqrt4) - d5)));
        double d6 = this.radius;
        double sqrt5 = Math.sqrt(2.0d);
        double d7 = this.radius;
        Double.isNaN(d6);
        Double.isNaN(d7);
        shapePath.lineTo(f2 + f4, ((float) (-((d6 * sqrt5) - d7))) + sqrt2);
    }
}
