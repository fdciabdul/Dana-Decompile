package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* loaded from: classes3.dex */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableFloatValue MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) throws IOException {
        return new AnimatableFloatValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, z ? Utils.getAuthRequestContext() : 1.0f, FloatParser.PlaceComponentResult, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableIntegerValue MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, 1.0f, IntegerParser.getAuthRequestContext, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatablePointValue getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, Utils.getAuthRequestContext(), PointFParser.BuiltInFictitiousFunctionClassFactory, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableScaleValue NetworkUserEntityData$$ExternalSyntheticLambda0(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, 1.0f, ScaleXYParser.MyBillsEntityDataFactory, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableShapeValue getErrorConfigVersion(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, Utils.getAuthRequestContext(), ShapeDataParser.KClassImpl$Data$declaredNonStaticMembers$2, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableTextFrame KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, 1.0f, DocumentDataParser.BuiltInFictitiousFunctionClassFactory, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableColorValue BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, 1.0f, ColorParser.getAuthRequestContext, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableGradientColorValue PlaceComponentResult(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        return new AnimatableGradientColorValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, 1.0f, new GradientColorParser(i), false));
    }

    public static AnimatableFloatValue PlaceComponentResult(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableFloatValue(KeyframesParser.getAuthRequestContext(jsonReader, lottieComposition, Utils.getAuthRequestContext(), FloatParser.PlaceComponentResult, false));
    }
}
