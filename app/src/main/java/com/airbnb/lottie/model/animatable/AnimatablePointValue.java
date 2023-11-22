package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
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

    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory() {
        return new PointKeyframeAnimation(this.PlaceComponentResult);
    }
}
