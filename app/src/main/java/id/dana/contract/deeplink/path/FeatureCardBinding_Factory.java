package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureCardBinding_Factory implements Factory<FeatureCardBinding> {
    private final Provider<GetIsCardBindingV2Enabled> KClassImpl$Data$declaredNonStaticMembers$2;

    private FeatureCardBinding_Factory(Provider<GetIsCardBindingV2Enabled> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static FeatureCardBinding_Factory MyBillsEntityDataFactory(Provider<GetIsCardBindingV2Enabled> provider) {
        return new FeatureCardBinding_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureCardBinding(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
