package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DropDownListView extends ListView implements FSDispatchDraw {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int GetContactSyncConfig;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Field MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private GateKeeperDrawable NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean PlaceComponentResult;
    private ViewPropertyAnimatorCompat getAuthRequestContext;
    private int getErrorConfigVersion;
    private final Rect initRecordTimeStamp;
    private int lookAheadTest;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper moveToNextValue;
    private int scheduleImpl;

    @Override // android.widget.ListView, android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_e72353112e9c29f096427b84cb635d68(canvas, view, j);
    }

    public void fsSuperDispatchDraw_e72353112e9c29f096427b84cb635d68(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_e72353112e9c29f096427b84cb635d68(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropDownListView(Context context, boolean z) {
        super(context, null, R.attr.BottomSheetCardBindingView$watcherCardNumberView$1);
        this.initRecordTimeStamp = new Rect();
        this.scheduleImpl = 0;
        this.GetContactSyncConfig = 0;
        this.lookAheadTest = 0;
        this.getErrorConfigVersion = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.MyBillsEntityDataFactory = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable = drawable != null ? new GateKeeperDrawable(drawable) : null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.scheduleImpl = rect.left;
        this.GetContactSyncConfig = rect.top;
        this.lookAheadTest = rect.right;
        this.getErrorConfigVersion = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.mResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        GateKeeperDrawable gateKeeperDrawable = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.getAuthRequestContext = true;
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
        if (resolveHoverRunnable != null) {
            DropDownListView.this.mResolveHoverRunnable = null;
            DropDownListView.this.removeCallbacks(resolveHoverRunnable);
        }
        return super.onTouchEvent(motionEvent);
    }

    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z) {
                    min = Math.max(0, i);
                    while (min < count && !adapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i, count - 1);
                    while (min >= 0 && !adapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            } else if (i >= 0 && i < count) {
                return i;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i6 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i6;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i7 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || i6 == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = i6;
            }
            i7++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GateKeeperDrawable extends DrawableWrapper implements FSDraw {
        boolean getAuthRequestContext;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.getAuthRequestContext = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.getAuthRequestContext) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.getAuthRequestContext) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.getAuthRequestContext) {
                super.setHotspot(f, f2);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.getAuthRequestContext) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.getAuthRequestContext) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.mResolveHoverRunnable = resolveHoverRunnable;
            DropDownListView.this.post(resolveHoverRunnable);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (Build.VERSION.SDK_INT >= 30 && Api30Impl.BuiltInFictitiousFunctionClassFactory()) {
                        Api30Impl.getAuthRequestContext(this, pointToPosition, childAt);
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r2 != 3) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onForwardedEvent(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        Drawable selector = getSelector();
        if (selector != null && PlaceComponentResult() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private boolean PlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView.this.mResolveHoverRunnable = null;
            DropDownListView.this.drawableStateChanged();
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        private static boolean BuiltInFictitiousFunctionClassFactory;
        private static Method KClassImpl$Data$declaredNonStaticMembers$2;
        private static Method MyBillsEntityDataFactory;
        private static Method getAuthRequestContext;

        static {
            try {
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", Integer.TYPE, View.class, Boolean.TYPE, Float.TYPE, Float.TYPE);
                KClassImpl$Data$declaredNonStaticMembers$2 = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", Integer.TYPE);
                getAuthRequestContext = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", Integer.TYPE);
                MyBillsEntityDataFactory = declaredMethod3;
                declaredMethod3.setAccessible(true);
                BuiltInFictitiousFunctionClassFactory = true;
            } catch (NoSuchMethodException unused) {
            }
        }

        private Api30Impl() {
        }

        static boolean BuiltInFictitiousFunctionClassFactory() {
            return BuiltInFictitiousFunctionClassFactory;
        }

        static void getAuthRequestContext(DropDownListView dropDownListView, int i, View view) {
            try {
                KClassImpl$Data$declaredNonStaticMembers$2.invoke(dropDownListView, Integer.valueOf(i), view, Boolean.FALSE, -1, -1);
                getAuthRequestContext.invoke(dropDownListView, Integer.valueOf(i));
                MyBillsEntityDataFactory.invoke(dropDownListView, Integer.valueOf(i));
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void MyBillsEntityDataFactory(View view, float f, float f2) {
            view.drawableHotspotChanged(f, f2);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.initRecordTimeStamp.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.initRecordTimeStamp);
            selector.draw(canvas);
        }
        fsSuperDispatchDraw_e72353112e9c29f096427b84cb635d68(canvas);
    }
}
