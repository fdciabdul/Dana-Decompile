package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;

/* loaded from: classes4.dex */
public final class MerchantDetailModule_ProvideViewFactory implements Factory<MerchantDetailContract.View> {
    private final MerchantDetailModule PlaceComponentResult;

    private MerchantDetailModule_ProvideViewFactory(MerchantDetailModule merchantDetailModule) {
        this.PlaceComponentResult = merchantDetailModule;
    }

    public static MerchantDetailModule_ProvideViewFactory PlaceComponentResult(MerchantDetailModule merchantDetailModule) {
        return new MerchantDetailModule_ProvideViewFactory(merchantDetailModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
