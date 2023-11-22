package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewGlobalSendDynamicFormBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewGlobalSendDynamicFormBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, View view) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.PlaceComponentResult = recyclerView;
        this.getAuthRequestContext = textView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public static ViewGlobalSendDynamicFormBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0550_summaryvoucherview_externalsyntheticlambda0, (ViewGroup) null, false);
        int i = R.id.ivHeader;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (imageView != null) {
            i = R.id.rvDynamicForm;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (recyclerView != null) {
                i = R.id.getLastClearRequest;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.f5915$r8$lambda$TGidIAE3L8As7QVHBZ6_rXBA0k))) != null) {
                    return new ViewGlobalSendDynamicFormBinding((ConstraintLayout) inflate, imageView, recyclerView, textView, BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
