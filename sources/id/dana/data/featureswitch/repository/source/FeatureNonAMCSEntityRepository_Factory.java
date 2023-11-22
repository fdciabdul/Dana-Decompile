package id.dana.data.featureswitch.repository.source;

import dagger.internal.Factory;
import id.dana.data.featureswitch.FeatureNonAMCSEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeatureNonAMCSEntityRepository_Factory implements Factory<FeatureNonAMCSEntityRepository> {
    private final Provider<FeatureNonAMCSEntityDataFactory> featureNonAMCSEntityDataFactoryProvider;

    public FeatureNonAMCSEntityRepository_Factory(Provider<FeatureNonAMCSEntityDataFactory> provider) {
        this.featureNonAMCSEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FeatureNonAMCSEntityRepository get() {
        return newInstance(this.featureNonAMCSEntityDataFactoryProvider.get());
    }

    public static FeatureNonAMCSEntityRepository_Factory create(Provider<FeatureNonAMCSEntityDataFactory> provider) {
        return new FeatureNonAMCSEntityRepository_Factory(provider);
    }

    public static FeatureNonAMCSEntityRepository newInstance(FeatureNonAMCSEntityDataFactory featureNonAMCSEntityDataFactory) {
        return new FeatureNonAMCSEntityRepository(featureNonAMCSEntityDataFactory);
    }
}
