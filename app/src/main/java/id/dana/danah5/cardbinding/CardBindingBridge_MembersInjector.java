package id.dana.danah5.cardbinding;

import dagger.MembersInjector;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CardBindingBridge_MembersInjector implements MembersInjector<CardBindingBridge> {
    private final Provider<FeatureCardBinding> featureCardBindingProvider;

    public CardBindingBridge_MembersInjector(Provider<FeatureCardBinding> provider) {
        this.featureCardBindingProvider = provider;
    }

    public static MembersInjector<CardBindingBridge> create(Provider<FeatureCardBinding> provider) {
        return new CardBindingBridge_MembersInjector(provider);
    }

    public final void injectMembers(CardBindingBridge cardBindingBridge) {
        injectFeatureCardBinding(cardBindingBridge, this.featureCardBindingProvider.get());
    }

    public static void injectFeatureCardBinding(CardBindingBridge cardBindingBridge, FeatureCardBinding featureCardBinding) {
        cardBindingBridge.featureCardBinding = featureCardBinding;
    }
}
