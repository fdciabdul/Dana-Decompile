package id.dana.requestmoney.bank;

import dagger.internal.Factory;
import id.dana.domain.bank.interactor.AddUserBank;
import id.dana.domain.bank.interactor.DeleteUserBank;
import id.dana.domain.bank.interactor.GetUserBanks;
import id.dana.domain.bank.interactor.InitRequestMoney;
import id.dana.domain.bank.interactor.SaveUserBanks;
import id.dana.requestmoney.bank.UserBankContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class UserBankPresenter_Factory implements Factory<UserBankPresenter> {
    private final Provider<DeleteUserBank> BuiltInFictitiousFunctionClassFactory;
    private final Provider<InitRequestMoney> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SaveUserBanks> MyBillsEntityDataFactory;
    private final Provider<GetUserBanks> PlaceComponentResult;
    private final Provider<AddUserBank> getAuthRequestContext;
    private final Provider<UserBankContract.View> lookAheadTest;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserBankPresenter(this.lookAheadTest.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
