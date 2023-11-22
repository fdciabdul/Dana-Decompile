package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.richview.NewPromoCenterView;

/* loaded from: classes2.dex */
public final class ViewItemPromoCenterWidgetBinding implements ViewBinding {
    public final NewPromoCenterView MyBillsEntityDataFactory;
    public final NewPromoCenterView getAuthRequestContext;

    private ViewItemPromoCenterWidgetBinding(NewPromoCenterView newPromoCenterView, NewPromoCenterView newPromoCenterView2) {
        this.MyBillsEntityDataFactory = newPromoCenterView;
        this.getAuthRequestContext = newPromoCenterView2;
    }

    public static ViewItemPromoCenterWidgetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_promo_center_widget, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        NewPromoCenterView newPromoCenterView = (NewPromoCenterView) inflate;
        return new ViewItemPromoCenterWidgetBinding(newPromoCenterView, newPromoCenterView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
