package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.wallet.acl.base.ResultError;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class getAuthRequestContext extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public getAuthRequestContext(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ResultError resultError = (ResultError) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED);
        jsonWriter.value(Integer.valueOf(resultError.errorCode));
        if (resultError != resultError.errorDesc) {
            j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE);
            jsonWriter.value(resultError.errorDesc);
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
        ResultError resultError = new ResultError();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 105) {
                if (authRequestContext != 289) {
                    jsonReader.skipValue();
                } else if (z) {
                    try {
                        resultError.errorCode = jsonReader.nextInt();
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                resultError.errorDesc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                resultError.errorDesc = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return resultError;
    }
}
