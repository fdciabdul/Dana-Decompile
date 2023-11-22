package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetHighlightPayTransaction_Factory implements Factory<GetHighlightPayTransaction> {
    private final Provider<MyBillsRepository> getAuthRequestContext;

    private GetHighlightPayTransaction_Factory(Provider<MyBillsRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetHighlightPayTransaction_Factory PlaceComponentResult(Provider<MyBillsRepository> provider) {
        return new GetHighlightPayTransaction_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetHighlightPayTransaction(this.getAuthRequestContext.get());
    }
}
