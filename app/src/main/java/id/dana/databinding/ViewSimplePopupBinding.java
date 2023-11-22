package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSimplePopupBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final LinearLayout scheduleImpl;

    private ViewSimplePopupBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.scheduleImpl = linearLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.PlaceComponentResult = linearLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ViewSimplePopupBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.ic_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_image);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_image_fg);
            if (appCompatImageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_message);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_dialog);
                    if (textView2 != null) {
                        return new ViewSimplePopupBinding(linearLayout, appCompatImageView, appCompatImageView2, linearLayout, textView, textView2);
                    }
                    i = R.id.tv_title_dialog;
                } else {
                    i = R.id.tv_message;
                }
            } else {
                i = R.id.ic_image_fg;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
