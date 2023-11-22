package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator BuiltInFictitiousFunctionClassFactory = new DecelerateInterpolator();
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private TabClickListener MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private int getAuthRequestContext;
    private Spinner lookAheadTest;
    int mMaxTabWidth;
    int mStackedTabMaxWidth;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.mVisAnimListener = new VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy PlaceComponentResult = ActionBarPolicy.PlaceComponentResult(context);
        setContentHeight(PlaceComponentResult.PlaceComponentResult());
        this.mStackedTabMaxWidth = PlaceComponentResult.PlaceComponentResult.getResources().getDimensionPixelSize(R.dimen.KClassImpl$Data$declaredNonStaticMembers$2);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.getAuthRequestContext);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        this.mTabLayout = linearLayoutCompat;
        addView(linearLayoutCompat, new ViewGroup.LayoutParams(-2, -1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.mTabLayout.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.mMaxTabWidth = View.MeasureSpec.getSize(i) / 2;
            }
            this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        } else {
            this.mMaxTabWidth = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.getAuthRequestContext, 1073741824);
        if (!z && this.PlaceComponentResult) {
            this.mTabLayout.measure(0, makeMeasureSpec);
            if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(i)) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            } else if (!getAuthRequestContext()) {
                if (this.lookAheadTest == null) {
                    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.scheduleImpl);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.lookAheadTest = appCompatSpinner;
                }
                removeView(this.mTabLayout);
                addView(this.lookAheadTest, new ViewGroup.LayoutParams(-2, -1));
                if (this.lookAheadTest.getAdapter() == null) {
                    this.lookAheadTest.setAdapter((SpinnerAdapter) new TabAdapter());
                }
                Runnable runnable = this.mTabSelector;
                if (runnable != null) {
                    removeCallbacks(runnable);
                    this.mTabSelector = null;
                }
                this.lookAheadTest.setSelection(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private boolean getAuthRequestContext() {
        Spinner spinner = this.lookAheadTest;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.PlaceComponentResult = z;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (getAuthRequestContext()) {
            removeView(this.lookAheadTest);
            addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.lookAheadTest.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.mTabLayout.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        Spinner spinner = this.lookAheadTest;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void setContentHeight(int i) {
        this.getAuthRequestContext = i;
        requestLayout();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy PlaceComponentResult = ActionBarPolicy.PlaceComponentResult(getContext());
        setContentHeight(PlaceComponentResult.PlaceComponentResult());
        this.mStackedTabMaxWidth = PlaceComponentResult.PlaceComponentResult.getResources().getDimensionPixelSize(R.dimen.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimator alpha = animate().alpha(1.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(BuiltInFictitiousFunctionClassFactory);
            alpha.setListener(this.mVisAnimListener.getAuthRequestContext(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimator alpha2 = animate().alpha(0.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(BuiltInFictitiousFunctionClassFactory);
        alpha2.setListener(this.mVisAnimListener.getAuthRequestContext(alpha2, i));
        alpha2.start();
    }

    public void animateToTab(int i) {
        final View childAt = this.mTabLayout.getChildAt(i);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.mTabSelector = null;
            }
        };
        this.mTabSelector = runnable2;
        post(runnable2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    TabView createTabView(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.getAuthRequestContext));
        } else {
            tabView.setFocusable(true);
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new TabClickListener();
            }
            tabView.setOnClickListener(this.MyBillsEntityDataFactory);
        }
        return tabView;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.lookAheadTest;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            createTabView.setSelected(true);
        }
        if (this.PlaceComponentResult) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.lookAheadTest;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            createTabView.setSelected(true);
        }
        if (this.PlaceComponentResult) {
            requestLayout();
        }
    }

    public void updateTab(int i) {
        ((TabView) this.mTabLayout.getChildAt(i)).BuiltInFictitiousFunctionClassFactory();
        Spinner spinner = this.lookAheadTest;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.PlaceComponentResult) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.mTabLayout.removeViewAt(i);
        Spinner spinner = this.lookAheadTest;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.PlaceComponentResult) {
            requestLayout();
        }
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner spinner = this.lookAheadTest;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.PlaceComponentResult) {
            requestLayout();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TabView extends LinearLayout {
        ActionBar.Tab KClassImpl$Data$declaredNonStaticMembers$2;
        private final int[] getAuthRequestContext;
        private TextView getErrorConfigVersion;
        private ImageView lookAheadTest;
        private View moveToNextValue;
        public static final byte[] MyBillsEntityDataFactory = {18, 119, 36, -59, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
        public static final int BuiltInFictitiousFunctionClassFactory = 28;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0074 -> B:16:0x007d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public TabView(android.content.Context r19, androidx.appcompat.app.ActionBar.Tab r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                r1 = r19
                r2 = r18
                androidx.appcompat.widget.ScrollingTabContainerView.this = r2
                int r2 = androidx.appcompat.R.attr.MyBillsEntityDataFactory
                r3 = 0
                r0.<init>(r1, r3, r2)
                r2 = 1
                int[] r4 = new int[r2]
                r5 = 16842964(0x10100d4, float:2.3694152E-38)
                r6 = 0
                r4[r6] = r5
                r0.getAuthRequestContext = r4
                r5 = r20
                r0.KClassImpl$Data$declaredNonStaticMembers$2 = r5
                int r5 = androidx.appcompat.R.attr.MyBillsEntityDataFactory
                androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.getAuthRequestContext(r1, r3, r4, r5, r6)
                boolean r3 = r1.getAuthRequestContext(r6)
                if (r3 == 0) goto L86
                byte[] r3 = androidx.appcompat.widget.ScrollingTabContainerView.TabView.MyBillsEntityDataFactory
                r4 = 23
                byte[] r4 = new byte[r4]
                r5 = 4
                r7 = 97
                r12 = r0
                r13 = r12
                if (r3 != 0) goto L42
                r7 = r1
                r8 = r3
                r11 = r4
                r9 = 4
                r10 = 97
                r15 = 0
                r3 = r7
                r4 = r3
                r1 = r21
                goto L7d
            L42:
                r5 = r1
                r7 = r3
                r8 = r4
                r9 = 4
                r10 = 97
                r11 = 0
                r3 = r5
                r4 = r3
                r1 = r21
            L4d:
                byte r14 = (byte) r10
                r8[r11] = r14
                r14 = 22
                int r15 = r11 + 1
                if (r11 != r14) goto L74
                java.lang.String r2 = new java.lang.String
                r2.<init>(r8, r6)
                java.lang.Class r2 = java.lang.Class.forName(r2)
                boolean r2 = r2.isInstance(r3)
                if (r2 == 0) goto L6c
                android.content.Context r4 = (android.content.Context) r4
                android.graphics.drawable.Drawable r2 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r4, r6)
                goto L70
            L6c:
                android.graphics.drawable.Drawable r2 = r4.BuiltInFictitiousFunctionClassFactory(r6)
            L70:
                r12.setBackgroundDrawable(r2)
                goto L8a
            L74:
                r11 = r7[r9]
                r16 = r7
                r7 = r5
                r5 = r11
                r11 = r8
                r8 = r16
            L7d:
                int r10 = r10 + r5
                int r10 = r10 + (-8)
                int r9 = r9 + r2
                r5 = r7
                r7 = r8
                r8 = r11
                r11 = r15
                goto L4d
            L86:
                r13 = r0
                r5 = r1
                r1 = r21
            L8a:
                android.content.res.TypedArray r2 = r5.BuiltInFictitiousFunctionClassFactory
                r2.recycle()
                if (r1 == 0) goto L97
                r1 = 8388627(0x800013, float:1.175497E-38)
                r13.setGravity(r1)
            L97:
                r13.BuiltInFictitiousFunctionClassFactory()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.mMaxTabWidth <= 0 || getMeasuredWidth() <= ScrollingTabContainerView.this.mMaxTabWidth) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.mMaxTabWidth, 1073741824), i2);
        }

        public final void BuiltInFictitiousFunctionClassFactory() {
            ActionBar.Tab tab = this.KClassImpl$Data$declaredNonStaticMembers$2;
            View PlaceComponentResult = tab.PlaceComponentResult();
            if (PlaceComponentResult != null) {
                ViewParent parent = PlaceComponentResult.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(PlaceComponentResult);
                    }
                    addView(PlaceComponentResult);
                }
                this.moveToNextValue = PlaceComponentResult;
                TextView textView = this.getErrorConfigVersion;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.lookAheadTest;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.lookAheadTest.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.moveToNextValue;
            if (view != null) {
                removeView(view);
                this.moveToNextValue = null;
            }
            Drawable BuiltInFictitiousFunctionClassFactory2 = tab.BuiltInFictitiousFunctionClassFactory();
            CharSequence MyBillsEntityDataFactory2 = tab.MyBillsEntityDataFactory();
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                if (this.lookAheadTest == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.lookAheadTest = appCompatImageView;
                }
                this.lookAheadTest.setImageDrawable(BuiltInFictitiousFunctionClassFactory2);
                this.lookAheadTest.setVisibility(0);
            } else {
                ImageView imageView2 = this.lookAheadTest;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.lookAheadTest.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(MyBillsEntityDataFactory2);
            if (z) {
                if (this.getErrorConfigVersion == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.getErrorConfigVersion);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.getErrorConfigVersion = appCompatTextView;
                }
                this.getErrorConfigVersion.setText(MyBillsEntityDataFactory2);
                this.getErrorConfigVersion.setVisibility(0);
            } else {
                TextView textView2 = this.getErrorConfigVersion;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.getErrorConfigVersion.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.lookAheadTest;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.KClassImpl$Data$declaredNonStaticMembers$2());
            }
            TooltipCompat.PlaceComponentResult(this, z ? null : tab.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    /* loaded from: classes.dex */
    class TabAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.mTabLayout.getChildAt(i)).KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.createTabView((ActionBar.Tab) getItem(i), true);
            }
            TabView tabView = (TabView) view;
            tabView.KClassImpl$Data$declaredNonStaticMembers$2 = (ActionBar.Tab) getItem(i);
            tabView.BuiltInFictitiousFunctionClassFactory();
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
            int childCount = ScrollingTabContainerView.this.mTabLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* loaded from: classes.dex */
    protected class VisibilityAnimListener extends AnimatorListenerAdapter {
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean getAuthRequestContext = false;

        protected VisibilityAnimListener() {
        }

        public final VisibilityAnimListener getAuthRequestContext(ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.getAuthRequestContext = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.getAuthRequestContext) {
                return;
            }
            ScrollingTabContainerView.this.mVisibilityAnim = null;
            ScrollingTabContainerView.this.setVisibility(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.getAuthRequestContext = true;
        }
    }
}
