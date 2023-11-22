package id.dana.data.profilemenu.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.model.CurrencyAmountResult;
import java.util.List;

/* loaded from: classes4.dex */
public class PaymentSecurityInitResult extends BaseRpcResult {
    public boolean authenticationFeatureStatus;
    public CurrencyAmountResult authenticationMinAmount;
    public List<AuthenticationTypeOptionResult> authenticationSettingOptions;
    public boolean authenticationStatus;
    public String authenticationType;
}
