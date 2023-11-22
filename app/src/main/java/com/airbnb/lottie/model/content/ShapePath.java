package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class ShapePath implements ContentModel {
    public final String BuiltInFictitiousFunctionClassFactory;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public final AnimatableShapeValue MyBillsEntityDataFactory;
    private final int PlaceComponentResult;

    public ShapePath(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = i;
        this.MyBillsEntityDataFactory = animatableShapeValue;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public final boolean getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapePath{name=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", index=");
        sb.append(this.PlaceComponentResult);
        sb.append('}');
        return sb.toString();
    }
}
