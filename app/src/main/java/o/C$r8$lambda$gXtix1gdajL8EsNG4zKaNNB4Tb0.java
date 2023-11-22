package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.danah5.mixpanel.model.JSApiWhitelistModel;
import java.io.IOException;
import java.util.List;

/* renamed from: o.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0  reason: invalid class name */
/* loaded from: classes4.dex */
public final class C$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public C$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        JSApiWhitelistModel jSApiWhitelistModel = (JSApiWhitelistModel) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (jSApiWhitelistModel != jSApiWhitelistModel.appIds) {
            j.PlaceComponentResult(jsonWriter, 219);
            DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl daggerEmergencyNotifComponent$EmergencyNotifComponentImpl = new DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl();
            List<String> list = jSApiWhitelistModel.appIds;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, daggerEmergencyNotifComponent$EmergencyNotifComponentImpl, list).write(jsonWriter, list);
        }
        if (jSApiWhitelistModel != jSApiWhitelistModel.serviceKeys) {
            j.PlaceComponentResult(jsonWriter, 152);
            getGnBenefitEntityDanaProtection getgnbenefitentitydanaprotection = new getGnBenefitEntityDanaProtection();
            List<String> list2 = jSApiWhitelistModel.serviceKeys;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getgnbenefitentitydanaprotection, list2).write(jsonWriter, list2);
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
        JSApiWhitelistModel jSApiWhitelistModel = new JSApiWhitelistModel();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 51) {
                if (authRequestContext != 131) {
                    jsonReader.skipValue();
                } else if (z) {
                    jSApiWhitelistModel.serviceKeys = (List) gson.getAdapter(new getGnBenefitEntityDanaProtection()).read2(jsonReader);
                } else {
                    jSApiWhitelistModel.serviceKeys = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                jSApiWhitelistModel.appIds = (List) gson.getAdapter(new DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl()).read2(jsonReader);
            } else {
                jSApiWhitelistModel.appIds = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return jSApiWhitelistModel;
    }
}
