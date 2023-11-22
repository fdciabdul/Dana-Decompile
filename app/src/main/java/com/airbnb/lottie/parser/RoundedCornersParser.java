package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* loaded from: classes3.dex */
public class RoundedCornersParser {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", BranchLinkConstant.PayloadKey.REFERRAL, "hd");

    private RoundedCornersParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoundedCorners MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z = false;
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 1) {
                animatableFloatValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, true);
            } else if (PlaceComponentResult == 2) {
                z = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        if (z) {
            return null;
        }
        return new RoundedCorners(str, animatableFloatValue);
    }
}
