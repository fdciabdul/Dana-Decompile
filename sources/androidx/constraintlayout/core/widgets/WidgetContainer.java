package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> getContainerAuth = new ArrayList<>();

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void whenAvailable() {
        this.getContainerAuth.clear();
        super.whenAvailable();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintWidget constraintWidget) {
        this.getContainerAuth.add(constraintWidget);
        if (constraintWidget.W != null) {
            ((WidgetContainer) constraintWidget.W).getContainerAuth.remove(constraintWidget);
            constraintWidget.whenAvailable();
        }
        constraintWidget.W = this;
    }

    public void BottomSheetCardBindingView$watcherCardNumberView$1() {
        ArrayList<ConstraintWidget> arrayList = this.getContainerAuth;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.getContainerAuth.get(i);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).BottomSheetCardBindingView$watcherCardNumberView$1();
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void PlaceComponentResult(Cache cache) {
        super.PlaceComponentResult(cache);
        int size = this.getContainerAuth.size();
        for (int i = 0; i < size; i++) {
            this.getContainerAuth.get(i).PlaceComponentResult(cache);
        }
    }
}
