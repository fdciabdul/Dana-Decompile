package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* loaded from: classes3.dex */
class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PathKeyframe MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new PathKeyframe(lottieComposition, KeyframeParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition, Utils.getAuthRequestContext(), PathParser.KClassImpl$Data$declaredNonStaticMembers$2, jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
