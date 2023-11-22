package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class ShapeTrimPath implements ContentModel {
    public final Type BuiltInFictitiousFunctionClassFactory;
    public final AnimatableFloatValue KClassImpl$Data$declaredNonStaticMembers$2;
    public final AnimatableFloatValue MyBillsEntityDataFactory;
    public final AnimatableFloatValue PlaceComponentResult;
    public final String getAuthRequestContext;
    private final boolean lookAheadTest;

    /* loaded from: classes3.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return INDIVIDUALLY;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown trim path type ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = type;
        this.MyBillsEntityDataFactory = animatableFloatValue;
        this.PlaceComponentResult = animatableFloatValue2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animatableFloatValue3;
        this.lookAheadTest = z;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trim Path: {start: ");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", end: ");
        sb.append(this.PlaceComponentResult);
        sb.append(", offset: ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("}");
        return sb.toString();
    }
}
