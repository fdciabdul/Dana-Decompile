package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser BuiltInFictitiousFunctionClassFactory = new PointFParser();

    private PointFParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    public final /* synthetic */ PointF KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token GetContactSyncConfig = jsonReader.GetContactSyncConfig();
        if (GetContactSyncConfig == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
        }
        if (GetContactSyncConfig == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
        }
        if (GetContactSyncConfig == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.lookAheadTest()) * f, ((float) jsonReader.lookAheadTest()) * f);
            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                jsonReader.DatabaseTableConfigUtil();
            }
            return pointF;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot convert json to point. Next token is ");
        sb.append(GetContactSyncConfig);
        throw new IllegalArgumentException(sb.toString());
    }
}
