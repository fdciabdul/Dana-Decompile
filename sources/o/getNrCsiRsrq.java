package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.TwilioTimeoutConfigResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getNrCsiRsrq extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getNrCsiRsrq(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TwilioTimeoutConfigResult twilioTimeoutConfigResult = (TwilioTimeoutConfigResult) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 589);
        jsonWriter.value(Integer.valueOf(twilioTimeoutConfigResult.counter));
        j.PlaceComponentResult(jsonWriter, 165);
        jsonWriter.value(Integer.valueOf(twilioTimeoutConfigResult.delayTime));
        j.PlaceComponentResult(jsonWriter, 553);
        jsonWriter.value(Integer.valueOf(twilioTimeoutConfigResult.timeout));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        TwilioTimeoutConfigResult twilioTimeoutConfigResult = new TwilioTimeoutConfigResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 7) {
                if (authRequestContext != 176) {
                    if (authRequestContext != 247) {
                        jsonReader.skipValue();
                    } else if (z) {
                        try {
                            twilioTimeoutConfigResult.delayTime = jsonReader.nextInt();
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        twilioTimeoutConfigResult.timeout = jsonReader.nextInt();
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    twilioTimeoutConfigResult.counter = jsonReader.nextInt();
                } catch (NumberFormatException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return twilioTimeoutConfigResult;
    }
}
