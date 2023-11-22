package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.userconsent.repository.UserConsentEntityRepository;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class onLoadComplete extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public onLoadComplete(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        UserConsentEntityRepository.UserConsentThreshold userConsentThreshold = (UserConsentEntityRepository.UserConsentThreshold) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 248);
        jsonWriter.value(Integer.valueOf(userConsentThreshold.MyBillsEntityDataFactory));
        j.PlaceComponentResult(jsonWriter, 132);
        jsonWriter.value(Integer.valueOf(userConsentThreshold.BuiltInFictitiousFunctionClassFactory));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        UserConsentEntityRepository.UserConsentThreshold userConsentThreshold = new UserConsentEntityRepository.UserConsentThreshold();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 42) {
                if (authRequestContext != 209) {
                    jsonReader.skipValue();
                } else if (z) {
                    try {
                        userConsentThreshold.BuiltInFictitiousFunctionClassFactory = jsonReader.nextInt();
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    userConsentThreshold.MyBillsEntityDataFactory = jsonReader.nextInt();
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return userConsentThreshold;
    }
}
