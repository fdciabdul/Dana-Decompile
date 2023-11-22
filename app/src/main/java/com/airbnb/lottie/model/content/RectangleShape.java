package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class RectangleShape implements ContentModel {
    public final AnimatableFloatValue BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    public final AnimatableValue<PointF, PointF> PlaceComponentResult;
    public final AnimatableValue<PointF, PointF> getAuthRequestContext;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatableValue<PointF, PointF> animatableValue2, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = animatableValue;
        this.PlaceComponentResult = animatableValue2;
        this.BuiltInFictitiousFunctionClassFactory = animatableFloatValue;
        this.MyBillsEntityDataFactory = z;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RectangleShape{position=");
        sb.append(this.getAuthRequestContext);
        sb.append(", size=");
        sb.append(this.PlaceComponentResult);
        sb.append('}');
        return sb.toString();
    }
}
