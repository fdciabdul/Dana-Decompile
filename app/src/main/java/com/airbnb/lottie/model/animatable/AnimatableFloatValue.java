package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory() {
        return super.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public final /* bridge */ /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2() {
        return super.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<Float, Float> MyBillsEntityDataFactory() {
        return new FloatKeyframeAnimation(this.PlaceComponentResult);
    }
}
