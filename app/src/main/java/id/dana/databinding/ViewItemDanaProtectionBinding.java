package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.animation.danaprotection.DanaProtectionHomeView;

/* loaded from: classes2.dex */
public final class ViewItemDanaProtectionBinding implements ViewBinding {
    public final DanaProtectionHomeView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaProtectionHomeView MyBillsEntityDataFactory;

    private ViewItemDanaProtectionBinding(DanaProtectionHomeView danaProtectionHomeView, DanaProtectionHomeView danaProtectionHomeView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaProtectionHomeView;
        this.MyBillsEntityDataFactory = danaProtectionHomeView2;
    }

    public static ViewItemDanaProtectionBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_dana_protection, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        DanaProtectionHomeView danaProtectionHomeView = (DanaProtectionHomeView) inflate;
        return new ViewItemDanaProtectionBinding(danaProtectionHomeView, danaProtectionHomeView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
