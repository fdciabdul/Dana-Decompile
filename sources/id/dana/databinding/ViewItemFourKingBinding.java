package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.animation.view.FourKingView;

/* loaded from: classes2.dex */
public final class ViewItemFourKingBinding implements ViewBinding {
    public final FourKingView BuiltInFictitiousFunctionClassFactory;
    public final FourKingView PlaceComponentResult;

    private ViewItemFourKingBinding(FourKingView fourKingView, FourKingView fourKingView2) {
        this.BuiltInFictitiousFunctionClassFactory = fourKingView;
        this.PlaceComponentResult = fourKingView2;
    }

    public static ViewItemFourKingBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_four_king, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        FourKingView fourKingView = (FourKingView) inflate;
        return new ViewItemFourKingBinding(fourKingView, fourKingView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
