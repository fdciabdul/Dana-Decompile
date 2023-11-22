package id.dana.network.base;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/network/base/BaseRpcResultWithHeader;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "challengeContext", "Ljava/lang/String;", "getChallengeContext", "()Ljava/lang/String;", "setChallengeContext", "(Ljava/lang/String;)V", "errorMsg", "getErrorMsg", "setErrorMsg", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class BaseRpcResultWithHeader extends BaseRpcResult {
    private String challengeContext;
    private String errorMsg;

    @JvmName(name = "getChallengeContext")
    public final String getChallengeContext() {
        return this.challengeContext;
    }

    @JvmName(name = "setChallengeContext")
    public final void setChallengeContext(String str) {
        this.challengeContext = str;
    }

    @JvmName(name = "getErrorMsg")
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @JvmName(name = "setErrorMsg")
    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
