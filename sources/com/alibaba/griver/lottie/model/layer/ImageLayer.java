package com.alibaba.griver.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.LottieProperty;
import com.alibaba.griver.lottie.animation.LPaint;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        Bitmap bitmap = getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        float dpScale = Utils.dpScale();
        this.paint.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        canvas.save();
        canvas.concat(matrix);
        this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.dst.set(0, 0, (int) (bitmap.getWidth() * dpScale), (int) (bitmap.getHeight() * dpScale));
        try {
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("drawBitmap exception ");
            sb.append(e);
            InstrumentInjector.log_e("Lottie-ImageLayer", sb.toString());
        }
        canvas.restore();
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        if (getBitmap() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * Utils.dpScale(), r3.getHeight() * Utils.dpScale());
            this.boundsMatrix.mapRect(rectF);
        }
    }

    private Bitmap getBitmap() {
        return this.lottieDrawable.getImageAsset(this.layerModel.getRefId());
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
            } else {
                this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }
}
