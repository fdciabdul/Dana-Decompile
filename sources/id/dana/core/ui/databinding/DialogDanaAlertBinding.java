package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class DialogDanaAlertBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final Button PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView getErrorConfigVersion;

    private DialogDanaAlertBinding(ConstraintLayout constraintLayout, Button button, Button button2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.MyBillsEntityDataFactory = button;
        this.PlaceComponentResult = button2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = textView;
        this.getErrorConfigVersion = textView2;
    }

    public static DialogDanaAlertBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.MyBillsEntityDataFactory, viewGroup, false);
        int i = R.id.BuiltInFictitiousFunctionClassFactory;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (button != null) {
            i = R.id.MyBillsEntityDataFactory;
            Button button2 = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (button2 != null) {
                i = R.id.iv_dialog_image;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.Q;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView != null) {
                        i = R.id.S;
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView2 != null) {
                            return new DialogDanaAlertBinding((ConstraintLayout) inflate, button, button2, appCompatImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
