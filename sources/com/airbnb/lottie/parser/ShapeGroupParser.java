package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ShapeGroupParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "hd", "it");

    private ShapeGroupParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeGroup PlaceComponentResult(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(PlaceComponentResult);
            if (PlaceComponentResult2 == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult2 == 1) {
                z = jsonReader.getErrorConfigVersion();
            } else if (PlaceComponentResult2 == 2) {
                jsonReader.getAuthRequestContext();
                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    ContentModel MyBillsEntityDataFactory = ContentModelParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
                    if (MyBillsEntityDataFactory != null) {
                        arrayList.add(MyBillsEntityDataFactory);
                    }
                }
                jsonReader.MyBillsEntityDataFactory();
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new ShapeGroup(str, arrayList, z);
    }
}
