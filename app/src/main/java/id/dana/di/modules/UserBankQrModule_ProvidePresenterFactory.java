package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.requestmoney.bank.UserBankQrContract;
import id.dana.requestmoney.bank.UserBankQrPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserBankQrModule_ProvidePresenterFactory implements Factory<UserBankQrContract.Presenter> {
    private final Provider<UserBankQrPresenter> MyBillsEntityDataFactory;
    private final UserBankQrModule getAuthRequestContext;

    public static UserBankQrContract.Presenter BuiltInFictitiousFunctionClassFactory(UserBankQrModule userBankQrModule, UserBankQrPresenter userBankQrPresenter) {
        return (UserBankQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(userBankQrModule.KClassImpl$Data$declaredNonStaticMembers$2(userBankQrPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserBankQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
