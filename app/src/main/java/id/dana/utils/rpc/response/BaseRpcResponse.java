package id.dana.utils.rpc.response;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import o.J;

/* loaded from: classes2.dex */
public abstract class BaseRpcResponse {
    private String errorCode;
    private String errorMessage;
    private String errorMsg;
    private boolean success;
    private String tips;

    /* JADX INFO: Access modifiers changed from: protected */
    public final /* synthetic */ void MyBillsEntityDataFactory(JsonWriter jsonWriter, J j) {
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED);
        jsonWriter.value(this.errorCode);
        j.PlaceComponentResult(jsonWriter, 211);
        jsonWriter.value(this.errorMessage);
        j.PlaceComponentResult(jsonWriter, 551);
        jsonWriter.value(this.errorMsg);
        j.PlaceComponentResult(jsonWriter, 428);
        jsonWriter.value(this.success);
        j.PlaceComponentResult(jsonWriter, 477);
        jsonWriter.value(this.tips);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final /* synthetic */ void PlaceComponentResult(Gson gson, JsonReader jsonReader, int i) {
        boolean z = jsonReader.peek() != JsonToken.NULL;
        if (i == 136) {
            if (!z) {
                this.tips = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.tips = jsonReader.nextString();
            } else {
                this.tips = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 238) {
            if (z) {
                this.success = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        } else if (i == 289) {
            if (!z) {
                this.errorCode = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.errorCode = jsonReader.nextString();
            } else {
                this.errorCode = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 517) {
            if (!z) {
                this.errorMsg = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.errorMsg = jsonReader.nextString();
            } else {
                this.errorMsg = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i != 614) {
            jsonReader.skipValue();
        } else if (!z) {
            this.errorMessage = null;
            jsonReader.nextNull();
        } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
            this.errorMessage = jsonReader.nextString();
        } else {
            this.errorMessage = Boolean.toString(jsonReader.nextBoolean());
        }
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public String getNetworkErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        String str2 = this.errorMsg;
        return str2 != null ? str2 : this.tips;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseRpcResponse{errorCode='");
        sb.append(this.errorCode);
        sb.append('\'');
        sb.append(", errorMessage='");
        sb.append(this.errorMessage);
        sb.append('\'');
        sb.append(", tips='");
        sb.append(this.tips);
        sb.append('\'');
        sb.append(", success=");
        sb.append(this.success);
        sb.append('}');
        return sb.toString();
    }
}
