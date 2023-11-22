package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;

/* loaded from: classes4.dex */
public final class MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory implements Factory<MerchantAverageRatingContract.View> {
    private final MerchantAverageRatingModule getAuthRequestContext;

    private MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory(MerchantAverageRatingModule merchantAverageRatingModule) {
        this.getAuthRequestContext = merchantAverageRatingModule;
    }

    public static MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory PlaceComponentResult(MerchantAverageRatingModule merchantAverageRatingModule) {
        return new MerchantAverageRatingModule_ProvideMerchantAverageRatingViewFactory(merchantAverageRatingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantAverageRatingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
