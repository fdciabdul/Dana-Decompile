package com.airbnb.lottie.model.animatable;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
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

    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final /* synthetic */ BaseKeyframeAnimation MyBillsEntityDataFactory() {
        return new ShapeKeyframeAnimation(this.PlaceComponentResult);
    }
}
