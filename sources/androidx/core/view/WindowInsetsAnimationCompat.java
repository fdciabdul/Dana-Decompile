package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: classes6.dex */
public final class WindowInsetsAnimationCompat {
    private Impl PlaceComponentResult;

    public WindowInsetsAnimationCompat(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.PlaceComponentResult = new Impl30(i, interpolator, j);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.PlaceComponentResult = new Impl21(i, interpolator, j);
        } else {
            this.PlaceComponentResult = new Impl(0, interpolator, j);
        }
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.PlaceComponentResult = new Impl30(windowInsetsAnimation);
        }
    }

    public final float getAuthRequestContext() {
        return this.PlaceComponentResult.PlaceComponentResult();
    }

    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        this.PlaceComponentResult.getAuthRequestContext(f);
    }

    /* loaded from: classes6.dex */
    public static final class BoundsCompat {
        private final Insets KClassImpl$Data$declaredNonStaticMembers$2;
        private final Insets getAuthRequestContext;

        public BoundsCompat(Insets insets, Insets insets2) {
            this.getAuthRequestContext = insets;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = insets2;
        }

        private BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.getAuthRequestContext = Impl30.PlaceComponentResult(bounds);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Impl30.getAuthRequestContext(bounds);
        }

        public final Insets BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        public final Insets MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Bounds{lower=");
            sb.append(this.getAuthRequestContext);
            sb.append(" upper=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("}");
            return sb.toString();
        }

        public final WindowInsetsAnimation.Bounds getAuthRequestContext() {
            return Impl30.getAuthRequestContext(this);
        }

        public static BoundsCompat PlaceComponentResult(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }
    }

    static WindowInsetsAnimationCompat PlaceComponentResult(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    /* loaded from: classes6.dex */
    public static abstract class Callback {
        private final int BuiltInFictitiousFunctionClassFactory;
        WindowInsets getAuthRequestContext;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface DispatchMode {
        }

        public void BuiltInFictitiousFunctionClassFactory(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public BoundsCompat MyBillsEntityDataFactory(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }

        public abstract WindowInsetsCompat getAuthRequestContext(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list);

        public void getAuthRequestContext(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Impl {
        private final long KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final Interpolator PlaceComponentResult;
        private float getAuthRequestContext;

        Impl(int i, Interpolator interpolator, long j) {
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = interpolator;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        }

        public float PlaceComponentResult() {
            Interpolator interpolator = this.PlaceComponentResult;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.getAuthRequestContext);
            }
            return this.getAuthRequestContext;
        }

        public long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public void getAuthRequestContext(float f) {
            this.getAuthRequestContext = f;
        }
    }

    /* loaded from: classes6.dex */
    static class Impl21 extends Impl {
        Impl21(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        static BoundsCompat KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i) {
            Insets KClassImpl$Data$declaredNonStaticMembers$2 = windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(i);
            Insets KClassImpl$Data$declaredNonStaticMembers$22 = windowInsetsCompat2.KClassImpl$Data$declaredNonStaticMembers$2(i);
            return new BoundsCompat(Insets.PlaceComponentResult(Math.min(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult), Math.min(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory), Math.min(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2), Math.min(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext)), Insets.PlaceComponentResult(Math.max(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult), Math.max(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory), Math.max(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2), Math.max(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext)));
        }

        static int getAuthRequestContext(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if (!windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(i2).equals(windowInsetsCompat2.KClassImpl$Data$declaredNonStaticMembers$2(i2))) {
                    i |= i2;
                }
            }
            return i;
        }

        static WindowInsetsCompat PlaceComponentResult(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f, int i) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) == 0) {
                    builder.MyBillsEntityDataFactory(i2, windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(i2));
                } else {
                    Insets KClassImpl$Data$declaredNonStaticMembers$2 = windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                    Insets KClassImpl$Data$declaredNonStaticMembers$22 = windowInsetsCompat2.KClassImpl$Data$declaredNonStaticMembers$2(i2);
                    float f2 = 1.0f - f;
                    double d = (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult - KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult) * f2;
                    Double.isNaN(d);
                    int i3 = (int) (d + 0.5d);
                    double d2 = (KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory - KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory) * f2;
                    Double.isNaN(d2);
                    double d3 = (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 - KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2) * f2;
                    Double.isNaN(d3);
                    int i4 = (int) (d3 + 0.5d);
                    double d4 = (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext - KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext) * f2;
                    Double.isNaN(d4);
                    builder.MyBillsEntityDataFactory(i2, WindowInsetsCompat.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, i3, (int) (d2 + 0.5d), i4, (int) (d4 + 0.5d)));
                }
            }
            return builder.getAuthRequestContext();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private WindowInsetsCompat PlaceComponentResult;
            final Callback getAuthRequestContext;

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.PlaceComponentResult = WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(windowInsets, view);
                    return Impl21.BuiltInFictitiousFunctionClassFactory(view, windowInsets);
                }
                final WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2 = WindowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(windowInsets, view);
                if (this.PlaceComponentResult == null) {
                    this.PlaceComponentResult = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda3(view);
                }
                if (this.PlaceComponentResult == null) {
                    this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
                    return Impl21.BuiltInFictitiousFunctionClassFactory(view, windowInsets);
                }
                Callback PlaceComponentResult = Impl21.PlaceComponentResult(view);
                if (PlaceComponentResult != null && Objects.equals(PlaceComponentResult.getAuthRequestContext, windowInsets)) {
                    return Impl21.BuiltInFictitiousFunctionClassFactory(view, windowInsets);
                }
                final int authRequestContext = Impl21.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                if (authRequestContext == 0) {
                    return Impl21.BuiltInFictitiousFunctionClassFactory(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat = this.PlaceComponentResult;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(authRequestContext, new DecelerateInterpolator(), 160L);
                windowInsetsAnimationCompat.KClassImpl$Data$declaredNonStaticMembers$2(0.0f);
                final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.KClassImpl$Data$declaredNonStaticMembers$2());
                final BoundsCompat KClassImpl$Data$declaredNonStaticMembers$22 = Impl21.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, windowInsetsCompat, authRequestContext);
                Impl21.getAuthRequestContext(view, windowInsetsAnimationCompat, windowInsets, false);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        windowInsetsAnimationCompat.KClassImpl$Data$declaredNonStaticMembers$2(valueAnimator.getAnimatedFraction());
                        Impl21.BuiltInFictitiousFunctionClassFactory(view, Impl21.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, windowInsetsCompat, windowInsetsAnimationCompat.getAuthRequestContext(), authRequestContext), Collections.singletonList(windowInsetsAnimationCompat));
                    }
                });
                duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        windowInsetsAnimationCompat.KClassImpl$Data$declaredNonStaticMembers$2(1.0f);
                        Impl21.MyBillsEntityDataFactory(view, windowInsetsAnimationCompat);
                    }
                });
                OneShotPreDrawListener.KClassImpl$Data$declaredNonStaticMembers$2(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Impl21.KClassImpl$Data$declaredNonStaticMembers$2(view, windowInsetsAnimationCompat, KClassImpl$Data$declaredNonStaticMembers$22);
                        duration.start();
                    }
                });
                this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
                return Impl21.BuiltInFictitiousFunctionClassFactory(view, windowInsets);
            }
        }

        static WindowInsets BuiltInFictitiousFunctionClassFactory(View view, WindowInsets windowInsets) {
            return view.getTag(R.id.N) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static void getAuthRequestContext(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            Callback PlaceComponentResult = PlaceComponentResult(view);
            if (PlaceComponentResult != null) {
                PlaceComponentResult.getAuthRequestContext = windowInsets;
                if (!z) {
                    PlaceComponentResult.getAuthRequestContext(windowInsetsAnimationCompat);
                    z = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    getAuthRequestContext(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z);
                }
            }
        }

        static void KClassImpl$Data$declaredNonStaticMembers$2(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback PlaceComponentResult = PlaceComponentResult(view);
            if (PlaceComponentResult != null) {
                PlaceComponentResult.MyBillsEntityDataFactory(windowInsetsAnimationCompat, boundsCompat);
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    KClassImpl$Data$declaredNonStaticMembers$2(viewGroup.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        static void BuiltInFictitiousFunctionClassFactory(View view, WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            Callback PlaceComponentResult = PlaceComponentResult(view);
            if (PlaceComponentResult != null) {
                windowInsetsCompat = PlaceComponentResult.getAuthRequestContext(windowInsetsCompat, list);
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    BuiltInFictitiousFunctionClassFactory(viewGroup.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        static void MyBillsEntityDataFactory(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback PlaceComponentResult = PlaceComponentResult(view);
            if (PlaceComponentResult != null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(windowInsetsAnimationCompat);
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    MyBillsEntityDataFactory(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
                }
            }
        }

        static Callback PlaceComponentResult(View view) {
            Object tag = view.getTag(R.id.V);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).getAuthRequestContext;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Impl30 extends Impl {
        private final WindowInsetsAnimation getAuthRequestContext;

        Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.getAuthRequestContext = windowInsetsAnimation;
        }

        Impl30(int i, Interpolator interpolator, long j) {
            this(new WindowInsetsAnimation(i, interpolator, j));
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void getAuthRequestContext(float f) {
            this.getAuthRequestContext.setFraction(f);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float PlaceComponentResult() {
            return this.getAuthRequestContext.getInterpolatedFraction();
        }

        /* loaded from: classes6.dex */
        static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> KClassImpl$Data$declaredNonStaticMembers$2;
            private ArrayList<WindowInsetsAnimationCompat> MyBillsEntityDataFactory;
            private List<WindowInsetsAnimationCompat> PlaceComponentResult;
            private final Callback getAuthRequestContext;

            private WindowInsetsAnimationCompat PlaceComponentResult(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.KClassImpl$Data$declaredNonStaticMembers$2.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat == null) {
                    WindowInsetsAnimationCompat PlaceComponentResult = WindowInsetsAnimationCompat.PlaceComponentResult(windowInsetsAnimation);
                    this.KClassImpl$Data$declaredNonStaticMembers$2.put(windowInsetsAnimation, PlaceComponentResult);
                    return PlaceComponentResult;
                }
                return windowInsetsAnimationCompat;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.getAuthRequestContext.getAuthRequestContext(PlaceComponentResult(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.getAuthRequestContext.MyBillsEntityDataFactory(PlaceComponentResult(windowInsetsAnimation), BoundsCompat.PlaceComponentResult(bounds)).getAuthRequestContext();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.MyBillsEntityDataFactory;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.MyBillsEntityDataFactory = arrayList2;
                    this.PlaceComponentResult = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    WindowInsetsAnimationCompat PlaceComponentResult = PlaceComponentResult(windowInsetsAnimation);
                    PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(windowInsetsAnimation.getFraction());
                    this.MyBillsEntityDataFactory.add(PlaceComponentResult);
                }
                return this.getAuthRequestContext.getAuthRequestContext(WindowInsetsCompat.PlaceComponentResult(windowInsets), this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda1();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(windowInsetsAnimation));
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(windowInsetsAnimation);
            }
        }

        public static WindowInsetsAnimation.Bounds getAuthRequestContext(BoundsCompat boundsCompat) {
            Insets BuiltInFictitiousFunctionClassFactory = boundsCompat.BuiltInFictitiousFunctionClassFactory();
            android.graphics.Insets BuiltInFictitiousFunctionClassFactory2 = Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
            Insets MyBillsEntityDataFactory = boundsCompat.MyBillsEntityDataFactory();
            return new WindowInsetsAnimation.Bounds(BuiltInFictitiousFunctionClassFactory2, Insets.Api29Impl.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext));
        }

        public static Insets PlaceComponentResult(WindowInsetsAnimation.Bounds bounds) {
            return Insets.MyBillsEntityDataFactory(bounds.getLowerBound());
        }

        public static Insets getAuthRequestContext(WindowInsetsAnimation.Bounds bounds) {
            return Insets.MyBillsEntityDataFactory(bounds.getUpperBound());
        }
    }
}
