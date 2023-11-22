package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.holdlogin.v2.model.HoldLoginErrorCodesEntity;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class readBoolean extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public readBoolean(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        HoldLoginErrorCodesEntity holdLoginErrorCodesEntity = (HoldLoginErrorCodesEntity) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (holdLoginErrorCodesEntity != holdLoginErrorCodesEntity.getAuthRequestContext) {
            j.PlaceComponentResult(jsonWriter, 442);
            SpanSuppressionStrategy$1 spanSuppressionStrategy$1 = new SpanSuppressionStrategy$1();
            List<String> list = holdLoginErrorCodesEntity.getAuthRequestContext;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, spanSuppressionStrategy$1, list).write(jsonWriter, list);
        }
        if (holdLoginErrorCodesEntity != holdLoginErrorCodesEntity.MyBillsEntityDataFactory) {
            j.PlaceComponentResult(jsonWriter, 579);
            SpanSuppressionStrategy$2 spanSuppressionStrategy$2 = new SpanSuppressionStrategy$2();
            List<String> list2 = holdLoginErrorCodesEntity.MyBillsEntityDataFactory;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, spanSuppressionStrategy$2, list2).write(jsonWriter, list2);
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
        HoldLoginErrorCodesEntity holdLoginErrorCodesEntity = new HoldLoginErrorCodesEntity();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 417) {
                if (authRequestContext != 556) {
                    jsonReader.skipValue();
                } else if (z) {
                    holdLoginErrorCodesEntity.getAuthRequestContext = (List) gson.getAdapter(new SpanSuppressionStrategy$1()).read2(jsonReader);
                } else {
                    holdLoginErrorCodesEntity.getAuthRequestContext = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                holdLoginErrorCodesEntity.MyBillsEntityDataFactory = (List) gson.getAdapter(new SpanSuppressionStrategy$2()).read2(jsonReader);
            } else {
                holdLoginErrorCodesEntity.MyBillsEntityDataFactory = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return holdLoginErrorCodesEntity;
    }
}
