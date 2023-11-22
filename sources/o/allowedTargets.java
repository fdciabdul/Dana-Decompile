package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.GeofenceConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class allowedTargets extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public allowedTargets(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        GeofenceConfigResult geofenceConfigResult = (GeofenceConfigResult) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 526);
        jsonWriter.value(Integer.valueOf(geofenceConfigResult.cachedInterval));
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(geofenceConfigResult.enable);
        j.PlaceComponentResult(jsonWriter, 529);
        jsonWriter.value(Integer.valueOf(geofenceConfigResult.maxRetry));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        GeofenceConfigResult geofenceConfigResult = new GeofenceConfigResult();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 175) {
                if (authRequestContext != 262) {
                    if (authRequestContext != 458) {
                        jsonReader.skipValue();
                    } else if (z) {
                        try {
                            geofenceConfigResult.maxRetry = jsonReader.nextInt();
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        geofenceConfigResult.cachedInterval = jsonReader.nextInt();
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                geofenceConfigResult.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return geofenceConfigResult;
    }
}
