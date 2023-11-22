package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes6.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    private IntegerParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.lottie.parser.ValueParser
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.valueFromObject(jsonReader) * f));
    }
}
