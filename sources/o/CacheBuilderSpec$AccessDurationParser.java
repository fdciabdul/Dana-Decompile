package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class CacheBuilderSpec$AccessDurationParser extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;

    public CacheBuilderSpec$AccessDurationParser(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ExpressPurchasePaylaterConfigResult expressPurchasePaylaterConfigResult = (ExpressPurchasePaylaterConfigResult) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = expressPurchasePaylaterConfigResult.dismiss;
        j.PlaceComponentResult(jsonWriter, 290);
        jsonWriter.value(expressPurchasePaylaterConfigResult.dismiss);
        String str2 = expressPurchasePaylaterConfigResult.spaceCode;
        j.PlaceComponentResult(jsonWriter, 83);
        jsonWriter.value(expressPurchasePaylaterConfigResult.spaceCode);
        String str3 = expressPurchasePaylaterConfigResult.url;
        j.PlaceComponentResult(jsonWriter, 320);
        jsonWriter.value(expressPurchasePaylaterConfigResult.url);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ExpressPurchasePaylaterConfigResult expressPurchasePaylaterConfigResult = new ExpressPurchasePaylaterConfigResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 95) {
                if (authRequestContext != 197) {
                    if (authRequestContext != 428) {
                        jsonReader.skipValue();
                    } else if (z) {
                        expressPurchasePaylaterConfigResult.dismiss = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        expressPurchasePaylaterConfigResult.dismiss = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    expressPurchasePaylaterConfigResult.spaceCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    expressPurchasePaylaterConfigResult.spaceCode = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                expressPurchasePaylaterConfigResult.url = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                expressPurchasePaylaterConfigResult.url = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return expressPurchasePaylaterConfigResult;
    }
}
