package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.model.ParagraphStyle;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;

/* loaded from: classes6.dex */
public class ParagraphStyleParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of(SecurityConstants.KEY_TEXT, "miniScale", "lineBreakMode");

    private ParagraphStyleParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParagraphStyle parse(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                f = (float) jsonReader.nextDouble();
            } else if (selectName == 2) {
                str2 = jsonReader.nextString();
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new ParagraphStyle(str, f, str2);
    }
}
