package id.dana.cashier;

import dagger.internal.Factory;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TncCardPaymentEventHandler_Factory implements Factory<TncCardPaymentEventHandler> {
    private final Provider<RecordAgreementOnlyAgreementKey> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConsultAgreementOnlyParamSpaceCodes> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TncCardPaymentEventHandler(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
