package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import id.dana.danapoly.R;
import id.dana.danapoly.ui.board.view.DanapolyLapCountView;

/* loaded from: classes4.dex */
public final class ActivityDanapolyBoardBinding implements ViewBinding {
    public final Group BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final FragmentContainerView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TabLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final DanapolyLapCountView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;

    private ActivityDanapolyBoardBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, AppCompatImageView appCompatImageView, FragmentContainerView fragmentContainerView, Group group, TabLayout tabLayout, View view, DanapolyLapCountView danapolyLapCountView) {
        this.lookAheadTest = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = fragmentContainerView;
        this.BuiltInFictitiousFunctionClassFactory = group;
        this.PlaceComponentResult = tabLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.getErrorConfigVersion = danapolyLapCountView;
    }

    public static ActivityDanapolyBoardBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.activity_danapoly_board, (ViewGroup) null, false);
        int i = R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a00fd;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (linearLayout != null) {
            i = R.id.btn_dice;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView != null) {
                i = R.id.fragment_container_view;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (fragmentContainerView != null) {
                    i = R.id.group_bottom_tab_menu;
                    Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (group != null) {
                        i = R.id.tab_menu;
                        TabLayout tabLayout = (TabLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (tabLayout != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.SplitReferralConfigEntityData_Factory_res_0x7f0a1b2b))) != null) {
                            i = R.id.getSavingConfigPresenter_res_0x7f0a1aba;
                            DanapolyLapCountView danapolyLapCountView = (DanapolyLapCountView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (danapolyLapCountView != null) {
                                return new ActivityDanapolyBoardBinding((ConstraintLayout) inflate, linearLayout, appCompatImageView, fragmentContainerView, group, tabLayout, BuiltInFictitiousFunctionClassFactory, danapolyLapCountView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
