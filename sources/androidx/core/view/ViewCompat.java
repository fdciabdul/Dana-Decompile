package androidx.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ViewCompat {
    private static Method BuiltInFictitiousFunctionClassFactory;
    private static ThreadLocal<Rect> DatabaseTableConfigUtil;
    private static WeakHashMap<View, String> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static boolean getErrorConfigVersion;
    private static Field lookAheadTest;
    private static Field moveToNextValue;
    private static boolean scheduleImpl;
    private static final AtomicInteger NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicInteger(1);
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> initRecordTimeStamp = null;
    private static boolean PlaceComponentResult = false;
    private static final int[] getAuthRequestContext = {R.id.getAuthRequestContext, R.id.BuiltInFictitiousFunctionClassFactory, R.id.NetworkUserEntityData$$ExternalSyntheticLambda1, R.id.NetworkUserEntityData$$ExternalSyntheticLambda3, R.id.getCallingPid, R.id.SubSequence, R.id.getSupportButtonTintMode, R.id.B, R.id.C, R.id.BottomSheetCardBindingView$watcherCardNumberView$1, R.id.MyBillsEntityDataFactory, R.id.KClassImpl$Data$declaredNonStaticMembers$2, R.id.NetworkUserEntityData$$ExternalSyntheticLambda0, R.id.moveToNextValue, R.id.getErrorConfigVersion, R.id.lookAheadTest, R.id.scheduleImpl, R.id.DatabaseTableConfigUtil, R.id.initRecordTimeStamp, R.id.NetworkUserEntityData$$ExternalSyntheticLambda2, R.id.GetContactSyncConfig, R.id.isLayoutRequested, R.id.PrepareContext, R.id.NetworkUserEntityData$$ExternalSyntheticLambda7, R.id.newProxyInstance, R.id.NetworkUserEntityData$$ExternalSyntheticLambda8, R.id.NetworkUserEntityData$$ExternalSyntheticLambda4, R.id.NetworkUserEntityData$$ExternalSyntheticLambda5, R.id.FragmentBottomSheetPaymentSettingBinding, R.id.NetworkUserEntityData$$ExternalSyntheticLambda6, R.id.whenAvailable, R.id.readMicros};
    private static final OnReceiveContentViewBehavior KClassImpl$Data$declaredNonStaticMembers$2 = new OnReceiveContentViewBehavior() { // from class: androidx.core.view.ViewCompat$$ExternalSyntheticLambda0
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
            return ViewCompat.MyBillsEntityDataFactory(contentInfoCompat);
        }
    };
    private static final AccessibilityPaneVisibilityManager MyBillsEntityDataFactory = new AccessibilityPaneVisibilityManager();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NestedScrollType {
    }

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean BuiltInFictitiousFunctionClassFactory(View view, KeyEvent keyEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollIndicators {
    }

    public static /* synthetic */ ContentInfoCompat MyBillsEntityDataFactory(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    private static Rect getAuthRequestContext() {
        if (DatabaseTableConfigUtil == null) {
            DatabaseTableConfigUtil = new ThreadLocal<>();
        }
        Rect rect = DatabaseTableConfigUtil.get();
        if (rect == null) {
            rect = new Rect();
            DatabaseTableConfigUtil.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void MyBillsEntityDataFactory(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.PlaceComponentResult(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    @Deprecated
    public static boolean getAuthRequestContext(View view, int i) {
        return view.canScrollVertically(i);
    }

    @Deprecated
    public static int isLayoutRequested(View view) {
        return view.getOverScrollMode();
    }

    @Deprecated
    public static void getErrorConfigVersion(View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void PlaceComponentResult(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.getSupportButtonTintMode());
    }

    public static void MyBillsEntityDataFactory(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (InstrumentInjector.getAccessibilityDelegate(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        InstrumentInjector.setAccessibilityDelegate(view, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    public static int NetworkUserEntityData$$ExternalSyntheticLambda2(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.PlaceComponentResult(view);
        }
        return 0;
    }

    public static void scheduleImpl(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static AccessibilityDelegateCompat PlaceComponentResult(View view) {
        View.AccessibilityDelegate accessibilityDelegate = InstrumentInjector.getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            return null;
        }
        if (accessibilityDelegate instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegate).BuiltInFictitiousFunctionClassFactory;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegate);
    }

    static void getAuthRequestContext(View view) {
        AccessibilityDelegateCompat PlaceComponentResult2 = PlaceComponentResult(view);
        if (PlaceComponentResult2 == null) {
            PlaceComponentResult2 = new AccessibilityDelegateCompat();
        }
        MyBillsEntityDataFactory(view, PlaceComponentResult2);
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getErrorConfigVersion(view);
        }
        return false;
    }

    public static void PlaceComponentResult(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.BuiltInFictitiousFunctionClassFactory(view, z);
        }
    }

    public static void VerifyPinStateManager$executeRiskChallenge$2$2(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.moveToNextValue(view);
        } else {
            view.postInvalidate();
        }
    }

    public static void MyBillsEntityDataFactory(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.getAuthRequestContext(view, i, i2, i3, i4);
        } else {
            view.postInvalidate(i, i2, i3, i4);
        }
    }

    public static void PlaceComponentResult(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.BuiltInFictitiousFunctionClassFactory(view, runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void PlaceComponentResult(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.MyBillsEntityDataFactory(view, runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static int NetworkUserEntityData$$ExternalSyntheticLambda1(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.PlaceComponentResult(view);
        }
        return 0;
    }

    public static void moveToNextValue(View view, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT >= 16) {
                if (i == 4) {
                    i = 2;
                }
                view.setImportantForAccessibility(i);
                return;
            }
            return;
        }
        view.setImportantForAccessibility(i);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(view, charSequence);
        if (KClassImpl$Data$declaredNonStaticMembers$22 != -1) {
            BuiltInFictitiousFunctionClassFactory(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(KClassImpl$Data$declaredNonStaticMembers$22, charSequence, accessibilityViewCommand));
        }
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(View view, CharSequence charSequence) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> H = H(view);
        for (int i = 0; i < H.size(); i++) {
            if (TextUtils.equals(charSequence, H.get(i).PlaceComponentResult())) {
                return H.get(i).MyBillsEntityDataFactory();
            }
        }
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int[] iArr = getAuthRequestContext;
            if (i2 >= iArr.length || i3 != -1) {
                break;
            }
            int i4 = iArr[i2];
            boolean z = true;
            for (int i5 = 0; i5 < H.size(); i5++) {
                z &= H.get(i5).MyBillsEntityDataFactory() != i4;
            }
            if (z) {
                i3 = i4;
            }
            i2++;
        }
        return i3;
    }

    public static void PlaceComponentResult(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            KClassImpl$Data$declaredNonStaticMembers$2(view, accessibilityActionCompat.MyBillsEntityDataFactory());
        } else {
            BuiltInFictitiousFunctionClassFactory(view, accessibilityActionCompat.MyBillsEntityDataFactory(charSequence, accessibilityViewCommand));
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            getAuthRequestContext(view);
            KClassImpl$Data$declaredNonStaticMembers$2(accessibilityActionCompat.MyBillsEntityDataFactory(), view);
            H(view).add(accessibilityActionCompat);
            MyBillsEntityDataFactory(view, 0);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            KClassImpl$Data$declaredNonStaticMembers$2(i, view);
            MyBillsEntityDataFactory(view, 0);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(int i, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> H = H(view);
        for (int i2 = 0; i2 < H.size(); i2++) {
            if (H.get(i2).MyBillsEntityDataFactory() == i) {
                H.remove(i2);
                return;
            }
        }
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> H(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.getNameOrBuilderList);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.getNameOrBuilderList, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void getAuthRequestContext(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            moveToNextValue().PlaceComponentResult(view, charSequence);
        }
    }

    public static void PlaceComponentResult(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.getAuthRequestContext(view, paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static int initRecordTimeStamp(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.PlaceComponentResult(view);
        }
        return 0;
    }

    public static ViewParent FragmentBottomSheetPaymentSettingBinding(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.MyBillsEntityDataFactory(view);
        }
        return view.getParent();
    }

    @Deprecated
    public static int newProxyInstance(View view) {
        return view.getMeasuredWidthAndState();
    }

    @Deprecated
    public static int GetContactSyncConfig(View view) {
        return view.getMeasuredHeightAndState();
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.getAuthRequestContext(view);
        }
        return 0;
    }

    public static void lookAheadTest(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.PlaceComponentResult(view, i);
        }
    }

    public static int NetworkUserEntityData$$ExternalSyntheticLambda4(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.MyBillsEntityDataFactory(view);
        }
        return view.getPaddingLeft();
    }

    public static int NetworkUserEntityData$$ExternalSyntheticLambda6(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.BuiltInFictitiousFunctionClassFactory(view);
        }
        return view.getPaddingRight();
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.PlaceComponentResult(view, i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public static int NetworkUserEntityData$$ExternalSyntheticLambda7(View view) {
        if (Build.VERSION.SDK_INT < 16) {
            if (!scheduleImpl) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinWidth");
                    lookAheadTest = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                scheduleImpl = true;
            }
            Field field = lookAheadTest;
            if (field != null) {
                try {
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }
        return view.getMinimumWidth();
    }

    public static int PrepareContext(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getAuthRequestContext(view);
        }
        if (!getErrorConfigVersion) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                moveToNextValue = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            getErrorConfigVersion = true;
        }
        Field field = moveToNextValue;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static ViewPropertyAnimatorCompat MyBillsEntityDataFactory(View view) {
        if (initRecordTimeStamp == null) {
            initRecordTimeStamp = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = initRecordTimeStamp.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            initRecordTimeStamp.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    @Deprecated
    public static void BuiltInFictitiousFunctionClassFactory(View view, float f) {
        view.setTranslationY(f);
    }

    @Deprecated
    public static void PlaceComponentResult(View view, float f) {
        view.setScaleY(f);
    }

    public static void MyBillsEntityDataFactory(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    public static float getErrorConfigVersion(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.MyBillsEntityDataFactory(view);
        }
        return 0.0f;
    }

    public static void getAuthRequestContext(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory(view, f);
        }
    }

    public static float readMicros(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void getAuthRequestContext(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory(view, str);
            return;
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            NetworkUserEntityData$$ExternalSyntheticLambda1 = new WeakHashMap<>();
        }
        NetworkUserEntityData$$ExternalSyntheticLambda1.put(view, str);
    }

    public static String getCallingPid(View view) {
        if (Build.VERSION.SDK_INT < 21) {
            WeakHashMap<View, String> weakHashMap = NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view);
        }
        return view.getTransitionName();
    }

    @Deprecated
    public static int whenAvailable(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void I(View view) {
        if (Build.VERSION.SDK_INT < 20) {
            if (Build.VERSION.SDK_INT >= 16) {
                Api16Impl.lookAheadTest(view);
                return;
            }
            return;
        }
        view.requestApplyInsets();
    }

    @Deprecated
    public static void PlaceComponentResult(ViewGroup viewGroup, boolean z) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            try {
                BuiltInFictitiousFunctionClassFactory = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                InstrumentInjector.log_e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            BuiltInFictitiousFunctionClassFactory.setAccessible(true);
        }
        try {
            BuiltInFictitiousFunctionClassFactory.invoke(viewGroup, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            InstrumentInjector.log_e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            InstrumentInjector.log_e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            InstrumentInjector.log_e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }

    public static boolean DatabaseTableConfigUtil(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.BuiltInFictitiousFunctionClassFactory(view);
        }
        return false;
    }

    @Deprecated
    public static void MyBillsEntityDataFactory(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void MyBillsEntityDataFactory(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(view, onApplyWindowInsetsListener);
        }
    }

    public static WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets NetworkUserEntityData$$ExternalSyntheticLambda12;
        if (Build.VERSION.SDK_INT >= 21 && (NetworkUserEntityData$$ExternalSyntheticLambda12 = windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda1()) != null) {
            WindowInsets authRequestContext = Api20Impl.getAuthRequestContext(view, NetworkUserEntityData$$ExternalSyntheticLambda12);
            if (!authRequestContext.equals(NetworkUserEntityData$$ExternalSyntheticLambda12)) {
                return WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, view);
            }
        }
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat PlaceComponentResult(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets NetworkUserEntityData$$ExternalSyntheticLambda12;
        if (Build.VERSION.SDK_INT >= 21 && (NetworkUserEntityData$$ExternalSyntheticLambda12 = windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda1()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(NetworkUserEntityData$$ExternalSyntheticLambda12);
            if (!dispatchApplyWindowInsets.equals(NetworkUserEntityData$$ExternalSyntheticLambda12)) {
                return WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(dispatchApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat NetworkUserEntityData$$ExternalSyntheticLambda3(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getAuthRequestContext(view);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getAuthRequestContext(view);
        }
        return null;
    }

    public static WindowInsetsCompat getAuthRequestContext(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? Api21Impl.PlaceComponentResult(view, windowInsetsCompat, rect) : windowInsetsCompat;
    }

    public static String[] NetworkUserEntityData$$ExternalSyntheticLambda8(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.PlaceComponentResult(view);
        }
        return (String[]) view.getTag(R.id.SummaryVoucherView$$ExternalSyntheticLambda0);
    }

    public static ContentInfoCompat getAuthRequestContext(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("performReceiveContent: ");
            sb.append(contentInfoCompat);
            sb.append(", view=");
            sb.append(view.getClass().getSimpleName());
            sb.append("[");
            sb.append(view.getId());
            sb.append("]");
            InstrumentInjector.log_d("ViewCompat", sb.toString());
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.KClassImpl$Data$declaredNonStaticMembers$2(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.Q);
        if (onReceiveContentListener != null) {
            ContentInfoCompat PlaceComponentResult2 = onReceiveContentListener.PlaceComponentResult(view, contentInfoCompat);
            if (PlaceComponentResult2 == null) {
                return null;
            }
            return G(view).onReceiveContent(PlaceComponentResult2);
        }
        return G(view).onReceiveContent(contentInfoCompat);
    }

    private static OnReceiveContentViewBehavior G(View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes.dex */
    public static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] PlaceComponentResult(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat KClassImpl$Data$declaredNonStaticMembers$2(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo KClassImpl$Data$declaredNonStaticMembers$2 = contentInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2();
            ContentInfo performReceiveContent = view.performReceiveContent(KClassImpl$Data$declaredNonStaticMembers$2);
            if (performReceiveContent == null) {
                return null;
            }
            return performReceiveContent == KClassImpl$Data$declaredNonStaticMembers$2 ? contentInfoCompat : ContentInfoCompat.getAuthRequestContext(performReceiveContent);
        }
    }

    /* loaded from: classes.dex */
    static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener getAuthRequestContext;

        @Override // android.view.OnReceiveContentListener
        public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat authRequestContext = ContentInfoCompat.getAuthRequestContext(contentInfo);
            ContentInfoCompat PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(view, authRequestContext);
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult == authRequestContext ? contentInfo : PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static boolean BottomSheetCardBindingView$watcherCardNumberView$1(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.scheduleImpl(view);
        }
        return true;
    }

    public static boolean D(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getAuthRequestContext(view);
        }
        return false;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static ColorStateList moveToNextValue(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.PlaceComponentResult(view);
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(view, colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (Api21Impl.PlaceComponentResult(view) == null && Api21Impl.BuiltInFictitiousFunctionClassFactory(view) == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode NetworkUserEntityData$$ExternalSyntheticLambda0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.BuiltInFictitiousFunctionClassFactory(view);
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void getAuthRequestContext(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.PlaceComponentResult(view, mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (Api21Impl.PlaceComponentResult(view) == null && Api21Impl.BuiltInFictitiousFunctionClassFactory(view) == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
                return;
            }
            return;
        }
        view.setNestedScrollingEnabled(z);
    }

    public static boolean getOnBoardingScenario(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.moveToNextValue(view);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void F(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getErrorConfigVersion(view);
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.getAuthRequestContext(view);
        }
        return false;
    }

    public static boolean getValueOfTouchPositionAbsolute(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float getSupportButtonTintMode(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.scheduleImpl(view);
        }
        return 0.0f;
    }

    public static void moveToNextValue(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(view, f);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect authRequestContext = getAuthRequestContext();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                authRequestContext.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !authRequestContext.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            DatabaseTableConfigUtil(view, i);
            if (z && authRequestContext.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(authRequestContext);
            }
        } else {
            DatabaseTableConfigUtil(view, i);
        }
    }

    private static void DatabaseTableConfigUtil(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            L(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                L((View) parent);
            }
        }
    }

    public static void PlaceComponentResult(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect authRequestContext = getAuthRequestContext();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                authRequestContext.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !authRequestContext.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            NetworkUserEntityData$$ExternalSyntheticLambda0(view, i);
            if (z && authRequestContext.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(authRequestContext);
            }
        } else {
            NetworkUserEntityData$$ExternalSyntheticLambda0(view, i);
        }
    }

    private static void NetworkUserEntityData$$ExternalSyntheticLambda0(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            L(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                L((View) parent);
            }
        }
    }

    private static void L(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void PlaceComponentResult(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.getAuthRequestContext(view, rect);
        }
    }

    public static Rect scheduleImpl(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.PlaceComponentResult(view);
        }
        return null;
    }

    public static boolean C(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.PlaceComponentResult(view);
        }
        return view.getWindowToken() != null;
    }

    public static boolean SubSequence(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return Api15Impl.BuiltInFictitiousFunctionClassFactory(view);
        }
        return false;
    }

    public static void MyBillsEntityDataFactory(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.PlaceComponentResult(view, i, i2);
        }
    }

    public static void PlaceComponentResult(View view, PointerIconCompat pointerIconCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.BuiltInFictitiousFunctionClassFactory(view, (PointerIcon) (pointerIconCompat != null ? pointerIconCompat.PlaceComponentResult() : null));
        }
    }

    public static Display lookAheadTest(View view) {
        if (Build.VERSION.SDK_INT < 17) {
            if (C(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
        return view.getDisplay();
    }

    public static int MyBillsEntityDataFactory() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.BuiltInFictitiousFunctionClassFactory();
        }
        do {
            atomicInteger = NetworkUserEntityData$$ExternalSyntheticLambda0;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    @Deprecated
    protected ViewCompat() {
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.KClassImpl$Data$declaredNonStaticMembers$2(view).KClassImpl$Data$declaredNonStaticMembers$2(keyEvent);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.KClassImpl$Data$declaredNonStaticMembers$2(view).KClassImpl$Data$declaredNonStaticMembers$2(view, keyEvent);
    }

    public static void getAuthRequestContext(View view, boolean z) {
        KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(view, Boolean.valueOf(z));
    }

    public static boolean E(View view) {
        Boolean moveToNextValue2 = KClassImpl$Data$declaredNonStaticMembers$2().moveToNextValue(view);
        return moveToNextValue2 != null && moveToNextValue2.booleanValue();
    }

    private static AccessibilityViewProperty<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        return new AccessibilityViewProperty<Boolean>(R.id.SummaryVoucherView$$ExternalSyntheticLambda2, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.1
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: getAuthRequestContext */
            public Boolean BuiltInFictitiousFunctionClassFactory(View view) {
                return Boolean.valueOf(Api28Impl.PlaceComponentResult(view));
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: BuiltInFictitiousFunctionClassFactory */
            public void getAuthRequestContext(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
            public boolean BuiltInFictitiousFunctionClassFactory(Boolean bool, Boolean bool2) {
                return !BuiltInFictitiousFunctionClassFactory(bool, bool2);
            }
        };
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(view, charSequence);
            if (charSequence != null) {
                MyBillsEntityDataFactory.getAuthRequestContext(view);
            } else {
                MyBillsEntityDataFactory.PlaceComponentResult(view);
            }
        }
    }

    public static CharSequence BuiltInFictitiousFunctionClassFactory(View view) {
        return BuiltInFictitiousFunctionClassFactory().moveToNextValue(view);
    }

    private static AccessibilityViewProperty<CharSequence> BuiltInFictitiousFunctionClassFactory() {
        return new AccessibilityViewProperty<CharSequence>(R.id.P, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.2
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: PlaceComponentResult */
            public CharSequence BuiltInFictitiousFunctionClassFactory(View view) {
                return Api28Impl.BuiltInFictitiousFunctionClassFactory(view);
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: MyBillsEntityDataFactory */
            public void getAuthRequestContext(View view, CharSequence charSequence) {
                Api28Impl.MyBillsEntityDataFactory(view, charSequence);
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccessibilityViewProperty<CharSequence> moveToNextValue() {
        return new AccessibilityViewProperty<CharSequence>(R.id.R, CharSequence.class, 64, 30) { // from class: androidx.core.view.ViewCompat.3
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
            public CharSequence BuiltInFictitiousFunctionClassFactory(View view) {
                return Api30Impl.BuiltInFictitiousFunctionClassFactory(view);
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public void getAuthRequestContext(View view, CharSequence charSequence) {
                Api30Impl.MyBillsEntityDataFactory(view, charSequence);
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: MyBillsEntityDataFactory */
            public boolean BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean VerifyPinStateManager$executeRiskChallenge$2$1(View view) {
        Boolean moveToNextValue2 = PlaceComponentResult().moveToNextValue(view);
        return moveToNextValue2 != null && moveToNextValue2.booleanValue();
    }

    private static AccessibilityViewProperty<Boolean> PlaceComponentResult() {
        return new AccessibilityViewProperty<Boolean>(R.id.O, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.4
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: MyBillsEntityDataFactory */
            public Boolean BuiltInFictitiousFunctionClassFactory(View view) {
                return Boolean.valueOf(Api28Impl.MyBillsEntityDataFactory(view));
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
            public void getAuthRequestContext(View view, Boolean bool) {
                Api28Impl.BuiltInFictitiousFunctionClassFactory(view, bool.booleanValue());
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            /* renamed from: getAuthRequestContext */
            public boolean BuiltInFictitiousFunctionClassFactory(Boolean bool, Boolean bool2) {
                return !BuiltInFictitiousFunctionClassFactory(bool, bool2);
            }
        };
    }

    /* loaded from: classes.dex */
    public static abstract class AccessibilityViewProperty<T> {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int PlaceComponentResult;
        private final Class<T> getAuthRequestContext;

        abstract T BuiltInFictitiousFunctionClassFactory(View view);

        abstract void getAuthRequestContext(View view, T t);

        AccessibilityViewProperty(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = cls;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.PlaceComponentResult = i3;
        }

        public void PlaceComponentResult(View view, T t) {
            if (PlaceComponentResult()) {
                getAuthRequestContext(view, t);
            } else if (BuiltInFictitiousFunctionClassFactory() && BuiltInFictitiousFunctionClassFactory(moveToNextValue(view), t)) {
                ViewCompat.getAuthRequestContext(view);
                view.setTag(this.BuiltInFictitiousFunctionClassFactory, t);
                ViewCompat.MyBillsEntityDataFactory(view, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        public T moveToNextValue(View view) {
            if (PlaceComponentResult()) {
                return BuiltInFictitiousFunctionClassFactory(view);
            }
            if (BuiltInFictitiousFunctionClassFactory()) {
                T t = (T) view.getTag(this.BuiltInFictitiousFunctionClassFactory);
                if (this.getAuthRequestContext.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        private boolean PlaceComponentResult() {
            return Build.VERSION.SDK_INT >= this.PlaceComponentResult;
        }

        private boolean BuiltInFictitiousFunctionClassFactory() {
            return Build.VERSION.SDK_INT >= 19;
        }

        boolean BuiltInFictitiousFunctionClassFactory(T t, T t2) {
            return !t2.equals(t);
        }

        boolean BuiltInFictitiousFunctionClassFactory(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }
    }

    static void MyBillsEntityDataFactory(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = BuiltInFictitiousFunctionClassFactory(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (KClassImpl$Data$declaredNonStaticMembers$2(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                Api19Impl.getAuthRequestContext(obtain, i);
                if (z) {
                    obtain.getText().add(BuiltInFictitiousFunctionClassFactory(view));
                    AppCompatEmojiTextHelper(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                Api19Impl.getAuthRequestContext(obtain2, i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(BuiltInFictitiousFunctionClassFactory(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    Api19Impl.getAuthRequestContext(view.getParent(), view, view, i);
                } catch (AbstractMethodError e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(view.getParent().getClass().getSimpleName());
                    sb.append(" does not fully implement ViewParent");
                    InstrumentInjector.log_e("ViewCompat", sb.toString(), e);
                }
            }
        }
    }

    private static void AppCompatEmojiTextHelper(View view) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda1(view) == 0) {
            moveToNextValue(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda1((View) parent) == 4) {
                moveToNextValue(view, 2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> PlaceComponentResult = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        AccessibilityPaneVisibilityManager() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.PlaceComponentResult.entrySet()) {
                    PlaceComponentResult(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            BuiltInFictitiousFunctionClassFactory(view);
        }

        void getAuthRequestContext(View view) {
            this.PlaceComponentResult.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (Api19Impl.PlaceComponentResult(view)) {
                BuiltInFictitiousFunctionClassFactory(view);
            }
        }

        void PlaceComponentResult(View view) {
            this.PlaceComponentResult.remove(view);
            view.removeOnAttachStateChangeListener(this);
            MyBillsEntityDataFactory(view);
        }

        private void PlaceComponentResult(View view, boolean z) {
            boolean z2 = view.isShown() && view.getWindowVisibility() == 0;
            if (z != z2) {
                ViewCompat.MyBillsEntityDataFactory(view, z2 ? 16 : 32);
                this.PlaceComponentResult.put(view, Boolean.valueOf(z2));
            }
        }

        private void BuiltInFictitiousFunctionClassFactory(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void MyBillsEntityDataFactory(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes.dex */
    public static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
        private WeakHashMap<View, Boolean> PlaceComponentResult = null;
        private SparseArray<WeakReference<View>> MyBillsEntityDataFactory = null;
        private WeakReference<KeyEvent> getAuthRequestContext = null;

        UnhandledKeyEventManager() {
        }

        private SparseArray<WeakReference<View>> BuiltInFictitiousFunctionClassFactory() {
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new SparseArray<>();
            }
            return this.MyBillsEntityDataFactory;
        }

        static UnhandledKeyEventManager KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.S);
            if (unhandledKeyEventManager == null) {
                UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                view.setTag(R.id.S, unhandledKeyEventManager2);
                return unhandledKeyEventManager2;
            }
            return unhandledKeyEventManager;
        }

        boolean KClassImpl$Data$declaredNonStaticMembers$2(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
            View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (BuiltInFictitiousFunctionClassFactory != null && !KeyEvent.isModifierKey(keyCode)) {
                    BuiltInFictitiousFunctionClassFactory().put(keyCode, new WeakReference<>(BuiltInFictitiousFunctionClassFactory));
                }
            }
            return BuiltInFictitiousFunctionClassFactory != null;
        }

        private View BuiltInFictitiousFunctionClassFactory(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.PlaceComponentResult;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(viewGroup.getChildAt(childCount), keyEvent);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        return BuiltInFictitiousFunctionClassFactory;
                    }
                }
            }
            if (PlaceComponentResult(view, keyEvent)) {
                return view;
            }
            return null;
        }

        boolean KClassImpl$Data$declaredNonStaticMembers$2(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.getAuthRequestContext;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.getAuthRequestContext = new WeakReference<>(keyEvent);
                SparseArray<WeakReference<View>> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
                WeakReference<View> weakReference2 = null;
                if (keyEvent.getAction() == 1 && (indexOfKey = BuiltInFictitiousFunctionClassFactory.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = BuiltInFictitiousFunctionClassFactory.valueAt(indexOfKey);
                    BuiltInFictitiousFunctionClassFactory.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = BuiltInFictitiousFunctionClassFactory.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && ViewCompat.C(view)) {
                        PlaceComponentResult(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        private boolean PlaceComponentResult(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.SummaryVoucherView$$ExternalSyntheticLambda1);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).BuiltInFictitiousFunctionClassFactory(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2() {
            WeakHashMap<View, Boolean> weakHashMap = this.PlaceComponentResult;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = KClassImpl$Data$declaredNonStaticMembers$2;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.PlaceComponentResult == null) {
                    this.PlaceComponentResult = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = KClassImpl$Data$declaredNonStaticMembers$2;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.PlaceComponentResult.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.PlaceComponentResult.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static WindowInsetsCompat getAuthRequestContext(View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.KClassImpl$Data$declaredNonStaticMembers$2(view);
        }

        static WindowInsetsCompat PlaceComponentResult(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets NetworkUserEntityData$$ExternalSyntheticLambda1 = windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda1();
            if (NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                return WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(view.computeSystemWindowInsets(NetworkUserEntityData$$ExternalSyntheticLambda1, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        static void getAuthRequestContext(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.N, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.V));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                    WindowInsetsCompat BuiltInFictitiousFunctionClassFactory = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2 = WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(windowInsets, view2);
                        if (Build.VERSION.SDK_INT < 30) {
                            Api21Impl.BuiltInFictitiousFunctionClassFactory(windowInsets, view);
                            if (KClassImpl$Data$declaredNonStaticMembers$2.equals(this.BuiltInFictitiousFunctionClassFactory)) {
                                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, KClassImpl$Data$declaredNonStaticMembers$2).NetworkUserEntityData$$ExternalSyntheticLambda1();
                            }
                        }
                        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
                        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view2, KClassImpl$Data$declaredNonStaticMembers$2);
                        if (Build.VERSION.SDK_INT >= 30) {
                            return onApplyWindowInsets.NetworkUserEntityData$$ExternalSyntheticLambda1();
                        }
                        ViewCompat.I(view2);
                        return onApplyWindowInsets.NetworkUserEntityData$$ExternalSyntheticLambda1();
                    }
                });
            }
        }

        static void BuiltInFictitiousFunctionClassFactory(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.V);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static float scheduleImpl(View view) {
            return view.getZ();
        }

        static void getAuthRequestContext(View view, float f) {
            view.setZ(f);
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, float f) {
            view.setTranslationZ(f);
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, String str) {
            view.setTransitionName(str);
        }

        static float MyBillsEntityDataFactory(View view) {
            return view.getElevation();
        }

        static void getAuthRequestContext(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static ColorStateList PlaceComponentResult(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode BuiltInFictitiousFunctionClassFactory(View view) {
            return view.getBackgroundTintMode();
        }

        static void PlaceComponentResult(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static boolean moveToNextValue(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void getErrorConfigVersion(View view) {
            view.stopNestedScroll();
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat getAuthRequestContext(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat PlaceComponentResult = WindowInsetsCompat.PlaceComponentResult(rootWindowInsets);
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(view.getRootView());
            return PlaceComponentResult;
        }

        static void PlaceComponentResult(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static void PlaceComponentResult(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        static void MyBillsEntityDataFactory(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        static CharSequence BuiltInFictitiousFunctionClassFactory(View view) {
            return view.getStateDescription();
        }
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static int PlaceComponentResult(View view) {
            return view.getImportantForAutofill();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api18Impl {
        private Api18Impl() {
        }

        static boolean getAuthRequestContext(View view) {
            return view.isInLayout();
        }

        static void getAuthRequestContext(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        static Rect PlaceComponentResult(View view) {
            return view.getClipBounds();
        }
    }

    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static boolean PlaceComponentResult(View view) {
            return view.isAttachedToWindow();
        }

        static int getAuthRequestContext(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static void PlaceComponentResult(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        static void getAuthRequestContext(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        static void getAuthRequestContext(ViewParent viewParent, View view, View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api15Impl {
        private Api15Impl() {
        }

        static boolean BuiltInFictitiousFunctionClassFactory(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static int BuiltInFictitiousFunctionClassFactory() {
            return View.generateViewId();
        }

        static void getAuthRequestContext(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static int PlaceComponentResult(View view) {
            return view.getLayoutDirection();
        }

        static int MyBillsEntityDataFactory(View view) {
            return view.getPaddingStart();
        }

        static int BuiltInFictitiousFunctionClassFactory(View view) {
            return view.getPaddingEnd();
        }

        static void PlaceComponentResult(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        static boolean getAuthRequestContext(View view) {
            return view.isPaddingRelative();
        }
    }

    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static boolean getErrorConfigVersion(View view) {
            return view.hasTransientState();
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, boolean z) {
            view.setHasTransientState(z);
        }

        static void moveToNextValue(View view) {
            view.postInvalidateOnAnimation();
        }

        static void getAuthRequestContext(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void MyBillsEntityDataFactory(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        static int PlaceComponentResult(View view) {
            return view.getImportantForAccessibility();
        }

        static ViewParent MyBillsEntityDataFactory(View view) {
            return view.getParentForAccessibility();
        }

        static int getAuthRequestContext(View view) {
            return view.getMinimumHeight();
        }

        static void lookAheadTest(View view) {
            view.requestFitSystemWindows();
        }

        static boolean BuiltInFictitiousFunctionClassFactory(View view) {
            return view.getFitsSystemWindows();
        }

        static boolean scheduleImpl(View view) {
            return view.hasOverlappingRendering();
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence BuiltInFictitiousFunctionClassFactory(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static void MyBillsEntityDataFactory(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        static boolean MyBillsEntityDataFactory(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean PlaceComponentResult(View view) {
            return view.isScreenReaderFocusable();
        }
    }

    /* loaded from: classes.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        static WindowInsets getAuthRequestContext(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }
    }
}
