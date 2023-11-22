package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class DrawerLayout extends ViewGroup implements Openable, FSDispatchDraw {
    static final boolean CAN_HIDE_DESCENDANTS;
    private static final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static boolean MyBillsEntityDataFactory = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private Drawable A;
    private Drawable B;
    private Paint BottomSheetCardBindingView$watcherCardNumberView$1;
    private int C;
    private Drawable D;
    private boolean DatabaseTableConfigUtil;
    private Drawable E;
    private List<DrawerListener> FragmentBottomSheetPaymentSettingBinding;
    private CharSequence G;
    private float GetContactSyncConfig;
    private CharSequence H;
    private final ChildAccessibilityDelegate NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private DrawerListener NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Object NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final ViewDragHelper NetworkUserEntityData$$ExternalSyntheticLambda8;
    private float PrepareContext;
    private final ViewDragCallback SubSequence;
    private float VerifyPinStateManager$executeRiskChallenge$2$1;
    private Drawable VerifyPinStateManager$executeRiskChallenge$2$2;
    private final ViewDragHelper getCallingPid;
    private Matrix getErrorConfigVersion;
    private Drawable getOnBoardingScenario;
    private int getSupportButtonTintMode;
    private Drawable getValueOfTouchPositionAbsolute;
    private boolean initRecordTimeStamp;
    private float isLayoutRequested;
    private Rect lookAheadTest;
    private final AccessibilityViewCommand moveToNextValue;
    private final ViewDragCallback newProxyInstance;
    private int readMicros;
    private boolean scheduleImpl;
    private final ArrayList<View> whenAvailable;
    public static final byte[] PlaceComponentResult = {42, -48, 107, -19, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = WSContextConstant.HANDSHAKE_RECEIVE_SIZE;
    private static final int[] BuiltInFictitiousFunctionClassFactory = {16843828};
    static final int[] LAYOUT_ATTRS = {16842931};

    /* loaded from: classes.dex */
    public interface DrawerListener {
        void BuiltInFictitiousFunctionClassFactory(float f);

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();
    }

    /* loaded from: classes6.dex */
    public static abstract class SimpleDrawerListener implements DrawerListener {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_c13e2a28b18b31a4d162bb1cddaa459b(canvas);
    }

    public void fsSuperDispatchDraw_c13e2a28b18b31a4d162bb1cddaa459b(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_c13e2a28b18b31a4d162bb1cddaa459b(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    static {
        CAN_HIDE_DESCENDANTS = Build.VERSION.SDK_INT >= 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = Build.VERSION.SDK_INT >= 21;
        MyBillsEntityDataFactory = Build.VERSION.SDK_INT >= 29;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.PlaceComponentResult);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ChildAccessibilityDelegate();
        this.C = -1728053248;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = new Paint();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 3;
        this.readMicros = 3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 3;
        this.D = null;
        this.A = null;
        this.B = null;
        this.getValueOfTouchPositionAbsolute = null;
        this.moveToNextValue = new AccessibilityViewCommand() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                if (!DrawerLayout.this.isDrawerOpen(view) || DrawerLayout.this.getDrawerLockMode(view) == 2) {
                    return false;
                }
                DrawerLayout.this.closeDrawer(view);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.getSupportButtonTintMode = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.newProxyInstance = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.SubSequence = viewDragCallback2;
        ViewDragHelper MyBillsEntityDataFactory2 = ViewDragHelper.MyBillsEntityDataFactory(this, 1.0f, viewDragCallback);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.getErrorConfigVersion = 1;
        MyBillsEntityDataFactory2.moveToNextValue = f2;
        viewDragCallback.getAuthRequestContext = MyBillsEntityDataFactory2;
        ViewDragHelper MyBillsEntityDataFactory3 = ViewDragHelper.MyBillsEntityDataFactory(this, 1.0f, viewDragCallback2);
        this.getCallingPid = MyBillsEntityDataFactory3;
        MyBillsEntityDataFactory3.getErrorConfigVersion = 2;
        MyBillsEntityDataFactory3.moveToNextValue = f2;
        viewDragCallback2.getAuthRequestContext = MyBillsEntityDataFactory3;
        setFocusableInTouchMode(true);
        ViewCompat.moveToNextValue((View) this, 1);
        ViewCompat.MyBillsEntityDataFactory(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.DatabaseTableConfigUtil(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(APEncodeOptions.DEFAULT_MAX_LEN);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(BuiltInFictitiousFunctionClassFactory);
                try {
                    this.getOnBoardingScenario = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.getOnBoardingScenario = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.MyBillsEntityDataFactory, i, 0);
        try {
            if (obtainStyledAttributes2.hasValue(R.styleable.PlaceComponentResult)) {
                this.GetContactSyncConfig = obtainStyledAttributes2.getDimension(R.styleable.PlaceComponentResult, 0.0f);
            } else {
                this.GetContactSyncConfig = getResources().getDimension(R.dimen.BuiltInFictitiousFunctionClassFactory);
            }
            obtainStyledAttributes2.recycle();
            this.whenAvailable = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setDrawerElevation(float f) {
        this.GetContactSyncConfig = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                ViewCompat.MyBillsEntityDataFactory(childAt, this.GetContactSyncConfig);
            }
        }
    }

    public float getDrawerElevation() {
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            return this.GetContactSyncConfig;
        }
        return 0.0f;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obj;
        this.initRecordTimeStamp = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        if ((i & 8388611) == 8388611) {
            this.D = drawable;
        } else if ((i & 8388613) == 8388613) {
            this.A = drawable;
        } else if ((i & 3) == 3) {
            this.B = drawable;
        } else if ((i & 5) != 5) {
            return;
        } else {
            this.getValueOfTouchPositionAbsolute = drawable;
        }
        PlaceComponentResult();
        invalidate();
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(ContextCompat.PlaceComponentResult(getContext(), i), i2);
    }

    public void setScrimColor(int i) {
        this.C = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = drawerListener;
    }

    public void addDrawerListener(DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.FragmentBottomSheetPaymentSettingBinding == null) {
            this.FragmentBottomSheetPaymentSettingBinding = new ArrayList();
        }
        this.FragmentBottomSheetPaymentSettingBinding.add(drawerListener);
    }

    public void removeDrawerListener(DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener == null || (list = this.FragmentBottomSheetPaymentSettingBinding) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        View findDrawerWithGravity;
        int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(i2, ViewCompat.initRecordTimeStamp(this));
        if (i2 == 3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = i;
        } else if (i2 == 5) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
        } else if (i2 == 8388611) {
            this.readMicros = i;
        } else if (i2 == 8388613) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        }
        if (i != 0) {
            ViewDragHelper viewDragHelper = BuiltInFictitiousFunctionClassFactory2 == 3 ? this.NetworkUserEntityData$$ExternalSyntheticLambda8 : this.getCallingPid;
            viewDragHelper.MyBillsEntityDataFactory = -1;
            viewDragHelper.PlaceComponentResult();
            VelocityTracker velocityTracker = viewDragHelper.scheduleImpl;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                viewDragHelper.scheduleImpl = null;
            }
        }
        if (i != 1) {
            if (i != 2 || (findDrawerWithGravity = findDrawerWithGravity(BuiltInFictitiousFunctionClassFactory2)) == null) {
                return;
            }
            openDrawer(findDrawerWithGravity);
            return;
        }
        View findDrawerWithGravity2 = findDrawerWithGravity(BuiltInFictitiousFunctionClassFactory2);
        if (findDrawerWithGravity2 != null) {
            closeDrawer(findDrawerWithGravity2);
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (!isDrawerView(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a drawer with appropriate layout_gravity");
            throw new IllegalArgumentException(sb.toString());
        }
        setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).MyBillsEntityDataFactory);
    }

    public int getDrawerLockMode(int i) {
        int initRecordTimeStamp = ViewCompat.initRecordTimeStamp(this);
        if (i == 3) {
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (i2 != 3) {
                return i2;
            }
            int i3 = initRecordTimeStamp == 0 ? this.readMicros : this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i == 5) {
            int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (i4 != 3) {
                return i4;
            }
            int i5 = initRecordTimeStamp == 0 ? this.NetworkUserEntityData$$ExternalSyntheticLambda4 : this.readMicros;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i == 8388611) {
            int i6 = this.readMicros;
            if (i6 != 3) {
                return i6;
            }
            int i7 = initRecordTimeStamp == 0 ? this.NetworkUserEntityData$$ExternalSyntheticLambda5 : this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i == 8388613) {
            int i8 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (i8 != 3) {
                return i8;
            }
            int i9 = initRecordTimeStamp == 0 ? this.NetworkUserEntityData$$ExternalSyntheticLambda3 : this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        } else {
            return 0;
        }
    }

    public int getDrawerLockMode(View view) {
        if (!isDrawerView(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a drawer");
            throw new IllegalArgumentException(sb.toString());
        }
        return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).MyBillsEntityDataFactory);
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(i, ViewCompat.initRecordTimeStamp(this));
        if (BuiltInFictitiousFunctionClassFactory2 == 3) {
            this.H = charSequence;
        } else if (BuiltInFictitiousFunctionClassFactory2 == 5) {
            this.G = charSequence;
        }
    }

    public CharSequence getDrawerTitle(int i) {
        int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(i, ViewCompat.initRecordTimeStamp(this));
        if (BuiltInFictitiousFunctionClassFactory2 == 3) {
            return this.H;
        }
        if (BuiltInFictitiousFunctionClassFactory2 == 5) {
            return this.G;
        }
        return null;
    }

    private boolean getAuthRequestContext(float f, float f2, View view) {
        if (this.lookAheadTest == null) {
            this.lookAheadTest = new Rect();
        }
        view.getHitRect(this.lookAheadTest);
        return this.lookAheadTest.contains((int) f, (int) f2);
    }

    private boolean MyBillsEntityDataFactory(MotionEvent motionEvent, View view) {
        if (view.getMatrix().isIdentity()) {
            float scrollX = getScrollX() - view.getLeft();
            float scrollY = getScrollY() - view.getTop();
            motionEvent.offsetLocation(scrollX, scrollY);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            return dispatchGenericMotionEvent;
        }
        float scrollX2 = getScrollX() - view.getLeft();
        float scrollY2 = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX2, scrollY2);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.getErrorConfigVersion == null) {
                this.getErrorConfigVersion = new Matrix();
            }
            matrix.invert(this.getErrorConfigVersion);
            obtain.transform(this.getErrorConfigVersion);
        }
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(obtain);
        obtain.recycle();
        return dispatchGenericMotionEvent2;
    }

    void updateDrawerState(int i, View view) {
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.PlaceComponentResult;
        int i3 = this.getCallingPid.PlaceComponentResult;
        int i4 = 2;
        if (i2 == 1 || i3 == 1) {
            i4 = 1;
        } else if (i2 != 2 && i3 != 2) {
            i4 = 0;
        }
        if (view != null && i == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.getAuthRequestContext == 0.0f) {
                dispatchOnDrawerClosed(view);
            } else if (layoutParams.getAuthRequestContext == 1.0f) {
                dispatchOnDrawerOpened(view);
            }
        }
        if (i4 != this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i4;
            List<DrawerListener> list = this.FragmentBottomSheetPaymentSettingBinding;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.FragmentBottomSheetPaymentSettingBinding.get(size);
                }
            }
        }
    }

    void dispatchOnDrawerClosed(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.PlaceComponentResult & 1) == 1) {
            layoutParams.PlaceComponentResult = 0;
            List<DrawerListener> list = this.FragmentBottomSheetPaymentSettingBinding;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.FragmentBottomSheetPaymentSettingBinding.get(size).MyBillsEntityDataFactory();
                }
            }
            MyBillsEntityDataFactory(view, false);
            PlaceComponentResult(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void dispatchOnDrawerOpened(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.PlaceComponentResult & 1) == 0) {
            layoutParams.PlaceComponentResult = 1;
            List<DrawerListener> list = this.FragmentBottomSheetPaymentSettingBinding;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.FragmentBottomSheetPaymentSettingBinding.get(size).getAuthRequestContext();
                }
            }
            MyBillsEntityDataFactory(view, true);
            PlaceComponentResult(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void MyBillsEntityDataFactory(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !isDrawerView(childAt)) || (z && childAt == view)) {
                ViewCompat.moveToNextValue(childAt, 1);
            } else {
                ViewCompat.moveToNextValue(childAt, 4);
            }
        }
    }

    private void PlaceComponentResult(View view) {
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.getErrorConfigVersion.MyBillsEntityDataFactory());
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        ViewCompat.PlaceComponentResult(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.getErrorConfigVersion, null, this.moveToNextValue);
    }

    void dispatchOnDrawerSlide(View view, float f) {
        List<DrawerListener> list = this.FragmentBottomSheetPaymentSettingBinding;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.FragmentBottomSheetPaymentSettingBinding.get(size).BuiltInFictitiousFunctionClassFactory(f);
            }
        }
    }

    void setDrawerViewOffset(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f == layoutParams.getAuthRequestContext) {
            return;
        }
        layoutParams.getAuthRequestContext = f;
        dispatchOnDrawerSlide(view, f);
    }

    float getDrawerViewOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).getAuthRequestContext;
    }

    int getDrawerViewAbsoluteGravity(View view) {
        return GravityCompat.BuiltInFictitiousFunctionClassFactory(((LayoutParams) view.getLayoutParams()).MyBillsEntityDataFactory, ViewCompat.initRecordTimeStamp(this));
    }

    boolean checkDrawerViewAbsoluteGravity(View view, int i) {
        return (getDrawerViewAbsoluteGravity(view) & i) == i;
    }

    View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).PlaceComponentResult & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void moveDrawerToOffset(View view, float f) {
        float drawerViewOffset = getDrawerViewOffset(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        setDrawerViewOffset(view, f);
    }

    View findDrawerWithGravity(int i) {
        int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(i, ViewCompat.initRecordTimeStamp(this));
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == (BuiltInFictitiousFunctionClassFactory2 & 7)) {
                return childAt;
            }
        }
        return null;
    }

    static String gravityToString(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null && ViewCompat.DatabaseTableConfigUtil(this);
        int initRecordTimeStamp = ViewCompat.initRecordTimeStamp(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(layoutParams.MyBillsEntityDataFactory, initRecordTimeStamp);
                    if (ViewCompat.DatabaseTableConfigUtil(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                            if (BuiltInFictitiousFunctionClassFactory2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (BuiltInFictitiousFunctionClassFactory2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        if (BuiltInFictitiousFunctionClassFactory2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (BuiltInFictitiousFunctionClassFactory2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (isDrawerView(childAt)) {
                    if (KClassImpl$Data$declaredNonStaticMembers$2) {
                        float errorConfigVersion = ViewCompat.getErrorConfigVersion(childAt);
                        float f = this.GetContactSyncConfig;
                        if (errorConfigVersion != f) {
                            ViewCompat.MyBillsEntityDataFactory(childAt, f);
                        }
                    }
                    int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                    boolean z4 = drawerViewAbsoluteGravity == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Child drawer has absolute gravity ");
                        sb.append(gravityToString(drawerViewAbsoluteGravity));
                        sb.append(" but this ");
                        sb.append("DrawerLayout");
                        sb.append(" already has a drawer view along that edge");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(getChildMeasureSpec(i, this.getSupportButtonTintMode + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    i4++;
                    i3 = 0;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Child ");
                    sb2.append(childAt);
                    sb2.append(" at index ");
                    sb2.append(i4);
                    sb2.append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            i4++;
            i3 = 0;
        }
    }

    private void PlaceComponentResult() {
        Drawable drawable;
        Drawable drawable2;
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        int initRecordTimeStamp = ViewCompat.initRecordTimeStamp(this);
        if (initRecordTimeStamp == 0) {
            Drawable drawable3 = this.D;
            if (drawable3 != null) {
                if (drawable3 != null && DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(drawable3)) {
                    DrawableCompat.getAuthRequestContext(drawable3, initRecordTimeStamp);
                }
                drawable = this.D;
            }
            drawable = this.B;
        } else {
            Drawable drawable4 = this.A;
            if (drawable4 != null) {
                if (drawable4 != null && DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(drawable4)) {
                    DrawableCompat.getAuthRequestContext(drawable4, initRecordTimeStamp);
                }
                drawable = this.A;
            }
            drawable = this.B;
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = drawable;
        int initRecordTimeStamp2 = ViewCompat.initRecordTimeStamp(this);
        if (initRecordTimeStamp2 == 0) {
            Drawable drawable5 = this.A;
            if (drawable5 != null) {
                if (drawable5 != null && DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(drawable5)) {
                    DrawableCompat.getAuthRequestContext(drawable5, initRecordTimeStamp2);
                }
                drawable2 = this.A;
            }
            drawable2 = this.getValueOfTouchPositionAbsolute;
        } else {
            Drawable drawable6 = this.D;
            if (drawable6 != null) {
                if (drawable6 != null && DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(drawable6)) {
                    DrawableCompat.getAuthRequestContext(drawable6, initRecordTimeStamp2);
                }
                drawable2 = this.D;
            }
            drawable2 = this.getValueOfTouchPositionAbsolute;
        }
        this.E = drawable2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f;
        int i5;
        this.DatabaseTableConfigUtil = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.getAuthRequestContext * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i6 - r11) / f3;
                        i5 = i6 - ((int) (layoutParams.getAuthRequestContext * f3));
                    }
                    boolean z2 = f != layoutParams.getAuthRequestContext;
                    int i8 = layoutParams.MyBillsEntityDataFactory & 112;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < layoutParams.topMargin) {
                            i10 = layoutParams.topMargin;
                        } else if (i10 + measuredHeight > i9 - layoutParams.bottomMargin) {
                            i10 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i10, measuredWidth + i5, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i11 = i4 - i2;
                        childAt.layout(i5, (i11 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i11 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        setDrawerViewOffset(childAt, f);
                    }
                    int i12 = layoutParams.getAuthRequestContext > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
        }
        if (MyBillsEntityDataFactory && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets scheduleImpl = WindowInsetsCompat.PlaceComponentResult(rootWindowInsets).scheduleImpl();
            ViewDragHelper viewDragHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            viewDragHelper.getAuthRequestContext = Math.max(viewDragHelper.KClassImpl$Data$declaredNonStaticMembers$2, scheduleImpl.PlaceComponentResult);
            ViewDragHelper viewDragHelper2 = this.getCallingPid;
            viewDragHelper2.getAuthRequestContext = Math.max(viewDragHelper2.KClassImpl$Data$declaredNonStaticMembers$2, scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        this.DatabaseTableConfigUtil = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.DatabaseTableConfigUtil) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).getAuthRequestContext);
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = f;
        boolean KClassImpl$Data$declaredNonStaticMembers$22 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2();
        boolean KClassImpl$Data$declaredNonStaticMembers$23 = this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$22 || KClassImpl$Data$declaredNonStaticMembers$23) {
            ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(this);
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.getOnBoardingScenario = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.getOnBoardingScenario;
    }

    public void setStatusBarBackground(int i) {
        this.getOnBoardingScenario = i != 0 ? ContextCompat.PlaceComponentResult(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.getOnBoardingScenario = new ColorDrawable(i);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        PlaceComponentResult();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.initRecordTimeStamp || this.getOnBoardingScenario == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.NetworkUserEntityData$$ExternalSyntheticLambda7) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.getOnBoardingScenario.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.getOnBoardingScenario.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean isContentView = isContentView(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (isContentView) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && KClassImpl$Data$declaredNonStaticMembers$2(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean fsSuperDrawChild_c13e2a28b18b31a4d162bb1cddaa459b = fsSuperDrawChild_c13e2a28b18b31a4d162bb1cddaa459b(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (f > 0.0f && isContentView) {
            this.BottomSheetCardBindingView$watcherCardNumberView$1.setColor((this.C & FlexItem.MAX_SIZE) | (((int) ((((-16777216) & r2) >>> 24) * f)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.BottomSheetCardBindingView$watcherCardNumberView$1);
        } else if (this.VerifyPinStateManager$executeRiskChallenge$2$2 != null && checkDrawerViewAbsoluteGravity(view, 3)) {
            int intrinsicWidth = this.VerifyPinStateManager$executeRiskChallenge$2$2.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext, 1.0f));
            this.VerifyPinStateManager$executeRiskChallenge$2$2.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.VerifyPinStateManager$executeRiskChallenge$2$2.setAlpha((int) (max * 255.0f));
            this.VerifyPinStateManager$executeRiskChallenge$2$2.draw(canvas);
        } else if (this.E != null && checkDrawerViewAbsoluteGravity(view, 5)) {
            int intrinsicWidth2 = this.E.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.getCallingPid.getAuthRequestContext, 1.0f));
            this.E.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.E.setAlpha((int) (max2 * 255.0f));
            this.E.draw(canvas);
        }
        return fsSuperDrawChild_c13e2a28b18b31a4d162bb1cddaa459b;
    }

    boolean isContentView(View view) {
        return ((LayoutParams) view.getLayoutParams()).MyBillsEntityDataFactory == 0;
    }

    boolean isDrawerView(View view) {
        int BuiltInFictitiousFunctionClassFactory2 = GravityCompat.BuiltInFictitiousFunctionClassFactory(((LayoutParams) view.getLayoutParams()).MyBillsEntityDataFactory, ViewCompat.initRecordTimeStamp(view));
        return ((BuiltInFictitiousFunctionClassFactory2 & 3) == 0 && (BuiltInFictitiousFunctionClassFactory2 & 5) == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r0 != 3) goto L14;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r7.NetworkUserEntityData$$ExternalSyntheticLambda8
            boolean r1 = r1.MyBillsEntityDataFactory(r8)
            androidx.customview.widget.ViewDragHelper r2 = r7.getCallingPid
            boolean r2 = r2.MyBillsEntityDataFactory(r8)
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L3f
            if (r0 == r4) goto L38
            r8 = 2
            if (r0 == r8) goto L1d
            r8 = 3
            if (r0 == r8) goto L38
            goto L3d
        L1d:
            androidx.customview.widget.ViewDragHelper r8 = r7.NetworkUserEntityData$$ExternalSyntheticLambda8
            boolean r8 = r8.BuiltInFictitiousFunctionClassFactory()
            if (r8 == 0) goto L3d
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r8 = r7.newProxyInstance
            androidx.drawerlayout.widget.DrawerLayout r0 = androidx.drawerlayout.widget.DrawerLayout.this
            java.lang.Runnable r8 = r8.PlaceComponentResult
            r0.removeCallbacks(r8)
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r8 = r7.SubSequence
            androidx.drawerlayout.widget.DrawerLayout r0 = androidx.drawerlayout.widget.DrawerLayout.this
            java.lang.Runnable r8 = r8.PlaceComponentResult
            r0.removeCallbacks(r8)
            goto L3d
        L38:
            r7.closeDrawers(r4)
            r7.scheduleImpl = r3
        L3d:
            r8 = 0
            goto L67
        L3f:
            float r0 = r8.getX()
            float r8 = r8.getY()
            r7.isLayoutRequested = r0
            r7.PrepareContext = r8
            float r5 = r7.VerifyPinStateManager$executeRiskChallenge$2$1
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L64
            androidx.customview.widget.ViewDragHelper r5 = r7.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = (int) r0
            int r8 = (int) r8
            android.view.View r8 = r5.BuiltInFictitiousFunctionClassFactory(r0, r8)
            if (r8 == 0) goto L64
            boolean r8 = r7.isContentView(r8)
            if (r8 == 0) goto L64
            r8 = 1
            goto L65
        L64:
            r8 = 0
        L65:
            r7.scheduleImpl = r3
        L67:
            r0 = r1 | r2
            if (r0 != 0) goto L77
            if (r8 != 0) goto L77
            boolean r8 = r7.BuiltInFictitiousFunctionClassFactory()
            if (r8 != 0) goto L77
            boolean r8 = r7.scheduleImpl
            if (r8 == 0) goto L78
        L77:
            r3 = 1
        L78:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.VerifyPinStateManager$executeRiskChallenge$2$1 <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return false;
            }
            View childAt = getChildAt(childCount);
            if (getAuthRequestContext(x, y, childAt) && !isContentView(childAt) && MyBillsEntityDataFactory(motionEvent, childAt)) {
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        if (getDrawerLockMode(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda8
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.getCallingPid
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L1f
            r7 = 3
            if (r0 != r7) goto L6d
            r6.closeDrawers(r2)
            r6.scheduleImpl = r1
            goto L6d
        L1f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.BuiltInFictitiousFunctionClassFactory(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.isContentView(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.isLayoutRequested
            float r0 = r0 - r3
            float r3 = r6.PrepareContext
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r3 = r3.lookAheadTest
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.findOpenDrawer()
            if (r7 == 0) goto L5a
            int r7 = r6.getDrawerLockMode(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = 1
        L5b:
            r6.closeDrawers(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.isLayoutRequested = r0
            r6.PrepareContext = r7
            r6.scheduleImpl = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            closeDrawers(true);
        }
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    void closeDrawers(boolean z) {
        boolean KClassImpl$Data$declaredNonStaticMembers$22;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z || layoutParams.BuiltInFictitiousFunctionClassFactory)) {
                int width = childAt.getWidth();
                if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                    KClassImpl$Data$declaredNonStaticMembers$22 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(childAt, -width, childAt.getTop());
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$22 = this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2(childAt, getWidth(), childAt.getTop());
                }
                z2 |= KClassImpl$Data$declaredNonStaticMembers$22;
                layoutParams.BuiltInFictitiousFunctionClassFactory = false;
            }
        }
        ViewDragCallback viewDragCallback = this.newProxyInstance;
        DrawerLayout.this.removeCallbacks(viewDragCallback.PlaceComponentResult);
        ViewDragCallback viewDragCallback2 = this.SubSequence;
        DrawerLayout.this.removeCallbacks(viewDragCallback2.PlaceComponentResult);
        if (z2) {
            invalidate();
        }
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        openDrawer(8388611);
    }

    public void openDrawer(View view) {
        openDrawer(view, true);
    }

    public void openDrawer(View view, boolean z) {
        if (!isDrawerView(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a sliding drawer");
            throw new IllegalArgumentException(sb.toString());
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            layoutParams.getAuthRequestContext = 1.0f;
            layoutParams.PlaceComponentResult = 1;
            MyBillsEntityDataFactory(view, true);
            PlaceComponentResult(view);
        } else if (z) {
            layoutParams.PlaceComponentResult |= 2;
            if (checkDrawerViewAbsoluteGravity(view, 3)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(view, 0, view.getTop());
            } else {
                this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            moveDrawerToOffset(view, 1.0f);
            updateDrawerState(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No drawer view found with gravity ");
            sb.append(gravityToString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        openDrawer(findDrawerWithGravity, z);
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        closeDrawer(8388611);
    }

    public void closeDrawer(View view) {
        closeDrawer(view, true);
    }

    public void closeDrawer(View view, boolean z) {
        if (!isDrawerView(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a sliding drawer");
            throw new IllegalArgumentException(sb.toString());
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            layoutParams.getAuthRequestContext = 0.0f;
            layoutParams.PlaceComponentResult = 0;
        } else if (z) {
            layoutParams.PlaceComponentResult |= 4;
            if (checkDrawerViewAbsoluteGravity(view, 3)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(view, -view.getWidth(), view.getTop());
            } else {
                this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2(view, getWidth(), view.getTop());
            }
        } else {
            moveDrawerToOffset(view, 0.0f);
            updateDrawerState(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No drawer view found with gravity ");
            sb.append(gravityToString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        closeDrawer(findDrawerWithGravity, z);
    }

    public boolean isDrawerOpen(View view) {
        if (isDrawerView(view)) {
            return (((LayoutParams) view.getLayoutParams()).PlaceComponentResult & 1) == 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isOpen() {
        return isDrawerOpen(8388611);
    }

    public boolean isDrawerOpen(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerOpen(findDrawerWithGravity);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        if (isDrawerView(view)) {
            return ((LayoutParams) view.getLayoutParams()).getAuthRequestContext > 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isDrawerVisible(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerVisible(findDrawerWithGravity);
        }
        return false;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).BuiltInFictitiousFunctionClassFactory) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (isDrawerView(childAt)) {
                if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            } else {
                this.whenAvailable.add(childAt);
            }
        }
        if (!z) {
            int size = this.whenAvailable.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.whenAvailable.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.whenAvailable.clear();
    }

    private boolean MyBillsEntityDataFactory() {
        return findVisibleDrawer() != null;
    }

    View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void cancelChildViewTouch() {
        if (this.scheduleImpl) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.scheduleImpl = true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && MyBillsEntityDataFactory()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View findVisibleDrawer = findVisibleDrawer();
            if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
                closeDrawers();
            }
            return findVisibleDrawer != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View findDrawerWithGravity;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.KClassImpl$Data$declaredNonStaticMembers$2 != 0 && (findDrawerWithGravity = findDrawerWithGravity(savedState.KClassImpl$Data$declaredNonStaticMembers$2)) != null) {
            openDrawer(findDrawerWithGravity);
        }
        if (savedState.PlaceComponentResult != 3) {
            setDrawerLockMode(savedState.PlaceComponentResult, 3);
        }
        if (savedState.MyBillsEntityDataFactory != 3) {
            setDrawerLockMode(savedState.MyBillsEntityDataFactory, 5);
        }
        if (savedState.BuiltInFictitiousFunctionClassFactory != 3) {
            setDrawerLockMode(savedState.BuiltInFictitiousFunctionClassFactory, 8388611);
        }
        if (savedState.getAuthRequestContext != 3) {
            setDrawerLockMode(savedState.getAuthRequestContext, 8388613);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = layoutParams.PlaceComponentResult == 1;
            boolean z2 = layoutParams.PlaceComponentResult == 2;
            if (z || z2) {
                savedState.KClassImpl$Data$declaredNonStaticMembers$2 = layoutParams.MyBillsEntityDataFactory;
                break;
            }
        }
        savedState.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        savedState.MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        savedState.BuiltInFictitiousFunctionClassFactory = this.readMicros;
        savedState.getAuthRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (findOpenDrawer() != null || isDrawerView(view)) {
            ViewCompat.moveToNextValue(view, 4);
        } else {
            ViewCompat.moveToNextValue(view, 1);
        }
        if (CAN_HIDE_DESCENDANTS) {
            return;
        }
        ViewCompat.MyBillsEntityDataFactory(view, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    static boolean includeChildForAccessibility(View view) {
        return (ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(view) == 4 || ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda1(view) == 2) ? false : true;
    }

    /* loaded from: classes6.dex */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        int getAuthRequestContext;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
            this.PlaceComponentResult = parcel.readInt();
            this.MyBillsEntityDataFactory = parcel.readInt();
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
            this.getAuthRequestContext = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
            parcel.writeInt(this.PlaceComponentResult);
            parcel.writeInt(this.MyBillsEntityDataFactory);
            parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
            parcel.writeInt(this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ViewDragCallback extends ViewDragHelper.Callback {
        final int BuiltInFictitiousFunctionClassFactory;
        final Runnable PlaceComponentResult = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                View findDrawerWithGravity;
                int width;
                ViewDragCallback viewDragCallback = ViewDragCallback.this;
                int i = viewDragCallback.getAuthRequestContext.getAuthRequestContext;
                boolean z = viewDragCallback.BuiltInFictitiousFunctionClassFactory == 3;
                if (z) {
                    findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
                    width = (findDrawerWithGravity != null ? -findDrawerWithGravity.getWidth() : 0) + i;
                } else {
                    findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
                    width = DrawerLayout.this.getWidth() - i;
                }
                if (findDrawerWithGravity != null) {
                    if (((!z || findDrawerWithGravity.getLeft() >= width) && (z || findDrawerWithGravity.getLeft() <= width)) || DrawerLayout.this.getDrawerLockMode(findDrawerWithGravity) != 0) {
                        return;
                    }
                    LayoutParams layoutParams = (LayoutParams) findDrawerWithGravity.getLayoutParams();
                    viewDragCallback.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(findDrawerWithGravity, width, findDrawerWithGravity.getTop());
                    layoutParams.BuiltInFictitiousFunctionClassFactory = true;
                    DrawerLayout.this.invalidate();
                    viewDragCallback.PlaceComponentResult();
                    DrawerLayout.this.cancelChildViewTouch();
                }
            }
        };
        ViewDragHelper getAuthRequestContext;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int i) {
            return false;
        }

        ViewDragCallback(int i) {
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.isDrawerView(view) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, this.BuiltInFictitiousFunctionClassFactory) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.updateDrawerState(i, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3) ? i + r3 : DrawerLayout.this.getWidth() - i) / view.getWidth();
            DrawerLayout.this.setDrawerViewOffset(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).BuiltInFictitiousFunctionClassFactory = false;
            PlaceComponentResult();
        }

        final void PlaceComponentResult() {
            View findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(this.BuiltInFictitiousFunctionClassFactory == 3 ? 5 : 3);
            if (findDrawerWithGravity != null) {
                DrawerLayout.this.closeDrawer(findDrawerWithGravity);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            float drawerViewOffset = DrawerLayout.this.getDrawerViewOffset(view);
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                i = (f < 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) ? width2 - width : width2;
            }
            this.getAuthRequestContext.getAuthRequestContext(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.PlaceComponentResult, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            View findDrawerWithGravity;
            if ((i & 1) == 1) {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
            } else {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
            }
            if (findDrawerWithGravity == null || DrawerLayout.this.getDrawerLockMode(findDrawerWithGravity) != 0) {
                return;
            }
            this.getAuthRequestContext.getAuthRequestContext(findDrawerWithGravity, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.isDrawerView(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }
    }

    /* loaded from: classes6.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        boolean BuiltInFictitiousFunctionClassFactory;
        public int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        float getAuthRequestContext;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.MyBillsEntityDataFactory = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
            this.MyBillsEntityDataFactory = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.MyBillsEntityDataFactory = 0;
            this.MyBillsEntityDataFactory = layoutParams.MyBillsEntityDataFactory;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.MyBillsEntityDataFactory = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.MyBillsEntityDataFactory = 0;
        }
    }

    /* loaded from: classes6.dex */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect PlaceComponentResult = new Rect();

        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat MyBillsEntityDataFactory;
            if (!DrawerLayout.CAN_HIDE_DESCENDANTS) {
                MyBillsEntityDataFactory = AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.MyBillsEntityDataFactory));
                super.onInitializeAccessibilityNodeInfo(view, MyBillsEntityDataFactory);
                accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(view);
                ViewParent FragmentBottomSheetPaymentSettingBinding = ViewCompat.FragmentBottomSheetPaymentSettingBinding(view);
                if (FragmentBottomSheetPaymentSettingBinding instanceof View) {
                    accessibilityNodeInfoCompat.PlaceComponentResult((View) FragmentBottomSheetPaymentSettingBinding);
                }
                Rect rect = this.PlaceComponentResult;
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(rect);
                accessibilityNodeInfoCompat.MyBillsEntityDataFactory(rect);
                accessibilityNodeInfoCompat.PrepareContext(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4());
                accessibilityNodeInfoCompat.scheduleImpl(MyBillsEntityDataFactory.moveToNextValue());
                accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.getAuthRequestContext());
                accessibilityNodeInfoCompat.PlaceComponentResult(MyBillsEntityDataFactory.scheduleImpl());
                accessibilityNodeInfoCompat.moveToNextValue(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8());
                accessibilityNodeInfoCompat.scheduleImpl(MyBillsEntityDataFactory.PrepareContext());
                accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.GetContactSyncConfig());
                accessibilityNodeInfoCompat.GetContactSyncConfig(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5());
                accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult());
                MyBillsEntityDataFactory.whenAvailable();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.includeChildForAccessibility(childAt)) {
                        accessibilityNodeInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(childAt);
                    }
                }
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            }
            accessibilityNodeInfoCompat.BuiltInFictitiousFunctionClassFactory("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(false);
            accessibilityNodeInfoCompat.scheduleImpl(false);
            accessibilityNodeInfoCompat.getAuthRequestContext(AccessibilityNodeInfoCompat.AccessibilityActionCompat.NetworkUserEntityData$$ExternalSyntheticLambda1);
            accessibilityNodeInfoCompat.getAuthRequestContext(AccessibilityNodeInfoCompat.AccessibilityActionCompat.getAuthRequestContext);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View findVisibleDrawer = DrawerLayout.this.findVisibleDrawer();
                if (findVisibleDrawer != null) {
                    CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(findVisibleDrawer));
                    if (drawerTitle != null) {
                        text.add(drawerTitle);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.includeChildForAccessibility(view)) {
                return;
            }
            accessibilityNodeInfoCompat.PlaceComponentResult((View) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:15:0x0042). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = androidx.drawerlayout.widget.DrawerLayout.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 4
            r4 = 97
            r5 = 0
            if (r0 != 0) goto L15
            r4 = r2
            r6 = 4
            r7 = 0
            r8 = 97
            r2 = r0
            r0 = r11
            r11 = r10
            goto L42
        L15:
            r3 = r2
            r6 = 4
            r7 = 0
            r2 = r0
            r0 = r11
            r11 = r10
        L1b:
            byte r8 = (byte) r4
            r3[r7] = r8
            int r7 = r7 + 1
            if (r7 != r1) goto L3d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r5)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L38
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L38:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L3d:
            r8 = r2[r6]
            r9 = r4
            r4 = r3
            r3 = r9
        L42:
            int r8 = -r8
            int r3 = r3 + r8
            int r3 = r3 + (-8)
            int r6 = r6 + 1
            r9 = r4
            r4 = r3
            r3 = r9
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
