package id.dana.danah5;

import dagger.MembersInjector;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RequestResultBridge_MembersInjector implements MembersInjector<RequestResultBridge> {
    private final Provider<ConsultAgreement> consultAgreementProvider;
    private final Provider<GetService> getServiceProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public RequestResultBridge_MembersInjector(Provider<SplitFacade> provider, Provider<GetService> provider2, Provider<ConsultAgreement> provider3) {
        this.splitFacadeProvider = provider;
        this.getServiceProvider = provider2;
        this.consultAgreementProvider = provider3;
    }

    public static MembersInjector<RequestResultBridge> create(Provider<SplitFacade> provider, Provider<GetService> provider2, Provider<ConsultAgreement> provider3) {
        return new RequestResultBridge_MembersInjector(provider, provider2, provider3);
    }

    public final void injectMembers(RequestResultBridge requestResultBridge) {
        injectSplitFacade(requestResultBridge, this.splitFacadeProvider.get());
        injectGetService(requestResultBridge, this.getServiceProvider.get());
        injectConsultAgreement(requestResultBridge, this.consultAgreementProvider.get());
    }

    public static void injectSplitFacade(RequestResultBridge requestResultBridge, SplitFacade splitFacade) {
        requestResultBridge.splitFacade = splitFacade;
    }

    public static void injectGetService(RequestResultBridge requestResultBridge, GetService getService) {
        requestResultBridge.getService = getService;
    }

    public static void injectConsultAgreement(RequestResultBridge requestResultBridge, ConsultAgreement consultAgreement) {
        requestResultBridge.consultAgreement = consultAgreement;
    }
}
