package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.saving.model.MainEmptyStateEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class SourceParamUtil$DanaKagetClaimSource extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson PlaceComponentResult;
    private J getAuthRequestContext;

    public SourceParamUtil$DanaKagetClaimSource(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MainEmptyStateEntity mainEmptyStateEntity = (MainEmptyStateEntity) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = mainEmptyStateEntity.icon;
        j.PlaceComponentResult(jsonWriter, 418);
        jsonWriter.value(mainEmptyStateEntity.icon);
        String str2 = mainEmptyStateEntity.subtitle;
        j.PlaceComponentResult(jsonWriter, 347);
        jsonWriter.value(mainEmptyStateEntity.subtitle);
        String str3 = mainEmptyStateEntity.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(mainEmptyStateEntity.title);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MainEmptyStateEntity mainEmptyStateEntity = new MainEmptyStateEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 518) {
                    if (authRequestContext != 524) {
                        jsonReader.skipValue();
                    } else if (z) {
                        mainEmptyStateEntity.icon = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        mainEmptyStateEntity.icon = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    mainEmptyStateEntity.subtitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    mainEmptyStateEntity.subtitle = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                mainEmptyStateEntity.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                mainEmptyStateEntity.title = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return mainEmptyStateEntity;
    }
}
