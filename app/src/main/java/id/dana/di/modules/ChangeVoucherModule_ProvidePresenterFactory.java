package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;
import id.dana.contract.sendmoney.voucher.ChangeVoucherPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangeVoucherModule_ProvidePresenterFactory implements Factory<ChangeVoucherContract.Presenter> {
    private final Provider<ChangeVoucherPresenter> MyBillsEntityDataFactory;
    private final ChangeVoucherModule PlaceComponentResult;

    public static ChangeVoucherContract.Presenter BuiltInFictitiousFunctionClassFactory(ChangeVoucherModule changeVoucherModule, ChangeVoucherPresenter changeVoucherPresenter) {
        return (ChangeVoucherContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(changeVoucherModule.KClassImpl$Data$declaredNonStaticMembers$2(changeVoucherPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangeVoucherContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
