package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.push.e;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ShapeTrimPathParser {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("s", e.PlaceComponentResult, "o", "nm", "m", "hd");

    private ShapeTrimPathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult == 0) {
                animatableFloatValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
            } else if (PlaceComponentResult == 1) {
                animatableFloatValue2 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
            } else if (PlaceComponentResult == 2) {
                animatableFloatValue3 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
            } else if (PlaceComponentResult == 3) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.scheduleImpl());
            } else if (PlaceComponentResult == 5) {
                z = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z);
    }
}
