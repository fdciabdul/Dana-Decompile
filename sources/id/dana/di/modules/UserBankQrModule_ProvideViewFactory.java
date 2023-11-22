package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.requestmoney.bank.UserBankQrContract;

/* loaded from: classes4.dex */
public final class UserBankQrModule_ProvideViewFactory implements Factory<UserBankQrContract.View> {
    private final UserBankQrModule PlaceComponentResult;

    public static UserBankQrContract.View PlaceComponentResult(UserBankQrModule userBankQrModule) {
        return (UserBankQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(userBankQrModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserBankQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
