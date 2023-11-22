package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Gps;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class AbstractMapBasedMultimap$AsMap extends TypeAdapter implements G {
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public AbstractMapBasedMultimap$AsMap(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Gps gps = (Gps) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 378);
        jsonWriter.value(Integer.valueOf(gps.KClassImpl$Data$declaredNonStaticMembers$2));
        String str = gps.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 503);
        jsonWriter.value(gps.BuiltInFictitiousFunctionClassFactory);
        String str2 = gps.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, 583);
        jsonWriter.value(gps.getAuthRequestContext);
        j.PlaceComponentResult(jsonWriter, 106);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(gps.PlaceComponentResult);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Gps gps = new Gps();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 163) {
                if (authRequestContext != 253) {
                    if (authRequestContext != 412) {
                        if (authRequestContext != 576) {
                            jsonReader.skipValue();
                        } else if (z) {
                            gps.PlaceComponentResult = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        gps.BuiltInFictitiousFunctionClassFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        gps.BuiltInFictitiousFunctionClassFactory = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    gps.getAuthRequestContext = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    gps.getAuthRequestContext = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    gps.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.nextInt();
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return gps;
    }
}
