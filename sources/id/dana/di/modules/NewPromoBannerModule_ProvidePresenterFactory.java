package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.promobanner.NewPromoBannerContract;
import id.dana.animation.promobanner.NewPromoBannerPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NewPromoBannerModule_ProvidePresenterFactory implements Factory<NewPromoBannerContract.Presenter> {
    private final NewPromoBannerModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NewPromoBannerPresenter> MyBillsEntityDataFactory;

    private NewPromoBannerModule_ProvidePresenterFactory(NewPromoBannerModule newPromoBannerModule, Provider<NewPromoBannerPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newPromoBannerModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static NewPromoBannerModule_ProvidePresenterFactory PlaceComponentResult(NewPromoBannerModule newPromoBannerModule, Provider<NewPromoBannerPresenter> provider) {
        return new NewPromoBannerModule_ProvidePresenterFactory(newPromoBannerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewPromoBannerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
