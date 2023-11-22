package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.NearbyTrendingKeywordEntity;
import java.io.IOException;

/* renamed from: o.getWalletV3RecommendationConfig$lambda-193  reason: invalid class name */
/* loaded from: classes4.dex */
public final class getWalletV3RecommendationConfig$lambda193 extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getWalletV3RecommendationConfig$lambda193(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        NearbyTrendingKeywordEntity nearbyTrendingKeywordEntity = (NearbyTrendingKeywordEntity) obj;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        String str = nearbyTrendingKeywordEntity.name;
        j.PlaceComponentResult(jsonWriter, 552);
        jsonWriter.value(nearbyTrendingKeywordEntity.name);
        String str2 = nearbyTrendingKeywordEntity.tag;
        j.PlaceComponentResult(jsonWriter, 7);
        jsonWriter.value(nearbyTrendingKeywordEntity.tag);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        NearbyTrendingKeywordEntity nearbyTrendingKeywordEntity = new NearbyTrendingKeywordEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 377) {
                if (authRequestContext != 474) {
                    jsonReader.skipValue();
                } else if (z) {
                    nearbyTrendingKeywordEntity.name = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    nearbyTrendingKeywordEntity.name = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                nearbyTrendingKeywordEntity.tag = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                nearbyTrendingKeywordEntity.tag = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return nearbyTrendingKeywordEntity;
    }
}
