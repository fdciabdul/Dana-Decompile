package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Paint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {
    public final BaseKeyframeAnimation<Float, Float> BuiltInFictitiousFunctionClassFactory;
    public final BaseKeyframeAnimation<Integer, Integer> KClassImpl$Data$declaredNonStaticMembers$2;
    public final BaseKeyframeAnimation<Float, Float> MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    public final BaseKeyframeAnimation<Float, Float> PlaceComponentResult;
    public final BaseKeyframeAnimation<Float, Float> getAuthRequestContext;
    private final BaseKeyframeAnimation.AnimationListener moveToNextValue;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.moveToNextValue = animationListener;
        ColorKeyframeAnimation colorKeyframeAnimation = new ColorKeyframeAnimation(dropShadowEffect.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = colorKeyframeAnimation;
        colorKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(colorKeyframeAnimation);
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(dropShadowEffect.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
        this.getAuthRequestContext = floatKeyframeAnimation;
        floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
        FloatKeyframeAnimation floatKeyframeAnimation2 = new FloatKeyframeAnimation(dropShadowEffect.PlaceComponentResult.PlaceComponentResult);
        this.BuiltInFictitiousFunctionClassFactory = floatKeyframeAnimation2;
        floatKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation2);
        FloatKeyframeAnimation floatKeyframeAnimation3 = new FloatKeyframeAnimation(dropShadowEffect.MyBillsEntityDataFactory.PlaceComponentResult);
        this.MyBillsEntityDataFactory = floatKeyframeAnimation3;
        floatKeyframeAnimation3.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation3);
        FloatKeyframeAnimation floatKeyframeAnimation4 = new FloatKeyframeAnimation(dropShadowEffect.getAuthRequestContext.PlaceComponentResult);
        this.PlaceComponentResult = floatKeyframeAnimation4;
        floatKeyframeAnimation4.MyBillsEntityDataFactory.add(this);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation4);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.moveToNextValue.PlaceComponentResult();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Paint paint) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            double floatValue = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            Double.isNaN(floatValue);
            double d = floatValue * 0.017453292519943295d;
            float floatValue2 = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
            float sin = (float) Math.sin(d);
            float cos = (float) Math.cos(d + 3.141592653589793d);
            int intValue = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue();
            paint.setShadowLayer(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue(), sin * floatValue2, cos * floatValue2, Color.argb(Math.round(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    /* renamed from: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends LottieValueCallback<Float> {
        final /* synthetic */ LottieValueCallback BuiltInFictitiousFunctionClassFactory;

        public AnonymousClass1(LottieValueCallback lottieValueCallback) {
            this.BuiltInFictitiousFunctionClassFactory = lottieValueCallback;
        }

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public final /* synthetic */ Float BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<Float> lottieFrameInfo) {
            Float f = (Float) this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(lottieFrameInfo);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }
}
