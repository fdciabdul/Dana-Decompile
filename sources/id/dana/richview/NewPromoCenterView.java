package id.dana.richview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.material.card.MaterialCardView;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.news.adapter.NewsWidgetAdapter;
import id.dana.animation.promocenter.NewPromoCenterContract;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.SingleItemClickAsyncListener;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.feeds.GlobalFeedsContract;
import id.dana.contract.feeds.GlobalFeedsModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.databinding.NewViewPromoCenterBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewPromoCenterComponent;
import id.dana.di.component.NewPromoCenterComponent;
import id.dana.di.modules.NewPromoCenterModule;
import id.dana.di.modules.OauthModule;
import id.dana.domain.featureconfig.model.PromoCenterConfig;
import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.feeds.model.Feeds;
import id.dana.feeds.model.FeedsModel;
import id.dana.model.ThirdPartyService;
import id.dana.news.NewsActivity;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.promocenter.views.PromoCenterActivity;
import id.dana.promocenter.views.PromoCenterSeePromosView;
import id.dana.promodiscovery.views.PromoDiscoveryActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001YB\u0011\b\u0016\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bR\u0010VB#\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010W\u001a\u00020\b¢\u0006\u0004\bR\u0010XJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010!\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0006J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0013H\u0002¢\u0006\u0004\b)\u0010\u0019J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0006J\r\u0010,\u001a\u00020\u0004¢\u0006\u0004\b,\u0010\u0006R\u0018\u0010)\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010.R\u0016\u0010+\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u00100R(\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010:\u001a\u00020/8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b9\u00100R(\u0010<\u001a\b\u0012\u0004\u0012\u00020;018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u00104\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u0016\u0010@\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010?R\u0016\u00109\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b@\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010DR(\u0010G\u001a\b\u0012\u0004\u0012\u00020F018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bG\u00104\u001a\u0004\bH\u00106\"\u0004\bI\u00108R\u0016\u0010J\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR(\u0010M\u001a\b\u0012\u0004\u0012\u00020L018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bM\u00104\u001a\u0004\bN\u00106\"\u0004\bO\u00108"}, d2 = {"Lid/dana/richview/NewPromoCenterView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/NewViewPromoCenterBinding;", "Lid/dana/home/promocenter/NewPromoCenterContract$View;", "", "dismissProgress", "()V", "disposeByActivity", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/NewViewPromoCenterBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isForRecyclerViewholder", "()Z", "notifyFinishCheckSessionWatcher", "isCacheEmpty", "onFinishCheckSessionAndLoadCache", "(Z)V", "Lid/dana/domain/featureconfig/model/PromoCenterConfig;", "promoCenterConfig", "onFinishGetPromoCenterConfig", "(Lid/dana/domain/featureconfig/model/PromoCenterConfig;)V", "", "Lid/dana/domain/feeds/model/ActivityData;", "activityData", "onGetFeedNewsModelFromCache", "(Ljava/util/List;)V", "onGetFeedNewsModelFromCacheError", "promoCenterVersion", "onGetPromoCenterVersion", "(I)V", "refreshView", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "setup", "PlaceComponentResult", "showSkeleton", "Lid/dana/di/component/NewPromoCenterComponent;", "Lid/dana/di/component/NewPromoCenterComponent;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Ldagger/Lazy;", "Lid/dana/contract/feeds/GlobalFeedsContract$Presenter;", "globalFeedPresenter", "Ldagger/Lazy;", "getGlobalFeedPresenter", "()Ldagger/Lazy;", "setGlobalFeedPresenter", "(Ldagger/Lazy;)V", "getAuthRequestContext", "MyBillsEntityDataFactory", "Lid/dana/home/tracker/HomeTrackerImpl;", "homeTrackerImpl", "getHomeTrackerImpl", "setHomeTrackerImpl", "Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/home/news/adapter/NewsWidgetAdapter;", "Lid/dana/home/news/adapter/NewsWidgetAdapter;", "scheduleImpl", "Lid/dana/domain/featureconfig/model/PromoCenterConfig;", "getErrorConfigVersion", "Lid/dana/home/promocenter/NewPromoCenterContract$Presenter;", "promoCenterPresenter", "getPromoCenterPresenter", "setPromoCenterPresenter", "moveToNextValue", "I", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "getReadDeepLinkPropertiesPresenter", "setReadDeepLinkPropertiesPresenter", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewPromoCenterView extends ViewBindingRichView<NewViewPromoCenterBinding> implements NewPromoCenterContract.View {
    public static final int MAX_NEWS_SIZE = 3;
    public static final int PROMO_CENTER_VERSION_1 = 1;
    public static final int PROMO_CENTER_VERSION_2 = 2;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private NewsWidgetAdapter getAuthRequestContext;
    private NewPromoCenterComponent KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    private SkeletonScreen PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private SkeletonScreen MyBillsEntityDataFactory;
    @Inject
    public Lazy<GlobalFeedsContract.Presenter> globalFeedPresenter;
    @Inject
    public Lazy<HomeTrackerImpl> homeTrackerImpl;
    private int moveToNextValue;
    @Inject
    public Lazy<NewPromoCenterContract.Presenter> promoCenterPresenter;
    @Inject
    public Lazy<ReadLinkPropertiesContract.Presenter> readDeepLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private PromoCenterConfig getErrorConfigVersion;

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_view_promo_center;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPromoCenterView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.moveToNextValue = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPromoCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.moveToNextValue = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPromoCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.moveToNextValue = 1;
    }

    @JvmName(name = "getGlobalFeedPresenter")
    public final Lazy<GlobalFeedsContract.Presenter> getGlobalFeedPresenter() {
        Lazy<GlobalFeedsContract.Presenter> lazy = this.globalFeedPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGlobalFeedPresenter")
    public final void setGlobalFeedPresenter(Lazy<GlobalFeedsContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.globalFeedPresenter = lazy;
    }

    @JvmName(name = "getPromoCenterPresenter")
    public final Lazy<NewPromoCenterContract.Presenter> getPromoCenterPresenter() {
        Lazy<NewPromoCenterContract.Presenter> lazy = this.promoCenterPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPromoCenterPresenter")
    public final void setPromoCenterPresenter(Lazy<NewPromoCenterContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.promoCenterPresenter = lazy;
    }

    @JvmName(name = "getReadDeepLinkPropertiesPresenter")
    public final Lazy<ReadLinkPropertiesContract.Presenter> getReadDeepLinkPropertiesPresenter() {
        Lazy<ReadLinkPropertiesContract.Presenter> lazy = this.readDeepLinkPropertiesPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReadDeepLinkPropertiesPresenter")
    public final void setReadDeepLinkPropertiesPresenter(Lazy<ReadLinkPropertiesContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.readDeepLinkPropertiesPresenter = lazy;
    }

    @JvmName(name = "getHomeTrackerImpl")
    public final Lazy<HomeTrackerImpl> getHomeTrackerImpl() {
        Lazy<HomeTrackerImpl> lazy = this.homeTrackerImpl;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomeTrackerImpl")
    public final void setHomeTrackerImpl(Lazy<HomeTrackerImpl> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.homeTrackerImpl = lazy;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return;
        }
        DaggerNewPromoCenterComponent.Builder PlaceComponentResult = DaggerNewPromoCenterComponent.PlaceComponentResult();
        PlaceComponentResult.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (NewPromoCenterModule) Preconditions.getAuthRequestContext(new NewPromoCenterModule(this));
        PlaceComponentResult.PlaceComponentResult = (GlobalFeedsModule) Preconditions.getAuthRequestContext(new GlobalFeedsModule(new GlobalFeedsContract.View() { // from class: id.dana.richview.NewPromoCenterView$injectComponent$1
            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(FeedsModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedsModel feedsModel) {
                Intrinsics.checkNotNullParameter(feedsModel, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                NewsWidgetAdapter newsWidgetAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                newsWidgetAdapter = NewPromoCenterView.this.getAuthRequestContext;
                if (newsWidgetAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    newsWidgetAdapter = null;
                }
                if (newsWidgetAdapter.MyBillsEntityDataFactory.isEmpty()) {
                    NewPromoCenterView.access$hideNewsSkeleton(NewPromoCenterView.this);
                    NewPromoCenterView.this.KClassImpl$Data$declaredNonStaticMembers$2(true);
                    NewPromoCenterView.access$stopLoadTime(NewPromoCenterView.this);
                }
            }

            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void MyBillsEntityDataFactory(Feeds p0) {
                NewsWidgetAdapter newsWidgetAdapter;
                if (p0 != null) {
                    NewPromoCenterView newPromoCenterView = NewPromoCenterView.this;
                    Intrinsics.checkNotNullExpressionValue(p0.getActivities(), "");
                    if ((!r1.isEmpty()) == true) {
                        NewPromoCenterView.access$hideNewsSkeleton(newPromoCenterView);
                        NewPromoCenterView.this.getPromoCenterPresenter().get().getAuthRequestContext(p0);
                        newsWidgetAdapter = newPromoCenterView.getAuthRequestContext;
                        if (newsWidgetAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            newsWidgetAdapter = null;
                        }
                        List<ActivityData> activities = p0.getActivities();
                        Intrinsics.checkNotNullExpressionValue(activities, "");
                        newsWidgetAdapter.getAuthRequestContext(CollectionsKt.take(activities, 3));
                        NewPromoCenterView.access$stopLoadTime(newPromoCenterView);
                    }
                }
            }

            @Override // id.dana.contract.feeds.GlobalFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Feeds feeds) {
                NewsWidgetAdapter newsWidgetAdapter;
                if (feeds == null) {
                    return;
                }
                NewsWidgetAdapter newsWidgetAdapter2 = null;
                if (feeds.getActivities() == null || feeds.getActivities().isEmpty()) {
                    NewPromoCenterView.this.getGlobalFeedPresenter().get().getAuthRequestContext(3);
                    return;
                }
                NewPromoCenterView.access$hideNewsSkeleton(NewPromoCenterView.this);
                newsWidgetAdapter = NewPromoCenterView.this.getAuthRequestContext;
                if (newsWidgetAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    newsWidgetAdapter2 = newsWidgetAdapter;
                }
                List<ActivityData> activities = feeds.getActivities();
                Intrinsics.checkNotNullExpressionValue(activities, "");
                newsWidgetAdapter2.getAuthRequestContext(CollectionsKt.take(activities, 3));
                NewPromoCenterView.access$stopLoadTime(NewPromoCenterView.this);
            }
        }));
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.richview.NewPromoCenterView$injectComponent$2
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = TrackerKey.SourceType.DANA_NEWS;
        byte b = 0;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
        PlaceComponentResult.moveToNextValue = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
        PlaceComponentResult.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        PlaceComponentResult.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        PlaceComponentResult.lookAheadTest = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, NewPromoCenterModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, GlobalFeedsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.moveToNextValue, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getErrorConfigVersion, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.lookAheadTest, OauthModule.class);
        if (PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, ApplicationComponent.class);
        DaggerNewPromoCenterComponent.NewPromoCenterComponentImpl newPromoCenterComponentImpl = new DaggerNewPromoCenterComponent.NewPromoCenterComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.moveToNextValue, PlaceComponentResult.getErrorConfigVersion, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.lookAheadTest, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult.MyBillsEntityDataFactory, (byte) 0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newPromoCenterComponentImpl;
        newPromoCenterComponentImpl.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getGlobalFeedPresenter().get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final NewViewPromoCenterBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        NewViewPromoCenterBinding authRequestContext = NewViewPromoCenterBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.PROMO_CENTER);
        RecyclerView recyclerView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        this.getAuthRequestContext = new NewsWidgetAdapter(recyclerView);
        RecyclerView recyclerView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        NewsWidgetAdapter newsWidgetAdapter = this.getAuthRequestContext;
        NewsWidgetAdapter newsWidgetAdapter2 = null;
        if (newsWidgetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newsWidgetAdapter = null;
        }
        recyclerView2.setAdapter(newsWidgetAdapter);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        NewsWidgetAdapter newsWidgetAdapter3 = this.getAuthRequestContext;
        if (newsWidgetAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            newsWidgetAdapter2 = newsWidgetAdapter3;
        }
        final BaseActivity baseActivity = getBaseActivity();
        newsWidgetAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = new SingleItemClickAsyncListener(baseActivity) { // from class: id.dana.richview.NewPromoCenterView$generateLatestNewsOnClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(baseActivity);
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            }

            @Override // id.dana.base.SingleItemClickAsyncListener
            public final void BuiltInFictitiousFunctionClassFactory(int p0) {
                NewPromoCenterView.access$onNewsItemClicked(NewPromoCenterView.this, p0);
            }
        };
        getPromoCenterPresenter().get().MyBillsEntityDataFactory();
        getPromoCenterPresenter().get().BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult();
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.NewPromoCenterView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewPromoCenterView.m2810$r8$lambda$hA4sWeyXG8UeuDcj7EKlqYPW9A(NewPromoCenterView.this, view);
            }
        });
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.NewPromoCenterView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewPromoCenterView.$r8$lambda$S1EVbES1ztEdQ4NV4RoB8U1fYxA(NewPromoCenterView.this, view);
            }
        });
    }

    public final void refreshView() {
        if (isInflated()) {
            getPromoCenterPresenter().get().PlaceComponentResult();
            getPromoCenterPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
            getGlobalFeedPresenter().get().PlaceComponentResult(Boolean.TRUE);
        }
    }

    private final void PlaceComponentResult() {
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        NewsWidgetAdapter newsWidgetAdapter = null;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.MyBillsEntityDataFactory();
            return;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0);
        NewsWidgetAdapter newsWidgetAdapter2 = this.getAuthRequestContext;
        if (newsWidgetAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            newsWidgetAdapter = newsWidgetAdapter2;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = newsWidgetAdapter;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 3;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.dana_info_view_news_skeleton;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen, "");
        this.PlaceComponentResult = recyclerViewSkeletonScreen;
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.View
    public final void onGetPromoCenterVersion(int promoCenterVersion) {
        this.moveToNextValue = promoCenterVersion;
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.View
    public final void onGetFeedNewsModelFromCache(List<? extends ActivityData> activityData) {
        Intrinsics.checkNotNullParameter(activityData, "");
        if ((!activityData.isEmpty()) == false) {
            PlaceComponentResult();
            return;
        }
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        NewsWidgetAdapter newsWidgetAdapter = null;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.PlaceComponentResult();
        }
        NewsWidgetAdapter newsWidgetAdapter2 = this.getAuthRequestContext;
        if (newsWidgetAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            newsWidgetAdapter = newsWidgetAdapter2;
        }
        newsWidgetAdapter.getAuthRequestContext(CollectionsKt.take(activityData, 3));
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        getHomeTrackerImpl().get().BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.View
    public final void onGetFeedNewsModelFromCacheError() {
        NewsWidgetAdapter newsWidgetAdapter = this.getAuthRequestContext;
        SkeletonScreen skeletonScreen = null;
        if (newsWidgetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newsWidgetAdapter = null;
        }
        if (newsWidgetAdapter.MyBillsEntityDataFactory.isEmpty()) {
            PlaceComponentResult();
        } else {
            SkeletonScreen skeletonScreen2 = this.PlaceComponentResult;
            if (skeletonScreen2 != null) {
                if (skeletonScreen2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    skeletonScreen = skeletonScreen2;
                }
                skeletonScreen.PlaceComponentResult();
            }
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        getHomeTrackerImpl().get().BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.View
    public final void onFinishCheckSessionAndLoadCache(boolean isCacheEmpty) {
        getGlobalFeedPresenter().get().PlaceComponentResult(!isCacheEmpty);
        getGlobalFeedPresenter().get().PlaceComponentResult(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        DanaButtonSecondaryView danaButtonSecondaryView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        boolean z = !p0;
        danaButtonSecondaryView.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(z ? 0 : 8);
        MaterialCardView materialCardView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        materialCardView.setVisibility(p0 ? 0 : 8);
    }

    public final void disposeByActivity() {
        getGlobalFeedPresenter().get().onDestroy();
    }

    public final void notifyFinishCheckSessionWatcher() {
        getPromoCenterPresenter().get().getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$S1EVbES1ztEdQ4NV4RoB8U1fYxA(NewPromoCenterView newPromoCenterView, View view) {
        Intrinsics.checkNotNullParameter(newPromoCenterView, "");
        newPromoCenterView.KClassImpl$Data$declaredNonStaticMembers$2(false);
        newPromoCenterView.PlaceComponentResult();
        newPromoCenterView.getGlobalFeedPresenter().get().getAuthRequestContext(3);
    }

    /* renamed from: $r8$lambda$hA4sWeyXG8UeuDcj7EKlqYPW9-A  reason: not valid java name */
    public static /* synthetic */ void m2810$r8$lambda$hA4sWeyXG8UeuDcj7EKlqYPW9A(NewPromoCenterView newPromoCenterView, View view) {
        Intrinsics.checkNotNullParameter(newPromoCenterView, "");
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        NewsActivity.Companion companion = NewsActivity.INSTANCE;
        Context context = newPromoCenterView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        NewsActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context);
    }

    public static /* synthetic */ void $r8$lambda$sdBeiDOExx1jJPvUQUpZ8dU1hXU(PromoCenterConfig promoCenterConfig, NewPromoCenterView newPromoCenterView, View view) {
        Unit unit;
        Context context;
        Context context2;
        Intrinsics.checkNotNullParameter(promoCenterConfig, "");
        Intrinsics.checkNotNullParameter(newPromoCenterView, "");
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        if (!promoCenterConfig.isRedirectNative) {
            String str = promoCenterConfig.redirectUrl;
            if (str != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("entryPoint", TopupSource.PROMOTION_CENTER);
                if (UrlUtil.getErrorConfigVersion(str)) {
                    newPromoCenterView.getReadDeepLinkPropertiesPresenter().get().MyBillsEntityDataFactory(str);
                } else {
                    String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(UrlUtil.getAuthRequestContext(str, hashMap), TopupSource.PROMOTION_CENTER);
                    Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                    DanaH5.startContainerFullUrl(BuiltInFictitiousFunctionClassFactory, new DanaH5Listener() { // from class: id.dana.richview.NewPromoCenterView$createH5AppListener$1
                        @Override // id.dana.utils.danah5.DanaH5Listener
                        public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                            DanaH5Listener.CC.getAuthRequestContext();
                        }

                        @Override // id.dana.utils.danah5.DanaH5Listener
                        public final void onContainerDestroyed(Bundle p0) {
                            DanaH5.dispose();
                        }
                    });
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                int i = newPromoCenterView.moveToNextValue;
                if (i == 1) {
                    Context context3 = newPromoCenterView.getContext();
                    if (context3 != null) {
                        context3.startActivity(new Intent(context3, PromoCenterActivity.class));
                        return;
                    }
                    return;
                } else if (i != 2 || (context = newPromoCenterView.getContext()) == null) {
                    return;
                } else {
                    PromoDiscoveryActivity.Companion companion = PromoDiscoveryActivity.INSTANCE;
                    PromoDiscoveryActivity.Companion.getAuthRequestContext(context);
                    return;
                }
            }
            return;
        }
        int i2 = newPromoCenterView.moveToNextValue;
        if (i2 == 1) {
            Context context4 = newPromoCenterView.getContext();
            if (context4 != null) {
                context4.startActivity(new Intent(context4, PromoCenterActivity.class));
            }
        } else if (i2 != 2 || (context2 = newPromoCenterView.getContext()) == null) {
        } else {
            PromoDiscoveryActivity.Companion companion2 = PromoDiscoveryActivity.INSTANCE;
            PromoDiscoveryActivity.Companion.getAuthRequestContext(context2);
        }
    }

    public static final /* synthetic */ void access$hideNewsSkeleton(NewPromoCenterView newPromoCenterView) {
        SkeletonScreen skeletonScreen = newPromoCenterView.PlaceComponentResult;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$onNewsItemClicked(NewPromoCenterView newPromoCenterView, int i) {
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        NewsWidgetAdapter newsWidgetAdapter = newPromoCenterView.getAuthRequestContext;
        if (newsWidgetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newsWidgetAdapter = null;
        }
        ActivityData KClassImpl$Data$declaredNonStaticMembers$2 = newsWidgetAdapter.KClassImpl$Data$declaredNonStaticMembers$2(i);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            String activityTitle = KClassImpl$Data$declaredNonStaticMembers$2.getActivityTitle();
            Intrinsics.checkNotNullExpressionValue(activityTitle, "");
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(newPromoCenterView.getContext().getApplicationContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_NEWS_OPEN;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.NewsProperty.NEWS_TITLE, activityTitle);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
            String redirectUrl = KClassImpl$Data$declaredNonStaticMembers$2.getRedirectUrl();
            Intrinsics.checkNotNullExpressionValue(redirectUrl, "");
            if (UrlUtil.getErrorConfigVersion(redirectUrl)) {
                newPromoCenterView.getReadDeepLinkPropertiesPresenter().get().MyBillsEntityDataFactory(redirectUrl);
            } else {
                DanaH5.startContainerFullUrl(redirectUrl);
            }
        }
    }

    public static final /* synthetic */ void access$stopLoadTime(NewPromoCenterView newPromoCenterView) {
        if (newPromoCenterView.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        newPromoCenterView.getHomeTrackerImpl().get().BuiltInFictitiousFunctionClassFactory();
        newPromoCenterView.BuiltInFictitiousFunctionClassFactory = true;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.View
    public final void onFinishGetPromoCenterConfig(final PromoCenterConfig promoCenterConfig) {
        Intrinsics.checkNotNullParameter(promoCenterConfig, "");
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.PlaceComponentResult();
        }
        this.getErrorConfigVersion = promoCenterConfig;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        PromoCenterSeePromosView promoCenterSeePromosView = new PromoCenterSeePromosView(context, null, 0, 6, null);
        promoCenterSeePromosView.setButtonIcon(promoCenterConfig.buttonIconUrl);
        promoCenterSeePromosView.setButtonTitle(promoCenterConfig.buttonTitle);
        getBinding().lookAheadTest.setText(getContext().getString(R.string.promo_center_entry_title));
        getBinding().moveToNextValue.setText(getContext().getString(R.string.promo_center_entry_description));
        getBinding().getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.NewPromoCenterView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewPromoCenterView.$r8$lambda$sdBeiDOExx1jJPvUQUpZ8dU1hXU(PromoCenterConfig.this, this, view);
            }
        });
    }

    public final void showSkeleton() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.MyBillsEntityDataFactory();
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.default_home_widget_skeleton;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
        this.MyBillsEntityDataFactory = viewSkeletonScreen;
    }
}
