package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.AnbuConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ItemSnapshotList extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public ItemSnapshotList(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        AnbuConfig anbuConfig = (AnbuConfig) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        Boolean bool = anbuConfig.featureWarmHomeDialog;
        j.PlaceComponentResult(jsonWriter, 224);
        jsonWriter.value(anbuConfig.featureWarmHomeDialog);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        AnbuConfig anbuConfig = new AnbuConfig();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 268) {
                jsonReader.skipValue();
            } else if (z) {
                anbuConfig.featureWarmHomeDialog = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
            } else {
                anbuConfig.featureWarmHomeDialog = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return anbuConfig;
    }
}
