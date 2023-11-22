package id.dana.domain.model.rpc;

import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/domain/model/rpc/LoginInfo;", "", "", BranchLinkConstant.Params.LOGIN_ID, "Ljava/lang/String;", "getLoginId", "()Ljava/lang/String;", "setLoginId", "(Ljava/lang/String;)V", "loginIdType", "getLoginIdType", "setLoginIdType", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginInfo {
    private String loginId;
    private String loginIdType;

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "setLoginId")
    public final void setLoginId(String str) {
        this.loginId = str;
    }

    @JvmName(name = "getLoginIdType")
    public final String getLoginIdType() {
        return this.loginIdType;
    }

    @JvmName(name = "setLoginIdType")
    public final void setLoginIdType(String str) {
        this.loginIdType = str;
    }
}
