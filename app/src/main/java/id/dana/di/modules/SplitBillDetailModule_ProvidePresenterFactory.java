package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillDetailContract;
import id.dana.splitbill.SplitBillDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillDetailModule_ProvidePresenterFactory implements Factory<SplitBillDetailContract.Presenter> {
    private final SplitBillDetailModule PlaceComponentResult;
    private final Provider<SplitBillDetailPresenter> getAuthRequestContext;

    public static SplitBillDetailContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SplitBillDetailModule splitBillDetailModule, SplitBillDetailPresenter splitBillDetailPresenter) {
        return (SplitBillDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(splitBillDetailModule.MyBillsEntityDataFactory(splitBillDetailPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
