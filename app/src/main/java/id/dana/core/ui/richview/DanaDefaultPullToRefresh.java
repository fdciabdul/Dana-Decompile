package id.dana.core.ui.richview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.perf.util.Constants;
import id.dana.core.ui.R;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-B\u0019\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b,\u00100B!\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\b,\u00102J+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0013R\"\u0010&\u001a\u00020\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0017R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lid/dana/core/ui/richview/DanaDefaultPullToRefresh;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "child", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "cancelRefreshProgress", "()V", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "getPullToRefreshView", "()Lin/srain/cube/views/ptr/PtrFrameLayout;", "Lid/dana/core/ui/richview/DanaPullToRefreshListener;", "danaPullToRefreshListener", "setDanaPullToRefreshListener", "(Lid/dana/core/ui/richview/DanaPullToRefreshListener;)V", "", Constants.ENABLE_DISABLE, "setEnable", "(Z)V", "drawableRes", "setHeaderBackground", "(I)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/richview/DanaPullToRefreshListener;", "getDanaPtrListener", "()Lid/dana/core/ui/richview/DanaPullToRefreshListener;", "setDanaPtrListener", "danaPtrListener", "MyBillsEntityDataFactory", "Z", "getDoneRefreshing", "()Z", "setDoneRefreshing", "doneRefreshing", "PlaceComponentResult", "I", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaDefaultPullToRefresh extends ConstraintLayout {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DanaPullToRefreshListener danaPtrListener;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean doneRefreshing;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

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

    @JvmName(name = "getDoneRefreshing")
    public final boolean getDoneRefreshing() {
        return this.doneRefreshing;
    }

    @JvmName(name = "setDoneRefreshing")
    public final void setDoneRefreshing(boolean z) {
        this.doneRefreshing = z;
    }

    @JvmName(name = "getDanaPtrListener")
    public final DanaPullToRefreshListener getDanaPtrListener() {
        return this.danaPtrListener;
    }

    @JvmName(name = "setDanaPtrListener")
    public final void setDanaPtrListener(DanaPullToRefreshListener danaPullToRefreshListener) {
        this.danaPtrListener = danaPullToRefreshListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaDefaultPullToRefresh(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = R.color.MyBillsEntityDataFactory;
        View.inflate(getContext(), R.layout.BuiltInFictitiousFunctionClassFactory, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaDefaultPullToRefresh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = R.color.MyBillsEntityDataFactory;
        View.inflate(getContext(), R.layout.BuiltInFictitiousFunctionClassFactory, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaDefaultPullToRefresh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = R.color.MyBillsEntityDataFactory;
        View.inflate(getContext(), R.layout.BuiltInFictitiousFunctionClassFactory, this);
    }

    public final void setDanaPullToRefreshListener(final DanaPullToRefreshListener danaPullToRefreshListener) {
        Intrinsics.checkNotNullParameter(danaPullToRefreshListener, "");
        this.danaPtrListener = danaPullToRefreshListener;
        PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_frame_layout);
        if (ptrClassicFrameLayout != null) {
            ptrClassicFrameLayout.addPtrUIHandler(new PtrUIHandler() { // from class: id.dana.core.ui.richview.DanaDefaultPullToRefresh$setupPullToRefreshLayout$1
                @Override // in.srain.cube.views.ptr.PtrUIHandler
                public final void onUIPositionChange(PtrFrameLayout p0, boolean p1, byte p2, PtrIndicator p3) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p3, "");
                }

                @Override // in.srain.cube.views.ptr.PtrUIHandler
                public final void onUIRefreshBegin(PtrFrameLayout p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // in.srain.cube.views.ptr.PtrUIHandler
                public final void onUIRefreshComplete(PtrFrameLayout p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // in.srain.cube.views.ptr.PtrUIHandler
                public final void onUIReset(PtrFrameLayout p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ((PtrClassicFrameLayout) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.ptr_frame_layout)).setBackground(null);
                }

                @Override // in.srain.cube.views.ptr.PtrUIHandler
                public final void onUIRefreshPrepare(PtrFrameLayout p0) {
                    int i;
                    Intrinsics.checkNotNullParameter(p0, "");
                    Context context = DanaDefaultPullToRefresh.this.getContext();
                    if (context != null) {
                        DanaDefaultPullToRefresh danaDefaultPullToRefresh = DanaDefaultPullToRefresh.this;
                        PtrClassicFrameLayout ptrClassicFrameLayout2 = (PtrClassicFrameLayout) danaDefaultPullToRefresh._$_findCachedViewById(R.id.ptr_frame_layout);
                        i = danaDefaultPullToRefresh.getAuthRequestContext;
                        ptrClassicFrameLayout2.setBackground(ContextCompat.PlaceComponentResult(context, i));
                    }
                }
            });
        }
        PtrClassicFrameLayout ptrClassicFrameLayout2 = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_frame_layout);
        if (ptrClassicFrameLayout2 != null) {
            ptrClassicFrameLayout2.setPtrHandler(new PtrHandler() { // from class: id.dana.core.ui.richview.DanaDefaultPullToRefresh$setupPullToRefreshLayout$2
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                    return true;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    LoadingLottieAnimationView loadingLottieAnimationView = (LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation);
                    if (loadingLottieAnimationView != null) {
                        loadingLottieAnimationView.playAnimation();
                    }
                    DanaPullToRefreshListener danaPtrListener = DanaDefaultPullToRefresh.this.getDanaPtrListener();
                    if (danaPtrListener != null) {
                        danaPtrListener.PlaceComponentResult(p0);
                    }
                }
            });
        }
        PtrClassicFrameLayout ptrClassicFrameLayout3 = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_frame_layout);
        if (ptrClassicFrameLayout3 != null) {
            ptrClassicFrameLayout3.disableWhenHorizontalMove(true);
        }
        PtrClassicFrameLayout ptrClassicFrameLayout4 = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_frame_layout);
        if (ptrClassicFrameLayout4 != null) {
            ptrClassicFrameLayout4.setHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        }
        LoadingLottieAnimationView loadingLottieAnimationView = (LoadingLottieAnimationView) _$_findCachedViewById(R.id.lav_loading_animation);
        if (loadingLottieAnimationView != null) {
            loadingLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: id.dana.core.ui.richview.DanaDefaultPullToRefresh$setupPullToRefreshLayout$3
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    LoadingLottieAnimationView loadingLottieAnimationView2 = (LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation);
                    if (loadingLottieAnimationView2 != null) {
                        LoadingLottieAnimationView loadingLottieAnimationView3 = (LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation);
                        Intrinsics.checkNotNullExpressionValue(loadingLottieAnimationView3, "");
                        loadingLottieAnimationView2.setupIntroMinMaxFrame(loadingLottieAnimationView3);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    LoadingLottieAnimationView loadingLottieAnimationView2 = (LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation);
                    if (loadingLottieAnimationView2 != null) {
                        loadingLottieAnimationView2.setLoopFinished(false);
                    }
                    DanaDefaultPullToRefresh.this.setDoneRefreshing(false);
                    danaPullToRefreshListener.BuiltInFictitiousFunctionClassFactory();
                    ((PtrClassicFrameLayout) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.ptr_frame_layout)).refreshComplete();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (((LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation)) != null && ((LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation)).getIsLoopFinished()) {
                        LoadingLottieAnimationView loadingLottieAnimationView2 = (LoadingLottieAnimationView) DanaDefaultPullToRefresh.this._$_findCachedViewById(R.id.lav_loading_animation);
                        if (loadingLottieAnimationView2 != null) {
                            loadingLottieAnimationView2.cancelAnimation();
                            return;
                        }
                        return;
                    }
                    DanaDefaultPullToRefresh.access$checkLoopingAnimationFinished(DanaDefaultPullToRefresh.this);
                }
            });
        }
    }

    public final void setHeaderBackground(int drawableRes) {
        this.getAuthRequestContext = drawableRes;
    }

    public final PtrFrameLayout getPullToRefreshView() {
        PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_frame_layout);
        Intrinsics.checkNotNullExpressionValue(ptrClassicFrameLayout, "");
        return ptrClassicFrameLayout;
    }

    public final void cancelRefreshProgress() {
        this.doneRefreshing = true;
    }

    public final void setEnable(boolean isEnabled) {
        ((PtrClassicFrameLayout) _$_findCachedViewById(R.id.ptr_frame_layout)).setEnabled(isEnabled);
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int index, ViewGroup.LayoutParams params) {
        Unit unit;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.getErrorConfigVersion);
        if (frameLayout != null) {
            frameLayout.addView(child, index, params);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.addView(child, index, params);
        }
    }

    public static final /* synthetic */ void access$checkLoopingAnimationFinished(DanaDefaultPullToRefresh danaDefaultPullToRefresh) {
        LoadingLottieAnimationView loadingLottieAnimationView = (LoadingLottieAnimationView) danaDefaultPullToRefresh._$_findCachedViewById(R.id.lav_loading_animation);
        if (loadingLottieAnimationView != null) {
            loadingLottieAnimationView.setupLoopMinMaxFrame(loadingLottieAnimationView);
            if (danaDefaultPullToRefresh.doneRefreshing) {
                loadingLottieAnimationView.setMaxFrame(loadingLottieAnimationView.getOutroMaxFrame());
                loadingLottieAnimationView.setLoopFinished(true);
            }
        }
    }
}
