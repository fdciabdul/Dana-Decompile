package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class Clause extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;

    public Clause(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        UserLocationPermissionPromptConfig userLocationPermissionPromptConfig = (UserLocationPermissionPromptConfig) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(userLocationPermissionPromptConfig.enable);
        j.PlaceComponentResult(jsonWriter, 227);
        jsonWriter.value(Integer.valueOf(userLocationPermissionPromptConfig.maxRepeatedInAMonth));
        j.PlaceComponentResult(jsonWriter, 120);
        jsonWriter.value(Integer.valueOf(userLocationPermissionPromptConfig.repeatedInDays));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        UserLocationPermissionPromptConfig userLocationPermissionPromptConfig = new UserLocationPermissionPromptConfig();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 175) {
                if (authRequestContext != 591) {
                    if (authRequestContext != 599) {
                        jsonReader.skipValue();
                    } else if (z) {
                        try {
                            userLocationPermissionPromptConfig.repeatedInDays = jsonReader.nextInt();
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        userLocationPermissionPromptConfig.maxRepeatedInAMonth = jsonReader.nextInt();
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                userLocationPermissionPromptConfig.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return userLocationPermissionPromptConfig;
    }
}
