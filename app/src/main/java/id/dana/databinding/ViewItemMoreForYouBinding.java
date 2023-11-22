package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.richview.moreforyou.MoreForYouView;

/* loaded from: classes2.dex */
public final class ViewItemMoreForYouBinding implements ViewBinding {
    public final MoreForYouView KClassImpl$Data$declaredNonStaticMembers$2;
    public final MoreForYouView MyBillsEntityDataFactory;

    private ViewItemMoreForYouBinding(MoreForYouView moreForYouView, MoreForYouView moreForYouView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moreForYouView;
        this.MyBillsEntityDataFactory = moreForYouView2;
    }

    public static ViewItemMoreForYouBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_more_for_you, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        MoreForYouView moreForYouView = (MoreForYouView) inflate;
        return new ViewItemMoreForYouBinding(moreForYouView, moreForYouView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
