package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Memory;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class createOauthGrantLoadingIntent extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public createOauthGrantLoadingIntent(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Memory memory = (Memory) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = memory.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 463);
        jsonWriter.value(memory.KClassImpl$Data$declaredNonStaticMembers$2);
        String str2 = memory.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 229);
        jsonWriter.value(memory.BuiltInFictitiousFunctionClassFactory);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Memory memory = new Memory();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 65) {
                if (authRequestContext != 144) {
                    jsonReader.skipValue();
                } else if (z) {
                    memory.BuiltInFictitiousFunctionClassFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    memory.BuiltInFictitiousFunctionClassFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                memory.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                memory.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return memory;
    }
}
