package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import id.dana.sendmoney.R;

/* loaded from: classes9.dex */
public final class ItemEmptyViewholderBinding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;

    private ItemEmptyViewholderBinding(ConstraintLayout constraintLayout) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
    }

    public static ItemEmptyViewholderBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_empty_viewholder, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemEmptyViewholderBinding((ConstraintLayout) inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
