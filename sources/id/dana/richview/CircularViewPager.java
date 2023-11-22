package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import id.dana.R;
import id.dana.base.GestureListener;
import id.dana.utils.SizeUtil;

/* loaded from: classes5.dex */
public class CircularViewPager extends ViewPager {
    private CircularViewPagerListener BuiltInFictitiousFunctionClassFactory;
    private final int DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    private final Handler KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private Runnable PlaceComponentResult;
    protected float aspectRatio;
    protected boolean autoScroll;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    protected boolean infinite;
    private int initRecordTimeStamp;
    protected float itemAspectRatio;
    private GestureDetector lookAheadTest;
    private boolean moveToNextValue;
    private IndicatorPageChangeListener scheduleImpl;
    protected boolean wrapContent;

    /* loaded from: classes5.dex */
    public interface CircularViewPagerListener {
        void PlaceComponentResult(boolean z);
    }

    /* loaded from: classes5.dex */
    public interface IndicatorPageChangeListener {
        void PlaceComponentResult();

        void PlaceComponentResult(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$id-dana-richview-CircularViewPager  reason: not valid java name */
    public /* synthetic */ void m2800lambda$new$0$iddanarichviewCircularViewPager() {
        if (getAdapter() == null || !this.autoScroll || getAdapter().getCount() < 2) {
            return;
        }
        if (!this.infinite && getAdapter().getCount() - 1 == this.getAuthRequestContext) {
            this.getAuthRequestContext = 0;
        } else {
            this.getAuthRequestContext++;
        }
        setCurrentItem(this.getAuthRequestContext, true);
    }

    public CircularViewPager(Context context) {
        super(context);
        this.infinite = true;
        this.wrapContent = true;
        this.getErrorConfigVersion = 1500;
        this.DatabaseTableConfigUtil = SizeUtil.getAuthRequestContext(322);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Handler();
        this.PlaceComponentResult = new Runnable() { // from class: id.dana.richview.CircularViewPager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CircularViewPager.this.m2800lambda$new$0$iddanarichviewCircularViewPager();
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        this.moveToNextValue = false;
        init();
    }

    public CircularViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.infinite = true;
        this.wrapContent = true;
        this.getErrorConfigVersion = 1500;
        this.DatabaseTableConfigUtil = SizeUtil.getAuthRequestContext(322);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Handler();
        this.PlaceComponentResult = new Runnable() { // from class: id.dana.richview.CircularViewPager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CircularViewPager.this.m2800lambda$new$0$iddanarichviewCircularViewPager();
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        this.moveToNextValue = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.O, 0, 0);
        try {
            this.infinite = obtainStyledAttributes.getBoolean(2, false);
            this.autoScroll = obtainStyledAttributes.getBoolean(0, false);
            this.wrapContent = obtainStyledAttributes.getBoolean(6, true);
            this.getErrorConfigVersion = obtainStyledAttributes.getInt(4, 1500);
            this.aspectRatio = obtainStyledAttributes.getFloat(5, 0.0f);
            this.itemAspectRatio = obtainStyledAttributes.getFloat(3, 0.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getBoolean(1, false);
            this.MyBillsEntityDataFactory = this.autoScroll;
            obtainStyledAttributes.recycle();
            init();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    protected void init() {
        this.lookAheadTest = new GestureDetector(getContext(), new GestureListener(this));
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.richview.CircularViewPager.1
            float getAuthRequestContext;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (CircularViewPager.this.scheduleImpl == null) {
                    return;
                }
                CircularViewPager.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getAuthRequestContext(i, f);
                if (f == 0.0f) {
                    this.getAuthRequestContext = i;
                }
                CircularViewPager circularViewPager = CircularViewPager.this;
                int selectingIndicatorPosition = circularViewPager.getSelectingIndicatorPosition(circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda2);
                float access$200 = CircularViewPager.access$200(CircularViewPager.this, i, f);
                if (access$200 == 0.0f || access$200 > 1.0f) {
                    return;
                }
                CircularViewPager.access$300(CircularViewPager.this, selectingIndicatorPosition, access$200);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircularViewPager circularViewPager = CircularViewPager.this;
                circularViewPager.initRecordTimeStamp = circularViewPager.getAuthRequestContext;
                CircularViewPager.this.getAuthRequestContext = i;
                if (CircularViewPager.this.scheduleImpl != null) {
                    CircularViewPager.this.scheduleImpl.PlaceComponentResult(CircularViewPager.this.getIndicatorPosition());
                }
                if (CircularViewPager.this.BuiltInFictitiousFunctionClassFactory != null) {
                    CircularViewPagerListener unused = CircularViewPager.this.BuiltInFictitiousFunctionClassFactory;
                }
                CircularViewPager.access$700(CircularViewPager.this);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                boolean z = true;
                if (!CircularViewPager.this.moveToNextValue && CircularViewPager.this.NetworkUserEntityData$$ExternalSyntheticLambda7 == 2 && i == 1 && CircularViewPager.this.scheduleImpl != null) {
                    IndicatorPageChangeListener indicatorPageChangeListener = CircularViewPager.this.scheduleImpl;
                    CircularViewPager circularViewPager = CircularViewPager.this;
                    circularViewPager.getSelectingIndicatorPosition(circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    indicatorPageChangeListener.PlaceComponentResult();
                }
                if (i != 2 && i != 1) {
                    z = false;
                }
                if (CircularViewPager.this.BuiltInFictitiousFunctionClassFactory != null) {
                    CircularViewPager.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(z);
                }
                CircularViewPager circularViewPager2 = CircularViewPager.this;
                circularViewPager2.NetworkUserEntityData$$ExternalSyntheticLambda1 = circularViewPager2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                CircularViewPager.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
                CircularViewPager.access$1100(CircularViewPager.this, i);
            }

            private boolean getAuthRequestContext(int i, float f) {
                return ((float) i) + f >= this.getAuthRequestContext;
            }
        });
        if (this.infinite) {
            setCurrentItem(1, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        if (this.infinite) {
            setCurrentItem(1, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int mode;
        int size = View.MeasureSpec.getSize(i);
        if (this.aspectRatio > 0.0f) {
            int round = Math.round(View.MeasureSpec.getSize(i) / this.aspectRatio);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
            float f = this.itemAspectRatio;
            if ((f > 0.0f && f != this.aspectRatio) || (f > 0.0f && getAdapter().getCount() > 1)) {
                super.onMeasure(i, i2);
                int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec((size - getPaddingLeft()) - getPaddingRight(), 1073741824);
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    childAt.measure(makeMeasureSpec3, View.MeasureSpec.makeMeasureSpec(0, 0));
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (measuredHeight > 0 && measuredHeight > round) {
                        double floor = Math.floor(round * (measuredWidth / measuredHeight));
                        double d = size;
                        Double.isNaN(d);
                        int round2 = (int) Math.round((d - floor) / 2.0d);
                        setPadding(round2, getPaddingTop(), round2, getPaddingBottom());
                        makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec((size - getPaddingLeft()) - getPaddingRight(), 1073741824);
                        childAt.measure(makeMeasureSpec3, View.MeasureSpec.makeMeasureSpec(0, 0));
                    }
                }
            }
            super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
            return;
        }
        if (this.wrapContent && ((mode = View.MeasureSpec.getMode(i2)) == 0 || mode == Integer.MIN_VALUE)) {
            super.onMeasure(i, i2);
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                paddingLeft = this.DatabaseTableConfigUtil;
                int i4 = (size - paddingLeft) / 2;
                setPadding(i4, getPaddingTop(), i4, getPaddingBottom());
            }
            int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
            int i5 = 0;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt2 = getChildAt(i6);
                childAt2.measure(makeMeasureSpec4, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight2 = childAt2.getMeasuredHeight();
                if (measuredHeight2 > i5) {
                    i5 = measuredHeight2;
                }
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i5 + getPaddingTop() + getPaddingBottom(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void resumeAutoScroll() {
        this.MyBillsEntityDataFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(this.PlaceComponentResult, this.getErrorConfigVersion);
    }

    public void resumeAutoScroll(long j) {
        this.MyBillsEntityDataFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(this.PlaceComponentResult);
        this.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(this.PlaceComponentResult, j);
    }

    public void pauseAutoScroll() {
        this.MyBillsEntityDataFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(this.PlaceComponentResult);
    }

    public int getIndicatorPosition() {
        int i;
        if (!this.infinite || !(getAdapter() instanceof CircularPagerAdapter)) {
            return this.getAuthRequestContext;
        }
        int i2 = this.getAuthRequestContext;
        if (i2 == 0) {
            i = ((CircularPagerAdapter) getAdapter()).getAuthRequestContext();
        } else if (i2 == ((CircularPagerAdapter) getAdapter()).BuiltInFictitiousFunctionClassFactory() + 1) {
            return 0;
        } else {
            i = this.getAuthRequestContext;
        }
        return i - 1;
    }

    public int getSelectingIndicatorPosition(boolean z) {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (i == 2 || i == 0 || (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == 2 && i == 1)) {
            return getIndicatorPosition();
        }
        int i2 = z ? 1 : -1;
        if (this.infinite) {
            if (getAdapter() instanceof CircularPagerAdapter) {
                if (KClassImpl$Data$declaredNonStaticMembers$2(z)) {
                    return ((CircularPagerAdapter) getAdapter()).BuiltInFictitiousFunctionClassFactory() - 1;
                }
                if (this.getAuthRequestContext == ((CircularPagerAdapter) getAdapter()).BuiltInFictitiousFunctionClassFactory() && z) {
                    return 0;
                }
                return (this.getAuthRequestContext + i2) - 1;
            }
            return this.getAuthRequestContext + i2;
        }
        return this.getAuthRequestContext + i2;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        return this.getAuthRequestContext == 1 && !z;
    }

    public int getIndicatorCount() {
        if (getAdapter() == null) {
            return 0;
        }
        if (getAdapter() instanceof CircularPagerAdapter) {
            return ((CircularPagerAdapter) getAdapter()).getAuthRequestContext();
        }
        return getAdapter().getCount();
    }

    public void reset() {
        boolean z = this.infinite;
        this.getAuthRequestContext = z ? 1 : 0;
        setCurrentItem(z ? 1 : 0, false);
    }

    public void setIndicatorSmart(boolean z) {
        this.moveToNextValue = z;
    }

    public void setIndicatorPageChangeListener(IndicatorPageChangeListener indicatorPageChangeListener) {
        this.scheduleImpl = indicatorPageChangeListener;
    }

    public void setCircularViewPagerListener(CircularViewPagerListener circularViewPagerListener) {
        this.BuiltInFictitiousFunctionClassFactory = circularViewPagerListener;
    }

    public void setIntervalAutoScroll(int i) {
        this.getErrorConfigVersion = i;
        pauseAutoScroll();
        resumeAutoScroll();
    }

    public void setNestedScroll(boolean z) {
        this.GetContactSyncConfig = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.GetContactSyncConfig) {
            this.lookAheadTest.onTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    static /* synthetic */ void access$1100(CircularViewPager circularViewPager, int i) {
        int count;
        if (i == 0) {
            if (circularViewPager.infinite) {
                if (circularViewPager.getAdapter() == null || (count = circularViewPager.getAdapter().getCount()) < 2) {
                    return;
                }
                int currentItem = circularViewPager.getCurrentItem();
                if (currentItem == 0) {
                    circularViewPager.setCurrentItem(count - 2, false);
                } else if (currentItem == count - 1) {
                    circularViewPager.setCurrentItem(1, false);
                }
            }
            IndicatorPageChangeListener indicatorPageChangeListener = circularViewPager.scheduleImpl;
            if (indicatorPageChangeListener != null) {
                circularViewPager.getIndicatorPosition();
                indicatorPageChangeListener.PlaceComponentResult();
            }
        }
    }

    static /* synthetic */ float access$200(CircularViewPager circularViewPager, int i, float f) {
        if (circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda7 != 2 || Math.abs(circularViewPager.getAuthRequestContext - circularViewPager.initRecordTimeStamp) <= 1) {
            return !circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda2 ? 1.0f - f : f;
        }
        int abs = Math.abs(circularViewPager.getAuthRequestContext - circularViewPager.initRecordTimeStamp);
        if (circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            float f2 = i - circularViewPager.initRecordTimeStamp;
            float f3 = abs;
            return (f / f3) + (f2 / f3);
        }
        float f4 = circularViewPager.initRecordTimeStamp - (i + 1);
        float f5 = abs;
        return (f4 / f5) + ((1.0f - f) / f5);
    }

    static /* synthetic */ void access$300(CircularViewPager circularViewPager, int i, float f) {
        if (circularViewPager.moveToNextValue) {
            if (circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda7 == 1) {
                circularViewPager.scheduleImpl.PlaceComponentResult();
                return;
            }
            return;
        }
        boolean z = false;
        boolean z2 = circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda2 && Math.abs(i - circularViewPager.getAuthRequestContext) == 2;
        if (!circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda2 && i == circularViewPager.getAuthRequestContext) {
            z = true;
        }
        if (circularViewPager.NetworkUserEntityData$$ExternalSyntheticLambda7 == 1 && (z2 || z)) {
            return;
        }
        circularViewPager.scheduleImpl.PlaceComponentResult();
    }

    static /* synthetic */ void access$700(CircularViewPager circularViewPager) {
        if (circularViewPager.MyBillsEntityDataFactory) {
            circularViewPager.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(circularViewPager.PlaceComponentResult);
            circularViewPager.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(circularViewPager.PlaceComponentResult, circularViewPager.getErrorConfigVersion);
        }
    }
}
