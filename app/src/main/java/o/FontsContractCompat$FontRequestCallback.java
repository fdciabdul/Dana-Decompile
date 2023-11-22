package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.here.model.ErrorHereResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class FontsContractCompat$FontRequestCallback extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public FontsContractCompat$FontRequestCallback(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        ErrorHereResponse errorHereResponse = (ErrorHereResponse) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = errorHereResponse.errorCode;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED);
        jsonWriter.value(errorHereResponse.errorCode);
        String str2 = errorHereResponse.errorDescription;
        j.PlaceComponentResult(jsonWriter, 178);
        jsonWriter.value(errorHereResponse.errorDescription);
        String str3 = errorHereResponse.message;
        j.PlaceComponentResult(jsonWriter, 10);
        jsonWriter.value(errorHereResponse.message);
        String str4 = errorHereResponse.status;
        j.PlaceComponentResult(jsonWriter, 95);
        jsonWriter.value(errorHereResponse.status);
        String str5 = errorHereResponse.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(errorHereResponse.title);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ErrorHereResponse errorHereResponse = new ErrorHereResponse();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 289) {
                    if (authRequestContext != 548) {
                        if (authRequestContext != 552) {
                            if (authRequestContext != 613) {
                                jsonReader.skipValue();
                            } else if (z) {
                                errorHereResponse.status = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                errorHereResponse.status = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            errorHereResponse.errorDescription = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            errorHereResponse.errorDescription = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        errorHereResponse.message = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        errorHereResponse.message = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    errorHereResponse.errorCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    errorHereResponse.errorCode = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                errorHereResponse.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                errorHereResponse.title = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return errorHereResponse;
    }
}
