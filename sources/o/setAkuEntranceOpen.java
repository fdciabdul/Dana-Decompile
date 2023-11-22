package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.NearbyMigrateApiResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setAkuEntranceOpen extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public setAkuEntranceOpen(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        NearbyMigrateApiResult nearbyMigrateApiResult = (NearbyMigrateApiResult) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        Boolean bool = nearbyMigrateApiResult.queryList;
        j.PlaceComponentResult(jsonWriter, 35);
        jsonWriter.value(nearbyMigrateApiResult.queryList);
        Boolean bool2 = nearbyMigrateApiResult.queryRadius;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE);
        jsonWriter.value(nearbyMigrateApiResult.queryRadius);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        NearbyMigrateApiResult nearbyMigrateApiResult = new NearbyMigrateApiResult();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 424) {
                if (authRequestContext != 542) {
                    jsonReader.skipValue();
                } else if (z) {
                    nearbyMigrateApiResult.queryRadius = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    nearbyMigrateApiResult.queryRadius = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                nearbyMigrateApiResult.queryList = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
            } else {
                nearbyMigrateApiResult.queryList = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return nearbyMigrateApiResult;
    }
}
