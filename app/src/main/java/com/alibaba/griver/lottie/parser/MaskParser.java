package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableIntegerValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableShapeValue;
import com.alibaba.griver.lottie.model.content.Mask;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.utils.Logger;
import com.huawei.hms.opendevice.i;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MaskParser {
    private MaskParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            int hashCode = nextName.hashCode();
            char c2 = 65535;
            if (hashCode == 111) {
                if (nextName.equals("o")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode == 3588) {
                if (nextName.equals("pt")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && nextName.equals("mode")) {
                    c = 3;
                }
                c = 65535;
            } else {
                if (nextName.equals("inv")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c == 0) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (c == 1) {
                animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
            } else if (c == 2) {
                z = jsonReader.nextBoolean();
            } else if (c == 3) {
                String nextString = jsonReader.nextString();
                nextString.hashCode();
                int hashCode2 = nextString.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 == 115 && nextString.equals("s")) {
                            c2 = 2;
                        }
                    } else if (nextString.equals(i.MyBillsEntityDataFactory)) {
                        c2 = 1;
                    }
                } else if (nextString.equals("a")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else if (c2 == 1) {
                    lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                } else if (c2 == 2) {
                    maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown mask mode ");
                    sb.append(nextName);
                    sb.append(". Defaulting to Add.");
                    Logger.warning(sb.toString());
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z);
    }
}
