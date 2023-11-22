package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.DealsConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class doCommonLog extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public doCommonLog(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DealsConfigResult dealsConfigResult = (DealsConfigResult) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = dealsConfigResult.danaDealsUrl;
        j.PlaceComponentResult(jsonWriter, 206);
        jsonWriter.value(dealsConfigResult.danaDealsUrl);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DealsConfigResult dealsConfigResult = new DealsConfigResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 91) {
                jsonReader.skipValue();
            } else if (z) {
                dealsConfigResult.danaDealsUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                dealsConfigResult.danaDealsUrl = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return dealsConfigResult;
    }
}
