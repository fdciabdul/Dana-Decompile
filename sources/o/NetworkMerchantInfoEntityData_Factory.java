package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.TimeLocation;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class NetworkMerchantInfoEntityData_Factory extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public NetworkMerchantInfoEntityData_Factory(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TimeLocation timeLocation = (TimeLocation) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = timeLocation.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 503);
        jsonWriter.value(timeLocation.PlaceComponentResult);
        String str2 = timeLocation.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 583);
        jsonWriter.value(timeLocation.MyBillsEntityDataFactory);
        String str3 = timeLocation.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 85);
        jsonWriter.value(timeLocation.KClassImpl$Data$declaredNonStaticMembers$2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        TimeLocation timeLocation = new TimeLocation();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 68) {
                if (authRequestContext != 253) {
                    if (authRequestContext != 412) {
                        jsonReader.skipValue();
                    } else if (z) {
                        timeLocation.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        timeLocation.PlaceComponentResult = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    timeLocation.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    timeLocation.MyBillsEntityDataFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                timeLocation.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                timeLocation.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return timeLocation;
    }
}
