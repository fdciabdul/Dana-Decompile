package com.alibaba.griver.lottie.parser;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableTextProperties;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;

/* loaded from: classes6.dex */
public class AnimatableTextPropertiesParser {
    private static JsonReader.Options PROPERTIES_NAMES = JsonReader.Options.of("a");
    private static JsonReader.Options ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of("fc", RVParams.SAFEPAY_CONTEXT, "sw", SecurityConstants.KEY_TEXT);

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(PROPERTIES_NAMES) == 0) {
                animatableTextProperties = parseAnimatableTextProperties(jsonReader, lottieComposition);
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return animatableTextProperties == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
    }

    private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
            if (selectName == 0) {
                animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (selectName == 1) {
                animatableColorValue2 = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }
}
