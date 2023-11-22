package id.dana.cardbinding.domain.interactor;

import dagger.internal.Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSupportedCardsConfig_Factory implements Factory<GetSupportedCardsConfig> {
    private final Provider<CardBindingRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetSupportedCardsConfig_Factory(Provider<CardBindingRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetSupportedCardsConfig_Factory MyBillsEntityDataFactory(Provider<CardBindingRepository> provider) {
        return new GetSupportedCardsConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSupportedCardsConfig(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
