package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.h5event.sendmoney.CheckoutFinishEntity;
import id.dana.data.h5event.sendmoney.PayQueryResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class targetValue extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public targetValue(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CheckoutFinishEntity checkoutFinishEntity = (CheckoutFinishEntity) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 146);
        jsonWriter.value(checkoutFinishEntity.apiSuccess);
        PayQueryResponse payQueryResponse = checkoutFinishEntity.payQueryResponse;
        j.PlaceComponentResult(jsonWriter, 182);
        PayQueryResponse payQueryResponse2 = checkoutFinishEntity.payQueryResponse;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, PayQueryResponse.class, payQueryResponse2).write(jsonWriter, payQueryResponse2);
        String str = checkoutFinishEntity.processingStatus;
        j.PlaceComponentResult(jsonWriter, 326);
        jsonWriter.value(checkoutFinishEntity.processingStatus);
        String str2 = checkoutFinishEntity.transScenario;
        j.PlaceComponentResult(jsonWriter, 319);
        jsonWriter.value(checkoutFinishEntity.transScenario);
        String str3 = checkoutFinishEntity.transType;
        j.PlaceComponentResult(jsonWriter, 87);
        jsonWriter.value(checkoutFinishEntity.transType);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CheckoutFinishEntity checkoutFinishEntity = new CheckoutFinishEntity();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 41) {
                if (authRequestContext != 227) {
                    if (authRequestContext != 390) {
                        if (authRequestContext != 484) {
                            if (authRequestContext != 512) {
                                jsonReader.skipValue();
                            } else if (z) {
                                checkoutFinishEntity.transScenario = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                checkoutFinishEntity.transScenario = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            checkoutFinishEntity.payQueryResponse = (PayQueryResponse) gson.getAdapter(PayQueryResponse.class).read2(jsonReader);
                        } else {
                            checkoutFinishEntity.payQueryResponse = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        checkoutFinishEntity.apiSuccess = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    checkoutFinishEntity.processingStatus = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    checkoutFinishEntity.processingStatus = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                checkoutFinishEntity.transType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                checkoutFinishEntity.transType = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return checkoutFinishEntity;
    }
}
