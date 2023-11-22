package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes3.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    private final ScaleXY KClassImpl$Data$declaredNonStaticMembers$2;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ScaleXY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        if (keyframe.moveToNextValue == 0 || keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY = (ScaleXY) keyframe.moveToNextValue;
        ScaleXY scaleXY2 = (ScaleXY) keyframe.KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
            ScaleXY scaleXY3 = (ScaleXY) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(keyframe.lookAheadTest, keyframe.MyBillsEntityDataFactory.floatValue(), scaleXY, scaleXY2, f, MyBillsEntityDataFactory(), KClassImpl$Data$declaredNonStaticMembers$2()));
            if (scaleXY3 != null) {
                return scaleXY3;
            }
        }
        ScaleXY scaleXY4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        float PlaceComponentResult = MiscUtils.PlaceComponentResult(scaleXY.KClassImpl$Data$declaredNonStaticMembers$2, scaleXY2.KClassImpl$Data$declaredNonStaticMembers$2, f);
        float PlaceComponentResult2 = MiscUtils.PlaceComponentResult(scaleXY.MyBillsEntityDataFactory, scaleXY2.MyBillsEntityDataFactory, f);
        scaleXY4.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        scaleXY4.MyBillsEntityDataFactory = PlaceComponentResult2;
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
