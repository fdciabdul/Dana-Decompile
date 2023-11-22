package id.dana.utils.rpc.response;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import o.J;
import o.getValueOfTouchPositionAbsolute;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/utils/rpc/response/DefaultResponse;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultResponse extends BaseRpcResponse {
    public final /* synthetic */ void getAuthRequestContext(JsonWriter jsonWriter, J j) {
        jsonWriter.beginObject();
        MyBillsEntityDataFactory(jsonWriter, j);
        jsonWriter.endObject();
    }

    public final /* synthetic */ void PlaceComponentResult(Gson gson, JsonReader jsonReader, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            PlaceComponentResult(gson, jsonReader, getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader));
        }
        jsonReader.endObject();
    }
}
