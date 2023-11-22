package id.dana.cashier.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.cashier.CashierHighlightContract;
import id.dana.cashier.domain.interactor.GetCashierHighlightCache;
import id.dana.cashier.domain.interactor.GetCashierHighlightConfig;
import id.dana.cashier.domain.interactor.GetHighlightNewInstId;
import id.dana.cashier.domain.interactor.SaveHighlightNewInstId;
import id.dana.cashier.domain.interactor.SaveHighlightTimeShown;
import id.dana.cashier.domain.interactor.SaveHighlightVersion;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierHighlightPresenter_Factory implements Factory<CashierHighlightPresenter> {
    private final Provider<SaveHighlightTimeShown> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetHighlightNewInstId> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetCashierHighlightCache> MyBillsEntityDataFactory;
    private final Provider<CashierHighlightContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetCashierHighlightConfig> PlaceComponentResult;
    private final Provider<SaveHighlightNewInstId> getAuthRequestContext;
    private final Provider<SaveHighlightVersion> moveToNextValue;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierHighlightPresenter(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }
}
