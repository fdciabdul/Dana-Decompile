package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat getAuthRequestContext;
    private final Impl PlaceComponentResult;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            getAuthRequestContext = Impl30.CONSUMED;
        } else {
            getAuthRequestContext = Impl.CONSUMED;
        }
    }

    private WindowInsetsCompat(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.PlaceComponentResult = new Impl30(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.PlaceComponentResult = new Impl29(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.PlaceComponentResult = new Impl28(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.PlaceComponentResult = new Impl21(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.PlaceComponentResult = new Impl20(this, windowInsets);
        } else {
            this.PlaceComponentResult = new Impl(this);
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.PlaceComponentResult;
            if (Build.VERSION.SDK_INT >= 30 && (impl instanceof Impl30)) {
                this.PlaceComponentResult = new Impl30(this, (Impl30) impl);
            } else if (Build.VERSION.SDK_INT >= 29 && (impl instanceof Impl29)) {
                this.PlaceComponentResult = new Impl29(this, (Impl29) impl);
            } else if (Build.VERSION.SDK_INT >= 28 && (impl instanceof Impl28)) {
                this.PlaceComponentResult = new Impl28(this, (Impl28) impl);
            } else if (Build.VERSION.SDK_INT >= 21 && (impl instanceof Impl21)) {
                this.PlaceComponentResult = new Impl21(this, (Impl21) impl);
            } else if (Build.VERSION.SDK_INT >= 20 && (impl instanceof Impl20)) {
                this.PlaceComponentResult = new Impl20(this, (Impl20) impl);
            } else {
                this.PlaceComponentResult = new Impl(this);
            }
            impl.copyWindowDataInto(this);
            return;
        }
        this.PlaceComponentResult = new Impl(this);
    }

    public static WindowInsetsCompat PlaceComponentResult(WindowInsets windowInsets) {
        return KClassImpl$Data$declaredNonStaticMembers$2(windowInsets, null);
    }

    public static WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(windowInsets));
        if (view != null && ViewCompat.C(view)) {
            windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda3(view));
            windowInsetsCompat.BuiltInFictitiousFunctionClassFactory(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public int lookAheadTest() {
        return this.PlaceComponentResult.getSystemWindowInsets().PlaceComponentResult;
    }

    @Deprecated
    public int initRecordTimeStamp() {
        return this.PlaceComponentResult.getSystemWindowInsets().BuiltInFictitiousFunctionClassFactory;
    }

    @Deprecated
    public int getErrorConfigVersion() {
        return this.PlaceComponentResult.getSystemWindowInsets().KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Deprecated
    public int moveToNextValue() {
        return this.PlaceComponentResult.getSystemWindowInsets().getAuthRequestContext;
    }

    @Deprecated
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return !this.PlaceComponentResult.getSystemWindowInsets().equals(Insets.MyBillsEntityDataFactory);
    }

    public boolean GetContactSyncConfig() {
        return this.PlaceComponentResult.isConsumed();
    }

    @Deprecated
    public WindowInsetsCompat MyBillsEntityDataFactory() {
        return this.PlaceComponentResult.consumeSystemWindowInsets();
    }

    @Deprecated
    public WindowInsetsCompat MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
        return new Builder(this).getAuthRequestContext(Insets.PlaceComponentResult(i, i2, i3, i4)).getAuthRequestContext();
    }

    @Deprecated
    public WindowInsetsCompat BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.consumeStableInsets();
    }

    public DisplayCutoutCompat PlaceComponentResult() {
        return this.PlaceComponentResult.getDisplayCutout();
    }

    @Deprecated
    public WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.consumeDisplayCutout();
    }

    @Deprecated
    public Insets NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.PlaceComponentResult.getStableInsets();
    }

    @Deprecated
    public Insets getAuthRequestContext() {
        return this.PlaceComponentResult.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public Insets scheduleImpl() {
        return this.PlaceComponentResult.getSystemGestureInsets();
    }

    public WindowInsetsCompat PlaceComponentResult(int i, int i2, int i3, int i4) {
        return this.PlaceComponentResult.inset(i, i2, i3, i4);
    }

    public Insets KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.PlaceComponentResult.getInsets(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.MyBillsEntityDataFactory(this.PlaceComponentResult, ((WindowInsetsCompat) obj).PlaceComponentResult);
        }
        return false;
    }

    public int hashCode() {
        Impl impl = this.PlaceComponentResult;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public WindowInsets NetworkUserEntityData$$ExternalSyntheticLambda1() {
        Impl impl = this.PlaceComponentResult;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class Impl {
        static final WindowInsetsCompat CONSUMED = new Builder().getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
        final WindowInsetsCompat mHost;

        void copyRootViewBounds(View view) {
        }

        void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
        }

        DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        boolean isConsumed() {
            return false;
        }

        boolean isRound() {
            return false;
        }

        boolean isVisible(int i) {
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        void setRootViewData(Insets insets) {
        }

        void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }

        Impl(WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        Insets getSystemWindowInsets() {
            return Insets.MyBillsEntityDataFactory;
        }

        Insets getStableInsets() {
            return Insets.MyBillsEntityDataFactory;
        }

        Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            return CONSUMED;
        }

        Insets getInsets(int i) {
            return Insets.MyBillsEntityDataFactory;
        }

        Insets getInsetsIgnoringVisibility(int i) {
            if ((i & 8) != 0) {
                throw new IllegalArgumentException("Unable to query the maximum insets for IME");
            }
            return Insets.MyBillsEntityDataFactory;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl) {
                Impl impl = (Impl) obj;
                return isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat.MyBillsEntityDataFactory(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat.MyBillsEntityDataFactory(getStableInsets(), impl.getStableInsets()) && ObjectsCompat.MyBillsEntityDataFactory(getDisplayCutout(), impl.getDisplayCutout());
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.PlaceComponentResult(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }
    }

    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass;
        private static Field sAttachInfoField;
        private static Method sGetViewRootImplMethod;
        private static Field sVisibleInsetsField;
        private static boolean sVisibleRectReflectionFetched;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        Impl20(WindowInsetsCompat windowInsetsCompat, Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int i) {
            return getInsets(i, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int i) {
            return getInsets(i, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isVisible(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0 && !isTypeVisible(i2)) {
                    return false;
                }
            }
            return true;
        }

        private Insets getInsets(int i, boolean z) {
            Insets insets = Insets.MyBillsEntityDataFactory;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    insets = Insets.PlaceComponentResult(insets, getInsetsForType(i2, z));
                }
            }
            return insets;
        }

        protected Insets getInsetsForType(int i, boolean z) {
            Insets NetworkUserEntityData$$ExternalSyntheticLambda0;
            DisplayCutoutCompat displayCutout;
            if (i == 1) {
                if (z) {
                    return Insets.PlaceComponentResult(0, Math.max(getRootStableInsets().BuiltInFictitiousFunctionClassFactory, getSystemWindowInsets().BuiltInFictitiousFunctionClassFactory), 0, 0);
                }
                return Insets.PlaceComponentResult(0, getSystemWindowInsets().BuiltInFictitiousFunctionClassFactory, 0, 0);
            }
            if (i == 2) {
                if (z) {
                    Insets rootStableInsets = getRootStableInsets();
                    Insets stableInsets = getStableInsets();
                    return Insets.PlaceComponentResult(Math.max(rootStableInsets.PlaceComponentResult, stableInsets.PlaceComponentResult), 0, Math.max(rootStableInsets.KClassImpl$Data$declaredNonStaticMembers$2, stableInsets.KClassImpl$Data$declaredNonStaticMembers$2), Math.max(rootStableInsets.getAuthRequestContext, stableInsets.getAuthRequestContext));
                }
                Insets systemWindowInsets = getSystemWindowInsets();
                WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = windowInsetsCompat != null ? windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda0() : null;
                int i2 = systemWindowInsets.getAuthRequestContext;
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    i2 = Math.min(i2, NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext);
                }
                return Insets.PlaceComponentResult(systemWindowInsets.PlaceComponentResult, 0, systemWindowInsets.KClassImpl$Data$declaredNonStaticMembers$2, i2);
            } else if (i == 8) {
                Insets[] insetsArr = this.mOverriddenInsets;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = insetsArr != null ? insetsArr[Type.PlaceComponentResult(8)] : null;
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    return NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                Insets systemWindowInsets2 = getSystemWindowInsets();
                Insets rootStableInsets2 = getRootStableInsets();
                if (systemWindowInsets2.getAuthRequestContext > rootStableInsets2.getAuthRequestContext) {
                    return Insets.PlaceComponentResult(0, 0, 0, systemWindowInsets2.getAuthRequestContext);
                }
                Insets insets = this.mRootViewVisibleInsets;
                if (insets != null && !insets.equals(Insets.MyBillsEntityDataFactory) && this.mRootViewVisibleInsets.getAuthRequestContext > rootStableInsets2.getAuthRequestContext) {
                    return Insets.PlaceComponentResult(0, 0, 0, this.mRootViewVisibleInsets.getAuthRequestContext);
                }
                return Insets.MyBillsEntityDataFactory;
            } else if (i != 16) {
                if (i != 32) {
                    if (i != 64) {
                        if (i == 128) {
                            WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                            if (windowInsetsCompat2 != null) {
                                displayCutout = windowInsetsCompat2.PlaceComponentResult();
                            } else {
                                displayCutout = getDisplayCutout();
                            }
                            if (displayCutout != null) {
                                return Insets.PlaceComponentResult(displayCutout.KClassImpl$Data$declaredNonStaticMembers$2(), displayCutout.PlaceComponentResult(), displayCutout.MyBillsEntityDataFactory(), displayCutout.BuiltInFictitiousFunctionClassFactory());
                            }
                            return Insets.MyBillsEntityDataFactory;
                        }
                        return Insets.MyBillsEntityDataFactory;
                    }
                    return getTappableElementInsets();
                }
                return getMandatorySystemGestureInsets();
            } else {
                return getSystemGestureInsets();
            }
        }

        protected boolean isTypeVisible(int i) {
            if (i != 1 && i != 2) {
                if (i == 4) {
                    return false;
                }
                if (i != 8 && i != 128) {
                    return true;
                }
            }
            return !getInsetsForType(i, false).equals(Insets.MyBillsEntityDataFactory);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.PlaceComponentResult(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            Builder builder = new Builder(WindowInsetsCompat.PlaceComponentResult(this.mPlatformInsets));
            builder.getAuthRequestContext(WindowInsetsCompat.getAuthRequestContext(getSystemWindowInsets(), i, i2, i3, i4));
            builder.MyBillsEntityDataFactory(WindowInsetsCompat.getAuthRequestContext(getStableInsets(), i, i2, i3, i4));
            return builder.getAuthRequestContext();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.mRootWindowInsets);
            windowInsetsCompat.MyBillsEntityDataFactory(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void setRootViewData(Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            return Insets.MyBillsEntityDataFactory;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void copyRootViewBounds(View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.MyBillsEntityDataFactory;
            }
            setRootViewData(visibleInsets);
        }

        private Insets getVisibleInsets(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!sVisibleRectReflectionFetched) {
                loadReflectionField();
            }
            Method method = sGetViewRootImplMethod;
            if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        InstrumentInjector.log_w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                    if (rect != null) {
                        return Insets.PlaceComponentResult(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    InstrumentInjector.log_e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                InstrumentInjector.log_e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            sVisibleRectReflectionFetched = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mStableInsets = null;
        }

        Impl21(WindowInsetsCompat windowInsetsCompat, Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.mStableInsets = null;
            this.mStableInsets = impl21.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.PlaceComponentResult(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.PlaceComponentResult(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.PlaceComponentResult(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl28(WindowInsetsCompat windowInsetsCompat, Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.MyBillsEntityDataFactory(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.PlaceComponentResult(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl28) {
                Impl28 impl28 = (Impl28) obj;
                return Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
        }

        Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        Impl29(WindowInsetsCompat windowInsetsCompat, Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.MyBillsEntityDataFactory(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.MyBillsEntityDataFactory(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        Insets getTappableElementInsets() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.MyBillsEntityDataFactory(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.PlaceComponentResult(this.mPlatformInsets.inset(i, i2, i3, i4));
        }
    }

    public static Insets getAuthRequestContext(Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.PlaceComponentResult - i);
        int max2 = Math.max(0, insets.BuiltInFictitiousFunctionClassFactory - i2);
        int max3 = Math.max(0, insets.KClassImpl$Data$declaredNonStaticMembers$2 - i3);
        int max4 = Math.max(0, insets.getAuthRequestContext - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? insets : Insets.PlaceComponentResult(max, max2, max3, max4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Impl30 extends Impl29 {
        static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.PlaceComponentResult(WindowInsets.CONSUMED);

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        final void copyRootViewBounds(View view) {
        }

        Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl30(WindowInsetsCompat windowInsetsCompat, Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int i) {
            return Insets.MyBillsEntityDataFactory(this.mPlatformInsets.getInsets(TypeImpl30.BuiltInFictitiousFunctionClassFactory(i)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int i) {
            return Insets.MyBillsEntityDataFactory(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.BuiltInFictitiousFunctionClassFactory(i)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int i) {
            return this.mPlatformInsets.isVisible(TypeImpl30.BuiltInFictitiousFunctionClassFactory(i));
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final BuilderImpl MyBillsEntityDataFactory;

        public Builder() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.MyBillsEntityDataFactory = new BuilderImpl30();
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.MyBillsEntityDataFactory = new BuilderImpl29();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.MyBillsEntityDataFactory = new BuilderImpl20();
            } else {
                this.MyBillsEntityDataFactory = new BuilderImpl();
            }
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.MyBillsEntityDataFactory = new BuilderImpl30(windowInsetsCompat);
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.MyBillsEntityDataFactory = new BuilderImpl29(windowInsetsCompat);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.MyBillsEntityDataFactory = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.MyBillsEntityDataFactory = new BuilderImpl(windowInsetsCompat);
            }
        }

        @Deprecated
        public final Builder getAuthRequestContext(Insets insets) {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(insets);
            return this;
        }

        public final Builder MyBillsEntityDataFactory(int i, Insets insets) {
            this.MyBillsEntityDataFactory.PlaceComponentResult(i, insets);
            return this;
        }

        @Deprecated
        public final Builder MyBillsEntityDataFactory(Insets insets) {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(insets);
            return this;
        }

        public final WindowInsetsCompat getAuthRequestContext() {
            return this.MyBillsEntityDataFactory.getAuthRequestContext();
        }
    }

    /* loaded from: classes.dex */
    public static class BuilderImpl {
        private final WindowInsetsCompat MyBillsEntityDataFactory;
        Insets[] getAuthRequestContext;

        void BuiltInFictitiousFunctionClassFactory(Insets insets) {
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(Insets insets) {
        }

        void MyBillsEntityDataFactory(Insets insets) {
        }

        void PlaceComponentResult(Insets insets) {
        }

        void getAuthRequestContext(Insets insets) {
        }

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.MyBillsEntityDataFactory = windowInsetsCompat;
        }

        void PlaceComponentResult(int i, Insets insets) {
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = new Insets[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.getAuthRequestContext[Type.PlaceComponentResult(i2)] = insets;
                }
            }
        }

        protected final void BuiltInFictitiousFunctionClassFactory() {
            Insets[] insetsArr = this.getAuthRequestContext;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.PlaceComponentResult(1)];
                Insets insets2 = this.getAuthRequestContext[Type.PlaceComponentResult(2)];
                if (insets2 == null) {
                    insets2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(2);
                }
                if (insets == null) {
                    insets = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1);
                }
                MyBillsEntityDataFactory(Insets.PlaceComponentResult(insets, insets2));
                Insets insets3 = this.getAuthRequestContext[Type.PlaceComponentResult(16)];
                if (insets3 != null) {
                    getAuthRequestContext(insets3);
                }
                Insets insets4 = this.getAuthRequestContext[Type.PlaceComponentResult(32)];
                if (insets4 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2(insets4);
                }
                Insets insets5 = this.getAuthRequestContext[Type.PlaceComponentResult(64)];
                if (insets5 != null) {
                    PlaceComponentResult(insets5);
                }
            }
        }

        WindowInsetsCompat getAuthRequestContext() {
            BuiltInFictitiousFunctionClassFactory();
            return this.MyBillsEntityDataFactory;
        }
    }

    void BuiltInFictitiousFunctionClassFactory(Insets[] insetsArr) {
        this.PlaceComponentResult.setOverriddenInsets(insetsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BuilderImpl20 extends BuilderImpl {
        private static boolean BuiltInFictitiousFunctionClassFactory;
        private static Field KClassImpl$Data$declaredNonStaticMembers$2;
        private static Constructor<WindowInsets> MyBillsEntityDataFactory;
        private static boolean PlaceComponentResult;
        private Insets getErrorConfigVersion;
        private WindowInsets scheduleImpl;

        BuilderImpl20() {
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2();
        }

        BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.scheduleImpl = windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda1();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void MyBillsEntityDataFactory(Insets insets) {
            WindowInsets windowInsets = this.scheduleImpl;
            if (windowInsets != null) {
                this.scheduleImpl = windowInsets.replaceSystemWindowInsets(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext);
            }
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void BuiltInFictitiousFunctionClassFactory(Insets insets) {
            this.getErrorConfigVersion = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat getAuthRequestContext() {
            BuiltInFictitiousFunctionClassFactory();
            WindowInsetsCompat PlaceComponentResult2 = WindowInsetsCompat.PlaceComponentResult(this.scheduleImpl);
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            PlaceComponentResult2.PlaceComponentResult(this.getErrorConfigVersion);
            return PlaceComponentResult2;
        }

        private static WindowInsets KClassImpl$Data$declaredNonStaticMembers$2() {
            if (!BuiltInFictitiousFunctionClassFactory) {
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2 = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    InstrumentInjector.log_i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                BuiltInFictitiousFunctionClassFactory = true;
            }
            Field field = KClassImpl$Data$declaredNonStaticMembers$2;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    InstrumentInjector.log_i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!PlaceComponentResult) {
                try {
                    MyBillsEntityDataFactory = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    InstrumentInjector.log_i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                PlaceComponentResult = true;
            }
            Constructor<WindowInsets> constructor = MyBillsEntityDataFactory;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    InstrumentInjector.log_i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }
    }

    void PlaceComponentResult(Insets insets) {
        this.PlaceComponentResult.setStableInsets(insets);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder BuiltInFictitiousFunctionClassFactory;

        BuilderImpl29() {
            this.BuiltInFictitiousFunctionClassFactory = new WindowInsets.Builder();
        }

        BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets NetworkUserEntityData$$ExternalSyntheticLambda1 = windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda1();
            if (NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                builder = new WindowInsets.Builder(NetworkUserEntityData$$ExternalSyntheticLambda1);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.BuiltInFictitiousFunctionClassFactory = builder;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void MyBillsEntityDataFactory(Insets insets) {
            this.BuiltInFictitiousFunctionClassFactory.setSystemWindowInsets(Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext));
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void getAuthRequestContext(Insets insets) {
            this.BuiltInFictitiousFunctionClassFactory.setSystemGestureInsets(Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext));
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void KClassImpl$Data$declaredNonStaticMembers$2(Insets insets) {
            this.BuiltInFictitiousFunctionClassFactory.setMandatorySystemGestureInsets(Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext));
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void PlaceComponentResult(Insets insets) {
            this.BuiltInFictitiousFunctionClassFactory.setTappableElementInsets(Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext));
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void BuiltInFictitiousFunctionClassFactory(Insets insets) {
            this.BuiltInFictitiousFunctionClassFactory.setStableInsets(Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext));
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        WindowInsetsCompat getAuthRequestContext() {
            BuiltInFictitiousFunctionClassFactory();
            WindowInsetsCompat PlaceComponentResult = WindowInsetsCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.build());
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            return PlaceComponentResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void PlaceComponentResult(int i, Insets insets) {
            this.BuiltInFictitiousFunctionClassFactory.setInsets(TypeImpl30.BuiltInFictitiousFunctionClassFactory(i), Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(insets.PlaceComponentResult, insets.BuiltInFictitiousFunctionClassFactory, insets.KClassImpl$Data$declaredNonStaticMembers$2, insets.getAuthRequestContext));
        }
    }

    /* loaded from: classes.dex */
    public static final class Type {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface InsetsType {
        }

        public static int KClassImpl$Data$declaredNonStaticMembers$2() {
            return 1;
        }

        public static int MyBillsEntityDataFactory() {
            return 7;
        }

        private Type() {
        }

        static int PlaceComponentResult(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            if (i == 256) {
                                                return 8;
                                            }
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("type needs to be >= FIRST and <= LAST, type=");
                                            sb.append(i);
                                            throw new IllegalArgumentException(sb.toString());
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int BuiltInFictitiousFunctionClassFactory(int i) {
            int statusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= statusBars;
                }
            }
            return i2;
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat windowInsetsCompat) {
        this.PlaceComponentResult.setRootWindowInsets(windowInsetsCompat);
    }

    void MyBillsEntityDataFactory(Insets insets) {
        this.PlaceComponentResult.setRootViewData(insets);
    }

    public void BuiltInFictitiousFunctionClassFactory(View view) {
        this.PlaceComponentResult.copyRootViewBounds(view);
    }

    /* loaded from: classes.dex */
    public static class Api21ReflectionHolder {
        private static Field BuiltInFictitiousFunctionClassFactory;
        private static Field MyBillsEntityDataFactory;
        private static Field PlaceComponentResult;
        private static boolean getAuthRequestContext;

        private Api21ReflectionHolder() {
        }

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                PlaceComponentResult = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                MyBillsEntityDataFactory = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                BuiltInFictitiousFunctionClassFactory = declaredField3;
                declaredField3.setAccessible(true);
                getAuthRequestContext = true;
            } catch (ReflectiveOperationException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets from AttachInfo ");
                sb.append(e.getMessage());
                InstrumentInjector.log_w("WindowInsetsCompat", sb.toString(), e);
            }
        }

        public static WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            if (getAuthRequestContext && view.isAttachedToWindow()) {
                try {
                    Object obj = PlaceComponentResult.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) MyBillsEntityDataFactory.get(obj);
                        Rect rect2 = (Rect) BuiltInFictitiousFunctionClassFactory.get(obj);
                        if (rect == null || rect2 == null) {
                            return null;
                        }
                        WindowInsetsCompat authRequestContext = new Builder().MyBillsEntityDataFactory(Insets.PlaceComponentResult(rect)).getAuthRequestContext(Insets.PlaceComponentResult(rect2)).getAuthRequestContext();
                        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
                        authRequestContext.BuiltInFictitiousFunctionClassFactory(view.getRootView());
                        return authRequestContext;
                    }
                    return null;
                } catch (IllegalAccessException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to get insets from AttachInfo. ");
                    sb.append(e.getMessage());
                    InstrumentInjector.log_w("WindowInsetsCompat", sb.toString(), e);
                    return null;
                }
            }
            return null;
        }
    }
}
