package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class LimitedDispatcher extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public LimitedDispatcher(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ExpressPurchaseModel.Paylater.BenefitContent benefitContent = (ExpressPurchaseModel.Paylater.BenefitContent) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = benefitContent.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 283);
        jsonWriter.value(benefitContent.PlaceComponentResult);
        String str2 = benefitContent.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, 454);
        jsonWriter.value(benefitContent.getAuthRequestContext);
        String str3 = benefitContent.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(benefitContent.MyBillsEntityDataFactory);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ExpressPurchaseModel.Paylater.BenefitContent benefitContent = new ExpressPurchaseModel.Paylater.BenefitContent();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 130) {
                if (authRequestContext != 190) {
                    if (authRequestContext != 257) {
                        if (authRequestContext != 384) {
                            jsonReader.skipValue();
                        }
                    } else if (z) {
                        benefitContent.getAuthRequestContext = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        benefitContent.getAuthRequestContext = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    benefitContent.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    benefitContent.MyBillsEntityDataFactory = null;
                    jsonReader.nextNull();
                }
            }
            if (z) {
                benefitContent.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                benefitContent.PlaceComponentResult = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return benefitContent;
    }
}
