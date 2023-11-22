package id.dana.sendmoney.confirmation;

import id.dana.di.PerActivity;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.sendmoney.mapper.PayMethodRiskMapper;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes5.dex */
public class SendMoneyConfirmationData {
    final SaveLastCardUsed BuiltInFictitiousFunctionClassFactory;
    final GetCheckoutH5Event KClassImpl$Data$declaredNonStaticMembers$2;
    private final PayMethodRiskMapper getAuthRequestContext;

    @Inject
    public SendMoneyConfirmationData(PayMethodRiskMapper payMethodRiskMapper, GetCheckoutH5Event getCheckoutH5Event, SaveLastCardUsed saveLastCardUsed) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getCheckoutH5Event;
        this.BuiltInFictitiousFunctionClassFactory = saveLastCardUsed;
        this.getAuthRequestContext = payMethodRiskMapper;
    }
}
