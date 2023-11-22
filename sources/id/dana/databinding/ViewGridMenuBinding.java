package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewGridMenuBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView MyBillsEntityDataFactory;
    private final ConstraintLayout getAuthRequestContext;

    private ViewGridMenuBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ViewGridMenuBinding getAuthRequestContext(View view) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.image);
        if (imageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.title);
            if (textView != null) {
                return new ViewGridMenuBinding((ConstraintLayout) view, imageView, textView);
            }
            i = R.id.title;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
