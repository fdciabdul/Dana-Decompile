package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetListHighlightMyBills_Factory implements Factory<GetListHighlightMyBills> {
    private final Provider<MyBillsRepository> repositoryProvider;

    public GetListHighlightMyBills_Factory(Provider<MyBillsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetListHighlightMyBills get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetListHighlightMyBills_Factory create(Provider<MyBillsRepository> provider) {
        return new GetListHighlightMyBills_Factory(provider);
    }

    public static GetListHighlightMyBills newInstance(MyBillsRepository myBillsRepository) {
        return new GetListHighlightMyBills(myBillsRepository);
    }
}
