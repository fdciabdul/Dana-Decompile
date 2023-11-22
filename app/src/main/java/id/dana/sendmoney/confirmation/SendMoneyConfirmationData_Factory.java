package id.dana.sendmoney.confirmation;

import dagger.internal.Factory;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.sendmoney.mapper.PayMethodRiskMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyConfirmationData_Factory implements Factory<SendMoneyConfirmationData> {
    private final Provider<PayMethodRiskMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveLastCardUsed> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetCheckoutH5Event> MyBillsEntityDataFactory;

    private SendMoneyConfirmationData_Factory(Provider<PayMethodRiskMapper> provider, Provider<GetCheckoutH5Event> provider2, Provider<SaveLastCardUsed> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static SendMoneyConfirmationData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<PayMethodRiskMapper> provider, Provider<GetCheckoutH5Event> provider2, Provider<SaveLastCardUsed> provider3) {
        return new SendMoneyConfirmationData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyConfirmationData(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
