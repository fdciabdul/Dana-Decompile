package id.dana.news;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseFragment;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerLatestNewsComponent;
import id.dana.di.modules.LatestNewsModule;
import id.dana.di.modules.OauthModule;
import id.dana.domain.feeds.model.Feeds;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.model.FeedsModel;
import id.dana.news.LatestNewsContract;
import id.dana.news.adapter.LatestNewsAdapter;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\n\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u0010X\u0087\"¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0017X\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001aX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/news/LatestNewsFragment;", "Lid/dana/base/BaseFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "p0", "", "PlaceComponentResult", "(I)Z", "Z", "MyBillsEntityDataFactory", "Lid/dana/news/adapter/LatestNewsAdapter;", "Lid/dana/news/adapter/LatestNewsAdapter;", "Lid/dana/news/LatestNewsContract$Presenter;", "latestNewsPresenter", "Lid/dana/news/LatestNewsContract$Presenter;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "scheduleImpl", "Landroidx/recyclerview/widget/LinearLayoutManager;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "getErrorConfigVersion", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LatestNewsFragment extends BaseFragment {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public LatestNewsContract.Presenter latestNewsPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private LinearLayoutManager BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final LatestNewsAdapter PlaceComponentResult = new LatestNewsAdapter(CollectionsKt.emptyList());

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<RecyclerViewSkeletonScreen>() { // from class: id.dana.news.LatestNewsFragment$skeletonScreen$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RecyclerViewSkeletonScreen invoke() {
            LatestNewsAdapter latestNewsAdapter;
            if (((RecyclerView) LatestNewsFragment.this.getAuthRequestContext(R.id.UpdateFactorPayload)) != null) {
                LatestNewsFragment latestNewsFragment = LatestNewsFragment.this;
                RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) latestNewsFragment.getAuthRequestContext(R.id.UpdateFactorPayload));
                latestNewsAdapter = latestNewsFragment.PlaceComponentResult;
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = latestNewsAdapter;
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 15;
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.latest_news_item_skeleton;
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
                BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
                RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
                return recyclerViewSkeletonScreen;
            }
            return null;
        }
    });

    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(int i) {
        if (i < 2) {
            return 2;
        }
        return i - 2;
    }

    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_latest_news;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean PlaceComponentResult(int p0) {
        LinearLayoutManager linearLayoutManager = this.BuiltInFictitiousFunctionClassFactory;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        return linearLayoutManager.findLastCompletelyVisibleItemPosition() >= p0;
    }

    public static final /* synthetic */ void getAuthRequestContext(LatestNewsFragment latestNewsFragment) {
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) latestNewsFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory.setAdapter(recyclerViewSkeletonScreen.getAuthRequestContext);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(LatestNewsFragment latestNewsFragment, String str) {
        if (!UrlUtil.getErrorConfigVersion(str)) {
            DanaH5.startContainerFullUrl(str);
            return;
        }
        ReadLinkPropertiesContract.Presenter presenter = latestNewsFragment.readDeepLinkPropertiesPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory(str);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final LatestNewsFragment latestNewsFragment) {
        RecyclerView recyclerView = (RecyclerView) latestNewsFragment.getAuthRequestContext(R.id.UpdateFactorPayload);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.news.LatestNewsFragment$setRecyclerViewOnScrollListener$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    LatestNewsAdapter latestNewsAdapter;
                    boolean PlaceComponentResult;
                    LatestNewsAdapter latestNewsAdapter2;
                    boolean z;
                    LatestNewsAdapter latestNewsAdapter3;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    latestNewsAdapter = LatestNewsFragment.this.PlaceComponentResult;
                    PlaceComponentResult = LatestNewsFragment.this.PlaceComponentResult(LatestNewsFragment.BuiltInFictitiousFunctionClassFactory(latestNewsAdapter.getItemCount()));
                    if (PlaceComponentResult) {
                        latestNewsAdapter2 = LatestNewsFragment.this.PlaceComponentResult;
                        if (latestNewsAdapter2.getPlaceComponentResult()) {
                            z = LatestNewsFragment.this.MyBillsEntityDataFactory;
                            if (z) {
                                return;
                            }
                            LatestNewsContract.Presenter presenter = LatestNewsFragment.this.latestNewsPresenter;
                            if (presenter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                presenter = null;
                            }
                            latestNewsAdapter3 = LatestNewsFragment.this.PlaceComponentResult;
                            presenter.getAuthRequestContext(latestNewsAdapter3.MyBillsEntityDataFactory);
                            LatestNewsFragment.this.MyBillsEntityDataFactory = true;
                        }
                    }
                }
            });
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(LatestNewsFragment latestNewsFragment, String str) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(latestNewsFragment.getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_NEWS_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.NewsProperty.NEWS_TITLE, str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerLatestNewsComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerLatestNewsComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
        byte b = 0;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getActivity();
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (LatestNewsModule) Preconditions.getAuthRequestContext(new LatestNewsModule(new LatestNewsContract.View() { // from class: id.dana.news.LatestNewsFragment$setupInjection$component$1
            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Feeds feeds) {
            }

            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void MyBillsEntityDataFactory(Feeds p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(FeedsModel p0) {
                LatestNewsAdapter latestNewsAdapter;
                LatestNewsAdapter latestNewsAdapter2;
                LatestNewsAdapter latestNewsAdapter3;
                LatestNewsFragment.getAuthRequestContext(LatestNewsFragment.this);
                if (p0 != null) {
                    LatestNewsFragment latestNewsFragment = LatestNewsFragment.this;
                    latestNewsFragment.MyBillsEntityDataFactory = false;
                    latestNewsAdapter = latestNewsFragment.PlaceComponentResult;
                    List<ActivityModel> list = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    latestNewsAdapter.setItems(list);
                    latestNewsAdapter2 = latestNewsFragment.PlaceComponentResult;
                    String str = p0.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    Intrinsics.checkNotNullParameter(str, "");
                    latestNewsAdapter2.MyBillsEntityDataFactory = str;
                    latestNewsAdapter3 = latestNewsFragment.PlaceComponentResult;
                    latestNewsAdapter3.PlaceComponentResult = p0.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.news.LatestNewsContract.View
            public final void PlaceComponentResult(FeedsModel p0) {
                LatestNewsAdapter latestNewsAdapter;
                LatestNewsAdapter latestNewsAdapter2;
                LatestNewsAdapter latestNewsAdapter3;
                Intrinsics.checkNotNullParameter(p0, "");
                LatestNewsFragment.this.MyBillsEntityDataFactory = false;
                latestNewsAdapter = LatestNewsFragment.this.PlaceComponentResult;
                List<ActivityModel> list = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                latestNewsAdapter.appendItems(list);
                latestNewsAdapter2 = LatestNewsFragment.this.PlaceComponentResult;
                String str = p0.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(str, "");
                Intrinsics.checkNotNullParameter(str, "");
                latestNewsAdapter2.MyBillsEntityDataFactory = str;
                latestNewsAdapter3 = LatestNewsFragment.this.PlaceComponentResult;
                latestNewsAdapter3.PlaceComponentResult = p0.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedsModel feedsModel) {
                LatestNewsAdapter latestNewsAdapter;
                Intrinsics.checkNotNullParameter(feedsModel, "");
                LatestNewsFragment.this.MyBillsEntityDataFactory = false;
                if (feedsModel.KClassImpl$Data$declaredNonStaticMembers$2 == null || feedsModel.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    LatestNewsFragment.KClassImpl$Data$declaredNonStaticMembers$2(LatestNewsFragment.this);
                    LatestNewsContract.Presenter presenter = LatestNewsFragment.this.latestNewsPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    presenter.getAuthRequestContext(15);
                    return;
                }
                LatestNewsFragment.getAuthRequestContext(LatestNewsFragment.this);
                latestNewsAdapter = LatestNewsFragment.this.PlaceComponentResult;
                latestNewsAdapter.setItems(feedsModel.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, LatestNewsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.lookAheadTest, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, OauthModule.class);
        if (BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerLatestNewsComponent.LatestNewsComponentImpl(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, BuiltInFictitiousFunctionClassFactory.lookAheadTest, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory(this);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new LatestNewsAdapter.NewsActions() { // from class: id.dana.news.LatestNewsFragment$setupAdapter$1
            @Override // id.dana.news.adapter.LatestNewsAdapter.NewsActions
            public final void getAuthRequestContext(ActivityModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (str != null) {
                    LatestNewsFragment latestNewsFragment = LatestNewsFragment.this;
                    latestNewsFragment.disableClick();
                    LatestNewsFragment.MyBillsEntityDataFactory(latestNewsFragment, str);
                    String str2 = p0.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(str2, "");
                    LatestNewsFragment.getAuthRequestContext(latestNewsFragment, str2);
                }
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.UpdateFactorPayload);
        LatestNewsContract.Presenter presenter = null;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = this.BuiltInFictitiousFunctionClassFactory;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayoutManager = null;
            }
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = (RecyclerView) getAuthRequestContext(R.id.UpdateFactorPayload);
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.PlaceComponentResult);
        }
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        }
        LatestNewsContract.Presenter presenter2 = this.latestNewsPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.PlaceComponentResult(Boolean.TRUE);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
