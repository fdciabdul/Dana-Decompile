package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.deeplink.model.SeamlessData;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class CreateOrderTopUpFamilyBalance extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson getAuthRequestContext;

    public CreateOrderTopUpFamilyBalance(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SeamlessData seamlessData = (SeamlessData) obj;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        String str = seamlessData.externalUid;
        j.PlaceComponentResult(jsonWriter, 568);
        jsonWriter.value(seamlessData.externalUid);
        String str2 = seamlessData.mobile;
        j.PlaceComponentResult(jsonWriter, 110);
        jsonWriter.value(seamlessData.mobile);
        String str3 = seamlessData.reqMsgId;
        j.PlaceComponentResult(jsonWriter, 159);
        jsonWriter.value(seamlessData.reqMsgId);
        String str4 = seamlessData.reqTime;
        j.PlaceComponentResult(jsonWriter, 460);
        jsonWriter.value(seamlessData.reqTime);
        String str5 = seamlessData.verifiedTime;
        j.PlaceComponentResult(jsonWriter, 587);
        jsonWriter.value(seamlessData.verifiedTime);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SeamlessData seamlessData = new SeamlessData();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 126) {
                if (authRequestContext != 203) {
                    if (authRequestContext != 285) {
                        if (authRequestContext != 415) {
                            if (authRequestContext != 532) {
                                jsonReader.skipValue();
                            } else if (z) {
                                seamlessData.reqTime = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                seamlessData.reqTime = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            seamlessData.reqMsgId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            seamlessData.reqMsgId = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        seamlessData.mobile = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        seamlessData.mobile = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    seamlessData.externalUid = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    seamlessData.externalUid = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                seamlessData.verifiedTime = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                seamlessData.verifiedTime = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return seamlessData;
    }
}
