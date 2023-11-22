package id.dana.data.featureswitch;

import dagger.internal.Factory;
import id.dana.data.featureswitch.repository.source.local.DefaultFeatureNonAMCSData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeatureNonAMCSEntityDataFactory_Factory implements Factory<FeatureNonAMCSEntityDataFactory> {
    private final Provider<DefaultFeatureNonAMCSData> defaultFeatureNonAMCSDataProvider;

    public FeatureNonAMCSEntityDataFactory_Factory(Provider<DefaultFeatureNonAMCSData> provider) {
        this.defaultFeatureNonAMCSDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FeatureNonAMCSEntityDataFactory get() {
        return newInstance(this.defaultFeatureNonAMCSDataProvider.get());
    }

    public static FeatureNonAMCSEntityDataFactory_Factory create(Provider<DefaultFeatureNonAMCSData> provider) {
        return new FeatureNonAMCSEntityDataFactory_Factory(provider);
    }

    public static FeatureNonAMCSEntityDataFactory newInstance(DefaultFeatureNonAMCSData defaultFeatureNonAMCSData) {
        return new FeatureNonAMCSEntityDataFactory(defaultFeatureNonAMCSData);
    }
}
