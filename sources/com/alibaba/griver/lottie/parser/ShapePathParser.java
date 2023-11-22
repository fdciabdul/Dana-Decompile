package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableShapeValue;
import com.alibaba.griver.lottie.model.content.ShapePath;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ShapePathParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                i = jsonReader.nextInt();
            } else if (selectName == 2) {
                animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapePath(str, i, animatableShapeValue, z);
    }
}
