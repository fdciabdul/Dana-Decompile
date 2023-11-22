package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetInquirySubscriptionPaylaterWithDestination_Factory implements Factory<GetInquirySubscriptionPaylaterWithDestination> {
    private final Provider<MyBillsRepository> myBillsRepositoryProvider;

    public GetInquirySubscriptionPaylaterWithDestination_Factory(Provider<MyBillsRepository> provider) {
        this.myBillsRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetInquirySubscriptionPaylaterWithDestination get() {
        return newInstance(this.myBillsRepositoryProvider.get());
    }

    public static GetInquirySubscriptionPaylaterWithDestination_Factory create(Provider<MyBillsRepository> provider) {
        return new GetInquirySubscriptionPaylaterWithDestination_Factory(provider);
    }

    public static GetInquirySubscriptionPaylaterWithDestination newInstance(MyBillsRepository myBillsRepository) {
        return new GetInquirySubscriptionPaylaterWithDestination(myBillsRepository);
    }
}
