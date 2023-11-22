package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private ViewTreeObserver BuiltInFictitiousFunctionClassFactory;
    private final View KClassImpl$Data$declaredNonStaticMembers$2;
    private final Runnable getAuthRequestContext;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = view.getViewTreeObserver();
        this.getAuthRequestContext = runnable;
    }

    public static OneShotPreDrawListener KClassImpl$Data$declaredNonStaticMembers$2(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext.run();
        return true;
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory.isAlive()) {
            this.BuiltInFictitiousFunctionClassFactory.removeOnPreDrawListener(this);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.BuiltInFictitiousFunctionClassFactory = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        BuiltInFictitiousFunctionClassFactory();
    }
}
