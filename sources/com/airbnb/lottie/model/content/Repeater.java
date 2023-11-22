package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class Repeater implements ContentModel {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    public final AnimatableFloatValue KClassImpl$Data$declaredNonStaticMembers$2;
    public final AnimatableFloatValue MyBillsEntityDataFactory;
    public final String PlaceComponentResult;
    public final AnimatableTransform getAuthRequestContext;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = animatableFloatValue;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableFloatValue2;
        this.getAuthRequestContext = animatableTransform;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }
}
