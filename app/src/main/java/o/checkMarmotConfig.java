package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.cashier.data.repository.source.network.request.MobileEnvInfoWithCity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class checkMarmotConfig extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public checkMarmotConfig(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MobileEnvInfoWithCity mobileEnvInfoWithCity = (MobileEnvInfoWithCity) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        String str = mobileEnvInfoWithCity.locationCity;
        j.PlaceComponentResult(jsonWriter, 52);
        jsonWriter.value(mobileEnvInfoWithCity.locationCity);
        mobileEnvInfoWithCity.BuiltInFictitiousFunctionClassFactory(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MobileEnvInfoWithCity mobileEnvInfoWithCity = new MobileEnvInfoWithCity();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 381) {
                mobileEnvInfoWithCity.KClassImpl$Data$declaredNonStaticMembers$2(gson, jsonReader, authRequestContext);
            } else if (z) {
                mobileEnvInfoWithCity.locationCity = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                mobileEnvInfoWithCity.locationCity = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return mobileEnvInfoWithCity;
    }
}
