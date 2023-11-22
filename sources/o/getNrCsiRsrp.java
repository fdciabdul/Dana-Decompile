package o;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.NearbyTrendingKeywordEntity;
import id.dana.data.config.source.amcs.result.NearbyConfigResult;
import id.dana.data.config.source.amcs.result.NearbyMigrateApiResult;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class getNrCsiRsrp extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public getNrCsiRsrp(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        NearbyConfigResult nearbyConfigResult = (NearbyConfigResult) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        NearbyMigrateApiResult nearbyMigrateApiResult = nearbyConfigResult.migrateApi;
        j.PlaceComponentResult(jsonWriter, AUScreenAdaptTool.WIDTH_BASE);
        NearbyMigrateApiResult nearbyMigrateApiResult2 = nearbyConfigResult.migrateApi;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, NearbyMigrateApiResult.class, nearbyMigrateApiResult2).write(jsonWriter, nearbyMigrateApiResult2);
        Boolean bool = nearbyConfigResult.nearbyRevamp;
        j.PlaceComponentResult(jsonWriter, 287);
        jsonWriter.value(nearbyConfigResult.nearbyRevamp);
        Double d = nearbyConfigResult.reviewCount;
        j.PlaceComponentResult(jsonWriter, 445);
        Double d2 = nearbyConfigResult.reviewCount;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Double.class, d2).write(jsonWriter, d2);
        if (nearbyConfigResult != nearbyConfigResult.trendingKeyword) {
            j.PlaceComponentResult(jsonWriter, 345);
            access$getFeaturedBankListAdapter$p access_getfeaturedbanklistadapter_p = new access$getFeaturedBankListAdapter$p();
            List<NearbyTrendingKeywordEntity> list = nearbyConfigResult.trendingKeyword;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, access_getfeaturedbanklistadapter_p, list).write(jsonWriter, list);
        }
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        NearbyConfigResult nearbyConfigResult = new NearbyConfigResult();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 354) {
                if (authRequestContext != 398) {
                    if (authRequestContext != 468) {
                        if (authRequestContext != 578) {
                            jsonReader.skipValue();
                        } else if (z) {
                            nearbyConfigResult.nearbyRevamp = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        } else {
                            nearbyConfigResult.nearbyRevamp = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        nearbyConfigResult.trendingKeyword = (List) gson.getAdapter(new access$getFeaturedBankListAdapter$p()).read2(jsonReader);
                    } else {
                        nearbyConfigResult.trendingKeyword = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    nearbyConfigResult.migrateApi = (NearbyMigrateApiResult) gson.getAdapter(NearbyMigrateApiResult.class).read2(jsonReader);
                } else {
                    nearbyConfigResult.migrateApi = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                nearbyConfigResult.reviewCount = (Double) gson.getAdapter(Double.class).read2(jsonReader);
            } else {
                nearbyConfigResult.reviewCount = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return nearbyConfigResult;
    }
}
