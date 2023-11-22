package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.richview.CircleImageSelectionView;

/* loaded from: classes4.dex */
public final class ViewManageFamilyBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageSelectionView MyBillsEntityDataFactory;
    private final ConstraintLayout getAuthRequestContext;

    private ViewManageFamilyBinding(ConstraintLayout constraintLayout, CircleImageSelectionView circleImageSelectionView, CircleImageView circleImageView, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = circleImageSelectionView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ViewManageFamilyBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_manage_family, (ViewGroup) null, false);
        int i = R.id.civManageFamilyAvatar;
        CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.civManageFamilyAvatar);
        if (circleImageSelectionView != null) {
            CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivMemberStatusIndicator);
            if (circleImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvManageFamilyName);
                if (textView != null) {
                    return new ViewManageFamilyBinding((ConstraintLayout) inflate, circleImageSelectionView, circleImageView, textView);
                }
                i = R.id.tvManageFamilyName;
            } else {
                i = R.id.ivMemberStatusIndicator;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
