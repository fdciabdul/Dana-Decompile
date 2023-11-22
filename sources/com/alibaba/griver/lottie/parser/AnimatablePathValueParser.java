package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePathValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableValue;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class AnimatablePathValueParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("k", "x", "y");

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonReader.Token.END_OBJECT) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                animatablePathValue = parse(jsonReader, lottieComposition);
            } else if (selectName != 1) {
                if (selectName == 2) {
                    if (jsonReader.peek() == JsonReader.Token.STRING) {
                        jsonReader.skipValue();
                        z = true;
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    }
                } else {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                }
            } else if (jsonReader.peek() == JsonReader.Token.STRING) {
                jsonReader.skipValue();
                z = true;
            } else {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
