package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.promobanner.NewPromoBannerContract;

/* loaded from: classes4.dex */
public final class NewPromoBannerModule_ProvideViewFactory implements Factory<NewPromoBannerContract.View> {
    private final NewPromoBannerModule KClassImpl$Data$declaredNonStaticMembers$2;

    private NewPromoBannerModule_ProvideViewFactory(NewPromoBannerModule newPromoBannerModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newPromoBannerModule;
    }

    public static NewPromoBannerModule_ProvideViewFactory MyBillsEntityDataFactory(NewPromoBannerModule newPromoBannerModule) {
        return new NewPromoBannerModule_ProvideViewFactory(newPromoBannerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewPromoBannerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
