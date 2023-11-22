package id.dana.contract.feeds;

import id.dana.base.AbstractContract;
import id.dana.feeds.model.FeedsModel;

/* loaded from: classes8.dex */
public interface UserFeedsContract {

    /* loaded from: classes8.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory(String str);
    }

    /* loaded from: classes8.dex */
    public interface View extends AbstractContract.AbstractView {
        void onDeleteFailed(String str);

        void onDeleted(String str);

        void onDeletingFeeds(String str);

        void onGetFeeds(FeedsModel feedsModel);
    }
}
