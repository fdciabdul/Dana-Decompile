package id.dana.myprofile.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.domain.profilemenu.model.Risk;
import id.dana.domain.profilemenu.model.SecurityContext;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;
import id.dana.myprofile.model.RiskResultModel;
import id.dana.myprofile.model.SecurityContextModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PaymentSecuritySwitchMapper extends BaseMapper<PaymentSecuritySwitch, PaymentSecuritySwitchModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ PaymentSecuritySwitchModel map(PaymentSecuritySwitch paymentSecuritySwitch) {
        RiskResultModel riskResultModel;
        PaymentSecuritySwitch paymentSecuritySwitch2 = paymentSecuritySwitch;
        SecurityContextModel securityContextModel = null;
        if (paymentSecuritySwitch2 != null) {
            PaymentSecuritySwitchModel paymentSecuritySwitchModel = new PaymentSecuritySwitchModel();
            Risk risk = paymentSecuritySwitch2.getRisk();
            if (risk != null) {
                riskResultModel = new RiskResultModel();
                riskResultModel.BuiltInFictitiousFunctionClassFactory = risk.getSecurityId();
                riskResultModel.KClassImpl$Data$declaredNonStaticMembers$2 = risk.getResult();
                riskResultModel.getAuthRequestContext = risk.getVerificationMethod();
            } else {
                riskResultModel = null;
            }
            paymentSecuritySwitchModel.KClassImpl$Data$declaredNonStaticMembers$2 = riskResultModel;
            SecurityContext securityContext = paymentSecuritySwitch2.getSecurityContext();
            if (securityContext != null) {
                securityContextModel = new SecurityContextModel();
                securityContextModel.PlaceComponentResult = securityContext.getPubKey();
            }
            paymentSecuritySwitchModel.getAuthRequestContext = securityContextModel;
            return paymentSecuritySwitchModel;
        }
        return null;
    }

    @Inject
    public PaymentSecuritySwitchMapper() {
    }
}
