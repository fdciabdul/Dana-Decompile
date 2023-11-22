package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.UgcConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getTypeMappings extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public getTypeMappings(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        UgcConfigResult ugcConfigResult = (UgcConfigResult) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        Integer num = ugcConfigResult.ugcInterval;
        j.PlaceComponentResult(jsonWriter, 28);
        Integer num2 = ugcConfigResult.ugcInterval;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        UgcConfigResult ugcConfigResult = new UgcConfigResult();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 305) {
                jsonReader.skipValue();
            } else if (z) {
                ugcConfigResult.ugcInterval = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                ugcConfigResult.ugcInterval = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return ugcConfigResult;
    }
}
