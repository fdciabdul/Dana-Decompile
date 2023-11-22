package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getAuthRequestContext(Keyframe<Integer> keyframe, float f) {
        if (keyframe.moveToNextValue == null || keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
            Integer num = (Integer) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(keyframe.lookAheadTest, keyframe.MyBillsEntityDataFactory.floatValue(), keyframe.moveToNextValue, keyframe.KClassImpl$Data$declaredNonStaticMembers$2, f, MyBillsEntityDataFactory(), KClassImpl$Data$declaredNonStaticMembers$2()));
            if (num != null) {
                return num.intValue();
            }
        }
        return GammaEvaluator.PlaceComponentResult(MiscUtils.MyBillsEntityDataFactory(f, 0.0f, 1.0f), keyframe.moveToNextValue.intValue(), keyframe.KClassImpl$Data$declaredNonStaticMembers$2.intValue());
    }

    public final int moveToNextValue() {
        return getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        return Integer.valueOf(getAuthRequestContext(keyframe, f));
    }
}
