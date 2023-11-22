package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.NetworkLoggingConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class RoundedCornerTreatment extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public RoundedCornerTreatment(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        NetworkLoggingConfig networkLoggingConfig = (NetworkLoggingConfig) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(networkLoggingConfig.KClassImpl$Data$declaredNonStaticMembers$2);
        if (networkLoggingConfig != networkLoggingConfig.getAuthRequestContext) {
            j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_APP);
            setPluginState setpluginstate = new setPluginState();
            List<String> list = networkLoggingConfig.getAuthRequestContext;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, setpluginstate, list).write(jsonWriter, list);
        }
        Long l = networkLoggingConfig.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 98);
        Long l2 = networkLoggingConfig.PlaceComponentResult;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Long.class, l2).write(jsonWriter, l2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        NetworkLoggingConfig networkLoggingConfig = new NetworkLoggingConfig();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 92) {
                if (authRequestContext != 175) {
                    if (authRequestContext != 534) {
                        jsonReader.skipValue();
                    } else if (z) {
                        networkLoggingConfig.getAuthRequestContext = (List) gson.getAdapter(new setPluginState()).read2(jsonReader);
                    } else {
                        networkLoggingConfig.getAuthRequestContext = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    networkLoggingConfig.KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                networkLoggingConfig.PlaceComponentResult = (Long) gson.getAdapter(Long.class).read2(jsonReader);
            } else {
                networkLoggingConfig.PlaceComponentResult = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return networkLoggingConfig;
    }
}
