package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.wallet_v3.view.sort.view.WalletSortCategoryView;

/* loaded from: classes4.dex */
public final class BottomSheetSortAssetBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final WalletSortCategoryView moveToNextValue;
    private final FrameLayout scheduleImpl;

    private BottomSheetSortAssetBinding(FrameLayout frameLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, WalletSortCategoryView walletSortCategoryView) {
        this.scheduleImpl = frameLayout;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = appCompatTextView;
        this.moveToNextValue = walletSortCategoryView;
    }

    public static BottomSheetSortAssetBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_apply;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_apply);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_reset);
            if (danaButtonSecondaryView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tab_icon);
                if (appCompatImageView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_sort);
                    if (appCompatTextView != null) {
                        WalletSortCategoryView walletSortCategoryView = (WalletSortCategoryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.wallet_sort_view);
                        if (walletSortCategoryView != null) {
                            return new BottomSheetSortAssetBinding(frameLayout, danaButtonPrimaryView, danaButtonSecondaryView, frameLayout, appCompatImageView, appCompatTextView, walletSortCategoryView);
                        }
                        i = R.id.wallet_sort_view;
                    } else {
                        i = R.id.tv_title_sort;
                    }
                } else {
                    i = R.id.tab_icon;
                }
            } else {
                i = R.id.btn_reset;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
