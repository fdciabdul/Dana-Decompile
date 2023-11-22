package o;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.h5event.sendmoney.Attributes;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class createSecondaryAnimatorProvider extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public createSecondaryAnimatorProvider(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Attributes attributes = (Attributes) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = attributes.accountName;
        j.PlaceComponentResult(jsonWriter, 233);
        jsonWriter.value(attributes.accountName);
        Boolean bool = attributes.displayMerchantOrder;
        j.PlaceComponentResult(jsonWriter, 437);
        jsonWriter.value(attributes.displayMerchantOrder);
        Boolean bool2 = attributes.loginStatus;
        j.PlaceComponentResult(jsonWriter, 386);
        jsonWriter.value(attributes.loginStatus);
        String str2 = attributes.merchantLogoUrl;
        j.PlaceComponentResult(jsonWriter, TarHeader.USTAR_FILENAME_PREFIX);
        jsonWriter.value(attributes.merchantLogoUrl);
        String str3 = attributes.merchantReturnUrl;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_LOW_VERSION_DATA_FILE);
        jsonWriter.value(attributes.merchantReturnUrl);
        String str4 = attributes.merchantTransId;
        j.PlaceComponentResult(jsonWriter, 534);
        jsonWriter.value(attributes.merchantTransId);
        String str5 = attributes.networkInfoName;
        j.PlaceComponentResult(jsonWriter, 15);
        jsonWriter.value(attributes.networkInfoName);
        String str6 = attributes.networkInfoScene;
        j.PlaceComponentResult(jsonWriter, 82);
        jsonWriter.value(attributes.networkInfoScene);
        String str7 = attributes.networkInfoSubscene;
        j.PlaceComponentResult(jsonWriter, 502);
        jsonWriter.value(attributes.networkInfoSubscene);
        String str8 = attributes.networkScenario;
        j.PlaceComponentResult(jsonWriter, 205);
        jsonWriter.value(attributes.networkScenario);
        String str9 = attributes.orderTitle;
        j.PlaceComponentResult(jsonWriter, 265);
        jsonWriter.value(attributes.orderTitle);
        String str10 = attributes.payAccountNo;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_STORE_GET_DATA_FILE_KEY_FAILED);
        jsonWriter.value(attributes.payAccountNo);
        String str11 = attributes.processingStatus;
        j.PlaceComponentResult(jsonWriter, 326);
        jsonWriter.value(attributes.processingStatus);
        String str12 = attributes.vaExpiredTime;
        j.PlaceComponentResult(jsonWriter, 404);
        jsonWriter.value(attributes.vaExpiredTime);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Attributes attributes = new Attributes();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 25:
                    if (!z) {
                        attributes.networkInfoScene = null;
                        break;
                    } else {
                        attributes.networkInfoScene = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 75:
                    if (!z) {
                        attributes.orderTitle = null;
                        break;
                    } else {
                        attributes.orderTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 110:
                    if (!z) {
                        attributes.vaExpiredTime = null;
                        break;
                    } else {
                        attributes.vaExpiredTime = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 188:
                    if (!z) {
                        attributes.merchantReturnUrl = null;
                        break;
                    } else {
                        attributes.merchantReturnUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 227:
                    if (!z) {
                        attributes.processingStatus = null;
                        break;
                    } else {
                        attributes.processingStatus = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_STA_NO_SUCH_INDEX /* 309 */:
                    if (!z) {
                        attributes.networkInfoSubscene = null;
                        break;
                    } else {
                        attributes.networkInfoSubscene = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 362:
                    if (!z) {
                        attributes.networkScenario = null;
                        break;
                    } else {
                        attributes.networkScenario = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 375:
                    if (!z) {
                        attributes.loginStatus = null;
                        break;
                    } else {
                        attributes.loginStatus = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 435:
                    if (!z) {
                        attributes.networkInfoName = null;
                        break;
                    } else {
                        attributes.networkInfoName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 444:
                    if (!z) {
                        attributes.merchantLogoUrl = null;
                        break;
                    } else {
                        attributes.merchantLogoUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 452:
                    if (!z) {
                        attributes.accountName = null;
                        break;
                    } else {
                        attributes.accountName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 460:
                    if (!z) {
                        attributes.merchantTransId = null;
                        break;
                    } else {
                        attributes.merchantTransId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_DYN_STORE_GET_DATA_FILE_KEY_FAILED /* 504 */:
                    if (!z) {
                        attributes.payAccountNo = null;
                        break;
                    } else {
                        attributes.payAccountNo = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 507:
                    if (!z) {
                        attributes.displayMerchantOrder = null;
                        break;
                    } else {
                        attributes.displayMerchantOrder = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return attributes;
    }
}
