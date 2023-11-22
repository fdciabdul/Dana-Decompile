package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes3.dex */
public final class ViewGroupSendMemberAmountBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final View getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewGroupSendMemberAmountBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, View view) {
        this.moveToNextValue = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.MyBillsEntityDataFactory = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.PlaceComponentResult = textView2;
        this.getAuthRequestContext = view;
    }

    public static ViewGroupSendMemberAmountBinding MyBillsEntityDataFactory(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.GetTopUpUserConsult_res_0x7f0a1101;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (recyclerView != null) {
            i = R.id.HttpClientAttributesExtractorBuilder_res_0x7f0a144b;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (textView != null) {
                i = R.id.tvSendToMembers;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.clearName))) != null) {
                    return new ViewGroupSendMemberAmountBinding(constraintLayout, constraintLayout, recyclerView, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
