package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.saving.model.SavingBenefitEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class CreateCredentialCustomException extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;

    public CreateCredentialCustomException(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SavingBenefitEntity savingBenefitEntity = (SavingBenefitEntity) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = savingBenefitEntity.icon;
        j.PlaceComponentResult(jsonWriter, 418);
        jsonWriter.value(savingBenefitEntity.icon);
        String str2 = savingBenefitEntity.subtitle;
        j.PlaceComponentResult(jsonWriter, 347);
        jsonWriter.value(savingBenefitEntity.subtitle);
        String str3 = savingBenefitEntity.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(savingBenefitEntity.title);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SavingBenefitEntity savingBenefitEntity = new SavingBenefitEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 518) {
                    if (authRequestContext != 524) {
                        jsonReader.skipValue();
                    } else if (z) {
                        savingBenefitEntity.icon = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        savingBenefitEntity.icon = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    savingBenefitEntity.subtitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    savingBenefitEntity.subtitle = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                savingBenefitEntity.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                savingBenefitEntity.title = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return savingBenefitEntity;
    }
}
