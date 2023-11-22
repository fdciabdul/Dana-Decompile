package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    private final List<Keyframe<PointF>> KClassImpl$Data$declaredNonStaticMembers$2;

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final List<Keyframe<PointF>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size() == 1 && this.KClassImpl$Data$declaredNonStaticMembers$2.get(0).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<PointF, PointF> MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(0).BuiltInFictitiousFunctionClassFactory()) {
            return new PointKeyframeAnimation(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return new PathKeyframeAnimation(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
