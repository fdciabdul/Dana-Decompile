package id.dana.data.registration.source.network.result;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.registration.model.LoginAuthenticationOptionResult;
import id.dana.network.base.BaseRpcResultWithHeader;
import java.util.List;

/* loaded from: classes4.dex */
public class CheckUserRegistrationStatusResult extends BaseRpcResultWithHeader {
    public String action;
    public boolean campaignEnabled;
    public String localPhoneNumber;
    public List<LoginAuthenticationOptionResult> loginAuthenticationOptions;
    public String otpChannel;
    public CurrencyAmountResult prizeAmount;
    public String prizeName;
    public String securityId;
    public String transferAccountStatus;
    public String userName;
    public int expirySeconds = 0;
    public int otpCodeLength = 0;
    public int retrySendSeconds = 0;
}
