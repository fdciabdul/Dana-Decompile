package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class OcrImagePreprocessingConfigModel extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public OcrImagePreprocessingConfigModel(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        Boolean bool = loanStatusWhitelist.alwaysConsult;
        j.PlaceComponentResult(jsonWriter, 372);
        jsonWriter.value(loanStatusWhitelist.alwaysConsult);
        Integer num = loanStatusWhitelist.dueDays;
        j.PlaceComponentResult(jsonWriter, 139);
        Integer num2 = loanStatusWhitelist.dueDays;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        String str = loanStatusWhitelist.status;
        j.PlaceComponentResult(jsonWriter, 95);
        jsonWriter.value(loanStatusWhitelist.status);
        String str2 = loanStatusWhitelist.type;
        j.PlaceComponentResult(jsonWriter, 237);
        jsonWriter.value(loanStatusWhitelist.type);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        LoanStatusWhitelist loanStatusWhitelist = new LoanStatusWhitelist();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 225) {
                if (authRequestContext != 283) {
                    if (authRequestContext != 562) {
                        if (authRequestContext != 613) {
                            jsonReader.skipValue();
                        } else if (z) {
                            loanStatusWhitelist.status = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            loanStatusWhitelist.status = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        loanStatusWhitelist.alwaysConsult = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                    } else {
                        loanStatusWhitelist.alwaysConsult = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    loanStatusWhitelist.type = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    loanStatusWhitelist.type = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                loanStatusWhitelist.dueDays = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
            } else {
                loanStatusWhitelist.dueDays = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return loanStatusWhitelist;
    }
}
