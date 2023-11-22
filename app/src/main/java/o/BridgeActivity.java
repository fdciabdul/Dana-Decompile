package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class BridgeActivity extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public BridgeActivity(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ServiceHighlighted serviceHighlighted = (ServiceHighlighted) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 453);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(serviceHighlighted.createdAt);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        Integer num = serviceHighlighted.index;
        j.PlaceComponentResult(jsonWriter, 546);
        Integer num2 = serviceHighlighted.index;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        String str = serviceHighlighted.key;
        j.PlaceComponentResult(jsonWriter, 318);
        jsonWriter.value(serviceHighlighted.key);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ServiceHighlighted serviceHighlighted = new ServiceHighlighted();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 72) {
                if (authRequestContext != 355) {
                    if (authRequestContext != 488) {
                        jsonReader.skipValue();
                    } else if (z) {
                        serviceHighlighted.createdAt = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    serviceHighlighted.index = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                } else {
                    serviceHighlighted.index = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                serviceHighlighted.key = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                serviceHighlighted.key = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return serviceHighlighted;
    }
}
