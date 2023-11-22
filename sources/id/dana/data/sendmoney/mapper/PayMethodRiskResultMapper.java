package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.domain.model.cashier.PayMethodRisk;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PayMethodRiskResultMapper extends BaseMapper<PayMethodRiskResult, PayMethodRisk> {
    @Inject
    public PayMethodRiskResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public PayMethodRisk map(PayMethodRiskResult payMethodRiskResult) {
        if (payMethodRiskResult != null) {
            PayMethodRisk payMethodRisk = new PayMethodRisk();
            payMethodRisk.setMaskPhoneNumber(payMethodRiskResult.maskPhoneNumber);
            payMethodRisk.setResult(payMethodRiskResult.result);
            payMethodRisk.setRiskInfo(payMethodRiskResult.riskInfo);
            payMethodRisk.setVerificationMethod(payMethodRiskResult.verificationMethod);
            payMethodRisk.setVerificationPriority(payMethodRiskResult.verificationPriority);
            return payMethodRisk;
        }
        return null;
    }
}
