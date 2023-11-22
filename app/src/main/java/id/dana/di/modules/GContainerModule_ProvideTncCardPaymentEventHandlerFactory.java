package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideTncCardPaymentEventHandlerFactory implements Factory<TncCardPaymentEventHandler> {
    private final Provider<ConsultAgreementOnlyParamSpaceCodes> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RecordAgreementOnlyAgreementKey> PlaceComponentResult;
    private final GContainerModule getAuthRequestContext;

    private GContainerModule_ProvideTncCardPaymentEventHandlerFactory(GContainerModule gContainerModule, Provider<ConsultAgreementOnlyParamSpaceCodes> provider, Provider<RecordAgreementOnlyAgreementKey> provider2) {
        this.getAuthRequestContext = gContainerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static GContainerModule_ProvideTncCardPaymentEventHandlerFactory PlaceComponentResult(GContainerModule gContainerModule, Provider<ConsultAgreementOnlyParamSpaceCodes> provider, Provider<RecordAgreementOnlyAgreementKey> provider2) {
        return new GContainerModule_ProvideTncCardPaymentEventHandlerFactory(gContainerModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TncCardPaymentEventHandler) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get()));
    }
}
