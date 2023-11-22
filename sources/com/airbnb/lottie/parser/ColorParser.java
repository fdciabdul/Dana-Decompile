package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ColorParser implements ValueParser<Integer> {
    public static final ColorParser getAuthRequestContext = new ColorParser();

    private ColorParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ Integer KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.getAuthRequestContext();
        }
        double lookAheadTest = jsonReader.lookAheadTest();
        double lookAheadTest2 = jsonReader.lookAheadTest();
        double lookAheadTest3 = jsonReader.lookAheadTest();
        double lookAheadTest4 = jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER ? jsonReader.lookAheadTest() : 1.0d;
        if (z) {
            jsonReader.MyBillsEntityDataFactory();
        }
        if (lookAheadTest <= 1.0d && lookAheadTest2 <= 1.0d && lookAheadTest3 <= 1.0d) {
            lookAheadTest *= 255.0d;
            lookAheadTest2 *= 255.0d;
            lookAheadTest3 *= 255.0d;
            if (lookAheadTest4 <= 1.0d) {
                lookAheadTest4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) lookAheadTest4, (int) lookAheadTest, (int) lookAheadTest2, (int) lookAheadTest3));
    }
}
