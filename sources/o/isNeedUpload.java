package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class isNeedUpload extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public isNeedUpload(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ExplorePromoConfigResponse explorePromoConfigResponse = (ExplorePromoConfigResponse) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        Integer num = explorePromoConfigResponse.promoBannerLimit;
        j.PlaceComponentResult(jsonWriter, 373);
        Integer num2 = explorePromoConfigResponse.promoBannerLimit;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ExplorePromoConfigResponse explorePromoConfigResponse = new ExplorePromoConfigResponse();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 21) {
                jsonReader.skipValue();
            } else if (z) {
                explorePromoConfigResponse.promoBannerLimit = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                explorePromoConfigResponse.promoBannerLimit = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return explorePromoConfigResponse;
    }
}
