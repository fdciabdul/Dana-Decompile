package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class FragmentCardListDetailBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ViewBaseToolbarBinding MyBillsEntityDataFactory;
    public final ViewEmptyCardStateBinding PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;

    private FragmentCardListDetailBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, ViewBaseToolbarBinding viewBaseToolbarBinding, ViewEmptyCardStateBinding viewEmptyCardStateBinding) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.getAuthRequestContext = lottieAnimationView;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.MyBillsEntityDataFactory = viewBaseToolbarBinding;
        this.PlaceComponentResult = viewEmptyCardStateBinding;
    }

    public static FragmentCardListDetailBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_card_list_detail, viewGroup, false);
        int i = R.id.SubSequence;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (lottieAnimationView != null) {
            i = R.id.applyTrimPathIfNeeded_res_0x7f0a1143;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (recyclerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.toolbar_danapoly))) != null) {
                ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                i = R.id.view_empty_card;
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    return new FragmentCardListDetailBinding((ConstraintLayout) inflate, lottieAnimationView, recyclerView, MyBillsEntityDataFactory, ViewEmptyCardStateBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
