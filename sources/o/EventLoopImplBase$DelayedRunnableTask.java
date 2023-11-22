package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class EventLoopImplBase$DelayedRunnableTask extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public EventLoopImplBase$DelayedRunnableTask(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig = (CashierMerchantWhitelistConfig) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        if (cashierMerchantWhitelistConfig != cashierMerchantWhitelistConfig.mids) {
            j.PlaceComponentResult(jsonWriter, 535);
            PromoExploreModule_ProvidesPresenterFactory promoExploreModule_ProvidesPresenterFactory = new PromoExploreModule_ProvidesPresenterFactory();
            List<String> list = cashierMerchantWhitelistConfig.mids;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, promoExploreModule_ProvidesPresenterFactory, list).write(jsonWriter, list);
        }
        String str = cashierMerchantWhitelistConfig.mode;
        j.PlaceComponentResult(jsonWriter, 397);
        jsonWriter.value(cashierMerchantWhitelistConfig.mode);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig = new CashierMerchantWhitelistConfig();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 53) {
                if (authRequestContext != 500) {
                    jsonReader.skipValue();
                } else if (z) {
                    cashierMerchantWhitelistConfig.mids = (List) gson.getAdapter(new PromoExploreModule_ProvidesPresenterFactory()).read2(jsonReader);
                } else {
                    cashierMerchantWhitelistConfig.mids = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                cashierMerchantWhitelistConfig.mode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                cashierMerchantWhitelistConfig.mode = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return cashierMerchantWhitelistConfig;
    }
}
