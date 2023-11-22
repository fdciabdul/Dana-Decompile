package id.dana.myprofile.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.profilemenu.model.AuthenticationTypeOption;
import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.myprofile.model.AuthenticationTypeOptionModel;
import id.dana.myprofile.model.PaymentSecurityInitModel;
import java.util.ArrayList;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PaymentSecurityInitMapper extends BaseMapper<PaymentSecurityInit, PaymentSecurityInitModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ PaymentSecurityInitModel map(PaymentSecurityInit paymentSecurityInit) {
        AuthenticationTypeOptionModel authenticationTypeOptionModel;
        PaymentSecurityInit paymentSecurityInit2 = paymentSecurityInit;
        if (paymentSecurityInit2 != null) {
            PaymentSecurityInitModel paymentSecurityInitModel = new PaymentSecurityInitModel();
            paymentSecurityInitModel.MyBillsEntityDataFactory = paymentSecurityInit2.isAuthenticationFeatureStatus();
            paymentSecurityInitModel.getAuthRequestContext = paymentSecurityInit2.isAuthenticationStatus();
            ArrayList arrayList = new ArrayList();
            for (AuthenticationTypeOption authenticationTypeOption : paymentSecurityInit2.getAuthenticationTypeOption()) {
                if (authenticationTypeOption != null) {
                    authenticationTypeOptionModel = new AuthenticationTypeOptionModel();
                    authenticationTypeOptionModel.KClassImpl$Data$declaredNonStaticMembers$2 = authenticationTypeOption.getAuthenticationType();
                } else {
                    authenticationTypeOptionModel = null;
                }
                arrayList.add(authenticationTypeOptionModel);
            }
            paymentSecurityInitModel.PlaceComponentResult = arrayList;
            return paymentSecurityInitModel;
        }
        return null;
    }

    @Inject
    public PaymentSecurityInitMapper() {
    }
}
