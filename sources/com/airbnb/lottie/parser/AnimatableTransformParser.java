package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVParams;
import id.dana.data.constant.BranchLinkConstant;

/* loaded from: classes3.dex */
public class AnimatableTransformParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("a", BranchLinkConstant.PayloadKey.PROMO_CODE, "s", "rz", BranchLinkConstant.PayloadKey.REFERRAL, "o", RVParams.SHOW_OPTION_MENU, "eo", "sk", "sa");
    private static final JsonReader.Options MyBillsEntityDataFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("k");

    private AnimatableTransformParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.airbnb.lottie.model.animatable.AnimatableTransform getAuthRequestContext(com.airbnb.lottie.parser.moshi.JsonReader r27, com.airbnb.lottie.LottieComposition r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.getAuthRequestContext(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.animatable.AnimatableTransform");
    }

    private static boolean getAuthRequestContext(AnimatablePathValue animatablePathValue) {
        return animatablePathValue == null || (animatablePathValue.BuiltInFictitiousFunctionClassFactory() && animatablePathValue.KClassImpl$Data$declaredNonStaticMembers$2().get(0).moveToNextValue.equals(0.0f, 0.0f));
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(AnimatableValue<PointF, PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.BuiltInFictitiousFunctionClassFactory() && animatableValue.KClassImpl$Data$declaredNonStaticMembers$2().get(0).moveToNextValue.equals(0.0f, 0.0f));
    }

    private static boolean MyBillsEntityDataFactory(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.BuiltInFictitiousFunctionClassFactory() && animatableFloatValue.KClassImpl$Data$declaredNonStaticMembers$2().get(0).moveToNextValue.floatValue() == 0.0f);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(AnimatableScaleValue animatableScaleValue) {
        return animatableScaleValue == null || (animatableScaleValue.BuiltInFictitiousFunctionClassFactory() && animatableScaleValue.KClassImpl$Data$declaredNonStaticMembers$2().get(0).moveToNextValue.BuiltInFictitiousFunctionClassFactory());
    }

    private static boolean PlaceComponentResult(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.BuiltInFictitiousFunctionClassFactory() && animatableFloatValue.KClassImpl$Data$declaredNonStaticMembers$2().get(0).moveToNextValue.floatValue() == 0.0f);
    }

    private static boolean getAuthRequestContext(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.BuiltInFictitiousFunctionClassFactory() && animatableFloatValue.KClassImpl$Data$declaredNonStaticMembers$2().get(0).moveToNextValue.floatValue() == 0.0f);
    }
}
