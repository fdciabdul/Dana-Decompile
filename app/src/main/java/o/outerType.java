package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.cardbinding.data.model.SupportedCardEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class outerType extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public outerType(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        SupportedCardEntity supportedCardEntity = (SupportedCardEntity) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = supportedCardEntity.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 92);
        jsonWriter.value(supportedCardEntity.MyBillsEntityDataFactory);
        String str2 = supportedCardEntity.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 552);
        jsonWriter.value(supportedCardEntity.KClassImpl$Data$declaredNonStaticMembers$2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SupportedCardEntity supportedCardEntity = new SupportedCardEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 295) {
                if (authRequestContext != 474) {
                    jsonReader.skipValue();
                } else if (z) {
                    supportedCardEntity.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    supportedCardEntity.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                supportedCardEntity.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                supportedCardEntity.MyBillsEntityDataFactory = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return supportedCardEntity;
    }
}
