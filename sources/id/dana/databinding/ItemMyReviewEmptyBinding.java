package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemMyReviewEmptyBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    private final LinearLayout getAuthRequestContext;

    private ItemMyReviewEmptyBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getAuthRequestContext = linearLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout2;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
    }

    public static ItemMyReviewEmptyBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.ivEmptyIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivEmptyIcon);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvEmptySubtitle);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvEmptyTitle);
                if (appCompatTextView2 != null) {
                    return new ItemMyReviewEmptyBinding(linearLayout, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2);
                }
                i = R.id.tvEmptyTitle;
            } else {
                i = R.id.tvEmptySubtitle;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
