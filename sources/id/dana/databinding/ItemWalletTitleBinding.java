package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemWalletTitleBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    private final FrameLayout PlaceComponentResult;

    private ItemWalletTitleBinding(FrameLayout frameLayout, TextView textView) {
        this.PlaceComponentResult = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ItemWalletTitleBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
        if (textView != null) {
            return new ItemWalletTitleBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tvTitle)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
