package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSnackbarInternetConnectionBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout MyBillsEntityDataFactory;
    public final LinearLayout getAuthRequestContext;

    private ViewSnackbarInternetConnectionBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.getAuthRequestContext = linearLayout;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ViewSnackbarInternetConnectionBinding MyBillsEntityDataFactory(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_content);
        if (textView != null) {
            return new ViewSnackbarInternetConnectionBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_content)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
