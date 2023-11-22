package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class ShapeFill implements ContentModel {
    public final Path.FillType BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AnimatableIntegerValue PlaceComponentResult;
    public final AnimatableColorValue getAuthRequestContext;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = z;
        this.BuiltInFictitiousFunctionClassFactory = fillType;
        this.getAuthRequestContext = animatableColorValue;
        this.PlaceComponentResult = animatableIntegerValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=, fillEnabled=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('}');
        return sb.toString();
    }
}
