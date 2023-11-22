package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.MerchantCategoryContentResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class SplitReferralConfigEntityData_Factory extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public SplitReferralConfigEntityData_Factory(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MerchantCategoryContentResult merchantCategoryContentResult = (MerchantCategoryContentResult) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = merchantCategoryContentResult.url;
        j.PlaceComponentResult(jsonWriter, 320);
        jsonWriter.value(merchantCategoryContentResult.url);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MerchantCategoryContentResult merchantCategoryContentResult = new MerchantCategoryContentResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 95) {
                jsonReader.skipValue();
            } else if (z) {
                merchantCategoryContentResult.url = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                merchantCategoryContentResult.url = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return merchantCategoryContentResult;
    }
}
