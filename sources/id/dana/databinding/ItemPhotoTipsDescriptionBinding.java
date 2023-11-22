package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes8.dex */
public final class ItemPhotoTipsDescriptionBinding implements ViewBinding {
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ItemPhotoTipsDescriptionBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
    }

    public static ItemPhotoTipsDescriptionBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_photo_tips_description, viewGroup, false);
        int i = R.id.tv_tips_bullet;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_tips_bullet);
        if (appCompatTextView != null) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_tips_description);
            if (appCompatTextView2 != null) {
                return new ItemPhotoTipsDescriptionBinding((ConstraintLayout) inflate, appCompatTextView, appCompatTextView2);
            }
            i = R.id.tv_tips_description;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
