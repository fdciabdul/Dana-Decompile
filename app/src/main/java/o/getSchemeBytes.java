package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.passkey.model.GetPasskeyResponse;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class getSchemeBytes extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;

    public getSchemeBytes(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        GetPasskeyResponse.Response response = (GetPasskeyResponse.Response) obj;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        if (response != response.authenticatorData) {
            j.PlaceComponentResult(jsonWriter, 436);
            jsonWriter.value(response.authenticatorData);
        }
        if (response != response.clientDataJSON) {
            j.PlaceComponentResult(jsonWriter, 93);
            jsonWriter.value(response.clientDataJSON);
        }
        if (response != response.signature) {
            j.PlaceComponentResult(jsonWriter, 288);
            jsonWriter.value(response.signature);
        }
        if (response != response.userHandle) {
            j.PlaceComponentResult(jsonWriter, 143);
            jsonWriter.value(response.userHandle);
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
        GetPasskeyResponse.Response response = new GetPasskeyResponse.Response();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 269) {
                if (authRequestContext != 329) {
                    if (authRequestContext != 425) {
                        if (authRequestContext != 587) {
                            jsonReader.skipValue();
                        } else if (z) {
                            response.userHandle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            response.userHandle = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        response.authenticatorData = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        response.authenticatorData = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    response.signature = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    response.signature = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                response.clientDataJSON = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                response.clientDataJSON = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return response;
    }
}
