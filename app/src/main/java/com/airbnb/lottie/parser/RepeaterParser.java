package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class RepeaterParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    public static Repeater MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(PlaceComponentResult);
            if (PlaceComponentResult2 == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult2 == 1) {
                animatableFloatValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
            } else if (PlaceComponentResult2 == 2) {
                animatableFloatValue2 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
            } else if (PlaceComponentResult2 == 3) {
                animatableTransform = AnimatableTransformParser.getAuthRequestContext(jsonReader, lottieComposition);
            } else if (PlaceComponentResult2 == 4) {
                z = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform, z);
    }
}
