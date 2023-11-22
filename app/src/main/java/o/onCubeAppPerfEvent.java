package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.referral.source.local.model.ReferralDialogDailyLimitEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class onCubeAppPerfEvent extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public onCubeAppPerfEvent(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ReferralDialogDailyLimitEntity referralDialogDailyLimitEntity = (ReferralDialogDailyLimitEntity) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_CONFUSE_FAILED);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(referralDialogDailyLimitEntity.lastTimeDialogShown);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, 473);
        jsonWriter.value(Integer.valueOf(referralDialogDailyLimitEntity.numberOfDialogShowToday));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ReferralDialogDailyLimitEntity referralDialogDailyLimitEntity = new ReferralDialogDailyLimitEntity();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 200) {
                if (authRequestContext != 242) {
                    jsonReader.skipValue();
                } else if (z) {
                    referralDialogDailyLimitEntity.lastTimeDialogShown = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    referralDialogDailyLimitEntity.numberOfDialogShowToday = jsonReader.nextInt();
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return referralDialogDailyLimitEntity;
    }
}
