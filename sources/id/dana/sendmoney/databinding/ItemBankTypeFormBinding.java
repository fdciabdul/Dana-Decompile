package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemBankTypeFormBinding implements ViewBinding {
    public final ChipGroup BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final Chip PlaceComponentResult;
    public final Chip getAuthRequestContext;

    private ItemBankTypeFormBinding(ConstraintLayout constraintLayout, Chip chip, Chip chip2, ChipGroup chipGroup, TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.getAuthRequestContext = chip;
        this.PlaceComponentResult = chip2;
        this.BuiltInFictitiousFunctionClassFactory = chipGroup;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ItemBankTypeFormBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d028b_networkuserentitydata_externalsyntheticlambda5, viewGroup, false);
        int i = R.id.moveToNextValue_res_0x7f0a0159;
        Chip chip = (Chip) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (chip != null) {
            i = R.id.res_0x7f0a0176_networkuserentitydata_externalsyntheticlambda1;
            Chip chip2 = (Chip) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (chip2 != null) {
                i = R.id.getCallingPid_res_0x7f0a02fa;
                ChipGroup chipGroup = (ChipGroup) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (chipGroup != null) {
                    i = R.id.setValue;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView != null) {
                        return new ItemBankTypeFormBinding((ConstraintLayout) inflate, chip, chip2, chipGroup, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
