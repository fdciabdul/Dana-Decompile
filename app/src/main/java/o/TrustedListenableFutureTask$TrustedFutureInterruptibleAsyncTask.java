package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.wallet_v3.model.Rules;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        Rules rules = (Rules) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        if (rules != rules.assetType) {
            j.PlaceComponentResult(jsonWriter, 296);
            access$getMerchantInfoRepository$p access_getmerchantinforepository_p = new access$getMerchantInfoRepository$p();
            List<String> list = rules.assetType;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, access_getmerchantinforepository_p, list).write(jsonWriter, list);
        }
        String str = rules.basedOn;
        j.PlaceComponentResult(jsonWriter, 128);
        jsonWriter.value(rules.basedOn);
        Integer num = rules.comparator;
        j.PlaceComponentResult(jsonWriter, 325);
        Integer num2 = rules.comparator;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        String str2 = rules.comparisonOperator;
        j.PlaceComponentResult(jsonWriter, 127);
        jsonWriter.value(rules.comparisonOperator);
        String str3 = rules.logicalOperator;
        j.PlaceComponentResult(jsonWriter, 555);
        jsonWriter.value(rules.logicalOperator);
        String str4 = rules.sectionType;
        j.PlaceComponentResult(jsonWriter, 580);
        jsonWriter.value(rules.sectionType);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Rules rules = new Rules();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 147) {
                if (authRequestContext != 181) {
                    if (authRequestContext != 189) {
                        if (authRequestContext != 508) {
                            if (authRequestContext != 544) {
                                if (authRequestContext != 575) {
                                    jsonReader.skipValue();
                                } else if (z) {
                                    rules.comparator = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                                } else {
                                    rules.comparator = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                rules.sectionType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                rules.sectionType = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            rules.comparisonOperator = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            rules.comparisonOperator = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        rules.logicalOperator = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        rules.logicalOperator = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    rules.assetType = (List) gson.getAdapter(new access$getMerchantInfoRepository$p()).read2(jsonReader);
                } else {
                    rules.assetType = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                rules.basedOn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                rules.basedOn = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return rules;
    }
}
