package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class StrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> BuiltInFictitiousFunctionClassFactory;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final BaseLayer NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final String getErrorConfigVersion;
    private final boolean moveToNextValue;

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        if (this.moveToNextValue) {
            return;
        }
        this.PlaceComponentResult.setColor(((ColorKeyframeAnimation) this.BuiltInFictitiousFunctionClassFactory).moveToNextValue());
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.PlaceComponentResult.setColorFilter(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
        super.getAuthRequestContext(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        super.PlaceComponentResult(t, lottieValueCallback);
        if (t == LottieProperty.FragmentBottomSheetPaymentSettingBinding) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(lottieValueCallback);
        } else if (t == LottieProperty.BuiltInFictitiousFunctionClassFactory) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseKeyframeAnimation != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.MyBillsEntityDataFactory.add(this);
            BaseLayer baseLayer = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.BuiltInFictitiousFunctionClassFactory;
            if (baseKeyframeAnimation2 != null) {
                baseLayer.MyBillsEntityDataFactory.add(baseKeyframeAnimation2);
            }
        }
    }

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.PlaceComponentResult.toPaintCap(), shapeStroke.KClassImpl$Data$declaredNonStaticMembers$2.toPaintJoin(), shapeStroke.BuiltInFictitiousFunctionClassFactory, shapeStroke.scheduleImpl, shapeStroke.NetworkUserEntityData$$ExternalSyntheticLambda0, shapeStroke.MyBillsEntityDataFactory, shapeStroke.moveToNextValue);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = baseLayer;
        this.getErrorConfigVersion = shapeStroke.getErrorConfigVersion;
        this.moveToNextValue = shapeStroke.KClassImpl$Data$declaredNonStaticMembers$2();
        ColorKeyframeAnimation colorKeyframeAnimation = new ColorKeyframeAnimation(shapeStroke.getAuthRequestContext.PlaceComponentResult);
        this.BuiltInFictitiousFunctionClassFactory = colorKeyframeAnimation;
        colorKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(colorKeyframeAnimation);
    }
}
