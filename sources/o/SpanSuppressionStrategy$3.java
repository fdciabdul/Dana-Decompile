package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.rpc.response.BaseNetworkRpcResponse;
import id.dana.utils.rpc.response.DefaultResponse;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class SpanSuppressionStrategy$3 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public SpanSuppressionStrategy$3(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        BaseNetworkRpcResponse baseNetworkRpcResponse = (BaseNetworkRpcResponse) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (baseNetworkRpcResponse != baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory) {
            j.PlaceComponentResult(jsonWriter, 3);
            DefaultResponse defaultResponse = baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, DefaultResponse.class, defaultResponse).write(jsonWriter, defaultResponse);
        }
        if (baseNetworkRpcResponse != baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2) {
            j.PlaceComponentResult(jsonWriter, 571);
            Integer num = baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num).write(jsonWriter, num);
        }
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        BaseNetworkRpcResponse baseNetworkRpcResponse = new BaseNetworkRpcResponse();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 1) {
                if (authRequestContext != 161) {
                    jsonReader.skipValue();
                } else if (z) {
                    baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory = (DefaultResponse) gson.getAdapter(DefaultResponse.class).read2(jsonReader);
                } else {
                    baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2 = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return baseNetworkRpcResponse;
    }
}
