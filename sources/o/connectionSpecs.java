package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.BannerConfigResult;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes4.dex */
public final class connectionSpecs extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public connectionSpecs(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        BannerConfigResult bannerConfigResult = (BannerConfigResult) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (bannerConfigResult != bannerConfigResult.bannerManagementEnable) {
            j.PlaceComponentResult(jsonWriter, 181);
            C$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8 c$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8 = new C$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8();
            Map<String, Boolean> map = bannerConfigResult.bannerManagementEnable;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, c$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8, map).write(jsonWriter, map);
        }
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        BannerConfigResult bannerConfigResult = new BannerConfigResult();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 2) {
                jsonReader.skipValue();
            } else if (z) {
                bannerConfigResult.bannerManagementEnable = (Map) gson.getAdapter(new C$r8$lambda$zXHmsujXTx99vyZ6bMhXqP1wKc8()).read2(jsonReader);
            } else {
                bannerConfigResult.bannerManagementEnable = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return bannerConfigResult;
    }
}
