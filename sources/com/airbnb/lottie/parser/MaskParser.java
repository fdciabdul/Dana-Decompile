package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.huawei.hms.opendevice.i;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MaskParser {
    private MaskParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mask MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            String NetworkUserEntityData$$ExternalSyntheticLambda0 = jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
            int hashCode = NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
            char c2 = 65535;
            if (hashCode == 111) {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0.equals("o")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode == 3588) {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0.equals("pt")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && NetworkUserEntityData$$ExternalSyntheticLambda0.equals("mode")) {
                    c = 3;
                }
                c = 65535;
            } else {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0.equals("inv")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c == 0) {
                animatableIntegerValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
            } else if (c == 1) {
                animatableShapeValue = AnimatableValueParser.getErrorConfigVersion(jsonReader, lottieComposition);
            } else if (c == 2) {
                z = jsonReader.getErrorConfigVersion();
            } else if (c == 3) {
                String moveToNextValue = jsonReader.moveToNextValue();
                moveToNextValue.hashCode();
                int hashCode2 = moveToNextValue.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 != 110) {
                            if (hashCode2 == 115 && moveToNextValue.equals("s")) {
                                c2 = 3;
                            }
                        } else if (moveToNextValue.equals("n")) {
                            c2 = 2;
                        }
                    } else if (moveToNextValue.equals(i.MyBillsEntityDataFactory)) {
                        c2 = 1;
                    }
                } else if (moveToNextValue.equals("a")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else if (c2 == 1) {
                    Logger.getAuthRequestContext("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    lottieComposition.initRecordTimeStamp.add("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                } else if (c2 == 2) {
                    maskMode = Mask.MaskMode.MASK_MODE_NONE;
                } else if (c2 == 3) {
                    maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown mask mode ");
                    sb.append(NetworkUserEntityData$$ExternalSyntheticLambda0);
                    sb.append(". Defaulting to Add.");
                    Logger.getAuthRequestContext(sb.toString());
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                }
            } else {
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        jsonReader.PlaceComponentResult();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z);
    }
}
