package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.saving.model.SavingLimitEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class buildStats extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private Gson getAuthRequestContext;

    public buildStats(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SavingLimitEntity savingLimitEntity = (SavingLimitEntity) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = savingLimitEntity.maxSavingAmountKyc;
        j.PlaceComponentResult(jsonWriter, 56);
        jsonWriter.value(savingLimitEntity.maxSavingAmountKyc);
        String str2 = savingLimitEntity.maxSavingAmountNonKyc;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_LOW_VERSION_DATA_FILE);
        jsonWriter.value(savingLimitEntity.maxSavingAmountNonKyc);
        String str3 = savingLimitEntity.maxSavingCountNonKyc;
        j.PlaceComponentResult(jsonWriter, 194);
        jsonWriter.value(savingLimitEntity.maxSavingCountNonKyc);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SavingLimitEntity savingLimitEntity = new SavingLimitEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 122) {
                if (authRequestContext != 400) {
                    if (authRequestContext != 581) {
                        jsonReader.skipValue();
                    } else if (z) {
                        savingLimitEntity.maxSavingAmountKyc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        savingLimitEntity.maxSavingAmountKyc = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    savingLimitEntity.maxSavingAmountNonKyc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    savingLimitEntity.maxSavingAmountNonKyc = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                savingLimitEntity.maxSavingCountNonKyc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                savingLimitEntity.maxSavingCountNonKyc = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return savingLimitEntity;
    }
}
