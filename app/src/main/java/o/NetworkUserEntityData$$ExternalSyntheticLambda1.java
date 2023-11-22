package o;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class NetworkUserEntityData$$ExternalSyntheticLambda1 extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public NetworkUserEntityData$$ExternalSyntheticLambda1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        ((BaseRpcResult) obj).PlaceComponentResult(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        BaseRpcResult baseRpcResult = new BaseRpcResult();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            baseRpcResult.KClassImpl$Data$declaredNonStaticMembers$2(gson, jsonReader, getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader));
        }
        jsonReader.endObject();
        return baseRpcResult;
    }
}
