package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.danapoly.R;
import id.dana.danapoly.ui.board.view.DanapolyBoardView;
import id.dana.danapoly.ui.board.view.DanapolyColorPickerView;
import id.dana.danapoly.ui.board.view.DanapolyPromptInfoView;

/* loaded from: classes4.dex */
public final class FragmentDanapolyBinding implements ViewBinding {
    public final DanapolyBoardView BuiltInFictitiousFunctionClassFactory;
    private final MotionLayout DatabaseTableConfigUtil;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final ViewDanapolyPointInfoBinding NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final FrameLayout PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final ViewBaseToolbarBinding getErrorConfigVersion;
    public final MotionLayout lookAheadTest;
    public final DanapolyColorPickerView moveToNextValue;
    public final DanapolyPromptInfoView scheduleImpl;

    private FragmentDanapolyBinding(MotionLayout motionLayout, AppCompatImageView appCompatImageView, DanapolyBoardView danapolyBoardView, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, MotionLayout motionLayout2, ViewBaseToolbarBinding viewBaseToolbarBinding, DanapolyPromptInfoView danapolyPromptInfoView, DanapolyColorPickerView danapolyColorPickerView, ViewDanapolyPointInfoBinding viewDanapolyPointInfoBinding, View view) {
        this.DatabaseTableConfigUtil = motionLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = danapolyBoardView;
        this.getAuthRequestContext = frameLayout;
        this.PlaceComponentResult = frameLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView3;
        this.lookAheadTest = motionLayout2;
        this.getErrorConfigVersion = viewBaseToolbarBinding;
        this.scheduleImpl = danapolyPromptInfoView;
        this.moveToNextValue = danapolyColorPickerView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = viewDanapolyPointInfoBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view;
    }

    public static FragmentDanapolyBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_danapoly, viewGroup, false);
        int i = R.id.res_0x7f0a00d6_kclassimpl_data_declarednonstaticmembers_2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.res_0x7f0a00ed_networkuserentitydata_externalsyntheticlambda5;
            DanapolyBoardView danapolyBoardView = (DanapolyBoardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danapolyBoardView != null) {
                i = R.id.fl_check_in;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.fl_check_in_notif;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (frameLayout2 != null) {
                        i = R.id.iv_check_in;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.res_0x7f0a0ab3_flowablereduce_reducesubscriber;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (appCompatImageView3 != null) {
                                MotionLayout motionLayout = (MotionLayout) inflate;
                                i = R.id.toolbar_danapoly;
                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                    ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                                    i = R.id.view_danapoly_board_info;
                                    DanapolyPromptInfoView danapolyPromptInfoView = (DanapolyPromptInfoView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (danapolyPromptInfoView != null) {
                                        i = R.id.viewDanapolyColorPicker;
                                        DanapolyColorPickerView danapolyColorPickerView = (DanapolyColorPickerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (danapolyColorPickerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.view_danapoly_point_info))) != null) {
                                            ViewDanapolyPointInfoBinding PlaceComponentResult = ViewDanapolyPointInfoBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                                            i = R.id.view_dummy;
                                            View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                return new FragmentDanapolyBinding(motionLayout, appCompatImageView, danapolyBoardView, frameLayout, frameLayout2, appCompatImageView2, appCompatImageView3, motionLayout, MyBillsEntityDataFactory, danapolyPromptInfoView, danapolyColorPickerView, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory3);
                                            }
                                        }
                                    }
                                }
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
        return this.DatabaseTableConfigUtil;
    }
}
