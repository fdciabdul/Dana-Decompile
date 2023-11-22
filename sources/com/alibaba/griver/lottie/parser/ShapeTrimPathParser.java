package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.content.ShapeTrimPath;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.huawei.hms.push.e;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ShapeTrimPathParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("s", e.PlaceComponentResult, "o", "nm", "m", "hd");

    private ShapeTrimPathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 1) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 2) {
                animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 3) {
                str = jsonReader.nextString();
            } else if (selectName == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
            } else if (selectName == 5) {
                z = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z);
    }
}
