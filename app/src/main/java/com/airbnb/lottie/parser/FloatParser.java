package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser PlaceComponentResult = new FloatParser();

    private FloatParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ Float KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(JsonUtils.BuiltInFictitiousFunctionClassFactory(jsonReader) * f);
    }
}
