package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewBodyGroupDetailBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final Group MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewBodyGroupDetailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, RecyclerView recyclerView, TextView textView, View view) {
        this.moveToNextValue = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = group;
        this.PlaceComponentResult = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public static ViewBodyGroupDetailBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.groupLabelMaxMembers;
        Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (group != null) {
            i = R.id.rvGridListMembers;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (recyclerView != null) {
                i = R.id.res_0x7f0a13ba_imagecaptureviewmodel_gettipuploadphoto_1;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.clearName))) != null) {
                    return new ViewBodyGroupDetailBinding(constraintLayout, constraintLayout, group, recyclerView, textView, BuiltInFictitiousFunctionClassFactory);
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
