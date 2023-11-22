package id.dana.contract.feeds;

import id.dana.contract.feeds.UserFeedsContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.feeds.interactor.BaseGetFeeds;
import id.dana.domain.feeds.interactor.DeleteFeeds;
import id.dana.domain.feeds.interactor.GetUserFeeds;
import id.dana.domain.feeds.model.DeleteFeed;
import id.dana.domain.feeds.model.Feeds;
import id.dana.feeds.mapper.FeedsModelMapper;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes8.dex */
public class UserFeedsPresenter implements UserFeedsContract.Presenter {
    private final FeedsModelMapper BuiltInFictitiousFunctionClassFactory;
    private final DeleteFeeds KClassImpl$Data$declaredNonStaticMembers$2;
    private final UserFeedsContract.View MyBillsEntityDataFactory;
    private final GetUserFeeds getAuthRequestContext;

    @Inject
    public UserFeedsPresenter(UserFeedsContract.View view, GetUserFeeds getUserFeeds, DeleteFeeds deleteFeeds, FeedsModelMapper feedsModelMapper) {
        this.MyBillsEntityDataFactory = view;
        this.getAuthRequestContext = getUserFeeds;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deleteFeeds;
        this.BuiltInFictitiousFunctionClassFactory = feedsModelMapper;
    }

    @Override // id.dana.contract.feeds.UserFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        this.MyBillsEntityDataFactory.showProgress();
        this.getAuthRequestContext.execute(new DefaultObserver<Feeds>() { // from class: id.dana.contract.feeds.UserFeedsPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                UserFeedsPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                UserFeedsContract.View view = UserFeedsPresenter.this.MyBillsEntityDataFactory;
                FeedsModelMapper unused = UserFeedsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onGetFeeds(FeedsModelMapper.PlaceComponentResult((Feeds) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                UserFeedsPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                UserFeedsPresenter.this.MyBillsEntityDataFactory.onError(th.getMessage());
            }
        }, BaseGetFeeds.Params.forGetFeeds(10, str));
    }

    @Override // id.dana.contract.feeds.UserFeedsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str) {
        this.MyBillsEntityDataFactory.onDeletingFeeds(str);
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<DeleteFeed>() { // from class: id.dana.contract.feeds.UserFeedsPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                DeleteFeed deleteFeed = (DeleteFeed) obj;
                if (deleteFeed.isSuccess()) {
                    UserFeedsPresenter.this.MyBillsEntityDataFactory.onDeleted(str);
                    return;
                }
                UserFeedsPresenter.this.MyBillsEntityDataFactory.onDeleteFailed(str);
                UserFeedsPresenter.this.MyBillsEntityDataFactory.onError(deleteFeed.getErrorMessage());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                UserFeedsPresenter.this.MyBillsEntityDataFactory.onDeleteFailed(str);
                UserFeedsPresenter.this.MyBillsEntityDataFactory.onError(th.getMessage());
            }
        }, DeleteFeeds.Params.forDeleteFeeds(str));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
