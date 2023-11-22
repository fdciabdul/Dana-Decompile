package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.requestmoney.bank.UserBankContract;

/* loaded from: classes4.dex */
public final class UserBankModule_ProvideViewFactory implements Factory<UserBankContract.View> {
    private final UserBankModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static UserBankContract.View KClassImpl$Data$declaredNonStaticMembers$2(UserBankModule userBankModule) {
        return (UserBankContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(userBankModule.PlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserBankContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
