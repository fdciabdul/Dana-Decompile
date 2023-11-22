package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetHighlightPayTransaction_Factory implements Factory<GetHighlightPayTransaction> {
    private final Provider<MyBillsRepository> repositoryProvider;

    public GetHighlightPayTransaction_Factory(Provider<MyBillsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHighlightPayTransaction get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetHighlightPayTransaction_Factory create(Provider<MyBillsRepository> provider) {
        return new GetHighlightPayTransaction_Factory(provider);
    }

    public static GetHighlightPayTransaction newInstance(MyBillsRepository myBillsRepository) {
        return new GetHighlightPayTransaction(myBillsRepository);
    }
}
