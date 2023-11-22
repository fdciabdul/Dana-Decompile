package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.Content;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getMessaging extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getMessaging(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        Content content = (Content) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = content.bodyMessage;
        j.PlaceComponentResult(jsonWriter, 114);
        jsonWriter.value(content.bodyMessage);
        String str2 = content.contentLanguage;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE);
        jsonWriter.value(content.contentLanguage);
        String str3 = content.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(content.title);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Content content = new Content();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 388) {
                    if (authRequestContext != 395) {
                        jsonReader.skipValue();
                    } else if (z) {
                        content.bodyMessage = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        content.bodyMessage = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    content.contentLanguage = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    content.contentLanguage = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                content.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                content.title = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return content;
    }
}
