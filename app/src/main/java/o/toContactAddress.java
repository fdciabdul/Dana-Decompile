package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.kyb.data.model.KybInfoResult;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class toContactAddress extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public toContactAddress(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        KybInfoResult kybInfoResult = (KybInfoResult) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = kybInfoResult.BUSINESS_ADDRESS;
        j.PlaceComponentResult(jsonWriter, 271);
        jsonWriter.value(kybInfoResult.BUSINESS_ADDRESS);
        String str2 = kybInfoResult.BUSINESS_NAME;
        j.PlaceComponentResult(jsonWriter, 177);
        jsonWriter.value(kybInfoResult.BUSINESS_NAME);
        String str3 = kybInfoResult.BUSINESS_TYPE;
        j.PlaceComponentResult(jsonWriter, 133);
        jsonWriter.value(kybInfoResult.BUSINESS_TYPE);
        String str4 = kybInfoResult.BUSSINESS_CITY;
        j.PlaceComponentResult(jsonWriter, 66);
        jsonWriter.value(kybInfoResult.BUSSINESS_CITY);
        String str5 = kybInfoResult.LOGO_URL;
        j.PlaceComponentResult(jsonWriter, 462);
        jsonWriter.value(kybInfoResult.LOGO_URL);
        String str6 = kybInfoResult.OPERATION_HOURS;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_DATA_FILE_MISMATCH);
        jsonWriter.value(kybInfoResult.OPERATION_HOURS);
        String str7 = kybInfoResult.OUTLET_PHOTO_URL;
        j.PlaceComponentResult(jsonWriter, 361);
        jsonWriter.value(kybInfoResult.OUTLET_PHOTO_URL);
        String str8 = kybInfoResult.OWNER_NAME;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA);
        jsonWriter.value(kybInfoResult.OWNER_NAME);
        String str9 = kybInfoResult.OWNER_TAX_NUMBER;
        j.PlaceComponentResult(jsonWriter, 137);
        jsonWriter.value(kybInfoResult.OWNER_TAX_NUMBER);
        String str10 = kybInfoResult.POSTAL_CODE;
        j.PlaceComponentResult(jsonWriter, 365);
        jsonWriter.value(kybInfoResult.POSTAL_CODE);
        String str11 = kybInfoResult.PRODUCTID;
        j.PlaceComponentResult(jsonWriter, 448);
        jsonWriter.value(kybInfoResult.PRODUCTID);
        String str12 = kybInfoResult.RESIDENTIAL_ADDRESS;
        j.PlaceComponentResult(jsonWriter, 391);
        jsonWriter.value(kybInfoResult.RESIDENTIAL_ADDRESS);
        String str13 = kybInfoResult.USER_ID;
        j.PlaceComponentResult(jsonWriter, 375);
        jsonWriter.value(kybInfoResult.USER_ID);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        KybInfoResult kybInfoResult = new KybInfoResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 4:
                    if (!z) {
                        kybInfoResult.BUSINESS_TYPE = null;
                        break;
                    } else {
                        kybInfoResult.BUSINESS_TYPE = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 34:
                    if (!z) {
                        kybInfoResult.BUSINESS_ADDRESS = null;
                        break;
                    } else {
                        kybInfoResult.BUSINESS_ADDRESS = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 61:
                    if (!z) {
                        kybInfoResult.BUSSINESS_CITY = null;
                        break;
                    } else {
                        kybInfoResult.BUSSINESS_CITY = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 64:
                    if (!z) {
                        kybInfoResult.RESIDENTIAL_ADDRESS = null;
                        break;
                    } else {
                        kybInfoResult.RESIDENTIAL_ADDRESS = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 94:
                    if (!z) {
                        kybInfoResult.LOGO_URL = null;
                        break;
                    } else {
                        kybInfoResult.LOGO_URL = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 150:
                    if (!z) {
                        kybInfoResult.PRODUCTID = null;
                        break;
                    } else {
                        kybInfoResult.PRODUCTID = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 164:
                    if (!z) {
                        kybInfoResult.OWNER_TAX_NUMBER = null;
                        break;
                    } else {
                        kybInfoResult.OWNER_TAX_NUMBER = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 276:
                    if (!z) {
                        kybInfoResult.USER_ID = null;
                        break;
                    } else {
                        kybInfoResult.USER_ID = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED /* 405 */:
                    if (!z) {
                        kybInfoResult.OUTLET_PHOTO_URL = null;
                        break;
                    } else {
                        kybInfoResult.OUTLET_PHOTO_URL = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 437:
                    if (!z) {
                        kybInfoResult.OWNER_NAME = null;
                        break;
                    } else {
                        kybInfoResult.OWNER_NAME = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 475:
                    if (!z) {
                        kybInfoResult.POSTAL_CODE = null;
                        break;
                    } else {
                        kybInfoResult.POSTAL_CODE = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 564:
                    if (!z) {
                        kybInfoResult.BUSINESS_NAME = null;
                        break;
                    } else {
                        kybInfoResult.BUSINESS_NAME = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_LOW_VERSION_DATA_FILE /* 615 */:
                    if (!z) {
                        kybInfoResult.OPERATION_HOURS = null;
                        break;
                    } else {
                        kybInfoResult.OPERATION_HOURS = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return kybInfoResult;
    }
}
