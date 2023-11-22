package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes6.dex */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {
    private final PointF MyBillsEntityDataFactory = new PointF();

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final /* synthetic */ PointF BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<PointF> lottieFrameInfo) {
        this.MyBillsEntityDataFactory.set(MiscUtils.PlaceComponentResult(lottieFrameInfo.lookAheadTest.x, lottieFrameInfo.BuiltInFictitiousFunctionClassFactory.x, lottieFrameInfo.PlaceComponentResult), MiscUtils.PlaceComponentResult(lottieFrameInfo.lookAheadTest.y, lottieFrameInfo.BuiltInFictitiousFunctionClassFactory.y, lottieFrameInfo.PlaceComponentResult));
        if (this.moveToNextValue == 0) {
            throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        }
        PointF pointF = (PointF) this.moveToNextValue;
        this.MyBillsEntityDataFactory.offset(pointF.x, pointF.y);
        return this.MyBillsEntityDataFactory;
    }
}
