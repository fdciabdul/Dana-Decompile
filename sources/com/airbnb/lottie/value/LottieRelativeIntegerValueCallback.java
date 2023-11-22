package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes6.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final /* synthetic */ Integer BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<Integer> lottieFrameInfo) {
        int MyBillsEntityDataFactory = MiscUtils.MyBillsEntityDataFactory(lottieFrameInfo.lookAheadTest.intValue(), lottieFrameInfo.BuiltInFictitiousFunctionClassFactory.intValue(), lottieFrameInfo.PlaceComponentResult);
        if (this.moveToNextValue != 0) {
            return Integer.valueOf(MyBillsEntityDataFactory + ((Integer) this.moveToNextValue).intValue());
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
