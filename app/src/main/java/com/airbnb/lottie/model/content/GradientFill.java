package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class GradientFill implements ContentModel {
    public final AnimatablePointValue BuiltInFictitiousFunctionClassFactory;
    public final AnimatableGradientColorValue KClassImpl$Data$declaredNonStaticMembers$2;
    public final GradientType MyBillsEntityDataFactory;
    public final String PlaceComponentResult;
    public final Path.FillType getAuthRequestContext;
    public final AnimatableIntegerValue getErrorConfigVersion;
    public final AnimatablePointValue lookAheadTest;
    private final boolean scheduleImpl;
    private final AnimatableFloatValue NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private final AnimatableFloatValue moveToNextValue = null;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, boolean z) {
        this.MyBillsEntityDataFactory = gradientType;
        this.getAuthRequestContext = fillType;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableGradientColorValue;
        this.getErrorConfigVersion = animatableIntegerValue;
        this.lookAheadTest = animatablePointValue;
        this.BuiltInFictitiousFunctionClassFactory = animatablePointValue2;
        this.PlaceComponentResult = str;
        this.scheduleImpl = z;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, baseLayer, this);
    }
}
