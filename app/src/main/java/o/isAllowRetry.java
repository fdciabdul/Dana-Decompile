package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.MarmotConfigResponse;
import id.dana.data.config.model.MarmotDanaPromotionResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class isAllowRetry extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public isAllowRetry(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MarmotConfigResponse marmotConfigResponse = (MarmotConfigResponse) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        MarmotDanaPromotionResponse marmotDanaPromotionResponse = marmotConfigResponse.danaPromotion;
        j.PlaceComponentResult(jsonWriter, 170);
        MarmotDanaPromotionResponse marmotDanaPromotionResponse2 = marmotConfigResponse.danaPromotion;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, MarmotDanaPromotionResponse.class, marmotDanaPromotionResponse2).write(jsonWriter, marmotDanaPromotionResponse2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MarmotConfigResponse marmotConfigResponse = new MarmotConfigResponse();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 570) {
                jsonReader.skipValue();
            } else if (z) {
                marmotConfigResponse.danaPromotion = (MarmotDanaPromotionResponse) gson.getAdapter(MarmotDanaPromotionResponse.class).read2(jsonReader);
            } else {
                marmotConfigResponse.danaPromotion = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return marmotConfigResponse;
    }
}
