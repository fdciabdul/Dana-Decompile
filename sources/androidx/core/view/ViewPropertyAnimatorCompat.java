package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    private final WeakReference<View> BuiltInFictitiousFunctionClassFactory;
    Runnable PlaceComponentResult = null;
    Runnable KClassImpl$Data$declaredNonStaticMembers$2 = null;
    int MyBillsEntityDataFactory = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimatorCompat(View view) {
        this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(view);
    }

    /* loaded from: classes.dex */
    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = viewPropertyAnimatorCompat;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void MyBillsEntityDataFactory(View view) {
            this.MyBillsEntityDataFactory = false;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory >= 0) {
                view.setLayerType(2, null);
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult != null) {
                Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.MyBillsEntityDataFactory(view);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void getAuthRequestContext(View view) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory >= 0) {
                view.setLayerType(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, null);
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.MyBillsEntityDataFactory) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.getAuthRequestContext(view);
                }
                this.MyBillsEntityDataFactory = true;
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.KClassImpl$Data$declaredNonStaticMembers$2(view);
            }
        }
    }

    public final ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat getAuthRequestContext(float f) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat MyBillsEntityDataFactory(float f) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat PlaceComponentResult(float f) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat BuiltInFictitiousFunctionClassFactory(Runnable runnable) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                Api16Impl.getAuthRequestContext(view.animate(), runnable);
            } else {
                PlaceComponentResult(view, new ViewPropertyAnimatorListenerApi14(this));
                this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
            }
        }
        return this;
    }

    public final long getAuthRequestContext() {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public final ViewPropertyAnimatorCompat MyBillsEntityDataFactory(Interpolator interpolator) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat PlaceComponentResult(long j) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat BuiltInFictitiousFunctionClassFactory(float f) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final ViewPropertyAnimatorCompat NetworkUserEntityData$$ExternalSyntheticLambda0(float f) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().x(f);
        }
        return this;
    }

    public final void PlaceComponentResult() {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final ViewPropertyAnimatorCompat MyBillsEntityDataFactory() {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                Api16Impl.MyBillsEntityDataFactory(view.animate());
            } else {
                this.MyBillsEntityDataFactory = view.getLayerType();
                PlaceComponentResult(view, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                PlaceComponentResult(view, new ViewPropertyAnimatorListenerApi14(this));
                this.PlaceComponentResult = runnable;
            } else {
                view.animate().withStartAction(runnable);
            }
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat KClassImpl$Data$declaredNonStaticMembers$2(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                PlaceComponentResult(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                PlaceComponentResult(view, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    private void PlaceComponentResult(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.KClassImpl$Data$declaredNonStaticMembers$2(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.getAuthRequestContext(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.MyBillsEntityDataFactory(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public final ViewPropertyAnimatorCompat PlaceComponentResult(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.BuiltInFictitiousFunctionClassFactory.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            Api19Impl.BuiltInFictitiousFunctionClassFactory(view.animate(), viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener2 = ViewPropertyAnimatorUpdateListener.this;
                    View view2 = view;
                    viewPropertyAnimatorUpdateListener2.PlaceComponentResult();
                }
            } : null);
        }
        return this;
    }

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static ViewPropertyAnimator getAuthRequestContext(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        static ViewPropertyAnimator MyBillsEntityDataFactory(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }
    }

    /* loaded from: classes.dex */
    static class Api18Impl {
        private Api18Impl() {
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }
    }

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static ViewPropertyAnimator BuiltInFictitiousFunctionClassFactory(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }
}
