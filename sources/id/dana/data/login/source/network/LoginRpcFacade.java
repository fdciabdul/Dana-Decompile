package id.dana.data.login.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.login.source.network.request.LoginRpcRequest;
import id.dana.data.login.source.network.request.LogoutRpcRequest;
import id.dana.data.login.source.network.request.VerifyPasswordRpcRequest;
import id.dana.data.login.source.network.result.CheckSessionResult;
import id.dana.data.login.source.network.result.LogoutRpcResult;
import id.dana.data.registration.source.network.request.Trust2RiskLoginRequest;
import id.dana.data.registration.source.network.result.Trust2RiskLoginResult;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.response.login.VerifyPasswordRpcResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/login/source/network/LoginRpcFacade;", "", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "request", "Lid/dana/data/login/source/network/result/CheckSessionResult;", "checkSession", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/login/source/network/result/CheckSessionResult;", "Lid/dana/data/registration/source/network/request/Trust2RiskLoginRequest;", "Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;", "consultTrust2RiskLogin", "(Lid/dana/data/registration/source/network/request/Trust2RiskLoginRequest;)Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;", "Lid/dana/data/login/source/network/request/LoginRpcRequest;", "Lid/dana/network/response/login/LoginRpcResult;", "holdLogin", "(Lid/dana/data/login/source/network/request/LoginRpcRequest;)Lid/dana/network/response/login/LoginRpcResult;", "login", "Lid/dana/data/login/source/network/request/LogoutRpcRequest;", "Lid/dana/data/login/source/network/result/LogoutRpcResult;", "logout", "(Lid/dana/data/login/source/network/request/LogoutRpcRequest;)Lid/dana/data/login/source/network/result/LogoutRpcResult;", "newCheckSession", "trust2RiskLogin", "(Lid/dana/data/registration/source/network/request/Trust2RiskLoginRequest;)Lid/dana/network/response/login/LoginRpcResult;", "Lid/dana/data/login/source/network/request/VerifyPasswordRpcRequest;", "Lid/dana/network/response/login/VerifyPasswordRpcResult;", "verifyPasswordTrustRiskV2", "(Lid/dana/data/login/source/network/request/VerifyPasswordRpcRequest;)Lid/dana/network/response/login/VerifyPasswordRpcResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LoginRpcFacade {
    public static final String CHECK_SESSION_OPERATION_TYPE = "id.dana.userprod.session.checkSession";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String NEW_CHECK_SESSION_OPERATION_TYPE = "id.dana.authprod.check.session";
    public static final String V1_OPERATION_TYPE = "alipayplus.mobilewallet.user.login";
    public static final String V2_OPERATION_TYPE = "id.dana.userprod.user.hold.login";

    @OperationType("id.dana.userprod.session.checkSession")
    @SignCheck
    CheckSessionResult checkSession(BaseRpcRequest request);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.TRUST_RISK_LOGIN_V2)
    @SignCheck
    Trust2RiskLoginResult consultTrust2RiskLogin(Trust2RiskLoginRequest request);

    @OperationType("id.dana.userprod.user.hold.login")
    @SignCheck
    LoginRpcResult holdLogin(LoginRpcRequest request);

    @OperationType("alipayplus.mobilewallet.user.login")
    @SignCheck
    LoginRpcResult login(LoginRpcRequest request);

    @OperationType("alipayplus.mobilewallet.user.logout")
    @SignCheck
    LogoutRpcResult logout(LogoutRpcRequest request);

    @OperationType("id.dana.authprod.check.session")
    @SignCheck
    CheckSessionResult newCheckSession(BaseRpcRequest request);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.TRUST_RISK_LOGIN_V2)
    @SignCheck
    LoginRpcResult trust2RiskLogin(Trust2RiskLoginRequest request);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.PASSWORD_VERIFY)
    @SignCheck
    VerifyPasswordRpcResult verifyPasswordTrustRiskV2(VerifyPasswordRpcRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/data/login/source/network/LoginRpcFacade$Companion;", "", "", "CHECK_SESSION_OPERATION_TYPE", "Ljava/lang/String;", "NEW_CHECK_SESSION_OPERATION_TYPE", "V1_OPERATION_TYPE", "V2_OPERATION_TYPE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CHECK_SESSION_OPERATION_TYPE = "id.dana.userprod.session.checkSession";
        public static final String NEW_CHECK_SESSION_OPERATION_TYPE = "id.dana.authprod.check.session";
        public static final String V1_OPERATION_TYPE = "alipayplus.mobilewallet.user.login";
        public static final String V2_OPERATION_TYPE = "id.dana.userprod.user.hold.login";

        private Companion() {
        }
    }
}
