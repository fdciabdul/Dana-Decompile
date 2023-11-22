package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.HelpButtonConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class FloatPoint extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public FloatPoint(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        HelpButtonConfig helpButtonConfig = (HelpButtonConfig) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(helpButtonConfig.enable);
        String str = helpButtonConfig.type;
        j.PlaceComponentResult(jsonWriter, 237);
        jsonWriter.value(helpButtonConfig.type);
        String str2 = helpButtonConfig.url;
        j.PlaceComponentResult(jsonWriter, 320);
        jsonWriter.value(helpButtonConfig.url);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        HelpButtonConfig helpButtonConfig = new HelpButtonConfig();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 95) {
                if (authRequestContext != 175) {
                    if (authRequestContext != 283) {
                        jsonReader.skipValue();
                    } else if (z) {
                        helpButtonConfig.type = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        helpButtonConfig.type = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    helpButtonConfig.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                helpButtonConfig.url = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                helpButtonConfig.url = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return helpButtonConfig;
    }
}
