package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemCashierAddOnImportantInfoBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final AppCompatTextView getAuthRequestContext;

    private ItemCashierAddOnImportantInfoBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, AppCompatTextView appCompatTextView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = circleImageView;
        this.getAuthRequestContext = appCompatTextView;
    }

    public static ItemCashierAddOnImportantInfoBinding PlaceComponentResult(View view) {
        int i = R.id.ivImportantInfo;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivImportantInfo);
        if (circleImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvImportantInfo);
            if (appCompatTextView != null) {
                return new ItemCashierAddOnImportantInfoBinding((ConstraintLayout) view, circleImageView, appCompatTextView);
            }
            i = R.id.tvImportantInfo;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
