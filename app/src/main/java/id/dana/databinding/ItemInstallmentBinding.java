package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.cashier.view.InstallmentOptionRadioButton;

/* loaded from: classes4.dex */
public final class ItemInstallmentBinding implements ViewBinding {
    public final InstallmentOptionRadioButton PlaceComponentResult;
    private final InstallmentOptionRadioButton getAuthRequestContext;

    private ItemInstallmentBinding(InstallmentOptionRadioButton installmentOptionRadioButton, InstallmentOptionRadioButton installmentOptionRadioButton2) {
        this.getAuthRequestContext = installmentOptionRadioButton;
        this.PlaceComponentResult = installmentOptionRadioButton2;
    }

    public static ItemInstallmentBinding MyBillsEntityDataFactory(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        InstallmentOptionRadioButton installmentOptionRadioButton = (InstallmentOptionRadioButton) view;
        return new ItemInstallmentBinding(installmentOptionRadioButton, installmentOptionRadioButton);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
