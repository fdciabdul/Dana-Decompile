package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.mobile.zebra.data.ZebraData;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FontCharacterParser {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("ch", GriverMonitorConstants.KEY_SIZE, "w", ZebraData.ATTR_STYLE, "fFamily", "data");
    private static final JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("shapes");

    private FontCharacterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontCharacter MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        double d = 0.0d;
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult == 0) {
                c = jsonReader.moveToNextValue().charAt(0);
            } else if (PlaceComponentResult == 1) {
                d2 = jsonReader.lookAheadTest();
            } else if (PlaceComponentResult == 2) {
                d = jsonReader.lookAheadTest();
            } else if (PlaceComponentResult == 3) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 4) {
                str2 = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 5) {
                jsonReader.BuiltInFictitiousFunctionClassFactory();
                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    if (jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2) == 0) {
                        jsonReader.getAuthRequestContext();
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            arrayList.add((ShapeGroup) ContentModelParser.MyBillsEntityDataFactory(jsonReader, lottieComposition));
                        }
                        jsonReader.MyBillsEntityDataFactory();
                    } else {
                        jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                        jsonReader.DatabaseTableConfigUtil();
                    }
                }
                jsonReader.PlaceComponentResult();
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        jsonReader.PlaceComponentResult();
        return new FontCharacter(arrayList, c, d2, d, str, str2);
    }
}
