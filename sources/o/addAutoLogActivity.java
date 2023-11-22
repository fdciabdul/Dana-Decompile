package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class addAutoLogActivity extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public addAutoLogActivity(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        PersonalizedReferralConfig personalizedReferralConfig = (PersonalizedReferralConfig) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = personalizedReferralConfig.bodyMessage;
        j.PlaceComponentResult(jsonWriter, 114);
        jsonWriter.value(personalizedReferralConfig.bodyMessage);
        String str2 = personalizedReferralConfig.contentLanguage;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE);
        jsonWriter.value(personalizedReferralConfig.contentLanguage);
        String str3 = personalizedReferralConfig.info;
        j.PlaceComponentResult(jsonWriter, 222);
        jsonWriter.value(personalizedReferralConfig.info);
        String str4 = personalizedReferralConfig.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(personalizedReferralConfig.title);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        PersonalizedReferralConfig personalizedReferralConfig = new PersonalizedReferralConfig();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 263) {
                    if (authRequestContext != 388) {
                        if (authRequestContext != 395) {
                            jsonReader.skipValue();
                        } else if (z) {
                            personalizedReferralConfig.bodyMessage = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            personalizedReferralConfig.bodyMessage = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        personalizedReferralConfig.contentLanguage = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        personalizedReferralConfig.contentLanguage = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    personalizedReferralConfig.info = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    personalizedReferralConfig.info = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                personalizedReferralConfig.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                personalizedReferralConfig.title = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return personalizedReferralConfig;
    }
}
