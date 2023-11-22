package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemSimpleFormOptionBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView getAuthRequestContext;

    private ItemSimpleFormOptionBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, View view) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.getAuthRequestContext = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public static ItemSimpleFormOptionBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_simple_form_option, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.setNewRibbon;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.MatrixEvaluator))) != null) {
            return new ItemSimpleFormOptionBinding(constraintLayout, constraintLayout, textView, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
