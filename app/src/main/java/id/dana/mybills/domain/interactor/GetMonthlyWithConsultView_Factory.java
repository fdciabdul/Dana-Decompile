package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetMonthlyWithConsultView_Factory implements Factory<GetMonthlyWithConsultView> {
    private final Provider<MyBillsRepository> MyBillsEntityDataFactory;

    private GetMonthlyWithConsultView_Factory(Provider<MyBillsRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetMonthlyWithConsultView_Factory getAuthRequestContext(Provider<MyBillsRepository> provider) {
        return new GetMonthlyWithConsultView_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMonthlyWithConsultView(this.MyBillsEntityDataFactory.get());
    }
}
