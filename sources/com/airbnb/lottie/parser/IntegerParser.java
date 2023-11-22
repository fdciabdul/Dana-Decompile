package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser getAuthRequestContext = new IntegerParser();

    private IntegerParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ Integer KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.BuiltInFictitiousFunctionClassFactory(jsonReader) * f));
    }
}
