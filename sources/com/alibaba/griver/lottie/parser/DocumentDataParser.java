package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.griver.lottie.model.DocumentData;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;

/* loaded from: classes6.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of(SecurityConstants.KEY_TEXT, f.f7258a, "s", "j", "tr", "lh", RVStartParams.KEY_LANDSCAPE_SHORT, "fc", RVParams.SAFEPAY_CONTEXT, "sw", "of", RVParams.PRESSO_LOGIN, "sz");

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.lottie.parser.ValueParser
    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f5 = 0.0f;
        boolean z = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt > DocumentData.Justification.CENTER.ordinal() || nextInt < 0) {
                        justification2 = DocumentData.Justification.CENTER;
                        break;
                    } else {
                        justification2 = DocumentData.Justification.values()[nextInt];
                        break;
                    }
                    break;
                case 4:
                    i = jsonReader.nextInt();
                    break;
                case 5:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    i2 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 8:
                    i3 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 9:
                    f5 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z = jsonReader.nextBoolean();
                    break;
                case 11:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 12:
                    pointF = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, f2, justification2, i, f3, f4, i2, i3, f5, z, pointF, pointF2);
    }
}
