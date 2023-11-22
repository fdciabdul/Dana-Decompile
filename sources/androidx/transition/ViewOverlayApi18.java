package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOverlayApi18(View view) {
        this.BuiltInFictitiousFunctionClassFactory = view.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void MyBillsEntityDataFactory(Drawable drawable) {
        this.BuiltInFictitiousFunctionClassFactory.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void getAuthRequestContext(Drawable drawable) {
        this.BuiltInFictitiousFunctionClassFactory.remove(drawable);
    }
}
