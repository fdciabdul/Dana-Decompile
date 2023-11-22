package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.PromoAdsLocationConfigResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 241);
        jsonWriter.value(Integer.valueOf(((PromoAdsLocationConfigResponse) obj).minimumRadiusInMeter));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        PromoAdsLocationConfigResponse promoAdsLocationConfigResponse = new PromoAdsLocationConfigResponse();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 266) {
                jsonReader.skipValue();
            } else if (z) {
                try {
                    promoAdsLocationConfigResponse.minimumRadiusInMeter = jsonReader.nextInt();
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return promoAdsLocationConfigResponse;
    }
}
