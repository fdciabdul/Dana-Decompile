package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {
    public static final ScaleXYParser MyBillsEntityDataFactory = new ScaleXYParser();

    private ScaleXYParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ ScaleXY KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.getAuthRequestContext();
        }
        float lookAheadTest = (float) jsonReader.lookAheadTest();
        float lookAheadTest2 = (float) jsonReader.lookAheadTest();
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            jsonReader.DatabaseTableConfigUtil();
        }
        if (z) {
            jsonReader.MyBillsEntityDataFactory();
        }
        return new ScaleXY((lookAheadTest / 100.0f) * f, (lookAheadTest2 / 100.0f) * f);
    }
}
