package id.dana.onlinemerchant.view;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.extension.view.ViewExtKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.onlinemerchant.adapter.OnlineMerchantViewAdapter;
import id.dana.onlinemerchant.view.OnlineMerchantListView;
import id.dana.onlinemerchant.view.OnlineMerchantView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Z2\u00020\u0001:\u0002Z[B%\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010W\u001a\u00020\b¢\u0006\u0004\bX\u0010YJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u001a\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u001b\u0010$\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\"¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010\u001eJ\u001b\u0010)\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b)\u0010\u0007J\u001b\u0010*\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b*\u0010\u0007J\u001b\u0010+\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\"¢\u0006\u0004\b+\u0010%J\r\u0010,\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\fJ\r\u0010-\u001a\u00020\u0005¢\u0006\u0004\b-\u0010\fJ\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\fJ\r\u0010/\u001a\u00020\u0005¢\u0006\u0004\b/\u0010\fJ\r\u00100\u001a\u00020\u0005¢\u0006\u0004\b0\u0010\fJ\r\u00101\u001a\u00020\u0005¢\u0006\u0004\b1\u0010\fJ\r\u00102\u001a\u00020\u0005¢\u0006\u0004\b2\u0010\fJ\r\u00103\u001a\u00020\u0005¢\u0006\u0004\b3\u0010\fJ\r\u00104\u001a\u00020\u0005¢\u0006\u0004\b4\u0010\fR\u0016\u0010\u0015\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u00106R$\u0010=\u001a\u0004\u0018\u0001078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010J\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010!R*\u0010O\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\u00128\u0005@EX\u0085\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010L\u001a\u0004\bM\u0010\u0014\"\u0004\bN\u0010\u001eR\u0016\u0010?\u001a\u00020P8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010V\u001a\u00020\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010L\u001a\u0004\bT\u0010\u0014\"\u0004\bU\u0010\u001e"}, d2 = {"Lid/dana/onlinemerchant/view/OnlineMerchantView;", "Lid/dana/base/BaseRichView;", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "merchants", "", "appendOnlineMerchantList", "(Ljava/util/List;)V", "", "getLayout", "()I", "hideLoadMoreBtn", "()V", "hideLoadingLoadMore", "hideOnlineMerchantShimmer", "hideSearchOnlineMerchantShimmer", "hideTrendingMerchantShimmer", "hideTrendingOnlineMerchantSection", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isVisible", "setEmptyStateVisibility", "(Z)V", "state", "setErrorStateOnView", "(I)V", "Lkotlin/Function0;", "action", "setLoadMoreClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnlineMerchantList", "p0", "MyBillsEntityDataFactory", "setSearchOnlineMerchantList", "setTrendingMerchantList", "setTryAgainClickListener", "setViewOnError", "setViewOnSuccess", "setup", "showLoadMoreBtn", "showLoadingLoadMore", "startOnlineMerchantShimmer", "startSearchOnlineMerchantShimmer", "startTrendingMerchantShimmer", "stopRefresh", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lid/dana/onlinemerchant/view/OnlineMerchantView$OnlineMerchantListener;", "Lid/dana/onlinemerchant/view/OnlineMerchantView$OnlineMerchantListener;", "getListener", "()Lid/dana/onlinemerchant/view/OnlineMerchantView$OnlineMerchantListener;", "setListener", "(Lid/dana/onlinemerchant/view/OnlineMerchantView$OnlineMerchantListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "getAuthRequestContext", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "getOnlineMerchantItemListener", "()Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "setOnlineMerchantItemListener", "(Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;)V", "onlineMerchantItemListener", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getOnlineMerchantState", "setOnlineMerchantState", "onlineMerchantState", "value", "Z", "getPullToRefreshEnable", "setPullToRefreshEnable", "pullToRefreshEnable", "Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter;", "getErrorConfigVersion", "Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter;", "lookAheadTest", "getStopRefreshAnimationOnRepeat", "setStopRefreshAnimationOnRepeat", "stopRefreshAnimationOnRepeat", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnlineMerchantListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantView extends BaseRichView {
    public static final int EMPTY_STATE = 1;
    public static final int ERROR_STATE = 0;
    public static final int FIRST_POSITION = 0;
    public static final int ONLINE_MERCHANT_STATE = 0;
    public static final int SEARCH_ONLINE_MERCHANT_STATE = 1;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean pullToRefreshEnable;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int onlineMerchantState;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private LoadingLottieAnimationView PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private OnlineMerchantListener com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private OnlineMerchantListView.OnlineMerchantItemListener onlineMerchantItemListener;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private OnlineMerchantViewAdapter getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean stopRefreshAnimationOnRepeat;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onlinemerchant/view/OnlineMerchantView$OnlineMerchantListener;", "", "", "isHasOnlineMerchantsMore", "()Z", "", "onRefresh", "()V", "onTouchBottom"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnlineMerchantListener {
        boolean isHasOnlineMerchantsMore();

        void onRefresh();

        void onTouchBottom();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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
        return R.layout.view_online_merchant;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.pullToRefreshEnable = true;
    }

    public /* synthetic */ OnlineMerchantView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getPullToRefreshEnable")
    public final boolean getPullToRefreshEnable() {
        return this.pullToRefreshEnable;
    }

    @JvmName(name = "setPullToRefreshEnable")
    protected final void setPullToRefreshEnable(boolean z) {
        this.pullToRefreshEnable = z;
        PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_online_merchant);
        if (ptrClassicFrameLayout != null) {
            ptrClassicFrameLayout.setEnabled(z && BuiltInFictitiousFunctionClassFactory());
        }
    }

    @JvmName(name = "getStopRefreshAnimationOnRepeat")
    public final boolean getStopRefreshAnimationOnRepeat() {
        return this.stopRefreshAnimationOnRepeat;
    }

    @JvmName(name = "setStopRefreshAnimationOnRepeat")
    public final void setStopRefreshAnimationOnRepeat(boolean z) {
        this.stopRefreshAnimationOnRepeat = z;
    }

    @JvmName(name = "getListener")
    /* renamed from: getListener  reason: from getter */
    public final OnlineMerchantListener getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String() {
        return this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
    }

    @JvmName(name = "setListener")
    public final void setListener(OnlineMerchantListener onlineMerchantListener) {
        this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String = onlineMerchantListener;
    }

    @JvmName(name = "getOnlineMerchantItemListener")
    public final OnlineMerchantListView.OnlineMerchantItemListener getOnlineMerchantItemListener() {
        return this.onlineMerchantItemListener;
    }

    @JvmName(name = "setOnlineMerchantItemListener")
    public final void setOnlineMerchantItemListener(OnlineMerchantListView.OnlineMerchantItemListener onlineMerchantItemListener) {
        this.onlineMerchantItemListener = onlineMerchantItemListener;
    }

    @JvmName(name = "getOnlineMerchantState")
    public final int getOnlineMerchantState() {
        return this.onlineMerchantState;
    }

    @JvmName(name = "setOnlineMerchantState")
    public final void setOnlineMerchantState(int i) {
        this.onlineMerchantState = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r7, AttributeSet attrs) {
        ?? r1;
        super.parseAttrs(r7, attrs);
        if (attrs != null) {
            OnlineMerchantViewAdapter onlineMerchantViewAdapter = null;
            TypedArray obtainStyledAttributes = r7 != null ? r7.obtainStyledAttributes(attrs, R.styleable.fromContextOrNull) : null;
            if (obtainStyledAttributes != null) {
                try {
                    r1 = obtainStyledAttributes.getBoolean(0, false);
                } catch (Throwable th) {
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    throw th;
                }
            } else {
                r1 = 0;
            }
            this.onlineMerchantState = r1;
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
            if (this.onlineMerchantState != 0) {
                setPullToRefreshEnable(false);
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
                if (recyclerView != null) {
                    OnlineMerchantViewAdapter onlineMerchantViewAdapter2 = new OnlineMerchantViewAdapter(this.onlineMerchantState != 1 ? 4 : 2);
                    onlineMerchantViewAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = new OnlineMerchantListView.OnlineMerchantItemListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$setupRecyclerViewSearchMerchant$1$1$1
                        @Override // id.dana.onlinemerchant.view.OnlineMerchantListView.OnlineMerchantItemListener
                        public final void getAuthRequestContext(PaySearchInfoModel p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            OnlineMerchantListView.OnlineMerchantItemListener onlineMerchantItemListener = OnlineMerchantView.this.getOnlineMerchantItemListener();
                            if (onlineMerchantItemListener != null) {
                                onlineMerchantItemListener.getAuthRequestContext(p0);
                            }
                        }
                    };
                    this.getAuthRequestContext = onlineMerchantViewAdapter2;
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    OnlineMerchantViewAdapter onlineMerchantViewAdapter3 = this.getAuthRequestContext;
                    if (onlineMerchantViewAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        onlineMerchantViewAdapter = onlineMerchantViewAdapter3;
                    }
                    recyclerView.setAdapter(onlineMerchantViewAdapter);
                    return;
                }
                return;
            }
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
            if (recyclerView2 != null) {
                OnlineMerchantViewAdapter onlineMerchantViewAdapter4 = new OnlineMerchantViewAdapter(this.onlineMerchantState != 1 ? 4 : 2);
                onlineMerchantViewAdapter4.KClassImpl$Data$declaredNonStaticMembers$2 = new OnlineMerchantListView.OnlineMerchantItemListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$setupRecyclerView$1$1$1
                    @Override // id.dana.onlinemerchant.view.OnlineMerchantListView.OnlineMerchantItemListener
                    public final void getAuthRequestContext(PaySearchInfoModel p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        OnlineMerchantListView.OnlineMerchantItemListener onlineMerchantItemListener = OnlineMerchantView.this.getOnlineMerchantItemListener();
                        if (onlineMerchantItemListener != null) {
                            onlineMerchantItemListener.getAuthRequestContext(p0);
                        }
                    }
                };
                this.getAuthRequestContext = onlineMerchantViewAdapter4;
                recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
                OnlineMerchantViewAdapter onlineMerchantViewAdapter5 = this.getAuthRequestContext;
                if (onlineMerchantViewAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    onlineMerchantViewAdapter = onlineMerchantViewAdapter5;
                }
                recyclerView2.setAdapter(onlineMerchantViewAdapter);
            }
        }
    }

    public final void startTrendingMerchantShimmer() {
        OnlineMerchantView$startTrendingMerchantShimmer$1 onlineMerchantView$startTrendingMerchantShimmer$1 = new Function1<OnlineMerchantViewAdapter.TrendingMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$startTrendingMerchantShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder) {
                invoke2(trendingMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(trendingMerchantViewHolder, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) trendingMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.showSmallSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda1(this, onlineMerchantView$startTrendingMerchantShimmer$1));
        }
    }

    public final void hideTrendingMerchantShimmer() {
        OnlineMerchantView$hideTrendingMerchantShimmer$1 onlineMerchantView$hideTrendingMerchantShimmer$1 = new Function1<OnlineMerchantViewAdapter.TrendingMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$hideTrendingMerchantShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder) {
                invoke2(trendingMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(trendingMerchantViewHolder, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) trendingMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.hideSmallSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda1(this, onlineMerchantView$hideTrendingMerchantShimmer$1));
        }
    }

    public final void setTrendingMerchantList(final List<PaySearchInfoModel> merchants) {
        Intrinsics.checkNotNullParameter(merchants, "");
        Function1<OnlineMerchantViewAdapter.TrendingMerchantViewHolder, Unit> function1 = new Function1<OnlineMerchantViewAdapter.TrendingMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$setTrendingMerchantList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder) {
                invoke2(trendingMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(trendingMerchantViewHolder, "");
                List<PaySearchInfoModel> list = merchants;
                Intrinsics.checkNotNullParameter(list, "");
                View view = trendingMerchantViewHolder.itemView;
                View findViewById = view.findViewById(R.id.NotificationTarget);
                if (findViewById != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewById, "");
                    findViewById.setVisibility(0);
                }
                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tv_title_online_merchant);
                if (appCompatTextView != null) {
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(0);
                }
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) view.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    Intrinsics.checkNotNullExpressionValue(onlineMerchantListView, "");
                    onlineMerchantListView.setVisibility(0);
                }
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_online_merchant_list_section);
                if (constraintLayout != null) {
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout, null, Float.valueOf(12.0f), null, null, 13);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_online_merchant_list_section);
                if (constraintLayout2 != null) {
                    Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                    constraintLayout2.setVisibility(0);
                }
                OnlineMerchantListView onlineMerchantListView2 = (OnlineMerchantListView) trendingMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView2 != null) {
                    onlineMerchantListView2.setMerchantListItem(list);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda1(this, function1));
        }
    }

    public final void startOnlineMerchantShimmer() {
        OnlineMerchantView$startOnlineMerchantShimmer$1 onlineMerchantView$startOnlineMerchantShimmer$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$startOnlineMerchantShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.showLargeSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda5(this, onlineMerchantView$startOnlineMerchantShimmer$1));
        }
    }

    public final void hideOnlineMerchantShimmer() {
        OnlineMerchantView$hideOnlineMerchantShimmer$1 onlineMerchantView$hideOnlineMerchantShimmer$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$hideOnlineMerchantShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.hideLargeSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda5(this, onlineMerchantView$hideOnlineMerchantShimmer$1));
        }
    }

    public final void setOnlineMerchantList(final List<PaySearchInfoModel> merchants) {
        Intrinsics.checkNotNullParameter(merchants, "");
        Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit> function1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$setOnlineMerchantList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                List<PaySearchInfoModel> list = merchants;
                Intrinsics.checkNotNullParameter(list, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.setMerchantListItem(list);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda5(this, function1));
        }
    }

    public final void appendOnlineMerchantList(final List<PaySearchInfoModel> merchants) {
        Intrinsics.checkNotNullParameter(merchants, "");
        Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit> function1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$appendOnlineMerchantList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                List<PaySearchInfoModel> list = merchants;
                Intrinsics.checkNotNullParameter(list, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.appendMerchantListItem(list);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda5(this, function1));
        }
    }

    public final void startSearchOnlineMerchantShimmer() {
        OnlineMerchantView$startSearchOnlineMerchantShimmer$1 onlineMerchantView$startSearchOnlineMerchantShimmer$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$startSearchOnlineMerchantShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.showSmallSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda2(this, onlineMerchantView$startSearchOnlineMerchantShimmer$1));
        }
    }

    public final void hideSearchOnlineMerchantShimmer() {
        OnlineMerchantView$hideSearchOnlineMerchantShimmer$1 onlineMerchantView$hideSearchOnlineMerchantShimmer$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$hideSearchOnlineMerchantShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.hideSmallSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda2(this, onlineMerchantView$hideSearchOnlineMerchantShimmer$1));
        }
    }

    public final void setSearchOnlineMerchantList(final List<PaySearchInfoModel> merchants) {
        Intrinsics.checkNotNullParameter(merchants, "");
        Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit> function1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$setSearchOnlineMerchantList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                invoke2(onlineMerchantViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantViewHolder, "");
                List<PaySearchInfoModel> list = merchants;
                Intrinsics.checkNotNullParameter(list, "");
                OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) onlineMerchantViewHolder.itemView.findViewById(R.id.rv_list_online_merchant);
                if (onlineMerchantListView != null) {
                    onlineMerchantListView.setMerchantListItem(list);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda2(this, function1));
        }
    }

    public final void stopRefresh() {
        LoadingLottieAnimationView loadingLottieAnimationView = this.PlaceComponentResult;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.cancelAnimation();
    }

    public final void showLoadMoreBtn() {
        OnlineMerchantView$showLoadMoreBtn$1 onlineMerchantView$showLoadMoreBtn$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$showLoadMoreBtn$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                invoke2(onlineMerchantLoadMoreViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantLoadMoreViewHolder, "");
                AppCompatTextView appCompatTextView = (AppCompatTextView) onlineMerchantLoadMoreViewHolder.itemView.findViewById(R.id.btnLoadMoreMerchant);
                if (appCompatTextView != null) {
                    appCompatTextView.setVisibility(0);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda3(this, onlineMerchantView$showLoadMoreBtn$1));
        }
    }

    public final void hideLoadMoreBtn() {
        OnlineMerchantView$hideLoadMoreBtn$1 onlineMerchantView$hideLoadMoreBtn$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$hideLoadMoreBtn$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                invoke2(onlineMerchantLoadMoreViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantLoadMoreViewHolder, "");
                AppCompatTextView appCompatTextView = (AppCompatTextView) onlineMerchantLoadMoreViewHolder.itemView.findViewById(R.id.btnLoadMoreMerchant);
                if (appCompatTextView != null) {
                    appCompatTextView.setVisibility(4);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda3(this, onlineMerchantView$hideLoadMoreBtn$1));
        }
    }

    public final void showLoadingLoadMore() {
        OnlineMerchantView$showLoadingLoadMore$1 onlineMerchantView$showLoadingLoadMore$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$showLoadingLoadMore$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                invoke2(onlineMerchantLoadMoreViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantLoadMoreViewHolder, "");
                ProgressBar progressBar = (ProgressBar) onlineMerchantLoadMoreViewHolder.itemView.findViewById(R.id.FlowKt__MergeKt);
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda3(this, onlineMerchantView$showLoadingLoadMore$1));
        }
    }

    public final void hideLoadingLoadMore() {
        OnlineMerchantView$hideLoadingLoadMore$1 onlineMerchantView$hideLoadingLoadMore$1 = new Function1<OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder, Unit>() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$hideLoadingLoadMore$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                invoke2(onlineMerchantLoadMoreViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
                Intrinsics.checkNotNullParameter(onlineMerchantLoadMoreViewHolder, "");
                ProgressBar progressBar = (ProgressBar) onlineMerchantLoadMoreViewHolder.itemView.findViewById(R.id.FlowKt__MergeKt);
                if (progressBar != null) {
                    progressBar.setVisibility(4);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.post(new OnlineMerchantView$$ExternalSyntheticLambda3(this, onlineMerchantView$hideLoadingLoadMore$1));
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final boolean PlaceComponentResult() {
        return this.PlaceComponentResult != null;
    }

    public final void setViewOnError() {
        setEmptyStateVisibility(true);
        _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572).setVisibility(8);
        MyBillsEntityDataFactory(false);
    }

    public final void setViewOnSuccess() {
        setEmptyStateVisibility(false);
        MyBillsEntityDataFactory(true);
    }

    public final void setEmptyStateVisibility(boolean isVisible) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.cl_empty_state);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(isVisible ? 0 : 8);
        }
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.setVisibility(p0 ? 0 : 8);
        }
    }

    public final void setTryAgainClickListener(final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "");
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_try_again_empty_state);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnlineMerchantView.$r8$lambda$zHWSjub_Ae9qfL1kFSktN9wc1Xo(OnlineMerchantView.this, action, view);
                }
            });
        }
    }

    public final void setLoadMoreClickListener(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "");
        OnlineMerchantViewAdapter onlineMerchantViewAdapter = this.getAuthRequestContext;
        if (onlineMerchantViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onlineMerchantViewAdapter = null;
        }
        Intrinsics.checkNotNullParameter(action, "");
        onlineMerchantViewAdapter.BuiltInFictitiousFunctionClassFactory = action;
    }

    public final void setErrorStateOnView(int state) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.getCustomAttributesOrThrow);
        if (appCompatImageView != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, state == 1 ? R.drawable.ic_mp_search_not_found : R.drawable.ic_general_error_somethings_wrong);
            appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(state == 1 ? R.string.img_not_found : R.string.img_offline));
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1921_textviewkt_doaftertextchanged_inlined_addtextchangedlistener_default_1);
        if (textView != null) {
            textView.setText(textView.getContext().getString(state == 1 ? R.string.error_search_not_found_title : R.string.error_connection_title));
            textView.setContentDescription(textView.getContext().getString(state == 1 ? R.string.lbl_not_found_title : R.string.lbl_offline_title));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_subtitle_empty_state);
        if (textView2 != null) {
            textView2.setText(textView2.getContext().getString(state == 1 ? R.string.error_search_not_found_subtitle : R.string.error_connection_subtitle));
            textView2.setContentDescription(textView2.getContext().getString(state == 1 ? R.string.lbl_not_found_description : R.string.lbl_offline_description));
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_try_again_empty_state);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(state == 0 ? 0 : 8);
        }
    }

    public static /* synthetic */ void $r8$lambda$RXSeV0U_76x1zknovGw5MOirKQo(OnlineMerchantView onlineMerchantView, View view) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(onlineMerchantView, "");
        RecyclerView recyclerView = (RecyclerView) onlineMerchantView._$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        layoutManager.smoothScrollToPosition((RecyclerView) onlineMerchantView._$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3), new RecyclerView.State(), 0);
    }

    public static /* synthetic */ void $r8$lambda$YZisoaIcqDk9EU92p6ROGsL56S4(OnlineMerchantView onlineMerchantView, Function1 function1) {
        Intrinsics.checkNotNullParameter(onlineMerchantView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RecyclerView recyclerView = (RecyclerView) onlineMerchantView._$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder = (OnlineMerchantViewAdapter.OnlineMerchantViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(2) : null);
        if (onlineMerchantViewHolder != null) {
            function1.invoke(onlineMerchantViewHolder);
        }
    }

    public static /* synthetic */ void $r8$lambda$hERvJ1SSKeVSU0iMl3Zg3N5UG8c(OnlineMerchantView onlineMerchantView, Function1 function1) {
        Intrinsics.checkNotNullParameter(onlineMerchantView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RecyclerView recyclerView = (RecyclerView) onlineMerchantView._$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder = (OnlineMerchantViewAdapter.TrendingMerchantViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(1) : null);
        if (trendingMerchantViewHolder != null) {
            function1.invoke(trendingMerchantViewHolder);
        }
    }

    public static /* synthetic */ void $r8$lambda$pfDQ5901cvbe9UdZjlqIivfPjKM(OnlineMerchantView onlineMerchantView, Function1 function1) {
        Intrinsics.checkNotNullParameter(onlineMerchantView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RecyclerView recyclerView = (RecyclerView) onlineMerchantView._$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        OnlineMerchantViewAdapter.OnlineMerchantViewHolder onlineMerchantViewHolder = (OnlineMerchantViewAdapter.OnlineMerchantViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(0) : null);
        if (onlineMerchantViewHolder != null) {
            function1.invoke(onlineMerchantViewHolder);
        }
    }

    /* renamed from: $r8$lambda$qV3kimQOA-rLwbJXm-F2oL1n2YA */
    public static /* synthetic */ void m2771$r8$lambda$qV3kimQOArLwbJXmF2oL1n2YA(OnlineMerchantView onlineMerchantView, Function1 function1) {
        Intrinsics.checkNotNullParameter(onlineMerchantView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RecyclerView recyclerView = (RecyclerView) onlineMerchantView._$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder = (OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(3) : null);
        if (onlineMerchantLoadMoreViewHolder != null) {
            function1.invoke(onlineMerchantLoadMoreViewHolder);
        }
    }

    public static /* synthetic */ void $r8$lambda$zHWSjub_Ae9qfL1kFSktN9wc1Xo(OnlineMerchantView onlineMerchantView, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(onlineMerchantView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        onlineMerchantView.setEmptyStateVisibility(false);
        function0.invoke();
    }

    public static final /* synthetic */ void access$checkLoopingAnimationFinished(OnlineMerchantView onlineMerchantView) {
        LoadingLottieAnimationView loadingLottieAnimationView = onlineMerchantView.PlaceComponentResult;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.setupLoopMinMaxFrame(loadingLottieAnimationView);
        if (onlineMerchantView.stopRefreshAnimationOnRepeat) {
            loadingLottieAnimationView.setMaxFrame(loadingLottieAnimationView.getOutroMaxFrame());
            loadingLottieAnimationView.setLoopFinished(true);
        }
    }

    public final void hideTrendingOnlineMerchantSection() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        OnlineMerchantViewAdapter.TrendingMerchantViewHolder trendingMerchantViewHolder = (OnlineMerchantViewAdapter.TrendingMerchantViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(1) : null);
        if (trendingMerchantViewHolder != null) {
            View view = trendingMerchantViewHolder.itemView;
            View findViewById = view.findViewById(R.id.NotificationTarget);
            if (findViewById != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById, "");
                findViewById.setVisibility(8);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tv_title_online_merchant);
            if (appCompatTextView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(8);
            }
            OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) view.findViewById(R.id.rv_list_online_merchant);
            if (onlineMerchantListView != null) {
                Intrinsics.checkNotNullExpressionValue(onlineMerchantListView, "");
                onlineMerchantListView.setVisibility(8);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_online_merchant_list_section);
            if (constraintLayout != null) {
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout, null, Float.valueOf(0.0f), null, null, 13);
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_online_merchant_list_section);
            if (constraintLayout2 != null) {
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                constraintLayout2.setVisibility(8);
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        View headerView;
        PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_online_merchant);
        if (ptrClassicFrameLayout != null) {
            ptrClassicFrameLayout.setPtrHandler(new PtrHandler() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$initPullToRefresh$1
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                    return OnlineMerchantView.this.getOnlineMerchantState() == 0;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout p0) {
                    boolean PlaceComponentResult;
                    LoadingLottieAnimationView loadingLottieAnimationView;
                    PlaceComponentResult = OnlineMerchantView.this.PlaceComponentResult();
                    if (PlaceComponentResult) {
                        loadingLottieAnimationView = OnlineMerchantView.this.PlaceComponentResult;
                        if (loadingLottieAnimationView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            loadingLottieAnimationView = null;
                        }
                        loadingLottieAnimationView.playAnimation();
                    }
                    OnlineMerchantView.OnlineMerchantListener onlineMerchantListener = OnlineMerchantView.this.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String();
                    if (onlineMerchantListener != null) {
                        onlineMerchantListener.onRefresh();
                    }
                }
            });
        }
        PtrClassicFrameLayout ptrClassicFrameLayout2 = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_online_merchant);
        if (ptrClassicFrameLayout2 != null) {
            ptrClassicFrameLayout2.disableWhenHorizontalMove(true);
        }
        PtrClassicFrameLayout ptrClassicFrameLayout3 = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_online_merchant);
        LoadingLottieAnimationView loadingLottieAnimationView = null;
        if (ptrClassicFrameLayout3 != null) {
            ptrClassicFrameLayout3.setHeaderView(BaseRichView.inflate(getContext(), R.layout.view_pull_to_refresh_header, null));
        }
        PtrClassicFrameLayout ptrClassicFrameLayout4 = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_online_merchant);
        LoadingLottieAnimationView loadingLottieAnimationView2 = (ptrClassicFrameLayout4 == null || (headerView = ptrClassicFrameLayout4.getHeaderView()) == null) ? null : (LoadingLottieAnimationView) headerView.findViewById(R.id.lav_loading_animation);
        if (loadingLottieAnimationView2 != null) {
            this.PlaceComponentResult = loadingLottieAnimationView2;
            if (loadingLottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                loadingLottieAnimationView = loadingLottieAnimationView2;
            }
            loadingLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$initPullToRefreshHeader$1$1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator p0) {
                    LoadingLottieAnimationView loadingLottieAnimationView3;
                    Intrinsics.checkNotNullParameter(p0, "");
                    loadingLottieAnimationView3 = OnlineMerchantView.this.PlaceComponentResult;
                    if (loadingLottieAnimationView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView3 = null;
                    }
                    loadingLottieAnimationView3.setupIntroMinMaxFrame(loadingLottieAnimationView3);
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator p0) {
                    LoadingLottieAnimationView loadingLottieAnimationView3;
                    Intrinsics.checkNotNullParameter(p0, "");
                    PtrClassicFrameLayout ptrClassicFrameLayout5 = (PtrClassicFrameLayout) OnlineMerchantView.this._$_findCachedViewById(R.id.ptr_online_merchant);
                    if (ptrClassicFrameLayout5 != null) {
                        OnlineMerchantView onlineMerchantView = OnlineMerchantView.this;
                        loadingLottieAnimationView3 = onlineMerchantView.PlaceComponentResult;
                        if (loadingLottieAnimationView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            loadingLottieAnimationView3 = null;
                        }
                        loadingLottieAnimationView3.setLoopFinished(false);
                        onlineMerchantView.setStopRefreshAnimationOnRepeat(false);
                        ptrClassicFrameLayout5.refreshComplete();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator p0) {
                    boolean PlaceComponentResult;
                    LoadingLottieAnimationView loadingLottieAnimationView3;
                    Intrinsics.checkNotNullParameter(p0, "");
                    PlaceComponentResult = OnlineMerchantView.this.PlaceComponentResult();
                    if (PlaceComponentResult) {
                        loadingLottieAnimationView3 = OnlineMerchantView.this.PlaceComponentResult;
                        if (loadingLottieAnimationView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            loadingLottieAnimationView3 = null;
                        }
                        OnlineMerchantView onlineMerchantView = OnlineMerchantView.this;
                        if (loadingLottieAnimationView3.getIsLoopFinished()) {
                            loadingLottieAnimationView3.cancelAnimation();
                        } else {
                            OnlineMerchantView.access$checkLoopingAnimationFinished(onlineMerchantView);
                        }
                    }
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a4_userpocketassetsdao_impl_3);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$onRvOnlineMerchant$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    boolean BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    BuiltInFictitiousFunctionClassFactory = OnlineMerchantView.this.BuiltInFictitiousFunctionClassFactory();
                    boolean z = !BuiltInFictitiousFunctionClassFactory;
                    OnlineMerchantView.this._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572).setVisibility(r2 ? 0 : 8);
                    PtrClassicFrameLayout ptrClassicFrameLayout5 = (PtrClassicFrameLayout) OnlineMerchantView.this._$_findCachedViewById(R.id.ptr_online_merchant);
                    if (ptrClassicFrameLayout5 != null) {
                        ptrClassicFrameLayout5.setEnabled(BuiltInFictitiousFunctionClassFactory && OnlineMerchantView.this.getPullToRefreshEnable());
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrollStateChanged(p0, p1);
                    OnlineMerchantView.OnlineMerchantListener onlineMerchantListener = OnlineMerchantView.this.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String();
                    if (onlineMerchantListener != null) {
                        OnlineMerchantView onlineMerchantView = OnlineMerchantView.this;
                        if (p0.canScrollVertically(130) || !onlineMerchantListener.isHasOnlineMerchantsMore()) {
                            return;
                        }
                        onlineMerchantView.showLoadingLoadMore();
                        onlineMerchantView.hideLoadMoreBtn();
                        onlineMerchantListener.onTouchBottom();
                    }
                }
            });
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnlineMerchantView.$r8$lambda$RXSeV0U_76x1zknovGw5MOirKQo(OnlineMerchantView.this, view);
                }
            });
        }
    }
}
