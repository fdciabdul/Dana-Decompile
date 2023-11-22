package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class PolystarShape implements ContentModel {
    public final String BuiltInFictitiousFunctionClassFactory;
    private final boolean GetContactSyncConfig;
    public final AnimatableFloatValue KClassImpl$Data$declaredNonStaticMembers$2;
    public final AnimatableFloatValue MyBillsEntityDataFactory;
    public final AnimatableValue<PointF, PointF> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AnimatableFloatValue PlaceComponentResult;
    public final AnimatableFloatValue getAuthRequestContext;
    public final AnimatableFloatValue getErrorConfigVersion;
    private final boolean lookAheadTest;
    public final Type moveToNextValue;
    public final AnimatableFloatValue scheduleImpl;

    /* loaded from: classes3.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z, boolean z2) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.moveToNextValue = type;
        this.getErrorConfigVersion = animatableFloatValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = animatableValue;
        this.scheduleImpl = animatableFloatValue2;
        this.MyBillsEntityDataFactory = animatableFloatValue3;
        this.PlaceComponentResult = animatableFloatValue4;
        this.getAuthRequestContext = animatableFloatValue5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableFloatValue6;
        this.lookAheadTest = z;
        this.GetContactSyncConfig = z2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.lookAheadTest;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }
}
