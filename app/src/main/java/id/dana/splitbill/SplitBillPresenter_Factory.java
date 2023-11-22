package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.splitbill.SplitBillContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplitBillPresenter_Factory implements Factory<SplitBillPresenter> {
    private final Provider<SplitBillContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetAccount> KClassImpl$Data$declaredNonStaticMembers$2;

    private SplitBillPresenter_Factory(Provider<SplitBillContract.View> provider, Provider<GetAccount> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static SplitBillPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<SplitBillContract.View> provider, Provider<GetAccount> provider2) {
        return new SplitBillPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
