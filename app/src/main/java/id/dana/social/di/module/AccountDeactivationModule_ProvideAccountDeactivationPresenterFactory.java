package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.AccountDeactivationPresenter;
import id.dana.social.contract.AccountDeactivationContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AccountDeactivationModule_ProvideAccountDeactivationPresenterFactory implements Factory<AccountDeactivationContract.Presenter> {
    private final Provider<AccountDeactivationPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final AccountDeactivationModule MyBillsEntityDataFactory;

    public static AccountDeactivationContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(AccountDeactivationModule accountDeactivationModule, AccountDeactivationPresenter accountDeactivationPresenter) {
        return (AccountDeactivationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(accountDeactivationModule.PlaceComponentResult(accountDeactivationPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AccountDeactivationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
