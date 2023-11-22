package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetInquirySubscriptionPaylaterWithDestination_Factory implements Factory<GetInquirySubscriptionPaylaterWithDestination> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    private GetInquirySubscriptionPaylaterWithDestination_Factory(Provider<MyBillsRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetInquirySubscriptionPaylaterWithDestination_Factory BuiltInFictitiousFunctionClassFactory(Provider<MyBillsRepository> provider) {
        return new GetInquirySubscriptionPaylaterWithDestination_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetInquirySubscriptionPaylaterWithDestination(this.getAuthRequestContext.get());
    }
}
