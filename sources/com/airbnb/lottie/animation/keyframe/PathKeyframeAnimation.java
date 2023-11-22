package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PathMeasure KClassImpl$Data$declaredNonStaticMembers$2;
    private final PointF NetworkUserEntityData$$ExternalSyntheticLambda0;
    private PathKeyframe moveToNextValue;
    private final float[] scheduleImpl;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new PointF();
        this.scheduleImpl = new float[2];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path path = pathKeyframe.BuiltInFictitiousFunctionClassFactory;
        if (path == null) {
            return (PointF) keyframe.moveToNextValue;
        }
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
            PointF pointF = (PointF) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(pathKeyframe.lookAheadTest, pathKeyframe.MyBillsEntityDataFactory.floatValue(), (PointF) pathKeyframe.moveToNextValue, (PointF) pathKeyframe.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory(), f, KClassImpl$Data$declaredNonStaticMembers$2()));
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.moveToNextValue != pathKeyframe) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setPath(path, false);
            this.moveToNextValue = pathKeyframe;
        }
        PathMeasure pathMeasure = this.KClassImpl$Data$declaredNonStaticMembers$2;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.scheduleImpl, null);
        PointF pointF2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        float[] fArr = this.scheduleImpl;
        pointF2.set(fArr[0], fArr[1]);
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
