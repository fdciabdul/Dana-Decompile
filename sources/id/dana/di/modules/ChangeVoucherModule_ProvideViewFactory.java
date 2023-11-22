package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;

/* loaded from: classes4.dex */
public final class ChangeVoucherModule_ProvideViewFactory implements Factory<ChangeVoucherContract.View> {
    private final ChangeVoucherModule BuiltInFictitiousFunctionClassFactory;

    public static ChangeVoucherContract.View BuiltInFictitiousFunctionClassFactory(ChangeVoucherModule changeVoucherModule) {
        return (ChangeVoucherContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(changeVoucherModule.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangeVoucherContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
