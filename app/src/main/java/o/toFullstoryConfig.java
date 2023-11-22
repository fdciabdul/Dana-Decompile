package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.saving.model.MainEmptyStateEntity;
import id.dana.data.saving.model.SavingBenefitEntity;
import id.dana.data.saving.model.SavingEmptyStateEntity;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class toFullstoryConfig extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private Gson getAuthRequestContext;

    public toFullstoryConfig(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SavingEmptyStateEntity savingEmptyStateEntity = (SavingEmptyStateEntity) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        MainEmptyStateEntity mainEmptyStateEntity = savingEmptyStateEntity.mainEmptyState;
        j.PlaceComponentResult(jsonWriter, 451);
        MainEmptyStateEntity mainEmptyStateEntity2 = savingEmptyStateEntity.mainEmptyState;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, MainEmptyStateEntity.class, mainEmptyStateEntity2).write(jsonWriter, mainEmptyStateEntity2);
        if (savingEmptyStateEntity != savingEmptyStateEntity.savingBenefit) {
            j.PlaceComponentResult(jsonWriter, 501);
            getLastClearRequest getlastclearrequest = new getLastClearRequest();
            List<SavingBenefitEntity> list = savingEmptyStateEntity.savingBenefit;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getlastclearrequest, list).write(jsonWriter, list);
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
        SavingEmptyStateEntity savingEmptyStateEntity = new SavingEmptyStateEntity();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 394) {
                if (authRequestContext != 480) {
                    jsonReader.skipValue();
                } else if (z) {
                    savingEmptyStateEntity.mainEmptyState = (MainEmptyStateEntity) gson.getAdapter(MainEmptyStateEntity.class).read2(jsonReader);
                } else {
                    savingEmptyStateEntity.mainEmptyState = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                savingEmptyStateEntity.savingBenefit = (List) gson.getAdapter(new getLastClearRequest()).read2(jsonReader);
            } else {
                savingEmptyStateEntity.savingBenefit = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return savingEmptyStateEntity;
    }
}
