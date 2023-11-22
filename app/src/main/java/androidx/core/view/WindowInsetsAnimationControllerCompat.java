package androidx.core.view;

import android.view.WindowInsetsAnimationController;

/* loaded from: classes6.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.PlaceComponentResult = new Impl30(windowInsetsAnimationController);
    }

    /* loaded from: classes6.dex */
    static class Impl {
        Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Impl30 extends Impl {
        private final WindowInsetsAnimationController MyBillsEntityDataFactory;

        Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.MyBillsEntityDataFactory = windowInsetsAnimationController;
        }
    }
}
