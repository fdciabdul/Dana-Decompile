package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class FragmentDeviceLimitErrorBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private FragmentDeviceLimitErrorBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, AppCompatImageView appCompatImageView, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2) {
        this.scheduleImpl = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutToolbarBinding;
        this.PlaceComponentResult = textView;
        this.getAuthRequestContext = textView2;
    }

    public static FragmentDeviceLimitErrorBinding getAuthRequestContext(View view) {
        int i = R.id.PlaceComponentResult_res_0x7f0a01e4;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.PlaceComponentResult_res_0x7f0a01e4);
        if (danaButtonSecondaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_device_limit);
            if (appCompatImageView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.SecurityGuardProfileProvider);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_subtitle);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                        if (textView2 != null) {
                            return new FragmentDeviceLimitErrorBinding((ConstraintLayout) view, danaButtonSecondaryView, appCompatImageView, MyBillsEntityDataFactory, textView, textView2);
                        }
                        i = R.id.tv_title;
                    } else {
                        i = R.id.tv_subtitle;
                    }
                } else {
                    i = R.id.SecurityGuardProfileProvider;
                }
            } else {
                i = R.id.iv_device_limit;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
