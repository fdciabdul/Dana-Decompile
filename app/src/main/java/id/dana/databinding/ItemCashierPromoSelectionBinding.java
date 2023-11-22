package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemCashierPromoSelectionBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView GetContactSyncConfig;
    public final Guideline KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private ItemCashierPromoSelectionBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Guideline guideline, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = guideline;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
        this.lookAheadTest = appCompatTextView3;
        this.getErrorConfigVersion = appCompatTextView4;
        this.moveToNextValue = appCompatTextView5;
        this.GetContactSyncConfig = appCompatTextView6;
    }

    public static ItemCashierPromoSelectionBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.guideline5;
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.guideline5);
        if (guideline != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.setOnSeeAllClickListener);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3861ivPromoSelected);
                if (appCompatImageView2 != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPromoCashback);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4305tvPromoCashbackAmount);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4306tvPromoDetail);
                            if (appCompatTextView3 != null) {
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4307res_0x7f0a1523_internal_mapadapter_setadapter);
                                if (appCompatTextView4 != null) {
                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPromoValid);
                                    if (appCompatTextView5 != null) {
                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.showShimmeringSkeleton);
                                        if (appCompatTextView6 != null) {
                                            return new ItemCashierPromoSelectionBinding(constraintLayout, constraintLayout, guideline, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
                                        }
                                        i = R.id.showShimmeringSkeleton;
                                    } else {
                                        i = R.id.tvPromoValid;
                                    }
                                } else {
                                    i = R.id.f4307res_0x7f0a1523_internal_mapadapter_setadapter;
                                }
                            } else {
                                i = R.id.f4306tvPromoDetail;
                            }
                        } else {
                            i = R.id.f4305tvPromoCashbackAmount;
                        }
                    } else {
                        i = R.id.tvPromoCashback;
                    }
                } else {
                    i = R.id.f3861ivPromoSelected;
                }
            } else {
                i = R.id.setOnSeeAllClickListener;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
