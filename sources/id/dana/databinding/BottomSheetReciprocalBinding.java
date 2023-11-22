package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetReciprocalBinding implements ViewBinding {
    private final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CoordinatorLayout MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;

    private BottomSheetReciprocalBinding(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, FrameLayout frameLayout) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout;
        this.MyBillsEntityDataFactory = coordinatorLayout2;
        this.PlaceComponentResult = frameLayout;
    }

    public static BottomSheetReciprocalBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_reciprocal, (ViewGroup) null, false);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3710cvFriendListContainer);
        if (frameLayout != null) {
            return new BottomSheetReciprocalBinding(coordinatorLayout, coordinatorLayout, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.f3710cvFriendListContainer)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
