package id.dana.sendmoney.mapper;

import id.dana.domain.model.cashier.PayMethodRisk;
import id.dana.sendmoney.model.PayMethodRiskModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PayMethodRiskMapper {
    @Inject
    public PayMethodRiskMapper() {
    }

    public static PayMethodRiskModel KClassImpl$Data$declaredNonStaticMembers$2(PayMethodRisk payMethodRisk) {
        if (payMethodRisk != null) {
            return new PayMethodRiskModel(payMethodRisk.getMaskPhoneNumber(), payMethodRisk.getResult(), payMethodRisk.getRiskInfo(), payMethodRisk.getVerificationMethod(), payMethodRisk.getVerificationPriority());
        }
        return null;
    }
}
