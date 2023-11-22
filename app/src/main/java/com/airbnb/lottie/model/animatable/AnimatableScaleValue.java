package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
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

    public AnimatableScaleValue(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<ScaleXY, ScaleXY> MyBillsEntityDataFactory() {
        return new ScaleKeyframeAnimation(this.PlaceComponentResult);
    }
}
