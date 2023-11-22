package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cardbinding.view.CardView;
import id.dana.cashier.view.InputCardNumberView;

/* loaded from: classes2.dex */
public final class ViewCardBindingBinding implements ViewBinding {
    public final ViewOneklikBcaBinding BuiltInFictitiousFunctionClassFactory;
    public final CardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final InputCardNumberView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;

    private ViewCardBindingBinding(LinearLayout linearLayout, CardView cardView, InputCardNumberView inputCardNumberView, RecyclerView recyclerView, ViewOneklikBcaBinding viewOneklikBcaBinding) {
        this.PlaceComponentResult = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardView;
        this.MyBillsEntityDataFactory = inputCardNumberView;
        this.getAuthRequestContext = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = viewOneklikBcaBinding;
    }

    public static ViewCardBindingBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.cardView;
        CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cardView);
        if (cardView != null) {
            InputCardNumberView inputCardNumberView = (InputCardNumberView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3826inputCardNumberView);
            if (inputCardNumberView != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4132res_0x7f0a112b_protoserializer_externalsyntheticlambda1);
                if (recyclerView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewOneKlikNotice);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        return new ViewCardBindingBinding((LinearLayout) view, cardView, inputCardNumberView, recyclerView, ViewOneklikBcaBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                    }
                    i = R.id.viewOneKlikNotice;
                } else {
                    i = R.id.f4132res_0x7f0a112b_protoserializer_externalsyntheticlambda1;
                }
            } else {
                i = R.id.f3826inputCardNumberView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
