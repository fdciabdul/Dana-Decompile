package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.FontCharacter;
import com.alibaba.griver.lottie.model.content.ShapeGroup;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.zebra.data.ZebraData;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class FontCharacterParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("ch", GriverMonitorConstants.KEY_SIZE, "w", ZebraData.ATTR_STYLE, "fFamily", "data");
    private static final JsonReader.Options DATA_NAMES = JsonReader.Options.of("shapes");

    private FontCharacterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d = 0.0d;
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                c = jsonReader.nextString().charAt(0);
            } else if (selectName == 1) {
                d2 = jsonReader.nextDouble();
            } else if (selectName == 2) {
                d = jsonReader.nextDouble();
            } else if (selectName == 3) {
                str = jsonReader.nextString();
            } else if (selectName == 4) {
                str2 = jsonReader.nextString();
            } else if (selectName == 5) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.selectName(DATA_NAMES) == 0) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                        }
                        jsonReader.endArray();
                    } else {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, c, d2, d, str, str2);
    }
}
