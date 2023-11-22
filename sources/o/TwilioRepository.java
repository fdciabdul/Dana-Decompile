package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.CashierMerchantWhitelistConfigResult;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class TwilioRepository extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public TwilioRepository(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult = (CashierMerchantWhitelistConfigResult) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (cashierMerchantWhitelistConfigResult != cashierMerchantWhitelistConfigResult.mids) {
            j.PlaceComponentResult(jsonWriter, 535);
            fromContextOrNull fromcontextornull = new fromContextOrNull();
            List<String> list = cashierMerchantWhitelistConfigResult.mids;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, fromcontextornull, list).write(jsonWriter, list);
        }
        String str = cashierMerchantWhitelistConfigResult.mode;
        j.PlaceComponentResult(jsonWriter, 397);
        jsonWriter.value(cashierMerchantWhitelistConfigResult.mode);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult = new CashierMerchantWhitelistConfigResult();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 53) {
                if (authRequestContext != 500) {
                    jsonReader.skipValue();
                } else if (z) {
                    cashierMerchantWhitelistConfigResult.mids = (List) gson.getAdapter(new fromContextOrNull()).read2(jsonReader);
                } else {
                    cashierMerchantWhitelistConfigResult.mids = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                cashierMerchantWhitelistConfigResult.mode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                cashierMerchantWhitelistConfigResult.mode = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return cashierMerchantWhitelistConfigResult;
    }
}
