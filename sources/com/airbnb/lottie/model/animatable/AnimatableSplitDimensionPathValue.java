package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    private final AnimatableFloatValue KClassImpl$Data$declaredNonStaticMembers$2;
    private final AnimatableFloatValue PlaceComponentResult;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.PlaceComponentResult = animatableFloatValue;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableFloatValue2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final List<Keyframe<PointF>> KClassImpl$Data$declaredNonStaticMembers$2() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() && this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory() {
        return new SplitDimensionPathKeyframeAnimation(new FloatKeyframeAnimation(this.PlaceComponentResult.PlaceComponentResult), new FloatKeyframeAnimation(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult));
    }
}
