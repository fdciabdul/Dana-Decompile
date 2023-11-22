package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;

/* loaded from: classes3.dex */
public class AnimatableTextPropertiesParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("a");
    private static final JsonReader.Options getAuthRequestContext = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("fc", RVParams.SAFEPAY_CONTEXT, "sw", SecurityConstants.KEY_TEXT);

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (jsonReader.PlaceComponentResult(PlaceComponentResult) != 0) {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            } else {
                jsonReader.BuiltInFictitiousFunctionClassFactory();
                AnimatableColorValue animatableColorValue = null;
                AnimatableColorValue animatableColorValue2 = null;
                AnimatableFloatValue animatableFloatValue = null;
                AnimatableFloatValue animatableFloatValue2 = null;
                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    int PlaceComponentResult2 = jsonReader.PlaceComponentResult(getAuthRequestContext);
                    if (PlaceComponentResult2 == 0) {
                        animatableColorValue = AnimatableValueParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
                    } else if (PlaceComponentResult2 == 1) {
                        animatableColorValue2 = AnimatableValueParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
                    } else if (PlaceComponentResult2 == 2) {
                        animatableFloatValue = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                    } else if (PlaceComponentResult2 == 3) {
                        animatableFloatValue2 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                    } else {
                        jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                        jsonReader.DatabaseTableConfigUtil();
                    }
                }
                jsonReader.PlaceComponentResult();
                animatableTextProperties = new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
            }
        }
        jsonReader.PlaceComponentResult();
        return animatableTextProperties == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
    }
}
