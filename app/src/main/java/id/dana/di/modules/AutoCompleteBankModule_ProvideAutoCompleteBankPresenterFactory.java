package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.bank.AutoCompleteBankContract;
import id.dana.richview.bank.AutoCompleteBankPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AutoCompleteBankModule_ProvideAutoCompleteBankPresenterFactory implements Factory<AutoCompleteBankContract.Presenter> {
    private final AutoCompleteBankModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AutoCompleteBankPresenter> getAuthRequestContext;

    public static AutoCompleteBankContract.Presenter BuiltInFictitiousFunctionClassFactory(AutoCompleteBankModule autoCompleteBankModule, AutoCompleteBankPresenter autoCompleteBankPresenter) {
        return (AutoCompleteBankContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(autoCompleteBankModule.PlaceComponentResult(autoCompleteBankPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AutoCompleteBankContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
