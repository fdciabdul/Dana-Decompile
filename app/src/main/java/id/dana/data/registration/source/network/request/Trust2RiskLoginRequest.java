package id.dana.data.registration.source.network.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001BO\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006"}, d2 = {"Lid/dana/data/registration/source/network/request/Trust2RiskLoginRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "credentials", "Ljava/lang/String;", "getCredentials", "()Ljava/lang/String;", BranchLinkConstant.Params.LOGIN_ID, "getLoginId", "loginIdType", "getLoginIdType", "loginTokenId", "getLoginTokenId", BioUtilityBridge.SECURITY_ID, "getSecurityId", "verifyMethod", "getVerifyMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Trust2RiskLoginRequest extends BaseRpcRequest {
    @SerializedName("credentials")
    private final String credentials;
    @SerializedName(BranchLinkConstant.Params.LOGIN_ID)
    private final String loginId;
    @SerializedName("loginIdType")
    private final String loginIdType;
    @SerializedName("loginTokenId")
    private final String loginTokenId;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("verifyMethod")
    private final String verifyMethod;

    public Trust2RiskLoginRequest() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ Trust2RiskLoginRequest(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "getLoginIdType")
    public final String getLoginIdType() {
        return this.loginIdType;
    }

    @JvmName(name = "getCredentials")
    public final String getCredentials() {
        return this.credentials;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerifyMethod")
    public final String getVerifyMethod() {
        return this.verifyMethod;
    }

    @JvmName(name = "getLoginTokenId")
    public final String getLoginTokenId() {
        return this.loginTokenId;
    }

    public Trust2RiskLoginRequest(@JSONField(name = "loginId") String str, @JSONField(name = "loginIdType") String str2, @JSONField(name = "credentials") String str3, @JSONField(name = "securityId") String str4, @JSONField(name = "verifyMethod") String str5, @JSONField(name = "loginTokenId") String str6) {
        this.loginId = str;
        this.loginIdType = str2;
        this.credentials = str3;
        this.securityId = str4;
        this.verifyMethod = str5;
        this.loginTokenId = str6;
    }
}
