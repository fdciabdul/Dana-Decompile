package id.dana.cashier.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.cashier.CashierFeedContract;
import id.dana.feeds.domain.share.interactor.GetPreviewActivity;
import id.dana.feeds.domain.share.interactor.SetLastShareFeedRequest;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierFeedPresenter_Factory implements Factory<CashierFeedPresenter> {
    private final Provider<GetPreviewActivity> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SetLastShareFeedRequest> MyBillsEntityDataFactory;
    private final Provider<CashierFeedContract.View> PlaceComponentResult;

    private CashierFeedPresenter_Factory(Provider<CashierFeedContract.View> provider, Provider<GetPreviewActivity> provider2, Provider<SetLastShareFeedRequest> provider3) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static CashierFeedPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<CashierFeedContract.View> provider, Provider<GetPreviewActivity> provider2, Provider<SetLastShareFeedRequest> provider3) {
        return new CashierFeedPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierFeedPresenter(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
