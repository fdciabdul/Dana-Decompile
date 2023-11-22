package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemViewMembersBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final View moveToNextValue;

    private ItemViewMembersBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, CircleImageView circleImageView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = constraintLayout3;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = circleImageView;
        this.lookAheadTest = textView;
        this.getErrorConfigVersion = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.moveToNextValue = view;
    }

    public static ItemViewMembersBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_view_members, viewGroup, false);
        int i = R.id.clInputAmount;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.clMembers;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (constraintLayout2 != null) {
                i = R.id.res_0x7f0a0994_flowablekt_toiterable_1;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.applyTrimPathIfNeeded_res_0x7f0a0a24;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (circleImageView != null) {
                        i = R.id.targetValue;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView != null) {
                            i = R.id.ItemSnapshotList;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (appCompatTextView != null) {
                                i = R.id.tvRecipientNumber;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.clearName))) != null) {
                                    return new ItemViewMembersBinding((ConstraintLayout) inflate, constraintLayout, constraintLayout2, appCompatImageView, circleImageView, textView, appCompatTextView, appCompatTextView2, BuiltInFictitiousFunctionClassFactory);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
