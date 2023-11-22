package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes3.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    protected LottieValueCallback<Float> KClassImpl$Data$declaredNonStaticMembers$2;
    private final BaseKeyframeAnimation<Float, Float> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final PointF getErrorConfigVersion;
    private final BaseKeyframeAnimation<Float, Float> lookAheadTest;
    protected LottieValueCallback<Float> moveToNextValue;
    private final PointF scheduleImpl;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final /* synthetic */ PointF MyBillsEntityDataFactory(Keyframe<PointF> keyframe, float f) {
        return PlaceComponentResult(f);
    }

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.getErrorConfigVersion = new PointF();
        this.scheduleImpl = new PointF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = baseKeyframeAnimation;
        this.lookAheadTest = baseKeyframeAnimation2;
        KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public final void getAuthRequestContext(LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.lookAheadTest = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.lookAheadTest = this;
        }
    }

    public final void MyBillsEntityDataFactory(LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.moveToNextValue;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.lookAheadTest = null;
        }
        this.moveToNextValue = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.lookAheadTest = this;
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(f);
        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(f);
        this.getErrorConfigVersion.set(this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue(), this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue());
        for (int i = 0; i < this.MyBillsEntityDataFactory.size(); i++) {
            this.MyBillsEntityDataFactory.get(i).PlaceComponentResult();
        }
    }

    private PointF PlaceComponentResult(float f) {
        Float f2;
        Keyframe<Float> BuiltInFictitiousFunctionClassFactory;
        Keyframe<Float> BuiltInFictitiousFunctionClassFactory2;
        Float f3 = null;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null || (BuiltInFictitiousFunctionClassFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory()) == null) {
            f2 = null;
        } else {
            float authRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext();
            Float f4 = BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory;
            LottieValueCallback<Float> lottieValueCallback = this.KClassImpl$Data$declaredNonStaticMembers$2;
            f2 = lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.lookAheadTest, f4 == null ? BuiltInFictitiousFunctionClassFactory2.lookAheadTest : f4.floatValue(), BuiltInFictitiousFunctionClassFactory2.moveToNextValue, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2, f, f, authRequestContext));
        }
        if (this.moveToNextValue != null && (BuiltInFictitiousFunctionClassFactory = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory()) != null) {
            float authRequestContext2 = this.lookAheadTest.getAuthRequestContext();
            Float f5 = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            LottieValueCallback<Float> lottieValueCallback2 = this.moveToNextValue;
            f3 = lottieValueCallback2.BuiltInFictitiousFunctionClassFactory(lottieValueCallback2.scheduleImpl.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest, f5 == null ? BuiltInFictitiousFunctionClassFactory.lookAheadTest : f5.floatValue(), BuiltInFictitiousFunctionClassFactory.moveToNextValue, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, f, f, authRequestContext2));
        }
        if (f2 == null) {
            this.scheduleImpl.set(this.getErrorConfigVersion.x, 0.0f);
        } else {
            this.scheduleImpl.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            PointF pointF = this.scheduleImpl;
            pointF.set(pointF.x, this.getErrorConfigVersion.y);
        } else {
            PointF pointF2 = this.scheduleImpl;
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return this.scheduleImpl;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* synthetic */ PointF NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return PlaceComponentResult(0.0f);
    }
}
