package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setValue extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public setValue(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        NearbyAutoSearchConfig nearbyAutoSearchConfig = (NearbyAutoSearchConfig) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 434);
        jsonWriter.value(nearbyAutoSearchConfig.enabled);
        j.PlaceComponentResult(jsonWriter, 74);
        jsonWriter.value(Integer.valueOf(nearbyAutoSearchConfig.interval));
        j.PlaceComponentResult(jsonWriter, 495);
        jsonWriter.value(Integer.valueOf(nearbyAutoSearchConfig.threshold));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        NearbyAutoSearchConfig nearbyAutoSearchConfig = new NearbyAutoSearchConfig();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 102) {
                if (authRequestContext != 220) {
                    if (authRequestContext != 287) {
                        jsonReader.skipValue();
                    } else if (z) {
                        try {
                            nearbyAutoSearchConfig.interval = jsonReader.nextInt();
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        nearbyAutoSearchConfig.threshold = jsonReader.nextInt();
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                nearbyAutoSearchConfig.enabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return nearbyAutoSearchConfig;
    }
}
