package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.promodiscovery.repository.source.split.model.PromoCenterVersionResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class VerifyPasswordFacade extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;
    private J getAuthRequestContext;

    public VerifyPasswordFacade(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 457);
        jsonWriter.value(Integer.valueOf(((PromoCenterVersionResult) obj).version));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        PromoCenterVersionResult promoCenterVersionResult = new PromoCenterVersionResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 494) {
                jsonReader.skipValue();
            } else if (z) {
                try {
                    promoCenterVersionResult.version = jsonReader.nextInt();
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return promoCenterVersionResult;
    }
}
