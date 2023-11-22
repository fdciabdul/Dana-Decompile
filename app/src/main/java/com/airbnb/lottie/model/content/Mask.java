package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* loaded from: classes3.dex */
public class Mask {
    public final AnimatableIntegerValue BuiltInFictitiousFunctionClassFactory;
    public final MaskMode MyBillsEntityDataFactory;
    public final AnimatableShapeValue PlaceComponentResult;
    private final boolean getAuthRequestContext;

    /* loaded from: classes3.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.MyBillsEntityDataFactory = maskMode;
        this.PlaceComponentResult = animatableShapeValue;
        this.BuiltInFictitiousFunctionClassFactory = animatableIntegerValue;
        this.getAuthRequestContext = z;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}
