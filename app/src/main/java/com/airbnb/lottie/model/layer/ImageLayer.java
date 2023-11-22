package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation<Bitmap, Bitmap> DatabaseTableConfigUtil;
    private final LottieImageAsset GetContactSyncConfig;
    private final Rect NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Rect initRecordTimeStamp;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new LPaint(3);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Rect();
        this.initRecordTimeStamp = new Rect();
        String str = layer.initRecordTimeStamp;
        LottieComposition lottieComposition = lottieDrawable.getAuthRequestContext;
        this.GetContactSyncConfig = lottieComposition == null ? null : lottieComposition.moveToNextValue.get(str);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        super.getAuthRequestContext(rectF, matrix, z);
        if (this.GetContactSyncConfig != null) {
            float authRequestContext = Utils.getAuthRequestContext();
            rectF.set(0.0f, 0.0f, this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2 * authRequestContext, this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory * authRequestContext);
            this.BuiltInFictitiousFunctionClassFactory.mapRect(rectF);
        }
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
        } else if (t == LottieProperty.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            if (lottieValueCallback == null) {
                this.DatabaseTableConfigUtil = null;
            } else {
                this.DatabaseTableConfigUtil = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Matrix matrix, int i) {
        Bitmap BuiltInFictitiousFunctionClassFactory;
        BaseKeyframeAnimation<Bitmap, Bitmap> baseKeyframeAnimation = this.DatabaseTableConfigUtil;
        Bitmap bitmap = null;
        if (baseKeyframeAnimation == null || (BuiltInFictitiousFunctionClassFactory = baseKeyframeAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0()) == null) {
            String str = this.scheduleImpl.initRecordTimeStamp;
            ImageAssetManager KClassImpl$Data$declaredNonStaticMembers$2 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2();
            BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(str) : null;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                LottieImageAsset lottieImageAsset = this.GetContactSyncConfig;
                if (lottieImageAsset != null) {
                    bitmap = lottieImageAsset.MyBillsEntityDataFactory;
                }
                if (bitmap != null || bitmap.isRecycled() || this.GetContactSyncConfig == null) {
                    return;
                }
                float authRequestContext = Utils.getAuthRequestContext();
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.setAlpha(i);
                BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.moveToNextValue;
                if (baseKeyframeAnimation2 != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColorFilter(baseKeyframeAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0());
                }
                canvas.save();
                canvas.concat(matrix);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                if (this.lookAheadTest.lookAheadTest()) {
                    this.initRecordTimeStamp.set(0, 0, (int) (this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2 * authRequestContext), (int) (this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory * authRequestContext));
                } else {
                    this.initRecordTimeStamp.set(0, 0, (int) (bitmap.getWidth() * authRequestContext), (int) (bitmap.getHeight() * authRequestContext));
                }
                canvas.drawBitmap(bitmap, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                canvas.restore();
                return;
            }
        }
        bitmap = BuiltInFictitiousFunctionClassFactory;
        if (bitmap != null) {
        }
    }
}
