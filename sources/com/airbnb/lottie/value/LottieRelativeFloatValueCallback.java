package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes6.dex */
public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final /* synthetic */ Float BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<Float> lottieFrameInfo) {
        float PlaceComponentResult = MiscUtils.PlaceComponentResult(lottieFrameInfo.lookAheadTest.floatValue(), lottieFrameInfo.BuiltInFictitiousFunctionClassFactory.floatValue(), lottieFrameInfo.PlaceComponentResult);
        if (this.moveToNextValue != 0) {
            return Float.valueOf(PlaceComponentResult + ((Float) this.moveToNextValue).floatValue());
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
