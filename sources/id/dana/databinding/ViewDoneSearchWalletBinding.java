package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewDoneSearchWalletBinding implements ViewBinding {
    private final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;

    private ViewDoneSearchWalletBinding(FrameLayout frameLayout, AppCompatTextView appCompatTextView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
    }

    public static ViewDoneSearchWalletBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_close);
        if (appCompatTextView != null) {
            return new ViewDoneSearchWalletBinding((FrameLayout) view, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_close)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
