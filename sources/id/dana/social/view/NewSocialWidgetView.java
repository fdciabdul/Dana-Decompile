package id.dana.social.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.common.recyclerviewanimator.SlideDownAlphaAnimator;
import id.dana.data.config.model.FeedCacheData;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import id.dana.databinding.NewViewFeedsEntryPointBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.richview.HomeWidgetLinearBase;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.RealTimeFeedAdapter;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.di.module.SocialWidgetModule;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.SocialFeedModel;
import id.dana.social.model.SocialFeedWrapperModel;
import id.dana.social.presenter.NewSocialWidgetPresenter;
import id.dana.social.presenter.NewSocialWidgetPresenter$createTimelineObserver$1;
import id.dana.social.utils.SocialSyncManagerKt;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.ErrorUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002VWB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PB\u001b\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bO\u0010SB#\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010T\u001a\u00020\u0007¢\u0006\u0004\bO\u0010UJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0005J\r\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0005J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0005J\r\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u0005J\r\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0004\u0010(J\r\u0010)\u001a\u00020\u0003¢\u0006\u0004\b)\u0010\u0005R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010*R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8\u0007¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/R(\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R(\u0010:\u001a\b\u0012\u0004\u0012\u000209018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u0016\u0010\u0004\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010=R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010=R\"\u0010>\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010=\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u001dR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010=R\u0016\u0010\u0006\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010=R\u0018\u0010'\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010AR(\u0010C\u001a\b\u0012\u0004\u0012\u00020B018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u00104\u001a\u0004\bD\u00106\"\u0004\bE\u00108R\u0016\u0010%\u001a\u00020F8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010GR\"\u0010H\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010!R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010="}, d2 = {"Lid/dana/social/view/NewSocialWidgetView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/NewViewFeedsEntryPointBinding;", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "", "getLayout", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "PlaceComponentResult", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/NewViewFeedsEntryPointBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "getAuthRequestContext", "notifyFinishCheckSession", "onActivityResume", "onTabSwipeResume", "onUnselected", "refreshTimeline", "p0", "(Z)V", "Lid/dana/social/view/NewSocialWidgetView$SocialWidgetListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setWidgetListener", "(Lid/dana/social/view/NewSocialWidgetView$SocialWidgetListener;)V", "setup", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "(I)V", "stopFeedLoadTime", "I", "Ljava/util/Stack;", "Lid/dana/social/model/SocialFeedModel;", "Ljava/util/Stack;", "getFeedStack", "()Ljava/util/Stack;", "feedStack", "Ldagger/Lazy;", "Lid/dana/home/tracker/HomeTrackerImpl;", "homeTrackerImpl", "Ldagger/Lazy;", "getHomeTrackerImpl", "()Ldagger/Lazy;", "setHomeTrackerImpl", "(Ldagger/Lazy;)V", "Lid/dana/data/config/source/HomeWidgetEntityData;", "homeWidgetCache", "getHomeWidgetCache", "setHomeWidgetCache", "Z", "isFeedRevamp", "setFeedRevamp", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "Lid/dana/social/presenter/NewSocialWidgetPresenter;", "presenter", "getPresenter", "setPresenter", "Lid/dana/social/adapter/RealTimeFeedAdapter;", "Lid/dana/social/adapter/RealTimeFeedAdapter;", "socialWidgetListener", "Lid/dana/social/view/NewSocialWidgetView$SocialWidgetListener;", "getSocialWidgetListener", "()Lid/dana/social/view/NewSocialWidgetView$SocialWidgetListener;", "setSocialWidgetListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "SocialWidgetListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewSocialWidgetView extends ViewBindingRichView<NewViewFeedsEntryPointBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Stack<SocialFeedModel> feedStack;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int getAuthRequestContext;
    private RealTimeFeedAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isFeedRevamp;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public Lazy<HomeTrackerImpl> homeTrackerImpl;
    @Inject
    public Lazy<HomeWidgetEntityData> homeWidgetCache;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Disposable lookAheadTest;
    @Inject
    @Named("newSocialWidgetPresenter")
    public Lazy<NewSocialWidgetPresenter> presenter;
    private boolean scheduleImpl;
    public SocialWidgetListener socialWidgetListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0006\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/view/NewSocialWidgetView$SocialWidgetListener;", "", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "", "p0", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface SocialWidgetListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(boolean p0);

        void getAuthRequestContext();
    }

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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_view_feeds_entry_point;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSocialWidgetView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scheduleImpl = true;
        this.feedStack = new Stack<>();
        this.getAuthRequestContext = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSocialWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scheduleImpl = true;
        this.feedStack = new Stack<>();
        this.getAuthRequestContext = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSocialWidgetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scheduleImpl = true;
        this.feedStack = new Stack<>();
        this.getAuthRequestContext = -1;
    }

    @JvmName(name = "getSocialWidgetListener")
    public final SocialWidgetListener getSocialWidgetListener() {
        SocialWidgetListener socialWidgetListener = this.socialWidgetListener;
        if (socialWidgetListener != null) {
            return socialWidgetListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSocialWidgetListener")
    public final void setSocialWidgetListener(SocialWidgetListener socialWidgetListener) {
        Intrinsics.checkNotNullParameter(socialWidgetListener, "");
        this.socialWidgetListener = socialWidgetListener;
    }

    @JvmName(name = "isFeedRevamp")
    /* renamed from: isFeedRevamp  reason: from getter */
    public final boolean getIsFeedRevamp() {
        return this.isFeedRevamp;
    }

    @JvmName(name = "setFeedRevamp")
    public final void setFeedRevamp(boolean z) {
        this.isFeedRevamp = z;
    }

    @JvmName(name = "getFeedStack")
    public final Stack<SocialFeedModel> getFeedStack() {
        return this.feedStack;
    }

    public final void setWidgetListener(SocialWidgetListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        setSocialWidgetListener(listener);
    }

    @JvmName(name = "getPresenter")
    public final Lazy<NewSocialWidgetPresenter> getPresenter() {
        Lazy<NewSocialWidgetPresenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<NewSocialWidgetPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    @JvmName(name = "getHomeWidgetCache")
    public final Lazy<HomeWidgetEntityData> getHomeWidgetCache() {
        Lazy<HomeWidgetEntityData> lazy = this.homeWidgetCache;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomeWidgetCache")
    public final void setHomeWidgetCache(Lazy<HomeWidgetEntityData> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.homeWidgetCache = lazy;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final NewViewFeedsEntryPointBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        NewViewFeedsEntryPointBinding KClassImpl$Data$declaredNonStaticMembers$2 = NewViewFeedsEntryPointBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        FeedConfig feedConfig;
        ViewTreeObserver viewTreeObserver;
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.SOCIAL_WIDGET);
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.NewSocialWidgetView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSocialWidgetView.$r8$lambda$Y00yQey892CZZQH7MprwfaWE0Q4(NewSocialWidgetView.this, view);
            }
        });
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new RealTimeFeedAdapter(context, new BaseSocialFeedInteraction() { // from class: id.dana.social.view.NewSocialWidgetView$setupRealTimeFeedAdapter$1
            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void MyBillsEntityDataFactory(int p0) {
                Context context2 = NewSocialWidgetView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(context2);
                NewSocialWidgetView.this.getSocialWidgetListener().PlaceComponentResult();
            }
        });
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setHasFixedSize(true);
        RecyclerView recyclerView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Context context2 = getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context2) { // from class: id.dana.social.view.NewSocialWidgetView$setupRecyclerViewAttributes$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final boolean canScrollVertically() {
                return false;
            }
        });
        RecyclerView recyclerView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        RealTimeFeedAdapter realTimeFeedAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        RealTimeFeedAdapter realTimeFeedAdapter2 = null;
        if (realTimeFeedAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            realTimeFeedAdapter = null;
        }
        recyclerView2.setAdapter(realTimeFeedAdapter);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setNestedScrollingEnabled(false);
        LinearLayout linearLayout = getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        LinearLayout linearLayout2 = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
        LinearLayout linearLayout3 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
        List<ViewGroup> listOf = CollectionsKt.listOf((Object[]) new ViewGroup[]{linearLayout, constraintLayout, linearLayout2, linearLayout3});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (ViewGroup viewGroup : listOf) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams != null) {
                RealTimeFeedAdapter.Companion companion = RealTimeFeedAdapter.INSTANCE;
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                layoutParams.height = RealTimeFeedAdapter.Companion.MyBillsEntityDataFactory(context3) * 3;
            }
            viewGroup.setLayoutParams(layoutParams);
            arrayList.add(Unit.INSTANCE);
        }
        RecyclerView recyclerView3 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        SlideDownAlphaAnimator slideDownAlphaAnimator = new SlideDownAlphaAnimator();
        slideDownAlphaAnimator.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1000L;
        recyclerView3.setItemAnimator(slideDownAlphaAnimator);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        final Rect rect = new Rect();
        Context context4 = getContext();
        if (context4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        ((Activity) context4).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final Rect rect2 = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        final View view = getView();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: id.dana.social.view.NewSocialWidgetView$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    NewSocialWidgetView.m2964$r8$lambda$qWMnDPVJuNlxBjtCTrwWEdPI4(view, rect, this, rect2);
                }
            });
        }
        final NewSocialWidgetPresenter newSocialWidgetPresenter = getPresenter().get();
        newSocialWidgetPresenter.addDisposable(Observable.combineLatest(newSocialWidgetPresenter.KClassImpl$Data$declaredNonStaticMembers$2, newSocialWidgetPresenter.initRecordTimeStamp, new BiFunction() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1);
                return valueOf;
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewSocialWidgetPresenter.MyBillsEntityDataFactory(NewSocialWidgetPresenter.this, ((Boolean) obj).booleanValue());
            }
        }));
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        FeedCacheData feedCacheData = ((DanaApplication) applicationContext).feedData;
        if (feedCacheData != null && (feedConfig = feedCacheData.getFeedConfig()) != null) {
            this.isFeedRevamp = feedConfig.getFeedVersion() >= 5;
            if (!feedConfig.isFeedEnabledAndNotMaintenance()) {
                if (!feedConfig.isFeedEnabled()) {
                    if (this.socialWidgetListener != null) {
                        getSocialWidgetListener().getAuthRequestContext();
                        getPresenter().get().onDestroy();
                    }
                } else {
                    if (this.socialWidgetListener != null) {
                        getSocialWidgetListener().BuiltInFictitiousFunctionClassFactory();
                    }
                    if (this.socialWidgetListener != null) {
                        getSocialWidgetListener().getAuthRequestContext();
                        getPresenter().get().onDestroy();
                    }
                }
                stopFeedLoadTime();
                return;
            } else if (feedCacheData.isFeedInitFinish() && KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.MyBillsEntityDataFactory = true;
                KClassImpl$Data$declaredNonStaticMembers$2(feedCacheData.isFeedWidgetEnabled());
                SocialFeedWrapperModelEntityData socialFeed = feedCacheData.getSocialFeed();
                if (socialFeed != null) {
                    if ((!socialFeed.getData().isEmpty()) != false) {
                        MyBillsEntityDataFactory(0);
                        RealTimeFeedAdapter realTimeFeedAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (realTimeFeedAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            realTimeFeedAdapter3 = null;
                        }
                        realTimeFeedAdapter3.PlaceComponentResult = true;
                        RealTimeFeedAdapter realTimeFeedAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (realTimeFeedAdapter4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            realTimeFeedAdapter4 = null;
                        }
                        List<SocialFeedModel> items = realTimeFeedAdapter4.getItems();
                        SocialFeedWrapperModel.Companion companion2 = SocialFeedWrapperModel.INSTANCE;
                        items.addAll(CollectionsKt.take(SocialFeedWrapperModel.Companion.MyBillsEntityDataFactory(socialFeed).BuiltInFictitiousFunctionClassFactory, 3));
                        RealTimeFeedAdapter realTimeFeedAdapter5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (realTimeFeedAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            realTimeFeedAdapter2 = realTimeFeedAdapter5;
                        }
                        realTimeFeedAdapter2.notifyItemInserted(0);
                        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.scrollToPosition(0);
                    } else {
                        MyBillsEntityDataFactory(2);
                    }
                }
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.view.NewSocialWidgetView$decideInMemoryCondition$1
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
                        NewSocialWidgetView.access$updateNotificationButton(NewSocialWidgetView.this);
                    }
                };
                if (!this.BuiltInFictitiousFunctionClassFactory) {
                    this.BuiltInFictitiousFunctionClassFactory = true;
                    function0.invoke();
                    this.BuiltInFictitiousFunctionClassFactory = false;
                }
                stopFeedLoadTime();
                return;
            } else if (feedCacheData.isFeedInitNull() || feedCacheData.isFeedInitNotActivated()) {
                this.MyBillsEntityDataFactory = true;
                KClassImpl$Data$declaredNonStaticMembers$2(feedCacheData.isFeedWidgetEnabled());
                scheduleImpl();
                MyBillsEntityDataFactory(1);
                stopFeedLoadTime();
                return;
            } else {
                scheduleImpl();
                lookAheadTest();
                return;
            }
        }
        scheduleImpl();
        lookAheadTest();
    }

    private final boolean getAuthRequestContext() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            return PermissionHelper.MyBillsEntityDataFactory(baseActivity, "android.permission.READ_CONTACTS");
        }
        return false;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return getAuthRequestContext() || this.isFeedRevamp;
    }

    public final void onTabSwipeResume() {
        if (this.PlaceComponentResult) {
            getPresenter().get().MyBillsEntityDataFactory();
            getPresenter().get().getAuthRequestContext();
        }
    }

    public final void onActivityResume() {
        getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        if (applicationComponent != null) {
            applicationComponent.MyBillsEntityDataFactory(new SocialWidgetModule(new SocialWidgetContract.View() { // from class: id.dana.social.view.NewSocialWidgetView$injectComponent$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void PlaceComponentResult(boolean p0, boolean p1, boolean p2, int p3) {
                    NewSocialWidgetView.access$setupWidgetStateBasedOnConfig(NewSocialWidgetView.this, p0, p2, p1, p3);
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void MyBillsEntityDataFactory() {
                    NewSocialWidgetView.access$showInitFeedFinishState(NewSocialWidgetView.this);
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void moveToNextValue() {
                    NewSocialWidgetView.access$renderFeedNotActivated(NewSocialWidgetView.this);
                    NewSocialWidgetView.this.stopFeedLoadTime();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void BuiltInFictitiousFunctionClassFactory(SocialFeedWrapperModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewSocialWidgetView.this.getFeedStack().addAll(p0.BuiltInFictitiousFunctionClassFactory);
                    NewSocialWidgetView.this.MyBillsEntityDataFactory();
                    if ((!p0.BuiltInFictitiousFunctionClassFactory.isEmpty()) == true) {
                        NewSocialWidgetView.this.getHomeWidgetCache().get().saveSocialFeed(p0.getAuthRequestContext());
                    }
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void getAuthRequestContext() {
                    NewSocialWidgetView.this.getFeedStack().clear();
                    NewSocialWidgetView.this.getPresenter().get().BuiltInFictitiousFunctionClassFactory();
                    NewSocialWidgetView.this.MyBillsEntityDataFactory(1);
                    NewSocialWidgetView.this.stopFeedLoadTime();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
                    NewSocialWidgetView.this.BuiltInFictitiousFunctionClassFactory();
                    NewSocialWidgetView.this.stopFeedLoadTime();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void scheduleImpl() {
                    int i;
                    i = NewSocialWidgetView.this.getAuthRequestContext;
                    if (i == -1) {
                        final NewSocialWidgetPresenter newSocialWidgetPresenter = NewSocialWidgetView.this.getPresenter().get();
                        InitSocialFeed initSocialFeed = newSocialWidgetPresenter.lookAheadTest.get();
                        Intrinsics.checkNotNullExpressionValue(initSocialFeed, "");
                        SingleUseCase.execute$default(initSocialFeed, Unit.INSTANCE, null, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$initFeed$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                                invoke2(exc);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Exception exc) {
                                Intrinsics.checkNotNullParameter(exc, "");
                                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(InitSocialFeed.class, SocialWidgetPresenter.this.getClass(), String.valueOf(exc.getCause())));
                            }
                        }, 2, null);
                    }
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void MyBillsEntityDataFactory(SocialFeedWrapperModel p0) {
                    RealTimeFeedAdapter realTimeFeedAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewSocialWidgetView.access$setupShowFeedItemObservable(NewSocialWidgetView.this);
                    if (p0.getGetAuthRequestContext()) {
                        realTimeFeedAdapter = NewSocialWidgetView.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (realTimeFeedAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            realTimeFeedAdapter = null;
                        }
                        realTimeFeedAdapter.PlaceComponentResult = false;
                        NewSocialWidgetView.access$insertFeedItemInBatch(NewSocialWidgetView.this, p0.BuiltInFictitiousFunctionClassFactory);
                    } else {
                        NewSocialWidgetView.this.getFeedStack().addAll(p0.BuiltInFictitiousFunctionClassFactory);
                        NewSocialWidgetView.this.MyBillsEntityDataFactory();
                        Context applicationContext = NewSocialWidgetView.this.getContext().getApplicationContext();
                        if (applicationContext == null) {
                            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
                        }
                        DanaApplication danaApplication = (DanaApplication) applicationContext;
                        FeedCacheData feedCacheData = danaApplication.feedData;
                        feedCacheData.setSocialFeed(p0.getAuthRequestContext());
                        danaApplication.feedData = feedCacheData;
                    }
                    NewSocialWidgetView.this.getPresenter().get().getAuthRequestContext();
                    if ((!p0.BuiltInFictitiousFunctionClassFactory.isEmpty()) != false) {
                        NewSocialWidgetView.this.getHomeWidgetCache().get().saveSocialFeed(p0.getAuthRequestContext());
                    }
                    NewSocialWidgetView.this.stopFeedLoadTime();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    NewSocialWidgetView.this.PlaceComponentResult();
                    NewSocialWidgetView.access$hideInactiveState(NewSocialWidgetView.this);
                    NewSocialWidgetView.access$showTryAgainState(NewSocialWidgetView.this);
                    NewSocialWidgetView.this.stopFeedLoadTime();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void getErrorConfigVersion() {
                    NewSocialWidgetView.this.lookAheadTest();
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final void PlaceComponentResult() {
                    NewSocialWidgetView.this.PlaceComponentResult();
                    NewSocialWidgetView.access$hideTryAgainState(NewSocialWidgetView.this);
                    NewSocialWidgetView.this.PlaceComponentResult = true;
                    NewSocialWidgetView.access$initSocialFeedView(NewSocialWidgetView.this);
                }

                @Override // id.dana.social.contract.SocialWidgetContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    NewViewFeedsEntryPointBinding binding;
                    try {
                        binding = NewSocialWidgetView.this.getBinding();
                        TextView textView = (TextView) binding.moveToNextValue.findViewWithTag(NewSocialWidgetView.this.getResources().getString(R.string.error_message_tag));
                        Intrinsics.checkNotNullExpressionValue(textView, "");
                        return textView.getVisibility() == 0 ? textView.getText().toString() : "";
                    } catch (Exception unused) {
                        return "";
                    }
                }
            })).BuiltInFictitiousFunctionClassFactory(this);
        }
        registerPresenter(getPresenter().get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        RealTimeFeedAdapter realTimeFeedAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (realTimeFeedAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            realTimeFeedAdapter = null;
        }
        if (realTimeFeedAdapter.getItems().isEmpty() && this.feedStack.isEmpty()) {
            MyBillsEntityDataFactory(2);
        } else {
            MyBillsEntityDataFactory(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        RealTimeFeedAdapter realTimeFeedAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (realTimeFeedAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            realTimeFeedAdapter = null;
        }
        List<SocialFeedModel> items = realTimeFeedAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        if (items.size() < 3) {
            TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(8);
    }

    private final void scheduleImpl() {
        LottieAnimationView lottieAnimationView = getBinding().MyBillsEntityDataFactory;
        if (LocaleUtil.BuiltInFictitiousFunctionClassFactory()) {
            lottieAnimationView.setAnimation("json/lottie/feed_inactive_ID.lottie");
        } else {
            lottieAnimationView.setAnimation("json/lottie/feed_inactive_EN.lottie");
        }
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(int p0) {
        this.getAuthRequestContext = p0;
        if (p0 == 0) {
            moveToNextValue();
        } else if (p0 == 1) {
            getErrorConfigVersion();
        } else if (p0 == 2) {
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        getBinding().getErrorConfigVersion.stopRefresh();
        LinearLayout linearLayout = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lookAheadTest() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        LinearLayout linearLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        LottieAnimationView lottieAnimationView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(8);
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        getBinding().getErrorConfigVersion.startRefresh();
        LinearLayout linearLayout2 = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
        linearLayout2.setVisibility(0);
        getBinding().BuiltInFictitiousFunctionClassFactory.setWidgetHeaderVisible(false);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setWidgetHeaderVisible(false);
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        PlaceComponentResult();
        LinearLayout linearLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        LottieAnimationView lottieAnimationView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
    }

    private final void getErrorConfigVersion() {
        scheduleImpl();
        getBinding().BuiltInFictitiousFunctionClassFactory.setWidgetHeaderVisible(true);
        LottieAnimationView lottieAnimationView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(0);
        LinearLayout linearLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        PlaceComponentResult();
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        int applyDimension = (int) TypedValue.applyDimension(1, 152.0f, getResources().getDisplayMetrics());
        ViewGroup.LayoutParams layoutParams = getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = applyDimension;
        }
    }

    private final void moveToNextValue() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setWidgetHeaderVisible(false);
        LinearLayout linearLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(0);
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        LottieAnimationView lottieAnimationView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(8);
        PlaceComponentResult();
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
    }

    public final void refreshTimeline() {
        getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void onUnselected() {
        NewSocialWidgetPresenter newSocialWidgetPresenter = getPresenter().get();
        new NewSocialWidgetPresenter$createTimelineObserver$1(newSocialWidgetPresenter).dispose();
        newSocialWidgetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    }

    public final void stopFeedLoadTime() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        HomeTrackerImpl homeTrackerImpl = getHomeTrackerImpl().get();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.SOCIAL_WIDGET);
        if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
            homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.FEED_LOAD_TIME, System.currentTimeMillis());
        }
    }

    public final void notifyFinishCheckSession() {
        getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
    }

    public static /* synthetic */ void $r8$lambda$Y00yQey892CZZQH7MprwfaWE0Q4(NewSocialWidgetView newSocialWidgetView, View view) {
        Intrinsics.checkNotNullParameter(newSocialWidgetView, "");
        Context context = newSocialWidgetView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        SocialSyncManagerKt.BuiltInFictitiousFunctionClassFactory(context);
        newSocialWidgetView.getSocialWidgetListener().PlaceComponentResult();
    }

    public static /* synthetic */ void $r8$lambda$lkqlqo9K4GQ_y3m0l_4YHo8aMdY(NewSocialWidgetView newSocialWidgetView, Long l) {
        Intrinsics.checkNotNullParameter(newSocialWidgetView, "");
        if ((!newSocialWidgetView.feedStack.isEmpty()) != false && newSocialWidgetView.scheduleImpl) {
            RealTimeFeedAdapter realTimeFeedAdapter = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            RealTimeFeedAdapter realTimeFeedAdapter2 = null;
            if (realTimeFeedAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                realTimeFeedAdapter = null;
            }
            realTimeFeedAdapter.PlaceComponentResult = true;
            RealTimeFeedAdapter realTimeFeedAdapter3 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (realTimeFeedAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                realTimeFeedAdapter3 = null;
            }
            realTimeFeedAdapter3.getItems().add(0, newSocialWidgetView.feedStack.pop());
            RealTimeFeedAdapter realTimeFeedAdapter4 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (realTimeFeedAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                realTimeFeedAdapter4 = null;
            }
            realTimeFeedAdapter4.notifyItemInserted(0);
            newSocialWidgetView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.scrollToPosition(0);
            RealTimeFeedAdapter realTimeFeedAdapter5 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (realTimeFeedAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                realTimeFeedAdapter5 = null;
            }
            if (realTimeFeedAdapter5.getPlaceComponentResult() > 3) {
                RealTimeFeedAdapter realTimeFeedAdapter6 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (realTimeFeedAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    realTimeFeedAdapter6 = null;
                }
                List<SocialFeedModel> items = realTimeFeedAdapter6.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                int lastIndex = CollectionsKt.getLastIndex(items);
                RealTimeFeedAdapter realTimeFeedAdapter7 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (realTimeFeedAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    realTimeFeedAdapter7 = null;
                }
                realTimeFeedAdapter7.removeItem(lastIndex);
                RealTimeFeedAdapter realTimeFeedAdapter8 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (realTimeFeedAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    realTimeFeedAdapter2 = realTimeFeedAdapter8;
                }
                realTimeFeedAdapter2.notifyItemRemoved(lastIndex);
            }
        }
        newSocialWidgetView.BuiltInFictitiousFunctionClassFactory();
        newSocialWidgetView.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$ok1jJPrwyhSFjDFNuEw6eN5mI2g(NewSocialWidgetView newSocialWidgetView, View view) {
        Intrinsics.checkNotNullParameter(newSocialWidgetView, "");
        newSocialWidgetView.getPresenter().get().BuiltInFictitiousFunctionClassFactory(true);
    }

    /* renamed from: $r8$lambda$qWMnDPVJuNlxBjtCTr-wWEdPI-4  reason: not valid java name */
    public static /* synthetic */ void m2964$r8$lambda$qWMnDPVJuNlxBjtCTrwWEdPI4(View view, Rect rect, NewSocialWidgetView newSocialWidgetView, Rect rect2) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(rect, "");
        Intrinsics.checkNotNullParameter(newSocialWidgetView, "");
        Intrinsics.checkNotNullParameter(rect2, "");
        if (view.isShown()) {
            view.getGlobalVisibleRect(rect);
            newSocialWidgetView.scheduleImpl = rect.intersect(rect2);
        }
    }

    public static final /* synthetic */ void access$checkAndMigrateFeedStatus(NewSocialWidgetView newSocialWidgetView) {
        if (newSocialWidgetView.PlaceComponentResult) {
            return;
        }
        NewSocialWidgetPresenter newSocialWidgetPresenter = newSocialWidgetView.getPresenter().get();
        Intrinsics.checkNotNullExpressionValue(newSocialWidgetPresenter, "");
        newSocialWidgetPresenter.BuiltInFictitiousFunctionClassFactory(false);
    }

    public static final /* synthetic */ void access$hideInactiveState(NewSocialWidgetView newSocialWidgetView) {
        LottieAnimationView lottieAnimationView = newSocialWidgetView.getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(8);
    }

    public static final /* synthetic */ void access$hideTryAgainState(NewSocialWidgetView newSocialWidgetView) {
        LinearLayout linearLayout = newSocialWidgetView.getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
    }

    public static final /* synthetic */ void access$initSocialFeedView(NewSocialWidgetView newSocialWidgetView) {
        if (newSocialWidgetView.KClassImpl$Data$declaredNonStaticMembers$2()) {
            final NewSocialWidgetPresenter newSocialWidgetPresenter = newSocialWidgetView.getPresenter().get();
            if (!newSocialWidgetPresenter.getAuthRequestContext.get().getGetAuthRequestContext()) {
                newSocialWidgetPresenter.getAuthRequestContext.get().execute(Unit.INSTANCE, new Function1<Observable<InitFeed>, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$observeInitFeed$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Observable<InitFeed> observable) {
                        invoke2(observable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Observable<InitFeed> observable) {
                        Intrinsics.checkNotNullParameter(observable, "");
                        observable.subscribe(SocialWidgetPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SocialWidgetPresenter.this));
                    }
                }, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$observeInitFeed$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                        invoke2(exc);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Exception exc) {
                        Intrinsics.checkNotNullParameter(exc, "");
                        SocialWidgetPresenter.this.PlaceComponentResult(exc);
                    }
                });
            }
            newSocialWidgetPresenter.getAuthRequestContext.get().getGetAuthRequestContext();
            return;
        }
        newSocialWidgetView.getPresenter().get().BuiltInFictitiousFunctionClassFactory();
        newSocialWidgetView.MyBillsEntityDataFactory(1);
        newSocialWidgetView.stopFeedLoadTime();
    }

    public static final /* synthetic */ void access$insertFeedItemInBatch(NewSocialWidgetView newSocialWidgetView, List list) {
        if ((!list.isEmpty()) == true) {
            RealTimeFeedAdapter realTimeFeedAdapter = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (realTimeFeedAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                realTimeFeedAdapter = null;
            }
            realTimeFeedAdapter.setItems(list);
        }
    }

    public static final /* synthetic */ void access$renderFeedNotActivated(NewSocialWidgetView newSocialWidgetView) {
        newSocialWidgetView.PlaceComponentResult();
        LinearLayout linearLayout = newSocialWidgetView.getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        Disposable disposable = newSocialWidgetView.lookAheadTest;
        if (disposable != null) {
            disposable.dispose();
        }
        RealTimeFeedAdapter realTimeFeedAdapter = null;
        newSocialWidgetView.lookAheadTest = null;
        newSocialWidgetView.feedStack.clear();
        RealTimeFeedAdapter realTimeFeedAdapter2 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (realTimeFeedAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            realTimeFeedAdapter2 = null;
        }
        realTimeFeedAdapter2.getItems().clear();
        RealTimeFeedAdapter realTimeFeedAdapter3 = newSocialWidgetView.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (realTimeFeedAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            realTimeFeedAdapter = realTimeFeedAdapter3;
        }
        realTimeFeedAdapter.notifyDataSetChanged();
        newSocialWidgetView.getPresenter().get().BuiltInFictitiousFunctionClassFactory();
        newSocialWidgetView.MyBillsEntityDataFactory(1);
    }

    public static final /* synthetic */ void access$renderFeedWidget(NewSocialWidgetView newSocialWidgetView, boolean z) {
        if (z) {
            HomeWidgetLinearBase homeWidgetLinearBase = newSocialWidgetView.getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(homeWidgetLinearBase, "");
            homeWidgetLinearBase.setVisibility(0);
        } else if (newSocialWidgetView.socialWidgetListener != null) {
            newSocialWidgetView.getSocialWidgetListener().getAuthRequestContext();
            newSocialWidgetView.getPresenter().get().onDestroy();
        }
    }

    public static final /* synthetic */ void access$setupShowFeedItemObservable(final NewSocialWidgetView newSocialWidgetView) {
        Disposable disposable;
        if (newSocialWidgetView.lookAheadTest == null) {
            newSocialWidgetView.lookAheadTest = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).doOnNext(new Consumer() { // from class: id.dana.social.view.NewSocialWidgetView$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    NewSocialWidgetView.$r8$lambda$lkqlqo9K4GQ_y3m0l_4YHo8aMdY(NewSocialWidgetView.this, (Long) obj);
                }
            }).subscribe();
        }
        Disposable disposable2 = newSocialWidgetView.lookAheadTest;
        if (!(disposable2 != null && disposable2.isDisposed()) || (disposable = newSocialWidgetView.lookAheadTest) == null) {
            return;
        }
        newSocialWidgetView.addDisposable(disposable);
    }

    public static final /* synthetic */ void access$setupWidgetStateBasedOnConfig(final NewSocialWidgetView newSocialWidgetView, boolean z, boolean z2, final boolean z3, int i) {
        newSocialWidgetView.isFeedRevamp = i >= 5;
        if (z && !z2) {
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.view.NewSocialWidgetView$setupWidgetStateBasedOnConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    NewSocialWidgetView.access$renderFeedWidget(NewSocialWidgetView.this, z3);
                    NewSocialWidgetView.access$checkAndMigrateFeedStatus(NewSocialWidgetView.this);
                    NewSocialWidgetView.access$updateNotificationButton(NewSocialWidgetView.this);
                }
            };
            if (newSocialWidgetView.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            newSocialWidgetView.BuiltInFictitiousFunctionClassFactory = true;
            function0.invoke();
            newSocialWidgetView.BuiltInFictitiousFunctionClassFactory = false;
            return;
        }
        if (!z) {
            if (newSocialWidgetView.socialWidgetListener != null) {
                newSocialWidgetView.getSocialWidgetListener().getAuthRequestContext();
                newSocialWidgetView.getPresenter().get().onDestroy();
            }
        } else {
            if (newSocialWidgetView.socialWidgetListener != null) {
                newSocialWidgetView.getSocialWidgetListener().BuiltInFictitiousFunctionClassFactory();
            }
            if (newSocialWidgetView.socialWidgetListener != null) {
                newSocialWidgetView.getSocialWidgetListener().getAuthRequestContext();
                newSocialWidgetView.getPresenter().get().onDestroy();
            }
        }
        newSocialWidgetView.stopFeedLoadTime();
    }

    public static final /* synthetic */ void access$showInitFeedFinishState(final NewSocialWidgetView newSocialWidgetView) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.view.NewSocialWidgetView$showInitFeedFinishState$1
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
                NewSocialWidgetView.access$updateNotificationButton(NewSocialWidgetView.this);
                final NewSocialWidgetPresenter newSocialWidgetPresenter = NewSocialWidgetView.this.getPresenter().get();
                newSocialWidgetPresenter.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$getCachedFeeds$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                        invoke2(socialFeed);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SocialFeed socialFeed) {
                        PublishSubject publishSubject;
                        List BuiltInFictitiousFunctionClassFactory;
                        Intrinsics.checkNotNullParameter(socialFeed, "");
                        if (socialFeed.hasActivities()) {
                            SocialWidgetContract.View view = NewSocialWidgetPresenter.this.DatabaseTableConfigUtil.get();
                            BuiltInFictitiousFunctionClassFactory = NewSocialWidgetPresenter.this.BuiltInFictitiousFunctionClassFactory(socialFeed);
                            List list = BuiltInFictitiousFunctionClassFactory;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((FeedViewHolderModel) it.next()).BuiltInFictitiousFunctionClassFactory());
                            }
                            view.MyBillsEntityDataFactory(new SocialFeedWrapperModel(arrayList, socialFeed.getFromCache()));
                        } else {
                            NewSocialWidgetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                        }
                        publishSubject = NewSocialWidgetPresenter.this.initRecordTimeStamp;
                        publishSubject.onNext(Boolean.TRUE);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$getCachedFeeds$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        PublishSubject publishSubject;
                        Intrinsics.checkNotNullParameter(th, "");
                        NewSocialWidgetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                        publishSubject = NewSocialWidgetPresenter.this.initRecordTimeStamp;
                        publishSubject.onNext(Boolean.TRUE);
                    }
                });
            }
        };
        if (newSocialWidgetView.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        newSocialWidgetView.BuiltInFictitiousFunctionClassFactory = true;
        function0.invoke();
        newSocialWidgetView.BuiltInFictitiousFunctionClassFactory = false;
    }

    public static final /* synthetic */ void access$showTryAgainState(final NewSocialWidgetView newSocialWidgetView) {
        newSocialWidgetView.getBinding().BuiltInFictitiousFunctionClassFactory.setWidgetHeaderVisible(false);
        LinearLayout linearLayout = newSocialWidgetView.getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(0);
        newSocialWidgetView.getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.NewSocialWidgetView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSocialWidgetView.$r8$lambda$ok1jJPrwyhSFjDFNuEw6eN5mI2g(NewSocialWidgetView.this, view);
            }
        });
    }

    public static final /* synthetic */ void access$updateNotificationButton(NewSocialWidgetView newSocialWidgetView) {
        if (newSocialWidgetView.socialWidgetListener != null) {
            newSocialWidgetView.getSocialWidgetListener().PlaceComponentResult(newSocialWidgetView.isFeedRevamp);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            HomeWidgetLinearBase homeWidgetLinearBase = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(homeWidgetLinearBase, "");
            homeWidgetLinearBase.setVisibility(0);
        } else if (this.socialWidgetListener != null) {
            getSocialWidgetListener().getAuthRequestContext();
            getPresenter().get().onDestroy();
        }
    }
}
