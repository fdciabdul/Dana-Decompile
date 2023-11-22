package id.dana.danah5.faceverificationenablement;

import com.alibaba.fastjson.JSONObject;
import id.dana.riskChallenges.constant.RiskChallengeValue;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/faceverificationenablement/FaceAuthenticationResponse;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceAuthenticationResponse {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ENROLLMENT_FAILED_ERROR_CODE = 14;
    private static final int PIN_TEMPORARY_LOCKED_ERROR_CODE = 13;
    private static final int RISK_REJECT_ERROR_CODE = 12;
    private static final int SWITCH_FAILED_ERROR_CODE = 15;
    private static final int USER_CANCEL_ERROR_CODE = 11;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0013\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000b"}, d2 = {"Lid/dana/danah5/faceverificationenablement/FaceAuthenticationResponse$Companion;", "", "", "code", "Lcom/alibaba/fastjson/JSONObject;", "getJsonError", "(I)Lcom/alibaba/fastjson/JSONObject;", "getENROLLMENT_FAILED", "()Lcom/alibaba/fastjson/JSONObject;", "ENROLLMENT_FAILED", "ENROLLMENT_FAILED_ERROR_CODE", "I", "getPIN_TEMPORARY_LOCKED", "PIN_TEMPORARY_LOCKED", "PIN_TEMPORARY_LOCKED_ERROR_CODE", "getRISK_REJECT", RiskChallengeValue.RISK_REJECT, "RISK_REJECT_ERROR_CODE", "getSWITCH_FAILED", "SWITCH_FAILED", "SWITCH_FAILED_ERROR_CODE", "getUSER_CANCEL", "USER_CANCEL", "USER_CANCEL_ERROR_CODE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject getJsonError(int code) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.FALSE);
            jSONObject.put("error", (Object) Integer.valueOf(code));
            return jSONObject;
        }

        @JvmName(name = "getENROLLMENT_FAILED")
        public final JSONObject getENROLLMENT_FAILED() {
            return getJsonError(14);
        }

        @JvmName(name = "getSWITCH_FAILED")
        public final JSONObject getSWITCH_FAILED() {
            return getJsonError(15);
        }

        @JvmName(name = "getPIN_TEMPORARY_LOCKED")
        public final JSONObject getPIN_TEMPORARY_LOCKED() {
            return getJsonError(13);
        }

        @JvmName(name = "getRISK_REJECT")
        public final JSONObject getRISK_REJECT() {
            return getJsonError(12);
        }

        @JvmName(name = "getUSER_CANCEL")
        public final JSONObject getUSER_CANCEL() {
            return getJsonError(11);
        }
    }
}
