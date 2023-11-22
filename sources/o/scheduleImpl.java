package o;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class scheduleImpl extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;

    public scheduleImpl(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        ((MobileEnvInfo) obj).BuiltInFictitiousFunctionClassFactory(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MobileEnvInfo mobileEnvInfo = new MobileEnvInfo();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            mobileEnvInfo.KClassImpl$Data$declaredNonStaticMembers$2(gson, jsonReader, getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader));
        }
        jsonReader.endObject();
        return mobileEnvInfo;
    }
}
