package id.dana.myprofile;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.zendesk.interactor.CreateZendeskTicket;
import id.dana.social.contract.AccountDeactivationContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class AccountDeactivationPresenter_Factory implements Factory<AccountDeactivationPresenter> {
    private final Provider<CreateZendeskTicket> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPhoneNumber> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserId> MyBillsEntityDataFactory;
    private final Provider<AccountDeactivationContract.View> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AccountDeactivationPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
