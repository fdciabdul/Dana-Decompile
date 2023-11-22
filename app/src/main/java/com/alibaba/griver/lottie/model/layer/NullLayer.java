package com.alibaba.griver.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.alibaba.griver.lottie.LottieDrawable;

/* loaded from: classes6.dex */
public class NullLayer extends BaseLayer {
    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
