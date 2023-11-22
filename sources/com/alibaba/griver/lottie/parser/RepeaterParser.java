package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableTransform;
import com.alibaba.griver.lottie.model.content.Repeater;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes6.dex */
public class RepeaterParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    public static Repeater parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 2) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
            } else if (selectName == 3) {
                animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
            } else if (selectName == 4) {
                z = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform, z);
    }
}
