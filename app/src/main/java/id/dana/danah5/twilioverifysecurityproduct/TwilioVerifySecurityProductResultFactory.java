package id.dana.danah5.twilioverifysecurityproduct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductResultFactory;", "", "", "errorMessage", "Lcom/alibaba/fastjson/JSONObject;", "getFailedResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "Lid/dana/danah5/twilioverifysecurityproduct/VerifySecurityProductResult;", "verifySecurityProductResult", "getSuccessResult", "(Lid/dana/danah5/twilioverifysecurityproduct/VerifySecurityProductResult;)Lcom/alibaba/fastjson/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TwilioVerifySecurityProductResultFactory {
    public static final TwilioVerifySecurityProductResultFactory INSTANCE = new TwilioVerifySecurityProductResultFactory();

    private TwilioVerifySecurityProductResultFactory() {
    }

    public final JSONObject getSuccessResult(VerifySecurityProductResult verifySecurityProductResult) {
        Intrinsics.checkNotNullParameter(verifySecurityProductResult, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", JSON.toJSON(verifySecurityProductResult));
        return jSONObject;
    }

    public final JSONObject getFailedResult(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) errorMessage);
        return jSONObject;
    }
}
