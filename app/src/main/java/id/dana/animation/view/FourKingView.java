package id.dana.animation.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.SwipeDelegateListener;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.util.ViewUtil;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.ViewFourKingsBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFourKingComponent;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionEntryPointClickTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.requestmoney.RequestMoneyActivity;
import id.dana.scanner.TrackerQRScanner;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.showcase.Content;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.SizeUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001NB\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0018\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\"\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0005¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0005¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00020\u0005¢\u0006\u0004\b-\u0010+J\r\u0010.\u001a\u00020\u0005¢\u0006\u0004\b.\u0010+J\u0017\u00100\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010+R(\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010<\u001a\b\u0012\u0004\u0012\u00020;038\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\u0016\u0010\u000e\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bB\u0010CR$\u0010K\u001a\u0004\u0018\u00010D8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J"}, d2 = {"Lid/dana/home/view/FourKingView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFourKingsBinding;", "Landroid/view/View;", "view", "", "bindView", "(Landroid/view/View;)V", "p0", "", "p1", "p2", "p3", "Lid/dana/showcase/target/Target;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;III)Lid/dana/showcase/target/Target;", "", "getHomeTooltipTarget", "()Ljava/util/List;", "Ljava/lang/Class;", "javaClass", "", "source", "Landroid/content/Intent;", "getIntentClassWithTracking", "(Ljava/lang/Class;Ljava/lang/String;)Landroid/content/Intent;", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "async", IAPSyncCommand.COMMAND_INIT, "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFourKingsBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "performClickRequest", "()V", "performClickScan", "performClickSend", "performClickTopUp", "customColor", "setBackgroundColor", "(Ljava/lang/String;)V", "setup", "Ldagger/Lazy;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Ldagger/Lazy;", "getDynamicUrlWrapper", "()Ldagger/Lazy;", "setDynamicUrlWrapper", "(Ldagger/Lazy;)V", "Lid/dana/home/tracker/HomeTrackerImpl;", "homeTrackerImpl", "getHomeTrackerImpl", "setHomeTrackerImpl", "PlaceComponentResult", "Z", "", "MyBillsEntityDataFactory", LogConstants.RESULT_FALSE, "Lid/dana/home/SwipeDelegateListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/home/SwipeDelegateListener;", "getSwipeDelegateListener", "()Lid/dana/home/SwipeDelegateListener;", "setSwipeDelegateListener", "(Lid/dana/home/SwipeDelegateListener;)V", "swipeDelegateListener", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FourKingView extends ViewBindingRichView<ViewFourKingsBinding> {
    public static final String FEATURE_REQUEST_MONEY = "Request Money";
    public static final String FEATURE_SCAN = "Scan";
    public static final String FEATURE_SEND_MONEY = "Send Money";
    public static final String FEATURE_TOP_UP = "Top Up";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private SwipeDelegateListener swipeDelegateListener;
    private final float MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public Lazy<DynamicUrlWrapper> dynamicUrlWrapper;
    @Inject
    public Lazy<HomeTrackerImpl> homeTrackerImpl;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FourKingView(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.view.FourKingView.<init>(android.content.Context):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public View _$_findCachedViewById(int i) {
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
    public int getLayout() {
        return R.layout.view_four_kings;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FourKingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = SizeUtil.getAuthRequestContext(36);
    }

    public /* synthetic */ FourKingView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final Lazy<DynamicUrlWrapper> getDynamicUrlWrapper() {
        Lazy<DynamicUrlWrapper> lazy = this.dynamicUrlWrapper;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(Lazy<DynamicUrlWrapper> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.dynamicUrlWrapper = lazy;
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

    @JvmName(name = "getSwipeDelegateListener")
    public final SwipeDelegateListener getSwipeDelegateListener() {
        return this.swipeDelegateListener;
    }

    @JvmName(name = "setSwipeDelegateListener")
    public final void setSwipeDelegateListener(SwipeDelegateListener swipeDelegateListener) {
        this.swipeDelegateListener = swipeDelegateListener;
    }

    @Override // id.dana.base.BaseRichView
    public void init(Context context, AttributeSet attrs, boolean async) {
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.FOUR_KINGS);
        super.init(context, attrs, async);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView, id.dana.base.BaseRichView
    public void bindView(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        super.bindView(view);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        HomeTrackerImpl homeTrackerImpl = getHomeTrackerImpl().get();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.FOUR_KINGS);
        if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
            homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.FOUR_KING, System.currentTimeMillis());
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    public final void performClickSend() {
        getBinding().PlaceComponentResult.performClick();
    }

    public final void performClickRequest() {
        getBinding().BuiltInFictitiousFunctionClassFactory.performClick();
    }

    public final void performClickTopUp() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.performClick();
    }

    public final void performClickScan() {
        getBinding().getAuthRequestContext.performClick();
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerFourKingComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerFourKingComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerFourKingComponent.FourKingComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0).MyBillsEntityDataFactory(this);
    }

    protected final Intent getIntentClassWithTracking(Class<?> javaClass, String source) {
        Intrinsics.checkNotNullParameter(javaClass, "");
        Intent intentClassWithTracking = getBaseActivity().getIntentClassWithTracking(javaClass, source);
        Intrinsics.checkNotNullExpressionValue(intentClassWithTracking, "");
        return intentClassWithTracking;
    }

    public final List<Target> getHomeTooltipTarget() {
        ArrayList arrayList = new ArrayList();
        GridMenuView gridMenuView = (GridMenuView) _$_findCachedViewById(R.id.grid_scan);
        Intrinsics.checkNotNullExpressionValue(gridMenuView, "");
        Target KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(gridMenuView, R.string.tooltip_home_scan_title, R.string.tooltip_home_scan_desc, R.drawable.ic_tooltip_home_scan);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2);
        }
        GridMenuView gridMenuView2 = (GridMenuView) _$_findCachedViewById(R.id.res_0x7f0a07c1_r8_lambda_lnslh7bn2mzxi8tfxssb_vyvfg);
        Intrinsics.checkNotNullExpressionValue(gridMenuView2, "");
        Target KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(gridMenuView2, R.string.tooltip_home_topup_title, R.string.tooltip_home_topup_desc, R.drawable.ic_tooltip_home_top_up);
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$22);
        }
        GridMenuView gridMenuView3 = (GridMenuView) _$_findCachedViewById(R.id.res_0x7f0a07c0_access_getselectopsequencenumber_p);
        Intrinsics.checkNotNullExpressionValue(gridMenuView3, "");
        Target KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2(gridMenuView3, R.string.tooltip_home_send_title, R.string.tooltip_home_send_desc, R.drawable.ic_tooltip_home_send);
        if (KClassImpl$Data$declaredNonStaticMembers$23 != null) {
            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$23);
        }
        GridMenuView gridMenuView4 = (GridMenuView) _$_findCachedViewById(R.id.res_0x7f0a07be_daggeroauthgrantcomponent_oauthgrantcomponentimpl_postexecutionthreadprovider);
        Intrinsics.checkNotNullExpressionValue(gridMenuView4, "");
        Target KClassImpl$Data$declaredNonStaticMembers$24 = KClassImpl$Data$declaredNonStaticMembers$2(gridMenuView4, R.string.tooltip_home_request_title, R.string.tooltip_home_request_desc, R.drawable.ic_tooltip_home_request);
        if (KClassImpl$Data$declaredNonStaticMembers$24 != null) {
            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$24);
        }
        return CollectionsKt.toList(arrayList);
    }

    private final Target KClassImpl$Data$declaredNonStaticMembers$2(View p0, int p1, int p2, int p3) {
        return new TargetBuilder(getBaseActivity()).BuiltInFictitiousFunctionClassFactory(p0).BuiltInFictitiousFunctionClassFactory(new CircleShape(this.MyBillsEntityDataFactory)).getAuthRequestContext(new Content(getResources().getString(p1), getResources().getString(p2), p3)).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public ViewFourKingsBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFourKingsBinding BuiltInFictitiousFunctionClassFactory = ViewFourKingsBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setBackgroundColor(String customColor) {
        ViewUtil viewUtil = ViewUtil.INSTANCE;
        ViewUtil.BuiltInFictitiousFunctionClassFactory(getBinding().moveToNextValue, customColor);
        ViewUtil viewUtil2 = ViewUtil.INSTANCE;
        ViewUtil.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory, customColor);
    }

    public static /* synthetic */ void $r8$lambda$Ii1EcyxuByvmiv3Lr5xh6h77GYs(FourKingView fourKingView, View view) {
        Intrinsics.checkNotNullParameter(fourKingView, "");
        SwipeDelegateListener swipeDelegateListener = fourKingView.swipeDelegateListener;
        if (swipeDelegateListener != null) {
            swipeDelegateListener.BuiltInFictitiousFunctionClassFactory();
        }
        TrackerQRScanner.PlaceComponentResult(TrackerKey.SourceType.FOUR_KING_KONG);
        fourKingView.getHomeTrackerImpl().get().getAuthRequestContext("Scan");
    }

    /* renamed from: $r8$lambda$OkgTg3mreCnDT0aTXvA5tRj-3YU  reason: not valid java name */
    public static /* synthetic */ void m2625$r8$lambda$OkgTg3mreCnDT0aTXvA5tRj3YU(FourKingView fourKingView, View view) {
        Intrinsics.checkNotNullParameter(fourKingView, "");
        FirstActionEntryPointClickTracker.BuiltInFictitiousFunctionClassFactory();
        Intent intentClassWithTracking = fourKingView.getIntentClassWithTracking(SendMoneyActivity.class, TrackerKey.SourceType.FOUR_KING_KONG);
        intentClassWithTracking.putExtra("transferScenario", "sendMoney");
        fourKingView.getBaseActivity().startActivity(intentClassWithTracking);
        fourKingView.getHomeTrackerImpl().get().getAuthRequestContext("Send Money");
    }

    public static /* synthetic */ void $r8$lambda$oaIWei_146WOzQyGl3FQZagc9Vk(FourKingView fourKingView, View view) {
        Intrinsics.checkNotNullParameter(fourKingView, "");
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        String topupUrl = fourKingView.getDynamicUrlWrapper().get().getTopupUrl(TopupSource.FOUR_KING_KONG);
        Intrinsics.checkNotNullExpressionValue(topupUrl, "");
        DanaH5.startContainerFullUrl(topupUrl, new DanaH5Listener() { // from class: id.dana.home.view.FourKingView$openTopUpPage$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }
        });
        fourKingView.getHomeTrackerImpl().get().getAuthRequestContext(FEATURE_TOP_UP);
    }

    public static /* synthetic */ void $r8$lambda$ppGZxe78by0H73P0Xvd9iRwCpg8(FourKingView fourKingView, View view) {
        Intrinsics.checkNotNullParameter(fourKingView, "");
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        fourKingView.getBaseActivity().startActivity(fourKingView.getIntentClassWithTracking(RequestMoneyActivity.class, TrackerKey.SourceType.FOUR_KING_KONG));
        fourKingView.getHomeTrackerImpl().get().getAuthRequestContext("Request Money");
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.view.FourKingView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourKingView.m2625$r8$lambda$OkgTg3mreCnDT0aTXvA5tRj3YU(FourKingView.this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.view.FourKingView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourKingView.$r8$lambda$ppGZxe78by0H73P0Xvd9iRwCpg8(FourKingView.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.view.FourKingView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourKingView.$r8$lambda$oaIWei_146WOzQyGl3FQZagc9Vk(FourKingView.this, view);
            }
        });
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.view.FourKingView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FourKingView.$r8$lambda$Ii1EcyxuByvmiv3Lr5xh6h77GYs(FourKingView.this, view);
            }
        });
    }
}
