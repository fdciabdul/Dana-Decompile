package com.alibaba.griver.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.LottieProperty;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.alibaba.griver.lottie.model.content.GradientColor;
import com.alibaba.griver.lottie.model.content.GradientStroke;
import com.alibaba.griver.lottie.model.content.GradientType;
import com.alibaba.griver.lottie.model.layer.BaseLayer;
import com.alibaba.griver.lottie.value.LottieValueCallback;

/* loaded from: classes6.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final LongSparseArray<LinearGradient> linearGradientCache;
    private final String name;
    private final LongSparseArray<RadialGradient> radialGradientCache;
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.linearGradientCache = new LongSparseArray<>();
        this.radialGradientCache = new LongSparseArray<>();
        this.boundsRect = new RectF();
        this.name = gradientStroke.getName();
        this.type = gradientStroke.getGradientType();
        this.hidden = gradientStroke.isHidden();
        this.cacheSteps = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientStroke.getGradientColor().createAnimation();
        this.colorAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = gradientStroke.getStartPoint().createAnimation();
        this.startPointAnimation = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientStroke.getEndPoint().createAnimation();
        this.endPointAnimation = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
    }

    @Override // com.alibaba.griver.lottie.animation.content.BaseStrokeContent, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader radialGradient;
        if (this.hidden) {
            return;
        }
        getBounds(this.boundsRect, matrix, false);
        if (this.type == GradientType.LINEAR) {
            radialGradient = getLinearGradient();
        } else {
            radialGradient = getRadialGradient();
        }
        this.paint.setShader(radialGradient);
        super.draw(canvas, matrix, i);
    }

    @Override // com.alibaba.griver.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private LinearGradient getLinearGradient() {
        long gradientHash = getGradientHash();
        LinearGradient MyBillsEntityDataFactory = this.linearGradientCache.MyBillsEntityDataFactory(gradientHash, null);
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory;
        }
        PointF value = this.startPointAnimation.getValue();
        PointF value2 = this.endPointAnimation.getValue();
        GradientColor value3 = this.colorAnimation.getValue();
        LinearGradient linearGradient = new LinearGradient((int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + value.x), (int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + value.y), (int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + value2.x), (int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + value2.y), applyDynamicColorsIfNeeded(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
        this.linearGradientCache.getAuthRequestContext(gradientHash, linearGradient);
        return linearGradient;
    }

    private RadialGradient getRadialGradient() {
        long gradientHash = getGradientHash();
        RadialGradient MyBillsEntityDataFactory = this.radialGradientCache.MyBillsEntityDataFactory(gradientHash, null);
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory;
        }
        PointF value = this.startPointAnimation.getValue();
        PointF value2 = this.endPointAnimation.getValue();
        GradientColor value3 = this.colorAnimation.getValue();
        int[] applyDynamicColorsIfNeeded = applyDynamicColorsIfNeeded(value3.getColors());
        float[] positions = value3.getPositions();
        RadialGradient radialGradient = new RadialGradient((int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + value.x), (int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + value.y), (float) Math.hypot(((int) ((this.boundsRect.left + (this.boundsRect.width() / 2.0f)) + value2.x)) - r4, ((int) ((this.boundsRect.top + (this.boundsRect.height() / 2.0f)) + value2.y)) - r0), applyDynamicColorsIfNeeded, positions, Shader.TileMode.CLAMP);
        this.radialGradientCache.getAuthRequestContext(gradientHash, radialGradient);
        return radialGradient;
    }

    private int getGradientHash() {
        int round = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
        int round2 = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
        int round3 = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private int[] applyDynamicColorsIfNeeded(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.griver.lottie.animation.content.BaseStrokeContent, com.alibaba.griver.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.GRADIENT_COLOR) {
            if (lottieValueCallback == null) {
                if (this.colorCallbackAnimation != null) {
                    this.layer.removeAnimation(this.colorCallbackAnimation);
                }
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorCallbackAnimation);
        }
    }
}
