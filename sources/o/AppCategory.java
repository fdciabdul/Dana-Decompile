package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.QrisTciCoConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class AppCategory extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public AppCategory(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        QrisTciCoConfigResult qrisTciCoConfigResult = (QrisTciCoConfigResult) obj;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        Boolean bool = qrisTciCoConfigResult.profile;
        j.PlaceComponentResult(jsonWriter, 352);
        jsonWriter.value(qrisTciCoConfigResult.profile);
        Boolean bool2 = qrisTciCoConfigResult.requestMoney;
        j.PlaceComponentResult(jsonWriter, 510);
        jsonWriter.value(qrisTciCoConfigResult.requestMoney);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        QrisTciCoConfigResult qrisTciCoConfigResult = new QrisTciCoConfigResult();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 157) {
                if (authRequestContext != 577) {
                    jsonReader.skipValue();
                } else if (z) {
                    qrisTciCoConfigResult.profile = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    qrisTciCoConfigResult.profile = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                qrisTciCoConfigResult.requestMoney = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
            } else {
                qrisTciCoConfigResult.requestMoney = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return qrisTciCoConfigResult;
    }
}
