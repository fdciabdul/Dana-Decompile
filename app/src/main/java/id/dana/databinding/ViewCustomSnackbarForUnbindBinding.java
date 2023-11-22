package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCustomSnackbarForUnbindBinding implements ViewBinding {
    public final TextView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;

    private ViewCustomSnackbarForUnbindBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.PlaceComponentResult = linearLayout;
        this.getAuthRequestContext = linearLayout2;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ViewCustomSnackbarForUnbindBinding getAuthRequestContext(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_custom_snackbar_for_unbind);
        if (textView != null) {
            return new ViewCustomSnackbarForUnbindBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_custom_snackbar_for_unbind)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
