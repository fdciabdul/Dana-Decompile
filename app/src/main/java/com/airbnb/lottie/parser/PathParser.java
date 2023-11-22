package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class PathParser implements ValueParser<PointF> {
    public static final PathParser KClassImpl$Data$declaredNonStaticMembers$2 = new PathParser();

    private PathParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* bridge */ /* synthetic */ PointF KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        return JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
    }
}
