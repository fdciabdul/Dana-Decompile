package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RoundedCornersContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class RoundedCorners implements ContentModel {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final AnimatableValue<Float, Float> KClassImpl$Data$declaredNonStaticMembers$2;

    public RoundedCorners(String str, AnimatableValue<Float, Float> animatableValue) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RoundedCornersContent(lottieDrawable, baseLayer, this);
    }
}
