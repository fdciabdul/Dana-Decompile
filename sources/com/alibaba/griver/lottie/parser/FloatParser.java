package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes6.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser INSTANCE = new FloatParser();

    private FloatParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.lottie.parser.ValueParser
    public Float parse(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(JsonUtils.valueFromObject(jsonReader) * f);
    }
}
