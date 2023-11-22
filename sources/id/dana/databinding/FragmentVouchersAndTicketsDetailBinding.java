package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;

/* loaded from: classes4.dex */
public final class FragmentVouchersAndTicketsDetailBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LottieAnimationView MyBillsEntityDataFactory;
    public final MotionLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final MotionLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final ViewWalletV3SearchStubBinding NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ConstraintLayout PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final PtrWalletFrameLayout getErrorConfigVersion;
    public final AppCompatImageView lookAheadTest;
    public final RecyclerView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private FragmentVouchersAndTicketsDetailBinding(MotionLayout motionLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatTextView appCompatTextView, LottieAnimationView lottieAnimationView, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, MotionLayout motionLayout2, PtrWalletFrameLayout ptrWalletFrameLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView2, ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = motionLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.MyBillsEntityDataFactory = lottieAnimationView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = constraintLayout;
        this.lookAheadTest = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = motionLayout2;
        this.getErrorConfigVersion = ptrWalletFrameLayout;
        this.moveToNextValue = recyclerView;
        this.scheduleImpl = appCompatImageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = viewWalletV3SearchStubBinding;
    }

    public static FragmentVouchersAndTicketsDetailBinding PlaceComponentResult(View view) {
        int i = R.id.btn_add_asset;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_add_asset);
        if (danaButtonPrimaryView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_cancel);
            if (appCompatTextView != null) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_close);
                if (lottieAnimationView != null) {
                    DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_sort_asset);
                    if (danaButtonSecondaryView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_button_setting_container);
                        if (constraintLayout != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_expired);
                            if (appCompatImageView != null) {
                                MotionLayout motionLayout = (MotionLayout) view;
                                PtrWalletFrameLayout ptrWalletFrameLayout = (PtrWalletFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ptr_card_vouchers_and_tickets);
                                if (ptrWalletFrameLayout != null) {
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_card_vouchers_and_tickets);
                                    if (recyclerView != null) {
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tab_icon);
                                        if (appCompatImageView2 != null) {
                                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.wsv_voucher_ticket);
                                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                                return new FragmentVouchersAndTicketsDetailBinding(motionLayout, danaButtonPrimaryView, appCompatTextView, lottieAnimationView, danaButtonSecondaryView, constraintLayout, appCompatImageView, motionLayout, ptrWalletFrameLayout, recyclerView, appCompatImageView2, ViewWalletV3SearchStubBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory));
                                            }
                                            i = R.id.wsv_voucher_ticket;
                                        } else {
                                            i = R.id.tab_icon;
                                        }
                                    } else {
                                        i = R.id.rv_card_vouchers_and_tickets;
                                    }
                                } else {
                                    i = R.id.ptr_card_vouchers_and_tickets;
                                }
                            } else {
                                i = R.id.ic_expired;
                            }
                        } else {
                            i = R.id.cl_button_setting_container;
                        }
                    } else {
                        i = R.id.btn_sort_asset;
                    }
                } else {
                    i = R.id.btn_close;
                }
            } else {
                i = R.id.btn_cancel;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
