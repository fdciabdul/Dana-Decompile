package id.dana.contract.sendmoney.v2;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;
import id.dana.domain.sendmoney.interactor.GetSortingSendMoney;
import id.dana.domain.sendmoney.interactor.SaveSortingSendMoney;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SortingSendMoneyPresenter_Factory implements Factory<SortingSendMoneyPresenter> {
    private final Provider<GetSortingSendMoney> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SortingSendMoneyContract.View> MyBillsEntityDataFactory;
    private final Provider<SaveSortingSendMoney> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SortingSendMoneyPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
