package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.geocode.model.GeocodeReverseConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class KeyEvent$DispatcherState extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public KeyEvent$DispatcherState(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        GeocodeReverseConfigResult geocodeReverseConfigResult = (GeocodeReverseConfigResult) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = geocodeReverseConfigResult.distanceInMeters;
        j.PlaceComponentResult(jsonWriter, 207);
        jsonWriter.value(geocodeReverseConfigResult.distanceInMeters);
        j.PlaceComponentResult(jsonWriter, 545);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(geocodeReverseConfigResult.intervalInHours);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, 41);
        jsonWriter.value(geocodeReverseConfigResult.shouldCallHEREGeocodeAPI);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        GeocodeReverseConfigResult geocodeReverseConfigResult = new GeocodeReverseConfigResult();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 170) {
                if (authRequestContext != 449) {
                    if (authRequestContext != 490) {
                        jsonReader.skipValue();
                    } else if (z) {
                        geocodeReverseConfigResult.shouldCallHEREGeocodeAPI = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    geocodeReverseConfigResult.distanceInMeters = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    geocodeReverseConfigResult.distanceInMeters = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                geocodeReverseConfigResult.intervalInHours = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return geocodeReverseConfigResult;
    }
}
