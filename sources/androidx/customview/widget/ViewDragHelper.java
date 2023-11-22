package androidx.customview.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ViewDragHelper {
    private static final Interpolator NetworkUserEntityData$$ExternalSyntheticLambda0 = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public View BuiltInFictitiousFunctionClassFactory;
    private int[] DatabaseTableConfigUtil;
    private final Callback GetContactSyncConfig;
    public final int KClassImpl$Data$declaredNonStaticMembers$2;
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    private OverScroller NetworkUserEntityData$$ExternalSyntheticLambda3;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda7;
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    public int PlaceComponentResult;
    private float[] PrepareContext;
    public int getAuthRequestContext;
    public int getErrorConfigVersion;
    private int[] initRecordTimeStamp;
    private float isLayoutRequested;
    public int lookAheadTest;
    public float moveToNextValue;
    private float[] newProxyInstance;
    public VelocityTracker scheduleImpl;
    public int MyBillsEntityDataFactory = -1;
    private final Runnable FragmentBottomSheetPaymentSettingBinding = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.MyBillsEntityDataFactory(0);
        }
    };

    /* loaded from: classes3.dex */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public static ViewDragHelper MyBillsEntityDataFactory(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = viewGroup;
        this.GetContactSyncConfig = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = i;
        this.lookAheadTest = viewConfiguration.getScaledTouchSlop();
        this.isLayoutRequested = viewConfiguration.getScaledMaximumFlingVelocity();
        this.moveToNextValue = viewConfiguration.getScaledMinimumFlingVelocity();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new OverScroller(context, NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public final void getAuthRequestContext(View view, int i) {
        if (view.getParent() != this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            StringBuilder sb = new StringBuilder();
            sb.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            sb.append(")");
            throw new IllegalArgumentException(sb.toString());
        }
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = i;
        this.GetContactSyncConfig.onViewCaptured(view, i);
        MyBillsEntityDataFactory(1);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = -1;
        boolean authRequestContext = getAuthRequestContext(i, i2, 0, 0);
        if (!authRequestContext && this.PlaceComponentResult == 0 && this.BuiltInFictitiousFunctionClassFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
        return authRequestContext;
    }

    public final boolean getAuthRequestContext(int i, int i2) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return getAuthRequestContext(i, i2, (int) this.scheduleImpl.getXVelocity(this.MyBillsEntityDataFactory), (int) this.scheduleImpl.getYVelocity(this.MyBillsEntityDataFactory));
    }

    private boolean getAuthRequestContext(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.BuiltInFictitiousFunctionClassFactory.getLeft();
        int top = this.BuiltInFictitiousFunctionClassFactory.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.abortAnimation();
            MyBillsEntityDataFactory(0);
            return false;
        }
        View view = this.BuiltInFictitiousFunctionClassFactory;
        int i7 = (int) this.moveToNextValue;
        int i8 = (int) this.isLayoutRequested;
        int abs = Math.abs(i3);
        if (abs < i7) {
            i3 = 0;
        } else if (abs > i8) {
            i3 = i3 <= 0 ? -i8 : i8;
        }
        int i9 = (int) this.moveToNextValue;
        int i10 = (int) this.isLayoutRequested;
        int abs2 = Math.abs(i4);
        if (abs2 < i9) {
            i4 = 0;
        } else if (abs2 > i10) {
            i4 = i4 <= 0 ? -i10 : i10;
        }
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int abs5 = Math.abs(i3);
        int abs6 = Math.abs(i4);
        int i11 = abs5 + abs6;
        int i12 = abs3 + abs4;
        if (i3 != 0) {
            f = abs5;
            f2 = i11;
        } else {
            f = abs3;
            f2 = i12;
        }
        float f5 = f / f2;
        if (i4 != 0) {
            f3 = abs6;
            f4 = i11;
        } else {
            f3 = abs4;
            f4 = i12;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.startScroll(left, top, i5, i6, (int) ((PlaceComponentResult(i5, i3, this.GetContactSyncConfig.getViewHorizontalDragRange(view)) * f5) + (PlaceComponentResult(i6, i4, this.GetContactSyncConfig.getViewVerticalDragRange(view)) * (f3 / f4))));
        MyBillsEntityDataFactory(2);
        return true;
    }

    private int PlaceComponentResult(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        float width = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getWidth() / 2;
        float sin = (float) Math.sin((Math.min(1.0f, Math.abs(i) / r0) - 0.5f) * 0.47123894f);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs((width + (sin * width)) / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.PlaceComponentResult == 2) {
            boolean computeScrollOffset = this.NetworkUserEntityData$$ExternalSyntheticLambda3.computeScrollOffset();
            int currX = this.NetworkUserEntityData$$ExternalSyntheticLambda3.getCurrX();
            int currY = this.NetworkUserEntityData$$ExternalSyntheticLambda3.getCurrY();
            int left = currX - this.BuiltInFictitiousFunctionClassFactory.getLeft();
            int top = currY - this.BuiltInFictitiousFunctionClassFactory.getTop();
            if (left != 0) {
                ViewCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, left);
            }
            if (top != 0) {
                ViewCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, top);
            }
            if (left != 0 || top != 0) {
                this.GetContactSyncConfig.onViewPositionChanged(this.BuiltInFictitiousFunctionClassFactory, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.NetworkUserEntityData$$ExternalSyntheticLambda3.getFinalX() && currY == this.NetworkUserEntityData$$ExternalSyntheticLambda3.getFinalY()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.post(this.FragmentBottomSheetPaymentSettingBinding);
            }
        }
        return this.PlaceComponentResult == 2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
        this.GetContactSyncConfig.onViewReleased(this.BuiltInFictitiousFunctionClassFactory, f, f2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
        if (this.PlaceComponentResult == 1) {
            MyBillsEntityDataFactory(0);
        }
    }

    public final void PlaceComponentResult() {
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.newProxyInstance, 0.0f);
        Arrays.fill(this.PrepareContext, 0.0f);
        Arrays.fill(this.NetworkUserEntityData$$ExternalSyntheticLambda8, 0.0f);
        Arrays.fill(this.initRecordTimeStamp, 0);
        Arrays.fill(this.NetworkUserEntityData$$ExternalSyntheticLambda1, 0);
        Arrays.fill(this.DatabaseTableConfigUtil, 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
    }

    private void getAuthRequestContext(int i) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null || !BuiltInFictitiousFunctionClassFactory(i)) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2[i] = 0.0f;
        this.newProxyInstance[i] = 0.0f;
        this.PrepareContext[i] = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8[i] = 0.0f;
        this.initRecordTimeStamp[i] = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1[i] = 0;
        this.DatabaseTableConfigUtil[i] = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = ((1 << i) ^ (-1)) & this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    private void PlaceComponentResult(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (PlaceComponentResult(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.PrepareContext[pointerId] = x;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[pointerId] = y;
            }
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return ((1 << i) & this.NetworkUserEntityData$$ExternalSyntheticLambda4) != 0;
    }

    final void MyBillsEntityDataFactory(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.removeCallbacks(this.FragmentBottomSheetPaymentSettingBinding);
        if (this.PlaceComponentResult != i) {
            this.PlaceComponentResult = i;
            this.GetContactSyncConfig.onViewDragStateChanged(i);
            if (this.PlaceComponentResult == 0) {
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
        }
    }

    private boolean MyBillsEntityDataFactory(View view, int i) {
        if (view == this.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == i) {
            return true;
        }
        if (view == null || !this.GetContactSyncConfig.tryCaptureView(view, i)) {
            return false;
        }
        this.MyBillsEntityDataFactory = i;
        getAuthRequestContext(view, i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e7, code lost:
    
        if (r12 != r11) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean MyBillsEntityDataFactory(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.MyBillsEntityDataFactory(android.view.MotionEvent):boolean");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            this.MyBillsEntityDataFactory = -1;
            PlaceComponentResult();
            VelocityTracker velocityTracker = this.scheduleImpl;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.scheduleImpl = null;
            }
        }
        if (this.scheduleImpl == null) {
            this.scheduleImpl = VelocityTracker.obtain();
        }
        this.scheduleImpl.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory((int) x, (int) y);
            BuiltInFictitiousFunctionClassFactory(x, y, pointerId);
            MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, pointerId);
            int i3 = this.initRecordTimeStamp[pointerId] & this.getErrorConfigVersion;
            if (i3 != 0) {
                this.GetContactSyncConfig.onEdgeTouched(i3, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.PlaceComponentResult == 1) {
                MyBillsEntityDataFactory();
            }
            this.MyBillsEntityDataFactory = -1;
            PlaceComponentResult();
            VelocityTracker velocityTracker2 = this.scheduleImpl;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.scheduleImpl = null;
            }
        } else if (actionMasked == 2) {
            if (this.PlaceComponentResult == 1) {
                if (PlaceComponentResult(this.MyBillsEntityDataFactory)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.MyBillsEntityDataFactory);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.PrepareContext;
                    int i4 = this.MyBillsEntityDataFactory;
                    int i5 = (int) (x2 - fArr[i4]);
                    int i6 = (int) (y2 - this.NetworkUserEntityData$$ExternalSyntheticLambda8[i4]);
                    int left = this.BuiltInFictitiousFunctionClassFactory.getLeft() + i5;
                    int top = this.BuiltInFictitiousFunctionClassFactory.getTop() + i6;
                    int left2 = this.BuiltInFictitiousFunctionClassFactory.getLeft();
                    int top2 = this.BuiltInFictitiousFunctionClassFactory.getTop();
                    if (i5 != 0) {
                        left = this.GetContactSyncConfig.clampViewPositionHorizontal(this.BuiltInFictitiousFunctionClassFactory, left, i5);
                        ViewCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, left - left2);
                    }
                    int i7 = left;
                    if (i6 != 0) {
                        top = this.GetContactSyncConfig.clampViewPositionVertical(this.BuiltInFictitiousFunctionClassFactory, top, i6);
                        ViewCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, top - top2);
                    }
                    int i8 = top;
                    if (i5 != 0 || i6 != 0) {
                        this.GetContactSyncConfig.onViewPositionChanged(this.BuiltInFictitiousFunctionClassFactory, i7, i8, i7 - left2, i8 - top2);
                    }
                    PlaceComponentResult(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (PlaceComponentResult(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.NetworkUserEntityData$$ExternalSyntheticLambda2[pointerId2];
                    float f2 = y3 - this.newProxyInstance[pointerId2];
                    MyBillsEntityDataFactory(f, f2, pointerId2);
                    if (this.PlaceComponentResult == 1) {
                        break;
                    }
                    View BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory((int) x3, (int) y3);
                    if (BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, f, f2) && MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2, pointerId2)) {
                        break;
                    }
                }
                i2++;
            }
            PlaceComponentResult(motionEvent);
        } else if (actionMasked == 3) {
            if (this.PlaceComponentResult == 1) {
                KClassImpl$Data$declaredNonStaticMembers$2(0.0f, 0.0f);
            }
            this.MyBillsEntityDataFactory = -1;
            PlaceComponentResult();
            VelocityTracker velocityTracker3 = this.scheduleImpl;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.scheduleImpl = null;
            }
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            BuiltInFictitiousFunctionClassFactory(x4, y4, pointerId3);
            if (this.PlaceComponentResult == 0) {
                MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory((int) x4, (int) y4), pointerId3);
                int i9 = this.initRecordTimeStamp[pointerId3] & this.getErrorConfigVersion;
                if (i9 != 0) {
                    this.GetContactSyncConfig.onEdgeTouched(i9, pointerId3);
                }
            } else if (KClassImpl$Data$declaredNonStaticMembers$2((int) x4, (int) y4)) {
                MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, pointerId3);
            }
        } else if (actionMasked == 6) {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.PlaceComponentResult == 1 && pointerId4 == this.MyBillsEntityDataFactory) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i2);
                    if (pointerId5 != this.MyBillsEntityDataFactory) {
                        View BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.BuiltInFictitiousFunctionClassFactory;
                        if (BuiltInFictitiousFunctionClassFactory3 == view && MyBillsEntityDataFactory(view, pointerId5)) {
                            i = this.MyBillsEntityDataFactory;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    MyBillsEntityDataFactory();
                }
            }
            getAuthRequestContext(pointerId4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    private void MyBillsEntityDataFactory(float f, float f2, int i) {
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(f, f2, i, 1);
        boolean z = MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory(f2, f, i, 4)) {
            z = MyBillsEntityDataFactory | true;
        }
        boolean z2 = z;
        if (MyBillsEntityDataFactory(f, f2, i, 2)) {
            z2 = (z ? 1 : 0) | true;
        }
        ?? r0 = z2;
        if (MyBillsEntityDataFactory(f2, f, i, 8)) {
            r0 = (z2 ? 1 : 0) | true;
        }
        if (r0 != 0) {
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            iArr[i] = iArr[i] | r0;
            this.GetContactSyncConfig.onEdgeDragStarted(r0, i);
        }
    }

    private boolean MyBillsEntityDataFactory(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.initRecordTimeStamp[i] & i2) != i2 || (this.getErrorConfigVersion & i2) == 0 || (this.DatabaseTableConfigUtil[i] & i2) == i2 || (this.NetworkUserEntityData$$ExternalSyntheticLambda1[i] & i2) == i2) {
            return false;
        }
        float f3 = this.lookAheadTest;
        if (abs > f3 || abs2 > f3) {
            if (abs >= abs2 * 0.5f || !this.GetContactSyncConfig.onEdgeLock(i2)) {
                return (this.NetworkUserEntityData$$ExternalSyntheticLambda1[i] & i2) == 0 && abs > ((float) this.lookAheadTest);
            }
            int[] iArr = this.DatabaseTableConfigUtil;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.GetContactSyncConfig.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.GetContactSyncConfig.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.lookAheadTest) : z2 && Math.abs(f2) > ((float) this.lookAheadTest);
        }
        int i = this.lookAheadTest;
        return (f * f) + (f2 * f2) > ((float) (i * i));
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        int length = this.NetworkUserEntityData$$ExternalSyntheticLambda2.length;
        for (int i = 0; i < length; i++) {
            if (KClassImpl$Data$declaredNonStaticMembers$2(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (BuiltInFictitiousFunctionClassFactory(i)) {
            float f = this.PrepareContext[i] - this.NetworkUserEntityData$$ExternalSyntheticLambda2[i];
            float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8[i] - this.newProxyInstance[i];
            int i2 = this.lookAheadTest;
            return (f * f) + (f2 * f2) > ((float) (i2 * i2));
        }
        return false;
    }

    private void MyBillsEntityDataFactory() {
        this.scheduleImpl.computeCurrentVelocity(1000, this.isLayoutRequested);
        float xVelocity = this.scheduleImpl.getXVelocity(this.MyBillsEntityDataFactory);
        float f = this.moveToNextValue;
        float f2 = this.isLayoutRequested;
        float abs = Math.abs(xVelocity);
        float f3 = 0.0f;
        if (abs < f) {
            xVelocity = 0.0f;
        } else if (abs > f2) {
            xVelocity = xVelocity <= 0.0f ? -f2 : f2;
        }
        float yVelocity = this.scheduleImpl.getYVelocity(this.MyBillsEntityDataFactory);
        float f4 = this.moveToNextValue;
        float f5 = this.isLayoutRequested;
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f4) {
            if (abs2 > f5) {
                if (yVelocity <= 0.0f) {
                    yVelocity = -f5;
                } else {
                    f3 = f5;
                }
            }
            f3 = yVelocity;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(xVelocity, f3);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        return PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, i, i2);
    }

    public static boolean PlaceComponentResult(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public final View BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        for (int childCount = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getChildAt(this.GetContactSyncConfig.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean PlaceComponentResult(int i) {
        if (BuiltInFictitiousFunctionClassFactory(i)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Ignoring pointerId=");
        sb.append(i);
        sb.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        InstrumentInjector.log_e("ViewDragHelper", sb.toString());
        return false;
    }

    public static ViewDragHelper MyBillsEntityDataFactory(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper viewDragHelper = new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
        viewDragHelper.lookAheadTest = (int) (viewDragHelper.lookAheadTest * (1.0f / f));
        return viewDragHelper;
    }

    private void BuiltInFictitiousFunctionClassFactory(float f, float f2, int i) {
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.newProxyInstance;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.PrepareContext;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.initRecordTimeStamp;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.DatabaseTableConfigUtil;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = fArr2;
            this.newProxyInstance = fArr3;
            this.PrepareContext = fArr4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = fArr5;
            this.initRecordTimeStamp = iArr;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = iArr2;
            this.DatabaseTableConfigUtil = iArr3;
        }
        float[] fArr9 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.PrepareContext[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.initRecordTimeStamp;
        int i3 = (int) f;
        int i4 = (int) f2;
        int i5 = i3 < this.NetworkUserEntityData$$ExternalSyntheticLambda7.getLeft() + this.getAuthRequestContext ? 1 : 0;
        if (i4 < this.NetworkUserEntityData$$ExternalSyntheticLambda7.getTop() + this.getAuthRequestContext) {
            i5 |= 4;
        }
        if (i3 > this.NetworkUserEntityData$$ExternalSyntheticLambda7.getRight() - this.getAuthRequestContext) {
            i5 |= 2;
        }
        if (i4 > this.NetworkUserEntityData$$ExternalSyntheticLambda7.getBottom() - this.getAuthRequestContext) {
            i5 |= 8;
        }
        iArr7[i] = i5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 |= 1 << i;
    }

    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = -1;
        PlaceComponentResult();
        VelocityTracker velocityTracker = this.scheduleImpl;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.scheduleImpl = null;
        }
        if (this.PlaceComponentResult == 2) {
            int currX = this.NetworkUserEntityData$$ExternalSyntheticLambda3.getCurrX();
            int currY = this.NetworkUserEntityData$$ExternalSyntheticLambda3.getCurrY();
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.abortAnimation();
            int currX2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3.getCurrX();
            int currY2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3.getCurrY();
            this.GetContactSyncConfig.onViewPositionChanged(this.BuiltInFictitiousFunctionClassFactory, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        MyBillsEntityDataFactory(0);
    }
}
