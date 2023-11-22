package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewSupportedCardsBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ViewSupportedCardsBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
        this.PlaceComponentResult = textView3;
    }

    public static ViewSupportedCardsBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_supported_cards, (ViewGroup) null, false);
        int i = R.id.btnCloseDialogSupportedCards;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnCloseDialogSupportedCards);
        if (danaButtonPrimaryView != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvSupportedCards);
            if (recyclerView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDescBottomSupportedCards);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDescTopSupportedCards);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvHeaderSupportedCards);
                        if (textView3 != null) {
                            return new ViewSupportedCardsBinding((ConstraintLayout) inflate, danaButtonPrimaryView, recyclerView, textView, textView2, textView3);
                        }
                        i = R.id.tvHeaderSupportedCards;
                    } else {
                        i = R.id.tvDescTopSupportedCards;
                    }
                } else {
                    i = R.id.tvDescBottomSupportedCards;
                }
            } else {
                i = R.id.rvSupportedCards;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
