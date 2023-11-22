package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewBottomSheetExpiryTimeBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    private final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final FrameLayout PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;

    private ViewBottomSheetExpiryTimeBinding(CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TextView textView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coordinatorLayout;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ViewBottomSheetExpiryTimeBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_bottom_sheet_expiry_time, (ViewGroup) null, false);
        int i = R.id.clExpiryTime;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clExpiryTime);
        if (constraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view);
            if (frameLayout != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.secondaryHash_res_0x7f0a08d3);
                if (appCompatImageView != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvExpiryTime);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvExpiryTimes);
                        if (textView != null) {
                            return new ViewBottomSheetExpiryTimeBinding((CoordinatorLayout) inflate, constraintLayout, frameLayout, appCompatImageView, recyclerView, textView);
                        }
                        i = R.id.tvExpiryTimes;
                    } else {
                        i = R.id.rvExpiryTime;
                    }
                } else {
                    i = R.id.secondaryHash_res_0x7f0a08d3;
                }
            } else {
                i = R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
