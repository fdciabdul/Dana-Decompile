package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;

/* loaded from: classes4.dex */
public final class MerchantDetailConfigModule_ProvidesViewFactory implements Factory<MerchantDetailConfigContract.View> {
    private final MerchantDetailConfigModule PlaceComponentResult;

    private MerchantDetailConfigModule_ProvidesViewFactory(MerchantDetailConfigModule merchantDetailConfigModule) {
        this.PlaceComponentResult = merchantDetailConfigModule;
    }

    public static MerchantDetailConfigModule_ProvidesViewFactory PlaceComponentResult(MerchantDetailConfigModule merchantDetailConfigModule) {
        return new MerchantDetailConfigModule_ProvidesViewFactory(merchantDetailConfigModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailConfigContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
