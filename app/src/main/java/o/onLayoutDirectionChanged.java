package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.RepeatedBackgroundJobsResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class onLayoutDirectionChanged extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public onLayoutDirectionChanged(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        RepeatedBackgroundJobsResult repeatedBackgroundJobsResult = (RepeatedBackgroundJobsResult) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(repeatedBackgroundJobsResult.enable);
        j.PlaceComponentResult(jsonWriter, 100);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(repeatedBackgroundJobsResult.intervalTimeInMillis);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, 527);
        jsonWriter.value(repeatedBackgroundJobsResult.requiredCharging);
        j.PlaceComponentResult(jsonWriter, 430);
        jsonWriter.value(repeatedBackgroundJobsResult.requiredDeviceIdle);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        RepeatedBackgroundJobsResult repeatedBackgroundJobsResult = new RepeatedBackgroundJobsResult();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 168) {
                if (authRequestContext != 175) {
                    if (authRequestContext != 371) {
                        if (authRequestContext != 418) {
                            jsonReader.skipValue();
                        } else if (z) {
                            repeatedBackgroundJobsResult.requiredCharging = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        repeatedBackgroundJobsResult.requiredDeviceIdle = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    repeatedBackgroundJobsResult.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                repeatedBackgroundJobsResult.intervalTimeInMillis = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return repeatedBackgroundJobsResult;
    }
}
