package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.globalnetwork.source.mock.MockGlobalNetworkEntityData$$ExternalSyntheticLambda0;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ViewInputOtpBinding extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public ViewInputOtpBinding(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MockGlobalNetworkEntityData$$ExternalSyntheticLambda0 mockGlobalNetworkEntityData$$ExternalSyntheticLambda0 = (MockGlobalNetworkEntityData$$ExternalSyntheticLambda0) obj;
        jsonWriter.beginObject();
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MockGlobalNetworkEntityData$$ExternalSyntheticLambda0 mockGlobalNetworkEntityData$$ExternalSyntheticLambda0 = new MockGlobalNetworkEntityData$$ExternalSyntheticLambda0();
        MockGlobalNetworkEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(jsonReader, this.getAuthRequestContext);
        return mockGlobalNetworkEntityData$$ExternalSyntheticLambda0;
    }
}
