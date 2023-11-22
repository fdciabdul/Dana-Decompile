package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ActivityInvalidLinkBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ActivityInvalidLinkBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ImageView imageView, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2) {
        this.scheduleImpl = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = imageView;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ActivityInvalidLinkBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_invalid_link, (ViewGroup) null, false);
        int i = R.id.f3462btnCta;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3462btnCta);
        if (danaButtonPrimaryView != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivIcon);
            if (imageView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbarInvalidLink);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDesc);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                        if (textView2 != null) {
                            return new ActivityInvalidLinkBinding((ConstraintLayout) inflate, danaButtonPrimaryView, imageView, MyBillsEntityDataFactory, textView, textView2);
                        }
                        i = R.id.tvTitle;
                    } else {
                        i = R.id.tvDesc;
                    }
                } else {
                    i = R.id.toolbarInvalidLink;
                }
            } else {
                i = R.id.ivIcon;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
