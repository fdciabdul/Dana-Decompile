package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.wallet_v3.model.WalletV3AddAssetServices;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class PopupModel extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public PopupModel(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        WalletV3AddAssetServices walletV3AddAssetServices = (WalletV3AddAssetServices) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        if (walletV3AddAssetServices != walletV3AddAssetServices.services) {
            j.PlaceComponentResult(jsonWriter, 113);
            MyBillsFacade myBillsFacade = new MyBillsFacade();
            List<String> list = walletV3AddAssetServices.services;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, myBillsFacade, list).write(jsonWriter, list);
        }
        String str = walletV3AddAssetServices.titleEn;
        j.PlaceComponentResult(jsonWriter, 112);
        jsonWriter.value(walletV3AddAssetServices.titleEn);
        String str2 = walletV3AddAssetServices.titleId;
        j.PlaceComponentResult(jsonWriter, 17);
        jsonWriter.value(walletV3AddAssetServices.titleId);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        WalletV3AddAssetServices walletV3AddAssetServices = new WalletV3AddAssetServices();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 59) {
                if (authRequestContext != 78) {
                    if (authRequestContext != 154) {
                        jsonReader.skipValue();
                    } else if (z) {
                        walletV3AddAssetServices.titleId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        walletV3AddAssetServices.titleId = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    walletV3AddAssetServices.services = (List) gson.getAdapter(new MyBillsFacade()).read2(jsonReader);
                } else {
                    walletV3AddAssetServices.services = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                walletV3AddAssetServices.titleEn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                walletV3AddAssetServices.titleEn = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return walletV3AddAssetServices;
    }
}
