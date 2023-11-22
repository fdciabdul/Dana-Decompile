package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewCommonDialogBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final TextView lookAheadTest;

    private ViewCommonDialogBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.PlaceComponentResult = appCompatImageView2;
        this.getAuthRequestContext = linearLayout2;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.lookAheadTest = textView2;
    }

    public static ViewCommonDialogBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_common_dialog, (ViewGroup) null, false);
        int i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda2;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                i = R.id.N;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    i = R.id.tv_title_dialog;
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView2 != null) {
                        return new ViewCommonDialogBinding(linearLayout, appCompatImageView, appCompatImageView2, linearLayout, textView, textView2);
                    }
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
