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
import id.dana.richview.CircleImageSelectionView;

/* loaded from: classes4.dex */
public final class ItemListManageMemberLimitBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageSelectionView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;

    private ItemListManageMemberLimitBinding(ConstraintLayout constraintLayout, CircleImageSelectionView circleImageSelectionView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = circleImageSelectionView;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ItemListManageMemberLimitBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_list_manage_member_limit, viewGroup, false);
        int i = R.id.cisvMemberPhoto;
        CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cisvMemberPhoto);
        if (circleImageSelectionView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivArrow);
            if (appCompatImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMemberLimit);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMemberName);
                    if (textView2 != null) {
                        return new ItemListManageMemberLimitBinding((ConstraintLayout) inflate, circleImageSelectionView, appCompatImageView, textView, textView2);
                    }
                    i = R.id.tvMemberName;
                } else {
                    i = R.id.tvMemberLimit;
                }
            } else {
                i = R.id.ivArrow;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
