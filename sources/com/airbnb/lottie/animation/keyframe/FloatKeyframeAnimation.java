package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float getAuthRequestContext(Keyframe<Float> keyframe, float f) {
        if (keyframe.moveToNextValue == null || keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
            Float f2 = (Float) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(keyframe.lookAheadTest, keyframe.MyBillsEntityDataFactory.floatValue(), keyframe.moveToNextValue, keyframe.KClassImpl$Data$declaredNonStaticMembers$2, f, MyBillsEntityDataFactory(), KClassImpl$Data$declaredNonStaticMembers$2()));
            if (f2 != null) {
                return f2.floatValue();
            }
        }
        if (keyframe.NetworkUserEntityData$$ExternalSyntheticLambda2 == -3987645.8f) {
            keyframe.NetworkUserEntityData$$ExternalSyntheticLambda2 = keyframe.moveToNextValue.floatValue();
        }
        float f3 = keyframe.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (keyframe.getAuthRequestContext == -3987645.8f) {
            keyframe.getAuthRequestContext = keyframe.KClassImpl$Data$declaredNonStaticMembers$2.floatValue();
        }
        return MiscUtils.PlaceComponentResult(f3, keyframe.getAuthRequestContext, f);
    }

    public final float lookAheadTest() {
        return getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        return Float.valueOf(getAuthRequestContext(keyframe, f));
    }
}
