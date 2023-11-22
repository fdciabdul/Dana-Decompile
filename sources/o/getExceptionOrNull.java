package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.yellowmessenger.ymchat.models.YMBotEventResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getExceptionOrNull extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getExceptionOrNull(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        YMBotEventResponse yMBotEventResponse = (YMBotEventResponse) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (yMBotEventResponse != yMBotEventResponse.PlaceComponentResult) {
            j.PlaceComponentResult(jsonWriter, 176);
            jsonWriter.value(yMBotEventResponse.PlaceComponentResult);
        }
        if (yMBotEventResponse != yMBotEventResponse.getAuthRequestContext) {
            j.PlaceComponentResult(jsonWriter, 584);
            jsonWriter.value(yMBotEventResponse.getAuthRequestContext);
        }
        j.PlaceComponentResult(jsonWriter, 301);
        jsonWriter.value(yMBotEventResponse.BuiltInFictitiousFunctionClassFactory);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        YMBotEventResponse yMBotEventResponse = new YMBotEventResponse();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 153) {
                if (authRequestContext != 174) {
                    if (authRequestContext != 409) {
                        jsonReader.skipValue();
                    } else if (z) {
                        yMBotEventResponse.getAuthRequestContext = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        yMBotEventResponse.getAuthRequestContext = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    yMBotEventResponse.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    yMBotEventResponse.PlaceComponentResult = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                yMBotEventResponse.BuiltInFictitiousFunctionClassFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return yMBotEventResponse;
    }
}
