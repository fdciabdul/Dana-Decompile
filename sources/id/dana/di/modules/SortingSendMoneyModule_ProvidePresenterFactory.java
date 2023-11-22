package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;
import id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SortingSendMoneyModule_ProvidePresenterFactory implements Factory<SortingSendMoneyContract.Presenter> {
    private final Provider<SortingSendMoneyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SortingSendMoneyModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SortingSendMoneyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
