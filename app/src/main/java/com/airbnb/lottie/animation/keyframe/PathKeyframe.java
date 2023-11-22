package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes3.dex */
public class PathKeyframe extends Keyframe<PointF> {
    Path BuiltInFictitiousFunctionClassFactory;
    private final Keyframe<PointF> DatabaseTableConfigUtil;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.moveToNextValue, keyframe.KClassImpl$Data$declaredNonStaticMembers$2, keyframe.NetworkUserEntityData$$ExternalSyntheticLambda0, keyframe.GetContactSyncConfig, keyframe.NetworkUserEntityData$$ExternalSyntheticLambda1, keyframe.lookAheadTest, keyframe.MyBillsEntityDataFactory);
        this.DatabaseTableConfigUtil = keyframe;
        PlaceComponentResult();
    }

    public final void PlaceComponentResult() {
        boolean z = (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0 || this.moveToNextValue == 0 || !((PointF) this.moveToNextValue).equals(((PointF) this.KClassImpl$Data$declaredNonStaticMembers$2).x, ((PointF) this.KClassImpl$Data$declaredNonStaticMembers$2).y)) ? false : true;
        if (this.moveToNextValue == 0 || this.KClassImpl$Data$declaredNonStaticMembers$2 == 0 || z) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = Utils.KClassImpl$Data$declaredNonStaticMembers$2((PointF) this.moveToNextValue, (PointF) this.KClassImpl$Data$declaredNonStaticMembers$2, this.DatabaseTableConfigUtil.getErrorConfigVersion, this.DatabaseTableConfigUtil.scheduleImpl);
    }
}
