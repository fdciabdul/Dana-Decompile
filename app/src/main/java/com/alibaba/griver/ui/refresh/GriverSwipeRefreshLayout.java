package com.alibaba.griver.ui.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.refresh.LoadMoreFooter;
import com.alibaba.griver.ui.refresh.RefreshHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverSwipeRefreshLayout extends ViewGroup {
    private boolean A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private volatile List<WMLAScrollerInfo> K;
    private int L;
    private OnReachDistanceRefreshListener M;
    private Animator.AnimatorListener N;

    /* renamed from: a */
    private View f6749a;
    private boolean b;
    private RefreshHeader c;
    private LoadMoreFooter d;
    private int e;
    private int f;
    private OnPullRefreshListener g;
    private OnPushLoadMoreListener h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    protected int mCurrentTargetOffsetTop;
    protected float mDensity;
    protected DisplayMetrics mDisplayMetrics;
    protected int mFooterViewHeight;
    protected int mFooterViewWidth;
    protected int mFrom;
    protected int mHeaderViewHeight;
    protected int mHeaderViewWidth;
    protected int mOriginalOffsetTop;
    protected int mRefreshOffset;
    protected int mTouchSlop;
    private boolean n;

    /* renamed from: o */
    private boolean f6750o;
    private int p;
    private boolean q;
    private float r;
    private int s;
    private int t;
    private float u;
    private boolean v;
    private int w;
    private int x;
    private DecelerateInterpolator y;
    private long z;

    /* loaded from: classes6.dex */
    public interface OnPullRefreshListener {
        void onPullDistance(int i);

        void onRefresh();

        void onRefreshStateChanged(RefreshHeader.RefreshState refreshState, RefreshHeader.RefreshState refreshState2);
    }

    /* loaded from: classes6.dex */
    public interface OnPushLoadMoreListener {
        void onLoadMore();

        void onLoadMoreStateChanged(LoadMoreFooter.LoadMoreState loadMoreState, LoadMoreFooter.LoadMoreState loadMoreState2);

        void onPushDistance(int i);
    }

    /* loaded from: classes6.dex */
    public interface OnReachDistanceRefreshListener {
        void onMotionEventUp();

        boolean onReachPullRefreshDistance();

        void onRefresh();
    }

    public GriverSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public GriverSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        this.f = -1;
        this.m = true;
        this.p = -1;
        this.r = 1.0f;
        this.s = -1;
        this.t = -1;
        this.v = true;
        this.w = 0;
        this.z = 2000L;
        this.A = false;
        this.F = 0;
        this.G = 0;
        this.H = -1;
        this.I = 0;
        this.J = -1;
        this.K = new ArrayList();
        this.L = 0;
        this.N = new Animator.AnimatorListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (GriverSwipeRefreshLayout.this.b) {
                    if (GriverSwipeRefreshLayout.this.l) {
                        if (GriverSwipeRefreshLayout.this.g != null) {
                            GriverSwipeRefreshLayout.this.g.onRefresh();
                        }
                        if (GriverSwipeRefreshLayout.this.M != null) {
                            GriverSwipeRefreshLayout.this.M.onRefresh();
                        }
                    }
                    GriverSwipeRefreshLayout.this.c.changeToState(RefreshHeader.RefreshState.REFRESHING);
                } else {
                    GriverSwipeRefreshLayout griverSwipeRefreshLayout = GriverSwipeRefreshLayout.this;
                    griverSwipeRefreshLayout.updateHeaderPosition(griverSwipeRefreshLayout.mOriginalOffsetTop - GriverSwipeRefreshLayout.this.mCurrentTargetOffsetTop);
                }
                GriverSwipeRefreshLayout griverSwipeRefreshLayout2 = GriverSwipeRefreshLayout.this;
                griverSwipeRefreshLayout2.mCurrentTargetOffsetTop = griverSwipeRefreshLayout2.c.getTop();
                GriverSwipeRefreshLayout.this.e();
            }
        };
        setWillNotDraw(false);
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mDisplayMetrics = displayMetrics;
        this.mDensity = displayMetrics.density;
        this.i = false;
        this.j = false;
        this.k = false;
        this.mHeaderViewWidth = this.mDisplayMetrics.widthPixels;
        this.mHeaderViewHeight = (int) (this.mDensity * 48.0f);
        this.mFooterViewWidth = this.mDisplayMetrics.widthPixels;
        this.mFooterViewHeight = (int) (this.mDensity * 50.0f);
        this.y = new DecelerateInterpolator(2.0f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        a();
        b();
        ViewCompat.PlaceComponentResult((ViewGroup) this, true);
        this.mRefreshOffset = 0;
        float f = this.mDensity;
        int i = (int) (48.0f * f);
        this.s = i;
        this.t = (int) (i + (20.0f * f));
        this.x = (int) (f * 100.0f);
        this.J = this.mDisplayMetrics.heightPixels;
    }

    public void setPullRefreshDistance(int i) {
        this.L = (int) (i * this.mDensity);
    }

    public void setReachDistanceRefreshListener(OnReachDistanceRefreshListener onReachDistanceRefreshListener) {
        this.M = onReachDistanceRefreshListener;
    }

    private void a() {
        GriverRefreshHeader griverRefreshHeader = new GriverRefreshHeader(getContext());
        this.c = griverRefreshHeader;
        OnPullRefreshListener onPullRefreshListener = this.g;
        if (onPullRefreshListener != null) {
            griverRefreshHeader.setPullRefreshListener(onPullRefreshListener);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(this.c, layoutParams);
    }

    private void b() {
        GriverLoadMoreFooter griverLoadMoreFooter = new GriverLoadMoreFooter(getContext());
        this.d = griverLoadMoreFooter;
        OnPushLoadMoreListener onPushLoadMoreListener = this.h;
        if (onPushLoadMoreListener != null) {
            griverLoadMoreFooter.setPushLoadMoreListener(onPushLoadMoreListener);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mFooterViewHeight);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        addView(this.d, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.e;
        if (i3 >= 0 || this.f >= 0) {
            if (i2 == i - 2) {
                return i3;
            }
            if (i2 == i - 1) {
                return this.f;
            }
            int i4 = this.f;
            int i5 = i4 > i3 ? i4 : i3;
            if (i4 < i3) {
                i3 = i4;
            }
            return (i2 < i3 || i2 >= i5 + (-1)) ? (i2 >= i5 || i2 == i5 + (-1)) ? i2 + 2 : i2 : i2 + 1;
        }
        return i2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f6749a == null) {
            c();
        }
        View view = this.f6749a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.mHeaderViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDisplayMetrics.heightPixels, 1073741824));
        this.d.measure(View.MeasureSpec.makeMeasureSpec(this.mFooterViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.x, 1073741824));
        if ("huawei".equalsIgnoreCase(Build.BRAND) && this.J != -1) {
            int i3 = this.mDisplayMetrics.heightPixels;
            int i4 = this.J;
            if (i3 != i4 && this.mCurrentTargetOffsetTop == (-i4)) {
                int i5 = (-this.c.getMeasuredHeight()) + this.mRefreshOffset;
                this.mOriginalOffsetTop = i5;
                this.mCurrentTargetOffsetTop = i5;
                this.J = this.mDisplayMetrics.heightPixels;
            }
        }
        if (!this.q) {
            this.q = true;
            int i6 = (-this.c.getMeasuredHeight()) + this.mRefreshOffset;
            this.mOriginalOffsetTop = i6;
            this.mCurrentTargetOffsetTop = i6;
            e();
        }
        this.e = -1;
        int i7 = 0;
        while (true) {
            if (i7 >= getChildCount()) {
                break;
            } else if (getChildAt(i7) == this.c) {
                this.e = i7;
                break;
            } else {
                i7++;
            }
        }
        this.f = -1;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if (getChildAt(i8) == this.d) {
                this.f = i8;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f6749a == null) {
            c();
        }
        if (this.f6749a == null) {
            return;
        }
        int measuredHeight2 = this.mCurrentTargetOffsetTop + this.c.getMeasuredHeight();
        if (!this.m) {
            measuredHeight2 = 0;
        }
        View view = this.f6749a;
        int paddingLeft = getPaddingLeft();
        int paddingTop = (getPaddingTop() + measuredHeight2) - this.w;
        int paddingLeft2 = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        view.layout(paddingLeft, this.v ? paddingTop : paddingTop - this.mRefreshOffset, ((measuredWidth - paddingLeft2) - paddingRight) + paddingLeft, (paddingTop + ((measuredHeight - paddingTop2) - getPaddingBottom())) - this.mRefreshOffset);
        RefreshHeader refreshHeader = this.c;
        int i5 = this.mCurrentTargetOffsetTop;
        refreshHeader.layout(0, i5, this.mHeaderViewWidth, this.mDisplayMetrics.heightPixels + i5);
        if (!this.k && this.c.getSecondFloorView() != null) {
            this.c.getSecondFloorView().setVisibility(8);
        }
        LoadMoreFooter loadMoreFooter = this.d;
        int i6 = this.w;
        loadMoreFooter.layout(0, measuredHeight - i6, this.mFooterViewWidth, (measuredHeight + this.x) - i6);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionIndex;
        int actionIndex2;
        c();
        int PlaceComponentResult = MotionEventCompat.PlaceComponentResult(motionEvent);
        boolean isChildScrollToTop = this.i ? isChildScrollToTop(motionEvent) : false;
        if (!isChildScrollToTop && this.c.getCurrentState() != RefreshHeader.RefreshState.NONE) {
            isChildScrollToTop = true;
        }
        boolean isChildScrollToBottom = this.j ? isChildScrollToBottom(motionEvent) : false;
        if (!isChildScrollToBottom && this.d.getCurrentState() != LoadMoreFooter.LoadMoreState.NONE) {
            isChildScrollToBottom = true;
        }
        if (isChildScrollToTop || isChildScrollToBottom) {
            if (PlaceComponentResult == 0) {
                this.C = (int) motionEvent.getY();
                actionIndex = motionEvent.getActionIndex();
                if (this.p == -1) {
                    this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, actionIndex);
                    this.B = motionEvent.getY();
                    this.H = this.p;
                }
                this.f6750o = false;
                float a2 = a(motionEvent, this.p);
                if (a2 == -1.0f) {
                    return false;
                }
                this.u = a2;
                this.c.getCurrentState();
                RefreshHeader.RefreshState refreshState = RefreshHeader.RefreshState.REFRESHING;
                if (this.d.getCurrentState() == LoadMoreFooter.LoadMoreState.LOADING) {
                    setLoadMore(false);
                }
            } else {
                if (PlaceComponentResult != 1) {
                    if (PlaceComponentResult == 2) {
                        int i = this.p;
                        if (i == -1) {
                            actionIndex2 = motionEvent.getActionIndex();
                            InstrumentInjector.log_e("SwipeRefreshLayout", "Got ACTION_MOVE event but don't have an active pointer id.");
                            this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, actionIndex2);
                            this.B = motionEvent.getY();
                            this.H = this.p;
                            this.C = (int) motionEvent.getY();
                            float a3 = a(motionEvent, this.p);
                            if (a3 == -1.0f) {
                                return false;
                            }
                            this.u = a3;
                            return false;
                        }
                        float a4 = a(motionEvent, i);
                        if (a4 == -1.0f) {
                            return false;
                        }
                        if (isChildScrollToBottom(motionEvent)) {
                            if (this.u - a4 > this.mTouchSlop && !this.f6750o) {
                                this.f6750o = true;
                            }
                        } else if (isChildScrollToTop(motionEvent)) {
                            float f = a4 - this.u;
                            if (f > this.mTouchSlop && !this.f6750o) {
                                this.f6750o = true;
                            } else if (f < 0.0f && this.c.getCurrentState() == RefreshHeader.RefreshState.REFRESHING) {
                                setRefreshing(false);
                            }
                        }
                    } else if (PlaceComponentResult != 3) {
                        if (PlaceComponentResult == 6) {
                            a(motionEvent);
                        }
                    }
                }
                if (this.f6750o) {
                    onTouchEvent(motionEvent);
                    this.f6750o = false;
                }
                this.G = 0;
                this.I = 0;
                this.p = -1;
            }
            if (this.f6750o) {
                GriverLogger.d("SwipeRefreshLayout", "onInterceptTouchEvent: mIsBeingDragged");
                onTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    private float a(MotionEvent motionEvent, int i) {
        int BuiltInFictitiousFunctionClassFactory = MotionEventCompat.BuiltInFictitiousFunctionClassFactory(motionEvent, i);
        if (BuiltInFictitiousFunctionClassFactory < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getAuthRequestContext(motionEvent, BuiltInFictitiousFunctionClassFactory);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int PlaceComponentResult = MotionEventCompat.PlaceComponentResult(motionEvent);
        boolean isChildScrollToTop = this.i ? isChildScrollToTop(motionEvent) : false;
        if (!isChildScrollToTop && this.c.getCurrentState() != RefreshHeader.RefreshState.NONE) {
            isChildScrollToTop = true;
        }
        if (this.c.getCurrentState() == RefreshHeader.RefreshState.SECOND_FLOOR_START || this.c.getCurrentState() == RefreshHeader.RefreshState.SECOND_FLOOR_END) {
            isChildScrollToTop = false;
        }
        boolean isChildScrollToBottom = this.j ? isChildScrollToBottom(motionEvent) : false;
        boolean z = (isChildScrollToBottom || this.d.getCurrentState() == LoadMoreFooter.LoadMoreState.NONE) ? isChildScrollToBottom : true;
        if (isChildScrollToTop || z) {
            if (isChildScrollToTop) {
                return b(motionEvent, PlaceComponentResult);
            }
            if (z) {
                return c(motionEvent, PlaceComponentResult);
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onTouchEvent: ");
        sb.append(isChildScrollToTop);
        GriverLogger.d("SwipeRefreshLayout", sb.toString());
        return false;
    }

    private boolean b(MotionEvent motionEvent, int i) {
        int i2;
        int i3;
        OnReachDistanceRefreshListener onReachDistanceRefreshListener;
        int actionIndex;
        int actionIndex2;
        if (i != 1) {
            if (i == 2) {
                if (this.p == -1) {
                    actionIndex = motionEvent.getActionIndex();
                    this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, actionIndex);
                    this.B = motionEvent.getY();
                    this.H = this.p;
                }
                try {
                    int authRequestContext = (int) MotionEventCompat.getAuthRequestContext(motionEvent, d(motionEvent, this.p));
                    StringBuilder sb = new StringBuilder();
                    sb.append("mStartY = ");
                    sb.append(this.C);
                    sb.append(" getY = ");
                    sb.append(motionEvent.getY());
                    GriverLogger.d("handlePullTouchEvent", sb.toString());
                    if (this.A) {
                        int i4 = this.H;
                        int i5 = this.p;
                        if (i4 == i5) {
                            float f = this.D;
                            float f2 = authRequestContext - this.B;
                            i3 = (int) (f + f2);
                            i2 = i3 - this.E;
                            this.E = i3;
                            this.G = (int) (this.F + f2);
                        } else {
                            int i6 = this.E;
                            int i7 = (int) (i6 + (authRequestContext - this.B));
                            int i8 = this.G;
                            this.H = i5;
                            this.D = i6;
                            this.F = i8;
                            i3 = i7;
                            i2 = 0;
                        }
                    } else {
                        int i9 = this.G;
                        if (i9 == 0) {
                            i9 = this.C;
                        }
                        i2 = authRequestContext - i9;
                        i3 = authRequestContext - this.C;
                        this.D = i3;
                        this.E = i3;
                        this.F = authRequestContext;
                        this.G = authRequestContext;
                    }
                    this.I += i2;
                    if (this.f6750o) {
                        int i10 = (int) (i3 * this.r);
                        int measuredHeight = this.f6749a.getMeasuredHeight();
                        double abs = measuredHeight - Math.abs(this.f6749a.getY());
                        Double.isNaN(abs);
                        double d = measuredHeight;
                        Double.isNaN(d);
                        double d2 = ((abs / 1.0d) / d) * 0.4000000059604645d;
                        if (d2 <= 0.01d) {
                            d2 = 0.01d;
                        }
                        double d3 = i10;
                        Double.isNaN(d3);
                        int min = Math.min(this.mDisplayMetrics.heightPixels, (int) (d3 * d2));
                        if (min >= this.L && (onReachDistanceRefreshListener = this.M) != null) {
                            onReachDistanceRefreshListener.onReachPullRefreshDistance();
                        }
                        float f3 = (min * 1.0f) / this.s;
                        if (f3 < 0.0f) {
                            return false;
                        }
                        float min2 = Math.min(1.0f, Math.abs(f3));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("dragPercent = ");
                        sb2.append(min2);
                        GriverLogger.d("SwipeRefreshLayout", sb2.toString());
                        int top = this.mDisplayMetrics.heightPixels + this.c.getTop();
                        if (top < this.s) {
                            this.c.changeToState(RefreshHeader.RefreshState.PULL_TO_REFRESH);
                        } else if (this.k) {
                            if (top > this.t) {
                                this.c.changeToState(RefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR);
                            } else {
                                this.c.changeToState(RefreshHeader.RefreshState.RELEASE_TO_REFRESH);
                            }
                        } else {
                            this.c.changeToState(RefreshHeader.RefreshState.RELEASE_TO_REFRESH);
                        }
                        this.c.setProgress(min2);
                        if (i2 >= 0) {
                            double d4 = i2;
                            Double.isNaN(d4);
                            updateHeaderPosition((int) Math.ceil(d4 * d2));
                        } else if (top <= 0) {
                            updateHeaderPosition(0);
                        } else {
                            updateHeaderPosition(i2);
                        }
                    }
                } catch (IllegalArgumentException unused) {
                }
            } else if (i != 3) {
                if (i == 5) {
                    actionIndex2 = motionEvent.getActionIndex();
                    if (actionIndex2 < 0) {
                        return false;
                    }
                    this.B = MotionEventCompat.getAuthRequestContext(motionEvent, actionIndex2);
                    this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, actionIndex2);
                    this.A = true;
                } else if (i == 6) {
                    a(motionEvent);
                }
            }
            return true;
        }
        OnReachDistanceRefreshListener onReachDistanceRefreshListener2 = this.M;
        if (onReachDistanceRefreshListener2 != null) {
            onReachDistanceRefreshListener2.onMotionEventUp();
        }
        if (this.p == -1) {
            if (i == 1) {
                InstrumentInjector.log_e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
            }
            return false;
        }
        this.f6750o = false;
        if (this.c.getCurrentState() == RefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR && this.k) {
            this.c.changeToState(RefreshHeader.RefreshState.SECOND_FLOOR_START);
            c(this.mCurrentTargetOffsetTop, new Animator.AnimatorListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                {
                    GriverSwipeRefreshLayout.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GriverSwipeRefreshLayout.this.c.changeToState(RefreshHeader.RefreshState.SECOND_FLOOR_END);
                }
            });
        } else if (this.c.getCurrentState() == RefreshHeader.RefreshState.RELEASE_TO_REFRESH) {
            a(true, true);
        } else {
            this.b = false;
            this.c.changeToState(RefreshHeader.RefreshState.NONE);
            b(this.mCurrentTargetOffsetTop, (Animator.AnimatorListener) null);
        }
        this.p = -1;
        this.A = false;
        this.D = 0;
        this.F = 0;
        return false;
    }

    private boolean c(MotionEvent motionEvent, int i) {
        int actionIndex;
        if (i == 0) {
            this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, 0);
            this.f6750o = false;
        } else {
            if (i != 1) {
                if (i == 2) {
                    int BuiltInFictitiousFunctionClassFactory = MotionEventCompat.BuiltInFictitiousFunctionClassFactory(motionEvent, this.p);
                    if (BuiltInFictitiousFunctionClassFactory < 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Got ACTION_MOVE event but have an invalid active pointer id. ");
                        sb.append(this.p);
                        InstrumentInjector.log_e("SwipeRefreshLayout", sb.toString());
                        return false;
                    }
                    float authRequestContext = MotionEventCompat.getAuthRequestContext(motionEvent, BuiltInFictitiousFunctionClassFactory);
                    float f = this.u;
                    float f2 = this.r;
                    if (this.f6750o) {
                        this.w = Math.min((int) ((f - authRequestContext) * f2), this.x);
                        d();
                        if (this.h != null) {
                            if (this.w >= this.mFooterViewHeight) {
                                this.d.changeToState(LoadMoreFooter.LoadMoreState.RELEASE_TO_LOAD);
                            } else {
                                this.d.changeToState(LoadMoreFooter.LoadMoreState.PUSH_TO_LOAD);
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 5) {
                        actionIndex = motionEvent.getActionIndex();
                        this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, actionIndex);
                    } else if (i == 6) {
                        a(motionEvent);
                    }
                }
            }
            int i2 = this.p;
            if (i2 == -1) {
                if (i == 1) {
                    InstrumentInjector.log_e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            int BuiltInFictitiousFunctionClassFactory2 = MotionEventCompat.BuiltInFictitiousFunctionClassFactory(motionEvent, i2);
            if (BuiltInFictitiousFunctionClassFactory2 < 0) {
                return false;
            }
            float min = Math.min((this.u - MotionEventCompat.getAuthRequestContext(motionEvent, BuiltInFictitiousFunctionClassFactory2)) * this.r, this.x);
            this.f6750o = false;
            this.p = -1;
            int i3 = this.mFooterViewHeight;
            if (min < i3 || this.h == null) {
                this.w = 0;
            } else {
                this.w = i3;
            }
            a((int) min, this.w);
            return false;
        }
        return true;
    }

    private void c() {
        if (this.f6749a == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.c) && !childAt.equals(this.d)) {
                    this.f6749a = childAt;
                    return;
                }
            }
        }
    }

    public boolean isChildScrollToTop(MotionEvent motionEvent) {
        return !a(this.f6749a, motionEvent);
    }

    private boolean a(View view, MotionEvent motionEvent) {
        if (view instanceof WebView) {
            return view.getScrollY() != 0;
        } else if (view instanceof ViewGroup) {
            boolean z = false;
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                z = z || a(viewGroup.getChildAt(i), motionEvent);
                if (z) {
                    break;
                }
                i++;
            }
            return z;
        } else {
            return ViewCompat.getAuthRequestContext(view, -1);
        }
    }

    public boolean isChildScrollToBottom(MotionEvent motionEvent) {
        int lastVisiblePosition;
        int BuiltInFictitiousFunctionClassFactory;
        if (isChildScrollToTop(motionEvent)) {
            return false;
        }
        View view = this.f6749a;
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int placeComponentResult = recyclerView.getAdapter().getPlaceComponentResult();
            if ((layoutManager instanceof LinearLayoutManager) && placeComponentResult > 0) {
                if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == placeComponentResult - 1) {
                    return true;
                }
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[2];
                if (2 < staggeredGridLayoutManager.moveToNextValue) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Provided int[]'s size must be more than or equal to span count. Expected:");
                    sb.append(staggeredGridLayoutManager.moveToNextValue);
                    sb.append(", array size:");
                    sb.append(2);
                    throw new IllegalArgumentException(sb.toString());
                }
                for (int i = 0; i < staggeredGridLayoutManager.moveToNextValue; i++) {
                    StaggeredGridLayoutManager.Span span = staggeredGridLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
                    if (StaggeredGridLayoutManager.this.MyBillsEntityDataFactory) {
                        BuiltInFictitiousFunctionClassFactory = span.BuiltInFictitiousFunctionClassFactory(0, span.BuiltInFictitiousFunctionClassFactory.size(), true, true, false);
                    } else {
                        BuiltInFictitiousFunctionClassFactory = span.BuiltInFictitiousFunctionClassFactory(span.BuiltInFictitiousFunctionClassFactory.size() - 1, -1, true, true, false);
                    }
                    iArr[i] = BuiltInFictitiousFunctionClassFactory;
                }
                if (Math.max(iArr[0], iArr[1]) == placeComponentResult - 1) {
                    return true;
                }
            }
            return false;
        } else if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            int count = ((ListAdapter) absListView.getAdapter()).getCount();
            return (absListView.getFirstVisiblePosition() != 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop()) && (lastVisiblePosition = absListView.getLastVisiblePosition()) > 0 && count > 0 && lastVisiblePosition == count - 1;
        } else {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                View childAt = scrollView.getChildAt(scrollView.getChildCount() - 1);
                if (childAt != null && childAt.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()) == 0) {
                    return true;
                }
            } else if (view instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                View childAt2 = nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                if (childAt2 != null && childAt2.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()) == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public void setRefreshingWithNotify(boolean z, boolean z2) {
        if (z && this.b != z) {
            this.b = z;
            updateHeaderPosition((this.mHeaderViewHeight + this.mOriginalOffsetTop) - this.mCurrentTargetOffsetTop);
            this.l = z2;
            a(this.N);
            return;
        }
        a(z, false);
    }

    public void setAutoRefreshing(boolean z) {
        this.l = z;
        c();
        this.b = true;
        this.c.changeToState(RefreshHeader.RefreshState.REFRESHING);
        a(this.mCurrentTargetOffsetTop, new Animator.AnimatorListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GriverSwipeRefreshLayout.this.N.onAnimationEnd(animator);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.3.1
                    {
                        AnonymousClass3.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        GriverSwipeRefreshLayout.this.setRefreshing(false);
                    }
                }, GriverSwipeRefreshLayout.this.z);
            }
        });
    }

    public void setAutoRefreshingDuration(long j) {
        if (j > 0) {
            this.z = j;
        }
    }

    private void a(boolean z, boolean z2) {
        if (this.b != z) {
            this.l = z2;
            c();
            this.b = z;
            if (z) {
                this.c.changeToState(RefreshHeader.RefreshState.REFRESHING);
                a(this.mCurrentTargetOffsetTop, this.N);
                return;
            }
            this.c.changeToState(RefreshHeader.RefreshState.NONE);
            b(this.mCurrentTargetOffsetTop, this.N);
            return;
        }
        if (this.c.getCurrentState() == RefreshHeader.RefreshState.SECOND_FLOOR_END) {
            this.b = false;
        } else if (!z) {
            return;
        } else {
            this.l = z2;
            c();
            this.b = z;
            if (z) {
                this.c.changeToState(RefreshHeader.RefreshState.REFRESHING);
                a(this.mCurrentTargetOffsetTop, this.N);
                return;
            }
        }
        this.c.changeToState(RefreshHeader.RefreshState.NONE);
        b(this.mCurrentTargetOffsetTop, this.N);
    }

    public void setLoadMore(boolean z) {
        if (z || !this.n) {
            return;
        }
        a(this.mFooterViewHeight, 0);
    }

    private void a(Animator.AnimatorListener animatorListener) {
        this.c.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(getResources().getInteger(17694721));
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    public boolean isRefreshing() {
        return getRefresHeader().getCurrentState() != RefreshHeader.RefreshState.NONE;
    }

    public void setRefreshing(boolean z) {
        if (z && this.b != z) {
            this.b = z;
            updateHeaderPosition((this.mHeaderViewHeight + this.mOriginalOffsetTop) - this.mCurrentTargetOffsetTop);
            this.l = false;
            a(this.N);
            return;
        }
        a(z, false);
    }

    private void a(int i, final int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.4
            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GriverSwipeRefreshLayout.this.w = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                GriverSwipeRefreshLayout.this.d();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.5
            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i2 <= 0 || GriverSwipeRefreshLayout.this.h == null) {
                    GriverSwipeRefreshLayout.this.n = false;
                    GriverSwipeRefreshLayout.this.d.changeToState(LoadMoreFooter.LoadMoreState.NONE);
                    return;
                }
                GriverSwipeRefreshLayout.this.n = true;
                GriverSwipeRefreshLayout.this.d.changeToState(LoadMoreFooter.LoadMoreState.LOADING);
                GriverSwipeRefreshLayout.this.h.onLoadMore();
            }
        });
        ofInt.setInterpolator(this.y);
        ofInt.start();
    }

    private void a(int i, Animator.AnimatorListener animatorListener) {
        int i2;
        int abs;
        this.mFrom = i;
        if (this.v) {
            i2 = this.mHeaderViewHeight - Math.abs(this.mOriginalOffsetTop);
            abs = this.mRefreshOffset;
        } else {
            i2 = this.mHeaderViewHeight;
            abs = Math.abs(this.mOriginalOffsetTop);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mFrom, i2 - abs);
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.6
            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GriverSwipeRefreshLayout.this.updateHeaderPosition(((Integer) valueAnimator.getAnimatedValue()).intValue() - GriverSwipeRefreshLayout.this.c.getTop());
            }
        });
        ofInt.setDuration(300L);
        ofInt.setInterpolator(this.y);
        ofInt.start();
    }

    private void b(int i, Animator.AnimatorListener animatorListener) {
        this.mFrom = i;
        ValueAnimator ofInt = ValueAnimator.ofInt(i, this.mOriginalOffsetTop);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.7
            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                GriverSwipeRefreshLayout.this.c.setProgress((intValue - GriverSwipeRefreshLayout.this.mFrom) / ((GriverSwipeRefreshLayout.this.mOriginalOffsetTop - GriverSwipeRefreshLayout.this.mFrom) * 1.0f));
                GriverSwipeRefreshLayout griverSwipeRefreshLayout = GriverSwipeRefreshLayout.this;
                griverSwipeRefreshLayout.updateHeaderPosition(intValue - griverSwipeRefreshLayout.c.getTop());
            }
        });
        ofInt.setDuration(300L);
        ofInt.setInterpolator(this.y);
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    private void c(int i, Animator.AnimatorListener animatorListener) {
        this.mFrom = i;
        new ValueAnimator();
        final ValueAnimator ofInt = ValueAnimator.ofInt(this.mFrom, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout.8
            {
                GriverSwipeRefreshLayout.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GriverSwipeRefreshLayout.this.updateHeaderPosition(((Integer) ofInt.getAnimatedValue()).intValue() - GriverSwipeRefreshLayout.this.c.getTop());
            }
        });
        ofInt.setDuration(300L);
        ofInt.setInterpolator(this.y);
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    public void updateHeaderPosition(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateHeaderPosition() called with: offset = [");
        sb.append(i);
        sb.append("]");
        GriverLogger.d("SwipeRefreshLayout", sb.toString());
        this.c.bringToFront();
        this.c.offsetTopAndBottom(i);
        this.f6749a.offsetTopAndBottom(i);
        this.mCurrentTargetOffsetTop = this.c.getTop();
        e();
    }

    public void d() {
        this.d.setVisibility(0);
        this.d.bringToFront();
        if (Build.VERSION.SDK_INT < 19) {
            this.d.getParent().requestLayout();
        }
        this.d.offsetTopAndBottom(-this.w);
        f();
    }

    public void e() {
        int i = this.mCurrentTargetOffsetTop;
        int i2 = this.mOriginalOffsetTop;
        OnPullRefreshListener onPullRefreshListener = this.g;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onPullDistance(i - i2);
        }
    }

    private void f() {
        OnPushLoadMoreListener onPushLoadMoreListener = this.h;
        if (onPushLoadMoreListener != null) {
            onPushLoadMoreListener.onPushDistance(this.w);
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex;
        actionIndex = motionEvent.getActionIndex();
        if (MotionEventCompat.MyBillsEntityDataFactory(motionEvent, actionIndex) == this.p) {
            int i = actionIndex == 0 ? 1 : 0;
            this.B = MotionEventCompat.getAuthRequestContext(motionEvent, i);
            this.p = MotionEventCompat.MyBillsEntityDataFactory(motionEvent, i);
        }
        int d = d(motionEvent, this.p);
        if (this.p == -1) {
            return;
        }
        this.B = MotionEventCompat.getAuthRequestContext(motionEvent, d);
    }

    public boolean isTargetScrollWithLayout() {
        return this.m;
    }

    public void setTargetScrollWithLayout(boolean z) {
        this.m = z;
    }

    public void enablePullRefresh(boolean z) {
        this.i = z;
    }

    public void enableLoadMore(boolean z) {
        this.j = z;
    }

    public void enableSecondFloor(boolean z) {
        this.k = z;
    }

    public float getDistanceToRefresh() {
        return this.s;
    }

    public void setDistanceToRefresh(int i) {
        float f = this.mDensity;
        int i2 = (int) (i * f);
        if (i2 < this.mHeaderViewHeight) {
            return;
        }
        this.s = i2;
        float f2 = f * 20.0f;
        if (this.t - i2 < f2) {
            this.t = (int) (i2 + f2);
        }
    }

    public float getDistanceToSecondFloor() {
        return this.t;
    }

    public void setDistanceToSecondFloor(int i) {
        float f = this.mDensity;
        int i2 = (int) (i * f);
        if (i2 - this.s < f * 20.0f) {
            InstrumentInjector.log_e("SwipeRefreshLayout", "Distance to second floor must be more than 50dp longer than distance to refresh");
        } else {
            this.t = i2;
        }
    }

    public void setMaxPushDistance(int i) {
        int i2 = (int) (i * this.mDensity);
        if (i2 < this.mFooterViewHeight) {
            InstrumentInjector.log_e("SwipeRefreshLayout", "Max push distance must be larger than footer view height!");
        } else {
            this.x = i2;
        }
    }

    public void enableTargetOffset(boolean z) {
        this.v = z;
    }

    public int getRefreshOffset() {
        return this.mRefreshOffset;
    }

    public void setRefreshOffset(int i) {
        int i2 = this.mHeaderViewHeight;
        int i3 = (int) (i * this.mDensity);
        if (i2 < i3) {
            InstrumentInjector.log_e("SwipeRefreshLayout", "Refresh offset cannot be larger than header view height.");
        } else {
            this.mRefreshOffset = i3;
        }
    }

    public void setOnPullRefreshListener(OnPullRefreshListener onPullRefreshListener) {
        this.g = onPullRefreshListener;
        RefreshHeader refreshHeader = this.c;
        if (refreshHeader != null) {
            refreshHeader.setPullRefreshListener(onPullRefreshListener);
        }
    }

    public void setOnPushLoadMoreListener(OnPushLoadMoreListener onPushLoadMoreListener) {
        this.h = onPushLoadMoreListener;
        LoadMoreFooter loadMoreFooter = this.d;
        if (loadMoreFooter != null) {
            loadMoreFooter.setPushLoadMoreListener(onPushLoadMoreListener);
        }
    }

    public void setDragRate(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.r = f;
        } else {
            InstrumentInjector.log_e("SwipeRefreshLayout", "Drag rate must be larger than 0 and smaller than 1!");
        }
    }

    public void setHeaderView(RefreshHeader refreshHeader) {
        if (refreshHeader != null) {
            int indexOfChild = indexOfChild(this.c);
            RefreshHeader refreshHeader2 = this.c;
            if (refreshHeader2 != null && indexOfChild != -1) {
                removeView(refreshHeader2);
            }
            this.c = refreshHeader;
            refreshHeader.setPullRefreshListener(this.g);
            addView(this.c, indexOfChild, new ViewGroup.LayoutParams(-1, this.mHeaderViewHeight));
        }
    }

    public int getHeaderViewHeight() {
        return this.mHeaderViewHeight;
    }

    public void setHeaderViewHeight(int i) {
        float f = this.mDensity;
        int i2 = (int) (i * f);
        if (i2 < this.mRefreshOffset) {
            GriverLogger.d("SwipeRefreshLayout", "HeaderView height cannot be smaller than refresh offset.");
            return;
        }
        this.mHeaderViewHeight = i2;
        if (this.s < i2) {
            this.s = i2;
        }
        int i3 = this.t;
        int i4 = this.s;
        if (i3 < i4) {
            this.t = (int) (i4 + (f * 20.0f));
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GriverLogger.d("SwipeRefreshLayout", "onConfigurationChanged");
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mDisplayMetrics = displayMetrics;
        this.mHeaderViewWidth = displayMetrics.widthPixels;
        this.mFooterViewWidth = this.mDisplayMetrics.widthPixels;
        this.q = false;
    }

    public void setFooterView(LoadMoreFooter loadMoreFooter) {
        if (loadMoreFooter != null) {
            int indexOfChild = indexOfChild(this.d);
            LoadMoreFooter loadMoreFooter2 = this.d;
            if (loadMoreFooter2 != null && indexOfChild != -1) {
                removeView(loadMoreFooter2);
            }
            this.d = loadMoreFooter;
            loadMoreFooter.setPushLoadMoreListener(this.h);
            addView(this.d, indexOfChild, new ViewGroup.LayoutParams(-1, this.mFooterViewHeight));
        }
    }

    public int getFooterViewHeight() {
        return this.mFooterViewHeight;
    }

    public void setFooterViewHeight(int i) {
        int i2 = (int) (i * this.mDensity);
        if (i2 > this.x) {
            this.x = i2;
        }
        this.mFooterViewHeight = i2;
    }

    public RefreshHeader getRefresHeader() {
        return this.c;
    }

    public LoadMoreFooter getLoadMoreFooter() {
        return this.d;
    }

    private int d(MotionEvent motionEvent, int i) {
        int BuiltInFictitiousFunctionClassFactory = MotionEventCompat.BuiltInFictitiousFunctionClassFactory(motionEvent, i);
        if (BuiltInFictitiousFunctionClassFactory == -1) {
            this.p = -1;
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public void setCurrentTargetOffsetTop(int i) {
        this.mCurrentTargetOffsetTop = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class WMLAScrollerInfo implements Serializable {
        float bottom;
        float left;
        float right;
        float top;

        WMLAScrollerInfo() {
            GriverSwipeRefreshLayout.this = r1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("WMLAScrollerInfo{top=");
            sb.append(this.top);
            sb.append(", left=");
            sb.append(this.left);
            sb.append(", bottom=");
            sb.append(this.bottom);
            sb.append(", right=");
            sb.append(this.right);
            sb.append('}');
            return sb.toString();
        }
    }
}
