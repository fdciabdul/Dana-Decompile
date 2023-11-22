package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.ExternalStorage;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class getNewPassword extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;

    public getNewPassword(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ExternalStorage externalStorage = (ExternalStorage) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = externalStorage.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 5);
        jsonWriter.value(externalStorage.MyBillsEntityDataFactory);
        String str2 = externalStorage.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 218);
        jsonWriter.value(externalStorage.PlaceComponentResult);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ExternalStorage externalStorage = new ExternalStorage();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 172) {
                if (authRequestContext != 463) {
                    jsonReader.skipValue();
                } else if (z) {
                    externalStorage.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    externalStorage.PlaceComponentResult = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                externalStorage.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                externalStorage.MyBillsEntityDataFactory = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return externalStorage;
    }
}
