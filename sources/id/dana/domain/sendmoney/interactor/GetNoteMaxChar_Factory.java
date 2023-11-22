package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNoteMaxChar_Factory implements Factory<GetNoteMaxChar> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetNoteMaxChar_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNoteMaxChar get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetNoteMaxChar_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetNoteMaxChar_Factory(provider);
    }

    public static GetNoteMaxChar newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetNoteMaxChar(featureConfigRepository);
    }
}
