package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetAutoCompleteByKeyword_Factory implements Factory<GetAutoCompleteByKeyword> {
    private final Provider<GlobalSearchRepository> MyBillsEntityDataFactory;

    private GetAutoCompleteByKeyword_Factory(Provider<GlobalSearchRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetAutoCompleteByKeyword_Factory getAuthRequestContext(Provider<GlobalSearchRepository> provider) {
        return new GetAutoCompleteByKeyword_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetAutoCompleteByKeyword(this.MyBillsEntityDataFactory.get());
    }
}
