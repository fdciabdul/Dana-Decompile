package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewOldDanaProtectionContentBinding implements ViewBinding {
    public final MaterialButton BuiltInFictitiousFunctionClassFactory;
    public final MaterialButton KClassImpl$Data$declaredNonStaticMembers$2;
    public final MaterialButton MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    private final LinearLayout getAuthRequestContext;

    private ViewOldDanaProtectionContentBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, LinearLayout linearLayout2) {
        this.getAuthRequestContext = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = materialButton;
        this.MyBillsEntityDataFactory = materialButton2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = materialButton3;
        this.PlaceComponentResult = linearLayout2;
    }

    public static ViewOldDanaProtectionContentBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_dana_protection_assistance;
        MaterialButton materialButton = (MaterialButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dana_protection_assistance);
        if (materialButton != null) {
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dana_protection_money_back);
            if (materialButton2 != null) {
                MaterialButton materialButton3 = (MaterialButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dana_protection_secure_data);
                if (materialButton3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new ViewOldDanaProtectionContentBinding(linearLayout, materialButton, materialButton2, materialButton3, linearLayout);
                }
                i = R.id.btn_dana_protection_secure_data;
            } else {
                i = R.id.btn_dana_protection_money_back;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
