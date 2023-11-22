package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.TransactionHistoryConfigEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class flow extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;

    public flow(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TransactionHistoryConfigEntity transactionHistoryConfigEntity = (TransactionHistoryConfigEntity) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = transactionHistoryConfigEntity.url;
        j.PlaceComponentResult(jsonWriter, 320);
        jsonWriter.value(transactionHistoryConfigEntity.url);
        Boolean bool = transactionHistoryConfigEntity.useNewUrl;
        j.PlaceComponentResult(jsonWriter, 188);
        jsonWriter.value(transactionHistoryConfigEntity.useNewUrl);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        TransactionHistoryConfigEntity transactionHistoryConfigEntity = new TransactionHistoryConfigEntity();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 95) {
                if (authRequestContext != 457) {
                    jsonReader.skipValue();
                } else if (z) {
                    transactionHistoryConfigEntity.useNewUrl = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    transactionHistoryConfigEntity.useNewUrl = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                transactionHistoryConfigEntity.url = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                transactionHistoryConfigEntity.url = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return transactionHistoryConfigEntity;
    }
}
