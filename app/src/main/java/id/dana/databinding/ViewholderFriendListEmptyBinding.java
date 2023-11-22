package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewholderFriendListEmptyBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    private final LinearLayout MyBillsEntityDataFactory;
    public final AppCompatImageView getAuthRequestContext;

    private ViewholderFriendListEmptyBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ViewholderFriendListEmptyBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.iv_empty_relationship;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_empty_relationship);
        if (appCompatImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_subtitle_empty_relationship);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_empty_relationship);
                if (textView2 != null) {
                    return new ViewholderFriendListEmptyBinding((LinearLayout) view, appCompatImageView, textView, textView2);
                }
                i = R.id.tv_title_empty_relationship;
            } else {
                i = R.id.tv_subtitle_empty_relationship;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
