package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewSearchDefaultBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final EditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView getAuthRequestContext;

    private ViewSearchDefaultBinding(ConstraintLayout constraintLayout, EditText editText, ImageView imageView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editText;
        this.getAuthRequestContext = imageView;
    }

    public static ViewSearchDefaultBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_search_default, (ViewGroup) null, false);
        int i = R.id.i;
        EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (editText != null) {
            i = R.id.iv_clear;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (imageView != null) {
                return new ViewSearchDefaultBinding((ConstraintLayout) inflate, editText, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
