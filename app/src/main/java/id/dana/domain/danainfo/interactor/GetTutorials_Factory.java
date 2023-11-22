package id.dana.domain.danainfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.danainfo.repository.DanaTutorialsRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTutorials_Factory implements Factory<GetTutorials> {
    private final Provider<DanaTutorialsRepository> repositoryProvider;

    public GetTutorials_Factory(Provider<DanaTutorialsRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTutorials get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetTutorials_Factory create(Provider<DanaTutorialsRepository> provider) {
        return new GetTutorials_Factory(provider);
    }

    public static GetTutorials newInstance(DanaTutorialsRepository danaTutorialsRepository) {
        return new GetTutorials(danaTutorialsRepository);
    }
}
