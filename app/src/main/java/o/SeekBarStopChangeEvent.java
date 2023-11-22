package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.userconsent.repository.UserConsentEntityRepository;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class SeekBarStopChangeEvent extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;

    public SeekBarStopChangeEvent(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        UserConsentEntityRepository.UserConsentAgreementContent userConsentAgreementContent = (UserConsentEntityRepository.UserConsentAgreementContent) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        UserConsentEntityRepository.EnIn enIn = userConsentAgreementContent.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 592);
        UserConsentEntityRepository.EnIn enIn2 = userConsentAgreementContent.BuiltInFictitiousFunctionClassFactory;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, UserConsentEntityRepository.EnIn.class, enIn2).write(jsonWriter, enIn2);
        UserConsentEntityRepository.EnIn enIn3 = userConsentAgreementContent.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, 357);
        UserConsentEntityRepository.EnIn enIn4 = userConsentAgreementContent.getAuthRequestContext;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, UserConsentEntityRepository.EnIn.class, enIn4).write(jsonWriter, enIn4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        UserConsentEntityRepository.UserConsentAgreementContent userConsentAgreementContent = new UserConsentEntityRepository.UserConsentAgreementContent();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 478) {
                if (authRequestContext != 574) {
                    jsonReader.skipValue();
                } else if (z) {
                    userConsentAgreementContent.BuiltInFictitiousFunctionClassFactory = (UserConsentEntityRepository.EnIn) gson.getAdapter(UserConsentEntityRepository.EnIn.class).read2(jsonReader);
                } else {
                    userConsentAgreementContent.BuiltInFictitiousFunctionClassFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                userConsentAgreementContent.getAuthRequestContext = (UserConsentEntityRepository.EnIn) gson.getAdapter(UserConsentEntityRepository.EnIn.class).read2(jsonReader);
            } else {
                userConsentAgreementContent.getAuthRequestContext = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return userConsentAgreementContent;
    }
}
