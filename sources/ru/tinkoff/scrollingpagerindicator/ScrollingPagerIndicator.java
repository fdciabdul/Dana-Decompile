package ru.tinkoff.scrollingpagerindicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes6.dex */
public class ScrollingPagerIndicator extends View {
    private PagerAttacher<?> BuiltInFictitiousFunctionClassFactory;
    private final Paint DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    private final ArgbEvaluator KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private SparseArray<Float> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7;
    private Runnable PlaceComponentResult;
    private int PrepareContext;
    private int getAuthRequestContext;
    private float getErrorConfigVersion;
    private final int initRecordTimeStamp;
    private float isLayoutRequested;
    private final int lookAheadTest;
    private final int moveToNextValue;
    private int newProxyInstance;
    private int scheduleImpl;

    /* loaded from: classes6.dex */
    public interface PagerAttacher<T> {
        void PlaceComponentResult(ScrollingPagerIndicator scrollingPagerIndicator, T t);

        void getAuthRequestContext();
    }

    public ScrollingPagerIndicator(Context context) {
        this(context, null);
    }

    public ScrollingPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollingPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArgbEvaluator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PlaceComponentResult, i, R.style.BuiltInFictitiousFunctionClassFactory);
        this.getAuthRequestContext = obtainStyledAttributes.getColor(R.styleable.MyBillsEntityDataFactory, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getColor(R.styleable.getAuthRequestContext, this.getAuthRequestContext);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BuiltInFictitiousFunctionClassFactory, 0);
        this.moveToNextValue = dimensionPixelSize;
        this.lookAheadTest = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, 0);
        this.initRecordTimeStamp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.getErrorConfigVersion, 0) + dimensionPixelSize;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getBoolean(R.styleable.scheduleImpl, false);
        int i2 = obtainStyledAttributes.getInt(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
        setVisibleDotCount(i2);
        this.newProxyInstance = obtainStyledAttributes.getInt(R.styleable.lookAheadTest, 2);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.DatabaseTableConfigUtil = paint;
        paint.setAntiAlias(true);
        if (isInEditMode()) {
            setDotCount(i2);
            onPageScrolled(i2 / 2, 0.0f);
        }
    }

    public void setLooped(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
        reattach();
        invalidate();
    }

    public int getDotColor() {
        return this.getAuthRequestContext;
    }

    public void setDotColor(int i) {
        this.getAuthRequestContext = i;
        invalidate();
    }

    public int getSelectedDotColor() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public void setSelectedDotColor(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
        invalidate();
    }

    public int getVisibleDotCount() {
        return this.PrepareContext;
    }

    public void setVisibleDotCount(int i) {
        if (i % 2 == 0) {
            throw new IllegalArgumentException("visibleDotCount must be odd");
        }
        this.PrepareContext = i;
        this.scheduleImpl = i + 2;
        if (this.PlaceComponentResult != null) {
            reattach();
        } else {
            requestLayout();
        }
    }

    public int getVisibleDotThreshold() {
        return this.newProxyInstance;
    }

    public void setVisibleDotThreshold(int i) {
        this.newProxyInstance = i;
        if (this.PlaceComponentResult != null) {
            reattach();
        } else {
            requestLayout();
        }
    }

    public void attachToPager(ViewPager viewPager) {
        attachToPager(viewPager, new ViewPagerAttacher());
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        attachToPager(recyclerView, new RecyclerViewAttacher());
    }

    public void attachToRecyclerView(RecyclerView recyclerView, int i) {
        attachToPager(recyclerView, new RecyclerViewAttacher(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void attachToPager(final T t, final PagerAttacher<T> pagerAttacher) {
        detachFromPager();
        pagerAttacher.PlaceComponentResult(this, t);
        this.BuiltInFictitiousFunctionClassFactory = pagerAttacher;
        this.PlaceComponentResult = new Runnable() { // from class: ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingPagerIndicator.this.GetContactSyncConfig = -1;
                ScrollingPagerIndicator.this.attachToPager(t, pagerAttacher);
            }
        };
    }

    public void detachFromPager() {
        PagerAttacher<?> pagerAttacher = this.BuiltInFictitiousFunctionClassFactory;
        if (pagerAttacher != null) {
            pagerAttacher.getAuthRequestContext();
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.PlaceComponentResult = null;
        }
        this.MyBillsEntityDataFactory = false;
    }

    public void reattach() {
        Runnable runnable = this.PlaceComponentResult;
        if (runnable != null) {
            runnable.run();
            invalidate();
        }
    }

    public void onPageScrolled(int i, float f) {
        int i2;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Offset must be [0, 1]");
        }
        if (i < 0 || (i != 0 && i >= this.GetContactSyncConfig)) {
            throw new IndexOutOfBoundsException("page must be [0, adapter.getItemCount())");
        }
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || ((i2 = this.GetContactSyncConfig) <= this.PrepareContext && i2 > 1)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            MyBillsEntityDataFactory(i, f);
            int i3 = this.GetContactSyncConfig;
            if (i < i3 - 1) {
                MyBillsEntityDataFactory(i + 1, 1.0f - f);
            } else if (i3 > 1) {
                MyBillsEntityDataFactory(0, 1.0f - f);
            }
            invalidate();
        }
        MyBillsEntityDataFactory(f, i);
        invalidate();
    }

    public void setCurrentPosition(int i) {
        if (i != 0 && (i < 0 || i >= this.GetContactSyncConfig)) {
            throw new IndexOutOfBoundsException("Position must be [0, adapter.getItemCount()]");
        }
        if (this.GetContactSyncConfig == 0) {
            return;
        }
        MyBillsEntityDataFactory(0.0f, i);
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.GetContactSyncConfig < this.PrepareContext) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(i, Float.valueOf(1.0f));
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r4 = r3.isInEditMode()
            if (r4 == 0) goto L11
            int r4 = r3.PrepareContext
            int r4 = r4 + (-1)
            int r0 = r3.initRecordTimeStamp
            int r4 = r4 * r0
            int r0 = r3.lookAheadTest
            goto L23
        L11:
            int r4 = r3.GetContactSyncConfig
            int r0 = r3.PrepareContext
            if (r4 < r0) goto L1b
            float r4 = r3.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r4 = (int) r4
            goto L24
        L1b:
            int r4 = r4 + (-1)
            int r0 = r3.initRecordTimeStamp
            int r4 = r4 * r0
            int r0 = r3.lookAheadTest
        L23:
            int r4 = r4 + r0
        L24:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r1 = r3.lookAheadTest
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r2) goto L38
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L3c
            r5 = r1
            goto L3c
        L38:
            int r5 = java.lang.Math.min(r1, r5)
        L3c:
            r3.setMeasuredDimension(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.onMeasure(int, int):void");
    }

    private void MyBillsEntityDataFactory(float f, int i) {
        int i2;
        int i3 = this.GetContactSyncConfig;
        int i4 = this.PrepareContext;
        if (i3 <= i4) {
            this.isLayoutRequested = 0.0f;
            return;
        }
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (z || i3 <= i4) {
            int i5 = this.scheduleImpl / 2;
            this.isLayoutRequested = ((this.getErrorConfigVersion + (i5 * r1)) + (this.initRecordTimeStamp * f)) - (this.NetworkUserEntityData$$ExternalSyntheticLambda7 / 2.0f);
            return;
        }
        this.isLayoutRequested = ((this.getErrorConfigVersion + (i * r5)) + (this.initRecordTimeStamp * f)) - (this.NetworkUserEntityData$$ExternalSyntheticLambda7 / 2.0f);
        int i6 = i4 / 2;
        if (z && i3 > i4) {
            i2 = this.scheduleImpl;
        } else {
            i2 = this.GetContactSyncConfig;
        }
        float f2 = this.getErrorConfigVersion;
        int i7 = this.initRecordTimeStamp;
        float f3 = (((i2 - 1) - i6) * i7) + f2;
        float f4 = this.isLayoutRequested;
        float f5 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if ((f5 / 2.0f) + f4 < (i6 * i7) + f2) {
            this.isLayoutRequested = (f2 + (i6 * i7)) - (f5 / 2.0f);
            return;
        }
        float f6 = f5 / 2.0f;
        if (f4 + f6 > f3) {
            this.isLayoutRequested = f3 - f6;
        }
    }

    private void MyBillsEntityDataFactory(int i, float f) {
        int i2;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 && this.GetContactSyncConfig > this.PrepareContext) {
                i2 = this.scheduleImpl;
            } else {
                i2 = this.GetContactSyncConfig;
            }
            if (i2 != 0) {
                float abs = 1.0f - Math.abs(f);
                if (abs == 0.0f) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(i);
                } else {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(i, Float.valueOf(abs));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
    
        if (r9 < r8) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
    
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e6, code lost:
    
        if (r9 < r8) goto L51;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.onDraw(android.graphics.Canvas):void");
    }

    public void setDotCount(int i) {
        if (this.GetContactSyncConfig == i && this.MyBillsEntityDataFactory) {
            return;
        }
        this.GetContactSyncConfig = i;
        this.MyBillsEntityDataFactory = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SparseArray<>();
        if (i < this.newProxyInstance) {
            requestLayout();
            invalidate();
            return;
        }
        this.getErrorConfigVersion = (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.GetContactSyncConfig <= this.PrepareContext) ? this.lookAheadTest / 2 : 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = ((this.PrepareContext - 1) * this.initRecordTimeStamp) + this.lookAheadTest;
        requestLayout();
        invalidate();
    }
}
