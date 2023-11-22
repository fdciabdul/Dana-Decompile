package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.biometric.data.source.local.RiskTrackerConfigEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class MultiLanguageHttpClient extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public MultiLanguageHttpClient(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        RiskTrackerConfigEntity riskTrackerConfigEntity = (RiskTrackerConfigEntity) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        Boolean bool = riskTrackerConfigEntity.accelerometerDataTracker;
        j.PlaceComponentResult(jsonWriter, 432);
        jsonWriter.value(riskTrackerConfigEntity.accelerometerDataTracker);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(riskTrackerConfigEntity.enable);
        Boolean bool2 = riskTrackerConfigEntity.gyroscopeDataTracker;
        j.PlaceComponentResult(jsonWriter, 411);
        jsonWriter.value(riskTrackerConfigEntity.gyroscopeDataTracker);
        Boolean bool3 = riskTrackerConfigEntity.keystrokeDataTracker;
        j.PlaceComponentResult(jsonWriter, 481);
        jsonWriter.value(riskTrackerConfigEntity.keystrokeDataTracker);
        Integer num = riskTrackerConfigEntity.maxRequestLimitInHour;
        j.PlaceComponentResult(jsonWriter, 596);
        Integer num2 = riskTrackerConfigEntity.maxRequestLimitInHour;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        RiskTrackerConfigEntity riskTrackerConfigEntity = new RiskTrackerConfigEntity();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 175) {
                if (authRequestContext != 292) {
                    if (authRequestContext != 330) {
                        if (authRequestContext != 351) {
                            if (authRequestContext != 569) {
                                jsonReader.skipValue();
                            } else if (z) {
                                riskTrackerConfigEntity.maxRequestLimitInHour = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                            } else {
                                riskTrackerConfigEntity.maxRequestLimitInHour = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            riskTrackerConfigEntity.gyroscopeDataTracker = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        } else {
                            riskTrackerConfigEntity.gyroscopeDataTracker = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        riskTrackerConfigEntity.accelerometerDataTracker = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                    } else {
                        riskTrackerConfigEntity.accelerometerDataTracker = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    riskTrackerConfigEntity.keystrokeDataTracker = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    riskTrackerConfigEntity.keystrokeDataTracker = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                riskTrackerConfigEntity.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return riskTrackerConfigEntity;
    }
}
