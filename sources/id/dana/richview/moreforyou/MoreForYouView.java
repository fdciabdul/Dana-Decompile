package id.dana.richview.moreforyou;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.common.DividerItemDecoration;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ViewMoreForYouBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMoreForYouComponent;
import id.dana.di.modules.MoreForYouModule;
import id.dana.di.modules.OauthModule;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.richview.moreforyou.MoreForYouContract;
import id.dana.richview.moreforyou.model.MoreForYouModel;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 g2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001gB'\b\u0016\u0012\u0006\u0010^\u001a\u00020]\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010a\u001a\u00020\f¢\u0006\u0004\bb\u0010cB+\b\u0016\u0012\u0006\u0010^\u001a\u00020]\u0012\b\u0010d\u001a\u0004\u0018\u00010_\u0012\u0006\u0010a\u001a\u00020\f\u0012\u0006\u0010e\u001a\u00020\f¢\u0006\u0004\bb\u0010fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J'\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010\u0005J\u001d\u0010&\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0003H\u0002¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010\u0005R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00108\u001a\b\u0012\u0004\u0012\u000207068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010@\u001a\u00020>2\u0006\u0010?\u001a\u00020>8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010AR\u0016\u0010G\u001a\u00020>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u0010AR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bN\u0010OR(\u0010Q\u001a\b\u0012\u0004\u0012\u00020P068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bQ\u00109\u001a\u0004\bR\u0010;\"\u0004\bS\u0010=R(\u0010U\u001a\b\u0012\u0004\u0012\u00020T068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bU\u00109\u001a\u0004\bV\u0010;\"\u0004\bW\u0010=R\u0016\u0010X\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u0010LR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u0010LR\u0018\u0010Z\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010["}, d2 = {"Lid/dana/richview/moreforyou/MoreForYouView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewMoreForYouBinding;", "", "adjustViewHeightAccordingToFirstItemHeight", "()V", "Lkotlin/Function0;", "onAnimationEnd", "animateSlideDown", "(Lkotlin/jvm/functions/Function0;)V", "animateSlideUp", "checkInvestmentStatus", "", "resultHeight", "Landroid/animation/ValueAnimator;", "generateAnimationValueAnimator", "(ILkotlin/jvm/functions/Function0;)Landroid/animation/ValueAnimator;", "getLayout", "()I", "getMoreForYouFirstItemHeight", "hideMoreForYouItemSkeleton", "hideProgressBar", "initButton", "initInjection", "initRecyclerView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewMoreForYouBinding;", "onFinishCheckSession", "", "url", "openH5Container", "(Ljava/lang/String;)V", "refreshContent", "", "Lid/dana/richview/moreforyou/model/MoreForYouModel;", "listOfItem", "setMoreForYouItems", "(Ljava/util/List;)V", "setup", "showMoreForYouItemSkeleton", "showProgressBar", "stopLoadTime", "Lid/dana/richview/moreforyou/MoreForYouAdapter;", "adapter", "Lid/dana/richview/moreforyou/MoreForYouAdapter;", "Ljava/lang/Runnable;", "finishLoaded", "Ljava/lang/Runnable;", "getFinishLoaded", "()Ljava/lang/Runnable;", "setFinishLoaded", "(Ljava/lang/Runnable;)V", "Ldagger/Lazy;", "Lid/dana/home/tracker/HomeTrackerImpl;", "homeTrackerImpl", "Ldagger/Lazy;", "getHomeTrackerImpl", "()Ldagger/Lazy;", "setHomeTrackerImpl", "(Ldagger/Lazy;)V", "", "value", "investmentMoreForYouEnable", "Z", "getInvestmentMoreForYouEnable", "()Z", "setInvestmentMoreForYouEnable", "(Z)V", "isExpanded", "isWidgetTracked", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "moreForYouItemSize", "I", "Lcom/ethanhua/skeleton/SkeletonScreen;", "moreForYouItemSkeleton", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/richview/moreforyou/MoreForYouContract$Presenter;", "presenter", "getPresenter", "setPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "getReadDeepLinkPropertiesPresenter", "setReadDeepLinkPropertiesPresenter", "recyclerViewHeight", "recyclerViewItemHeight", "slideDownAnimation", "Landroid/animation/ValueAnimator;", "slideUpAnimation", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleArr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreForYouView extends ViewBindingRichView<ViewMoreForYouBinding> {
    private static final long ANIMATE_DURATION = 300;
    public Map<Integer, View> _$_findViewCache;
    private MoreForYouAdapter adapter;
    private Runnable finishLoaded;
    @Inject
    public Lazy<HomeTrackerImpl> homeTrackerImpl;
    private boolean investmentMoreForYouEnable;
    private boolean isExpanded;
    private boolean isWidgetTracked;
    private LinearLayoutManager layoutManager;
    private int moreForYouItemSize;
    private SkeletonScreen moreForYouItemSkeleton;
    @Inject
    public Lazy<MoreForYouContract.Presenter> presenter;
    @Inject
    public Lazy<ReadLinkPropertiesContract.Presenter> readDeepLinkPropertiesPresenter;
    private int recyclerViewHeight;
    private int recyclerViewItemHeight;
    private ValueAnimator slideDownAnimation;
    private ValueAnimator slideUpAnimation;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MoreForYouView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MoreForYouView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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
        return R.layout.view_more_for_you;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreForYouView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MoreForYouView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getPresenter")
    public final Lazy<MoreForYouContract.Presenter> getPresenter() {
        Lazy<MoreForYouContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<MoreForYouContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreForYouView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getInvestmentMoreForYouEnable")
    public final boolean getInvestmentMoreForYouEnable() {
        return this.investmentMoreForYouEnable;
    }

    @JvmName(name = "setInvestmentMoreForYouEnable")
    public final void setInvestmentMoreForYouEnable(boolean z) {
        this.investmentMoreForYouEnable = z;
        checkInvestmentStatus();
    }

    @JvmName(name = "getFinishLoaded")
    public final Runnable getFinishLoaded() {
        return this.finishLoaded;
    }

    @JvmName(name = "setFinishLoaded")
    public final void setFinishLoaded(Runnable runnable) {
        this.finishLoaded = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewMoreForYouBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewMoreForYouBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewMoreForYouBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getBinding().moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setText(R.string.more_for_you_title);
        getBinding().moveToNextValue.MyBillsEntityDataFactory.setText(R.string.more_for_you_description);
        getBinding().moveToNextValue.getAuthRequestContext.setActiveButton(getContext().getString(R.string.more_for_you_show), null);
        FrameLayout frameLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(0);
        initInjection();
        getPresenter().get().initMoreForYouHitBeObservable();
        initButton();
        initRecyclerView();
        showProgressBar();
        getPresenter().get().getMoreForYouCdpFromPersistence();
        showMoreForYouItemSkeleton();
    }

    private final void showMoreForYouItemSkeleton() {
        SkeletonScreen skeletonScreen = this.moreForYouItemSkeleton;
        MoreForYouAdapter moreForYouAdapter = null;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.MyBillsEntityDataFactory();
            return;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.skeleton_item_more_for_you;
        MoreForYouAdapter moreForYouAdapter2 = this.adapter;
        if (moreForYouAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            moreForYouAdapter = moreForYouAdapter2;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = moreForYouAdapter;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 1;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen, "");
        this.moreForYouItemSkeleton = recyclerViewSkeletonScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideMoreForYouItemSkeleton() {
        SkeletonScreen skeletonScreen = this.moreForYouItemSkeleton;
        if (skeletonScreen != null) {
            if (skeletonScreen == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                skeletonScreen = null;
            }
            skeletonScreen.PlaceComponentResult();
        }
    }

    private final void animateSlideUp(Function0<Unit> onAnimationEnd) {
        ValueAnimator valueAnimator = this.slideUpAnimation;
        if (valueAnimator != null) {
            if (valueAnimator != null && valueAnimator.isStarted()) {
                return;
            }
        }
        if (getView() == null) {
            return;
        }
        int moreForYouFirstItemHeight = getMoreForYouFirstItemHeight();
        View view = getView();
        Intrinsics.checkNotNull(view);
        ValueAnimator generateAnimationValueAnimator = generateAnimationValueAnimator((view.getMeasuredHeight() - this.recyclerViewHeight) + moreForYouFirstItemHeight, onAnimationEnd);
        this.slideUpAnimation = generateAnimationValueAnimator;
        if (generateAnimationValueAnimator != null) {
            generateAnimationValueAnimator.start();
        }
    }

    private final ValueAnimator generateAnimationValueAnimator(int resultHeight, final Function0<Unit> onAnimationEnd) {
        View view = getView();
        if (view != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(view.getMeasuredHeight(), resultHeight);
            ofInt.setTarget(view);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.richview.moreforyou.MoreForYouView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MoreForYouView.m2844generateAnimationValueAnimator$lambda3$lambda2$lambda0(MoreForYouView.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(ofInt, "");
            ofInt.addListener(new Animator.AnimatorListener() { // from class: id.dana.richview.moreforyou.MoreForYouView$generateAnimationValueAnimator$lambda-3$lambda-2$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "");
                    Function0.this.invoke();
                }
            });
            ofInt.setDuration(300L);
            return ofInt;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: generateAnimationValueAnimator$lambda-3$lambda-2$lambda-0  reason: not valid java name */
    public static final void m2844generateAnimationValueAnimator$lambda3$lambda2$lambda0(MoreForYouView moreForYouView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(moreForYouView, "");
        Intrinsics.checkNotNullParameter(valueAnimator, "");
        View view = moreForYouView.getView();
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            layoutParams.height = ((Integer) animatedValue).intValue();
        }
        View view2 = moreForYouView.getView();
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
    }

    private final int getMoreForYouFirstItemHeight() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(0);
        if (findViewByPosition != null) {
            return findViewByPosition.getHeight();
        }
        return 0;
    }

    private final void animateSlideDown(Function0<Unit> onAnimationEnd) {
        ValueAnimator valueAnimator = this.slideDownAnimation;
        if (valueAnimator != null) {
            if (valueAnimator != null && valueAnimator.isStarted()) {
                return;
            }
        }
        if (getView() == null) {
            return;
        }
        int moreForYouFirstItemHeight = getMoreForYouFirstItemHeight();
        View view = getView();
        Intrinsics.checkNotNull(view);
        ValueAnimator generateAnimationValueAnimator = generateAnimationValueAnimator((view.getMeasuredHeight() + this.recyclerViewHeight) - moreForYouFirstItemHeight, onAnimationEnd);
        this.slideDownAnimation = generateAnimationValueAnimator;
        if (generateAnimationValueAnimator != null) {
            generateAnimationValueAnimator.start();
        }
    }

    private final void showProgressBar() {
        LinearLayout linearLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
        linearLayout2.setVisibility(8);
        getBinding().PlaceComponentResult.startRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideProgressBar() {
        LinearLayout linearLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
        linearLayout2.setVisibility(0);
        getBinding().PlaceComponentResult.stopRefresh();
    }

    private final void initRecyclerView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        MoreForYouAdapter moreForYouAdapter = new MoreForYouAdapter(context);
        this.adapter = moreForYouAdapter;
        moreForYouAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.richview.moreforyou.MoreForYouView$$ExternalSyntheticLambda2
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                MoreForYouView.m2846initRecyclerView$lambda4(MoreForYouView.this, i);
            }
        });
        final RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.richview.moreforyou.MoreForYouView$initRecyclerView$$inlined$afterMeasured$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ViewMoreForYouBinding binding;
                int i;
                int i2;
                int i3;
                if (recyclerView.getMeasuredWidth() <= 0 || recyclerView.getMeasuredHeight() <= 0) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    recyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                RecyclerView recyclerView2 = (RecyclerView) recyclerView;
                MoreForYouView moreForYouView = this;
                binding = moreForYouView.getBinding();
                moreForYouView.recyclerViewHeight = binding.KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredHeight();
                this.adjustViewHeightAccordingToFirstItemHeight();
                i = this.moreForYouItemSize;
                if (i > 0) {
                    MoreForYouView moreForYouView2 = this;
                    i2 = moreForYouView2.recyclerViewHeight;
                    i3 = this.moreForYouItemSize;
                    moreForYouView2.recyclerViewItemHeight = i2 / i3;
                }
            }
        });
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        MoreForYouAdapter moreForYouAdapter2 = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.addItemDecoration(new DividerItemDecoration(getContext(), R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
        RecyclerView recyclerView3 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        MoreForYouAdapter moreForYouAdapter3 = this.adapter;
        if (moreForYouAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            moreForYouAdapter2 = moreForYouAdapter3;
        }
        recyclerView3.setAdapter(moreForYouAdapter2);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initRecyclerView$lambda-4  reason: not valid java name */
    public static final void m2846initRecyclerView$lambda4(MoreForYouView moreForYouView, int i) {
        Intrinsics.checkNotNullParameter(moreForYouView, "");
        MoreForYouAdapter moreForYouAdapter = moreForYouView.adapter;
        if (moreForYouAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            moreForYouAdapter = null;
        }
        MoreForYouModel item = moreForYouAdapter.getItem(i);
        String redirectUrl = item.getRedirectUrl();
        if (redirectUrl == null) {
            redirectUrl = "";
        }
        moreForYouView.openH5Container(redirectUrl);
        HomeTrackerImpl homeTrackerImpl = moreForYouView.getHomeTrackerImpl().get();
        Intrinsics.checkNotNullParameter(item, "");
        Pair<String, Object>[] pairArr = new Pair[6];
        String contentId = item.getContentId();
        if (contentId == null) {
            contentId = "";
        }
        pairArr[0] = TuplesKt.to(TrackerDataKey.MoreForYouProperties.CONTENT_ID, contentId);
        String contentType = item.getContentType();
        if (contentType == null) {
            contentType = "";
        }
        pairArr[1] = TuplesKt.to("Content Type", contentType);
        String contentName = item.getContentName();
        if (contentName == null) {
            contentName = "";
        }
        pairArr[2] = TuplesKt.to(TrackerDataKey.MoreForYouProperties.CONTENT_NAME, contentName);
        pairArr[3] = TuplesKt.to(TrackerDataKey.MoreForYouProperties.EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(item.getExpireDate(), "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext()));
        String spaceCode = item.getSpaceCode();
        if (spaceCode == null) {
            spaceCode = "";
        }
        pairArr[4] = TuplesKt.to(TrackerDataKey.MoreForYouProperties.SPACE_CODE, spaceCode);
        String redirectUrl2 = item.getRedirectUrl();
        pairArr[5] = TuplesKt.to(TrackerDataKey.MoreForYouProperties.REDIRECT_URL, redirectUrl2 != null ? redirectUrl2 : "");
        homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.MORE_FOR_YOU_ARTICLE_OPEN, pairArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustViewHeightAccordingToFirstItemHeight() {
        View view = getView();
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (view.getMeasuredHeight() - this.recyclerViewHeight) + getMoreForYouFirstItemHeight();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMoreForYouItems(List<MoreForYouModel> listOfItem) {
        hideProgressBar();
        hideMoreForYouItemSkeleton();
        if (listOfItem.isEmpty()) {
            getBinding().moveToNextValue.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout = getBinding().moveToNextValue.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = getBinding().moveToNextValue.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "");
        relativeLayout2.setVisibility(listOfItem.size() > 1 ? 0 : 8);
        MoreForYouAdapter moreForYouAdapter = this.adapter;
        if (moreForYouAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            moreForYouAdapter = null;
        }
        moreForYouAdapter.setItems(listOfItem);
        int i = this.moreForYouItemSize;
        int size = listOfItem.size();
        this.moreForYouItemSize = listOfItem.size();
        this.recyclerViewHeight = this.recyclerViewItemHeight * listOfItem.size();
        if (this.isExpanded) {
            View view = getView();
            ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
            if (layoutParams != null) {
                View view2 = getView();
                layoutParams.height = (view2 != null ? Integer.valueOf(view2.getMeasuredHeight() - (this.recyclerViewItemHeight * (i - size))) : null).intValue();
            }
        }
        checkInvestmentStatus();
    }

    private final void initInjection() {
        DaggerMoreForYouComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMoreForYouComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (MoreForYouModule) Preconditions.getAuthRequestContext(new MoreForYouModule(new MoreForYouContract.View() { // from class: id.dana.richview.moreforyou.MoreForYouView$initInjection$1
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

            @Override // id.dana.richview.moreforyou.MoreForYouContract.View
            public final void onGetMoreForYouSuccess(List<MoreForYouModel> listOfItem) {
                Intrinsics.checkNotNullParameter(listOfItem, "");
                MoreForYouView.this.setMoreForYouItems(listOfItem);
                MoreForYouView.this.stopLoadTime();
            }

            @Override // id.dana.richview.moreforyou.MoreForYouContract.View
            public final void onGetMoreForYouError() {
                ViewMoreForYouBinding binding;
                MoreForYouAdapter moreForYouAdapter;
                ViewMoreForYouBinding binding2;
                binding = MoreForYouView.this.getBinding();
                FrameLayout frameLayout = binding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "");
                frameLayout.setVisibility(8);
                MoreForYouView.this.hideProgressBar();
                MoreForYouView.this.hideMoreForYouItemSkeleton();
                moreForYouAdapter = MoreForYouView.this.adapter;
                if (moreForYouAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    moreForYouAdapter = null;
                }
                if (moreForYouAdapter.getPlaceComponentResult() == 0) {
                    binding2 = MoreForYouView.this.getBinding();
                    binding2.moveToNextValue.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                }
                MoreForYouView.this.stopLoadTime();
            }
        }));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getBaseActivity();
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, MoreForYouModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, OauthModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerMoreForYouComponent.MoreForYouComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopLoadTime() {
        if (this.isWidgetTracked) {
            return;
        }
        Runnable runnable = this.finishLoaded;
        if (runnable != null) {
            runnable.run();
        }
        this.isWidgetTracked = true;
    }

    private final void checkInvestmentStatus() {
        if (this.investmentMoreForYouEnable) {
            return;
        }
        MoreForYouAdapter moreForYouAdapter = this.adapter;
        MoreForYouAdapter moreForYouAdapter2 = null;
        if (moreForYouAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            moreForYouAdapter = null;
        }
        if (moreForYouAdapter.getPlaceComponentResult() > 0) {
            MoreForYouAdapter moreForYouAdapter3 = this.adapter;
            if (moreForYouAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                moreForYouAdapter3 = null;
            }
            int indexMoreForYouModel = moreForYouAdapter3.getIndexMoreForYouModel(MoreForYouScenarioType.DANA_REKSA_FUNDTASTIC);
            if (indexMoreForYouModel != -1) {
                MoreForYouAdapter moreForYouAdapter4 = this.adapter;
                if (moreForYouAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    moreForYouAdapter2 = moreForYouAdapter4;
                }
                moreForYouAdapter2.removeItem(indexMoreForYouModel);
            }
        }
    }

    private final void openH5Container(String url) {
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        if (UrlUtil.getErrorConfigVersion(url)) {
            getReadDeepLinkPropertiesPresenter().get().MyBillsEntityDataFactory(url);
        } else {
            DanaH5.startContainerFullUrl(url);
        }
    }

    public final void onFinishCheckSession() {
        if (isInflated()) {
            getPresenter().get().markSessionChecked();
        }
    }

    public final void refreshContent() {
        if (isInflated()) {
            RelativeLayout relativeLayout = getBinding().moveToNextValue.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            relativeLayout.setVisibility(0);
            getPresenter().get().getMoreForYouCDP(true);
            showMoreForYouItemSkeleton();
        }
    }

    private final void initButton() {
        getBinding().moveToNextValue.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.moreforyou.MoreForYouView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoreForYouView.m2845initButton$lambda7(MoreForYouView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initButton$lambda-7  reason: not valid java name */
    public static final void m2845initButton$lambda7(final MoreForYouView moreForYouView, View view) {
        Intrinsics.checkNotNullParameter(moreForYouView, "");
        if (moreForYouView.isExpanded) {
            moreForYouView.animateSlideUp(new Function0<Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouView$initButton$1$1
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
                    ViewMoreForYouBinding binding;
                    boolean z;
                    binding = MoreForYouView.this.getBinding();
                    binding.moveToNextValue.getAuthRequestContext.setActiveButton(MoreForYouView.this.getResources().getString(R.string.more_for_you_show), null);
                    MoreForYouView moreForYouView2 = MoreForYouView.this;
                    z = moreForYouView2.isExpanded;
                    moreForYouView2.isExpanded = !z;
                }
            });
        } else {
            moreForYouView.animateSlideDown(new Function0<Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouView$initButton$1$2
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
                    ViewMoreForYouBinding binding;
                    boolean z;
                    binding = MoreForYouView.this.getBinding();
                    binding.moveToNextValue.getAuthRequestContext.setActiveButton(MoreForYouView.this.getResources().getString(R.string.more_for_you_hide), null);
                    MoreForYouView moreForYouView2 = MoreForYouView.this;
                    z = moreForYouView2.isExpanded;
                    moreForYouView2.isExpanded = !z;
                }
            });
        }
    }
}
