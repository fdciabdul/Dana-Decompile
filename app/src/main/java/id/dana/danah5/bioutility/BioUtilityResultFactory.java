package id.dana.danah5.bioutility;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danah5/bioutility/BioUtilityResultFactory;", "", "", "errorCode", "Lcom/alibaba/fastjson/JSONObject;", "getError", "(I)Lcom/alibaba/fastjson/JSONObject;", "", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "Lid/dana/danah5/bioutility/BioUtilitySuccessResult;", "bioUtilitySuccessResult", "getResult", "(Lid/dana/danah5/bioutility/BioUtilitySuccessResult;)Lcom/alibaba/fastjson/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BioUtilityResultFactory {
    public static final BioUtilityResultFactory INSTANCE = new BioUtilityResultFactory();

    private BioUtilityResultFactory() {
    }

    @JvmStatic
    public static final JSONObject getResult(BioUtilitySuccessResult bioUtilitySuccessResult) {
        Intrinsics.checkNotNullParameter(bioUtilitySuccessResult, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", JSON.toJSON(bioUtilitySuccessResult));
        return jSONObject;
    }

    @JvmStatic
    public static final JSONObject getError(String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) errorCode);
        return jSONObject;
    }

    @JvmStatic
    public static final JSONObject getError(int errorCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) Integer.valueOf(errorCode));
        return jSONObject;
    }
}
