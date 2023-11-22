package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemListAvailableServiceMemberFamilyAccountBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ItemListAvailableServiceMemberFamilyAccountBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ItemListAvailableServiceMemberFamilyAccountBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return PlaceComponentResult(layoutInflater.inflate(R.layout.item_list_available_service_member_family_account, viewGroup, false));
    }

    private static ItemListAvailableServiceMemberFamilyAccountBinding PlaceComponentResult(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.imgRightArrow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.imgRightArrow);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconService);
            if (appCompatImageView2 != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNameService);
                if (textView != null) {
                    return new ItemListAvailableServiceMemberFamilyAccountBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatImageView2, textView);
                }
                i = R.id.tvNameService;
            } else {
                i = R.id.ivIconService;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemListAvailableServiceMemberFamilyAccountBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        return PlaceComponentResult(layoutInflater.inflate(R.layout.item_list_available_service_member_family_account, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
