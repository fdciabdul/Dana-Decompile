package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.common.EmptyStateView;

/* loaded from: classes5.dex */
public final class ItemGroupRecipientContactNoPermissionBinding implements ViewBinding {
    public final EmptyStateView KClassImpl$Data$declaredNonStaticMembers$2;
    private final EmptyStateView MyBillsEntityDataFactory;

    private ItemGroupRecipientContactNoPermissionBinding(EmptyStateView emptyStateView, EmptyStateView emptyStateView2) {
        this.MyBillsEntityDataFactory = emptyStateView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = emptyStateView2;
    }

    public static ItemGroupRecipientContactNoPermissionBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d02d0_bottomsheetcardbindingview_watchercardnumberview_1, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        EmptyStateView emptyStateView = (EmptyStateView) inflate;
        return new ItemGroupRecipientContactNoPermissionBinding(emptyStateView, emptyStateView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
