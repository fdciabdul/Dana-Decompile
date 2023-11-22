package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.LinkInfo;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class forEach extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public forEach(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        OnboardingWarningTextConfig onboardingWarningTextConfig = (OnboardingWarningTextConfig) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = onboardingWarningTextConfig.enTitle;
        j.PlaceComponentResult(jsonWriter, 158);
        jsonWriter.value(onboardingWarningTextConfig.enTitle);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(onboardingWarningTextConfig.enable);
        String str2 = onboardingWarningTextConfig.idTitle;
        j.PlaceComponentResult(jsonWriter, 2);
        jsonWriter.value(onboardingWarningTextConfig.idTitle);
        if (onboardingWarningTextConfig != onboardingWarningTextConfig.linkInfo) {
            j.PlaceComponentResult(jsonWriter, 215);
            DialogTncInformation_ViewBinding dialogTncInformation_ViewBinding = new DialogTncInformation_ViewBinding();
            List<LinkInfo> list = onboardingWarningTextConfig.linkInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, dialogTncInformation_ViewBinding, list).write(jsonWriter, list);
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
        OnboardingWarningTextConfig onboardingWarningTextConfig = new OnboardingWarningTextConfig();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 35) {
                if (authRequestContext != 175) {
                    if (authRequestContext != 205) {
                        if (authRequestContext != 555) {
                            jsonReader.skipValue();
                        } else if (z) {
                            onboardingWarningTextConfig.idTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            onboardingWarningTextConfig.idTitle = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        onboardingWarningTextConfig.linkInfo = (List) gson.getAdapter(new DialogTncInformation_ViewBinding()).read2(jsonReader);
                    } else {
                        onboardingWarningTextConfig.linkInfo = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    onboardingWarningTextConfig.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                onboardingWarningTextConfig.enTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                onboardingWarningTextConfig.enTitle = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return onboardingWarningTextConfig;
    }
}
