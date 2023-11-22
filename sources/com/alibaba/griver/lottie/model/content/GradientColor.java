package com.alibaba.griver.lottie.model.content;

import com.alibaba.griver.lottie.utils.GammaEvaluator;
import com.alibaba.griver.lottie.utils.MiscUtils;

/* loaded from: classes6.dex */
public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] fArr, int[] iArr) {
        this.positions = fArr;
        this.colors = iArr;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f) {
        if (gradientColor.colors.length != gradientColor2.colors.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot interpolate between gradients. Lengths vary (");
            sb.append(gradientColor.colors.length);
            sb.append(" vs ");
            sb.append(gradientColor2.colors.length);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < gradientColor.colors.length; i++) {
            this.positions[i] = MiscUtils.lerp(gradientColor.positions[i], gradientColor2.positions[i], f);
            this.colors[i] = GammaEvaluator.evaluate(f, gradientColor.colors[i], gradientColor2.colors[i]);
        }
    }
}
