package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class BarcodeUtil$$ExternalSyntheticLambda1 extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public BarcodeUtil$$ExternalSyntheticLambda1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        QueryCredentialInfoResult queryCredentialInfoResult = (QueryCredentialInfoResult) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 355);
        jsonWriter.value(queryCredentialInfoResult.passwordLastModifiedCheck);
        j.PlaceComponentResult(jsonWriter, 55);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(queryCredentialInfoResult.passwordLastModifiedInEpoch);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        queryCredentialInfoResult.PlaceComponentResult(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        QueryCredentialInfoResult queryCredentialInfoResult = new QueryCredentialInfoResult();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 277) {
                if (authRequestContext != 321) {
                    queryCredentialInfoResult.KClassImpl$Data$declaredNonStaticMembers$2(gson, jsonReader, authRequestContext);
                } else if (z) {
                    queryCredentialInfoResult.passwordLastModifiedInEpoch = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                queryCredentialInfoResult.passwordLastModifiedCheck = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return queryCredentialInfoResult;
    }
}
