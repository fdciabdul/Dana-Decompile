package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.Content;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class times extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public times(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        EmergencyNotificationConfig emergencyNotificationConfig = (EmergencyNotificationConfig) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (emergencyNotificationConfig != emergencyNotificationConfig.content) {
            j.PlaceComponentResult(jsonWriter, 175);
            timer timerVar = new timer();
            List<Content> list = emergencyNotificationConfig.content;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, timerVar, list).write(jsonWriter, list);
        }
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(emergencyNotificationConfig.enable);
        j.PlaceComponentResult(jsonWriter, 67);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(emergencyNotificationConfig.endDate);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        EmergencyNotificationConfig emergencyNotificationConfig = new EmergencyNotificationConfig();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 175) {
                if (authRequestContext != 499) {
                    if (authRequestContext != 520) {
                        jsonReader.skipValue();
                    } else if (z) {
                        emergencyNotificationConfig.endDate = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    emergencyNotificationConfig.content = (List) gson.getAdapter(new timer()).read2(jsonReader);
                } else {
                    emergencyNotificationConfig.content = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                emergencyNotificationConfig.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return emergencyNotificationConfig;
    }
}
