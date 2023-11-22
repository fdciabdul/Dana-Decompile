package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes6.dex */
interface ValueParser<V> {
    V parse(JsonReader jsonReader, float f) throws IOException;
}
