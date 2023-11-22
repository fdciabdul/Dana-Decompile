package id.dana.contract.promocenter;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promocenter.PromoCategoryContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoCategoryModule_ProvidePresenterFactory implements Factory<PromoCategoryContract.Presenter> {
    private final PromoCategoryModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PromoCategoryPresenter> MyBillsEntityDataFactory;

    private PromoCategoryModule_ProvidePresenterFactory(PromoCategoryModule promoCategoryModule, Provider<PromoCategoryPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoCategoryModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static PromoCategoryModule_ProvidePresenterFactory PlaceComponentResult(PromoCategoryModule promoCategoryModule, Provider<PromoCategoryPresenter> provider) {
        return new PromoCategoryModule_ProvidePresenterFactory(promoCategoryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoCategoryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
