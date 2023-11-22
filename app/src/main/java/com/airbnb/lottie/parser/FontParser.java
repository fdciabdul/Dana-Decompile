package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FontParser {
    private static final JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("fFamily", "fName", "fStyle", "ascent");

    private FontParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Font PlaceComponentResult(JsonReader jsonReader) throws IOException {
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            if (PlaceComponentResult == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 1) {
                str2 = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 2) {
                str3 = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 3) {
                f = (float) jsonReader.lookAheadTest();
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        jsonReader.PlaceComponentResult();
        return new Font(str, str2, str3, f);
    }
}
