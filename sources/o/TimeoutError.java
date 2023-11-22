package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.here.model.HereConfigResponse;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class TimeoutError extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson getAuthRequestContext;

    public TimeoutError(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        HereConfigResponse hereConfigResponse = (HereConfigResponse) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        if (hereConfigResponse != hereConfigResponse.excludeSource) {
            j.PlaceComponentResult(jsonWriter, 343);
            saveNickname savenickname = new saveNickname();
            List<String> list = hereConfigResponse.excludeSource;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, savenickname, list).write(jsonWriter, list);
        }
        Integer num = hereConfigResponse.factor;
        j.PlaceComponentResult(jsonWriter, 36);
        Integer num2 = hereConfigResponse.factor;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        Integer num3 = hereConfigResponse.maxBackoff;
        j.PlaceComponentResult(jsonWriter, 111);
        Integer num4 = hereConfigResponse.maxBackoff;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        HereConfigResponse hereConfigResponse = new HereConfigResponse();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 272) {
                if (authRequestContext != 530) {
                    if (authRequestContext != 568) {
                        jsonReader.skipValue();
                    } else if (z) {
                        hereConfigResponse.excludeSource = (List) gson.getAdapter(new saveNickname()).read2(jsonReader);
                    } else {
                        hereConfigResponse.excludeSource = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    hereConfigResponse.maxBackoff = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                } else {
                    hereConfigResponse.maxBackoff = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                hereConfigResponse.factor = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                hereConfigResponse.factor = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return hereConfigResponse;
    }
}
