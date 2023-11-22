package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setAmountToSent extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public setAmountToSent(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        WalletConfig walletConfig = (WalletConfig) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 593);
        jsonWriter.value(walletConfig.featureWalletNew);
        WalletV3Config walletV3Config = walletConfig.walletV3;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN);
        WalletV3Config walletV3Config2 = walletConfig.walletV3;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, WalletV3Config.class, walletV3Config2).write(jsonWriter, walletV3Config2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        WalletConfig walletConfig = new WalletConfig();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 48) {
                if (authRequestContext != 345) {
                    jsonReader.skipValue();
                } else if (z) {
                    walletConfig.featureWalletNew = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                walletConfig.walletV3 = (WalletV3Config) gson.getAdapter(WalletV3Config.class).read2(jsonReader);
            } else {
                walletConfig.walletV3 = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return walletConfig;
    }
}
