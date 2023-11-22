package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.danah5.mixpanel.model.JSApiRuleModel;
import id.dana.danah5.mixpanel.model.JSApiWhitelistModel;
import java.io.IOException;

/* renamed from: o.$r8$lambda$Z7cCkiMOp-RjsRTg6ix8npYCD-M  reason: invalid class name */
/* loaded from: classes4.dex */
public final class C$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public C$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        JSApiRuleModel jSApiRuleModel = (JSApiRuleModel) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 434);
        jsonWriter.value(jSApiRuleModel.enabled);
        JSApiWhitelistModel jSApiWhitelistModel = jSApiRuleModel.whitelist;
        j.PlaceComponentResult(jsonWriter, 480);
        JSApiWhitelistModel jSApiWhitelistModel2 = jSApiRuleModel.whitelist;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, JSApiWhitelistModel.class, jSApiWhitelistModel2).write(jsonWriter, jSApiWhitelistModel2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        JSApiRuleModel jSApiRuleModel = new JSApiRuleModel();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 102) {
                if (authRequestContext != 322) {
                    jsonReader.skipValue();
                } else if (z) {
                    jSApiRuleModel.whitelist = (JSApiWhitelistModel) gson.getAdapter(JSApiWhitelistModel.class).read2(jsonReader);
                } else {
                    jSApiRuleModel.whitelist = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                jSApiRuleModel.enabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return jSApiRuleModel;
    }
}
