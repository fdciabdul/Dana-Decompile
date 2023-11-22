package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.userconsent.repository.UserConsentEntityRepository;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getSharingAgreementIds extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getSharingAgreementIds(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        UserConsentEntityRepository.EnIn enIn = (UserConsentEntityRepository.EnIn) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        String[] strArr = enIn.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 520);
        String[] strArr2 = enIn.PlaceComponentResult;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, String[].class, strArr2).write(jsonWriter, strArr2);
        String[] strArr3 = enIn.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 150);
        String[] strArr4 = enIn.MyBillsEntityDataFactory;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, String[].class, strArr4).write(jsonWriter, strArr4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        UserConsentEntityRepository.EnIn enIn = new UserConsentEntityRepository.EnIn();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 334) {
                if (authRequestContext != 410) {
                    jsonReader.skipValue();
                } else if (z) {
                    enIn.MyBillsEntityDataFactory = (String[]) gson.getAdapter(String[].class).read2(jsonReader);
                } else {
                    enIn.MyBillsEntityDataFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                enIn.PlaceComponentResult = (String[]) gson.getAdapter(String[].class).read2(jsonReader);
            } else {
                enIn.PlaceComponentResult = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return enIn;
    }
}
