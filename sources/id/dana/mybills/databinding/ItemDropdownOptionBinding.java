package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ItemDropdownOptionBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final ImageView getAuthRequestContext;

    private ItemDropdownOptionBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = imageView;
        this.BuiltInFictitiousFunctionClassFactory = imageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.PlaceComponentResult = textView2;
    }

    public static ItemDropdownOptionBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_dropdown_option, viewGroup, false);
        int i = R.id.ivChecklist;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (imageView != null) {
            i = R.id.ivDropdownOptionIcon;
            ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (imageView2 != null) {
                i = R.id.tvDropdownOptionName;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    i = R.id.tvDropdownOptionValue;
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView2 != null) {
                        return new ItemDropdownOptionBinding((ConstraintLayout) inflate, imageView, imageView2, textView, textView2);
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
