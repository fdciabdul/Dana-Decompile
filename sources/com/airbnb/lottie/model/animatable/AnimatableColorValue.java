package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
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

    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<Integer, Integer> MyBillsEntityDataFactory() {
        return new ColorKeyframeAnimation(this.PlaceComponentResult);
    }
}
