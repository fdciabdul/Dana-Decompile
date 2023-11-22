package id.dana.data.registration.source;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.data.BaseMapper;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.registration.model.LoginAuthenticationOptionResult;
import id.dana.data.registration.source.network.result.CheckUserRegistrationStatusResult;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import id.dana.domain.registration.CheckUserAction;
import id.dana.domain.transferaccount.StatusTransferAccount;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019J'\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/data/registration/source/RegistrationMapper;", "", "Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "response", "", "doWhenActionIsTrustRiskLogin", "(Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;)V", "", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "responses", "", LogConstants.KEY_AUTH_METHOD, "", "findAuthenticationMethodIndex", "(Ljava/util/List;Ljava/lang/String;)I", "", "isLoginAuthResponseEqual", "(Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;Ljava/lang/String;)Z", "Lid/dana/data/model/CurrencyAmountResult;", "prizeAmount", "Lid/dana/domain/user/CurrencyAmount;", "transform", "(Lid/dana/data/model/CurrencyAmountResult;)Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/data/registration/source/network/result/CheckUserRegistrationStatusResult;", "result", "(Lid/dana/data/registration/source/network/result/CheckUserRegistrationStatusResult;)Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "Lid/dana/data/registration/model/LoginAuthenticationOptionResult;", "loginAuthenticationOptionResults", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/registration/source/LoginAuthenticationMapper;", "loginAuthenticationMapper", "Lid/dana/data/registration/source/LoginAuthenticationMapper;", "<init>", "(Lid/dana/data/registration/source/LoginAuthenticationMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RegistrationMapper {
    private final LoginAuthenticationMapper loginAuthenticationMapper;

    @Inject
    public RegistrationMapper(LoginAuthenticationMapper loginAuthenticationMapper) {
        this.loginAuthenticationMapper = loginAuthenticationMapper;
    }

    public final CheckRegistrationResponse transform(CheckUserRegistrationStatusResult result) {
        if (result != null) {
            CheckRegistrationResponse checkRegistrationResponse = new CheckRegistrationResponse();
            checkRegistrationResponse.setUserName(result.userName);
            checkRegistrationResponse.setAction(result.action);
            checkRegistrationResponse.setExpirySeconds(result.expirySeconds);
            checkRegistrationResponse.setLocalPhoneNumber(result.localPhoneNumber);
            checkRegistrationResponse.setOtpCodeLength(result.otpCodeLength);
            checkRegistrationResponse.setRetrySendSeconds(result.retrySendSeconds);
            checkRegistrationResponse.setCampaignEnabled(result.campaignEnabled);
            checkRegistrationResponse.setPrizeName(result.prizeName);
            checkRegistrationResponse.setOtpChannel(result.otpChannel);
            checkRegistrationResponse.setPrizeAmount(transform(result.prizeAmount));
            checkRegistrationResponse.setExtendInfo(result.extendInfo);
            checkRegistrationResponse.setSecurityId(result.securityId);
            checkRegistrationResponse.setLoginAuthenticationOptionResponses(transform(result.loginAuthenticationOptions));
            checkRegistrationResponse.setChallengeContext(result.getChallengeContext());
            checkRegistrationResponse.setTransferAccountStatus(StatusTransferAccount.INSTANCE.getValue(result.transferAccountStatus));
            doWhenActionIsTrustRiskLogin(checkRegistrationResponse);
            BaseMapper.transform(checkRegistrationResponse, result);
            return checkRegistrationResponse;
        }
        return null;
    }

    private final void doWhenActionIsTrustRiskLogin(CheckRegistrationResponse response) {
        if (StringsKt.equals(CheckUserAction.TRUST_RISK_LOGIN, response.getAction(), true)) {
            response.setFaceLoginAuthMethodIndex(findAuthenticationMethodIndex(response.getLoginAuthenticationOptionResponses(), "MIC_FACE"));
            response.setPasswordAuthMethodIndex(findAuthenticationMethodIndex(response.getLoginAuthenticationOptionResponses(), "PASSWORD"));
        }
    }

    private final int findAuthenticationMethodIndex(List<? extends LoginAuthenticationOptionResponse> responses, String authMethod) {
        if (responses == null || responses.isEmpty()) {
            return -1;
        }
        for (LoginAuthenticationOptionResponse loginAuthenticationOptionResponse : responses) {
            if (isLoginAuthResponseEqual(loginAuthenticationOptionResponse, authMethod)) {
                return responses.indexOf(loginAuthenticationOptionResponse);
            }
        }
        return -1;
    }

    private final boolean isLoginAuthResponseEqual(LoginAuthenticationOptionResponse response, String authMethod) {
        return (response == null || TextUtils.isEmpty(response.getAuthenticationMethod()) || !Intrinsics.areEqual(authMethod, response.getAuthenticationMethod())) ? false : true;
    }

    private final List<LoginAuthenticationOptionResponse> transform(List<? extends LoginAuthenticationOptionResult> loginAuthenticationOptionResults) {
        ArrayList arrayList = new ArrayList();
        if (loginAuthenticationOptionResults != null && !loginAuthenticationOptionResults.isEmpty()) {
            for (LoginAuthenticationOptionResult loginAuthenticationOptionResult : loginAuthenticationOptionResults) {
                if (loginAuthenticationOptionResult != null) {
                    LoginAuthenticationMapper loginAuthenticationMapper = this.loginAuthenticationMapper;
                    Intrinsics.checkNotNull(loginAuthenticationMapper);
                    LoginAuthenticationOptionResponse apply = loginAuthenticationMapper.apply(loginAuthenticationOptionResult);
                    Intrinsics.checkNotNullExpressionValue(apply, "");
                    arrayList.add(apply);
                }
            }
        }
        return arrayList;
    }

    private final CurrencyAmount transform(CurrencyAmountResult prizeAmount) {
        if (prizeAmount != null) {
            return new CurrencyAmount(prizeAmount.getAmount(), prizeAmount.getCurrency());
        }
        return null;
    }
}
