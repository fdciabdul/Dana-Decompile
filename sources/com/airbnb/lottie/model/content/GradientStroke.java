package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes3.dex */
public class GradientStroke implements ContentModel {
    public final GradientType BuiltInFictitiousFunctionClassFactory;
    public final AnimatableFloatValue GetContactSyncConfig;
    public final AnimatableFloatValue KClassImpl$Data$declaredNonStaticMembers$2;
    public final ShapeStroke.LineCapType MyBillsEntityDataFactory;
    public final ShapeStroke.LineJoinType NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AnimatablePointValue NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AnimatablePointValue PlaceComponentResult;
    public final AnimatableGradientColorValue getAuthRequestContext;
    public final List<AnimatableFloatValue> getErrorConfigVersion;
    private final boolean initRecordTimeStamp;
    public final String lookAheadTest;
    public final AnimatableIntegerValue moveToNextValue;
    public final float scheduleImpl;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.lookAheadTest = str;
        this.BuiltInFictitiousFunctionClassFactory = gradientType;
        this.getAuthRequestContext = animatableGradientColorValue;
        this.moveToNextValue = animatableIntegerValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = animatablePointValue;
        this.PlaceComponentResult = animatablePointValue2;
        this.GetContactSyncConfig = animatableFloatValue;
        this.MyBillsEntityDataFactory = lineCapType;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lineJoinType;
        this.scheduleImpl = f;
        this.getErrorConfigVersion = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableFloatValue2;
        this.initRecordTimeStamp = z;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.initRecordTimeStamp;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }
}
