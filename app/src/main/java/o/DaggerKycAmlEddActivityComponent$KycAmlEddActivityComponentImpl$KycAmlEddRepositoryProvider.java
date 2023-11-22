package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.IP;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class DaggerKycAmlEddActivityComponent$KycAmlEddActivityComponentImpl$KycAmlEddRepositoryProvider extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public DaggerKycAmlEddActivityComponent$KycAmlEddActivityComponentImpl$KycAmlEddRepositoryProvider(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        IP ip = (IP) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = ip.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 90);
        jsonWriter.value(ip.KClassImpl$Data$declaredNonStaticMembers$2);
        String str2 = ip.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 303);
        jsonWriter.value(ip.BuiltInFictitiousFunctionClassFactory);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        IP ip = new IP();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 121) {
                if (authRequestContext != 342) {
                    jsonReader.skipValue();
                } else if (z) {
                    ip.BuiltInFictitiousFunctionClassFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    ip.BuiltInFictitiousFunctionClassFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                ip.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                ip.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return ip;
    }
}
