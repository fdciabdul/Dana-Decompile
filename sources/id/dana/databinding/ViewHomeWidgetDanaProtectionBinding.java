package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.richview.HomeWidgetBase;

/* loaded from: classes4.dex */
public final class ViewHomeWidgetDanaProtectionBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final ViewDanaProtectionHomeFailedStateBinding GetContactSyncConfig;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final ViewOldDanaProtectionContentBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final HomeWidgetBase NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final Barrier PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final HomeWidgetBase lookAheadTest;
    public final ViewNewDanaProtectionContentBinding moveToNextValue;
    public final Barrier scheduleImpl;

    private ViewHomeWidgetDanaProtectionBinding(HomeWidgetBase homeWidgetBase, Barrier barrier, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonSecondaryView danaButtonSecondaryView2, AppCompatImageView appCompatImageView, FrameLayout frameLayout, Barrier barrier2, AppCompatTextView appCompatTextView, ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding, ViewOldDanaProtectionContentBinding viewOldDanaProtectionContentBinding, HomeWidgetBase homeWidgetBase2, ViewDanaProtectionHomeFailedStateBinding viewDanaProtectionHomeFailedStateBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = homeWidgetBase;
        this.PlaceComponentResult = barrier;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView2;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.scheduleImpl = barrier2;
        this.getErrorConfigVersion = appCompatTextView;
        this.moveToNextValue = viewNewDanaProtectionContentBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewOldDanaProtectionContentBinding;
        this.lookAheadTest = homeWidgetBase2;
        this.GetContactSyncConfig = viewDanaProtectionHomeFailedStateBinding;
    }

    public static ViewHomeWidgetDanaProtectionBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.bottomBarrier;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.bottomBarrier);
        if (barrier != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dana_protection_main_button);
            if (danaButtonSecondaryView != null) {
                DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dana_protection_old_main_button);
                if (danaButtonSecondaryView2 != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dana_protection_logo);
                    if (appCompatImageView != null) {
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.skeleton_view);
                        if (frameLayout != null) {
                            Barrier barrier2 = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.topBarrier);
                            if (barrier2 != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_protection_desc);
                                if (appCompatTextView != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.v_new_dana_protection);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        ViewNewDanaProtectionContentBinding PlaceComponentResult = ViewNewDanaProtectionContentBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                                        View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.v_old_dana_protection);
                                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                            ViewOldDanaProtectionContentBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewOldDanaProtectionContentBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2);
                                            HomeWidgetBase homeWidgetBase = (HomeWidgetBase) view;
                                            View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_protection_failed);
                                            if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                return new ViewHomeWidgetDanaProtectionBinding(homeWidgetBase, barrier, danaButtonSecondaryView, danaButtonSecondaryView2, appCompatImageView, frameLayout, barrier2, appCompatTextView, PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2, homeWidgetBase, ViewDanaProtectionHomeFailedStateBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3));
                                            }
                                            i = R.id.view_protection_failed;
                                        } else {
                                            i = R.id.v_old_dana_protection;
                                        }
                                    } else {
                                        i = R.id.v_new_dana_protection;
                                    }
                                } else {
                                    i = R.id.tv_dana_protection_desc;
                                }
                            } else {
                                i = R.id.topBarrier;
                            }
                        } else {
                            i = R.id.skeleton_view;
                        }
                    } else {
                        i = R.id.iv_dana_protection_logo;
                    }
                } else {
                    i = R.id.btn_dana_protection_old_main_button;
                }
            } else {
                i = R.id.btn_dana_protection_main_button;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
