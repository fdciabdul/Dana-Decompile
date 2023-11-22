package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class OrAudience extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public OrAudience(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SmartFrictionConfig smartFrictionConfig = (SmartFrictionConfig) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 537);
        jsonWriter.value(smartFrictionConfig.accountFreeze);
        j.PlaceComponentResult(jsonWriter, 489);
        jsonWriter.value(smartFrictionConfig.blackListAccount);
        j.PlaceComponentResult(jsonWriter, 275);
        jsonWriter.value(smartFrictionConfig.notBankListRecent);
        j.PlaceComponentResult(jsonWriter, 544);
        jsonWriter.value(smartFrictionConfig.notContactListRecent);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE_DATA);
        jsonWriter.value(smartFrictionConfig.reachLimit);
        j.PlaceComponentResult(jsonWriter, 286);
        jsonWriter.value(smartFrictionConfig.suspiciousAccount);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SmartFrictionConfig smartFrictionConfig = new SmartFrictionConfig();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 69) {
                if (authRequestContext != 233) {
                    if (authRequestContext != 402) {
                        if (authRequestContext != 523) {
                            if (authRequestContext != 588) {
                                if (authRequestContext != 603) {
                                    jsonReader.skipValue();
                                } else if (z) {
                                    smartFrictionConfig.suspiciousAccount = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                } else {
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                smartFrictionConfig.notContactListRecent = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            smartFrictionConfig.blackListAccount = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        smartFrictionConfig.notBankListRecent = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    smartFrictionConfig.reachLimit = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                smartFrictionConfig.accountFreeze = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return smartFrictionConfig;
    }
}
