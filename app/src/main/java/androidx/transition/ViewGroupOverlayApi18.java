package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes3.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.PlaceComponentResult = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void MyBillsEntityDataFactory(Drawable drawable) {
        this.PlaceComponentResult.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void getAuthRequestContext(Drawable drawable) {
        this.PlaceComponentResult.remove(drawable);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void getAuthRequestContext(View view) {
        this.PlaceComponentResult.add(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        this.PlaceComponentResult.remove(view);
    }
}
