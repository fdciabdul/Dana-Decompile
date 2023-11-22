package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.DanaHomeBalanceConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class EmergencyNotifActivity$getEmergencyNotifModule$1 extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public EmergencyNotifActivity$getEmergencyNotifModule$1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DanaHomeBalanceConfig danaHomeBalanceConfig = (DanaHomeBalanceConfig) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 561);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(danaHomeBalanceConfig.delayInMillis);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(danaHomeBalanceConfig.enable);
        j.PlaceComponentResult(jsonWriter, 230);
        Class cls2 = Long.TYPE;
        Long valueOf2 = Long.valueOf(danaHomeBalanceConfig.loopUntilInMillis);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls2, valueOf2).write(jsonWriter, valueOf2);
        if (danaHomeBalanceConfig != danaHomeBalanceConfig.services) {
            j.PlaceComponentResult(jsonWriter, 113);
            StandardRowSortedTable$1 standardRowSortedTable$1 = new StandardRowSortedTable$1();
            List<String> list = danaHomeBalanceConfig.services;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, standardRowSortedTable$1, list).write(jsonWriter, list);
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
        DanaHomeBalanceConfig danaHomeBalanceConfig = new DanaHomeBalanceConfig();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 71) {
                if (authRequestContext != 175) {
                    if (authRequestContext != 77) {
                        if (authRequestContext != 78) {
                            jsonReader.skipValue();
                        } else if (z) {
                            danaHomeBalanceConfig.services = (List) gson.getAdapter(new StandardRowSortedTable$1()).read2(jsonReader);
                        } else {
                            danaHomeBalanceConfig.services = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        danaHomeBalanceConfig.delayInMillis = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    danaHomeBalanceConfig.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                danaHomeBalanceConfig.loopUntilInMillis = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return danaHomeBalanceConfig;
    }
}
