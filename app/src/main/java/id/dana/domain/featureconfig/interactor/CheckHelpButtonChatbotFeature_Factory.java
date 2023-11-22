package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckHelpButtonChatbotFeature_Factory implements Factory<CheckHelpButtonChatbotFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckHelpButtonChatbotFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckHelpButtonChatbotFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckHelpButtonChatbotFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckHelpButtonChatbotFeature_Factory(provider);
    }

    public static CheckHelpButtonChatbotFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckHelpButtonChatbotFeature(featureConfigRepository);
    }
}
