package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes8.dex */
public final class ViewWalletV3SearchHeaderBinding implements ViewBinding {
    public final FrameLayout MyBillsEntityDataFactory;

    private ViewWalletV3SearchHeaderBinding(FrameLayout frameLayout) {
        this.MyBillsEntityDataFactory = frameLayout;
    }

    public static ViewWalletV3SearchHeaderBinding MyBillsEntityDataFactory(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ViewWalletV3SearchHeaderBinding((FrameLayout) view);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
