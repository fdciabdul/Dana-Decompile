package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor KClassImpl$Data$declaredNonStaticMembers$2;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).moveToNextValue;
        int length = gradientColor != null ? gradientColor.BuiltInFictitiousFunctionClassFactory.length : 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new GradientColor(new float[length], new int[length]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        GradientColor gradientColor = this.KClassImpl$Data$declaredNonStaticMembers$2;
        GradientColor gradientColor2 = (GradientColor) keyframe.moveToNextValue;
        GradientColor gradientColor3 = (GradientColor) keyframe.KClassImpl$Data$declaredNonStaticMembers$2;
        if (gradientColor2.BuiltInFictitiousFunctionClassFactory.length != gradientColor3.BuiltInFictitiousFunctionClassFactory.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot interpolate between gradients. Lengths vary (");
            sb.append(gradientColor2.BuiltInFictitiousFunctionClassFactory.length);
            sb.append(" vs ");
            sb.append(gradientColor3.BuiltInFictitiousFunctionClassFactory.length);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
        for (int i = 0; i < gradientColor2.BuiltInFictitiousFunctionClassFactory.length; i++) {
            gradientColor.getAuthRequestContext[i] = MiscUtils.PlaceComponentResult(gradientColor2.getAuthRequestContext[i], gradientColor3.getAuthRequestContext[i], f);
            gradientColor.BuiltInFictitiousFunctionClassFactory[i] = GammaEvaluator.PlaceComponentResult(f, gradientColor2.BuiltInFictitiousFunctionClassFactory[i], gradientColor3.BuiltInFictitiousFunctionClassFactory[i]);
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
