package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.paylater.model.LoanInfo;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getKybKaFilter extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public getKybKaFilter(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        LoanInfo loanInfo = (LoanInfo) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        Long l = loanInfo.billDueDate;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED);
        Long l2 = loanInfo.billDueDate;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Long.class, l2).write(jsonWriter, l2);
        Boolean bool = loanInfo.registered;
        j.PlaceComponentResult(jsonWriter, 16);
        jsonWriter.value(loanInfo.registered);
        String str = loanInfo.type;
        j.PlaceComponentResult(jsonWriter, 237);
        jsonWriter.value(loanInfo.type);
        j.PlaceComponentResult(jsonWriter, 480);
        jsonWriter.value(loanInfo.whitelist);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        LoanInfo loanInfo = new LoanInfo();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 283) {
                if (authRequestContext != 293) {
                    if (authRequestContext != 322) {
                        if (authRequestContext != 333) {
                            jsonReader.skipValue();
                        } else if (z) {
                            loanInfo.billDueDate = (Long) gson.getAdapter(Long.class).read2(jsonReader);
                        } else {
                            loanInfo.billDueDate = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        loanInfo.whitelist = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    loanInfo.registered = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    loanInfo.registered = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                loanInfo.type = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                loanInfo.type = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return loanInfo;
    }
}
