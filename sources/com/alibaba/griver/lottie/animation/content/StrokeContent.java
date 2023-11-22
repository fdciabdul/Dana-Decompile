package com.alibaba.griver.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.LottieProperty;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.alibaba.griver.lottie.model.animatable.AnimatableColorValue;
import com.alibaba.griver.lottie.model.content.ShapeStroke;
import com.alibaba.griver.lottie.model.layer.BaseLayer;
import com.alibaba.griver.lottie.value.LottieValueCallback;

/* loaded from: classes6.dex */
public class StrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final String name;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.layer = baseLayer;
        this.name = shapeStroke.getName();
        this.hidden = shapeStroke.isHidden();
        AnimatableColorValue color = shapeStroke.getColor();
        if (color != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation = color.createAnimation();
            this.colorAnimation = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(createAnimation);
            return;
        }
        this.colorAnimation = null;
    }

    @Override // com.alibaba.griver.lottie.animation.content.BaseStrokeContent, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (this.hidden || this.colorAnimation == null) {
            return;
        }
        this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
        if (this.colorFilterAnimation != null) {
            this.paint.setColorFilter(this.colorFilterAnimation.getValue());
        }
        super.draw(canvas, matrix, i);
    }

    @Override // com.alibaba.griver.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.alibaba.griver.lottie.animation.content.BaseStrokeContent, com.alibaba.griver.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation;
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.STROKE_COLOR && (baseKeyframeAnimation = this.colorAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
            } else if (this.colorAnimation != null) {
                ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                this.colorFilterAnimation = valueCallbackKeyframeAnimation;
                valueCallbackKeyframeAnimation.addUpdateListener(this);
                this.layer.addAnimation(this.colorAnimation);
            }
        }
    }
}
