package id.dana.contract.feeds;

import id.dana.base.AbstractContract;
import id.dana.domain.feeds.model.Feeds;
import id.dana.feeds.model.FeedsModel;

/* loaded from: classes4.dex */
public interface GlobalFeedsContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void PlaceComponentResult(Boolean bool);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext(int i);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(FeedsModel feedsModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(Feeds feeds);

        void KClassImpl$Data$declaredNonStaticMembers$2(FeedsModel feedsModel);

        void MyBillsEntityDataFactory(Feeds feeds);
    }
}
