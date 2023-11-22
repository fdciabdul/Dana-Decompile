package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.danah5.model.H5ShareData;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setBackgroundTime extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public setBackgroundTime(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        H5ShareData h5ShareData = (H5ShareData) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String[] strArr = h5ShareData.userId;
        j.PlaceComponentResult(jsonWriter, 154);
        String[] strArr2 = h5ShareData.userId;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, String[].class, strArr2).write(jsonWriter, strArr2);
        String[] strArr3 = h5ShareData.utdId;
        j.PlaceComponentResult(jsonWriter, 53);
        String[] strArr4 = h5ShareData.utdId;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, String[].class, strArr4).write(jsonWriter, strArr4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        H5ShareData h5ShareData = new H5ShareData();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 304) {
                if (authRequestContext != 476) {
                    jsonReader.skipValue();
                } else if (z) {
                    h5ShareData.utdId = (String[]) gson.getAdapter(String[].class).read2(jsonReader);
                } else {
                    h5ShareData.utdId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                h5ShareData.userId = (String[]) gson.getAdapter(String[].class).read2(jsonReader);
            } else {
                h5ShareData.userId = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return h5ShareData;
    }
}
