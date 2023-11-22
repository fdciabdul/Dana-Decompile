package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import id.dana.data.login.source.network.result.RetryConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class SightCameraView$ICameraFrameListener extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public SightCameraView$ICameraFrameListener(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        LoginRegisterConfigResult loginRegisterConfigResult = (LoginRegisterConfigResult) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        Boolean bool = loginRegisterConfigResult.ipificationCheckCoverage;
        j.PlaceComponentResult(jsonWriter, 60);
        jsonWriter.value(loginRegisterConfigResult.ipificationCheckCoverage);
        Boolean bool2 = loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled;
        j.PlaceComponentResult(jsonWriter, 408);
        jsonWriter.value(loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled);
        RetryConfig retryConfig = loginRegisterConfigResult.retryConfig;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA);
        RetryConfig retryConfig2 = loginRegisterConfigResult.retryConfig;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, RetryConfig.class, retryConfig2).write(jsonWriter, retryConfig2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        LoginRegisterConfigResult loginRegisterConfigResult = new LoginRegisterConfigResult();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 96) {
                if (authRequestContext != 298) {
                    if (authRequestContext != 459) {
                        jsonReader.skipValue();
                    } else if (z) {
                        loginRegisterConfigResult.ipificationCheckCoverage = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                    } else {
                        loginRegisterConfigResult.ipificationCheckCoverage = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    loginRegisterConfigResult.retryConfig = (RetryConfig) gson.getAdapter(RetryConfig.class).read2(jsonReader);
                } else {
                    loginRegisterConfigResult.retryConfig = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
            } else {
                loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return loginRegisterConfigResult;
    }
}
