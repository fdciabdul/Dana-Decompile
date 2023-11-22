package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.devicestats.model.DeviceStatsConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class indexOfAny extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;
    private J getAuthRequestContext;

    public indexOfAny(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DeviceStatsConfig deviceStatsConfig = (DeviceStatsConfig) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        Integer num = deviceStatsConfig.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE);
        Integer num2 = deviceStatsConfig.getAuthRequestContext;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        Boolean bool = deviceStatsConfig.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 498);
        jsonWriter.value(deviceStatsConfig.MyBillsEntityDataFactory);
        Boolean bool2 = deviceStatsConfig.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(deviceStatsConfig.KClassImpl$Data$declaredNonStaticMembers$2);
        Integer num3 = deviceStatsConfig.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 77);
        Integer num4 = deviceStatsConfig.PlaceComponentResult;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DeviceStatsConfig deviceStatsConfig = new DeviceStatsConfig();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 66) {
                if (authRequestContext != 93) {
                    if (authRequestContext != 175) {
                        if (authRequestContext != 248) {
                            jsonReader.skipValue();
                        } else if (z) {
                            deviceStatsConfig.MyBillsEntityDataFactory = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        } else {
                            deviceStatsConfig.MyBillsEntityDataFactory = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        deviceStatsConfig.KClassImpl$Data$declaredNonStaticMembers$2 = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                    } else {
                        deviceStatsConfig.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    deviceStatsConfig.getAuthRequestContext = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                } else {
                    deviceStatsConfig.getAuthRequestContext = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                deviceStatsConfig.PlaceComponentResult = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                deviceStatsConfig.PlaceComponentResult = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return deviceStatsConfig;
    }
}
