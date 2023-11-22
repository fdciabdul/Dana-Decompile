package id.dana.data.sendmoney.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.sendmoney.model.KycResult;
import id.dana.data.sendmoney.model.PayOptionDTOResult;
import id.dana.domain.user.CurrencyAmount;
import java.util.List;

/* loaded from: classes4.dex */
public class SendMoneyInitResult extends BaseRpcResult {
    public String avatarUrl;
    public KycResult kyc;
    public List<PayOptionDTOResult> payOptions;
    public String payeeMaskedNickname;
    public String payeeMaskedPhoneNumber;
    public String payeeUserId;
    public CurrencyAmount payerAccountBalance;
    public CurrencyAmount payerMaxAmount;
    public CurrencyAmount payerMinAmount;
}
