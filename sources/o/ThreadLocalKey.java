package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class ThreadLocalKey extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public ThreadLocalKey(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        PopularPlaceInfo popularPlaceInfo = (PopularPlaceInfo) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 162);
        jsonWriter.value(popularPlaceInfo.highlight);
        String str = popularPlaceInfo.logoUrl;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_HASHHEX_FAILED);
        jsonWriter.value(popularPlaceInfo.logoUrl);
        String str2 = popularPlaceInfo.merchantId;
        j.PlaceComponentResult(jsonWriter, 478);
        jsonWriter.value(popularPlaceInfo.merchantId);
        String str3 = popularPlaceInfo.merchantName;
        j.PlaceComponentResult(jsonWriter, 105);
        jsonWriter.value(popularPlaceInfo.merchantName);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        PopularPlaceInfo popularPlaceInfo = new PopularPlaceInfo();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 104) {
                if (authRequestContext != 177) {
                    if (authRequestContext != 282) {
                        if (authRequestContext != 543) {
                            jsonReader.skipValue();
                        } else if (z) {
                            popularPlaceInfo.logoUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            popularPlaceInfo.logoUrl = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        popularPlaceInfo.highlight = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    popularPlaceInfo.merchantId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    popularPlaceInfo.merchantId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                popularPlaceInfo.merchantName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                popularPlaceInfo.merchantName = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return popularPlaceInfo;
    }
}
