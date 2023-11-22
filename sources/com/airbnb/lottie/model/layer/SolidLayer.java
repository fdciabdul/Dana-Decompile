package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class SolidLayer extends BaseLayer {
    private final Paint DatabaseTableConfigUtil;
    private final Layer GetContactSyncConfig;
    private final float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Path NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final RectF initRecordTimeStamp;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.initRecordTimeStamp = new RectF();
        LPaint lPaint = new LPaint();
        this.DatabaseTableConfigUtil = lPaint;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[8];
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Path();
        this.GetContactSyncConfig = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda2);
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * (this.getErrorConfigVersion.MyBillsEntityDataFactory == null ? 100 : this.getErrorConfigVersion.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue())) / 100.0f) * 255.0f);
        this.DatabaseTableConfigUtil.setAlpha(intValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.moveToNextValue;
        if (baseKeyframeAnimation != null) {
            this.DatabaseTableConfigUtil.setColorFilter(baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        if (intValue > 0) {
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8;
            float[] fArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            fArr2[3] = 0.0f;
            fArr2[4] = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1[5] = this.GetContactSyncConfig.isLayoutRequested;
            float[] fArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            fArr3[6] = 0.0f;
            fArr3[7] = this.GetContactSyncConfig.isLayoutRequested;
            matrix.mapPoints(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.reset();
            Path path = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float[] fArr4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float[] fArr5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float[] fArr6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float[] fArr7 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float[] fArr8 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.close();
            canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.DatabaseTableConfigUtil);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        super.getAuthRequestContext(rectF, matrix, z);
        this.initRecordTimeStamp.set(0.0f, 0.0f, this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda8, this.GetContactSyncConfig.isLayoutRequested);
        this.BuiltInFictitiousFunctionClassFactory.mapRect(this.initRecordTimeStamp);
        rectF.set(this.initRecordTimeStamp);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        super.PlaceComponentResult(t, lottieValueCallback);
        if (t == LottieProperty.BuiltInFictitiousFunctionClassFactory) {
            if (lottieValueCallback == null) {
                this.moveToNextValue = null;
            } else {
                this.moveToNextValue = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }
}
