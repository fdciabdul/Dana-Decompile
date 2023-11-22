package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.core.ui.R;
import id.dana.core.ui.dialog.DanaLogoProgressView;

/* loaded from: classes4.dex */
public final class DialogDanaLoadingBinding implements ViewBinding {
    public final DanaLogoProgressView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaLogoProgressView MyBillsEntityDataFactory;

    private DialogDanaLoadingBinding(DanaLogoProgressView danaLogoProgressView, DanaLogoProgressView danaLogoProgressView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaLogoProgressView;
        this.MyBillsEntityDataFactory = danaLogoProgressView2;
    }

    public static DialogDanaLoadingBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.dialog_dana_loading, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        DanaLogoProgressView danaLogoProgressView = (DanaLogoProgressView) inflate;
        return new DialogDanaLoadingBinding(danaLogoProgressView, danaLogoProgressView);
    }

    public static DialogDanaLoadingBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.dialog_dana_loading, (ViewGroup) null, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        DanaLogoProgressView danaLogoProgressView = (DanaLogoProgressView) inflate;
        return new DialogDanaLoadingBinding(danaLogoProgressView, danaLogoProgressView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
