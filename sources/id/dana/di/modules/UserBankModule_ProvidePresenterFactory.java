package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.requestmoney.bank.UserBankPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserBankModule_ProvidePresenterFactory implements Factory<UserBankContract.Presenter> {
    private final Provider<UserBankPresenter> BuiltInFictitiousFunctionClassFactory;
    private final UserBankModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static UserBankContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(UserBankModule userBankModule, UserBankPresenter userBankPresenter) {
        return (UserBankContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(userBankModule.KClassImpl$Data$declaredNonStaticMembers$2(userBankPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserBankContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
