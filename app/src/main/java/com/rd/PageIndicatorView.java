package com.rd;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.text.TextUtilsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.rd.IndicatorManager;
import com.rd.animation.AnimationManager;
import com.rd.animation.controller.AnimationController;
import com.rd.animation.type.AnimationType;
import com.rd.animation.type.BaseAnimation;
import com.rd.draw.DrawManager;
import com.rd.draw.controller.DrawController;
import com.rd.draw.controller.MeasureController;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.PositionSavedState;
import com.rd.draw.data.RtlMode;
import com.rd.utils.CoordinatesUtils;
import com.rd.utils.DensityUtils;
import com.rd.utils.IdUtils;

/* loaded from: classes3.dex */
public class PageIndicatorView extends View implements ViewPager.OnPageChangeListener, IndicatorManager.Listener, ViewPager.OnAdapterChangeListener, View.OnTouchListener {
    private static final Handler PlaceComponentResult = new Handler(Looper.getMainLooper());
    private DataSetObserver BuiltInFictitiousFunctionClassFactory;
    private Runnable KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private IndicatorManager getAuthRequestContext;
    private ViewPager lookAheadTest;

    public PageIndicatorView(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: com.rd.PageIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                DrawManager drawManager = PageIndicatorView.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
                }
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = true;
                PageIndicatorView.access$200(PageIndicatorView.this);
            }
        };
        if (getId() == -1) {
            setId(IdUtils.getAuthRequestContext());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(null);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            Handler handler = PlaceComponentResult;
            handler.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            handler.postDelayed(runnable, drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: com.rd.PageIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                DrawManager drawManager = PageIndicatorView.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
                }
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = true;
                PageIndicatorView.access$200(PageIndicatorView.this);
            }
        };
        if (getId() == -1) {
            setId(IdUtils.getAuthRequestContext());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            Handler handler = PlaceComponentResult;
            handler.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            handler.postDelayed(runnable, drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: com.rd.PageIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                DrawManager drawManager = PageIndicatorView.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
                }
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = true;
                PageIndicatorView.access$200(PageIndicatorView.this);
            }
        };
        if (getId() == -1) {
            setId(IdUtils.getAuthRequestContext());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            Handler handler = PlaceComponentResult;
            handler.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            handler.postDelayed(runnable, drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: com.rd.PageIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                DrawManager drawManager = PageIndicatorView.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
                }
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = true;
                PageIndicatorView.access$200(PageIndicatorView.this);
            }
        };
        if (getId() == -1) {
            setId(IdUtils.getAuthRequestContext());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            Handler handler = PlaceComponentResult;
            handler.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            handler.postDelayed(runnable, drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        View findViewById;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (!(parent != null && (parent instanceof ViewGroup) && ((ViewGroup) parent).getChildCount() > 0)) {
                return;
            }
            DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            ViewPager viewPager = (viewGroup.getChildCount() <= 0 || (findViewById = viewGroup.findViewById(drawManager.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable)) == null || !(findViewById instanceof ViewPager)) ? null : (ViewPager) findViewById;
            if (viewPager != null) {
                setViewPager(viewPager);
                return;
            }
            parent = parent.getParent();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        scheduleImpl();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        PositionSavedState positionSavedState = new PositionSavedState(super.onSaveInstanceState());
        positionSavedState.BuiltInFictitiousFunctionClassFactory = indicator.NetworkUserEntityData$$ExternalSyntheticLambda4;
        positionSavedState.PlaceComponentResult = indicator.NetworkUserEntityData$$ExternalSyntheticLambda3;
        positionSavedState.getAuthRequestContext = indicator.DatabaseTableConfigUtil;
        return positionSavedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof PositionSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        PositionSavedState positionSavedState = (PositionSavedState) parcelable;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 = positionSavedState.BuiltInFictitiousFunctionClassFactory;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda3 = positionSavedState.PlaceComponentResult;
        indicator.DatabaseTableConfigUtil = positionSavedState.getAuthRequestContext;
        super.onRestoreInstanceState(positionSavedState.getSuperState());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        MeasureController measureController = drawManager.MyBillsEntityDataFactory;
        Pair<Integer, Integer> BuiltInFictitiousFunctionClassFactory = MeasureController.BuiltInFictitiousFunctionClassFactory(drawManager.KClassImpl$Data$declaredNonStaticMembers$2, i, i2);
        setMeasuredDimension(((Integer) BuiltInFictitiousFunctionClassFactory.first).intValue(), ((Integer) BuiltInFictitiousFunctionClassFactory.second).intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0136  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rd.PageIndicatorView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DrawController drawController = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        if (motionEvent != null && motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (drawController.BuiltInFictitiousFunctionClassFactory != null && CoordinatesUtils.KClassImpl$Data$declaredNonStaticMembers$2(drawController.PlaceComponentResult, x, y) >= 0) {
                DrawController.ClickListener clickListener = drawController.BuiltInFictitiousFunctionClassFactory;
            }
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                MyBillsEntityDataFactory();
            } else if (action == 1) {
                BuiltInFictitiousFunctionClassFactory();
            }
            return false;
        }
        return false;
    }

    @Override // com.rd.IndicatorManager.Listener
    public void onIndicatorUpdated() {
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.MyBillsEntityDataFactory;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        DataSetObserver dataSetObserver;
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (pagerAdapter != null && (dataSetObserver = this.BuiltInFictitiousFunctionClassFactory) != null) {
                pagerAdapter.unregisterDataSetObserver(dataSetObserver);
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
            getAuthRequestContext();
        }
        lookAheadTest();
    }

    public void setCount(int i) {
        if (i >= 0) {
            DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult != i) {
                DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
                }
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = i;
                getErrorConfigVersion();
                requestLayout();
            }
        }
    }

    public int getCount() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
    }

    public void setDynamicCount(boolean z) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = z;
        if (z) {
            getAuthRequestContext();
        } else {
            scheduleImpl();
        }
    }

    public void setFadeOnIdle(boolean z) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = z;
        if (z) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            MyBillsEntityDataFactory();
        }
    }

    public void setRadius(int i) {
        if (i < 0) {
            i = 0;
        }
        int PlaceComponentResult2 = DensityUtils.PlaceComponentResult(i);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 = PlaceComponentResult2;
        invalidate();
    }

    public void setRadius(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 = (int) f;
        invalidate();
    }

    public int getRadius() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public void setPadding(int i) {
        if (i < 0) {
            i = 0;
        }
        int PlaceComponentResult2 = DensityUtils.PlaceComponentResult(i);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult2;
        invalidate();
    }

    public void setPadding(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) f;
        invalidate();
    }

    public int getPadding() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public void setScaleFactor(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.3f) {
            f = 0.3f;
        }
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext = f;
    }

    public float getScaleFactor() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext;
    }

    public void setStrokeWidth(float f) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        int i = drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            float f2 = i;
            if (f > f2) {
                f = f2;
            }
        }
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5 = (int) f;
        invalidate();
    }

    public void setStrokeWidth(int i) {
        int PlaceComponentResult2 = DensityUtils.PlaceComponentResult(i);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        int i2 = drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (PlaceComponentResult2 < 0) {
            PlaceComponentResult2 = 0;
        } else if (PlaceComponentResult2 > i2) {
            PlaceComponentResult2 = i2;
        }
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5 = PlaceComponentResult2;
        invalidate();
    }

    public int getStrokeWidth() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    public void setSelectedColor(int i) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6 = i;
        invalidate();
    }

    public int getSelectedColor() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public void setUnselectedColor(int i) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding = i;
        invalidate();
    }

    public int getUnselectedColor() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding;
    }

    public void setAutoVisibility(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = z;
        getErrorConfigVersion();
    }

    public void setOrientation(Orientation orientation) {
        if (orientation != null) {
            DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2 = orientation;
            requestLayout();
        }
    }

    public void setAnimationDuration(long j) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = j;
    }

    public void setIdleDuration(long j) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = j;
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            MyBillsEntityDataFactory();
        }
    }

    public long getAnimationDuration() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
    }

    public void setAnimationType(AnimationType animationType) {
        IndicatorManager indicatorManager = this.getAuthRequestContext;
        indicatorManager.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = null;
        IndicatorManager.Listener listener = indicatorManager.getAuthRequestContext;
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
        if (animationType != null) {
            DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = animationType;
        } else {
            DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        invalidate();
    }

    public void setInteractiveAnimation(boolean z) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        this.MyBillsEntityDataFactory = z;
    }

    public void setViewPager(ViewPager viewPager) {
        releaseViewPager();
        if (viewPager == null) {
            return;
        }
        this.lookAheadTest = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.lookAheadTest.addOnAdapterChangeListener(this);
        this.lookAheadTest.setOnTouchListener(this);
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable = this.lookAheadTest.getId();
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        setDynamicCount(drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
        lookAheadTest();
    }

    public void releaseViewPager() {
        ViewPager viewPager = this.lookAheadTest;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
            this.lookAheadTest.removeOnAdapterChangeListener(this);
            this.lookAheadTest = null;
        }
    }

    public void setRtlMode(RtlMode rtlMode) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        if (rtlMode == null) {
            indicator.isLayoutRequested = RtlMode.Off;
        } else {
            indicator.isLayoutRequested = rtlMode;
        }
        if (this.lookAheadTest == null) {
            return;
        }
        int i = indicator.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
            ViewPager viewPager = this.lookAheadTest;
            if (viewPager != null) {
                i = viewPager.getCurrentItem();
            }
        } else {
            i = (indicator.PlaceComponentResult - 1) - i;
        }
        indicator.DatabaseTableConfigUtil = i;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        invalidate();
    }

    public int getSelection() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        return drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    public void setSelection(int i) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        int i2 = drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult - 1;
        if (i < 0) {
            i = 0;
        } else if (i > i2) {
            i = i2;
        }
        if (i == indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 || i == indicator.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            return;
        }
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        indicator.DatabaseTableConfigUtil = indicator.NetworkUserEntityData$$ExternalSyntheticLambda4;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        AnimationManager animationManager = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
        AnimationController animationController = animationManager.MyBillsEntityDataFactory;
        if (animationController != null) {
            BaseAnimation baseAnimation = animationController.PlaceComponentResult;
            if (baseAnimation != null) {
                baseAnimation.MyBillsEntityDataFactory();
            }
            AnimationController animationController2 = animationManager.MyBillsEntityDataFactory;
            animationController2.MyBillsEntityDataFactory = false;
            animationController2.getAuthRequestContext = 0.0f;
            animationController2.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public void setSelected(int i) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        AnimationType animationType = indicator.KClassImpl$Data$declaredNonStaticMembers$2;
        indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        setSelection(i);
        indicator.KClassImpl$Data$declaredNonStaticMembers$2 = animationType;
    }

    public void clearSelection() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        indicator.DatabaseTableConfigUtil = -1;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda3 = -1;
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 = -1;
        AnimationManager animationManager = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
        AnimationController animationController = animationManager.MyBillsEntityDataFactory;
        if (animationController != null) {
            BaseAnimation baseAnimation = animationController.PlaceComponentResult;
            if (baseAnimation != null) {
                baseAnimation.MyBillsEntityDataFactory();
            }
            AnimationController animationController2 = animationManager.MyBillsEntityDataFactory;
            animationController2.MyBillsEntityDataFactory = false;
            animationController2.getAuthRequestContext = 0.0f;
            animationController2.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public void setProgress(int i, float f) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        if (indicator.PlaceComponentResult()) {
            int i2 = indicator.PlaceComponentResult;
            if (i2 <= 0 || i < 0) {
                i = 0;
            } else {
                int i3 = i2 - 1;
                if (i > i3) {
                    i = i3;
                }
            }
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            if (f == 1.0f) {
                indicator.DatabaseTableConfigUtil = indicator.NetworkUserEntityData$$ExternalSyntheticLambda4;
                indicator.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
            }
            indicator.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
            AnimationController animationController = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            if (animationController != null) {
                animationController.MyBillsEntityDataFactory = true;
                animationController.getAuthRequestContext = f;
                animationController.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    public void setClickListener(DrawController.ClickListener clickListener) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = clickListener;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet) {
        IndicatorManager indicatorManager = new IndicatorManager(this);
        this.getAuthRequestContext = indicatorManager;
        DrawManager drawManager = indicatorManager.KClassImpl$Data$declaredNonStaticMembers$2;
        drawManager.getAuthRequestContext.PlaceComponentResult(getContext(), attributeSet);
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager2.KClassImpl$Data$declaredNonStaticMembers$2;
        indicator.initRecordTimeStamp = getPaddingLeft();
        indicator.NetworkUserEntityData$$ExternalSyntheticLambda7 = getPaddingTop();
        indicator.newProxyInstance = getPaddingRight();
        indicator.GetContactSyncConfig = getPaddingBottom();
        this.MyBillsEntityDataFactory = indicator.PlaceComponentResult();
    }

    private void getAuthRequestContext() {
        ViewPager viewPager;
        if (this.BuiltInFictitiousFunctionClassFactory != null || (viewPager = this.lookAheadTest) == null || viewPager.getAdapter() == null) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = new DataSetObserver() { // from class: com.rd.PageIndicatorView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PageIndicatorView.this.lookAheadTest();
            }
        };
        try {
            this.lookAheadTest.getAdapter().registerDataSetObserver(this.BuiltInFictitiousFunctionClassFactory);
        } catch (IllegalStateException unused) {
        }
    }

    private void scheduleImpl() {
        ViewPager viewPager;
        if (this.BuiltInFictitiousFunctionClassFactory == null || (viewPager = this.lookAheadTest) == null || viewPager.getAdapter() == null) {
            return;
        }
        try {
            this.lookAheadTest.getAdapter().unregisterDataSetObserver(this.BuiltInFictitiousFunctionClassFactory);
            this.BuiltInFictitiousFunctionClassFactory = null;
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lookAheadTest() {
        BaseAnimation baseAnimation;
        ViewPager viewPager = this.lookAheadTest;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        int count = this.lookAheadTest.getAdapter().getCount();
        int currentItem = KClassImpl$Data$declaredNonStaticMembers$2() ? (count - 1) - this.lookAheadTest.getCurrentItem() : this.lookAheadTest.getCurrentItem();
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 = currentItem;
        DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3 = currentItem;
        DrawManager drawManager3 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager3.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager3.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager3.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = currentItem;
        DrawManager drawManager4 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager4.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager4.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        drawManager4.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = count;
        AnimationController animationController = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        if (animationController != null && (baseAnimation = animationController.PlaceComponentResult) != null) {
            baseAnimation.MyBillsEntityDataFactory();
        }
        getErrorConfigVersion();
        requestLayout();
    }

    private void getErrorConfigVersion() {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            DrawManager drawManager2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                drawManager2.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
            }
            int i = drawManager2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
            int visibility = getVisibility();
            if (visibility != 0 && i > 1) {
                setVisibility(0);
            } else if (visibility == 4 || i > 1) {
            } else {
                setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rd.PageIndicatorView$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[RtlMode.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[RtlMode.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[RtlMode.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[RtlMode.Auto.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        int[] iArr = AnonymousClass3.MyBillsEntityDataFactory;
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        if (indicator.isLayoutRequested == null) {
            indicator.isLayoutRequested = RtlMode.Off;
        }
        int i = iArr[indicator.isLayoutRequested.ordinal()];
        return i == 1 || (i == 3 && TextUtilsCompat.PlaceComponentResult(getContext().getResources().getConfiguration().locale) == 1);
    }

    private boolean PlaceComponentResult() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        Handler handler = PlaceComponentResult;
        handler.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        handler.postDelayed(runnable, drawManager.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
    }

    private void MyBillsEntityDataFactory() {
        PlaceComponentResult.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
        animate().cancel();
        animate().alpha(1.0f).setDuration(250L);
    }

    static /* synthetic */ void access$200(PageIndicatorView pageIndicatorView) {
        pageIndicatorView.animate().cancel();
        pageIndicatorView.animate().alpha(0.0f).setDuration(250L);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        if (indicator.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            indicator.KClassImpl$Data$declaredNonStaticMembers$2 = AnimationType.NONE;
        }
        if (PlaceComponentResult() && indicator.PlaceComponentResult() && indicator.KClassImpl$Data$declaredNonStaticMembers$2 != AnimationType.NONE) {
            Pair<Integer, Float> KClassImpl$Data$declaredNonStaticMembers$2 = CoordinatesUtils.KClassImpl$Data$declaredNonStaticMembers$2(indicator, i, f, KClassImpl$Data$declaredNonStaticMembers$2());
            setProgress(((Integer) KClassImpl$Data$declaredNonStaticMembers$2.first).intValue(), ((Float) KClassImpl$Data$declaredNonStaticMembers$2.second).floatValue());
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        DrawManager drawManager = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        Indicator indicator = drawManager.KClassImpl$Data$declaredNonStaticMembers$2;
        boolean PlaceComponentResult2 = PlaceComponentResult();
        int i2 = indicator.PlaceComponentResult;
        if (PlaceComponentResult2) {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                i = (i2 - 1) - i;
            }
            setSelection(i);
        }
    }
}
