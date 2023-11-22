package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.cashier.data.repository.source.network.result.CashierCurrencyFromCdnResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setValuePrefixBytes extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public setValuePrefixBytes(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        CashierCurrencyFromCdnResult cashierCurrencyFromCdnResult = (CashierCurrencyFromCdnResult) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = cashierCurrencyFromCdnResult.countryName;
        j.PlaceComponentResult(jsonWriter, 202);
        jsonWriter.value(cashierCurrencyFromCdnResult.countryName);
        String str2 = cashierCurrencyFromCdnResult.currencyCode;
        j.PlaceComponentResult(jsonWriter, 542);
        jsonWriter.value(cashierCurrencyFromCdnResult.currencyCode);
        String str3 = cashierCurrencyFromCdnResult.currencyLabel;
        j.PlaceComponentResult(jsonWriter, 540);
        jsonWriter.value(cashierCurrencyFromCdnResult.currencyLabel);
        String str4 = cashierCurrencyFromCdnResult.currencySymbol;
        j.PlaceComponentResult(jsonWriter, 558);
        jsonWriter.value(cashierCurrencyFromCdnResult.currencySymbol);
        String str5 = cashierCurrencyFromCdnResult.currencySymbolString;
        j.PlaceComponentResult(jsonWriter, 134);
        jsonWriter.value(cashierCurrencyFromCdnResult.currencySymbolString);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CashierCurrencyFromCdnResult cashierCurrencyFromCdnResult = new CashierCurrencyFromCdnResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 98) {
                if (authRequestContext != 123) {
                    if (authRequestContext != 127) {
                        if (authRequestContext != 391) {
                            if (authRequestContext != 445) {
                                jsonReader.skipValue();
                            } else if (z) {
                                cashierCurrencyFromCdnResult.countryName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                cashierCurrencyFromCdnResult.countryName = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            cashierCurrencyFromCdnResult.currencyCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            cashierCurrencyFromCdnResult.currencyCode = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        cashierCurrencyFromCdnResult.currencySymbolString = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        cashierCurrencyFromCdnResult.currencySymbolString = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    cashierCurrencyFromCdnResult.currencySymbol = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    cashierCurrencyFromCdnResult.currencySymbol = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                cashierCurrencyFromCdnResult.currencyLabel = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                cashierCurrencyFromCdnResult.currencyLabel = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return cashierCurrencyFromCdnResult;
    }
}
