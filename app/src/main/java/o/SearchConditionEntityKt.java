package o;

import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class SearchConditionEntityKt extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public SearchConditionEntityKt(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult = (PaylaterCicilMethodConfigResult) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        Integer num = paylaterCicilMethodConfigResult.cacheTime;
        j.PlaceComponentResult(jsonWriter, 528);
        Integer num2 = paylaterCicilMethodConfigResult.cacheTime;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        Integer num3 = paylaterCicilMethodConfigResult.delayShowRegistration;
        j.PlaceComponentResult(jsonWriter, 435);
        Integer num4 = paylaterCicilMethodConfigResult.delayShowRegistration;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        Integer num5 = paylaterCicilMethodConfigResult.maxCountShowRegistration;
        j.PlaceComponentResult(jsonWriter, 51);
        Integer num6 = paylaterCicilMethodConfigResult.maxCountShowRegistration;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num6).write(jsonWriter, num6);
        String str = paylaterCicilMethodConfigResult.mid;
        j.PlaceComponentResult(jsonWriter, 31);
        jsonWriter.value(paylaterCicilMethodConfigResult.mid);
        String str2 = paylaterCicilMethodConfigResult.onBoardingImageUrl;
        j.PlaceComponentResult(jsonWriter, 151);
        jsonWriter.value(paylaterCicilMethodConfigResult.onBoardingImageUrl);
        String str3 = paylaterCicilMethodConfigResult.onboardingSpaceCode;
        j.PlaceComponentResult(jsonWriter, WSContextConstant.HANDSHAKE_SEND_SIZE);
        jsonWriter.value(paylaterCicilMethodConfigResult.onboardingSpaceCode);
        String str4 = paylaterCicilMethodConfigResult.payMethodUnregistDesc;
        j.PlaceComponentResult(jsonWriter, 394);
        jsonWriter.value(paylaterCicilMethodConfigResult.payMethodUnregistDesc);
        String str5 = paylaterCicilMethodConfigResult.paymethodDescription;
        j.PlaceComponentResult(jsonWriter, 203);
        jsonWriter.value(paylaterCicilMethodConfigResult.paymethodDescription);
        String str6 = paylaterCicilMethodConfigResult.paymethodName;
        j.PlaceComponentResult(jsonWriter, 193);
        jsonWriter.value(paylaterCicilMethodConfigResult.paymethodName);
        String str7 = paylaterCicilMethodConfigResult.promoRibbonDesc;
        j.PlaceComponentResult(jsonWriter, 582);
        jsonWriter.value(paylaterCicilMethodConfigResult.promoRibbonDesc);
        String str8 = paylaterCicilMethodConfigResult.promoRibbonSelectedDesc;
        j.PlaceComponentResult(jsonWriter, 377);
        jsonWriter.value(paylaterCicilMethodConfigResult.promoRibbonSelectedDesc);
        Integer num7 = paylaterCicilMethodConfigResult.thresholdDue;
        j.PlaceComponentResult(jsonWriter, 449);
        Integer num8 = paylaterCicilMethodConfigResult.thresholdDue;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num8).write(jsonWriter, num8);
        if (paylaterCicilMethodConfigResult != paylaterCicilMethodConfigResult.tncSpaceCode) {
            j.PlaceComponentResult(jsonWriter, 294);
            HttpClientAttributesExtractorBuilder httpClientAttributesExtractorBuilder = new HttpClientAttributesExtractorBuilder();
            List<String> list = paylaterCicilMethodConfigResult.tncSpaceCode;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, httpClientAttributesExtractorBuilder, list).write(jsonWriter, list);
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
        PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult = new PaylaterCicilMethodConfigResult();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 12:
                    if (!z) {
                        paylaterCicilMethodConfigResult.promoRibbonDesc = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.promoRibbonDesc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 31:
                    if (!z) {
                        paylaterCicilMethodConfigResult.onBoardingImageUrl = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.onBoardingImageUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 58:
                    if (!z) {
                        paylaterCicilMethodConfigResult.cacheTime = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.cacheTime = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 158:
                    if (!z) {
                        paylaterCicilMethodConfigResult.payMethodUnregistDesc = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.payMethodUnregistDesc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 314:
                    if (!z) {
                        paylaterCicilMethodConfigResult.onboardingSpaceCode = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.onboardingSpaceCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 318:
                    if (!z) {
                        paylaterCicilMethodConfigResult.tncSpaceCode = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.tncSpaceCode = (List) gson.getAdapter(new HttpClientAttributesExtractorBuilder()).read2(jsonReader);
                        continue;
                    }
                case 337:
                    if (!z) {
                        paylaterCicilMethodConfigResult.promoRibbonSelectedDesc = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.promoRibbonSelectedDesc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 379:
                    if (!z) {
                        paylaterCicilMethodConfigResult.maxCountShowRegistration = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.maxCountShowRegistration = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 401:
                    if (!z) {
                        paylaterCicilMethodConfigResult.thresholdDue = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.thresholdDue = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 403:
                    if (!z) {
                        paylaterCicilMethodConfigResult.mid = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.mid = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 455:
                    if (!z) {
                        paylaterCicilMethodConfigResult.paymethodDescription = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.paymethodDescription = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 483:
                    if (!z) {
                        paylaterCicilMethodConfigResult.delayShowRegistration = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.delayShowRegistration = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 611:
                    if (!z) {
                        paylaterCicilMethodConfigResult.paymethodName = null;
                        break;
                    } else {
                        paylaterCicilMethodConfigResult.paymethodName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return paylaterCicilMethodConfigResult;
    }
}
