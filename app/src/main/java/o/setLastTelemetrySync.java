package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.passkey.model.GetPasskeyResponse;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class setLastTelemetrySync extends TypeAdapter implements G {
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public setLastTelemetrySync(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        GetPasskeyResponse getPasskeyResponse = (GetPasskeyResponse) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        if (getPasskeyResponse != getPasskeyResponse.authenticatorAttachment) {
            j.PlaceComponentResult(jsonWriter, 322);
            jsonWriter.value(getPasskeyResponse.authenticatorAttachment);
        }
        if (getPasskeyResponse != getPasskeyResponse.f8228id) {
            j.PlaceComponentResult(jsonWriter, 150);
            jsonWriter.value(getPasskeyResponse.f8228id);
        }
        if (getPasskeyResponse != getPasskeyResponse.rawId) {
            j.PlaceComponentResult(jsonWriter, 586);
            jsonWriter.value(getPasskeyResponse.rawId);
        }
        if (getPasskeyResponse != getPasskeyResponse.response) {
            j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_ENTITY_APP);
            GetPasskeyResponse.Response response = getPasskeyResponse.response;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, GetPasskeyResponse.Response.class, response).write(jsonWriter, response);
        }
        if (getPasskeyResponse != getPasskeyResponse.type) {
            j.PlaceComponentResult(jsonWriter, 237);
            jsonWriter.value(getPasskeyResponse.type);
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
        GetPasskeyResponse getPasskeyResponse = new GetPasskeyResponse();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 113) {
                if (authRequestContext != 193) {
                    if (authRequestContext != 283) {
                        if (authRequestContext != 396) {
                            if (authRequestContext != 410) {
                                jsonReader.skipValue();
                            } else if (z) {
                                getPasskeyResponse.f8228id = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                getPasskeyResponse.f8228id = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            getPasskeyResponse.authenticatorAttachment = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            getPasskeyResponse.authenticatorAttachment = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        getPasskeyResponse.type = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        getPasskeyResponse.type = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    getPasskeyResponse.rawId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    getPasskeyResponse.rawId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                getPasskeyResponse.response = (GetPasskeyResponse.Response) gson.getAdapter(GetPasskeyResponse.Response.class).read2(jsonReader);
            } else {
                getPasskeyResponse.response = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return getPasskeyResponse;
    }
}
