package id.dana.data.user.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.user.source.network.request.CheckUserInfoRequest;
import id.dana.data.user.source.network.request.MiniProgramUserInfoRequest;
import id.dana.data.user.source.network.request.UserInfoRequest;
import id.dana.data.user.source.network.result.CheckUserInfoResponse;
import id.dana.data.user.source.network.result.MiniProgramUserInfoResult;
import id.dana.data.user.source.network.result.UserCohortResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;

/* loaded from: classes4.dex */
public interface UserInfoRpcFacade {
    public static final String MOBILE_WALLET_USER_INFO = "alipayplus.mobilewallet.wallet.user.info";
    public static final String MOBILE_WALLET_USER_INFO_BALANCE = "alipayplus.mobilewallet.user.information.balance";
    public static final String OMNIPROD_USER_INFO = "id.dana.omniprod.get.user.info";

    @OperationType(MOBILE_WALLET_USER_INFO_BALANCE)
    @SignCheck
    UserInfoRpcResult getBalance(UserInfoRequest userInfoRequest);

    @OperationType("alipayplus.mobilewallet.oauth.user.info")
    @SignCheck
    MiniProgramUserInfoResult getMiniProgramUserInfo(MiniProgramUserInfoRequest miniProgramUserInfoRequest);

    @OperationType("id.dana.userprod.user.query.cohort.feature")
    @SignCheck
    UserCohortResult getUserCohort(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.wallet.user.info")
    @SignCheck
    UserInfoRpcResult getUserInfo(UserInfoRequest userInfoRequest);

    @OperationType(OMNIPROD_USER_INFO)
    @SignCheck
    UserInfoRpcResult getUserInfoOmniProd(UserInfoRequest userInfoRequest);

    @OperationType("alipayplus.mobilewallet.oauth.check.user.info")
    @SignCheck
    CheckUserInfoResponse queryCheckUserInfo(CheckUserInfoRequest checkUserInfoRequest);
}
