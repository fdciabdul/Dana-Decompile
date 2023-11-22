package id.dana.animation.adapter;

import android.content.Context;
import android.content.IntentSender;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.animation.HomeRecycleFragment;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.SwipeDelegateListener;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.tracker.HomeTracker;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.animation.view.EmptySpaceView;
import id.dana.animation.view.HomePersonalizationView;
import id.dana.core.ui.scrollanimation.BaseSpringAnimationViewHolder;
import id.dana.databinding.ViewItemDanaProtectionBinding;
import id.dana.databinding.ViewItemFourKingBinding;
import id.dana.databinding.ViewItemHomeGlobalSearchBinding;
import id.dana.databinding.ViewItemHomeInvestmentBinding;
import id.dana.databinding.ViewItemHomePersonalizationBinding;
import id.dana.databinding.ViewItemMoreForYouBinding;
import id.dana.databinding.ViewItemNearbyWidgetBinding;
import id.dana.databinding.ViewItemPromoCenterWidgetBinding;
import id.dana.databinding.ViewItemPromoWidgetBinding;
import id.dana.databinding.ViewItemServicesWidgetBinding;
import id.dana.databinding.ViewItemSocialWidgetBinding;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.investment.view.HomeInvestmentView;
import id.dana.nearbyme.NewNearbyMeView;
import id.dana.nearbyme.OnRedirectListener;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.promoquest.handler.PromoQuestRedirectType;
import id.dana.richview.globalsearch.ToolbarGlobalSearchView;
import id.dana.richview.servicescard.ServiceCardListener;
import id.dana.social.v2.FeedsActivity;
import id.dana.social.view.NewSocialWidgetView;
import id.dana.tracker.constant.TrackerType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000e^_`abcdefghijkBC\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u00020&H\u0016J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020&H\u0016J\u0018\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u00022\u0006\u00100\u001a\u00020&H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020&H\u0016J\u000e\u00107\u001a\u00020,2\u0006\u0010%\u001a\u00020&J\u0016\u00108\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u00109\u001a\u00020,J\u0011\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020)H\u0096\u0001J\u000e\u0010<\u001a\u00020,2\u0006\u0010(\u001a\u00020)J\u0013\u0010=\u001a\u00020,2\b\b\u0002\u0010>\u001a\u00020?H\u0096\u0001J\t\u0010@\u001a\u00020,H\u0096\u0001J\t\u0010A\u001a\u00020,H\u0096\u0001J\t\u0010B\u001a\u00020,H\u0096\u0001J\t\u0010C\u001a\u00020,H\u0096\u0001J\t\u0010D\u001a\u00020,H\u0096\u0001J\t\u0010E\u001a\u00020,H\u0096\u0001J\t\u0010F\u001a\u00020,H\u0096\u0001J\t\u0010G\u001a\u00020,H\u0096\u0001J\t\u0010H\u001a\u00020,H\u0096\u0001J\t\u0010I\u001a\u00020,H\u0096\u0001J\t\u0010J\u001a\u00020,H\u0096\u0001J\t\u0010K\u001a\u00020,H\u0096\u0001J\t\u0010L\u001a\u00020,H\u0096\u0001J\u0011\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020)H\u0096\u0001J\t\u0010O\u001a\u00020,H\u0096\u0001J\u0011\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020RH\u0096\u0001J\t\u0010S\u001a\u00020,H\u0096\u0001J\t\u0010T\u001a\u00020,H\u0096\u0001J\t\u0010U\u001a\u00020,H\u0096\u0001J>\u0010V\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010W\u001a\u00020)2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0Y2\u0006\u0010[\u001a\u00020&2\b\u0010\\\u001a\u0004\u0018\u00010&H\u0096\u0001¢\u0006\u0002\u0010]R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lid/dana/home/adapter/HomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/home/tracker/HomeTracker;", "widgetModels", "", "Lid/dana/home/adapter/HomeViewWidgetModel;", HummerConstants.CONTEXT, "Landroid/content/Context;", "homeTabActivity", "Lid/dana/home/HomeTabActivity;", "swipeDelegateListener", "Lid/dana/home/SwipeDelegateListener;", "fragment", "Lid/dana/home/HomeRecycleFragment;", "homeTrackerImpl", "Lid/dana/home/tracker/HomeTrackerImpl;", "serviceCardListener", "Lid/dana/richview/servicescard/ServiceCardListener;", "(Ljava/util/List;Landroid/content/Context;Lid/dana/home/HomeTabActivity;Lid/dana/home/SwipeDelegateListener;Lid/dana/home/HomeRecycleFragment;Lid/dana/home/tracker/HomeTrackerImpl;Lid/dana/richview/servicescard/ServiceCardListener;)V", "checkSessionWatcher", "Lio/reactivex/subjects/BehaviorSubject;", "", "getCheckSessionWatcher", "()Lio/reactivex/subjects/BehaviorSubject;", "setCheckSessionWatcher", "(Lio/reactivex/subjects/BehaviorSubject;)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "fromRefresh", "granted", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/home/adapter/HomeAdapter$HomeAdapterListener;", "getListener", "()Lid/dana/home/adapter/HomeAdapter$HomeAdapterListener;", "setListener", "(Lid/dana/home/adapter/HomeAdapter$HomeAdapterListener;)V", "resultCode", "", "Ljava/lang/Integer;", "searchBarHint", "", "serviceInitComplete", "disableFeed", "", "dispose", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onLocationResolutionResult", "onRequestPermissionResult", "removeGlobalSearch", "saveConnectionStatus", "status", "setGlobalSearchHint", "startHomeAssetsLoadTime", "startTimeInMillis", "", "stopAllServiceLoadTime", "stopBalanceLoadTime", "stopBottomBarLoadTime", "stopDanaProtectionLoadTime", "stopFeedLoadTime", "stopFourKingLoadTime", "stopHomeInvestmentLoadTime", "stopHomePersonalizationLoadTime", "stopMoreForYouLoadTime", "stopNearbyLoadTime", "stopNotificationLoadTime", "stopPromoCarouselLoadTime", "stopWhatNewLoadTime", "trackFourKingTap", "source", "trackHomeAssetLoadTime", "trackMoreForYouArticleOpen", "moreForYouModel", "Lid/dana/richview/moreforyou/model/MoreForYouModel;", "trackPinChangeBottomSheetOpen", "trackPinChangeOpen", "trackPinCreateComplete", "trackServiceFeaturedDisplayed", "currentPromotedService", "thirdPartyServices", "", "Lid/dana/model/ThirdPartyService;", "remainingDueDays", "currentHighlightedIndex", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;)V", "DanaProtectionViewHolder", "FourKingViewHolder", "GlobalSearchViewHolder", "HomeAdapterListener", "HomeInvestmentViewHolder", "HomePersonalizationViewHolder", "HomeWidget", "MoreForYouViewHolder", "NearbyViewHolder", "PromoCenterViewHolder", "PromoViewHolder", "ServicesViewHolder", "SocialWidgetHolder", "ViewHolder", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HomeAdapter extends RecyclerView.Adapter<BaseSpringAnimationViewHolder> implements HomeTracker {
    public CompositeDisposable BuiltInFictitiousFunctionClassFactory;
    private final Context DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final HomeTabActivity NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final SwipeDelegateListener NetworkUserEntityData$$ExternalSyntheticLambda2;
    public BehaviorSubject<Boolean> PlaceComponentResult;
    public final HomeRecycleFragment getAuthRequestContext;
    public final List<HomeViewWidgetModel> getErrorConfigVersion;
    private final ServiceCardListener initRecordTimeStamp;
    public HomeAdapterListener lookAheadTest;
    public Integer moveToNextValue;
    final HomeTrackerImpl scheduleImpl;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$HomeAdapterListener;", "", "", "p0", "", "getAuthRequestContext", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/eventbus/models/TimerEventKey;", "(Lid/dana/eventbus/models/TimerEventKey;)V", "Landroid/content/IntentSender;", "PlaceComponentResult", "(Landroid/content/IntentSender;)V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface HomeAdapterListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(boolean p0);

        void PlaceComponentResult(IntentSender p0);

        void getAuthRequestContext(TimerEventKey p0);

        void getAuthRequestContext(boolean p0);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[HomeWidget.values().length];
            iArr[HomeWidget.FOUR_KINGS.ordinal()] = 1;
            iArr[HomeWidget.SERVICES.ordinal()] = 2;
            iArr[HomeWidget.SOCIAL_WIDGET.ordinal()] = 3;
            iArr[HomeWidget.PROMO_BANNER.ordinal()] = 4;
            iArr[HomeWidget.PROMO_CENTER.ordinal()] = 5;
            iArr[HomeWidget.NEARBY_ME.ordinal()] = 6;
            iArr[HomeWidget.HOME_INVESTMENT.ordinal()] = 7;
            iArr[HomeWidget.MORE_FOR_YOU.ordinal()] = 8;
            iArr[HomeWidget.DANA_PROTECTION.ordinal()] = 9;
            iArr[HomeWidget.PERSONALIZED_BACKGROUND.ordinal()] = 10;
            iArr[HomeWidget.SPACERS.ordinal()] = 11;
            iArr[HomeWidget.GLOBAL_SEARCH.ordinal()] = 12;
            iArr[HomeWidget.NO_SPACE.ordinal()] = 13;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseSpringAnimationViewHolder baseSpringAnimationViewHolder, int i) {
        BaseSpringAnimationViewHolder baseSpringAnimationViewHolder2 = baseSpringAnimationViewHolder;
        Intrinsics.checkNotNullParameter(baseSpringAnimationViewHolder2, "");
        if (!(baseSpringAnimationViewHolder2 instanceof FourKingViewHolder)) {
            if (baseSpringAnimationViewHolder2 instanceof ServicesViewHolder) {
                if (this.GetContactSyncConfig) {
                    return;
                }
                ServicesViewHolder servicesViewHolder = (ServicesViewHolder) baseSpringAnimationViewHolder2;
                servicesViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setServiceCardListener(servicesViewHolder.KClassImpl$Data$declaredNonStaticMembers$2);
                this.GetContactSyncConfig = true;
                return;
            } else if (baseSpringAnimationViewHolder2 instanceof SocialWidgetHolder) {
                final SocialWidgetHolder socialWidgetHolder = (SocialWidgetHolder) baseSpringAnimationViewHolder2;
                final SwipeDelegateListener swipeDelegateListener = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                final HomeTabActivity homeTabActivity = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                final HomeAdapterListener homeAdapterListener = this.lookAheadTest;
                final HomeRecycleFragment homeRecycleFragment = this.getAuthRequestContext;
                Intrinsics.checkNotNullParameter(swipeDelegateListener, "");
                Intrinsics.checkNotNullParameter(homeTabActivity, "");
                Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
                socialWidgetHolder.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.setWidgetListener(new NewSocialWidgetView.SocialWidgetListener() { // from class: id.dana.home.adapter.HomeAdapter$SocialWidgetHolder$setup$1
                    @Override // id.dana.social.view.NewSocialWidgetView.SocialWidgetListener
                    public final void PlaceComponentResult() {
                        if (HomeAdapter.SocialWidgetHolder.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.getIsFeedRevamp()) {
                            HomeAdapter.HomeAdapterListener homeAdapterListener2 = homeAdapterListener;
                            if (homeAdapterListener2 != null) {
                                homeAdapterListener2.getAuthRequestContext(TimerEventKey.FEED_OPEN);
                            }
                            FeedsActivity.Companion companion = FeedsActivity.INSTANCE;
                            FeedsActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(homeTabActivity, FeedsSourceType.FEED_WIDGET);
                            return;
                        }
                        swipeDelegateListener.KClassImpl$Data$declaredNonStaticMembers$2(FeedsSourceType.FEED_WIDGET, false);
                    }

                    @Override // id.dana.social.view.NewSocialWidgetView.SocialWidgetListener
                    public final void PlaceComponentResult(boolean p0) {
                        HomeAdapter.HomeAdapterListener homeAdapterListener2 = homeAdapterListener;
                        if (homeAdapterListener2 != null) {
                            homeAdapterListener2.MyBillsEntityDataFactory(p0);
                        }
                    }

                    @Override // id.dana.social.view.NewSocialWidgetView.SocialWidgetListener
                    public final void BuiltInFictitiousFunctionClassFactory() {
                        homeTabActivity.setFeedMaintenance(true);
                    }

                    @Override // id.dana.social.view.NewSocialWidgetView.SocialWidgetListener
                    public final void getAuthRequestContext() {
                        homeRecycleFragment.NetworkUserEntityData$$ExternalSyntheticLambda5();
                        homeTabActivity.showDefaultNotificationPage();
                    }
                });
                socialWidgetHolder.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.onActivityResume();
                return;
            } else if (baseSpringAnimationViewHolder2 instanceof NearbyViewHolder) {
                final NearbyViewHolder nearbyViewHolder = (NearbyViewHolder) baseSpringAnimationViewHolder2;
                final HomeAdapterListener homeAdapterListener2 = this.lookAheadTest;
                final HomeRecycleFragment homeRecycleFragment2 = this.getAuthRequestContext;
                Integer num = this.moveToNextValue;
                Intrinsics.checkNotNullParameter(homeRecycleFragment2, "");
                nearbyViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setOnNearbyMeEntryView(new NewNearbyMeView.OnNearbyMeEntryView() { // from class: id.dana.home.adapter.HomeAdapter$NearbyViewHolder$setup$1
                    @Override // id.dana.nearbyme.NewNearbyMeView.OnNearbyMeEntryView
                    public final void MyBillsEntityDataFactory(boolean p0) {
                        HomeAdapter.HomeAdapterListener homeAdapterListener3 = HomeAdapter.HomeAdapterListener.this;
                        if (homeAdapterListener3 != null) {
                            homeAdapterListener3.getAuthRequestContext(p0);
                        }
                    }

                    @Override // id.dana.nearbyme.NewNearbyMeView.OnNearbyMeEntryView
                    public final void MyBillsEntityDataFactory(IntentSender p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        HomeAdapter.HomeAdapterListener homeAdapterListener3 = HomeAdapter.HomeAdapterListener.this;
                        if (homeAdapterListener3 != null) {
                            homeAdapterListener3.PlaceComponentResult(p0);
                        }
                    }

                    @Override // id.dana.nearbyme.NewNearbyMeView.OnNearbyMeEntryView
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        HomeAdapter.HomeAdapterListener homeAdapterListener3 = HomeAdapter.HomeAdapterListener.this;
                        if (homeAdapterListener3 != null) {
                            homeAdapterListener3.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    }
                });
                nearbyViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setSource("Home");
                nearbyViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setOnRedirectToNearbyMeListener(new OnRedirectListener() { // from class: id.dana.home.adapter.HomeAdapter$NearbyViewHolder$setup$2
                    @Override // id.dana.nearbyme.OnRedirectListener
                    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TimerEventKey timerEventKey) {
                        Intrinsics.checkNotNullParameter(timerEventKey, "");
                    }

                    @Override // id.dana.nearbyme.OnRedirectListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        HomeRecycleFragment.this.BuiltInFictitiousFunctionClassFactory(TimerEventKey.NEARBY_OPEN);
                    }
                });
                nearbyViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setFinishLoaded(new Runnable() { // from class: id.dana.home.adapter.HomeAdapter$NearbyViewHolder$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeAdapter.NearbyViewHolder.getAuthRequestContext(HomeAdapter.NearbyViewHolder.this);
                    }
                });
                if (num != null) {
                    nearbyViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.onLocationResolutionResult(num.intValue());
                    return;
                }
                return;
            } else if (baseSpringAnimationViewHolder2 instanceof HomePersonalizationViewHolder) {
                final HomePersonalizationViewHolder homePersonalizationViewHolder = (HomePersonalizationViewHolder) baseSpringAnimationViewHolder2;
                Intrinsics.checkNotNullParameter(this, "");
                homePersonalizationViewHolder.PlaceComponentResult.getAuthRequestContext.setHomePersonalizationListener(new HomePersonalizationView.HomePersonalizationListener() { // from class: id.dana.home.adapter.HomeAdapter$HomePersonalizationViewHolder$setup$1
                    @Override // id.dana.home.view.HomePersonalizationView.HomePersonalizationListener
                    public final void BuiltInFictitiousFunctionClassFactory() {
                        Function0 function0;
                        function0 = HomeAdapter.HomePersonalizationViewHolder.this.MyBillsEntityDataFactory;
                        function0.invoke();
                    }

                    @Override // id.dana.home.view.HomePersonalizationView.HomePersonalizationListener
                    public final void MyBillsEntityDataFactory() {
                        List list;
                        List list2;
                        list = this.getErrorConfigVersion;
                        Iterator it = list.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            if (((HomeViewWidgetModel) it.next()).MyBillsEntityDataFactory == HomeAdapter.HomeWidget.SPACERS) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            list2 = this.getErrorConfigVersion;
                            list2.remove(i2);
                            this.notifyItemRemoved(i2);
                        }
                    }
                });
                return;
            } else if (!(baseSpringAnimationViewHolder2 instanceof HomeInvestmentViewHolder)) {
                if (baseSpringAnimationViewHolder2 instanceof GlobalSearchViewHolder) {
                    GlobalSearchViewHolder globalSearchViewHolder = (GlobalSearchViewHolder) baseSpringAnimationViewHolder2;
                    ToolbarGlobalSearchView.HomeSearchListener homeSearchListener = new ToolbarGlobalSearchView.HomeSearchListener() { // from class: id.dana.home.adapter.HomeAdapter$onBindViewHolder$1
                        @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.HomeSearchListener
                        public final void getAuthRequestContext() {
                            SwipeDelegateListener swipeDelegateListener2;
                            swipeDelegateListener2 = HomeAdapter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                            swipeDelegateListener2.MyBillsEntityDataFactory("Home");
                        }
                    };
                    String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullParameter(homeSearchListener, "");
                    Intrinsics.checkNotNullParameter(str, "");
                    globalSearchViewHolder.MyBillsEntityDataFactory.getAuthRequestContext.setHomeSearchListener(homeSearchListener);
                    String str2 = str;
                    if (str2.length() > 0) {
                        ((EditText) globalSearchViewHolder.MyBillsEntityDataFactory.getAuthRequestContext._$_findCachedViewById(R.id.et_global_search_toolbar)).setHint(str2);
                        return;
                    }
                    return;
                }
                return;
            } else {
                final HomeAdapterListener homeAdapterListener3 = this.lookAheadTest;
                ((HomeInvestmentViewHolder) baseSpringAnimationViewHolder2).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.setListener(new HomeInvestmentView.InvestmentViewListener() { // from class: id.dana.home.adapter.HomeAdapter$HomeInvestmentViewHolder$setup$1
                    @Override // id.dana.investment.view.HomeInvestmentView.InvestmentViewListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        HomeAdapter.HomeAdapterListener homeAdapterListener4 = HomeAdapter.HomeAdapterListener.this;
                        if (homeAdapterListener4 != null) {
                            homeAdapterListener4.MyBillsEntityDataFactory();
                        }
                    }
                });
                return;
            }
        }
        SwipeDelegateListener swipeDelegateListener2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullParameter(swipeDelegateListener2, "");
        ((FourKingViewHolder) baseSpringAnimationViewHolder2).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setSwipeDelegateListener(swipeDelegateListener2);
    }

    /* JADX WARN: Type inference failed for: r6v56, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, id.dana.core.ui.scrollanimation.BaseSpringAnimationViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseSpringAnimationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        DanaProtectionViewHolder danaProtectionViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == HomeWidget.FOUR_KINGS.getIndex()) {
            ViewItemFourKingBinding BuiltInFictitiousFunctionClassFactory = ViewItemFourKingBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            danaProtectionViewHolder = (BaseSpringAnimationViewHolder) new FourKingViewHolder(BuiltInFictitiousFunctionClassFactory);
        } else if (i == HomeWidget.SERVICES.getIndex()) {
            ViewItemServicesWidgetBinding BuiltInFictitiousFunctionClassFactory2 = ViewItemServicesWidgetBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            final ServicesViewHolder servicesViewHolder = new ServicesViewHolder(BuiltInFictitiousFunctionClassFactory2, this.initRecordTimeStamp);
            BehaviorSubject<Boolean> behaviorSubject = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject, "");
            Intrinsics.checkNotNullParameter(compositeDisposable, "");
            compositeDisposable.getAuthRequestContext(behaviorSubject.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$ServicesViewHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean authRequestContext;
                    authRequestContext = HomeAdapter.ServicesViewHolder.getAuthRequestContext((Boolean) obj);
                    return authRequestContext;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$ServicesViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.ServicesViewHolder.MyBillsEntityDataFactory(HomeAdapter.ServicesViewHolder.this);
                }
            }));
            danaProtectionViewHolder = servicesViewHolder;
        } else if (i == HomeWidget.SOCIAL_WIDGET.getIndex()) {
            ViewItemSocialWidgetBinding BuiltInFictitiousFunctionClassFactory3 = ViewItemSocialWidgetBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
            final SocialWidgetHolder socialWidgetHolder = new SocialWidgetHolder(BuiltInFictitiousFunctionClassFactory3);
            BehaviorSubject<Boolean> behaviorSubject2 = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable2 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject2, "");
            Intrinsics.checkNotNullParameter(compositeDisposable2, "");
            compositeDisposable2.getAuthRequestContext(behaviorSubject2.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$SocialWidgetHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean authRequestContext;
                    authRequestContext = HomeAdapter.SocialWidgetHolder.getAuthRequestContext((Boolean) obj);
                    return authRequestContext;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$SocialWidgetHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.SocialWidgetHolder.MyBillsEntityDataFactory(HomeAdapter.SocialWidgetHolder.this);
                }
            }));
            danaProtectionViewHolder = socialWidgetHolder;
        } else if (i == HomeWidget.PROMO_CENTER.getIndex()) {
            ViewItemPromoCenterWidgetBinding BuiltInFictitiousFunctionClassFactory4 = ViewItemPromoCenterWidgetBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory4, "");
            final PromoCenterViewHolder promoCenterViewHolder = new PromoCenterViewHolder(BuiltInFictitiousFunctionClassFactory4);
            BehaviorSubject<Boolean> behaviorSubject3 = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable3 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject3, "");
            Intrinsics.checkNotNullParameter(compositeDisposable3, "");
            compositeDisposable3.getAuthRequestContext(behaviorSubject3.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$PromoCenterViewHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean PlaceComponentResult;
                    PlaceComponentResult = HomeAdapter.PromoCenterViewHolder.PlaceComponentResult((Boolean) obj);
                    return PlaceComponentResult;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$PromoCenterViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.PromoCenterViewHolder.PlaceComponentResult(HomeAdapter.PromoCenterViewHolder.this);
                }
            }));
            danaProtectionViewHolder = promoCenterViewHolder;
        } else if (i == HomeWidget.PROMO_BANNER.getIndex()) {
            ViewItemPromoWidgetBinding MyBillsEntityDataFactory = ViewItemPromoWidgetBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            final PromoViewHolder promoViewHolder = new PromoViewHolder(MyBillsEntityDataFactory);
            BehaviorSubject<Boolean> behaviorSubject4 = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable4 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject4, "");
            Intrinsics.checkNotNullParameter(compositeDisposable4, "");
            compositeDisposable4.getAuthRequestContext(behaviorSubject4.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$PromoViewHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean authRequestContext;
                    authRequestContext = HomeAdapter.PromoViewHolder.getAuthRequestContext((Boolean) obj);
                    return authRequestContext;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$PromoViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.PromoViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(HomeAdapter.PromoViewHolder.this);
                }
            }));
            danaProtectionViewHolder = promoViewHolder;
        } else if (i == HomeWidget.NEARBY_ME.getIndex()) {
            ViewItemNearbyWidgetBinding BuiltInFictitiousFunctionClassFactory5 = ViewItemNearbyWidgetBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory5, "");
            final NearbyViewHolder nearbyViewHolder = new NearbyViewHolder(BuiltInFictitiousFunctionClassFactory5, new Function0<Unit>() { // from class: id.dana.home.adapter.HomeAdapter$onCreateViewHolder$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HomeTrackerImpl homeTrackerImpl = HomeAdapter.this.scheduleImpl;
                    AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.NEARBY_ME);
                    if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                        homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.NEARBY_LOAD_TIME, System.currentTimeMillis());
                    }
                }
            });
            BehaviorSubject<Boolean> behaviorSubject5 = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable5 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject5, "");
            Intrinsics.checkNotNullParameter(compositeDisposable5, "");
            compositeDisposable5.getAuthRequestContext(behaviorSubject5.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$NearbyViewHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean MyBillsEntityDataFactory2;
                    MyBillsEntityDataFactory2 = HomeAdapter.NearbyViewHolder.MyBillsEntityDataFactory((Boolean) obj);
                    return MyBillsEntityDataFactory2;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$NearbyViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.NearbyViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(HomeAdapter.NearbyViewHolder.this);
                }
            }));
            danaProtectionViewHolder = nearbyViewHolder;
        } else if (i == HomeWidget.HOME_INVESTMENT.getIndex()) {
            ViewItemHomeInvestmentBinding MyBillsEntityDataFactory2 = ViewItemHomeInvestmentBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            danaProtectionViewHolder = (BaseSpringAnimationViewHolder) new HomeInvestmentViewHolder(MyBillsEntityDataFactory2);
        } else if (i == HomeWidget.MORE_FOR_YOU.getIndex()) {
            ViewItemMoreForYouBinding MyBillsEntityDataFactory3 = ViewItemMoreForYouBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory3, "");
            final MoreForYouViewHolder moreForYouViewHolder = new MoreForYouViewHolder(MyBillsEntityDataFactory3, new Function0<Unit>() { // from class: id.dana.home.adapter.HomeAdapter$onCreateViewHolder$7
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HomeTrackerImpl homeTrackerImpl = HomeAdapter.this.scheduleImpl;
                    AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.MORE_FOR_YOU);
                    if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                        homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.MORE_FOR_YOU_LOAD_TIME, System.currentTimeMillis());
                    }
                }
            });
            BehaviorSubject<Boolean> behaviorSubject6 = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable6 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject6, "");
            Intrinsics.checkNotNullParameter(compositeDisposable6, "");
            compositeDisposable6.getAuthRequestContext(behaviorSubject6.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$MoreForYouViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean MyBillsEntityDataFactory4;
                    MyBillsEntityDataFactory4 = HomeAdapter.MoreForYouViewHolder.MyBillsEntityDataFactory((Boolean) obj);
                    return MyBillsEntityDataFactory4;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$MoreForYouViewHolder$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.MoreForYouViewHolder.getAuthRequestContext(HomeAdapter.MoreForYouViewHolder.this);
                }
            }));
            danaProtectionViewHolder = moreForYouViewHolder;
        } else if (i == HomeWidget.DANA_PROTECTION.getIndex()) {
            ViewItemDanaProtectionBinding authRequestContext = ViewItemDanaProtectionBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            final DanaProtectionViewHolder danaProtectionViewHolder2 = new DanaProtectionViewHolder(authRequestContext);
            BehaviorSubject<Boolean> behaviorSubject7 = this.PlaceComponentResult;
            CompositeDisposable compositeDisposable7 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(behaviorSubject7, "");
            Intrinsics.checkNotNullParameter(compositeDisposable7, "");
            compositeDisposable7.getAuthRequestContext(behaviorSubject7.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.adapter.HomeAdapter$DanaProtectionViewHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$2;
                    KClassImpl$Data$declaredNonStaticMembers$2 = HomeAdapter.DanaProtectionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2((Boolean) obj);
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }).subscribe(new Consumer() { // from class: id.dana.home.adapter.HomeAdapter$DanaProtectionViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    HomeAdapter.DanaProtectionViewHolder.getAuthRequestContext(HomeAdapter.DanaProtectionViewHolder.this);
                }
            }));
            HomeTrackerImpl homeTrackerImpl = this.scheduleImpl;
            AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeWidget.DANA_PROTECTION);
            if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
                homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.DANA_PROTECTION_LOAD_TIME, System.currentTimeMillis());
            }
            danaProtectionViewHolder = danaProtectionViewHolder2;
        } else if (i == HomeWidget.PERSONALIZED_BACKGROUND.getIndex()) {
            ViewItemHomePersonalizationBinding authRequestContext2 = ViewItemHomePersonalizationBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
            danaProtectionViewHolder = (BaseSpringAnimationViewHolder) new HomePersonalizationViewHolder(authRequestContext2, new Function0<Unit>() { // from class: id.dana.home.adapter.HomeAdapter$onCreateViewHolder$10
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HomeTrackerImpl homeTrackerImpl2 = HomeAdapter.this.scheduleImpl;
                    AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.PERSONALIZED_BACKGROUND);
                    if (homeTrackerImpl2.MyBillsEntityDataFactory.get()) {
                        homeTrackerImpl2.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.HOME_PERSONALIZATION_LOAD_TIME, System.currentTimeMillis());
                    }
                }
            });
        } else if (i == HomeWidget.GLOBAL_SEARCH.getIndex()) {
            ViewItemHomeGlobalSearchBinding BuiltInFictitiousFunctionClassFactory6 = ViewItemHomeGlobalSearchBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory6, "");
            danaProtectionViewHolder = (BaseSpringAnimationViewHolder) new GlobalSearchViewHolder(BuiltInFictitiousFunctionClassFactory6);
        } else {
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i2 = 2;
            int i3 = 0;
            if (i == HomeWidget.SPACERS.getIndex()) {
                danaProtectionViewHolder = (BaseSpringAnimationViewHolder) new ViewHolder(new EmptySpaceView(this.DatabaseTableConfigUtil, i3, i2, defaultConstructorMarker));
            } else {
                danaProtectionViewHolder = i == HomeWidget.NO_SPACE.getIndex() ? (BaseSpringAnimationViewHolder) new ViewHolder(new EmptySpaceView(this.DatabaseTableConfigUtil, 0)) : (BaseSpringAnimationViewHolder) new ViewHolder(new EmptySpaceView(this.DatabaseTableConfigUtil, i3, i2, defaultConstructorMarker));
            }
        }
        return danaProtectionViewHolder;
    }

    public HomeAdapter(List<HomeViewWidgetModel> list, Context context, HomeTabActivity homeTabActivity, SwipeDelegateListener swipeDelegateListener, HomeRecycleFragment homeRecycleFragment, HomeTrackerImpl homeTrackerImpl, ServiceCardListener serviceCardListener) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(homeTabActivity, "");
        Intrinsics.checkNotNullParameter(swipeDelegateListener, "");
        Intrinsics.checkNotNullParameter(homeRecycleFragment, "");
        Intrinsics.checkNotNullParameter(homeTrackerImpl, "");
        Intrinsics.checkNotNullParameter(serviceCardListener, "");
        this.getErrorConfigVersion = list;
        this.DatabaseTableConfigUtil = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = homeTabActivity;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = swipeDelegateListener;
        this.getAuthRequestContext = homeRecycleFragment;
        this.scheduleImpl = homeTrackerImpl;
        this.initRecordTimeStamp = serviceCardListener;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[this.getErrorConfigVersion.get(position).MyBillsEntityDataFactory.ordinal()]) {
            case 1:
                return HomeWidget.FOUR_KINGS.getIndex();
            case 2:
                return HomeWidget.SERVICES.getIndex();
            case 3:
                return HomeWidget.SOCIAL_WIDGET.getIndex();
            case 4:
                return HomeWidget.PROMO_BANNER.getIndex();
            case 5:
                return HomeWidget.PROMO_CENTER.getIndex();
            case 6:
                return HomeWidget.NEARBY_ME.getIndex();
            case 7:
                return HomeWidget.HOME_INVESTMENT.getIndex();
            case 8:
                return HomeWidget.MORE_FOR_YOU.getIndex();
            case 9:
                return HomeWidget.DANA_PROTECTION.getIndex();
            case 10:
                return HomeWidget.PERSONALIZED_BACKGROUND.getIndex();
            case 11:
                return HomeWidget.SPACERS.getIndex();
            case 12:
                return HomeWidget.GLOBAL_SEARCH.getIndex();
            case 13:
                return HomeWidget.NO_SPACE.getIndex();
            default:
                return HomeWidget.SPACERS.getIndex();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.getErrorConfigVersion.size();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$ServicesViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemServicesWidgetBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/databinding/ViewItemServicesWidgetBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/richview/servicescard/ServiceCardListener;", "MyBillsEntityDataFactory", "Lid/dana/richview/servicescard/ServiceCardListener;", "p0", "p1", "<init>", "(Lid/dana/databinding/ViewItemServicesWidgetBinding;Lid/dana/richview/servicescard/ServiceCardListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ServicesViewHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final ViewItemServicesWidgetBinding BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final ServiceCardListener KClassImpl$Data$declaredNonStaticMembers$2;

        public static final boolean getAuthRequestContext(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void MyBillsEntityDataFactory(ServicesViewHolder servicesViewHolder) {
            Intrinsics.checkNotNullParameter(servicesViewHolder, "");
            servicesViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.notifyFinishCheckSession();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ServicesViewHolder(id.dana.databinding.ViewItemServicesWidgetBinding r3, id.dana.richview.servicescard.ServiceCardListener r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                id.dana.richview.servicescard.ServiceCardV2View r1 = r3.getAuthRequestContext
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.ServicesViewHolder.<init>(id.dana.databinding.ViewItemServicesWidgetBinding, id.dana.richview.servicescard.ServiceCardListener):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$SocialWidgetHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemSocialWidgetBinding;", "PlaceComponentResult", "Lid/dana/databinding/ViewItemSocialWidgetBinding;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/databinding/ViewItemSocialWidgetBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SocialWidgetHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final ViewItemSocialWidgetBinding getAuthRequestContext;

        public static final boolean getAuthRequestContext(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void MyBillsEntityDataFactory(SocialWidgetHolder socialWidgetHolder) {
            Intrinsics.checkNotNullParameter(socialWidgetHolder, "");
            socialWidgetHolder.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.notifyFinishCheckSession();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public SocialWidgetHolder(id.dana.databinding.ViewItemSocialWidgetBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.social.view.NewSocialWidgetView r1 = r3.PlaceComponentResult
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.getAuthRequestContext = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.SocialWidgetHolder.<init>(id.dana.databinding.ViewItemSocialWidgetBinding):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$PromoCenterViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemPromoCenterWidgetBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/ViewItemPromoCenterWidgetBinding;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/databinding/ViewItemPromoCenterWidgetBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PromoCenterViewHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final ViewItemPromoCenterWidgetBinding PlaceComponentResult;

        public static final boolean PlaceComponentResult(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void PlaceComponentResult(PromoCenterViewHolder promoCenterViewHolder) {
            Intrinsics.checkNotNullParameter(promoCenterViewHolder, "");
            promoCenterViewHolder.PlaceComponentResult.getAuthRequestContext.notifyFinishCheckSessionWatcher();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PromoCenterViewHolder(id.dana.databinding.ViewItemPromoCenterWidgetBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.richview.NewPromoCenterView r1 = r3.MyBillsEntityDataFactory
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.PlaceComponentResult = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.PromoCenterViewHolder.<init>(id.dana.databinding.ViewItemPromoCenterWidgetBinding):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$PromoViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemPromoWidgetBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ViewItemPromoWidgetBinding;", "p0", "<init>", "(Lid/dana/databinding/ViewItemPromoWidgetBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PromoViewHolder extends BaseSpringAnimationViewHolder {
        public final ViewItemPromoWidgetBinding BuiltInFictitiousFunctionClassFactory;

        public static final boolean getAuthRequestContext(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoViewHolder promoViewHolder) {
            Intrinsics.checkNotNullParameter(promoViewHolder, "");
            promoViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.notifyFinishCheckSessionWatcher();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PromoViewHolder(id.dana.databinding.ViewItemPromoWidgetBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.richview.NewPromoBannerView r1 = r3.getAuthRequestContext
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.PromoViewHolder.<init>(id.dana.databinding.ViewItemPromoWidgetBinding):void");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$NearbyViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemNearbyWidgetBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/ViewItemNearbyWidgetBinding;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function0;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/databinding/ViewItemNearbyWidgetBinding;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NearbyViewHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final ViewItemNearbyWidgetBinding BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

        public static final boolean MyBillsEntityDataFactory(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NearbyViewHolder nearbyViewHolder) {
            Intrinsics.checkNotNullParameter(nearbyViewHolder, "");
            nearbyViewHolder.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.notifyFinishCheckSessionWatcher();
        }

        public static /* synthetic */ void getAuthRequestContext(NearbyViewHolder nearbyViewHolder) {
            Intrinsics.checkNotNullParameter(nearbyViewHolder, "");
            nearbyViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public NearbyViewHolder(id.dana.databinding.ViewItemNearbyWidgetBinding r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                id.dana.nearbyme.NewNearbyMeView r1 = r3.BuiltInFictitiousFunctionClassFactory
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.NearbyViewHolder.<init>(id.dana.databinding.ViewItemNearbyWidgetBinding, kotlin.jvm.functions.Function0):void");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$MoreForYouViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemMoreForYouBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ViewItemMoreForYouBinding;", "Lkotlin/Function0;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "p0", "p1", "<init>", "(Lid/dana/databinding/ViewItemMoreForYouBinding;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class MoreForYouViewHolder extends BaseSpringAnimationViewHolder {
        public final ViewItemMoreForYouBinding BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final Function0<Unit> PlaceComponentResult;

        public static final boolean MyBillsEntityDataFactory(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void PlaceComponentResult(MoreForYouViewHolder moreForYouViewHolder) {
            Intrinsics.checkNotNullParameter(moreForYouViewHolder, "");
            moreForYouViewHolder.PlaceComponentResult.invoke();
        }

        public static /* synthetic */ void getAuthRequestContext(MoreForYouViewHolder moreForYouViewHolder) {
            Intrinsics.checkNotNullParameter(moreForYouViewHolder, "");
            moreForYouViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.onFinishCheckSession();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MoreForYouViewHolder(id.dana.databinding.ViewItemMoreForYouBinding r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                id.dana.richview.moreforyou.MoreForYouView r1 = r3.KClassImpl$Data$declaredNonStaticMembers$2
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                r2.PlaceComponentResult = r4
                id.dana.richview.moreforyou.MoreForYouView r3 = r3.MyBillsEntityDataFactory
                id.dana.home.adapter.HomeAdapter$MoreForYouViewHolder$$ExternalSyntheticLambda0 r4 = new id.dana.home.adapter.HomeAdapter$MoreForYouViewHolder$$ExternalSyntheticLambda0
                r4.<init>()
                r3.setFinishLoaded(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.MoreForYouViewHolder.<init>(id.dana.databinding.ViewItemMoreForYouBinding, kotlin.jvm.functions.Function0):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$DanaProtectionViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemDanaProtectionBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ViewItemDanaProtectionBinding;", "p0", "<init>", "(Lid/dana/databinding/ViewItemDanaProtectionBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DanaProtectionViewHolder extends BaseSpringAnimationViewHolder {
        public final ViewItemDanaProtectionBinding BuiltInFictitiousFunctionClassFactory;

        public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "");
            return bool.booleanValue();
        }

        public static /* synthetic */ void getAuthRequestContext(DanaProtectionViewHolder danaProtectionViewHolder) {
            Intrinsics.checkNotNullParameter(danaProtectionViewHolder, "");
            danaProtectionViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.onFinishCheckSession();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DanaProtectionViewHolder(id.dana.databinding.ViewItemDanaProtectionBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.home.danaprotection.DanaProtectionHomeView r1 = r3.KClassImpl$Data$declaredNonStaticMembers$2
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.DanaProtectionViewHolder.<init>(id.dana.databinding.ViewItemDanaProtectionBinding):void");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$HomePersonalizationViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemHomePersonalizationBinding;", "getAuthRequestContext", "Lid/dana/databinding/ViewItemHomePersonalizationBinding;", "PlaceComponentResult", "Lkotlin/Function0;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function0;", "p0", "p1", "<init>", "(Lid/dana/databinding/ViewItemHomePersonalizationBinding;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class HomePersonalizationViewHolder extends BaseSpringAnimationViewHolder {
        private final Function0<Unit> MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final ViewItemHomePersonalizationBinding PlaceComponentResult;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public HomePersonalizationViewHolder(id.dana.databinding.ViewItemHomePersonalizationBinding r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                id.dana.home.view.HomePersonalizationView r1 = r3.MyBillsEntityDataFactory
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.PlaceComponentResult = r3
                r2.MyBillsEntityDataFactory = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.HomePersonalizationViewHolder.<init>(id.dana.databinding.ViewItemHomePersonalizationBinding, kotlin.jvm.functions.Function0):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$ViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends BaseSpringAnimationViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$HomeWidget;", "", "", "index", "I", "getIndex", "()I", "<init>", "(Ljava/lang/String;II)V", "GLOBAL_SEARCH", "FOUR_KINGS", PromoQuestRedirectType.SERVICES, "SOCIAL_WIDGET", "PROMO_BANNER", "PROMO_CENTER", "NEARBY_ME", "HOME_INVESTMENT", "MORE_FOR_YOU", "DANA_PROTECTION", "PERSONALIZED_BACKGROUND", "SPACERS", "BALANCE", "NOTIFICATION", "BOTTOM_BAR", "NO_SPACE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum HomeWidget {
        GLOBAL_SEARCH(0),
        FOUR_KINGS(1),
        SERVICES(2),
        SOCIAL_WIDGET(3),
        PROMO_BANNER(4),
        PROMO_CENTER(5),
        NEARBY_ME(6),
        HOME_INVESTMENT(7),
        MORE_FOR_YOU(8),
        DANA_PROTECTION(9),
        PERSONALIZED_BACKGROUND(10),
        SPACERS(11),
        BALANCE(12),
        NOTIFICATION(13),
        BOTTOM_BAR(14),
        NO_SPACE(15);

        private final int index;

        HomeWidget(int i) {
            this.index = i;
        }

        @JvmName(name = "getIndex")
        public final int getIndex() {
            return this.index;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$FourKingViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemFourKingBinding;", "getAuthRequestContext", "Lid/dana/databinding/ViewItemFourKingBinding;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/databinding/ViewItemFourKingBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class FourKingViewHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final ViewItemFourKingBinding BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FourKingViewHolder(id.dana.databinding.ViewItemFourKingBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.home.view.FourKingView r1 = r3.BuiltInFictitiousFunctionClassFactory
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.FourKingViewHolder.<init>(id.dana.databinding.ViewItemFourKingBinding):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$GlobalSearchViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemHomeGlobalSearchBinding;", "PlaceComponentResult", "Lid/dana/databinding/ViewItemHomeGlobalSearchBinding;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/databinding/ViewItemHomeGlobalSearchBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class GlobalSearchViewHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final ViewItemHomeGlobalSearchBinding MyBillsEntityDataFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public GlobalSearchViewHolder(id.dana.databinding.ViewItemHomeGlobalSearchBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.richview.globalsearch.ToolbarGlobalSearchView r1 = r3.MyBillsEntityDataFactory
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.MyBillsEntityDataFactory = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.GlobalSearchViewHolder.<init>(id.dana.databinding.ViewItemHomeGlobalSearchBinding):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/home/adapter/HomeAdapter$HomeInvestmentViewHolder;", "Lid/dana/core/ui/scrollanimation/BaseSpringAnimationViewHolder;", "Lid/dana/databinding/ViewItemHomeInvestmentBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/databinding/ViewItemHomeInvestmentBinding;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/databinding/ViewItemHomeInvestmentBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class HomeInvestmentViewHolder extends BaseSpringAnimationViewHolder {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final ViewItemHomeInvestmentBinding BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public HomeInvestmentViewHolder(id.dana.databinding.ViewItemHomeInvestmentBinding r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                id.dana.investment.view.HomeInvestmentView r1 = r3.getAuthRequestContext
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.view.View r1 = (android.view.View) r1
                r2.<init>(r1)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.home.adapter.HomeAdapter.HomeInvestmentViewHolder.<init>(id.dana.databinding.ViewItemHomeInvestmentBinding):void");
        }
    }
}
