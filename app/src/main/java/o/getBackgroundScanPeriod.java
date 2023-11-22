package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class getBackgroundScanPeriod extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;

    public getBackgroundScanPeriod(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        MoneyViewEntity moneyViewEntity = (MoneyViewEntity) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = moneyViewEntity.amount;
        j.PlaceComponentResult(jsonWriter, 78);
        jsonWriter.value(moneyViewEntity.amount);
        String str2 = moneyViewEntity.currency;
        j.PlaceComponentResult(jsonWriter, 525);
        jsonWriter.value(moneyViewEntity.currency);
        String str3 = moneyViewEntity.currencyCode;
        j.PlaceComponentResult(jsonWriter, 542);
        jsonWriter.value(moneyViewEntity.currencyCode);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MoneyViewEntity moneyViewEntity = new MoneyViewEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 327) {
                if (authRequestContext != 391) {
                    if (authRequestContext != 554) {
                        jsonReader.skipValue();
                    } else if (z) {
                        moneyViewEntity.currency = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        moneyViewEntity.currency = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    moneyViewEntity.currencyCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    moneyViewEntity.currencyCode = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                moneyViewEntity.amount = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                moneyViewEntity.amount = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return moneyViewEntity;
    }
}
