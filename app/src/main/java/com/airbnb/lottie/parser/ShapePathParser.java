package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ShapePathParser {
    static JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapePath getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 1) {
                i = jsonReader.scheduleImpl();
            } else if (PlaceComponentResult == 2) {
                animatableShapeValue = AnimatableValueParser.getErrorConfigVersion(jsonReader, lottieComposition);
            } else if (PlaceComponentResult == 3) {
                z = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new ShapePath(str, i, animatableShapeValue, z);
    }
}
