package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class VerifyPushDerollRequest extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public VerifyPushDerollRequest(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DanaProtectionWidgetConfig danaProtectionWidgetConfig = (DanaProtectionWidgetConfig) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 71);
        jsonWriter.value(Integer.valueOf(danaProtectionWidgetConfig.expiredCacheTimeInMinute));
        j.PlaceComponentResult(jsonWriter, 0);
        jsonWriter.value(danaProtectionWidgetConfig.isApiToggleEnabled);
        j.PlaceComponentResult(jsonWriter, 439);
        jsonWriter.value(danaProtectionWidgetConfig.isNewWidgetEnabled);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DanaProtectionWidgetConfig danaProtectionWidgetConfig = new DanaProtectionWidgetConfig();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 15) {
                if (authRequestContext != 231) {
                    if (authRequestContext != 299) {
                        jsonReader.skipValue();
                    } else if (z) {
                        try {
                            danaProtectionWidgetConfig.expiredCacheTimeInMinute = jsonReader.nextInt();
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    danaProtectionWidgetConfig.isNewWidgetEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                danaProtectionWidgetConfig.isApiToggleEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return danaProtectionWidgetConfig;
    }
}
