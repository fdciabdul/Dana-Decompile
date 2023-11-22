package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.sendmoney.model.DigitalMoneyResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class longitude extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public longitude(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DigitalMoneyResult digitalMoneyResult = (DigitalMoneyResult) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = digitalMoneyResult.bankName;
        j.PlaceComponentResult(jsonWriter, 38);
        jsonWriter.value(digitalMoneyResult.bankName);
        String str2 = digitalMoneyResult.eWalletName;
        j.PlaceComponentResult(jsonWriter, 269);
        jsonWriter.value(digitalMoneyResult.eWalletName);
        String str3 = digitalMoneyResult.identifier;
        j.PlaceComponentResult(jsonWriter, 187);
        jsonWriter.value(digitalMoneyResult.identifier);
        String str4 = digitalMoneyResult.instId;
        j.PlaceComponentResult(jsonWriter, 332);
        jsonWriter.value(digitalMoneyResult.instId);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DigitalMoneyResult digitalMoneyResult = new DigitalMoneyResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 255) {
                if (authRequestContext != 294) {
                    if (authRequestContext != 311) {
                        if (authRequestContext != 600) {
                            jsonReader.skipValue();
                        } else if (z) {
                            digitalMoneyResult.bankName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            digitalMoneyResult.bankName = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        digitalMoneyResult.identifier = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        digitalMoneyResult.identifier = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    digitalMoneyResult.eWalletName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    digitalMoneyResult.eWalletName = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                digitalMoneyResult.instId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                digitalMoneyResult.instId = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return digitalMoneyResult;
    }
}
