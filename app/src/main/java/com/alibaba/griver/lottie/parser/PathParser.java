package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes6.dex */
public class PathParser implements ValueParser<PointF> {
    public static final PathParser INSTANCE = new PathParser();

    private PathParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.lottie.parser.ValueParser
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        return JsonUtils.jsonToPoint(jsonReader, f);
    }
}
