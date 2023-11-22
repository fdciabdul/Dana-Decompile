package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser BuiltInFictitiousFunctionClassFactory = new DocumentDataParser();
    private static final JsonReader.Options getAuthRequestContext = JsonReader.Options.BuiltInFictitiousFunctionClassFactory(SecurityConstants.KEY_TEXT, f.f7258a, "s", "j", "tr", "lh", RVStartParams.KEY_LANDSCAPE_SHORT, "fc", RVParams.SAFEPAY_CONTEXT, "sw", "of");

    private DocumentDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ DocumentData KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f5 = 0.0f;
        boolean z = true;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            switch (jsonReader.PlaceComponentResult(getAuthRequestContext)) {
                case 0:
                    str = jsonReader.moveToNextValue();
                    break;
                case 1:
                    str2 = jsonReader.moveToNextValue();
                    break;
                case 2:
                    f2 = (float) jsonReader.lookAheadTest();
                    break;
                case 3:
                    int scheduleImpl = jsonReader.scheduleImpl();
                    if (scheduleImpl > DocumentData.Justification.CENTER.ordinal() || scheduleImpl < 0) {
                        justification2 = DocumentData.Justification.CENTER;
                        break;
                    } else {
                        justification2 = DocumentData.Justification.values()[scheduleImpl];
                        break;
                    }
                case 4:
                    i = jsonReader.scheduleImpl();
                    break;
                case 5:
                    f3 = (float) jsonReader.lookAheadTest();
                    break;
                case 6:
                    f4 = (float) jsonReader.lookAheadTest();
                    break;
                case 7:
                    i2 = JsonUtils.getAuthRequestContext(jsonReader);
                    break;
                case 8:
                    i3 = JsonUtils.getAuthRequestContext(jsonReader);
                    break;
                case 9:
                    f5 = (float) jsonReader.lookAheadTest();
                    break;
                case 10:
                    z = jsonReader.getErrorConfigVersion();
                    break;
                default:
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                    break;
            }
        }
        jsonReader.PlaceComponentResult();
        return new DocumentData(str, str2, f2, justification2, i, f3, f4, i2, i3, f5, z);
    }
}
