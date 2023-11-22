package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.explore.data.globalsearch.model.GlobalSearchWidgetResponse;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class getOnCreateTime extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getOnCreateTime(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        GlobalSearchWidgetResponse globalSearchWidgetResponse = (GlobalSearchWidgetResponse) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = globalSearchWidgetResponse.name;
        j.PlaceComponentResult(jsonWriter, 552);
        jsonWriter.value(globalSearchWidgetResponse.name);
        Integer num = globalSearchWidgetResponse.orderId;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP);
        Integer num2 = globalSearchWidgetResponse.orderId;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        GlobalSearchWidgetResponse globalSearchWidgetResponse = new GlobalSearchWidgetResponse();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 224) {
                if (authRequestContext != 474) {
                    jsonReader.skipValue();
                } else if (z) {
                    globalSearchWidgetResponse.name = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    globalSearchWidgetResponse.name = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                globalSearchWidgetResponse.orderId = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                globalSearchWidgetResponse.orderId = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return globalSearchWidgetResponse;
    }
}
