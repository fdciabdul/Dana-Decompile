package androidx.core.view;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;

/* loaded from: classes6.dex */
public final class WindowInsetsControllerCompat {

    /* loaded from: classes6.dex */
    static class Impl23 extends Impl20 {
    }

    /* loaded from: classes6.dex */
    static class Impl26 extends Impl23 {
    }

    /* loaded from: classes6.dex */
    public interface OnControllableInsetsChangedListener {
        void MyBillsEntityDataFactory(WindowInsetsControllerCompat windowInsetsControllerCompat, int i);
    }

    /* loaded from: classes6.dex */
    static class Impl {
        Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Impl20 extends Impl {
    }

    /* loaded from: classes6.dex */
    static class Impl30 extends Impl {
        final WindowInsetsControllerCompat BuiltInFictitiousFunctionClassFactory;
        final WindowInsetsController MyBillsEntityDataFactory;

        /* renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl30$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 implements WindowInsetsAnimationControlListener {
            private WindowInsetsAnimationControllerCompat PlaceComponentResult;
            final /* synthetic */ WindowInsetsAnimationControlListenerCompat getAuthRequestContext;

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.PlaceComponentResult = windowInsetsAnimationControllerCompat;
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(windowInsetsAnimationControllerCompat, i);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.getAuthRequestContext.MyBillsEntityDataFactory(windowInsetsAnimationController == null ? null : this.PlaceComponentResult);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void getAuthRequestContext(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i) {
            if (this.MyBillsEntityDataFactory == windowInsetsController) {
                onControllableInsetsChangedListener.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, i);
            }
        }
    }
}
