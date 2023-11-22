package id.dana.richview.bank;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.withdraw.interactor.GetAvailableBanks;
import id.dana.richview.bank.AutoCompleteBankContract;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.mapper.TransferConfigModelMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class AutoCompleteBankPresenter_Factory implements Factory<AutoCompleteBankPresenter> {
    private final Provider<BankModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AutoCompleteBankContract.View> MyBillsEntityDataFactory;
    private final Provider<TransferConfigModelMapper> PlaceComponentResult;
    private final Provider<GetAvailableBanks> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AutoCompleteBankPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
