package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BlurEffectParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("ef");
    private static final JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("ty", SecurityConstants.KEY_VALUE);

    BlurEffectParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BlurEffect KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        BlurEffect blurEffect = null;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (jsonReader.PlaceComponentResult(PlaceComponentResult) == 0) {
                jsonReader.getAuthRequestContext();
                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    jsonReader.BuiltInFictitiousFunctionClassFactory();
                    BlurEffect blurEffect2 = null;
                    while (true) {
                        boolean z = false;
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                            if (PlaceComponentResult2 != 0) {
                                if (PlaceComponentResult2 != 1) {
                                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                    jsonReader.DatabaseTableConfigUtil();
                                } else if (z) {
                                    blurEffect2 = new BlurEffect(AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition));
                                } else {
                                    jsonReader.DatabaseTableConfigUtil();
                                }
                            } else if (jsonReader.scheduleImpl() == 0) {
                                z = true;
                            }
                        }
                    }
                    jsonReader.PlaceComponentResult();
                    if (blurEffect2 != null) {
                        blurEffect = blurEffect2;
                    }
                }
                jsonReader.MyBillsEntityDataFactory();
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return blurEffect;
    }
}
