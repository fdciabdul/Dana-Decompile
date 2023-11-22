package id.dana.news.presenter;

import dagger.Lazy;
import id.dana.contract.feeds.GlobalFeedsPresenter;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.feeds.interactor.BaseGetFeeds;
import id.dana.domain.feeds.interactor.GetGlobalFeeds;
import id.dana.domain.feeds.model.Feeds;
import id.dana.domain.feeds.model.GetDefaultFeedFromConfig;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.feeds.mapper.FeedsModelMapper;
import id.dana.feeds.model.FeedsModel;
import id.dana.news.LatestNewsContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BI\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0010\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\n\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/news/presenter/LatestNewsPresenter;", "Lid/dana/news/LatestNewsContract$Presenter;", "Lid/dana/contract/feeds/GlobalFeedsPresenter;", "", "p0", "", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "Ldagger/Lazy;", "Lid/dana/feeds/mapper/FeedsModelMapper;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "Lid/dana/domain/feeds/interactor/GetGlobalFeeds;", "PlaceComponentResult", "Lid/dana/news/LatestNewsContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/news/LatestNewsContract$View;", "p2", "Lid/dana/domain/feeds/model/GetDefaultFeedFromConfig;", "p3", "Lid/dana/domain/home/interactor/SaveNewsWidgetActivitiesIntoPersistence;", "p4", "<init>", "(Lid/dana/news/LatestNewsContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class LatestNewsPresenter extends GlobalFeedsPresenter implements LatestNewsContract.Presenter {
    private final Lazy<FeedsModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final LatestNewsContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<GetGlobalFeeds> PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LatestNewsPresenter(LatestNewsContract.View view, Lazy<GetGlobalFeeds> lazy, Lazy<FeedsModelMapper> lazy2, Lazy<GetDefaultFeedFromConfig> lazy3, Lazy<SaveNewsWidgetActivitiesIntoPersistence> lazy4) {
        super(view, lazy, lazy2, lazy3, lazy4);
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
    }

    @Override // id.dana.news.LatestNewsContract.Presenter
    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.PlaceComponentResult.get().execute(new DefaultObserver<Feeds>() { // from class: id.dana.news.presenter.LatestNewsPresenter$loadMoreFeedOnScroll$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                LatestNewsContract.View view;
                LatestNewsContract.View view2;
                Lazy lazy;
                Feeds feeds = (Feeds) obj;
                Intrinsics.checkNotNullParameter(feeds, "");
                view = LatestNewsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = LatestNewsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                lazy = LatestNewsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                FeedsModelMapper feedsModelMapper = (FeedsModelMapper) lazy.get();
                FeedsModel PlaceComponentResult = FeedsModelMapper.PlaceComponentResult(feeds);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                view2.PlaceComponentResult(PlaceComponentResult);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                LatestNewsContract.View view;
                LatestNewsContract.View view2;
                String str2 = "";
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.getMessage() != null) {
                    str2 = p0.getMessage();
                    Intrinsics.checkNotNull(str2);
                }
                view = LatestNewsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = LatestNewsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(str2);
            }
        }, BaseGetFeeds.Params.forGetFeeds(15, str));
    }
}
