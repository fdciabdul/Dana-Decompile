package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.splitbill.interactor.GetSplitBillHistories;
import id.dana.splitbill.SplitBillHistoryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SplitBillHistoryPresenter_Factory implements Factory<SplitBillHistoryPresenter> {
    private final Provider<GetAccount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetSplitBillHistories> PlaceComponentResult;
    private final Provider<SplitBillHistoryContract.View> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillHistoryPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
