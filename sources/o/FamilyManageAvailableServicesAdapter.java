package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.danaprotection.repository.source.network.result.DanaProtectionInfoResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class FamilyManageAvailableServicesAdapter extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public FamilyManageAvailableServicesAdapter(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DanaProtectionInfoResult danaProtectionInfoResult = (DanaProtectionInfoResult) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        Integer num = danaProtectionInfoResult.protectedActivity;
        j.PlaceComponentResult(jsonWriter, 381);
        Integer num2 = danaProtectionInfoResult.protectedActivity;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        Integer num3 = danaProtectionInfoResult.suspiciousActivity;
        j.PlaceComponentResult(jsonWriter, 474);
        Integer num4 = danaProtectionInfoResult.suspiciousActivity;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        Integer num5 = danaProtectionInfoResult.timeRange;
        j.PlaceComponentResult(jsonWriter, 46);
        Integer num6 = danaProtectionInfoResult.timeRange;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num6).write(jsonWriter, num6);
        danaProtectionInfoResult.PlaceComponentResult(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DanaProtectionInfoResult danaProtectionInfoResult = new DanaProtectionInfoResult();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 32) {
                if (authRequestContext != 156) {
                    if (authRequestContext != 392) {
                        danaProtectionInfoResult.KClassImpl$Data$declaredNonStaticMembers$2(gson, jsonReader, authRequestContext);
                    } else if (z) {
                        danaProtectionInfoResult.timeRange = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                    } else {
                        danaProtectionInfoResult.timeRange = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    danaProtectionInfoResult.suspiciousActivity = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                } else {
                    danaProtectionInfoResult.suspiciousActivity = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                danaProtectionInfoResult.protectedActivity = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                danaProtectionInfoResult.protectedActivity = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return danaProtectionInfoResult;
    }
}
