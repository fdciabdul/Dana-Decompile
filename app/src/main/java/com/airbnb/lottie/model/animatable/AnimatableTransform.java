package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class AnimatableTransform implements ModifierContent, ContentModel {
    public final AnimatableFloatValue BuiltInFictitiousFunctionClassFactory;
    public final AnimatableFloatValue KClassImpl$Data$declaredNonStaticMembers$2;
    public final AnimatablePathValue MyBillsEntityDataFactory;
    public final AnimatableFloatValue NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AnimatableValue<PointF, PointF> PlaceComponentResult;
    public final AnimatableIntegerValue getAuthRequestContext;
    public final AnimatableScaleValue getErrorConfigVersion;
    public final AnimatableFloatValue lookAheadTest;
    public final AnimatableFloatValue scheduleImpl;

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5) {
        this.MyBillsEntityDataFactory = animatablePathValue;
        this.PlaceComponentResult = animatableValue;
        this.getErrorConfigVersion = animatableScaleValue;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableFloatValue;
        this.getAuthRequestContext = animatableIntegerValue;
        this.scheduleImpl = animatableFloatValue2;
        this.BuiltInFictitiousFunctionClassFactory = animatableFloatValue3;
        this.lookAheadTest = animatableFloatValue4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = animatableFloatValue5;
    }
}
