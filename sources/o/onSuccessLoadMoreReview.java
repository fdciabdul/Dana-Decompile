package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class onSuccessLoadMoreReview extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;

    public onSuccessLoadMoreReview(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DanaHomeBalanceConfigModel danaHomeBalanceConfigModel = (DanaHomeBalanceConfigModel) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 167);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(danaHomeBalanceConfigModel.delayInMillis);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(danaHomeBalanceConfigModel.enable);
        j.PlaceComponentResult(jsonWriter, 476);
        Class cls2 = Long.TYPE;
        Long valueOf2 = Long.valueOf(danaHomeBalanceConfigModel.loopUntilInMillis);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls2, valueOf2).write(jsonWriter, valueOf2);
        if (danaHomeBalanceConfigModel != danaHomeBalanceConfigModel.services) {
            j.PlaceComponentResult(jsonWriter, 113);
            X509CRL x509crl = new X509CRL();
            List<String> list = danaHomeBalanceConfigModel.services;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, x509crl, list).write(jsonWriter, list);
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
        DanaHomeBalanceConfigModel danaHomeBalanceConfigModel = new DanaHomeBalanceConfigModel();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 78) {
                if (authRequestContext != 114) {
                    if (authRequestContext != 175) {
                        if (authRequestContext != 239) {
                            jsonReader.skipValue();
                        } else if (z) {
                            danaHomeBalanceConfigModel.loopUntilInMillis = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        danaHomeBalanceConfigModel.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    danaHomeBalanceConfigModel.delayInMillis = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                danaHomeBalanceConfigModel.services = (List) gson.getAdapter(new X509CRL()).read2(jsonReader);
            } else {
                danaHomeBalanceConfigModel.services = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return danaHomeBalanceConfigModel;
    }
}
