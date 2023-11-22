package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.mybills.ui.model.MoneyViewModel;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class QuickBuyBillsAdapter$onQuickBuyItemClickListener$1 extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public QuickBuyBillsAdapter$onQuickBuyItemClickListener$1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MoneyViewModel moneyViewModel = (MoneyViewModel) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = moneyViewModel.amount;
        j.PlaceComponentResult(jsonWriter, 78);
        jsonWriter.value(moneyViewModel.amount);
        String str2 = moneyViewModel.currency;
        j.PlaceComponentResult(jsonWriter, 525);
        jsonWriter.value(moneyViewModel.currency);
        String str3 = moneyViewModel.currencyCode;
        j.PlaceComponentResult(jsonWriter, 542);
        jsonWriter.value(moneyViewModel.currencyCode);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MoneyViewModel moneyViewModel = new MoneyViewModel();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 327) {
                if (authRequestContext != 391) {
                    if (authRequestContext != 554) {
                        jsonReader.skipValue();
                    } else if (z) {
                        moneyViewModel.currency = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        moneyViewModel.currency = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    moneyViewModel.currencyCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    moneyViewModel.currencyCode = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                moneyViewModel.amount = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                moneyViewModel.amount = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return moneyViewModel;
    }
}
