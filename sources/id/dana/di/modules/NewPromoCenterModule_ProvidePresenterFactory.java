package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.promocenter.NewPromoCenterContract;
import id.dana.animation.promocenter.NewPromoCenterPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NewPromoCenterModule_ProvidePresenterFactory implements Factory<NewPromoCenterContract.Presenter> {
    private final NewPromoCenterModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NewPromoCenterPresenter> MyBillsEntityDataFactory;

    private NewPromoCenterModule_ProvidePresenterFactory(NewPromoCenterModule newPromoCenterModule, Provider<NewPromoCenterPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = newPromoCenterModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static NewPromoCenterModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(NewPromoCenterModule newPromoCenterModule, Provider<NewPromoCenterPresenter> provider) {
        return new NewPromoCenterModule_ProvidePresenterFactory(newPromoCenterModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewPromoCenterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
