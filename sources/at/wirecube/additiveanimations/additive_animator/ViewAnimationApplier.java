package at.wirecube.additiveanimations.additive_animator;

import android.view.View;

/* loaded from: classes6.dex */
public class ViewAnimationApplier implements Runnable {
    private final boolean MyBillsEntityDataFactory;
    private final View PlaceComponentResult;

    @Override // java.lang.Runnable
    public void run() {
        if (this.MyBillsEntityDataFactory) {
            this.PlaceComponentResult.requestLayout();
        } else {
            this.PlaceComponentResult.invalidate();
        }
    }
}
