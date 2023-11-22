package id.dana.drawable.merchantdetail.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import id.dana.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class CustomMerchantDetailBottomsheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    int BuiltInFictitiousFunctionClassFactory;
    private final ViewDragHelper.Callback DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    private View GetContactSyncConfig;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private List<BottomSheetCallback> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private WeakReference<View> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private VelocityTracker NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    int PlaceComponentResult;
    private int PrepareContext;
    private int SubSequence;
    int getAuthRequestContext;
    private WeakReference<V> getCallingPid;
    private boolean getErrorConfigVersion;
    private boolean initRecordTimeStamp;
    private float isLayoutRequested;
    private int lookAheadTest;
    private int moveToNextValue;
    private int newProxyInstance;
    private boolean readMicros;
    ViewDragHelper scheduleImpl;
    private boolean whenAvailable;

    /* loaded from: classes9.dex */
    public interface BottomSheetCallback {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface State {
    }

    public CustomMerchantDetailBottomsheetBehavior() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList();
        this.initRecordTimeStamp = true;
        this.SubSequence = 5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 5;
        this.DatabaseTableConfigUtil = new ViewDragHelper.Callback() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.CustomMerchantDetailBottomsheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1 && CustomMerchantDetailBottomsheetBehavior.this.initRecordTimeStamp) {
                    CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2 = 3;
                if (f2 < 0.0f) {
                    i = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                } else if (CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory && CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext(view, f2)) {
                    i = CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext;
                    i2 = 5;
                } else {
                    if (f2 != 0.0f) {
                        i = CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult;
                    } else {
                        int top = view.getTop();
                        if (Math.abs(top - CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory) < Math.abs(top - CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult)) {
                            i = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                        } else {
                            i = CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult;
                        }
                    }
                    i2 = 4;
                }
                if (CustomMerchantDetailBottomsheetBehavior.this.scheduleImpl.getAuthRequestContext(view.getLeft(), i)) {
                    CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(2);
                    ViewCompat.PlaceComponentResult(view, new SettleRunnable(view, i2));
                    return;
                }
                CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(i2);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                int i;
                int i2;
                if (CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory) {
                    i = CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext;
                    i2 = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                } else {
                    i = CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult;
                    i2 = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                }
                return i - i2;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View view2;
                if (CustomMerchantDetailBottomsheetBehavior.this.SubSequence == 1 || CustomMerchantDetailBottomsheetBehavior.this.whenAvailable) {
                    return false;
                }
                return ((CustomMerchantDetailBottomsheetBehavior.this.SubSequence == 3 && CustomMerchantDetailBottomsheetBehavior.this.moveToNextValue == i && (view2 = (View) CustomMerchantDetailBottomsheetBehavior.this.NetworkUserEntityData$$ExternalSyntheticLambda6.get()) != null && view2.canScrollVertically(-1)) || CustomMerchantDetailBottomsheetBehavior.this.getCallingPid == null || CustomMerchantDetailBottomsheetBehavior.this.getCallingPid.get() != view) ? false : true;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.BuiltInFictitiousFunctionClassFactory(i, CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory, CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory ? CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext : CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                if (CustomMerchantDetailBottomsheetBehavior.this.getCallingPid.get() != null) {
                    View view2 = (View) CustomMerchantDetailBottomsheetBehavior.this.getCallingPid.get();
                    CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory(i2, (i2 > CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult || CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult == CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory) ? ((CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult - i2) / CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext) - CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult : (CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult - i2) / (CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult - CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory));
                    CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory(view2);
                }
            }
        };
    }

    public CustomMerchantDetailBottomsheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList();
        this.initRecordTimeStamp = true;
        this.SubSequence = 5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 5;
        this.DatabaseTableConfigUtil = new ViewDragHelper.Callback() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.CustomMerchantDetailBottomsheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1 && CustomMerchantDetailBottomsheetBehavior.this.initRecordTimeStamp) {
                    CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2 = 3;
                if (f2 < 0.0f) {
                    i = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                } else if (CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory && CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext(view, f2)) {
                    i = CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext;
                    i2 = 5;
                } else {
                    if (f2 != 0.0f) {
                        i = CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult;
                    } else {
                        int top = view.getTop();
                        if (Math.abs(top - CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory) < Math.abs(top - CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult)) {
                            i = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                        } else {
                            i = CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult;
                        }
                    }
                    i2 = 4;
                }
                if (CustomMerchantDetailBottomsheetBehavior.this.scheduleImpl.getAuthRequestContext(view.getLeft(), i)) {
                    CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(2);
                    ViewCompat.PlaceComponentResult(view, new SettleRunnable(view, i2));
                    return;
                }
                CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(i2);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                int i;
                int i2;
                if (CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory) {
                    i = CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext;
                    i2 = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                } else {
                    i = CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult;
                    i2 = CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory;
                }
                return i - i2;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View view2;
                if (CustomMerchantDetailBottomsheetBehavior.this.SubSequence == 1 || CustomMerchantDetailBottomsheetBehavior.this.whenAvailable) {
                    return false;
                }
                return ((CustomMerchantDetailBottomsheetBehavior.this.SubSequence == 3 && CustomMerchantDetailBottomsheetBehavior.this.moveToNextValue == i && (view2 = (View) CustomMerchantDetailBottomsheetBehavior.this.NetworkUserEntityData$$ExternalSyntheticLambda6.get()) != null && view2.canScrollVertically(-1)) || CustomMerchantDetailBottomsheetBehavior.this.getCallingPid == null || CustomMerchantDetailBottomsheetBehavior.this.getCallingPid.get() != view) ? false : true;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.BuiltInFictitiousFunctionClassFactory(i, CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory, CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory ? CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext : CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                if (CustomMerchantDetailBottomsheetBehavior.this.getCallingPid.get() != null) {
                    View view2 = (View) CustomMerchantDetailBottomsheetBehavior.this.getCallingPid.get();
                    CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory(i2, (i2 > CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult || CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult == CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory) ? ((CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult - i2) / CustomMerchantDetailBottomsheetBehavior.this.getAuthRequestContext) - CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult : (CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult - i2) / (CustomMerchantDetailBottomsheetBehavior.this.PlaceComponentResult - CustomMerchantDetailBottomsheetBehavior.this.BuiltInFictitiousFunctionClassFactory));
                    CustomMerchantDetailBottomsheetBehavior.this.MyBillsEntityDataFactory(view2);
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.d);
        TypedValue peekValue = obtainStyledAttributes.peekValue(2);
        if (peekValue != null && peekValue.data == -1) {
            MyBillsEntityDataFactory(peekValue.data);
        } else {
            MyBillsEntityDataFactory(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.MyBillsEntityDataFactory = obtainStyledAttributes.getBoolean(1, false);
        this.readMicros = obtainStyledAttributes.getBoolean(3, false);
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(0);
        if (peekValue2 != null && peekValue2.data == -1) {
            BuiltInFictitiousFunctionClassFactory(peekValue2.data);
        } else {
            BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes.getDimensionPixelSize(0, -1));
        }
        obtainStyledAttributes.recycle();
        this.isLayoutRequested = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.initRecordTimeStamp) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.moveToNextValue = -1;
            VelocityTracker velocityTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = VelocityTracker.obtain();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.clear();
            int x = (int) motionEvent.getX();
            this.newProxyInstance = (int) motionEvent.getY();
            if (this.SubSequence == 6) {
                this.moveToNextValue = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.whenAvailable = true;
            } else {
                View view = this.NetworkUserEntityData$$ExternalSyntheticLambda6.get();
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.newProxyInstance)) {
                    this.moveToNextValue = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.whenAvailable = true;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.moveToNextValue == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.newProxyInstance);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.whenAvailable = false;
            this.moveToNextValue = -1;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                return false;
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 || (viewDragHelper = this.scheduleImpl) == null || !viewDragHelper.MyBillsEntityDataFactory(motionEvent)) {
            View view2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.get();
            return (this.scheduleImpl == null || actionMasked != 2 || view2 == null || this.NetworkUserEntityData$$ExternalSyntheticLambda2 || this.SubSequence == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.newProxyInstance) - motionEvent.getY()) <= ((float) this.scheduleImpl.lookAheadTest)) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.SubSequence == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.scheduleImpl;
            if (viewDragHelper != null) {
                viewDragHelper.KClassImpl$Data$declaredNonStaticMembers$2(motionEvent);
            }
            if (actionMasked == 0) {
                this.moveToNextValue = -1;
                VelocityTracker velocityTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
                }
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = VelocityTracker.obtain();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.addMovement(motionEvent);
            if (PlaceComponentResult(actionMasked, motionEvent)) {
                this.scheduleImpl.getAuthRequestContext(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        return false;
    }

    private boolean PlaceComponentResult(int i, MotionEvent motionEvent) {
        return this.scheduleImpl != null && i == 2 && !this.NetworkUserEntityData$$ExternalSyntheticLambda2 && Math.abs(((float) this.newProxyInstance) - motionEvent.getY()) > ((float) this.scheduleImpl.lookAheadTest);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.PrepareContext = 0;
        this.FragmentBottomSheetPaymentSettingBinding = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r6, V r7, android.view.View r8, int r9) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.merchantdetail.bottomsheet.CustomMerchantDetailBottomsheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 != 1 && this.initRecordTimeStamp && view == this.NetworkUserEntityData$$ExternalSyntheticLambda6.get()) {
            int top = v.getTop();
            int i5 = top - i2;
            if (i2 > 0) {
                int i6 = this.BuiltInFictitiousFunctionClassFactory;
                if (i5 < i6) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 4) {
                        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, this.KClassImpl$Data$declaredNonStaticMembers$2);
                        KClassImpl$Data$declaredNonStaticMembers$2(6);
                    } else {
                        int i7 = top - i6;
                        iArr[1] = i7;
                        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, -i7);
                        KClassImpl$Data$declaredNonStaticMembers$2(3);
                    }
                } else {
                    iArr[1] = i2;
                    ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, -i2);
                    KClassImpl$Data$declaredNonStaticMembers$2(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i8 = this.PlaceComponentResult;
                if (i5 <= i8 || this.MyBillsEntityDataFactory) {
                    iArr[1] = i2;
                    ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, -i2);
                    KClassImpl$Data$declaredNonStaticMembers$2(1);
                } else {
                    int i9 = top - i8;
                    iArr[1] = i9;
                    ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, -i9);
                    KClassImpl$Data$declaredNonStaticMembers$2(4);
                }
            }
            int top2 = v.getTop();
            if (this.getCallingPid.get() != null) {
                V v2 = this.getCallingPid.get();
                int i10 = this.PlaceComponentResult;
                BuiltInFictitiousFunctionClassFactory(top2, (top2 > i10 || i10 == (i4 = this.BuiltInFictitiousFunctionClassFactory)) ? ((i10 - top2) / this.getAuthRequestContext) - i10 : (i10 - top2) / (i10 - i4));
                MyBillsEntityDataFactory(v2);
            }
            this.PrepareContext = i2;
            this.FragmentBottomSheetPaymentSettingBinding = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.NetworkUserEntityData$$ExternalSyntheticLambda6.get() && (this.SubSequence != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        super.onRestoreInstanceState(coordinatorLayout, v, ((SavedState) parcelable).getSuperState());
        this.SubSequence = 5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (CustomMerchantDetailBottomsheetBehavior<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory(View view) {
        List<BottomSheetCallback> list;
        if (view == null || (list = this.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
            return;
        }
        for (BottomSheetCallback bottomSheetCallback : list) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory(int i, float f) {
        View view = this.GetContactSyncConfig;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (f <= 0.0f) {
            this.GetContactSyncConfig.setVisibility(8);
            return;
        }
        float f2 = this.GetContactSyncConfig.getY() < 0.0f ? i : this.KClassImpl$Data$declaredNonStaticMembers$2;
        float f3 = f2 - height;
        float f4 = this.PlaceComponentResult;
        this.GetContactSyncConfig.setVisibility(0);
        this.GetContactSyncConfig.setY(f3 + ((f4 - f3) * ((i - f2) / (f4 - f2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        List<BottomSheetCallback> list;
        if (this.SubSequence == i) {
            return;
        }
        this.SubSequence = i;
        if (i != 1 && i != 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
        }
        View view = this.GetContactSyncConfig;
        if (view != null && (i == 6 || i == 3)) {
            view.setVisibility(0);
        }
        if (this.getCallingPid.get() == null || (list = this.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
            return;
        }
        for (BottomSheetCallback bottomSheetCallback : list) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAuthRequestContext(View view, float f) {
        return this.readMicros ? view.getTop() >= this.KClassImpl$Data$declaredNonStaticMembers$2 : view.getTop() >= this.PlaceComponentResult && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.PlaceComponentResult)) / ((float) this.NetworkUserEntityData$$ExternalSyntheticLambda3) > 0.5f;
    }

    private void MyBillsEntityDataFactory(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
            }
            z = false;
        } else {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda5 || this.NetworkUserEntityData$$ExternalSyntheticLambda3 != i) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = Math.max(0, i);
                this.PlaceComponentResult = this.getAuthRequestContext - i;
            }
            z = false;
        }
        if (!z || this.SubSequence != 4 || (weakReference = this.getCallingPid) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.getErrorConfigVersion) {
                this.getErrorConfigVersion = true;
            }
            z = false;
        } else {
            if (this.getErrorConfigVersion || this.lookAheadTest != i) {
                this.getErrorConfigVersion = false;
                this.lookAheadTest = Math.max(this.NetworkUserEntityData$$ExternalSyntheticLambda3, i);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext - i;
            }
            z = false;
        }
        if (!z || this.SubSequence != 6 || (weakReference = this.getCallingPid) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    private View getAuthRequestContext(View view) {
        if (ViewCompat.getOnBoardingScenario(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View authRequestContext = getAuthRequestContext(viewGroup.getChildAt(i));
                if (authRequestContext != null) {
                    return authRequestContext;
                }
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes9.dex */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: id.dana.nearbyrevamp.merchantdetail.bottomsheet.CustomMerchantDetailBottomsheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean BuiltInFictitiousFunctionClassFactory;
        final int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        boolean getAuthRequestContext;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.MyBillsEntityDataFactory = parcel.readInt();
            this.PlaceComponentResult = parcel.readInt();
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt() == 1;
            this.getAuthRequestContext = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, CustomMerchantDetailBottomsheetBehavior<?> customMerchantDetailBottomsheetBehavior) {
            super(parcelable);
            this.MyBillsEntityDataFactory = ((CustomMerchantDetailBottomsheetBehavior) customMerchantDetailBottomsheetBehavior).SubSequence;
            this.PlaceComponentResult = ((CustomMerchantDetailBottomsheetBehavior) customMerchantDetailBottomsheetBehavior).NetworkUserEntityData$$ExternalSyntheticLambda3;
            this.BuiltInFictitiousFunctionClassFactory = customMerchantDetailBottomsheetBehavior.MyBillsEntityDataFactory;
            this.getAuthRequestContext = ((CustomMerchantDetailBottomsheetBehavior) customMerchantDetailBottomsheetBehavior).readMicros;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.MyBillsEntityDataFactory);
            parcel.writeInt(this.PlaceComponentResult);
            parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
            parcel.writeInt(this.getAuthRequestContext ? 1 : 0);
        }
    }

    /* loaded from: classes9.dex */
    class SettleRunnable implements Runnable {
        private final View PlaceComponentResult;
        private final int getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SettleRunnable(View view, int i) {
            this.PlaceComponentResult = view;
            this.getAuthRequestContext = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CustomMerchantDetailBottomsheetBehavior.this.scheduleImpl == null || !CustomMerchantDetailBottomsheetBehavior.this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2()) {
                CustomMerchantDetailBottomsheetBehavior.this.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            } else {
                ViewCompat.PlaceComponentResult(this.PlaceComponentResult, this);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ViewCompat.DatabaseTableConfigUtil(coordinatorLayout) && !ViewCompat.DatabaseTableConfigUtil(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.getAuthRequestContext = coordinatorLayout.getHeight();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (i2 != 0) {
                i2 = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.f33552131166004);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = i2;
        }
        if (this.getErrorConfigVersion) {
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i3 == 0) {
                i3 = this.getAuthRequestContext - ((coordinatorLayout.getWidth() * 9) / 16);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
            this.lookAheadTest = i3;
        }
        int max = Math.max(0, this.getAuthRequestContext - v.getHeight());
        this.BuiltInFictitiousFunctionClassFactory = max;
        int max2 = Math.max(this.getAuthRequestContext - this.NetworkUserEntityData$$ExternalSyntheticLambda3, max);
        this.PlaceComponentResult = max2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.min(this.getAuthRequestContext - this.lookAheadTest, max2);
        int i4 = this.SubSequence;
        if (i4 == 3) {
            ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, this.BuiltInFictitiousFunctionClassFactory);
        } else if (this.MyBillsEntityDataFactory && i4 == 5) {
            ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, this.getAuthRequestContext);
            View view = this.GetContactSyncConfig;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (i4 == 4) {
            ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, this.PlaceComponentResult);
            View view2 = this.GetContactSyncConfig;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else if (i4 == 1 || i4 == 2) {
            ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, top - v.getTop());
        } else if (i4 == 6) {
            ViewCompat.BuiltInFictitiousFunctionClassFactory((View) v, this.KClassImpl$Data$declaredNonStaticMembers$2);
            View view3 = this.GetContactSyncConfig;
            if (view3 != null) {
                view3.setY(0.0f);
                this.GetContactSyncConfig.setVisibility(0);
            }
        }
        if (this.scheduleImpl == null) {
            this.scheduleImpl = ViewDragHelper.MyBillsEntityDataFactory(coordinatorLayout, this.DatabaseTableConfigUtil);
        }
        this.getCallingPid = new WeakReference<>(v);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new WeakReference<>(getAuthRequestContext(v));
        return true;
    }
}
