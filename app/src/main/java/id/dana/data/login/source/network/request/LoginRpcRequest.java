package id.dana.data.login.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/data/login/source/network/request/LoginRpcRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "credentials", "Ljava/lang/String;", BranchLinkConstant.Params.LOGIN_ID, "loginIdType", "loginType", BioUtilityBridge.SECURITY_ID, "verifyAnswer", "verifyMethod", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginRpcRequest extends BaseRpcRequest {
    public String credentials;
    public String loginId;
    public String loginIdType;
    public String loginType;
    public String securityId;
    public String verifyAnswer;
    public String verifyMethod;
}
