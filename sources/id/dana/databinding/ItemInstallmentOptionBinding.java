package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemInstallmentOptionBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView MyBillsEntityDataFactory;
    private final LinearLayoutCompat getAuthRequestContext;

    private ItemInstallmentOptionBinding(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getAuthRequestContext = linearLayoutCompat;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
    }

    public static ItemInstallmentOptionBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.item_installment_option, (ViewGroup) null, false);
        int i = R.id.tv_installment_amount;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_installment_amount);
        if (appCompatTextView != null) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_installment_period);
            if (appCompatTextView2 != null) {
                return new ItemInstallmentOptionBinding((LinearLayoutCompat) inflate, appCompatTextView, appCompatTextView2);
            }
            i = R.id.tv_installment_period;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
