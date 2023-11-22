package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int PlaceComponentResult(Keyframe<Integer> keyframe, float f) {
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
        if (keyframe.initRecordTimeStamp == 784923401) {
            keyframe.initRecordTimeStamp = keyframe.moveToNextValue.intValue();
        }
        int i = keyframe.initRecordTimeStamp;
        if (keyframe.PlaceComponentResult == 784923401) {
            keyframe.PlaceComponentResult = keyframe.KClassImpl$Data$declaredNonStaticMembers$2.intValue();
        }
        return MiscUtils.MyBillsEntityDataFactory(i, keyframe.PlaceComponentResult, f);
    }

    public final int moveToNextValue() {
        return PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(), getAuthRequestContext());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        return Integer.valueOf(PlaceComponentResult(keyframe, f));
    }
}
