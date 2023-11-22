package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    public final List<Keyframe<V>> PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.PlaceComponentResult = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult.isEmpty()) {
            return true;
        }
        return this.PlaceComponentResult.size() == 1 && this.PlaceComponentResult.get(0).BuiltInFictitiousFunctionClassFactory();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.PlaceComponentResult.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.PlaceComponentResult.toArray()));
        }
        return sb.toString();
    }
}
