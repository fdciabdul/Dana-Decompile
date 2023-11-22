package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF KClassImpl$Data$declaredNonStaticMembers$2;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public PointF getAuthRequestContext(Keyframe<PointF> keyframe, float f, float f2, float f3) {
        if (keyframe.moveToNextValue == null || keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = keyframe.moveToNextValue;
        PointF pointF2 = keyframe.KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
            PointF pointF3 = (PointF) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(keyframe.lookAheadTest, keyframe.MyBillsEntityDataFactory.floatValue(), pointF, pointF2, f, MyBillsEntityDataFactory(), KClassImpl$Data$declaredNonStaticMembers$2()));
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.set(pointF.x + (f2 * (pointF2.x - pointF.x)), pointF.y + (f3 * (pointF2.y - pointF.y)));
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        return getAuthRequestContext(keyframe, f, f, f);
    }
}
