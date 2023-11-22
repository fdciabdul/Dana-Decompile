package id.dana.data.resetpin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/resetpin/model/SelfUnfreezeRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", BranchLinkConstant.Params.LOGIN_ID, "Ljava/lang/String;", "getLoginId", "()Ljava/lang/String;", "loginIdType", "getLoginIdType", BioUtilityBridge.SECURITY_ID, "getSecurityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SelfUnfreezeRequest extends BaseRpcRequest {
    @SerializedName(BranchLinkConstant.Params.LOGIN_ID)
    private final String loginId;
    @SerializedName("loginIdType")
    private final String loginIdType;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "getLoginIdType")
    public final String getLoginIdType() {
        return this.loginIdType;
    }

    public SelfUnfreezeRequest(@JSONField(name = "securityId") String str, @JSONField(name = "loginId") String str2, @JSONField(name = "loginIdType") String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.securityId = str;
        this.loginId = str2;
        this.loginIdType = str3;
    }
}
