package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
class MergePathsParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "mm", "hd");

    private MergePathsParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths PlaceComponentResult(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(PlaceComponentResult);
            if (PlaceComponentResult2 == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult2 == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.scheduleImpl());
            } else if (PlaceComponentResult2 == 2) {
                z = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
