package id.dana.social.v2.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/social/v2/view/FeedPullToRefreshView;", "Lin/srain/cube/views/ptr/PtrClassicFrameLayout;", "Landroid/view/LayoutInflater;", "layoutInflater", "Lkotlin/Function0;", "", "onRefresh", "initPullToRefreshView", "(Landroid/view/LayoutInflater;Lkotlin/jvm/functions/Function0;)V", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "Z", "getDoneRefreshing", "setDoneRefreshing", "(Z)V", "doneRefreshing", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "PlaceComponentResult", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedPullToRefreshView extends PtrClassicFrameLayout {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean doneRefreshing;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private LoadingLottieAnimationView KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedPullToRefreshView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedPullToRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPullToRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FeedPullToRefreshView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getDoneRefreshing")
    public final boolean getDoneRefreshing() {
        return this.doneRefreshing;
    }

    @JvmName(name = "setDoneRefreshing")
    public final void setDoneRefreshing(boolean z) {
        this.doneRefreshing = z;
    }

    public final void initPullToRefreshView(LayoutInflater layoutInflater, final Function0<Unit> onRefresh) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(onRefresh, "");
        LoadingLottieAnimationView loadingLottieAnimationView = null;
        setHeaderView(layoutInflater.inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        View headerView = getHeaderView();
        LoadingLottieAnimationView loadingLottieAnimationView2 = headerView != null ? (LoadingLottieAnimationView) headerView.findViewById(R.id.lav_loading_animation) : null;
        if (loadingLottieAnimationView2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.core.ui.richview.LoadingLottieAnimationView");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loadingLottieAnimationView2;
        if (loadingLottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            loadingLottieAnimationView = loadingLottieAnimationView2;
        }
        loadingLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.social.v2.view.FeedPullToRefreshView$initLoadingAnimationListener$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                LoadingLottieAnimationView loadingLottieAnimationView3;
                LoadingLottieAnimationView loadingLottieAnimationView4;
                Intrinsics.checkNotNullParameter(p0, "");
                loadingLottieAnimationView3 = FeedPullToRefreshView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                LoadingLottieAnimationView loadingLottieAnimationView5 = null;
                if (loadingLottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    loadingLottieAnimationView3 = null;
                }
                loadingLottieAnimationView4 = FeedPullToRefreshView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (loadingLottieAnimationView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    loadingLottieAnimationView5 = loadingLottieAnimationView4;
                }
                loadingLottieAnimationView3.setupIntroMinMaxFrame(loadingLottieAnimationView5);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p0) {
                LoadingLottieAnimationView loadingLottieAnimationView3;
                Intrinsics.checkNotNullParameter(p0, "");
                loadingLottieAnimationView3 = FeedPullToRefreshView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (loadingLottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    loadingLottieAnimationView3 = null;
                }
                loadingLottieAnimationView3.setLoopFinished(false);
                FeedPullToRefreshView.this.refreshComplete();
                FeedPullToRefreshView.this.setDoneRefreshing(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                boolean BuiltInFictitiousFunctionClassFactory;
                LoadingLottieAnimationView loadingLottieAnimationView3;
                Intrinsics.checkNotNullParameter(p0, "");
                BuiltInFictitiousFunctionClassFactory = FeedPullToRefreshView.this.BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory) {
                    loadingLottieAnimationView3 = FeedPullToRefreshView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (loadingLottieAnimationView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView3 = null;
                    }
                    FeedPullToRefreshView feedPullToRefreshView = FeedPullToRefreshView.this;
                    if (loadingLottieAnimationView3.getIsLoopFinished()) {
                        loadingLottieAnimationView3.cancelAnimation();
                    } else {
                        FeedPullToRefreshView.access$checkLoopingAnimationFinished(feedPullToRefreshView);
                    }
                }
            }
        });
        setPtrHandler(new PtrHandler() { // from class: id.dana.social.v2.view.FeedPullToRefreshView$initPullToRefreshView$1$2
            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                LoadingLottieAnimationView loadingLottieAnimationView3;
                LoadingLottieAnimationView loadingLottieAnimationView4;
                loadingLottieAnimationView3 = FeedPullToRefreshView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (loadingLottieAnimationView3 != null) {
                    loadingLottieAnimationView4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (loadingLottieAnimationView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView4 = null;
                    }
                    loadingLottieAnimationView4.playAnimation();
                    onRefresh.invoke();
                }
            }
        });
        disableWhenHorizontalMove(true);
        addPtrUIHandler(new PtrUIHandler() { // from class: id.dana.social.v2.view.FeedPullToRefreshView$initPullToRefreshView$2
            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIPositionChange(PtrFrameLayout p0, boolean p1, byte p2, PtrIndicator p3) {
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIRefreshBegin(PtrFrameLayout p0) {
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIRefreshComplete(PtrFrameLayout p0) {
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIReset(PtrFrameLayout p0) {
                FeedPullToRefreshView.this.setBackground(null);
            }

            @Override // in.srain.cube.views.ptr.PtrUIHandler
            public final void onUIRefreshPrepare(PtrFrameLayout p0) {
                FeedPullToRefreshView feedPullToRefreshView = FeedPullToRefreshView.this;
                feedPullToRefreshView.setBackground(ContextCompat.PlaceComponentResult(feedPullToRefreshView.getContext(), (int) R.color.f23182131099816));
            }
        });
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != null;
    }

    public static final /* synthetic */ void access$checkLoopingAnimationFinished(FeedPullToRefreshView feedPullToRefreshView) {
        if (feedPullToRefreshView.BuiltInFictitiousFunctionClassFactory()) {
            LoadingLottieAnimationView loadingLottieAnimationView = feedPullToRefreshView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (loadingLottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                loadingLottieAnimationView = null;
            }
            loadingLottieAnimationView.setupLoopMinMaxFrame(loadingLottieAnimationView);
            if (feedPullToRefreshView.doneRefreshing) {
                loadingLottieAnimationView.setMaxFrame(loadingLottieAnimationView.getOutroMaxFrame());
                loadingLottieAnimationView.setLoopFinished(true);
            }
        }
    }
}
