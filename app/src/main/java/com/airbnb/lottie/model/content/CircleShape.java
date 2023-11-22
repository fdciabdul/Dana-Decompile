package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class CircleShape implements ContentModel {
    public final AnimatableValue<PointF, PointF> BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    public final AnimatablePointValue PlaceComponentResult;
    private final boolean getAuthRequestContext;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z, boolean z2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = animatableValue;
        this.PlaceComponentResult = animatablePointValue;
        this.getAuthRequestContext = z;
        this.MyBillsEntityDataFactory = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
