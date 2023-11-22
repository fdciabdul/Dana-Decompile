package com.alibaba.griver.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.animation.content.ContentGroup;
import com.alibaba.griver.lottie.model.KeyPath;
import com.alibaba.griver.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup contentGroup;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.getShapes(), false));
        this.contentGroup = contentGroup;
        contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i) {
        this.contentGroup.draw(canvas, matrix, i);
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.contentGroup.getBounds(rectF, this.boundsMatrix, z);
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, i, list, keyPath2);
    }
}
