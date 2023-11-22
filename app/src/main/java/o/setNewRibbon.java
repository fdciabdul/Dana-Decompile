package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.wallet_v3.model.RecommendationConfigKey;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class setNewRibbon extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public setNewRibbon(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        RecommendationConfigKey recommendationConfigKey = (RecommendationConfigKey) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (recommendationConfigKey != recommendationConfigKey.keys) {
            j.PlaceComponentResult(jsonWriter, 523);
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = new DeserializedCallableMemberDescriptor();
            List<String> list = recommendationConfigKey.keys;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, deserializedCallableMemberDescriptor, list).write(jsonWriter, list);
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
        RecommendationConfigKey recommendationConfigKey = new RecommendationConfigKey();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 585) {
                jsonReader.skipValue();
            } else if (z) {
                recommendationConfigKey.keys = (List) gson.getAdapter(new DeserializedCallableMemberDescriptor()).read2(jsonReader);
            } else {
                recommendationConfigKey.keys = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return recommendationConfigKey;
    }
}
