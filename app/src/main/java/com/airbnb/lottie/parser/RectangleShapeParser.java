package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* loaded from: classes3.dex */
public class RectangleShapeParser {
    private static final JsonReader.Options getAuthRequestContext = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", BranchLinkConstant.PayloadKey.PROMO_CODE, "s", BranchLinkConstant.PayloadKey.REFERRAL, "hd");

    private RectangleShapeParser() {
    }

    public static RectangleShape MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(getAuthRequestContext);
            if (PlaceComponentResult == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 1) {
                animatableValue = AnimatablePathValueParser.getAuthRequestContext(jsonReader, lottieComposition);
            } else if (PlaceComponentResult == 2) {
                animatablePointValue = AnimatableValueParser.getAuthRequestContext(jsonReader, lottieComposition);
            } else if (PlaceComponentResult == 3) {
                animatableFloatValue = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
            } else if (PlaceComponentResult == 4) {
                z = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
    }
}
