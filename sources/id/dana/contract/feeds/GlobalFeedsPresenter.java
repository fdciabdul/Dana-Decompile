package id.dana.contract.feeds;

import dagger.Lazy;
import id.dana.contract.feeds.GlobalFeedsContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.feeds.interactor.BaseGetFeeds;
import id.dana.domain.feeds.interactor.GetGlobalFeeds;
import id.dana.domain.feeds.model.Feeds;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.feeds.mapper.FeedsModelMapper;
import id.dana.feeds.model.FeedsModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class GlobalFeedsPresenter implements GlobalFeedsContract.Presenter {
    private final Lazy<GetGlobalFeeds> BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    private final Lazy<GetDefaultFeedFromConfig> MyBillsEntityDataFactory;
    private final Lazy<SaveNewsWidgetActivitiesIntoPersistence> PlaceComponentResult;
    private final Lazy<FeedsModelMapper> getAuthRequestContext;
    private final GlobalFeedsContract.View moveToNextValue;

    @Inject
    public GlobalFeedsPresenter(GlobalFeedsContract.View view, Lazy<GetGlobalFeeds> lazy, Lazy<FeedsModelMapper> lazy2, Lazy<GetDefaultFeedFromConfig> lazy3, Lazy<SaveNewsWidgetActivitiesIntoPersistence> lazy4) {
        this.moveToNextValue = view;
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.getAuthRequestContext = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.PlaceComponentResult = lazy4;
    }

    @Override // id.dana.contract.feeds.GlobalFeedsContract.Presenter
    public final void getAuthRequestContext(int i) {
        this.moveToNextValue.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new DefaultObserver<Feeds>() { // from class: id.dana.contract.feeds.GlobalFeedsPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Feeds feeds = (Feeds) obj;
                GlobalFeedsPresenter.this.moveToNextValue.dismissProgress();
                if (!GlobalFeedsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    GlobalFeedsPresenter.this.moveToNextValue.MyBillsEntityDataFactory(feeds);
                    GlobalFeedsPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(GlobalFeedsPresenter.BuiltInFictitiousFunctionClassFactory(GlobalFeedsPresenter.this, feeds));
                    return;
                }
                GlobalFeedsPresenter.this.getAuthRequestContext(feeds);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                String message = th.getMessage() == null ? "" : th.getMessage();
                GlobalFeedsPresenter.this.moveToNextValue.dismissProgress();
                GlobalFeedsPresenter.this.moveToNextValue.onError(message);
            }
        }, BaseGetFeeds.Params.forGetFeeds(i, null));
    }

    @Override // id.dana.contract.feeds.GlobalFeedsContract.Presenter
    public final void PlaceComponentResult(final Boolean bool) {
        this.moveToNextValue.showProgress();
        this.MyBillsEntityDataFactory.get().execute(new DefaultObserver<Feeds>() { // from class: id.dana.contract.feeds.GlobalFeedsPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Feeds feeds = (Feeds) obj;
                GlobalFeedsPresenter.this.moveToNextValue.dismissProgress();
                if (!GlobalFeedsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    GlobalFeedsPresenter.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(feeds);
                    GlobalFeedsPresenter.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(GlobalFeedsPresenter.BuiltInFictitiousFunctionClassFactory(GlobalFeedsPresenter.this, feeds));
                    return;
                }
                GlobalFeedsPresenter.this.getAuthRequestContext(feeds);
                if (feeds == null || feeds.getActivities() == null || feeds.getActivities().isEmpty()) {
                    GlobalFeedsPresenter.this.getAuthRequestContext(3);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_DEFAULT_FEED_FROM_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.contract.feeds.GlobalFeedsContract.Presenter
    public final void PlaceComponentResult(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext(Feeds feeds) {
        if (feeds == null || feeds.getActivities() == null) {
            return;
        }
        this.PlaceComponentResult.get().execute(new SaveNewsWidgetActivitiesIntoPersistence.Params(feeds.getActivities()));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
    }

    static /* synthetic */ FeedsModel BuiltInFictitiousFunctionClassFactory(GlobalFeedsPresenter globalFeedsPresenter, Feeds feeds) {
        globalFeedsPresenter.getAuthRequestContext.get();
        FeedsModel PlaceComponentResult = FeedsModelMapper.PlaceComponentResult(feeds);
        if (feeds.getActivities() != null && !feeds.getActivities().isEmpty()) {
            globalFeedsPresenter.getAuthRequestContext(feeds);
        }
        return PlaceComponentResult;
    }
}
