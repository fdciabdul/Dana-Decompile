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
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;

/* loaded from: classes4.dex */
public final class FragmentLoyaltyDetailWalletBinding implements ViewBinding {
    public final LottieAnimationView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final MotionLayout MyBillsEntityDataFactory;
    public final PtrWalletFrameLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    private final MotionLayout lookAheadTest;
    public final RecyclerView moveToNextValue;
    public final ViewWalletV3SearchStubBinding scheduleImpl;

    private FragmentLoyaltyDetailWalletBinding(MotionLayout motionLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatTextView appCompatTextView, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, MotionLayout motionLayout2, PtrWalletFrameLayout ptrWalletFrameLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView, ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding) {
        this.lookAheadTest = motionLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.PlaceComponentResult = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = lottieAnimationView;
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = motionLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ptrWalletFrameLayout;
        this.moveToNextValue = recyclerView;
        this.getErrorConfigVersion = appCompatImageView;
        this.scheduleImpl = viewWalletV3SearchStubBinding;
    }

    public static FragmentLoyaltyDetailWalletBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_add_asset;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_add_asset);
        if (danaButtonPrimaryView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_cancel);
            if (appCompatTextView != null) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_close);
                if (lottieAnimationView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_button_setting_container);
                    if (constraintLayout != null) {
                        MotionLayout motionLayout = (MotionLayout) view;
                        PtrWalletFrameLayout ptrWalletFrameLayout = (PtrWalletFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ptr_card_loyalty);
                        if (ptrWalletFrameLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_card_loyalty);
                            if (recyclerView != null) {
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tab_icon);
                                if (appCompatImageView != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.wsv_loyalty);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        return new FragmentLoyaltyDetailWalletBinding(motionLayout, danaButtonPrimaryView, appCompatTextView, lottieAnimationView, constraintLayout, motionLayout, ptrWalletFrameLayout, recyclerView, appCompatImageView, ViewWalletV3SearchStubBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory));
                                    }
                                    i = R.id.wsv_loyalty;
                                } else {
                                    i = R.id.tab_icon;
                                }
                            } else {
                                i = R.id.rv_card_loyalty;
                            }
                        } else {
                            i = R.id.ptr_card_loyalty;
                        }
                    } else {
                        i = R.id.cl_button_setting_container;
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
        return this.lookAheadTest;
    }
}
