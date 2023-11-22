package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.rpc.response.DefaultResponse;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class sipHash24 extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public sipHash24(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            ((DefaultResponse) obj).getAuthRequestContext(jsonWriter, this.PlaceComponentResult);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, jsonReader, this.getAuthRequestContext);
        return defaultResponse;
    }
}
