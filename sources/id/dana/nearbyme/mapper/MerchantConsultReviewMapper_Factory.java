package id.dana.nearbyme.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantConsultReviewMapper_Factory implements Factory<MerchantConsultReviewMapper> {
    private final Provider<MerchantReviewTagMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ShopMapper> getAuthRequestContext;

    private MerchantConsultReviewMapper_Factory(Provider<ShopMapper> provider, Provider<MerchantReviewTagMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static MerchantConsultReviewMapper_Factory getAuthRequestContext(Provider<ShopMapper> provider, Provider<MerchantReviewTagMapper> provider2) {
        return new MerchantConsultReviewMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantConsultReviewMapper(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
