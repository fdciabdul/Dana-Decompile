package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.cashier.data.repository.source.network.request.MobileLocationInfoWithCity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class PrefetchDownloadStatus extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public PrefetchDownloadStatus(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MobileLocationInfoWithCity mobileLocationInfoWithCity = (MobileLocationInfoWithCity) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = mobileLocationInfoWithCity.city;
        j.PlaceComponentResult(jsonWriter, 329);
        jsonWriter.value(mobileLocationInfoWithCity.city);
        mobileLocationInfoWithCity.BuiltInFictitiousFunctionClassFactory(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MobileLocationInfoWithCity mobileLocationInfoWithCity = new MobileLocationInfoWithCity();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 436) {
                mobileLocationInfoWithCity.MyBillsEntityDataFactory(gson, jsonReader, authRequestContext);
            } else if (z) {
                mobileLocationInfoWithCity.city = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                mobileLocationInfoWithCity.city = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return mobileLocationInfoWithCity;
    }
}
