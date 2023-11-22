package at.wirecube.additiveanimations.additive_animator;

import java.util.HashMap;

/* loaded from: classes3.dex */
class AccumulatedAnimationValueManager {
    private HashMap<AdditiveAnimation, AccumulatedAnimationValue> MyBillsEntityDataFactory = new HashMap<>();

    public final AccumulatedAnimationValue getAuthRequestContext(AdditiveAnimation additiveAnimation) {
        AccumulatedAnimationValue accumulatedAnimationValue = this.MyBillsEntityDataFactory.get(additiveAnimation);
        if (accumulatedAnimationValue != null) {
            return accumulatedAnimationValue;
        }
        AccumulatedAnimationValue accumulatedAnimationValue2 = new AccumulatedAnimationValue(additiveAnimation);
        this.MyBillsEntityDataFactory.put(additiveAnimation, accumulatedAnimationValue2);
        return accumulatedAnimationValue2;
    }
}
